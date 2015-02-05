/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;

import java.util.List;

import com.chinaebi.pmp.database.IAcqBankDao;
import com.chinaebi.pmp.database.entity.AcqBank;

/**
 * acq_bank表实现类
 * 
 * @author king
 */
public class AcqBankDaoImpl extends BaseDao implements IAcqBankDao {
	/**
	 * 查询列表
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AcqBank> selectList(AcqBank param) throws Exception {
		return getSqlSession().selectList("AcqBankManager.select", param);
	}
}
