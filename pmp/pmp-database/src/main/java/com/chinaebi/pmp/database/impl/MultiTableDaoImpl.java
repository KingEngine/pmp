
/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.chinaebi.pmp.database.IMultiTableDao;
import com.chinaebi.pmp.database.entity.LoginUser;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.TradeType;
/**
 * 多表关联操作
 * 
 * @author king
 * 2014-10-15
 */
public class MultiTableDaoImpl extends BaseDao implements IMultiTableDao{

	public LoginUser getLoginUser(Map<String, Object> params) {
		return (LoginUser) this.getSqlSession().selectOne("MultiTableManager.queryLoginUser", params);
	}
	
	public Page<Map<String, Object>> getTlogForPage(
			Page<Map<String, Object>> page, Map<String, Object> params) {
		return selectPage(page, "MultiTableManager.queryTlogPage","MultiTableManager.queryTlogPageCount", params);
	}
	
	public List<TradeType> getTradeTypeByChannelId(Integer channelId) {
		return this.getSqlSession().selectList("MultiTableManager.selectTradeType", channelId);
	}
}
