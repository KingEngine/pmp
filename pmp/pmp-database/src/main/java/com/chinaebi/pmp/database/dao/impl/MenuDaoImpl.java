/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMenuDao;
import com.chinaebi.pmp.database.entity.Menu;

/**
 * users表实现类
 *
 * @author king
 */
public class MenuDaoImpl extends CommonDaoImpl<Menu> implements IMenuDao{
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public List<Menu> selectFirstMenuList(String userName) throws DaoException {
		try {
			return this.getSqlSession().selectList("MenuManager.selectFirsetMenus", userName);
		} catch (Exception e) {
			logger.error("MenuManager.select查询异常:",e);
			throw new DaoException("");
		}
	}

	public List<Menu> selectSecondMenuList(String userName,Integer firstMenuId) throws DaoException {
		 try {
			return this.getSqlSession().selectList("MenuManager.selectSecondsMenus",generateParameters(userName, firstMenuId));
		} catch (Exception e) {
			logger.error("MenuManager.selectSecondsMenus查询异常:",e);
			throw new DaoException("");
		}
	}

	public List<Menu> selectThirdMenuList(String userName,Integer secondMenuId) throws DaoException {
		 try {
			return this.getSqlSession().selectList("MenuManager.selectThirdMenus",generateParameters(userName, secondMenuId));
		} catch (Exception e) {
			logger.error("MenuManager.selectSecondsMenus查询异常:",e);
			throw new DaoException("");
		}
	}
	public List<Menu> selectList(Menu param) {
		try {
			return super.selectList("MenuManager.select", param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private Map<String,Object> generateParameters(String userName,Integer menuId){
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("userName", userName);
		parameters.put("parentMenuId", menuId);
		return parameters;
	}
}


