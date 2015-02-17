package com.chinaebi.pmp.common.entity;

import java.io.Serializable;


/**
 * 商户状态类型
 * 
 * @author king
 * 2015年2月16日
 */
public class MerchantType implements Serializable{

	private static final long serialVersionUID = -5378069503948753937L;

	private String typeCode;
	
	private String typeDesc;

	public MerchantType(String typeCode, String typeDesc) {
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
