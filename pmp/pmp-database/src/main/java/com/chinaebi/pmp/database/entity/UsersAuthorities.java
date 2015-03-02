package com.chinaebi.pmp.database.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class UsersAuthorities implements Serializable {

	private static final long serialVersionUID = 6844447583057119924L;
	private BigInteger id;/* 对应表中id */
	private BigInteger userId;/* 对应表中user_id */
	private int menuId;/* 对应表中menu_id */

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
}
