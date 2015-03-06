package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.Menu;

/**
 * menu表操作接口
 * 
 * @author king
 */
public interface IMenuDao{
	
	 public List<Menu> selectFirstMenuList(String userName) throws DaoException;
	 
	 
	 public List<Menu> selectSecondMenuList(String userName,Integer firstMenuId) throws DaoException;
	 
	 
	 public List<Menu> selectThirdMenuList(String userName,Integer secondMenuId) throws DaoException;
	 
	 public List<Menu> selectList(Menu param) throws DaoException;
}


