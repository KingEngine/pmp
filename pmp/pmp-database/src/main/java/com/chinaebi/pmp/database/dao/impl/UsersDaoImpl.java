/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao.impl;

import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Users;

/**
 * users表实现类
 *
 * @author king
 */
public class UsersDaoImpl extends CommonDaoImpl<Users> implements IUsersDao{
	
	public Users selectOne(Users param) throws Exception {
		return super.selectOne("UsersManager.select", param);
	}
}


