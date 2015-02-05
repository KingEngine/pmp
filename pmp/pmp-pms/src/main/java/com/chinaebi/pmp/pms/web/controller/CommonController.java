/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.pms.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.Constants;
import com.chinaebi.pmp.common.entity.TradeStatus;
import com.chinaebi.pmp.database.entity.AcqBank;
import com.chinaebi.pmp.database.entity.Channel;
import com.chinaebi.pmp.database.entity.TradeType;
import com.chinaebi.pmp.pms.service.ICommonService;

/**
 * 全局通用的Controller类
 * 
 * @author king
 * 2014-12-16
 */
@Controller
public class CommonController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	@Qualifier(Annotations.SERVICE_COMMON)
	private ICommonService commonService;
	@RequestMapping(value = "/**/getChannelSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<Channel> getChannelSelectList(){
		List<Channel>  lists = commonService.getChannelSelectList();
		return lists;
	}
	
	@RequestMapping(value = "/**/getTradeTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TradeType> getTradeTypeSelectList(@RequestParam("channelId")Integer channelId){
		List<TradeType>  lists = commonService.getTradeTypeSelectList(channelId);
		return lists;
	}
	@RequestMapping(value = "/**/getTradeStatusSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TradeStatus> getTradeStatusSelectList(){
		return Constants.TRADE_STATUS;
	}
	@RequestMapping(value = "/**/getAcqBankSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<AcqBank> getAcqBankSelectList(){
		return commonService.getAcqBankSelectList();
	}
}
