package com.chinaebi.pmp.pms.service;

import java.util.List;

import com.chinaebi.pmp.database.entity.AcqBank;
import com.chinaebi.pmp.database.entity.Channel;
import com.chinaebi.pmp.database.entity.TradeType;


/**
 * 全局通用的service
 * 
 * @author king
 * 2014-12-16
 */
public interface ICommonService {
	/**
	 * 交易渠道列表
	 * @return
	 */
	public List<Channel> getChannelSelectList();
	/**
	 * 交易类型列表
	 */
	public List<TradeType> getTradeTypeSelectList(Integer channelId);
	/**
	 * 交易类型列表
	 */
	public List<AcqBank> getAcqBankSelectList();
}
