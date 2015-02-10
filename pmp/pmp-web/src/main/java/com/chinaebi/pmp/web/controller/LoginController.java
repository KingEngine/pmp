package com.chinaebi.pmp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
/**
 * 登录控制器
 * @author king 
 * 2015年2月10日
 */
@Controller
public class LoginController {
	public final static String prefix="";
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
	public String getMainFrame(){
		return prefix+"main";
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
