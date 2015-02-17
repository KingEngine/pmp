/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.Users;

/**
 * users表操作接口
 * 
 * @author king
 */
public interface IUsersDao {
	/**
	 * 查询操作
	 * @param param
	 * @return
	 * @throws Exception
	 */
	 public Users selectOne(Users param) throws Exception;
}
    


