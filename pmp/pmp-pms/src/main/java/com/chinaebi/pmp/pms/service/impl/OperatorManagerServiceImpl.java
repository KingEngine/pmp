package com.chinaebi.pmp.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;
import com.chinaebi.pmp.pms.service.IOperatorManagerService;

@Component
public class OperatorManagerServiceImpl implements IOperatorManagerService{
	
	@Autowired
	@Qualifier(Annotations.DAO_USERS)
	private IUsersDao usersDao;//users表数据操作

	public Page<Users> queryOperatorsForPage(Page<Users> page,Users param) {
		
		return usersDao.selectPage(page, param);
	}

	public Response addOperator(Users user) {
		
		boolean result =  usersDao.insert(user);
		if(result){
			return new Response("00","插入操作员成功");
		}
		return new Response("01","插入操作员失败");
	}
}
