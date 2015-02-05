/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.entity;

import java.io.Serializable;

/**
 * 登陆操作员信息
 * 
 * @author king
 * 2014-10-14
 */
public class LoginUser implements Serializable{
	
	private static final long serialVersionUID = 6558173975366456425L;
	private Integer mid;
	private Integer operId;
	private String operName;
	private Integer state;
	private String logined;
	private Integer mtype;
	private Integer expDate;
	private String abbrev;
	private String auth;
	private Integer role;
	private Integer operState;
	private String md5Pwd;
	
	private Integer errCount;
	private Integer lastUpdat;
	private Long errTime;
	private String innerMercode;
	
	
	public Long getErrTime() {
		return errTime;
	}

	public void setErrTime(Long errTime) {
		this.errTime = errTime;
	}

	public Integer getErrCount() {
		return errCount;
	}

	public void setErrCount(Integer errCount) {
		this.errCount = errCount;
	}

	public Integer getLastUpdat() {
		return lastUpdat;
	}

	public void setLastUpdat(Integer lastUpdat) {
		this.lastUpdat = lastUpdat;
	}



	public String getMd5Pwd() {
		return md5Pwd;
	}

	public void setMd5Pwd(String md5Pwd) {
		this.md5Pwd = md5Pwd;
	}

	public Integer getOperState() {
		return operState;
	}

	public void setOperState(Integer operState) {
		this.operState = operState;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public LoginUser() {
		super();
	}
	
	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getLogined() {
		return logined;
	}
	public void setLogined(String logined) {
		this.logined = logined;
	}
	public Integer getMtype() {
		return mtype;
	}
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
	public Integer getExpDate() {
		return expDate;
	}
	public void setExpDate(Integer expDate) {
		this.expDate = expDate;
	}	
	public String getInnerMercode() {
		return innerMercode;
	}
	public void setInnerMercode(String innerMercode) {
		this.innerMercode = innerMercode;
	}
}
