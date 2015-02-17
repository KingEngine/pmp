package com.chinaebi.pmp.common.entity;

import java.io.Serializable;

/**
 * 交易状态
 * 
 * @author king
 * 2015年2月16日
 */
public class TradeStatus implements Serializable{

	private static final long serialVersionUID = -7584949265205013412L;
	
	private String statusKey;
	
	private String statusDesc;

	public TradeStatus(String statusKey, String statusDesc) {
		super();
		this.statusKey = statusKey;
		this.statusDesc = statusDesc;
	}

	public String getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	
}
