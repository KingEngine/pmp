package com.chinaebi.pmp.common.entity;

import java.io.Serializable;

public class TradeStatus implements Serializable{

	private static final long serialVersionUID = -7584949265205013412L;
	
	private Integer statusKey;
	
	private String statusDesc;

	public TradeStatus(Integer statusKey, String statusDesc) {
		super();
		this.statusKey = statusKey;
		this.statusDesc = statusDesc;
	}

	public Integer getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(Integer statusKey) {
		this.statusKey = statusKey;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	
}
