package com.chinaebi.pmp.service;

import java.util.List;

import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.entity.Menu;

public interface ILoginService {
	
	public List<Menu> getUsersFirstMenuList(String userName) throws BusinessException;

}
