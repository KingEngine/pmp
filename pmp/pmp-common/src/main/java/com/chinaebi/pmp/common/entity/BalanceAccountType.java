package com.chinaebi.pmp.common.entity;

import java.io.Serializable;

/**
 * 结算类型
 * 
 * @author king
 * 2015年2月17日
 */
public class BalanceAccountType implements Serializable{

	private static final long serialVersionUID = -7630441404009572688L;
	
	private String balanceCode;//结算类型
	
	private String balanceCodeDesc;//结算类型说明

	public BalanceAccountType(String balanceCode, String balanceCodeDesc) {
		super();
		this.balanceCode = balanceCode;
		this.balanceCodeDesc = balanceCodeDesc;
	}

	public String getBalanceCode() {
		return balanceCode;
	}

	public void setBalanceCode(String balanceCode) {
		this.balanceCode = balanceCode;
	}

	public String getBalanceCodeDesc() {
		return balanceCodeDesc;
	}

	public void setBalanceCodeDesc(String balanceCodeDesc) {
		this.balanceCodeDesc = balanceCodeDesc;
	}

}
