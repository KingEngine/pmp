package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.database.entity.UnionpayAreaCode;
/**
 * unionpay_area_code表操作接口
 * 
 * @author king
 */
public interface IUnionpayAreaCodeDao{
    
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<UnionpayAreaCode> selectList(UnionpayAreaCode param);
	 
}


