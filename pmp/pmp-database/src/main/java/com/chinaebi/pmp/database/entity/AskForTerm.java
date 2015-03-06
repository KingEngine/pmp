package com.chinaebi.pmp.database.entity;

import java.util.Date;

/**
 * 对应表 ask_for_term
 * 
 * @author king
 *
 */
public class AskForTerm implements java.io.Serializable {
	private static final long serialVersionUID = 2138421469915281043L;
	private int id;/* 对应表中id */
	private int mid;/* 对应表中mid */
	private int channelId;/* 对应表中channel_id */
	private int askForNumber;/* 对应表中ask_for_number */
	private int isFirst;/* 对应表中is_first */
	private int status;/* 对应表中status */
	private Date createTime;/* 对应表中create_time */
	private int termType;/* 对应表中term_type */
	private String manufacturers;/* 对应表中manufacturers */
	private String manufacturersModel;/* 对应表中manufacturers_model */
	private String merChannelId;/* 对应表中mer_channel_id */
	private String tradeCode;/* 对应表中trade_code */
	private int netModel;/* 对应表中net_model */
	private int posType;/* 对应表中pos_type */
	private String batch;/* 对应表中batch */
	private String termAddAddress;/* 对应表中term_add_address */
	private String merInfoAddress;/* 对应表中mer_info_address */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getAskForNumber() {
		return askForNumber;
	}

	public void setAskForNumber(int askForNumber) {
		this.askForNumber = askForNumber;
	}

	public int getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(int isFirst) {
		this.isFirst = isFirst;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getTermType() {
		return termType;
	}

	public void setTermType(int termType) {
		this.termType = termType;
	}

	public String getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}

	public String getManufacturersModel() {
		return manufacturersModel;
	}

	public void setManufacturersModel(String manufacturersModel) {
		this.manufacturersModel = manufacturersModel;
	}

	public String getMerChannelId() {
		return merChannelId;
	}

	public void setMerChannelId(String merChannelId) {
		this.merChannelId = merChannelId;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public int getNetModel() {
		return netModel;
	}

	public void setNetModel(int netModel) {
		this.netModel = netModel;
	}

	public int getPosType() {
		return posType;
	}

	public void setPosType(int posType) {
		this.posType = posType;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getTermAddAddress() {
		return termAddAddress;
	}

	public void setTermAddAddress(String termAddAddress) {
		this.termAddAddress = termAddAddress;
	}

	public String getMerInfoAddress() {
		return merInfoAddress;
	}

	public void setMerInfoAddress(String merInfoAddress) {
		this.merInfoAddress = merInfoAddress;
	}
}
