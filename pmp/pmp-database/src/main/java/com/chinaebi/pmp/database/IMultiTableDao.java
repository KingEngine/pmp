/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database;

import java.util.List;
import java.util.Map;

import com.chinaebi.pmp.database.entity.LoginUser;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.TradeType;
/**
 * 操作管理员
 * 
 * @author king
 * 2014-10-14
 */
public interface IMultiTableDao {
	/**
	 * 得到操作员信息
	 * @param params
	 * @return
	 */
	public LoginUser getLoginUser(Map<String,Object> params);
	/**
	 * 分页查询当天交易
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<Map<String, Object>> getTlogForPage(Page<Map<String, Object>> page, Map<String, Object> params);
	/**
	 * 根据渠道Id得到交易类型
	 * @return
	 */
	public List<TradeType> getTradeTypeByChannelId(Integer channelId);
}
