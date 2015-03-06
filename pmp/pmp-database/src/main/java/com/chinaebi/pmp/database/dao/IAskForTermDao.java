package com.chinaebi.pmp.database.dao;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.AskForTerm;
/**
 * ask_for_term表操作接口
 * 
 * @author king
 */
public interface IAskForTermDao{
	 /**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean insert(AskForTerm param) throws DaoException;
}


