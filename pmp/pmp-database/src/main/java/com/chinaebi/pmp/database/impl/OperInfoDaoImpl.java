/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.chinaebi.pmp.database.IOperInfoDao;
import com.chinaebi.pmp.database.entity.OperInfo;
/**
 * oper_info表实现类
 * @author king
 * 2014-9-11
 */
public class OperInfoDaoImpl extends SqlSessionDaoSupport implements IOperInfoDao{
	 /**
	 * 更新操作
	 * @param 
	 * @return
	 * @throws Exception
	 */
	 public boolean update(OperInfo param) throws Exception{
	 	int affectedRows = getSqlSession().update("OperInfoManager.update", param);
		if(affectedRows>0)
			return true;
		return false;
	 }
}


