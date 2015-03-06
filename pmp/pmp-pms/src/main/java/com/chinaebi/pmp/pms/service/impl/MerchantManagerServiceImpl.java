package com.chinaebi.pmp.pms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMerInfoDao;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.pms.service.IMerchantManagerService;

@Component
public class MerchantManagerServiceImpl implements IMerchantManagerService{

	@Autowired
	@Qualifier(Annotations.DAO_MERINFO)
	private IMerInfoDao merInfoDao;

	public Page<Map<String, Object>> queryMerInfoForPage(Page<Map<String, Object>> page, MerInfo param) throws BusinessException {
		try {
			return merInfoDao.selectPage(page, param);
		} catch (DaoException e) {
			throw new BusinessException("");
		}
	}
}
