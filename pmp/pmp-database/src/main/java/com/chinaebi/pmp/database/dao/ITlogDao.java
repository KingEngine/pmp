package com.chinaebi.pmp.database.dao;

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
	 public Page<Map<String,Object>> selectPage(Page<Map<String,Object>> page,Map<String,Object> param) throws Exception;
	 
}


