package com.chinaebi.pmp.common.entity;

public class MerchantStatus {
	
	private String statusKey;//状态码
	
	private String statusDesc;//状态说明

	
	public MerchantStatus(String statusKey, String statusDesc) {
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
