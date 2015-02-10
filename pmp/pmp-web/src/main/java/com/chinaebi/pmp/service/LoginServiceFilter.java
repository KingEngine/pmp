package com.chinaebi.pmp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chinaebi.pmp.common.constant.WebConstants;


public class LoginServiceFilter extends UsernamePasswordAuthenticationFilter {

	private @Value(value = "${checkValidateCode}") boolean isCheckValidateCode;
	
	public static final String RAND_CODE = "j_randcode";//随机验证码
	private String randCodeParamter= RAND_CODE;
	
	public boolean validateOperator(String userName, String password) {
		return false;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		//判断是否为post提交方式
		if(!StringUtils.equalsIgnoreCase("post", request.getMethod())){
			throw new AuthenticationServiceException("方法不支持:"+request.getMethod()+"方式提交");
		}
		// 判断是否验证码验证开关是否开启
		if (isCheckValidateCode) {
			validateCode(request);
		}
		return super.attemptAuthentication(request, response);
	}
	/**
	 * 校验验证码
	 * @param request
	 */
	private void validateCode(HttpServletRequest request) {
		Object sessionRand = request.getSession().getAttribute(WebConstants.RAND);
		Object requestRand = obtainRandCode(request);
		String sessionRandStr = (sessionRand == null ? "" : request.toString());
		String requestRandStr = (requestRand == null ? "" : request.toString());
		if(StringUtils.isBlank(requestRandStr)){
			throw new AuthenticationServiceException("请输入验证码!");   
		}
		if(!StringUtils.equals(sessionRandStr, requestRandStr)){
			throw new AuthenticationServiceException("验证码错误!");   
		}
	}

	protected String obtainRandCode(HttpServletRequest request) {
		return request.getParameter(randCodeParamter);
	}
	
}
