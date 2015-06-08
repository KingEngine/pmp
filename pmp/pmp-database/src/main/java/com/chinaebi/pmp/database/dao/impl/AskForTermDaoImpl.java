package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IAskForTermDao;
import com.chinaebi.pmp.database.entity.AskForTerm;

public class AskForTermDaoImpl extends CommonDaoImpl<AskForTerm> implements IAskForTermDao{

	public boolean insert(AskForTerm param) throws DaoException {
		return super.insert("AskForTermManager.insert", param);
	}
	public List<AskForTerm> selectList(AskForTerm param) throws DaoException {
		return super.selectList("AskForTermManager.select", param);
	}
	public int selectMerchantTermNum(int mid) throws DaoException {
		int num = 0;
		try {
			num = super.getSqlSession().selectOne("AskForTermManager.selectMerchantTermNum", mid);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return num;
	}
}
