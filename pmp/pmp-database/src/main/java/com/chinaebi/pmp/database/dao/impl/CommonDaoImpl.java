package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.ICommonDao;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;

/**
 * 基本数据库操作
 * 
 * @author king 2015年3月4日
 */
public class CommonDaoImpl<T extends Object> extends BaseDao implements
		ICommonDao<T> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	public T selectOne(String querySQL, T param) throws DaoException {
		try {
			Object obj = this.getSqlSession().selectOne(querySQL, param);
			if (null != obj) {
				return (T) obj;
			}
			return null;
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:", new Object[] { querySQL, e });
			}
			throw new DaoException(e.getMessage());
		}
	}

	public List<T> selectList(String querySQL, T param) throws DaoException {
		try {
			return this.getSqlSession().selectList(querySQL, param);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:", new Object[] { querySQL, e });
			}
			throw new DaoException(e.getMessage());
		}
	}

	public Page<T> selectPage(Page<T> page, String querySQL, Object parameter)
			throws DaoException {
		try {
			return super.selectForPage(page, querySQL, parameter);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:", new Object[] { querySQL, e });
			}
			throw new DaoException(e.getMessage());
		}
	}
	public Page<T> selectPage(Page<T> page, String querySQL, String counterSQL,
			Object parameter) throws DaoException {
		try {
			return super.selectForPage(page, querySQL,counterSQL, parameter);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:", new Object[] { querySQL, e });
			}
			throw new DaoException(e.getMessage());
		}
	}

	public List<T> selectAll(String querySQL) throws DaoException {
		try {
			return this.getSqlSession().selectList(querySQL);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:", new Object[] { querySQL, e });
			}
			throw new DaoException(e.getMessage());
		}
	}

	public boolean insert(String insertSQL, T param) throws DaoException {
		try {
			int counter = this.getSqlSession().insert(insertSQL, param);
			if (counter > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:",
						new Object[] { insertSQL, e });
			}
			throw new DaoException(e.getMessage());
		}
	}
}
