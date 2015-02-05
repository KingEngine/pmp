/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database;

import java.util.List;

import com.chinaebi.pmp.database.entity.CommercialTenantUnionpay;
import com.chinaebi.pmp.database.entity.Page;
/**
 * commercial_tenant_unionpay表操作接口
 * 
 * @author king
 */
public interface ICommercialTenantUnionpayDao{
     /**
	  * 查询对象
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public CommercialTenantUnionpay selectOne(CommercialTenantUnionpay param) throws Exception;
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<CommercialTenantUnionpay> selectList(CommercialTenantUnionpay param) throws Exception;
	 /**
	  * 分页查询
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public Page<CommercialTenantUnionpay> selectPage(Page<CommercialTenantUnionpay> page,CommercialTenantUnionpay param) throws Exception;
	 /**
	  * 更新操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean update(CommercialTenantUnionpay param) throws Exception;
	 /**
	  * 删除操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean delete(CommercialTenantUnionpay param) throws Exception;
	 /**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean insert(CommercialTenantUnionpay param) throws Exception;
}


