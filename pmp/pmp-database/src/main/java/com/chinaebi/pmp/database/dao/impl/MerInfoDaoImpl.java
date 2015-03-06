package com.chinaebi.pmp.database.dao.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMerInfoDao;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;

public class MerInfoDaoImpl extends CommonDaoImpl<MerInfo> implements IMerInfoDao{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public int insert(MerInfo param) throws DaoException {
		try {
			this.getSqlSession().insert("MerInfoManager.insert",param);
			return param.getMid();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作:MerInfoManager.insert,ERROR:", new Object[] {e});
			}
			throw new DaoException(e.getMessage());
		}
	}
	public Page<Map<String, Object>> selectPage(Page<Map<String, Object>> page,
			Map<String, Object> param) throws DaoException {
		try {
			return super.selectForPage(page, "MerInfoManager.queryPage",
					"MerInfoManager.queryPageCount", param);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作:MerInfoManager.queryPage,ERROR:", new Object[] {e});
			}
			throw new DaoException(e.getMessage());
		}
	}
	public Page<Map<String, Object>> selectPage(Page<Map<String, Object>> page, MerInfo param) throws DaoException {
		try {
			return super.selectForPage(page, "MerInfoManager.queryPageFuzzy","MerInfoManager.queryPageFuzzyCount", param);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("DB操作:MerInfoManager.queryPageFuzzy,ERROR:", new Object[] {e});
			}
			throw new DaoException(e.getMessage());
		}
	}
}
