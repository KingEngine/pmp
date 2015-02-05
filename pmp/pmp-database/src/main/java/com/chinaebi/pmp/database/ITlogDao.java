/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database;

import java.util.Map;

import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;
/**
 * tlog表操作接口
 * 
 * @author king
 */
public interface ITlogDao{
    
	 /**
	  * 分页查询
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public Page<Tlog> selectPage(Page<Tlog> page,Map<String,Object> param) throws Exception;
}


