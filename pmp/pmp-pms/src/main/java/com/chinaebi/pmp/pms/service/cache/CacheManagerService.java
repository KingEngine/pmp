package com.chinaebi.pmp.pms.service.cache;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IDeductChannelDao;
import com.chinaebi.pmp.database.dao.ITradeTypeDao;
import com.chinaebi.pmp.database.entity.DeductChannel;
import com.chinaebi.pmp.database.entity.TradeType;

public class CacheManagerService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<TradeType> tradeTypes;
	
	public List<DeductChannel> deductChannels;
	
	

	@Autowired
	@Qualifier(Annotations.DAO_TRADETYPE)
	private ITradeTypeDao tradeTypeDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_DEDUCTCHANNEL)
	private IDeductChannelDao deductChannelDao;
	public void loadTradeTypes() throws DaoException {
		try {
			tradeTypes = tradeTypeDao.selectAllTradeTypes();
			if(logger.isInfoEnabled()){
				logger.info("获取交易列表成功");
			}
		} catch (DaoException e) {
			if(logger.isErrorEnabled()){
				logger.error("获取交易类型列表失败!");
			}
			throw e;
		}
	}
	public void loadDeductChannels() throws DaoException {
		try {
			deductChannels = deductChannelDao.selectAllList();
			if(logger.isInfoEnabled()){
				logger.info("获取扣款列表成功");
			}
		} catch (DaoException e) {
			if(logger.isErrorEnabled()){
				logger.error("获取扣款列表失败!");
			}
			throw e;
		}
	}
	public List<TradeType> getCacheTradeTypes(){
		return tradeTypes;
	}
	public List<DeductChannel> getCacheDeductChannels(){
		return deductChannels;
	}
	public void initialize() throws DaoException{
		loadTradeTypes();
		loadDeductChannels();
		
	}
}
