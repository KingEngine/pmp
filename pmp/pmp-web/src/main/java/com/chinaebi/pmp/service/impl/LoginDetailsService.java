package com.chinaebi.pmp.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Users;

/**
 * 登录操作
 * 
 * @author king 
 * 2015年2月11日
 */
public class LoginDetailsService implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	@Qualifier(Annotations.DAO_USERS)
	private IUsersDao usersDao;//users表数据操作

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Users user = new Users();
		user.setUserName(userName);
		UserDetails userDetails = null;
		Users existUser = null;
		try {
			existUser = usersDao.selectOne(user);
		} catch (Exception e) {
			logger.error("数据库操作异常:",e);
		}
		if (null == existUser
				|| (null == existUser.getUserName() || StringUtils.equals("",
						existUser.getUserName()))) {
			throw new BadCredentialsException("用户名或者密码错误!");
		} else {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
			authorities.add(authority);
			userDetails = new User(existUser.getUserName(),existUser.getUserPassword(),authorities);
			return userDetails;
		}
	}
}
