package com.chinaebi.pmp.common.entity;

import java.io.Serializable;

/**
 * 证件类型
 * 
 * @author king
 * 2015年2月17日
 */
public class CertificateType implements Serializable{

	private static final long serialVersionUID = -9223152248091275653L;

	private String typeCode;

	private String typeDesc;

	public CertificateType(String typeCode, String typeDesc) {
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
