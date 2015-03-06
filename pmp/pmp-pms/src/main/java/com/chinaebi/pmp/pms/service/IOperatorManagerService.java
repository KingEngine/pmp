package com.chinaebi.pmp.pms.service;


import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;

public interface IOperatorManagerService {
	
	public Page<Users> queryOperatorsForPage(Page<Users> page,Users users)throws BusinessException;
	
	public Response addOperator(Users user)throws BusinessException;
	
	public List<Map<String,Object>> getOperatorAuthroities(String userName,String menuType)throws BusinessException;
	
	public String getUserNameByUserId(BigInteger userId)throws BusinessException;
	
	public BigInteger getUserIdByUserName(String userName)throws BusinessException;
	
	public boolean modifyOperatorAuthorities(String workFlowMenusJson,String mmsMenusJson,String userName)throws BusinessException;
	
	

}
