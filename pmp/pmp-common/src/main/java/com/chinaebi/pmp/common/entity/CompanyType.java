package com.chinaebi.pmp.common.entity;

import java.io.Serializable;


/**
 * 公司类型
 * 
 * @author king
 * 2015年2月16日
 */
public class CompanyType implements Serializable {

	private static final long serialVersionUID = -8883069539703982919L;

	private String typeCode;

	private String typeDesc;

	public CompanyType(String typeCode, String typeDesc) {
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
