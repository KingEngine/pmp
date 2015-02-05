/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.pms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.utils.MD5;
import com.chinaebi.pmp.database.entity.LoginUser;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.database.entity.OperInfo;
import com.chinaebi.pmp.pms.service.IPOSAdminLoginService;

/**
 * 登陆控制类
 * 
 * @author king 2014-10-13
 */
@Controller
public class POSAdminLoginController {
	private static String prefix = "pos/";

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IPOSAdminLoginService posAdminLoginService;

	public void setPosAdminLoginService(
			@Qualifier(Annotations.SERVICE_POSADMINLOGIN) IPOSAdminLoginService posAdminLoginService) {
		this.posAdminLoginService = posAdminLoginService;
	}
	/**
	 * 管理员登陆操作
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/**/POSLogin.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String login(
			@RequestParam(value = "uid",required=false) String uid,
			@RequestParam(value = "pwd",required=false) String pwd,
			@RequestParam(value = "ckpwd",required=false) String ckpwd, 
			HttpSession session,Model model) {
		try {
			// 判断验证码
			String verifyCode = (String) session.getAttribute(WebConstants.RAND);
			if (ckpwd == null || ckpwd.equals("")) {
				model.addAttribute("loginerror", "验证码生成已过期，请刷新重新输入!");
				return prefix + "login";
			}
			if (ckpwd != null && !ckpwd.equals(verifyCode)) {
				model.addAttribute("loginerror", "验证码输入错误，请重新输入!");
				return prefix + "login";
			}
			Map<String, Object> params = new HashMap<String, Object>();
			String mid="1";
			params.put("uid", uid);
			params.put("mtype", "0");
			params.put("mid", mid);
			LoginUser loginuser = posAdminLoginService.getLoginUser(params);
			if (null != loginuser) {
				logger.info("查询操作员[{}]成功",
						new Object[] { loginuser.getOperName() });
				if (loginuser.getOperState() == 1) {
					model.addAttribute("loginerror", "此操作员号已被关闭!");
					return prefix + "login";
				}
				/**
				 * 输错密码的业务处理
				 */
				String md5pwd = MD5.getMD5(pwd.getBytes());
				if (!loginuser.getMd5Pwd().equals(md5pwd)) {
					int newErrCount = loginuser.getErrCount() + 1;
					OperInfo operInfo = new OperInfo();
					operInfo.setMid(loginuser.getMid());
					operInfo.setOperId(loginuser.getOperId());
					operInfo.setMtype(loginuser.getMtype());
					if (newErrCount >= WebConstants.ALLOW_ERR_LOGIN_PWD_COUNT) {//
						// 关闭操作员
						posAdminLoginService.closeOper(operInfo);
						operInfo.setErrCount(newErrCount);
						posAdminLoginService.updatErrorCount(operInfo);
						model.addAttribute("loginerror", "此操作员号已被关闭，请联系管理员!");
						return prefix + "login";
					} else {
						operInfo.setErrCount(newErrCount);
						posAdminLoginService.updatErrorCount(operInfo);
						model.addAttribute("loginerror","输入有误,还有"+(WebConstants.ALLOW_ERR_LOGIN_PWD_COUNT - newErrCount)+"次机会");
						return prefix + "login";
					}
				}else{//
					session.setAttribute(WebConstants.SESSION_LOGGED_ON_USER, loginuser);
					session.setAttribute(WebConstants.SESSION_LOGGED_ON_MID, mid);
					session.setAttribute(WebConstants.SESSION_LOGGED_ON_INNERMERCODE, null);
					//得到菜单列表
					List<Menu> firstMenus = posAdminLoginService.getFirstMenuList(loginuser);
					session.setAttribute(WebConstants.FIRST_MENUS, firstMenus);
					return prefix+"main";
				}
			} else {
				model.addAttribute("loginerror", "操作员不存在!");
				return prefix + "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询操作员异常:" + e);
		}
		return null;
	}
	@RequestMapping(value = "/**/getLeftMenuList.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getLeftMenuList(HttpSession session,Model model,HttpServletRequest request,@RequestParam("firstMenuId")Integer firstMenuId){
		logger.info("开始查询左菜单,菜单编号:["+firstMenuId+"]");
		LoginUser loginUser = (LoginUser) session.getAttribute(WebConstants.SESSION_LOGGED_ON_USER);
		try {
			List<Menu> treeMenus = posAdminLoginService.getChildrenMenuList(loginUser, firstMenuId);
			model.addAttribute(WebConstants.LEFT_MENU_LIST, treeMenus);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return prefix+"left";
	}
	
	@RequestMapping(value = "getPosTopPage.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getPosTopPage(){
		return prefix+"top";
	}
	
	@RequestMapping(value = "getPosLeftPage.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getPosLeftPage(){
		return prefix+"left";
	}
	
	@RequestMapping(value = "getPosWelcomePage.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getPosWelcomePage(){
		return "welcome";
	}
	
	@RequestMapping(value = "getPosFootPage.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String getPosFootPage(){
		return prefix+"foot";
	}
	/**
	 * 退出方法
	 * @return
	 */
	@RequestMapping(value = "exit.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String exit(){
		return prefix+"foot";
	}
}
