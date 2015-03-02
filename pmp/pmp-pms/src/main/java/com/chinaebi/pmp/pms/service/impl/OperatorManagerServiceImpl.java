package com.chinaebi.pmp.pms.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.Constants;
import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.dao.IMenuDao;
import com.chinaebi.pmp.database.dao.IUsersAuthoritiesDao;
import com.chinaebi.pmp.database.dao.IUsersDao;
import com.chinaebi.pmp.database.entity.Menu;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;
import com.chinaebi.pmp.database.entity.UsersAuthorities;
import com.chinaebi.pmp.pms.service.IOperatorManagerService;

@Component
public class OperatorManagerServiceImpl implements IOperatorManagerService{
	
	@Autowired
	@Qualifier(Annotations.DAO_USERS)
	private IUsersDao usersDao;//users表数据操作
	@Autowired
	@Qualifier(Annotations.DAO_MENU)
	private IMenuDao menuDao;//users表数据操作
	
	private IdentityService identityService;
	@Autowired
	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}
	@Autowired
	@Qualifier(Annotations.DAO_USERSAUTHORITIES)
	private IUsersAuthoritiesDao usersAuthoritiesDao;

	public Page<Users> queryOperatorsForPage(Page<Users> page,Users param) {
		
		return usersDao.selectPage(page, param);
	}

	public Response addOperator(Users user) {
		
		boolean result =  usersDao.insert(user);
		if(result){
			return new Response("00","插入操作员成功");
		}
		return new Response("01","插入操作员失败");
	}
	
	public List<Map<String, Object>> getOperatorAuthroities(String userName,String menuType) {
		//得到所有的一级菜单
		Menu firstMenu = new Menu();
		firstMenu.setMenuLevel(1);
		firstMenu.setMenuType(menuType);
		List<Menu> firstMenus = menuDao.selectList(firstMenu);
		List<Map<String, Object>> menuTree = new ArrayList<Map<String,Object>>();
		List<Menu> userFirstMenus = null;//用户的所有一级菜单
		try {
			userFirstMenus = menuDao.selectFirstMenuList(userName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//得到管理员的一级菜单
		for (Menu first : firstMenus) {
			Map<String, Object> firstTree = new HashMap<String, Object>();
			firstTree.put("id", first.getMenuId());
			firstTree.put("text", first.getMenuName());
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("department", first.getMenuDepartment());
			firstTree.put("attributes", attributes);
			//判断第一节点是否被选中
			for (Menu userFirst : userFirstMenus) {
				if (first.getMenuId() == userFirst.getMenuId()) {
					firstTree.put("checked", "checked");
				}
			}
			//得到所有的二级菜单
			Menu secondMenuParam = new Menu();
			secondMenuParam.setMenuLevel(2);
			secondMenuParam.setParentMenuId(first.getMenuId());
			List<Menu> secondMenus = menuDao.selectList(secondMenuParam);
			List<Map<String, Object>> secondMenuTree = new ArrayList<Map<String,Object>>();
			for(Menu second : secondMenus){
				Map<String, Object> secondTree = new HashMap<String, Object>();
				secondTree.put("id",second.getMenuId());
				secondTree.put("text", second.getMenuName());
				//判断二级级点是否被选中
				List<Menu> userSecondMenus = null;//用户的所有一级菜单
				try {
					userSecondMenus = menuDao.selectSecondMenuList(userName, first.getMenuId());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				for (Menu userSecond : userSecondMenus) {
					if (second.getMenuId() == userSecond.getMenuId()) {
						secondTree.put("checked", "checked");
					}
				}
				//得到所有三级菜单
				Menu thirdMenuParam = new Menu();
				thirdMenuParam.setMenuLevel(3);
				thirdMenuParam.setParentMenuId(second.getMenuId());
				List<Menu> thirdMenus = menuDao.selectList(thirdMenuParam);
				List<Map<String, Object>> thirdMenuTree = new ArrayList<Map<String,Object>>();
				for(Menu third : thirdMenus){
					Map<String, Object> thirdTree = new HashMap<String, Object>();
					thirdTree.put("id",third.getMenuId());
					thirdTree.put("text", third.getMenuName());
					thirdMenuTree.add(thirdTree);
					//判断三级是否被选中
					List<Menu> userThirdMenus = null;//用户的所有一级菜单
					try {
						userThirdMenus = menuDao.selectThirdMenuList(userName, second.getMenuId());
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					for (Menu userThird : userThirdMenus) {
						if (third.getMenuId() == userThird.getMenuId()) {
							thirdTree.put("checked", "checked");
						}
					}
				}
				secondTree.put("children", thirdMenuTree);
				secondMenuTree.add(secondTree);
			}
			firstTree.put("children", secondMenuTree);
			menuTree.add(firstTree);
		}
		return menuTree;
	}
	public String getUserNameByUserId(BigInteger userId) {
		Users user =  new Users();
		user.setId(userId);
		try {
			user = usersDao.selectOne(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotBlank(user.getUserName())){
			return user.getUserName();
		}
		return null;
	}
	public BigInteger getUserIdByUserName(String userName) {
		Users user =  new Users();
		user.setUserName(userName);
		try {
			user = usersDao.selectOne(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotBlank(user.getUserName())){
			return user.getId();
		}
		return null;
	}
	
	//TODO 需要添加事务
	//@Transactional(rollbackFor=Exception.class)
	public boolean modifyOperatorAuthorities(String workFlowMenusJson,String mmsMenusJson, String userName) {
		List<Menu> workFlowMenus = generateMenuListFromJson(workFlowMenusJson,"workFlowMenus");
		List<Menu> mmsMenus = generateMenuListFromJson(mmsMenusJson, "mmsMenus");
		// 删除平台所有权限
		usersAuthoritiesDao.delete(userName);
		// 删除工作流权限
		identityService.deleteUser(userName);;
		// 判断是否有工作流权限
		//添加用户到activiti
		BigInteger userId = getUserIdByUserName(userName);
		List<UsersAuthorities> authorities = new ArrayList<UsersAuthorities>();
		//添加工作流权限
		if (null != workFlowMenus && workFlowMenus.size() > 0) {
			for (Menu menu : workFlowMenus) {
				if(StringUtils.isNotBlank(menu.getMenuDepartment())){
					if(Constants.ACTIVITI_ROLE.contains(menu.getMenuDepartment())){
						//判断用户是否存在
						List<User> activitiUser = identityService.createUserQuery().userId(userName).list();
						if(null==activitiUser || activitiUser.size()<1){
							//添加用户
							identityService.saveUser(new UserEntity(userName));
						}
						identityService.createMembership(userName, menu.getMenuDepartment());;
					}
				}
				UsersAuthorities authority = new UsersAuthorities();
				authority.setUserId(userId);
				authority.setMenuId(menu.getMenuId());
				authorities.add(authority);
			}
		}
		//添加管理平台权限
		if (null != mmsMenus && mmsMenus.size() > 0) {
			for (Menu menu : mmsMenus) {
				UsersAuthorities authority = new UsersAuthorities();
				authority.setUserId(userId);
				authority.setMenuId(menu.getMenuId());
				authorities.add(authority);
			}
		}
		if(authorities.size()>0){
			usersAuthoritiesDao.insert(authorities);
		}
		return true;
	}
	
	private List<Menu> generateMenuListFromJson(String json,String jsonHeader){
		JSONObject workFlowMenusJsonObject =JSONObject.fromObject(json);
		JSONArray workFlowMenusArray = workFlowMenusJsonObject.getJSONArray(jsonHeader);
		List<Menu> workFlowMenus = new ArrayList<Menu>();
		for (int i = 0; i < workFlowMenusArray.size(); i++) {
			JSONObject object = (JSONObject) workFlowMenusArray.get(i);
			Menu workFlowMenu = (Menu) JSONObject.toBean(object, Menu.class);
			if(null!=workFlowMenu){
				workFlowMenus.add(workFlowMenu);
			}
		}
		return workFlowMenus;
	}
}
