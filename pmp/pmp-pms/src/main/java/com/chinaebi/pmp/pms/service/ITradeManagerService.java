/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.pms.service;

import java.util.Map;

import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;

/**
 * 交易管理service
 * 
 * @author king
 * 2014-11-9
 */
public interface ITradeManagerService {
	
	public Page<Tlog> getTlogForPage(Page<Tlog> page,Map<String,Object> params);

}
