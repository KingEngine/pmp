package com.chinaebi.pmp.service;


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
		authentication.getName();
		System.out.println(authentication.getPrincipal());
		System.out.println(authentication.getCredentials());
		
	}
}
