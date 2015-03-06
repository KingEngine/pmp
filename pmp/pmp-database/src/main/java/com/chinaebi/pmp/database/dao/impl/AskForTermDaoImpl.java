package com.chinaebi.pmp.database.dao.impl;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IAskForTermDao;
import com.chinaebi.pmp.database.entity.AskForTerm;

public class AskForTermDaoImpl extends CommonDaoImpl<AskForTerm> implements IAskForTermDao{

	public boolean insert(AskForTerm param) throws DaoException {
		return super.insert("AskForTermManager.insert", param);
	}

}
