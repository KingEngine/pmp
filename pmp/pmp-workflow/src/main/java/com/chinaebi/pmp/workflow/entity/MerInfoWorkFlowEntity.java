package com.chinaebi.pmp.workflow.entity;

import java.io.Serializable;
import java.util.Map;

public class MerInfoWorkFlowEntity implements Serializable {
	
	private static final long serialVersionUID = 6223742898180811678L;
	
	private String taskId;//任务id

	private String taskName;//结点名称
	
	private Integer mid;//商户主键
	
	private String innerMerCode;//内部商户号
	
	private Integer merType;//商户类型
	
	private String name;//商户名称
	
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

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getInnerMerCode() {
		return innerMerCode;
	}

	public void setInnerMerCode(String innerMerCode) {
		this.innerMerCode = innerMerCode;
	}

	public Integer getMerType() {
		return merType;
	}

	public void setMerType(Integer merType) {
		this.merType = merType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//设置属性值
	public void setMerInfos(Map<String, Object> merInfos) {
		this.innerMerCode=(String) merInfos.get("");
		this.mid=(Integer) merInfos.get("mid");
		this.merType=(Integer) merInfos.get("mer_type");
		this.name=(String) merInfos.get("name");
	}
}
