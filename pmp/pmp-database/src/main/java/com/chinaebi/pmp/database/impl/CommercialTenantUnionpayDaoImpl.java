/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;

import java.util.List;

import com.chinaebi.pmp.database.ICommercialTenantUnionpayDao;
import com.chinaebi.pmp.database.entity.CommercialTenantUnionpay;
import com.chinaebi.pmp.database.entity.Page;

/**
 * commercial_tenant_unionpay表实现类
 *
 * @author king
 */
public class CommercialTenantUnionpayDaoImpl extends BaseDao implements ICommercialTenantUnionpayDao{

	 /**
	  * 查询对象
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public CommercialTenantUnionpay selectOne(CommercialTenantUnionpay param) throws Exception {
	 	Object obj = getSqlSession().selectOne("CommercialTenantUnionpayManager.select", param);
		if(null!=obj){
			return (CommercialTenantUnionpay)obj;
		}
		return null;
	 }
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<CommercialTenantUnionpay> selectList(CommercialTenantUnionpay param) throws Exception{
	 	return getSqlSession().selectList("CommercialTenantUnionpayManager.select", param);
	 }
	 /**
	  * 分页查询
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public Page<CommercialTenantUnionpay> selectPage(Page<CommercialTenantUnionpay> page,CommercialTenantUnionpay param) throws Exception{
	 	return selectPage(page,"CommercialTenantUnionpayManager.queryPage","CommercialTenantUnionpayManager.queryPageCount",param);
	 }
	 /**
	  * 更新操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean update(CommercialTenantUnionpay param) throws Exception{
	 	int affectedRows = getSqlSession().update("CommercialTenantUnionpayManager.update", param);
		if(affectedRows>0)
			return true;
		return false;
	 }
	 /**
	  * 删除操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean delete(CommercialTenantUnionpay param) throws Exception{
	 	int affectedRows = getSqlSession().delete("CommercialTenantUnionpayManager.delete", param);
		if(affectedRows>0)
			return true;
		return false;
	 }
	 /**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean insert(CommercialTenantUnionpay param) throws Exception{
	 	int affectedRows =  getSqlSession().insert("CommercialTenantUnionpayManager.insert",param);
		if(affectedRows>0)
			return true;
		return false;
	 }
	
}


