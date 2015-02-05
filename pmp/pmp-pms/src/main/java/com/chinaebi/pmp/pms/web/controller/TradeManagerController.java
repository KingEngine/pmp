package com.chinaebi.pmp.pms.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;
import com.chinaebi.pmp.pms.service.ITradeManagerService;

/**
 * 交易管理控制器
 * 
 * @author king
 * 2014-10-27
 */
@Controller
public class TradeManagerController {
	
	private static final String prefix="pos/TradeManager/";

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ITradeManagerService tradeManagerService;
	public void setTradeManagerService(@Qualifier(Annotations.SERVICE_TRADEMANAGER)ITradeManagerService tradeManagerService) {
		this.tradeManagerService = tradeManagerService;
	}
	@RequestMapping(value = "/**/getCurrentTradePagePre.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getCurrentTradePagePre() {
		return prefix+"current_trade_pre";
	}
	@RequestMapping(value = "/**/getCurrentTradePage.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public Page<Tlog> getCurrentTradePage(HttpServletRequest request,HttpServletResponse response) {
		String curPage = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		Page<Tlog> page = new Page<Tlog>();
		if(StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if(StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else 
			page.setPageSize(10);
		Map<String,Object> params = new HashMap<String,Object>();
		Page<Tlog> pages = null;
		try {
			pages = tradeManagerService.getTlogForPage(page, params);
		} catch (Exception e) {
			
		}
		return pages;
	}
}
