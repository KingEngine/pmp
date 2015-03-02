package com.chinaebi.pmp.pms.service;

import java.util.Map;

import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;

public interface IMerchantManagerService {
	
	public Page<Map<String, Object>> queryMerInfoForPage(Page<Map<String, Object>> page,MerInfo merInfo);
	

}
