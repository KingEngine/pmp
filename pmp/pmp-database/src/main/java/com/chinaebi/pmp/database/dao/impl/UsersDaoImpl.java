/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao.impl;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;
/**
 * users表实现类
 *
 * @author king
 */
public class UsersDaoImpl extends CommonDaoImpl<Users> implements IUsersDao{

	public Users selectOne(Users param) throws DaoException {
		return super.selectOne("UsersManager.select", param);
	}

	public Page<Users> selectPage(Page<Users> page,Users param) throws DaoException {
		
		return super.selectPage(page, "UsersManager.queryPage", "UsersManager.queryPageCount",param);
	}

	public boolean insert(Users param) throws DaoException {
		return super.insert("UsersManager.insert", param);
	}
}


