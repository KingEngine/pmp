package com.chinaebi.pmp.database.dao;

import java.util.List;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.MerPhotoInfo;
/**
 * mer_photo_info表操作接口
 * 
 * @author king
 */
public interface IMerPhotoInfoDao{
	 /**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public boolean insert(MerPhotoInfo param) throws DaoException;
}


