package com.chinaebi.pmp.pms.web.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.exception.WebException;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;
import com.chinaebi.pmp.pms.service.IOperatorManagerService;

@Controller
public class OperatorManagerController {

	private final static String prefix = "mms/OperatorManager/";

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IOperatorManagerService operatorManagerService;

	@RequestMapping(value = "/**/managerOperationPre.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String getOperatorManagerPre() {
		return prefix + "operator_manager_pre";
	}

	@RequestMapping(value = "/**/queryOperatorsForPage.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Page<Users> queryOperatorsForPage(HttpServletRequest request,
			Users users) throws WebException {
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<Users> page = new Page<Users>();
		if (StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if (StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else
			page.setPageSize(10);
		try {
			return operatorManagerService.queryOperatorsForPage(page, users);
		} catch (BusinessException e) {
			throw new WebException();
		}
	}

	@RequestMapping(value = "/**/getOperatorAddPre.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String getOperatorAddPre() {
		return prefix + "operator_add_pre";
	}

	@RequestMapping(value = "/**/addOperator.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public Response addOperator(Users user) throws WebException {
		try {
			return operatorManagerService.addOperator(user);
		} catch (BusinessException e) {
			throw new WebException();
		}
	}

	@RequestMapping(value = "/**/operatorAuthoritySettingPre.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String operatorAuthoritySettingPre(
			@RequestParam("userId") BigInteger userId, Model model)
			throws WebException {
		String userName;
		try {
			userName = operatorManagerService.getUserNameByUserId(userId);
			model.addAttribute("userName", userName);
			return prefix + "operator_authority_setting";
		} catch (BusinessException e) {
			throw new WebException();
		}

	}

	/**
	 * 查询工作流权限
	 * 
	 * @throws WebException
	 */
	@RequestMapping(value = "/**/getOperatorAuthorities.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<Map<String, Object>> getOperatorAuthorities(
			@RequestParam("userName") String userName,
			@RequestParam("menuType") String menuType) throws WebException {
		try {
			return operatorManagerService.getOperatorAuthroities(userName,
					menuType);
		} catch (BusinessException e) {
			throw new WebException();
		}
	}

	/**
	 * 查询工作流权限
	 * 
	 * @throws WebException
	 */
	@RequestMapping(value = "/**/addOperatorAuthorities.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Response addOperatorAuthorities(
			@RequestParam("workFlowMenuJson") String workFlowMenusJson,
			@RequestParam("mmsMenuJson") String mmsMenusJson,
			@RequestParam("userName") String userName) throws WebException {
		boolean result;
		try {
			result = operatorManagerService.modifyOperatorAuthorities(
					workFlowMenusJson, mmsMenusJson, userName);
			if (result) {
				return new Response("00", "修改操作员权限成功!");
			} else {
				return new Response("E0", "修改操作员权限失败!");
			}
		} catch (BusinessException e) {
			throw new WebException();
		}

	}

}
