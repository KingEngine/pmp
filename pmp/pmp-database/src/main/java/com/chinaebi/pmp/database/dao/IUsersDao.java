/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao;

import com.chinaebi.pmp.database.entity.Page;
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
	 
	 
	 public Page<Users> selectPage(Page<Users> page,Users param);
	 
	 public boolean insert(Users param);
}
    


