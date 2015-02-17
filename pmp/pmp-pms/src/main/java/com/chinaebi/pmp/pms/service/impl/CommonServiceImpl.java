package com.chinaebi.pmp.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.dao.IAcqBankDao;
import com.chinaebi.pmp.database.dao.IChannelDao;
import com.chinaebi.pmp.database.dao.IDeductChannelDao;
import com.chinaebi.pmp.database.dao.ITradeTypeDao;
import com.chinaebi.pmp.database.dao.IUnionpayAreaCodeDao;
import com.chinaebi.pmp.database.entity.AcqBank;
import com.chinaebi.pmp.database.entity.Channel;
import com.chinaebi.pmp.database.entity.DeductChannel;
import com.chinaebi.pmp.database.entity.TradeType;
import com.chinaebi.pmp.database.entity.UnionpayAreaCode;
import com.chinaebi.pmp.pms.service.ICommonService;
import com.chinaebi.pmp.pms.service.cache.CacheManagerService;

@Service(Annotations.SERVICE_COMMON)
public class CommonServiceImpl implements ICommonService{

	@Autowired
	@Qualifier(Annotations.DAO_CHANNEL)
	private IChannelDao channelDao;
	@Autowired
	@Qualifier(Annotations.DAO_TRADETYPE)
	private ITradeTypeDao tradeTypeDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_ACQBANK)
	private IAcqBankDao acqBankDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_DEDUCTCHANNEL)
	private IDeductChannelDao deductChannelDao;
	
	@Autowired
	@Qualifier(Annotations.SERVICE_CACHEMANAGER)
	private CacheManagerService cacheManagerService;
	
	@Autowired
	@Qualifier(Annotations.DAO_UNIONPAYAREACODE)
	private IUnionpayAreaCodeDao unionpayAreaCodeDao;
	
	public List<Channel> getChannels() throws BusinessException {
		try {
			return channelDao.selectList(new Channel());
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
	public List<TradeType> getTradeTypesByChannelId(Integer channelId)
			throws BusinessException {
		return tradeTypeDao.selectTradeTypesByChannelId(channelId);
	}
	public List<AcqBank> getAcqBanks() throws BusinessException {
		return acqBankDao.selectAllList();
	}
	
	public List<DeductChannel> getCacheDeductChannels() throws BusinessException {
		return cacheManagerService.getCacheDeductChannels();
	}
	
	public List<TradeType> getCacheTradeTypes() throws BusinessException {
		return cacheManagerService.getCacheTradeTypes();
	}
	public List<UnionpayAreaCode> getUnionpayAreaCodes(int parentAreaCode)
			throws BusinessException {
		UnionpayAreaCode param = new UnionpayAreaCode();
		param.setParentAreaCode(parentAreaCode);
		return unionpayAreaCodeDao.selectList(param);
	}
}
