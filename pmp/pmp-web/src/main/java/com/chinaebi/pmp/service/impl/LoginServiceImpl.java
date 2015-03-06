package com.chinaebi.pmp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.exception.DaoException;
import com.chinaebi.pmp.database.dao.IMenuDao;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.service.ILoginService;



@Service(Annotations.SERVICE_LOGIN)
public class LoginServiceImpl implements ILoginService{

	@Autowired
	@Qualifier(Annotations.DAO_MENU)
	private IMenuDao menuDao;
	public List<Menu> getUsersFirstMenus(String userName) throws BusinessException {
		 try {
			return menuDao.selectFirstMenuList(userName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("");
		}
	}
	public List<Menu> getUsersChildMenus(String userName,Integer firstMenuId) throws BusinessException {
		//查询二级菜单
		List<Menu> treeMenus = new ArrayList<Menu>();
		try {
			List<Menu> secondMenus = menuDao.selectSecondMenuList(userName, firstMenuId);
			for(Menu secondMenu: secondMenus){
				treeMenus.add(secondMenu);
				//得到三级菜单
				List<Menu> thirdMenus = menuDao.selectThirdMenuList(userName,secondMenu.getMenuId());
				for(Menu thirdMenu :thirdMenus){
					treeMenus.add(thirdMenu);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeMenus;
	}
}
