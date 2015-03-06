package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;
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
	public T selectOne(String querySQL,T param) throws DaoException;
	/**
	 * 查询列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<T> selectList(String querySQL,T param) throws DaoException;
	/**
	 * 查询所有的列表
	 * @param querySQL
	 * @return
	 */
	public List<T> selectAll(String querySQL) throws DaoException;
	/**
	 * 分页查询
	 * @param page
	 * @param querySQL
	 * @param parameter
	 * @return
	 * @throws DaoException
	 */
	public Page<T> selectPage(Page<T> page,String querySQL, Object parameter)throws DaoException;
	/**
	 * 分页查询
	 * @param page
	 * @param querySQL
	 * @param parameter
	 * @return
	 * @throws DaoException
	 */
	public Page<T> selectPage(Page<T> page, String querySQL, String counterSQL, Object parameter)throws DaoException;
	
	/**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean insert(String insertSQL,T param) throws DaoException;
}
