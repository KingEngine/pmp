package com.chinaebi.pmp.database.dao.impl;

import java.util.Map;

import com.chinaebi.pmp.database.dao.IMerInfoDao;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;

public class MerInfoDaoImpl extends CommonDaoImpl<MerInfo> implements IMerInfoDao{

	public int insert(MerInfo param) throws Exception {
		int mid = this.getSqlSession().insert("MerInfoManager.insert", param);
		return mid;
	}
	public Page<Map<String, Object>> selectPage(Page<Map<String, Object>> page,
			Map<String, Object> param) {
		return super.selectPage(page, "MerInfoManager.queryPage", "MerInfoManager.queryPageCount",param);
	}
	public Page<Map<String, Object>> selectPage(Page<Map<String, Object>> page, MerInfo param) {
		return super.selectPage(page,"MerInfoManager.queryPageFuzzy", "MerInfoManager.queryPageFuzzyCount",param);
	}
}
