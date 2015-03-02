package com.chinaebi.pmp.service.impl;


import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.database.dao.IUsersDao;

/**
 * 校验用户名和密码
 *  
 * @author king 
 * 2015年2月10日
 */
public class LoginAuthenticationManager extends DaoAuthenticationProvider{
	@Autowired
	@Qualifier(Annotations.DAO_USERS)
	private IUsersDao usersDao;//users表数据操作
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
