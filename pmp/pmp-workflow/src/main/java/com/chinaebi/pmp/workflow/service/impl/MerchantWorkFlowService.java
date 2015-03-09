package com.chinaebi.pmp.workflow.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.Constants;
import com.chinaebi.pmp.common.entity.CompanyType;
import com.chinaebi.pmp.common.entity.MerchantType;
import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.common.utils.BusinessUtil;
import com.chinaebi.pmp.common.utils.ObjectUtil;
import com.chinaebi.pmp.database.dao.IAskForTermDao;
import com.chinaebi.pmp.database.dao.IMerInfoDao;
import com.chinaebi.pmp.database.dao.IMerPhotoInfoDao;
import com.chinaebi.pmp.database.entity.AskForTerm;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.MerPhotoInfo;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.workflow.entity.MerInfoWorkFlowEntity;
import com.chinaebi.pmp.workflow.entity.WorkFlowEntity;

/**
 * 商户开通工作流任务
 * 
 * @author king
 * 2015年3月4日
 */
@Component
public class MerchantWorkFlowService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private RuntimeService runtimeService;
	@Autowired
	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	private TaskService taskService;
	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	private IdentityService identityService;
	@Autowired
	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
	
	private RepositoryService repositoryService;
	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	@Autowired
	@Qualifier(Annotations.DAO_MERINFO)
	private IMerInfoDao merInfoDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_ASKFORTERM)
	private IAskForTermDao askForTermDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_MERPHOTOINFO)
	private IMerPhotoInfoDao merPhotoInfoDao;
	
	
	private @Value(value = "${merchantAttachmentDir}")String merchantAttachmentDir;//商户资料保存地址
	/**
	 * 开始商户开通流程
	 * @throws Exception 
	 */
	public void startWorkFlow(MerInfo merInfo, String askForTermJson,MultipartFile merchantAttachment)
			throws Exception {
		// 将数据保存到mer_info表中
		int mid = saveMerInfoAndAskForTerm(merInfo, askForTermJson,merchantAttachment);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("mid", mid);
		runtimeService.startProcessInstanceByKey(Constants.ADDMERCHANT_WORKFLOW_INSTANCE, "1", variables);
	}
	private int saveMerInfoAndAskForTerm(MerInfo merInfo, String askForTermJson,MultipartFile merchantAttachment) throws BusinessException {
		int mid = 0;
		try {
			merInfo.setLastBatch(0L);// 最后批次号 //TODO
			merInfo.setLastLiqDate(0);// 最后一次清算日期//TODO
			mid = merInfoDao.insert(merInfo);
			// 保存终端信息
			List<AskForTerm> askForTermList = generateListFromJson(askForTermJson);
			if (null != askForTermList && !askForTermList.isEmpty()) {
				// 生成批次号
				String batch = BusinessUtil.getTermBatchId(mid);
				for (AskForTerm term : askForTermList) {
					term.setMid(mid);
					term.setChannelId(merInfo.getChannelId());
					term.setBatch(batch);
					askForTermDao.insert(term);
				}
			}
			String[] fileNameWithSeparator = merchantAttachment.getOriginalFilename().split("/");
			String fileName = fileNameWithSeparator[fileNameWithSeparator.length-1];
			String filePath=merchantAttachmentDir+File.separator+fileName;
			//保存资料地址
			MerPhotoInfo merPhotoInfo = new MerPhotoInfo();
			merPhotoInfo.setMid(mid);
			//存储相对路径
			merPhotoInfo.setPhotoUrl(fileName);
			merPhotoInfoDao.insert(merPhotoInfo);
			//保存商户资料
			FileUtils.copyInputStreamToFile(merchantAttachment.getInputStream(),new File(filePath));
		} catch (DaoException e) {
			throw new BusinessException("");
		} catch (IOException e) {
			if(logger.isErrorEnabled()){
				logger.error("商户资料上传失败",e);
			}
			throw new BusinessException("");
		}
		return mid;
	}
	private  List<AskForTerm> generateListFromJson(String json){
		JSONArray jsonList = JSONArray.fromObject(json);
		List<AskForTerm> list = new ArrayList<AskForTerm>();
		for (int i = 0; i < jsonList.size(); i++) {
			JSONObject object = (JSONObject) jsonList.get(i);
			AskForTerm result = (AskForTerm) JSONObject.toBean(object,AskForTerm.class);
			if(null!=result){
				list.add(result);
			}
		}
		return list;
	}
	
	/**
	 * 运行中的流程
	 * @param page
	 * @return
	 */
	public Page<WorkFlowEntity> queryRunningInstancesForPage(Page<WorkFlowEntity> page,String getName) {
		List<Group> groups = identityService.createGroupQuery().groupMember(getName)
				.list();
		List<WorkFlowEntity> results = new ArrayList<WorkFlowEntity>();
		int total = 0;
		if (null != groups && groups.size() > 0) {
			//分页查询
			List<Task> tasks = taskService
					.createTaskQuery()
					.taskCandidateGroup(groups.get(0).getId())
					.listPage((page.getPageNo() - 1) * page.getPageSize(),
							page.getPageSize());
			total = taskService
					.createTaskQuery()
					.taskCandidateGroup(groups.get(0).getId()).list().size();
			for (Task task : tasks) {
				WorkFlowEntity entity = new WorkFlowEntity();
				ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
				entity.setTaskId(task.getId());
				entity.setTaskName(task.getName());
				entity.setProcessDefinitionName(definition.getName());
				results.add(entity);
			}
			page.setRows(results);
		}
		page.setTotal(total);
		return page;
	}
	public InputStream queryProcessDefinitionByTaskId(String taskId){
		Task task  = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processDefinitionId = task.getProcessDefinitionId();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
		InputStream resourceAsStream = null;
        resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());
		return resourceAsStream;
	}
	/**
	 * 查询任务坐标
	 * @param taskId
	 * @return
	 */
	public Map<String, Object> findCoordinateByTaskId(String taskId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		// 获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		// 流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()// 创建流程实例查询
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		// 获取当前活动的ID
		String activityId = pi.getActivityId();
		// 获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity
				.findActivity(activityId);// 活动ID
		// 获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}
	public Page<MerInfoWorkFlowEntity> queryMerInfoForPage(Page<MerInfoWorkFlowEntity> page,Map<String,Object> params){
		//查询商户分页信息
		Page<Map<String,Object>> merInfoPage =  new Page<Map<String,Object>>();
		merInfoPage.setPageNo(page.getPageNo());
		merInfoPage.setPageSize(page.getPageSize());
		try {
			merInfoPage = merInfoDao.selectPage(merInfoPage, params);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		List<Map<String,Object>> list = merInfoPage.getRows();
		List<MerInfoWorkFlowEntity> entitys = new ArrayList<MerInfoWorkFlowEntity>();
		//得到运行中的实例
		for(Map<String,Object> o:list){
			MerInfoWorkFlowEntity entity = new MerInfoWorkFlowEntity();
			Integer mid = (Integer) o.get("mid");
			//根据mid查询当前的结点
			List<Task> tasks = taskService
					.createTaskQuery()
					.processDefinitionKey(
							Constants.ADDMERCHANT_WORKFLOW_INSTANCE)
					.processVariableValueEquals("mid", mid).list();
			if(null!=tasks && tasks.size()>0){
				Task task = tasks.get(0);
				entity.setTaskName(task.getName());
				entity.setTaskId(task.getName());
			}
			entity.setMerInfos(o);
			entitys.add(entity);
		}
		page.setRows(entitys);
		page.setTotal(merInfoPage.getTotal());
		return page;
	}
	public String getTaskNameByTaskId(String taskId){
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		Integer mid = (Integer) taskService.getVariable(taskId, "mid");
		return task.getName();
	}
	//完成任务
	public Response completeTask(String taskId,String suggestion){
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.put("suggestion", suggestion);
		try {
			taskService.complete(taskId, variables);
		} catch (ActivitiObjectNotFoundException e) {
			return new Response("01","任务"+taskId+"不存在!");
		}
		return new Response("00","任务处理成功");
	}
	
	public Page<Map<String, Object>> queryMerInfoWithFlowForPage(
			Page<Map<String, Object>> page, Map<String, Object> params) {
		Page<Map<String, Object>> merInfoPage = new Page<Map<String, Object>>();
		merInfoPage.setPageNo(page.getPageNo());
		merInfoPage.setPageSize(page.getPageSize());
		try {
			merInfoPage = merInfoDao.selectPage(merInfoPage, params);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		List<Map<String, Object>> merInfoList = merInfoPage.getRows();
		if(null!=merInfoList && merInfoList.size()>0){
			// 得到运行中的实例
			for (Map<String, Object> o : merInfoList) {
				Integer mid = (Integer) o.get("mid");
				//查询当前任务
				List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constants.ADDMERCHANT_WORKFLOW_INSTANCE).processVariableValueEquals("mid", mid).list();
				if (null != tasks && tasks.size() > 0) {
					String taskNames = "";
					String processDefinitionNames="";
					for(Task task:tasks){
						taskNames+=(task.getName()+"|");
						//得到流程定义名称
						ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
						processDefinitionNames+=(definition.getName()+"|");
					}
					o.put("taskNames", taskNames);
					o.put("processDefinitionNames", processDefinitionNames);
				}
			}
		}
		return merInfoPage;
	}
	
	public Map<String,Object> getMerInfoFromTaskId(String taskId) throws BusinessException{
		Integer mid = (Integer) taskService.getVariable(taskId, "mid");
		MerInfo merInfo = new MerInfo();
		merInfo.setMid(mid);
		try {
			MerInfo returnValue =  merInfoDao.selectOne(merInfo);
			Map<String,Object> map = ObjectUtil.beanToMap(returnValue);
			//商户类别
			Integer merType = (Integer) map.get("merType");
			if(null!=merType){
				List<MerchantType> merTypes = Constants.MERCHANT_TYPE;
				for(MerchantType o:merTypes){
					if(StringUtils.equals(o.getTypeCode(),merType+"")){
						map.put("merTypeDesc",o.getTypeDesc());
						break;
					}
				}
			}
			//公司类型
			Integer companyType = (Integer) map.get("companyType");
			if(null!=merType){
				List<CompanyType> companyTypes = Constants.COMPANY_TYPE;
				for(CompanyType o:companyTypes){
					if(StringUtils.equals(o.getTypeCode(),companyType+"")){
						map.put("companyTypeDesc",o.getTypeDesc());
						break;
					}
				}
			}
			//加载终端信息
			AskForTerm askForTermParam = new AskForTerm();
			askForTermParam.setMid(mid);
			List<AskForTerm> terms = askForTermDao.selectList(askForTermParam);
			List<Map<String,Object>> termList = new ArrayList<Map<String,Object>>();
			for(AskForTerm o:terms){
				Map<String,Object> termMap = ObjectUtil.beanToMap(o);
				termList.add(termMap);
			}
			map.put("termList",termList);
			//查询附件上传地址
			MerPhotoInfo merPhotoInfoParam = new MerPhotoInfo();
			merPhotoInfoParam.setMid(mid);
			List<MerPhotoInfo> merPhotoInfoList = merPhotoInfoDao.selectList(merPhotoInfoParam);
			map.put("merPhotoInfoList", merPhotoInfoList);
			return map;
		} catch (DaoException e) {
			throw new BusinessException("");
		}
	}
}
