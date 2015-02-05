/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/

package com.chinaebi.pmp.database;


import com.chinaebi.pmp.database.entity.OperInfo;
/**
 * oper_info表操作接口
 * 
 * @author king
 */
public interface IOperInfoDao{
	 /**
	 * 更新操作
	 * @param 
	 * @return
	 * @throws Exception
	 */
	 public boolean update(OperInfo param) throws Exception;
}


