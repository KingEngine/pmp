package com.chinaebi.pmp.common.entity;

import java.io.Serializable;


 /**
  * 终端方式
  * @author king
  * 2015年3月3日
  */
public class TerminalMode implements Serializable{

	private static final long serialVersionUID = -711497838355072308L;
	
	private String modeCode;//终端方式码
	
	private String modeDesc;//方式说明
	
	public TerminalMode(String modeCode, String modeDesc) {
		super();
		this.modeCode = modeCode;
		this.modeDesc = modeDesc;
	}

	public String getModeCode() {
		return modeCode;
	}

	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	}

	public String getModeDesc() {
		return modeDesc;
	}

	public void setModeDesc(String modeDesc) {
		this.modeDesc = modeDesc;
	}
}
