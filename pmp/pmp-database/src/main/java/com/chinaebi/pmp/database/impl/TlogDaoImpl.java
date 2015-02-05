/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;

import java.util.Map;

import com.chinaebi.pmp.database.ITlogDao;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;

/**
 * tlog表实现类
 *
 * @author king
 */
public class TlogDaoImpl extends BaseDao implements ITlogDao{
	 /**
	  * 分页查询
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public Page<Tlog> selectPage(Page<Tlog> page,Map<String,Object> param) throws Exception{
	 	return selectPage(page,"TlogManager.queryPage","TlogManager.queryPageCount",param);
	 }
}


