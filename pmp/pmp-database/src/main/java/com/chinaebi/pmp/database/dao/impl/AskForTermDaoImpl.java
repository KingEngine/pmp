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
		// TODO Auto-generated method stub
		return super.selectList("AskForTermManager.select", param);
	}

}
