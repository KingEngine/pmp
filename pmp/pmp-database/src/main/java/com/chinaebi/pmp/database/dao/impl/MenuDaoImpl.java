/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMenuDao;
import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.database.entity.Users;

/**
 * users表实现类
 *
 * @author king
 */
public class MenuDaoImpl extends CommonDaoImpl<Users> implements IMenuDao{
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public List<Menu> selectList(String userName) throws DaoException {
		try {
			return this.getSqlSession().selectList("MenuManager.select", userName);
		} catch (Exception e) {
			logger.error("MenuManager.select查询异常:",e);
			throw new DaoException("");
		}
	}
}


