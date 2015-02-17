package com.chinaebi.pmp.database.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * 对应表 tlog
 * 
 * @author king
 *
 */
public class Tlog implements java.io.Serializable {

	private static final long serialVersionUID = -7843658243113654221L;
	private BigInteger id;/* 对应表中id */
	private String tseq;/* 对应表中tseq */
	private int version;/* 对应表中version */
	private int ip;/* 对应表中ip */
	private int mdate;/* 对应表中mdate */
	private int mid;/* 对应表中mid */
	private String bid;/* 对应表中bid */
	private String oid;/* 对应表中oid */
	private BigInteger amount;/* 对应表中amount */
	private int type;/* 对应表中type */
	private int gate;/* 对应表中gate */
	private int sysDate;/* 对应表中sys_date */
	private int initSysDate;/* 对应表中init_sys_date */
	private int sysTime;/* 对应表中sys_time */
	private BigInteger batch;/* 对应表中batch */
	private int feeAmt;/* 对应表中fee_amt */
	private int bankFee;/* 对应表中bank_fee */
	private int tstat;/* 对应表中tstat */
	private int bkFlag;/* 对应表中bk_flag */
	private BigInteger orgSeq;/* 对应表中org_seq */
	private BigInteger refSeq;/* 对应表中ref_seq */
	private int refundAmt;/* 对应表中refund_amt */
	private String merPriv;/* 对应表中mer_priv */
	private int bkSend;/* 对应表中bk_send */
	private int bkRecv;/* 对应表中bk_recv */
	private String bkUrl;/* 对应表中bk_url */
	private String fgUrl;/* 对应表中fg_url */
	private int bkChk;/* 对应表中bk_chk */
	private int bkDate;/* 对应表中bk_date */
	private String bkSeq1;/* 对应表中bk_seq1 */
	private String bkSeq2;/* 对应表中bk_seq2 */
	private String bkResp;/* 对应表中bk_resp */
	private String mobileNo;/* 对应表中mobile_no */
	private int transPeriod;/* 对应表中trans_period */
	private String cardNo;/* 对应表中card_no */
	private String errorCode;/* 对应表中error_code */
	private int authorType;/* 对应表中author_type */
	private String phoneNo;/* 对应表中phone_no */
	private int operId;/* 对应表中oper_id */
	private int gid;/* 对应表中gid */
	private int preAmt;/* 对应表中pre_amt */
	private int preAmt1;/* 对应表中pre_amt1 */
	private String bkFeeModel;/* 对应表中bk_fee_model */
	private String terminalNumber;/* 对应表中terminal_number */
	private String xpepMercode;/* 对应表中xpep_mercode */
	private String xpepTermid;/* 对应表中xpep_termid */
	private String xpepTrancode;/* 对应表中xpep_trancode */
	private String xpepTrace;/* 对应表中xpep_trace */
	private BigInteger xpepTradeDatetime;/* 对应表中xpep_trade_datetime */
	private String xpepOutcard;/* 对应表中xpep_outcard */
	private String xpepTradeResp;/* 对应表中xpep_trade_resp */
	private int xpeTradetype;/* 对应表中xpe_tradetype */
	private String xpeDeductMercode;/* 对应表中xpe_deduct_mercode */
	private String xpeDeductTermid;/* 对应表中xpe_deduct_termid */
	private String xpeDeductTrace;/* 对应表中xpe_deduct_trace */
	private int xpeDeductInsid;/* 对应表中xpe_deduct_insid */
	private String xpeDeductResp;/* 对应表中xpe_deduct_resp */
	private String xpeDeductRefer;/* 对应表中xpe_deduct_refer */
	private String xpeDeductAuthcode;/* 对应表中xpe_deduct_authcode */
	private int xpeDeductRollbkFlag;/* 对应表中xpe_deduct_rollbk_flag */
	private String xpeDeductRollbkReason;/* 对应表中xpe_deduct_rollbk_reason */
	private String xpeDeductRollbkStance;/* 对应表中xpe_deduct_rollbk_stance */
	private String xpeDeductRollbkResp;/* 对应表中xpe_deduct_rollbk_resp */
	private String xpeDeductRollBkResponse;/* 对应表中xpe_deduct_roll_bk_response */
	private String xpepTermId;/* 对应表中xpep_term_id */
	private String xpepTermIdm;/* 对应表中xpep_term_idm */
	private String xpepIntcdNo;/* 对应表中xpep_intcd_no */
	private Date xpepDeductSysTime;/* 对应表中xpep_deduct_sys_time */
	private Date xpepDeductStlmDate;/* 对应表中xpep_deduct_stlm_date */
	private int xpepTrademsgType;/* 对应表中xpep_trademsg_type */
	private int flag;/* 对应表中flag */
	private String xpepSendcde;/* 对应表中xpep_sendcde */
	private String xpepTradeCardType;/* 对应表中xpep_trade_card_type */
	private int xpepGainSysId;/* 对应表中xpep_gain_sys_id */
	private String xpepGainSysStance;/* 对应表中xpep_gain_sys_stance */
	private String xpepGainMerCode;/* 对应表中xpep_gain_mer_code */
	private String xpepGainMerTermId;/* 对应表中xpep_gain_mer_term_id */
	private BigInteger xpepGainTradeAmount;/* 对应表中xpep_gain_trade_amount */
	private String xpepGainSysResponse;/* 对应表中xpep_gain_sys_response */
	private String xpepGainSysReference;/* 对应表中xpep_gain_sys_reference */
	private int xpepGainResult;/* 对应表中xpep_gain_result */
	private String xpepAuthCode;/* 对应表中xpep_auth_code */
	private int posFlag;/* 对应表中pos_flag */
	private String xpeDeductRollBkSysReference;/* 对应表中xpe_deduct_roll_bk_sys_reference */
	private String xpepPosmercode;/* 对应表中xpep_posmercode */
	private String xpepPostermcode;/* 对应表中xpep_postermcode */
	private int chinnalId;/* 对应表中chinnal_id */
	private String xpepIntcdbank;/* 对应表中xpep_intcdbank */
	private String xpepIntcdname;/* 对应表中xpep_intcdname */
	private String xpepPoitcde;/* 对应表中xpep_poitcde */
	private String xpepGpsid;/* 对应表中xpep_gpsid */
	private String xpepOutcdtype;/* 对应表中xpep_outcdtype */
	private String abbrev;/*商户简称,对应mer_info表abbrev*/

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTseq() {
		return tseq;
	}

