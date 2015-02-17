package com.chinaebi.pmp.database.dao.impl;

import java.util.Map;

import com.chinaebi.pmp.database.dao.ITlogDao;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;

public class TlogDaoImpl extends CommonDaoImpl<Tlog> implements ITlogDao{

	public Page<Map<String,Object>> selectPage(Page<Map<String,Object>> page, Map<String,Object> parameter) throws Exception {
		 
		return super.selectPage(page, "TlogManager.queryPage", "TlogManager.queryPageCount",parameter);
	}
}
