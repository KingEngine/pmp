package com.chinaebi.pmp.common.entity;


/**
 * 工作流任务类型
 * 
 * @author king
 * 2015年3月6日
 */
public class WorkFlowTaskType {
	
	private String typeCode;//任务类型编码
	
	private String typeDesc;//任务类型说明
	
	public WorkFlowTaskType(String typeCode, String typeDesc) {
		super();
		this.typeCode = typeCode;
		this.typeDesc = typeDesc;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
}
