package com.chinaebi.pmp.database.entity;

/**
 * 对应表 menu
 * 
 * @author king
 *
 */
public class Menu implements java.io.Serializable {
	private static final long serialVersionUID = -3251360082245722153L;
	private int id;/* 对应表中id */
	private int menuId;/* 对应表中menu_id */
	private String menuName;/* 对应表中menu_name */
	private String menuUrl;/* 对应表中menu_url */
	private int menuLevel;/* 对应表中menu_level */
	private int parentMenuId;/* 对应表中parent_menu_id */
	private int menuStatus;/* 对应表中menu_status */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public int getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public int getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(int menuStatus) {
		this.menuStatus = menuStatus;
	}
}
