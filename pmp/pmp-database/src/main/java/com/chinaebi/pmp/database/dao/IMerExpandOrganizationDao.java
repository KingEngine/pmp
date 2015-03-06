package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.MerExpandOrganization;
/**
 * mer_expand_organization表操作接口
 * 
 * @author king
 */
public interface IMerExpandOrganizationDao{
     
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<MerExpandOrganization> selectList(MerExpandOrganization param) throws DaoException;
}


