package com.chinaebi.pmp.database.dao.impl;

import java.util.List;
import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IAcqBankDao;
import com.chinaebi.pmp.database.entity.AcqBank;

public class AcqBankDaoImpl extends CommonDaoImpl<AcqBank> implements IAcqBankDao{

	public List<AcqBank> selectAllList() throws DaoException {
		return super.selectAll("AcqBankManager.select");
	}
}
