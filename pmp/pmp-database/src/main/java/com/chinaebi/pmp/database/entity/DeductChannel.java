package com.chinaebi.pmp.database.entity;

/**
 * 对应表 deduct_channel
 * 
 * @author king
 *
 */
public class DeductChannel implements java.io.Serializable {
	private static final long serialVersionUID = -8525737569701019116L;
	private int deductChannelId;/* 对应表中deduct_channel_id */
	private String deductChannelName;/* 对应表中deduct_channel_name */

	public int getDeductChannelId() {
		return deductChannelId;
	}

	public void setDeductChannelId(int deductChannelId) {
		this.deductChannelId = deductChannelId;
	}

	public String getDeductChannelName() {
		return deductChannelName;
	}

	public void setDeductChannelName(String deductChannelName) {
		this.deductChannelName = deductChannelName;
	}
}
