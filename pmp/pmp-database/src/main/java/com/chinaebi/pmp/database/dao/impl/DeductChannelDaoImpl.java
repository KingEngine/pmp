package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.database.dao.IDeductChannelDao;
import com.chinaebi.pmp.database.entity.DeductChannel;

public class DeductChannelDaoImpl extends CommonDaoImpl<DeductChannel> implements IDeductChannelDao{

	public List<DeductChannel> selectList(DeductChannel param){
		return null;
	}

	public List<DeductChannel> selectAllList(){
		return this.getSqlSession().selectList("DeductChannelManager.select");
	}

}
