/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database;

import java.util.List;

import com.chinaebi.pmp.database.entity.Menu;
/**
 * menu表操作接口
 * 
 * @author king
 */
public interface IMenuDao{
	 /**
	 * 查询一级菜单列表
	 * @param 
	 * @return
	 * @throws Exception
	 */
	 public List<Menu> selectFirstMenuList() throws Exception;
	 /**
	  * 查询二级菜单列表
	  * @return
	  * @throws Exception
	  */
	 public List<Menu> selectSecondMenuList(int firstMenuId) throws Exception;
	 /**
	  * 查询三级菜单列表
	  * @return
	  * @throws Exception
	  */
	 public List<Menu> selectThirdMenuList(int parentMenuId) throws Exception;
}


