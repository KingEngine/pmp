/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.UsersAuthorities;

/**
 * users_authorities表操作接口
 * 
 * @author king
 */
public interface IUsersAuthoritiesDao{
	
	public boolean delete(String userName)throws DaoException;
	
	public boolean insert(List<UsersAuthorities> authorities)throws DaoException;
    
}


