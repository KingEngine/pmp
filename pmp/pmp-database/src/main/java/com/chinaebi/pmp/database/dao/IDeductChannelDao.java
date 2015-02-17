package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.database.entity.DeductChannel;
/**
 * deduct_channel表操作接口
 * 
 * @author king
 */
public interface IDeductChannelDao{
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<DeductChannel> selectList(DeductChannel param);
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<DeductChannel> selectAllList();
}


