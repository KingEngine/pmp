package com.chinaebi.pmp.pms.service;

import java.util.Map;
import com.chinaebi.pmp.database.entity.Page;

public interface ITradeManagerService {
	
	public Page<Map<String,Object>> getTlogForPage(Page<Map<String,Object>> page,Map<String,Object> paramter) throws Exception;

}
