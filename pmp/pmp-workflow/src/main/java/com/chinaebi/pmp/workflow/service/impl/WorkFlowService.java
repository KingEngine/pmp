package com.chinaebi.pmp.workflow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 工作流服务类
 * 
 * @author king 2015年3月5日
 */
@Component
public class WorkFlowService {

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

	private RepositoryService repositoryService;
	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	private IdentityService identityService;
	@Autowired
	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
	
	/**
	 * 根据任务id查询任务名称
	 * 
	 * @param taskId
	 * @return
	 */
	public String getTaskNameByTaskId(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		return task.getName();
	}

	/**
	 * 启动流程
	 * 
	 * @param processDefinitionKey
	 *            流程定义的id
	 * @param variables
	 *            能数
	 * @throws Exception
	 */
	protected void startWorkFlow(String processDefinitionKey,
			Map<String, Object> variables) {
		// 将数据保存到mer_info表中
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey(processDefinitionKey, variables);
		if (logger.isInfoEnabled()) {
			logger.info(
					"流程定义[{}]启动成功,流程实例ID为[{}]",
					new Object[] { processDefinitionKey,
							processInstance.getProcessInstanceId() });
		}
	}

	/**
	 * 得到任务坐标
	 * 
	 * @param taskId
	 * @return
	 */
	public Map<String, Object> getCoordinateByTaskId(String taskId) {
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

	/**
	 * 得到运行中的实例
	 * @param userName
	 * @param processDefinitionKey
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<Task> getRunningInstances(String userName,
			String processDefinitionKey, int firstResult, int maxResults) {
		// 得到用户所在的组
		Group group = identityService.createGroupQuery().groupMember(userName)
				.singleResult();
		// 得到任务列表
		List<Task> tasks = taskService.createTaskQuery()
				.processDefinitionKey(processDefinitionKey)
				.taskCandidateGroup(group.getId())
				.listPage(firstResult, maxResults);
		return tasks;
	}

	/**
	 * 得到总数
	 * @param userName
	 * @param processDefinitionKey
	 * @return
	 */
	public int getRunningInstancesTotal(String userName,
			String processDefinitionKey) {
		// 得到用户所在的组
		Group group = identityService.createGroupQuery().groupMember(userName)
				.singleResult();
		int total = 0;
		// 得到总数
		total = taskService.createTaskQuery()
				.processDefinitionKey(processDefinitionKey)
				.taskCandidateGroup(group.getId()).list().size();
		return total;
	}
	/**
	 * 根据流程定义id得到流程定义
	 * 
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinition getProcessDefinitionByProcessDefinitionId(
			String processDefinitionId) {
		return repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
	}
	/**
	 * 得到流程变量
	 * 
	 * @param taskId
	 * @return
	 */
	public Map<String, Object> getVariables(String taskId) {
		return taskService.getVariables(taskId);
	}
}
