package com.chinaebi.pmp.common.entity;

import java.io.Serializable;


/**
 * 终端类型
 * 
 * @author king
 * 2015年3月3日
 */
public class TerminalType implements Serializable{
	
	private static final long serialVersionUID = -4344172722922381460L;

	private String typeCode;//终端类型码
	
	private String typeDesc;//终端类型说明

	public TerminalType(String typeCode, String typeDesc) {
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
