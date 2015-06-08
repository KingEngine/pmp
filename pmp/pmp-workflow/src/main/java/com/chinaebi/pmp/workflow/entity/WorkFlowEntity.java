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
	
	private String innerMercode;//电银商户号
	
	private String merchantName;//商户名称
	
	private int merType;//商户类型
	
	private String createTime;//商户创建时间
	
	private int termNum;//终端数量
	
	private int merchantState;//商户状态

	private String taskId;
	
	private String taskName;
	
	private String processDefinitionName;//流程定义的名称

	public String getInnerMercode() {
		return innerMercode;
	}

	public void setInnerMercode(String innerMercode) {
		this.innerMercode = innerMercode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public int getMerType() {
		return merType;
	}

	public void setMerType(int merType) {
		this.merType = merType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

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

	public int getTermNum() {
		return termNum;
	}

	public void setTermNum(int termNum) {
		this.termNum = termNum;
	}

	public int getMerchantState() {
		return merchantState;
	}

	public void setMerchantState(int merchantState) {
		this.merchantState = merchantState;
	}

}
