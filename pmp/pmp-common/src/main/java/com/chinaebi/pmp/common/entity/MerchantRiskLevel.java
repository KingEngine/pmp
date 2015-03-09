package com.chinaebi.pmp.common.entity;


/**
 * 商户风险级别
 * 
 * @author king
 * 2015年3月9日
 */
public class MerchantRiskLevel {
	
	private String levelCode;//风险级别代码
	
	private String levelDesc;//风险级别说明

	
	public MerchantRiskLevel(String levelCode, String levelDesc) {
		super();
		this.levelCode = levelCode;
		this.levelDesc = levelDesc;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}
}
