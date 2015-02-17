package com.chinaebi.pmp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.service.ILoginService;
/**
 * 登录控制器
 * @author king 
 * 2015年2月10日
 */
@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public final static String prefix="";
	@Autowired
	@Qualifier(Annotations.SERVICE_LOGIN)
	private ILoginService loginServie;
	/**
	 * 登陆操作
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/login.do",method={RequestMethod.GET,RequestMethod.POST})
	public String login(HttpSession session, HttpServletRequest request,HttpServletResponse response, ModelMap model, SessionStatus status){
		return prefix+"login";
	}
	/**
	 * 获取主页面
	 * @return
	 */
	@RequestMapping(value="/getMainFrame.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getMainFrame(HttpSession session){
		//查找用户的菜单权限
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			List<Menu> firstMenus = loginServie.getUsersFirstMenus(userName);
			session.setAttribute(WebConstants.FIRST_MENUS, firstMenus);;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return prefix+"main";
	}
	/**
	 * 获取主页面
	 * @return
	 */
	@RequestMapping(value="/getLeftMenus.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getLeftMenus(HttpSession session,@RequestParam("firstMenuId")Integer firstMenuId){
		//查找用户的菜单权限
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			List<Menu> menuTrees = loginServie.getUsersChildMenus(userName, firstMenuId);
			session.setAttribute(WebConstants.LEFT_MENU_LIST, menuTrees);;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return prefix+"left";
	}
	/**
	 * 获取顶部页面
	 * @return
	 */
	@RequestMapping(value="/getTopPage.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getTopPage(){
		return prefix+"top";
	}
	/**
	 * 获取欢迎页面
	 * @return
	 */
	@RequestMapping(value="/getWelcomePage.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getWelcomePage(){
		return prefix+"welcome";
	}
	/**
	 * 获取底部页面
	 * @return
	 */
	@RequestMapping(value="/getFootPage.do",method={RequestMethod.GET,RequestMethod.POST})
	@Secured("ROLE_ADMIN")
	public String getFootPage(){
		return prefix+"foot";
	}
}
