package com.chinaebi.pmp.database.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.chinaebi.pmp.database.dao.ICommonDao;

public class CommonDaoImpl<T extends Object> extends BaseDao implements ICommonDao<T>{
	@SuppressWarnings("unchecked")
	public T selectOne(String querySQL, T param) throws SQLException {
		Object obj =  this.getSqlSession().selectOne(querySQL,param);
		if(null!=obj){
			return (T)obj;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<T> selectList(String querySQL, T param) throws SQLException {
		  return this.getSqlSession().selectList(querySQL,param);
	}
}
