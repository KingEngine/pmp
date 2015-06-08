package com.chinaebi.pmp.database.dao;

import java.util.List;

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
	 
	 /**
	  * 查询操作
	  * @param param
	  * @return
	  * @throws DaoException
	  */
	 public List<AskForTerm> selectList(AskForTerm param) throws DaoException;
	 /**
	  * 商户下的终端数量
	  * @param mid
	  * @return
	  * @throws DaoException
	  */
	 public int selectMerchantTermNum(int mid) throws DaoException;
}


