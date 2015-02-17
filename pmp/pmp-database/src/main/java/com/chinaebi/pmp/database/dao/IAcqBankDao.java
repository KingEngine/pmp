package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.database.entity.AcqBank;

/**
 * acq_bank表操作接口
 * 
 * @author king
 */
public interface IAcqBankDao{
 
	public List<AcqBank> selectAllList();
}


