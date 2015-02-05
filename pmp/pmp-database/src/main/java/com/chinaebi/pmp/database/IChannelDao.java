/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database;

import java.util.List;
import com.chinaebi.pmp.database.entity.Channel;
/**
 * channel表操作接口
 * 
 * @author king
 */
public interface IChannelDao{
     /**
	  * 查询对象
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public Channel selectOne(Channel param) throws Exception;
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<Channel> selectList(Channel param) throws Exception;
}


