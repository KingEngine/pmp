package com.chinaebi.pmp.common.entity;

import java.io.Serializable;


/**
 * controller 回复给页面的说明
 * 
 * @author king
 * 2015年2月17日
 */
public class Response implements Serializable{

	private static final long serialVersionUID = 5040387005525829152L;
	
	private String respCode ;//应答码
	
	private String respCodeDesc;//应答说明

	public Response(String respCode, String respCodeDesc) {
		super();
		this.respCode = respCode;
		this.respCodeDesc = respCodeDesc;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespCodeDesc() {
		return respCodeDesc;
	}

	public void setRespCodeDesc(String respCodeDesc) {
		this.respCodeDesc = respCodeDesc;
	}
}
