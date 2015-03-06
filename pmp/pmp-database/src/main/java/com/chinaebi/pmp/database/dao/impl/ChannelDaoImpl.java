package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IChannelDao;
import com.chinaebi.pmp.database.entity.Channel;

/**
 * channel表实现类
 *
 * @author king
 */
public class ChannelDaoImpl extends CommonDaoImpl<Channel> implements IChannelDao{

	public List<Channel> selectList(Channel param) throws DaoException {
		return super.selectList("ChannelManager.select", param);
	}
}