	public void setTseq(String tseq) {
		this.tseq = tseq;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public int getMdate() {
		return mdate;
	}

	public void setMdate(int mdate) {
		this.mdate = mdate;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getGate() {
		return gate;
	}

	public void setGate(int gate) {
		this.gate = gate;
	}

	public int getSysDate() {
		return sysDate;
	}

	public void setSysDate(int sysDate) {
		this.sysDate = sysDate;
	}

	public int getInitSysDate() {
		return initSysDate;
	}

	public void setInitSysDate(int initSysDate) {
		this.initSysDate = initSysDate;
	}

	public int getSysTime() {
		return sysTime;
	}

	public void setSysTime(int sysTime) {
		this.sysTime = sysTime;
	}

	public BigInteger getBatch() {
		return batch;
	}

	public void setBatch(BigInteger batch) {
		this.batch = batch;
	}

	public int getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(int feeAmt) {
		this.feeAmt = feeAmt;
	}

	public int getBankFee() {
		return bankFee;
	}

	public void setBankFee(int bankFee) {
		this.bankFee = bankFee;
	}

	public int getTstat() {
		return tstat;
	}

	public void setTstat(int tstat) {
		this.tstat = tstat;
	}

	public int getBkFlag() {
		return bkFlag;
	}

	public void setBkFlag(int bkFlag) {
		this.bkFlag = bkFlag;
	}

	public BigInteger getOrgSeq() {
		return orgSeq;
	}

	public void setOrgSeq(BigInteger orgSeq) {
		this.orgSeq = orgSeq;
	}

	public BigInteger getRefSeq() {
		return refSeq;
	}

	public void setRefSeq(BigInteger refSeq) {
		this.refSeq = refSeq;
	}

	public int getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(int refundAmt) {
		this.refundAmt = refundAmt;
	}

	public String getMerPriv() {
		return merPriv;
	}

	public void setMerPriv(String merPriv) {
		this.merPriv = merPriv;
	}

	public int getBkSend() {
		return bkSend;
	}

	public void setBkSend(int bkSend) {
		this.bkSend = bkSend;
	}

	public int getBkRecv() {
		return bkRecv;
	}

	public void setBkRecv(int bkRecv) {
		this.bkRecv = bkRecv;
	}

	public String getBkUrl() {
		return bkUrl;
	}

	public void setBkUrl(String bkUrl) {
		this.bkUrl = bkUrl;
	}

	public String getFgUrl() {
		return fgUrl;
	}

	public void setFgUrl(String fgUrl) {
		this.fgUrl = fgUrl;
	}

	public int getBkChk() {
		return bkChk;
	}

	public void setBkChk(int bkChk) {
		this.bkChk = bkChk;
	}

	public int getBkDate() {
		return bkDate;
	}

	public void setBkDate(int bkDate) {
		this.bkDate = bkDate;
	}

	public String getBkSeq1() {
		return bkSeq1;
	}

	public void setBkSeq1(String bkSeq1) {
		this.bkSeq1 = bkSeq1;
	}

	public String getBkSeq2() {
		return bkSeq2;
	}

	public void setBkSeq2(String bkSeq2) {
		this.bkSeq2 = bkSeq2;
	}

	public String getBkResp() {
		return bkResp;
	}

	public void setBkResp(String bkResp) {
		this.bkResp = bkResp;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getTransPeriod() {
		return transPeriod;
	}

	public void setTransPeriod(int transPeriod) {
		this.transPeriod = transPeriod;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getAuthorType() {
		return authorType;
	}

	public void setAuthorType(int authorType) {
		this.authorType = authorType;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getOperId() {
		return operId;
	}

	public void setOperId(int operId) {
		this.operId = operId;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getPreAmt() {
		return preAmt;
	}

	public void setPreAmt(int preAmt) {
		this.preAmt = preAmt;
	}

	public int getPreAmt1() {
		return preAmt1;
	}

	public void setPreAmt1(int preAmt1) {
		this.preAmt1 = preAmt1;
	}

	public String getBkFeeModel() {
		return bkFeeModel;
	}

	public void setBkFeeModel(String bkFeeModel) {
		this.bkFeeModel = bkFeeModel;
	}

	public String getTerminalNumber() {
		return terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getXpepMercode() {
		return xpepMercode;
	}

	public void setXpepMercode(String xpepMercode) {
		this.xpepMercode = xpepMercode;
	}

	public String getXpepTermid() {
		return xpepTermid;
	}

	public void setXpepTermid(String xpepTermid) {
		this.xpepTermid = xpepTermid;
	}

	public String getXpepTrancode() {
		return xpepTrancode;
	}

	public void setXpepTrancode(String xpepTrancode) {
		this.xpepTrancode = xpepTrancode;
	}

	public String getXpepTrace() {
		return xpepTrace;
	}

	public void setXpepTrace(String xpepTrace) {
		this.xpepTrace = xpepTrace;
	}

	public BigInteger getXpepTradeDatetime() {
		return xpepTradeDatetime;
	}

	public void setXpepTradeDatetime(BigInteger xpepTradeDatetime) {
		this.xpepTradeDatetime = xpepTradeDatetime;
	}

	public String getXpepOutcard() {
		return xpepOutcard;
	}

	public void setXpepOutcard(String xpepOutcard) {
		this.xpepOutcard = xpepOutcard;
	}

	public String getXpepTradeResp() {
		return xpepTradeResp;
	}

	public void setXpepTradeResp(String xpepTradeResp) {
		this.xpepTradeResp = xpepTradeResp;
	}

	public int getXpeTradetype() {
		return xpeTradetype;
	}

	public void setXpeTradetype(int xpeTradetype) {
		this.xpeTradetype = xpeTradetype;
	}

	public String getXpeDeductMercode() {
		return xpeDeductMercode;
	}

	public void setXpeDeductMercode(String xpeDeductMercode) {
		this.xpeDeductMercode = xpeDeductMercode;
	}

	public String getXpeDeductTermid() {
		return xpeDeductTermid;
	}

	public void setXpeDeductTermid(String xpeDeductTermid) {
		this.xpeDeductTermid = xpeDeductTermid;
	}

	public String getXpeDeductTrace() {
		return xpeDeductTrace;
	}

	public void setXpeDeductTrace(String xpeDeductTrace) {
		this.xpeDeductTrace = xpeDeductTrace;
	}

	public int getXpeDeductInsid() {
		return xpeDeductInsid;
	}

	public void setXpeDeductInsid(int xpeDeductInsid) {
		this.xpeDeductInsid = xpeDeductInsid;
	}

	public String getXpeDeductResp() {
		return xpeDeductResp;
	}

	public void setXpeDeductResp(String xpeDeductResp) {
		this.xpeDeductResp = xpeDeductResp;
	}

	public String getXpeDeductRefer() {
		return xpeDeductRefer;
	}

	public void setXpeDeductRefer(String xpeDeductRefer) {
		this.xpeDeductRefer = xpeDeductRefer;
	}

	public String getXpeDeductAuthcode() {
		return xpeDeductAuthcode;
	}

	public void setXpeDeductAuthcode(String xpeDeductAuthcode) {
		this.xpeDeductAuthcode = xpeDeductAuthcode;
	}

	public int getXpeDeductRollbkFlag() {
		return xpeDeductRollbkFlag;
	}

	public void setXpeDeductRollbkFlag(int xpeDeductRollbkFlag) {
		this.xpeDeductRollbkFlag = xpeDeductRollbkFlag;
	}

	public String getXpeDeductRollbkReason() {
		return xpeDeductRollbkReason;
	}

	public void setXpeDeductRollbkReason(String xpeDeductRollbkReason) {
		this.xpeDeductRollbkReason = xpeDeductRollbkReason;
	}

	public String getXpeDeductRollbkStance() {
		return xpeDeductRollbkStance;
	}

	public void setXpeDeductRollbkStance(String xpeDeductRollbkStance) {
		this.xpeDeductRollbkStance = xpeDeductRollbkStance;
	}

	public String getXpeDeductRollbkResp() {
		return xpeDeductRollbkResp;
	}

	public void setXpeDeductRollbkResp(String xpeDeductRollbkResp) {
		this.xpeDeductRollbkResp = xpeDeductRollbkResp;
	}

	public String getXpeDeductRollBkResponse() {
		return xpeDeductRollBkResponse;
	}

	public void setXpeDeductRollBkResponse(String xpeDeductRollBkResponse) {
		this.xpeDeductRollBkResponse = xpeDeductRollBkResponse;
	}

	public String getXpepTermId() {
		return xpepTermId;
	}

	public void setXpepTermId(String xpepTermId) {
		this.xpepTermId = xpepTermId;
	}

	public String getXpepTermIdm() {
		return xpepTermIdm;
	}

	public void setXpepTermIdm(String xpepTermIdm) {
		this.xpepTermIdm = xpepTermIdm;
	}

	public String getXpepIntcdNo() {
		return xpepIntcdNo;
	}

	public void setXpepIntcdNo(String xpepIntcdNo) {
		this.xpepIntcdNo = xpepIntcdNo;
	}

	

	public Date getXpepDeductSysTime() {
		return xpepDeductSysTime;
	}

	public void setXpepDeductSysTime(Date xpepDeductSysTime) {
		this.xpepDeductSysTime = xpepDeductSysTime;
	}

	public Date getXpepDeductStlmDate() {
		return xpepDeductStlmDate;
	}

	public void setXpepDeductStlmDate(Date xpepDeductStlmDate) {
		this.xpepDeductStlmDate = xpepDeductStlmDate;
	}

	public int getXpepTrademsgType() {
		return xpepTrademsgType;
	}

	public void setXpepTrademsgType(int xpepTrademsgType) {
		this.xpepTrademsgType = xpepTrademsgType;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getXpepSendcde() {
		return xpepSendcde;
	}

	public void setXpepSendcde(String xpepSendcde) {
		this.xpepSendcde = xpepSendcde;
	}

	public String getXpepTradeCardType() {
		return xpepTradeCardType;
	}

	public void setXpepTradeCardType(String xpepTradeCardType) {
		this.xpepTradeCardType = xpepTradeCardType;
	}

	public int getXpepGainSysId() {
		return xpepGainSysId;
	}

	public void setXpepGainSysId(int xpepGainSysId) {
		this.xpepGainSysId = xpepGainSysId;
	}

	public String getXpepGainSysStance() {
		return xpepGainSysStance;
	}

	public void setXpepGainSysStance(String xpepGainSysStance) {
		this.xpepGainSysStance = xpepGainSysStance;
	}

	public String getXpepGainMerCode() {
		return xpepGainMerCode;
	}

	public void setXpepGainMerCode(String xpepGainMerCode) {
		this.xpepGainMerCode = xpepGainMerCode;
	}

	public String getXpepGainMerTermId() {
		return xpepGainMerTermId;
	}

	public void setXpepGainMerTermId(String xpepGainMerTermId) {
		this.xpepGainMerTermId = xpepGainMerTermId;
	}

	public BigInteger getXpepGainTradeAmount() {
		return xpepGainTradeAmount;
	}

	public void setXpepGainTradeAmount(BigInteger xpepGainTradeAmount) {
		this.xpepGainTradeAmount = xpepGainTradeAmount;
	}

	public String getXpepGainSysResponse() {
		return xpepGainSysResponse;
	}

	public void setXpepGainSysResponse(String xpepGainSysResponse) {
		this.xpepGainSysResponse = xpepGainSysResponse;
	}

	public String getXpepGainSysReference() {
		return xpepGainSysReference;
	}

	public void setXpepGainSysReference(String xpepGainSysReference) {
		this.xpepGainSysReference = xpepGainSysReference;
	}

	public int getXpepGainResult() {
		return xpepGainResult;
	}

	public void setXpepGainResult(int xpepGainResult) {
		this.xpepGainResult = xpepGainResult;
	}

	public String getXpepAuthCode() {
		return xpepAuthCode;
	}

	public void setXpepAuthCode(String xpepAuthCode) {
		this.xpepAuthCode = xpepAuthCode;
	}

	public int getPosFlag() {
		return posFlag;
	}

	public void setPosFlag(int posFlag) {
		this.posFlag = posFlag;
	}

	public String getXpeDeductRollBkSysReference() {
		return xpeDeductRollBkSysReference;
	}

	public void setXpeDeductRollBkSysReference(
			String xpeDeductRollBkSysReference) {
		this.xpeDeductRollBkSysReference = xpeDeductRollBkSysReference;
	}

	public String getXpepPosmercode() {
		return xpepPosmercode;
	}

	public void setXpepPosmercode(String xpepPosmercode) {
		this.xpepPosmercode = xpepPosmercode;
	}

	public String getXpepPostermcode() {
		return xpepPostermcode;
	}

	public void setXpepPostermcode(String xpepPostermcode) {
		this.xpepPostermcode = xpepPostermcode;
	}

	public int getChinnalId() {
		return chinnalId;
	}

	public void setChinnalId(int chinnalId) {
		this.chinnalId = chinnalId;
	}

	public String getXpepIntcdbank() {
		return xpepIntcdbank;
	}

	public void setXpepIntcdbank(String xpepIntcdbank) {
		this.xpepIntcdbank = xpepIntcdbank;
	}

	public String getXpepIntcdname() {
		return xpepIntcdname;
	}

	public void setXpepIntcdname(String xpepIntcdname) {
		this.xpepIntcdname = xpepIntcdname;
	}

	public String getXpepPoitcde() {
		return xpepPoitcde;
	}

	public void setXpepPoitcde(String xpepPoitcde) {
		this.xpepPoitcde = xpepPoitcde;
	}

	public String getXpepGpsid() {
		return xpepGpsid;
	}

	public void setXpepGpsid(String xpepGpsid) {
		this.xpepGpsid = xpepGpsid;
	}

	public String getXpepOutcdtype() {
		return xpepOutcdtype;
	}

	public void setXpepOutcdtype(String xpepOutcdtype) {
		this.xpepOutcdtype = xpepOutcdtype;
	}

	public String getAbbrev() {
		return "test";
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
}
