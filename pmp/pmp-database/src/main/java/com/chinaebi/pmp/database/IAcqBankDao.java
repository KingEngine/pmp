/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database;

import java.util.List;

import com.chinaebi.pmp.database.entity.AcqBank;
/**
 * acq_bank表操作接口
 * 
 * @author king
 */
public interface IAcqBankDao{
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<AcqBank> selectList(AcqBank param) throws Exception;
}


