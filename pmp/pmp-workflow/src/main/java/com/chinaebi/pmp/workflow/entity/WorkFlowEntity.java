package com.chinaebi.pmp.workflow.entity;

import java.io.Serializable;


/**
 * 运行中的实例
 * 
 * @author king
 * 2015年2月23日
 */
public class WorkFlowEntity implements Serializable{
	
	private static final long serialVersionUID = 3578634075083774214L;

	private String taskId;
	
	private String taskName;
	
	private String processDefinitionName;//流程定义的名称

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getProcessDefinitionName() {
		return processDefinitionName;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		this.processDefinitionName = processDefinitionName;
	}
	
}
