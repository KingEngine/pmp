package com.chinaebi.pmp.service;


import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 校验用户名和密码
 *  
 * @author king 
 * 2015年2月10日
 */
public class LoginAuthenticationManager extends DaoAuthenticationProvider{
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		//校验登陆密码
		if (!StringUtils.equals(userDetails.getPassword(), authentication
				.getCredentials().toString())) {
			throw new BadCredentialsException("用户名或者密码错误!");
		}
		
	}
}
