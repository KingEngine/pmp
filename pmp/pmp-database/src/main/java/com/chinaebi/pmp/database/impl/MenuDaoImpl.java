/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.chinaebi.pmp.database.IMenuDao;
import com.chinaebi.pmp.database.entity.Menu;


/**
 * menu表实现类
 * @author king
 * 2014-9-11
 */
public class MenuDaoImpl extends SqlSessionDaoSupport implements IMenuDao{
	 public List<Menu> selectFirstMenuList() throws Exception{
	 	return getSqlSession().selectList("MenuManager.selectFirstMenuList");
	 }
	public List<Menu> selectSecondMenuList(int firstMenuId) throws Exception {
		return getSqlSession().selectList("MenuManager.selectSecondMenuList",firstMenuId);
	}
	public List<Menu> selectThirdMenuList(int parentMenuId) throws Exception {
		return getSqlSession().selectList("MenuManager.selectThirdMenuList",parentMenuId);
	}
}


