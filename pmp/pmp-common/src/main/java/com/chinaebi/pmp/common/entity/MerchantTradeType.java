package com.chinaebi.pmp.common.entity;

/**
 * 商户所属行业类型
 * 
 * @author king
 * 2015年2月17日
 */
public class MerchantTradeType {
	
	private String tradeCode; //行业代码
	
	private String tradeCodeDesc;//行业代码描述

	public MerchantTradeType(String tradeCode, String tradeCodeDesc) {
		super();
		this.tradeCode = tradeCode;
		this.tradeCodeDesc = tradeCodeDesc;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeCodeDesc() {
		return tradeCodeDesc;
	}

	public void setTradeCodeDesc(String tradeCodeDesc) {
		this.tradeCodeDesc = tradeCodeDesc;
	}
}
