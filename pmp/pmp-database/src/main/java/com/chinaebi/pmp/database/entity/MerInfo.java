package com.chinaebi.pmp.database.entity;

import java.math.BigInteger;

/**
 * 对应表 mer_info
 * 
 * @author king
 *
 */
public class MerInfo implements java.io.Serializable {
	private static final long serialVersionUID = -6688623151363106217L;
	private int mid;/* 对应表中mid */
	private String name;/* 对应表中name */
	private String abbrev;/* 对应表中abbrev */
	private int provId;/* 对应表中prov_id */
	private String beginDate;/* 对应表中begin_date */
	private String expDate;/* 对应表中exp_date */
	private int merType;/* 对应表中mer_type */
	private int posType;/* 对应表中pos_type */
	private int channelId;/* 对应表中channel_id */
	private int termCount;/* 对应表中term_count */
	private int beginFee;/* 对应表中begin_fee */
	private int annualFee;/* 对应表中annual_fee */
	private int cautionMoney;/* 对应表中caution_money */
	private String faxNo;/* 对应表中fax_no */
	private String signagory;/* 对应表中signagory */
	private String corpCode;/* 对应表中corp_code */
	private int codeExpDate;/* 对应表中code_exp_date */
	private String regCode;/* 对应表中reg_code */
	private String address;/* 对应表中address */
	private String zip;/* 对应表中zip */
	private String mdesc;/* 对应表中mdesc */
	private int mstate;/* 对应表中mstate */
	private int openDate;/* 对应表中open_date */
	private int lastUpdate;/* 对应表中last_update */
	private String bankName;/* 对应表中bank_name */
	private String bankAcct;/* 对应表中bank_acct */
	private int bankProvId;/* 对应表中bank_prov_id */
	private String bankBranch;/* 对应表中bank_branch */
	private String bankAcctName;/* 对应表中bank_acct_name */
	private String contact0;/* 对应表中contact0 */
	private String tel0;/* 对应表中tel0 */
	private String cell0;/* 对应表中cell0 */
	private String email0;/* 对应表中email0 */
	private String contact1;/* 对应表中contact1 */
	private String tel1;/* 对应表中tel1 */
	private String cell1;/* 对应表中cell1 */
	private String email1;/* 对应表中email1 */
	private String contact2;/* 对应表中contact2 */
	private String tel2;/* 对应表中tel2 */
	private String cell2;/* 对应表中cell2 */
	private String email2;/* 对应表中email2 */
	private String contact3;/* 对应表中contact3 */
	private String tel3;/* 对应表中tel3 */
	private String cell3;/* 对应表中cell3 */
	private String email3;/* 对应表中email3 */
	private String contact4;/* 对应表中contact4 */
	private String tel4;/* 对应表中tel4 */
	private String cell4;/* 对应表中cell4 */
	private String email4;/* 对应表中email4 */
	private String contact5;/* 对应表中contact5 */
	private String tel5;/* 对应表中tel5 */
	private String cell5;/* 对应表中cell5 */
	private String email5;/* 对应表中email5 */
	private int balance;/* 对应表中balance */
	private long lastBatch;/* 对应表中last_batch */
	private int lastLiqDate;/* 对应表中last_liq_date */
	private int category;/* 对应表中category */
	private int merTradeType;/* 对应表中mer_trade_type */
	private String idType;/* 对应表中id_type */
	private String idNo;/* 对应表中id_no */
	private String corpName;/* 对应表中corp_name */
	private String openBkNo;/* 对应表中open_bk_no */
	private int openTime;/* 对应表中open_time */
	private String regAddress;/* 对应表中reg_address */
	private int regCapital;/* 对应表中reg_capital */
	private String credentialsStartDate;/* 对应表中credentials_start_date */
	private String credentialsEndDate;/* 对应表中credentials_end_date */
	private String operateScope;/* 对应表中operate_scope */
	private String companyTel;/* 对应表中company_tel */
	private String companyWeb;/* 对应表中company_web */
	private int companyType;/* 对应表中company_type */
	private String remark;/* 对应表中remark */
	private String terminalFactory;/* 对应表中terminal_factory */
	private String publicAccount;/* 对应表中public_account */
	private String manufacturersModel;/* 对应表中manufacturers_model */
	private int merProlongation;/* 对应表中mer_prolongation */
	private int merMaintenance;/* 对应表中mer_maintenance */
	private String rejectRemark;/* 对应表中reject_remark */
	private int auditingState;/* 对应表中auditing_state */
	private String termTypeNum;/* 对应表中term_type_num */
	private String createTime;/* 对应表中create_time */
	private String updateTime;/* 对应表中update_time */
	private int identify;/* 对应表中identify */
	private int operId;/* 对应表中oper_id */
	private String updOperName;/* 对应表中upd_oper_name */
	private String settlementBankCode;/* 对应表中settlement_bank_code */
	private String settlementBankName;/* 对应表中settlement_bank_name */
	private String withdrawalFee;/* 对应表中withdrawal_fee */
	private int workflowNode;/* 对应表中workflow_node */
	private String businessLicense;/* 对应表中business_license */
	private String busStartDate;/* 对应表中bus_start_date */
	private String busEndDate;/* 对应表中bus_end_date */
	private int merRiskType;/* 对应表中mer_risk_type */
	private int askType;/* 对应表中ask_type */
	private int askTypeState;/* 对应表中ask_type_state */
	private String merManagerName;/* 对应表中mer_manager_name */
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrev() {
		return abbrev;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	public int getProvId() {
		return provId;
	}
	public void setProvId(int provId) {
		this.provId = provId;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getMerType() {
		return merType;
	}
	public void setMerType(int merType) {
		this.merType = merType;
	}
	public int getPosType() {
		return posType;
	}
	public void setPosType(int posType) {
		this.posType = posType;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getTermCount() {
		return termCount;
	}
	public void setTermCount(int termCount) {
		this.termCount = termCount;
	}
	public int getBeginFee() {
		return beginFee;
	}
	public void setBeginFee(int beginFee) {
		this.beginFee = beginFee;
	}
	public int getAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(int annualFee) {
		this.annualFee = annualFee;
	}
	public int getCautionMoney() {
		return cautionMoney;
	}
	public void setCautionMoney(int cautionMoney) {
		this.cautionMoney = cautionMoney;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getSignagory() {
		return signagory;
	}
	public void setSignagory(String signagory) {
		this.signagory = signagory;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public int getCodeExpDate() {
		return codeExpDate;
	}
	public void setCodeExpDate(int codeExpDate) {
		this.codeExpDate = codeExpDate;
	}
	public String getRegCode() {
		return regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	public int getMstate() {
		return mstate;
	}
	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	public int getOpenDate() {
		return openDate;
	}
	public void setOpenDate(int openDate) {
		this.openDate = openDate;
	}
	public int getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(int lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAcct() {
		return bankAcct;
	}
	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct;
	}
	public int getBankProvId() {
		return bankProvId;
	}
	public void setBankProvId(int bankProvId) {
		this.bankProvId = bankProvId;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankAcctName() {
		return bankAcctName;
	}
	public void setBankAcctName(String bankAcctName) {
		this.bankAcctName = bankAcctName;
	}
	public String getContact0() {
		return contact0;
	}
	public void setContact0(String contact0) {
		this.contact0 = contact0;
	}
	public String getTel0() {
		return tel0;
	}
	public void setTel0(String tel0) {
		this.tel0 = tel0;
	}
	public String getCell0() {
		return cell0;
	}
	public void setCell0(String cell0) {
		this.cell0 = cell0;
	}
	public String getEmail0() {
		return email0;
	}
	public void setEmail0(String email0) {
		this.email0 = email0;
	}
	public String getContact1() {
		return contact1;
	}
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getCell1() {
		return cell1;
	}
	public void setCell1(String cell1) {
		this.cell1 = cell1;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getContact2() {
		return contact2;
	}
	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getCell2() {
		return cell2;
	}
	public void setCell2(String cell2) {
		this.cell2 = cell2;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getContact3() {
		return contact3;
	}
	public void setContact3(String contact3) {
		this.contact3 = contact3;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getCell3() {
		return cell3;
	}
	public void setCell3(String cell3) {
		this.cell3 = cell3;
	}
	public String getEmail3() {
		return email3;
	}
	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	public String getContact4() {
		return contact4;
	}
	public void setContact4(String contact4) {
		this.contact4 = contact4;
	}
	public String getTel4() {
		return tel4;
	}
	public void setTel4(String tel4) {
		this.tel4 = tel4;
	}
	public String getCell4() {
		return cell4;
	}
	public void setCell4(String cell4) {
		this.cell4 = cell4;
	}
	public String getEmail4() {
		return email4;
	}
	public void setEmail4(String email4) {
		this.email4 = email4;
	}
	public String getContact5() {
		return contact5;
	}
	public void setContact5(String contact5) {
		this.contact5 = contact5;
	}
	public String getTel5() {
		return tel5;
	}
	public void setTel5(String tel5) {
		this.tel5 = tel5;
	}
	public String getCell5() {
		return cell5;
	}
	public void setCell5(String cell5) {
		this.cell5 = cell5;
	}
	public String getEmail5() {
		return email5;
	}
	public void setEmail5(String email5) {
		this.email5 = email5;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public long getLastBatch() {
		return lastBatch;
	}
	public void setLastBatch(long lastBatch) {
		this.lastBatch = lastBatch;
	}
	public int getLastLiqDate() {
		return lastLiqDate;
	}
	public void setLastLiqDate(int lastLiqDate) {
		this.lastLiqDate = lastLiqDate;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getMerTradeType() {
		return merTradeType;
	}
	public void setMerTradeType(int merTradeType) {
		this.merTradeType = merTradeType;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getOpenBkNo() {
		return openBkNo;
	}
	public void setOpenBkNo(String openBkNo) {
		this.openBkNo = openBkNo;
	}
	public int getOpenTime() {
		return openTime;
	}
	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}
	public String getRegAddress() {
		return regAddress;
	}
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	public int getRegCapital() {
		return regCapital;
	}
	public void setRegCapital(int regCapital) {
		this.regCapital = regCapital;
	}
	public String getCredentialsStartDate() {
		return credentialsStartDate;
	}
	public void setCredentialsStartDate(String credentialsStartDate) {
		this.credentialsStartDate = credentialsStartDate;
	}
	public String getCredentialsEndDate() {
		return credentialsEndDate;
	}
	public void setCredentialsEndDate(String credentialsEndDate) {
		this.credentialsEndDate = credentialsEndDate;
	}
	public String getOperateScope() {
		return operateScope;
	}
	public void setOperateScope(String operateScope) {
		this.operateScope = operateScope;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getCompanyWeb() {
		return companyWeb;
	}
	public void setCompanyWeb(String companyWeb) {
		this.companyWeb = companyWeb;
	}
	public int getCompanyType() {
		return companyType;
	}
	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTerminalFactory() {
		return terminalFactory;
	}
	public void setTerminalFactory(String terminalFactory) {
		this.terminalFactory = terminalFactory;
	}
	public String getPublicAccount() {
		return publicAccount;
	}
	public void setPublicAccount(String publicAccount) {
		this.publicAccount = publicAccount;
	}
	public String getManufacturersModel() {
		return manufacturersModel;
	}
	public void setManufacturersModel(String manufacturersModel) {
		this.manufacturersModel = manufacturersModel;
	}
	public int getMerProlongation() {
		return merProlongation;
	}
	public void setMerProlongation(int merProlongation) {
		this.merProlongation = merProlongation;
	}
	public int getMerMaintenance() {
		return merMaintenance;
	}
	public void setMerMaintenance(int merMaintenance) {
		this.merMaintenance = merMaintenance;
	}
	public String getRejectRemark() {
		return rejectRemark;
	}
	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}
	public int getAuditingState() {
		return auditingState;
	}
	public void setAuditingState(int auditingState) {
		this.auditingState = auditingState;
	}
	public String getTermTypeNum() {
		return termTypeNum;
	}
	public void setTermTypeNum(String termTypeNum) {
		this.termTypeNum = termTypeNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getIdentify() {
		return identify;
	}
	public void setIdentify(int identify) {
		this.identify = identify;
	}
	public int getOperId() {
		return operId;
	}
	public void setOperId(int operId) {
		this.operId = operId;
	}
	public String getUpdOperName() {
		return updOperName;
	}
	public void setUpdOperName(String updOperName) {
		this.updOperName = updOperName;
	}
	public String getSettlementBankCode() {
		return settlementBankCode;
	}
	public void setSettlementBankCode(String settlementBankCode) {
		this.settlementBankCode = settlementBankCode;
	}
	public String getSettlementBankName() {
		return settlementBankName;
	}
	public void setSettlementBankName(String settlementBankName) {
		this.settlementBankName = settlementBankName;
	}
	public String getWithdrawalFee() {
		return withdrawalFee;
	}
	public void setWithdrawalFee(String withdrawalFee) {
		this.withdrawalFee = withdrawalFee;
	}
	public int getWorkflowNode() {
		return workflowNode;
	}
	public void setWorkflowNode(int workflowNode) {
		this.workflowNode = workflowNode;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getBusStartDate() {
		return busStartDate;
	}
	public void setBusStartDate(String busStartDate) {
		this.busStartDate = busStartDate;
	}
	public String getBusEndDate() {
		return busEndDate;
	}
	public void setBusEndDate(String busEndDate) {
		this.busEndDate = busEndDate;
	}
	public int getMerRiskType() {
		return merRiskType;
	}
	public void setMerRiskType(int merRiskType) {
		this.merRiskType = merRiskType;
	}
	public int getAskType() {
		return askType;
	}
	public void setAskType(int askType) {
		this.askType = askType;
	}
	public int getAskTypeState() {
		return askTypeState;
	}
	public void setAskTypeState(int askTypeState) {
		this.askTypeState = askTypeState;
	}
	public String getMerManagerName() {
		return merManagerName;
	}
	public void setMerManagerName(String merManagerName) {
		this.merManagerName = merManagerName;
	}
}
