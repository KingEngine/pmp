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
	
	 public List<Menu> selectList(String userName) throws DaoException;
    
}


