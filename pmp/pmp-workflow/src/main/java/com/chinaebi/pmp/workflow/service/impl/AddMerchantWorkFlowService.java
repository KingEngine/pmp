package com.chinaebi.pmp.workflow.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.Constants;
import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.dao.IMerInfoDao;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.workflow.entity.MerInfoWorkFlowEntity;
import com.chinaebi.pmp.workflow.entity.WorkFlowEntity;


@Component
public class AddMerchantWorkFlowService {
	
	
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
	/**
	 * 开始商户开通流程
	 * @throws Exception 
	 */
	public void startWorkFlow(MerInfo merInfo) throws Exception{
		//将数据保存到mer_info表中
		int mid = merInfoDao.insert(merInfo);
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("mid",mid);
		runtimeService.startProcessInstanceByKey(Constants.ADDMERCHANT_WORKFLOW_INSTANCE, "1", variables);
		//添加组任务
		//风控
		/*
		identityService.saveGroup(new GroupEntity("RISK_DEPARTMENT"));
		identityService.saveUser(new UserEntity("risk"));
		identityService.createMembership("risk","RISK_DEPARTMENT");
		//运行
		identityService.saveGroup(new GroupEntity("OPERATION_DEPARTMENT"));
		identityService.saveUser(new UserEntity("operation"));
		identityService.createMembership("operation","OPERATION_DEPARTMENT");
		//业管
		identityService.saveGroup(new GroupEntity("BUSINESS_DEAPARTMENT"));
		identityService.saveUser(new UserEntity("business"));
		identityService.createMembership("business","BUSINESS_DEAPARTMENT");*/
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
		merInfoPage = merInfoDao.selectPage(merInfoPage, params);
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
}
