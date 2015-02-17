package com.chinaebi.pmp.pms.service;

import java.util.List;

import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.entity.AcqBank;
import com.chinaebi.pmp.database.entity.Channel;
import com.chinaebi.pmp.database.entity.DeductChannel;
import com.chinaebi.pmp.database.entity.TradeType;
import com.chinaebi.pmp.database.entity.UnionpayAreaCode;


public interface ICommonService {
	
	public List<Channel> getChannels() throws BusinessException;
	
	public List<TradeType> getTradeTypesByChannelId(Integer channelId)throws BusinessException;
	
	public List<AcqBank> getAcqBanks()throws BusinessException;
	
	public List<DeductChannel> getCacheDeductChannels()throws BusinessException;
	
	public List<TradeType> getCacheTradeTypes()throws BusinessException;
	
	public List<UnionpayAreaCode> getUnionpayAreaCodes(int parentAreaCode)throws BusinessException;
	
}
