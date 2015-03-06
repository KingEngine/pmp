package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.TradeType;


/**
 * trade_type表操作接口
 * 
 * @author king
 */
public interface ITradeTypeDao{

	/**
	 * 根据渠道号获取交易类型
	 * @return
	 */
	public List<TradeType> selectTradeTypesByChannelId(Integer channelId)throws DaoException;
	
	/**
	 * 根据渠道号获取交易类型
	 * @return
	 */
	public List<TradeType> selectAllTradeTypes()throws DaoException;
}


