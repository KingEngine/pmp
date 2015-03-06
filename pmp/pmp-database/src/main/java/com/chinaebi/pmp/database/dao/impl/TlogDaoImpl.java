package com.chinaebi.pmp.database.dao.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.ITlogDao;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;

public class TlogDaoImpl extends CommonDaoImpl<Tlog> implements ITlogDao{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public Page<Map<String,Object>> selectPage(Page<Map<String,Object>> page, Map<String,Object> parameter) throws DaoException {
		try {
			return super.selectForPage(page, "TlogManager.queryPage",
					"TlogManager.queryPageCount", parameter);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作：[{}]异常,ERROR:", new Object[] {
						"TlogManager.queryPage", e });
			}
			throw new DaoException(e.getMessage());
		}
	}
}
