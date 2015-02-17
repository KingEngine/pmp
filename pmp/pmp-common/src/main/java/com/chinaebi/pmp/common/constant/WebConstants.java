package com.chinaebi.pmp.common.constant;

public class WebConstants {
	
	/** 当前登录用户 */
	public static final String SESSION_LOGGED_ON_USER = "SESSION_LOGGED_ON_USER";

	/** 当前登录用户mid */
	public static final String SESSION_LOGGED_ON_MID = "SESSION_LOGGED_ON_MID";
	
	public static final String SESSION_LOGGED_ON_INNERMERCODE = "SESSION_LOGGED_ON_INNERMERCODE";
	
	public static final String LEFT_MENU_LIST = "left_menu_list";
	
	public static final String FIRST_MENUS = "firstMenus";
	
	/**允许用户登录密码连续输入失败的次数 */
	public static final int ALLOW_ERR_LOGIN_PWD_COUNT = 3;
	
	/**用户密码的有效期（天） */
	public static final int USER_PWD_PERIOD = 90;
	
	public static final String RAND="rand";
	/**
	 * 分页请求页号
	 */
	public final static String PAGE_OFFET="pageOffset";
	/**
	 * 一页返回行数
	 */
	public final static String ROWS="rows";
}
