package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.Channel;
/**
 * channel表操作接口
 * 
 * @author king
 */
public interface IChannelDao{
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<Channel> selectList(Channel param) throws DaoException;
	
}


