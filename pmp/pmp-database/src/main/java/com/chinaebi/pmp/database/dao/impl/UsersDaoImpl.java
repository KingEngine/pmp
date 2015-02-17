/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao.impl;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Users;

/**
 * users表实现类
 *
 * @author king
 */
public class UsersDaoImpl extends CommonDaoImpl<Users> implements IUsersDao{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public Users selectOne(Users param) throws Exception {
	
		 try {
			return super.selectOne("UsersManager.select", param);
		} catch (SQLException e) {
			logger.error("UsersManager.select查询异常:",e);
			throw new DaoException(e.getMessage());
		}
	}
}


