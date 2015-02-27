package com.chinaebi.pmp.common.entity;

import java.io.Serializable;


/**
 * 操作员角色类型
 * 
 * @author king
 * 2015年2月24日
 */
public class OperatorRoleType implements Serializable{
	
	private static final long serialVersionUID = 3411729966163463966L;

	private String roleTypeCode;//类型码
	
	private String roleTypeDesc;//类型描述

	public OperatorRoleType(String roleTypeCode, String roleTypeDesc) {
		super();
		this.roleTypeCode = roleTypeCode;
		this.roleTypeDesc = roleTypeDesc;
	}

	public String getRoleTypeCode() {
		return roleTypeCode;
	}

	public void setRoleTypeCode(String roleTypeCode) {
		this.roleTypeCode = roleTypeCode;
	}

	public String getRoleTypeDesc() {
		return roleTypeDesc;
	}

	public void setRoleTypeDesc(String roleTypeDesc) {
		this.roleTypeDesc = roleTypeDesc;
	}
}
