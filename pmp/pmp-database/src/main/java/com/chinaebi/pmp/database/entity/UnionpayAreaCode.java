package com.chinaebi.pmp.database.entity;

/**
 * 对应表 unionpay_area_code
 * 
 * @author king
 *
 */
public class UnionpayAreaCode implements java.io.Serializable {
	private static final long serialVersionUID = 4411320006669358996L;
	private int areaCode;/* 对应表中area_code */
	private int parentAreaCode;/* 对应表中parent_area_code */
	private String areaName;/* 对应表中area_name */

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getParentAreaCode() {
		return parentAreaCode;
	}

	public void setParentAreaCode(int parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
