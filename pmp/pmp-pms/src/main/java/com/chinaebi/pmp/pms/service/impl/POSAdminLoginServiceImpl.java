/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.pms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.IMenuDao;
import com.chinaebi.pmp.database.IMultiTableDao;
import com.chinaebi.pmp.database.IOperInfoDao;
import com.chinaebi.pmp.database.entity.LoginUser;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.database.entity.OperInfo;
import com.chinaebi.pmp.pms.service.IPOSAdminLoginService;

/**
 * 登录服务类
 * @author king
 * 2014-10-15
 */
@Service(Annotations.SERVICE_POSADMINLOGIN)
public class POSAdminLoginServiceImpl implements IPOSAdminLoginService{

	@Autowired
	private IMultiTableDao multiTableDao;
	public void setMultiTableDao(@Qualifier(Annotations.DAO_MULTITABLE)IMultiTableDao multiTableDao) {
		this.multiTableDao = multiTableDao;
	}
	@Autowired
	private IOperInfoDao operInfoDao;
	public void setOperInfoDao(@Qualifier(Annotations.DAO_OPERINFO)IOperInfoDao operInfoDao) {
		this.operInfoDao = operInfoDao;
	}

	public LoginUser getLoginUser(Map<String,Object> params) {
		return multiTableDao.getLoginUser(params);
	}
	
	public boolean closeOper(OperInfo operInfo) throws BusinessException {
		try {
			operInfo.setState(1);
			boolean result = operInfoDao.update(operInfo);
			if(result){//开启商户解锁的线程
				
			}
			return true;
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
	public boolean updatErrorCount(OperInfo operInfo) throws BusinessException {
		try {
			return operInfoDao.update(operInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}
	@Autowired
	private IMenuDao menuDao;
	public void setMenuDao(@Qualifier(Annotations.DAO_MENU)IMenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<Menu> getFirstMenuList(LoginUser loginUser)
			throws BusinessException {
		//得到操作员的一级菜单列表
		List<Menu> userMenuList = new ArrayList<Menu>();
		try {
			Menu param = new Menu();
			param.setMenuLevel(1);
			List<Menu> allMenuList = menuDao.selectFirstMenuList();
			String userAuth = loginUser.getAuth();//得到操作员权限列表
			
			for (Menu menu : allMenuList) {
				//判断操作员是否有的权限
				if(hasThisAuth(userAuth, menu.getId())){
					userMenuList.add(menu);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userMenuList;
	}
	public List<Menu> getChildrenMenuList(LoginUser loginUser,int firstMenuId)throws BusinessException {
		try {
			if(hasThisAuth(loginUser.getAuth(), firstMenuId)){
				List<Menu> treeMenus = new ArrayList<Menu>();
				//查询二级菜单
				List<Menu> secondMenus = menuDao.selectSecondMenuList(firstMenuId);
				for(Menu second:secondMenus){
					if(hasThisAuth(loginUser.getAuth(), second.getMenuId())){
						treeMenus.add(second);
						//查询三级菜单
						List<Menu> thirdMenus = menuDao.selectThirdMenuList(second.getMenuId());
						for(Menu third:thirdMenus){
							if(hasThisAuth(loginUser.getAuth(), third.getMenuId())){
								treeMenus.add(third);
							}
						}
					}
					return treeMenus;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}
		return null;
	}
	
	private static boolean hasThisAuth(String auth, int authIndex) {
		try {
			return auth.charAt(authIndex) == '1';
		} catch (Exception e) {
			return false;
		}
		
	}
}
