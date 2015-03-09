package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMerPhotoInfoDao;
import com.chinaebi.pmp.database.entity.MerPhotoInfo;

/**
 * mer_photo_info表实现类
 *
 * @author king
 */
public class MerPhotoInfoDaoImpl extends CommonDaoImpl<MerPhotoInfo> implements IMerPhotoInfoDao{

	 /**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean insert(MerPhotoInfo param) throws DaoException{
	 	return super.insert("MerPhotoInfoManager.insert", param);
	 }
	 public List<MerPhotoInfo> selectList(MerPhotoInfo param)
			throws DaoException {
		return super.selectList("MerPhotoInfoManager.select", param);
	}
	
}


