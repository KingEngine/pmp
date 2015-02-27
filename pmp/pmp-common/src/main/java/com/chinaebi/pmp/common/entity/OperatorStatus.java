package com.chinaebi.pmp.common.entity;

import java.io.Serializable;

/**
 * 操作员状态
 * 
 * @author king
 * 2015年2月24日
 */
public class OperatorStatus implements Serializable{

	private static final long serialVersionUID = -169239979428589558L;
	
	private String statusCode;//状态码
	
	private String statusDesc;//状态描述
	
	public OperatorStatus(String statusCode, String statusDesc) {
		super();
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
}
