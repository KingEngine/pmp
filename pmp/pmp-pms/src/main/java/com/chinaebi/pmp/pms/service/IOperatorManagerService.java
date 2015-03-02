package com.chinaebi.pmp.pms.service;


import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;

public interface IOperatorManagerService {
	
	public Page<Users> queryOperatorsForPage(Page<Users> page,Users users);
	
	public Response addOperator(Users user);
	
	public List<Map<String,Object>> getOperatorAuthroities(String userName,String menuType);
	
	public String getUserNameByUserId(BigInteger userId);
	
	public BigInteger getUserIdByUserName(String userName);
	
	public boolean modifyOperatorAuthorities(String workFlowMenusJson,String mmsMenusJson,String userName);
	
	

}
