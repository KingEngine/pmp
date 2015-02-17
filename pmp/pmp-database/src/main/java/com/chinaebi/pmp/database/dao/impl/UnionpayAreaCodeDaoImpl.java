package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.database.dao.IUnionpayAreaCodeDao;
import com.chinaebi.pmp.database.entity.UnionpayAreaCode;

/**
 * unionpay_area_code表实现类
 *
 * @author king
 */
public class UnionpayAreaCodeDaoImpl extends CommonDaoImpl<UnionpayAreaCode>
		implements IUnionpayAreaCodeDao {
	public List<UnionpayAreaCode> selectList(UnionpayAreaCode param){
		try {
			return super.selectList("UnionpayAreaCodeManager.select", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
