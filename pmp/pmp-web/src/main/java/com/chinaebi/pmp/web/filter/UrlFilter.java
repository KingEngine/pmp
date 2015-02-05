package com.chinaebi.pmp.web.filter;



/*********************************************************************
 * 
 * Copyright (C) 2012, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/


import java.io.IOException;
import java.text.ParseException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * URL 杩囨护鍣�
 * 
 * @author tangbiao
 * @version $Id: UrlFilter.java, v 0.1 2012-12-19 涓嬪崍5:40:09 Administrator Exp $
 */
public class UrlFilter implements Filter {
    /**
     * Default constructor. 
     */
    public UrlFilter() {
    	
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    	
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String url = httpRequest.getRequestURI();
        String path = httpRequest.getContextPath();
    	if(url.indexOf("login.do")  != -1 || url.indexOf("exit.do") != -1 || url.indexOf("pwdUpdate.do") != -1|| url.indexOf("safetyPwdModify.do") != -1 || url.indexOf("operatorValidateWeakPassword.do") != -1){
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		String time = (String)session.getAttribute("lastActivityTime");
		Boolean login = (Boolean) session.getAttribute("isLogin") == null ? false : (Boolean) session.getAttribute("isLogin") ;
		Boolean isTimeOut = false;
		
        
        String method = httpRequest.getMethod();
        boolean flag = true;
       if (method.equals("GET") && url.indexOf("login.do") != -1) {
        	session.removeAttribute("login");
            httpResponse.sendRedirect(path);
            flag = false;
        } else if (method.equals("GET")) {
            if (url.indexOf(".do") != -1) {
                //闃叉鍒犻櫎鍔熻兘url鏀诲嚮
            }
        } else {
            if (url.indexOf(".do") != -1 && url.indexOf("system") != -1) {
                httpResponse.sendRedirect(path);
                flag = false;
            }
        }
        if (flag) {
            chain.doFilter(httpRequest, httpResponse);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
