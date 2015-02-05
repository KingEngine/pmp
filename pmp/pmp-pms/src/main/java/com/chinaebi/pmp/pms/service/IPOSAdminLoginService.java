/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.pms.service;


import java.util.List;
import java.util.Map;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.entity.LoginUser;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.database.entity.OperInfo;



/**
 * 管理员登陆查询操作
 * @author king
 * 2014-10-14
 */
public interface IPOSAdminLoginService {
	
	public LoginUser getLoginUser(Map<String,Object> params);
	
	public boolean closeOper(OperInfo operInfo) throws BusinessException;

	public boolean updatErrorCount(OperInfo operInfo) throws BusinessException;
	
	public List<Menu> getFirstMenuList(LoginUser loginUser)throws BusinessException;
	
	public List<Menu> getChildrenMenuList(LoginUser loginUser,int firstMenuId)throws BusinessException;
}
