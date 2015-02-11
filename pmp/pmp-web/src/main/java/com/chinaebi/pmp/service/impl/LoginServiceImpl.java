package com.chinaebi.pmp.service.impl;

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
	public List<Menu> getUsersFirstMenuList(String userName) throws BusinessException {
		 try {
			return menuDao.selectList(userName);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}
}
