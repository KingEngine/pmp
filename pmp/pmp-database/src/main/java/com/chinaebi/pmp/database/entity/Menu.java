package com.chinaebi.pmp.database.entity;

/**
 * 对应表 menu
 * 
 * @author king
 * 
 */
public class Menu implements java.io.Serializable {

	private static final long serialVersionUID = -8179049493655869273L;
	private int id;/* 对应表中id */
	private int menuId;/* 对应表中menu_id */
	private String menuName;/* 对应表中menu_name */
	private String requestUrl;/* 对应表中request_url */
	private int parentId;/* 对应表中parent_id */
	private int menuLevel;/* 对应表中menu_level */

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

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
}
