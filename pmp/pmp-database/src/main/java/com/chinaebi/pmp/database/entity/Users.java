/*********************************************************************
 * 
 * Copyright (C) 2015, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.database.entity;
import java.math.BigInteger;
import java.util.Date;
/**
 * 对应表 users
 * @author king
 */
public class Users implements java.io.Serializable{
	private static final long serialVersionUID = 8413282965095153489L;
	private BigInteger id;/* 对应表中id */
	private String userName;/* 对应表中user_name */
	private String userPassword;/* 对应表中user_password */
	private String roleType;/* 对应表中role_type */
	private String status;/* 对应表中status */
	private Date lastLoginTime;/* 对应表中last_login_time */
    public BigInteger getId(){  
      return id;  
    }  
    public void setId(BigInteger id){  
      this.id = id;  
    }  
    public String getUserName(){  
      return userName;  
    }  
    public void setUserName(String userName){  
      this.userName = userName;  
    }  
    public String getUserPassword(){  
      return userPassword;  
    }  
    public void setUserPassword(String userPassword){  
      this.userPassword = userPassword;  
    }  
    public String getRoleType(){  
      return roleType;  
    }  
    public void setRoleType(String roleType){  
      this.roleType = roleType;  
    }  
    public String getStatus(){  
      return status;  
    }  
    public void setStatus(String status){  
      this.status = status;  
    }  
    public Date getLastLoginTime(){  
      return lastLoginTime;  
    }  
    public void setLastLoginTime(Date lastLoginTime){  
      this.lastLoginTime = lastLoginTime;  
    }  
}


