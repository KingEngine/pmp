/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.common.constant;

import java.util.ArrayList;
import java.util.List;

import com.chinaebi.pmp.common.entity.TradeStatus;

/**
 * 全局字典说明
 * @author king
 * 2014-10-15
 */
public class Constants {
	public final static List<TradeStatus> TRADE_STATUS = new ArrayList<TradeStatus>();
	static{
		TRADE_STATUS.add(new TradeStatus(null,"全部"));
		TRADE_STATUS.add(new TradeStatus(0,"成功"));
		TRADE_STATUS.add(new TradeStatus(1,"失败"));
		TRADE_STATUS.add(new TradeStatus(2,"待处理"));
	}
}
