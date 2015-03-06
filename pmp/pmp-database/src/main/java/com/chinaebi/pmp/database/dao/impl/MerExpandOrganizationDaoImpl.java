package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMerExpandOrganizationDao;
import com.chinaebi.pmp.database.entity.MerExpandOrganization;

/**
 * mer_expand_organization表实现类
 *
 * @author king
 */
public class MerExpandOrganizationDaoImpl extends CommonDaoImpl<MerExpandOrganization> implements IMerExpandOrganizationDao{

	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<MerExpandOrganization> selectList(MerExpandOrganization param) throws DaoException{
	 	 return super.selectList("MerExpandOrganizationManager.select", param);
	 }
}


