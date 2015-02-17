package com.chinaebi.pmp.pms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.database.dao.ITlogDao;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Tlog;
import com.chinaebi.pmp.pms.service.ITradeManagerService;

@Service(Annotations.SERVICE_TRADEMANAGER)
public class TradeManagerServiceImpl implements ITradeManagerService{

	@Autowired
	@Qualifier(Annotations.DAO_TLOG)
	private ITlogDao tlogDao;

	public Page<Map<String,Object>> getTlogForPage(Page<Map<String,Object>> page, Map<String,Object> paramter)
			throws Exception {
		return tlogDao.selectPage(page, paramter);
	}

}
