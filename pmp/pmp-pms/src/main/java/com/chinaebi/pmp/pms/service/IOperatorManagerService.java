package com.chinaebi.pmp.pms.service;


import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;

public interface IOperatorManagerService {
	
	public Page<Users> queryOperatorsForPage(Page<Users> page,Users users);
	
	public Response addOperator(Users user);

}
