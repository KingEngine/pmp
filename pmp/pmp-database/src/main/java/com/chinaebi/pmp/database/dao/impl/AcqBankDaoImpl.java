package com.chinaebi.pmp.database.dao.impl;

import java.util.List;
import com.chinaebi.pmp.database.dao.IAcqBankDao;
import com.chinaebi.pmp.database.entity.AcqBank;

public class AcqBankDaoImpl extends CommonDaoImpl<AcqBank> implements IAcqBankDao{
	public List<AcqBank> selectAllList(){
		return this.getSqlSession().selectList("AcqBankManager.select");
	}
}
