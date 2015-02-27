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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.pms.service.ITradeManagerService;


@Controller
public class TradeManagerController {
	public final static String prefix="mms/TradeManager/TradeQuery/";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier(Annotations.SERVICE_TRADEMANAGER)
	private ITradeManagerService tradeMangerService;
	
	@RequestMapping(value = "/**/getCurrentTradePagePre.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getCurrentTradePagePre() {
		return prefix+"current_trade_pre";
	}
	@RequestMapping(value = "/**/getCurrentTradePage.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public Page<Map<String,Object>> getCurrentTradePage(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="tradeChannel",required=false) String tradeChannel,
			@RequestParam(value="tradeType",required=false)String tradeType,
			@RequestParam(value="tradeStatus",required=false)String tradeStatus,
			@RequestParam(value="acqBank",required=false)String acqBank,
			@RequestParam(value="unionpayMerId",required=false)String unionpayMerId,
			@RequestParam(value="deductChannel",required=false)String deductChannel,
			@RequestParam(value="posMerAbbrev",required=false)String posMerAbbrev,
			@RequestParam(value="innerMerCode",required=false)String innerMerCode,
			@RequestParam(value="incrementMerCode",required=false)String incrementMerCode,
			@RequestParam(value="terminalNum",required=false)String terminalNum,
			@RequestParam(value="phoneOrOthers",required=false)String phoneOrOthers,
			@RequestParam(value="bankCard",required=false)String bankCard,
			@RequestParam(value="systemFollowNum",required=false)String systemFollowNum,
			@RequestParam(value="bkSeq",required=false)String bkSeq,
			@RequestParam(value="oid",required=false)String oid,
			@RequestParam(value="xpeDeductResp",required=false)String xpeDeductResp
			) throws Exception {
		
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<Map<String,Object>> page = new Page<Map<String,Object>>();
		if(StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if(StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else 
			page.setPageSize(10);
		Page<Map<String,Object>> pages = null;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("tradeChannel",tradeChannel );
		params.put("tradeType", tradeType);
		params.put("tradeStatus",tradeStatus );
		params.put("acqBank",acqBank );
		params.put("unionpayMerId", unionpayMerId);
		params.put("deductChannel", deductChannel);
		params.put("posMerAbbrev", posMerAbbrev);
		params.put("innerMerCode",innerMerCode );
		params.put("incrementMerCode", incrementMerCode);
		params.put("terminalNum", terminalNum);
		params.put("phoneOrOthers", phoneOrOthers);
		params.put("bankCard",bankCard );
		params.put("systemFollowNum",systemFollowNum );
		params.put("bkSeq", bkSeq);
		params.put("oid", oid);
		params.put("xpeDeductResp", xpeDeductResp);
		try {
			pages = tradeMangerService.getTlogForPage(page, params);
		} catch (Exception e) {
			if(logger.isErrorEnabled()){
				logger.error("查询当天交易失败",e);
			}
		}
		return pages;
	}
	/**
	 * tseq 交易订单号
	 */
	@RequestMapping(value = "/**/getTradeDetailPage.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getTradeDetail(@RequestParam("tseq") String tseq) {
		return prefix+"trade_detail";
	}
}
