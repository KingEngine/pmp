package com.chinaebi.pmp.pms.web.controller;


import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.database.entity.Users;
import com.chinaebi.pmp.pms.service.IOperatorManagerService;


@Controller
public class OperatorManagerController {
	
	private final static String prefix="mms/OperatorManager/";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IOperatorManagerService operatorManagerService;
	
	@RequestMapping(value="/**/managerOperationPre.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getOperatorManagerPre(){
		return prefix+"operator_manager_pre";
	}
	
	@RequestMapping(value="/**/queryOperatorsForPage.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Page<Users> queryOperatorsForPage(HttpServletRequest request,Users users){
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<Users> page = new Page<Users>();
		if(StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if(StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else 
			page.setPageSize(10);
		return operatorManagerService.queryOperatorsForPage(page, users);
	}
	
	@RequestMapping(value="/**/getOperatorAddPre.do",method={RequestMethod.GET,RequestMethod.POST})
	public String getOperatorAddPre(){
		return prefix+"operator_add_pre";
	}
	@RequestMapping(value="/**/addOperator.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response addOperator(Users user){
		return operatorManagerService.addOperator(user);
	}
}
