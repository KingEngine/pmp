package com.chinaebi.pmp.database.dao.impl;


import java.util.List;

import com.chinaebi.pmp.database.dao.ICommonDao;
import com.chinaebi.pmp.database.entity.Page;

public class CommonDaoImpl<T extends Object> extends BaseDao implements ICommonDao<T>{
	@SuppressWarnings("unchecked")
	public T selectOne(String querySQL, T param) throws Exception {
		Object obj =  this.getSqlSession().selectOne(querySQL,param);
		if(null!=obj){
			return (T)obj;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<T> selectList(String querySQL, T param) throws Exception {
		  return this.getSqlSession().selectList(querySQL,param);
	}

	public Page<T> selectForPage(Page<T> page, String querySQL, Object parameter)
			throws Exception {
		return super.selectPage(page, querySQL, parameter);
	}
	public List<T> selectAll(String querySQL){
		return this.getSqlSession().selectList(querySQL);
	}
}
