package com.chinaebi.pmp.database.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
/**
 * 通用数据库操作方法
 * 
 * @author king 
 * 2015年2月10日
 */
public interface ICommonDao<T> {
	/**
	 * 查询对象
	 * @param
	 * @return
	 * @throws Exception
	 */
	public T selectOne(String querySQL,T param) throws SQLException;
	/**
	 * 查询列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<T> selectList(String querySQL,T param) throws SQLException;
}
