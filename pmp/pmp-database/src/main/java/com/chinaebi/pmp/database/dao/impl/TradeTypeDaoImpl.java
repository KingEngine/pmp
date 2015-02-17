package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.database.dao.ITradeTypeDao;
import com.chinaebi.pmp.database.entity.TradeType;

public class TradeTypeDaoImpl extends CommonDaoImpl<TradeType> implements ITradeTypeDao{

	public List<TradeType> selectTradeTypesByChannelId(Integer channelId) {
		return this.getSqlSession().selectList("TradeTypeManager.selectByChannelId", channelId);
	}
	public List<TradeType> selectAllTradeTypes() {
		return super.selectAll("TradeTypeManager.select");
	}

}
