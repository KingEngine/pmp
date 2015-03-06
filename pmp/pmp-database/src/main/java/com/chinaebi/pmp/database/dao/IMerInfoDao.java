package com.chinaebi.pmp.database.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.database.entity.Page;
/**
 * mer_info表操作接口
 * 
 * @author king
 */
@Component
public interface IMerInfoDao{
	 /**
	  * 插入操作
	  * @param 
	  * @return
	  * @throws Exception
	  */
	 public int insert(MerInfo param) throws DaoException;
	 
	 /**
	  * 分页查询
	  * @param page
	  * @param param
	  * @return
	  */
	 public Page<Map<String,Object>> selectPage(Page<Map<String,Object>> page,Map<String,Object> param) throws DaoException;
	 
	 public Page<Map<String, Object>> selectPage(Page<Map<String, Object>> page,MerInfo param)throws DaoException;
}


