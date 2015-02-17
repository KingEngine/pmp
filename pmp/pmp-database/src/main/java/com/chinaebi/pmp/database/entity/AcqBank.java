package com.chinaebi.pmp.database.entity;

import java.util.Date;

/**
 * 对应表 acq_bank
 * 
 * @author king
 *
 */
public class AcqBank implements java.io.Serializable {
	private static final long serialVersionUID = -1010399738360357184L;
	private int acqBankId;/* 对应表中acq_bank_id */
	private String acpBankName;/* 对应表中acp_bank_name */
	private String remark;/* 对应表中remark */
	private Date createTime;/* 对应表中create_time */
	private int xpeSystemNum;/* 对应表中xpe_system_num */
	private String institutionCode;/* 对应表中institution_code */
	private int status;/* 对应表中status */

	public int getAcqBankId() {
		return acqBankId;
	}

	public void setAcqBankId(int acqBankId) {
		this.acqBankId = acqBankId;
	}

	public String getAcpBankName() {
		return acpBankName;
	}

	public void setAcpBankName(String acpBankName) {
		this.acpBankName = acpBankName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getXpeSystemNum() {
		return xpeSystemNum;
	}

	public void setXpeSystemNum(int xpeSystemNum) {
		this.xpeSystemNum = xpeSystemNum;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
