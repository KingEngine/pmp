package com.chinaebi.pmp.pms.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.exception.WebException;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.pms.service.IMerchantManagerService;

/**
 * 商户管理
 * 
 * @author king
 * 2015年2月26日
 */
@Controller
public class MerchantManagerController {
	
	private final static String prefix="mms/MerchantManager/";
	
	@Autowired
	private IMerchantManagerService merchantManagerService;
	
	@RequestMapping(value = "/**/merchantBaseInfoModifyPre.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String merchantBaseInfoModifyPre() {
		return prefix+"merchant_base_info_modify_pre";
	}

	@RequestMapping(value = "/**/getMerchantBaseInfoForPage.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public Page<Map<String, Object>> getMerchantBaseInfoForPage(HttpServletRequest request,MerInfo merInfo) throws WebException {
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		if(StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if(StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else 
			page.setPageSize(10);
		try {
			return merchantManagerService.queryMerInfoForPage(page, merInfo);
		} catch (BusinessException e) {
			throw new WebException();
		}
	}

}
