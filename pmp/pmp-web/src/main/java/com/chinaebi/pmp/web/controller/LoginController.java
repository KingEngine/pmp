package com.chinaebi.pmp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public final static String prefix="pos/";
	
	@RequestMapping(value="/login.do",method={RequestMethod.GET,RequestMethod.POST})
	public String login(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, ModelMap model, SessionStatus status){
		return prefix+"login";
	}
	@RequestMapping(value="/mainFrame.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getMainFrame(){
		return prefix+"main";
	}
}
