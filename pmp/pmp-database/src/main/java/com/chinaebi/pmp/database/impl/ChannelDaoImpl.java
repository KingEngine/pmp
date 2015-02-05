/*********************************************************************
 * 
 * Copyright (C) 2013, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.chinaebi.pmp.database.IChannelDao;
import com.chinaebi.pmp.database.entity.Channel;

/**
 * channel表实现类
 *
 * @author king
 */
public class ChannelDaoImpl extends SqlSessionDaoSupport implements IChannelDao{

	 /**
	  * 查询对象
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public Channel selectOne(Channel param) throws Exception {
	 	Object obj = getSqlSession().selectOne("ChannelManager.select", param);
		if(null!=obj){
			return (Channel)obj;
		}
		return null;
	 }
	 /**
	  * 查询列表
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public List<Channel> selectList(Channel param) throws Exception{
	 	return getSqlSession().selectList("ChannelManager.select", param);
	 }
}


