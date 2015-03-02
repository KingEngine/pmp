package com.chinaebi.pmp.database.dao.impl;

import java.util.List;

import com.chinaebi.pmp.database.dao.IUsersAuthoritiesDao;
import com.chinaebi.pmp.database.entity.UsersAuthorities;

public class UsersAuthoritiesDaoImpl extends CommonDaoImpl<UsersAuthorities> implements IUsersAuthoritiesDao{

	public boolean delete(String userName) {
		int counter = this.getSqlSession().delete("UsersAuthoritiesManager.delete", userName);
		if(counter>1){
			return true;
		}
		return false;
	}

	public boolean insert(List<UsersAuthorities> authorities) {
		int counter = this.getSqlSession().delete("UsersAuthoritiesManager.insert", authorities);
		return true;
	}

}
