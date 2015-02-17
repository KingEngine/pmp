package com.chinaebi.pmp.workflow.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaebi.pmp.database.entity.MerInfo;


/**
 * 运行部门操作
 *  
 * @author king 
 * 2015年2月10日
 */
@Controller
public class OperationDepartmentController {
	private final static String prefix="workflow/OperationDepartment/";
	/**
	 * 商户资料添加初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/fillMerchantInfoPre.do")
    public String fillMerchantInfoPre() {
        return prefix+"fill_merchantInfo_pre";
    }
	/**
	 * 商户资料录入提交
	 * @return
	 */
	@RequestMapping(value = "/**/fillMerchantInfo.do")
    public String fillMerchantInfo(MerInfo merInfo) {
		//将数据保存到mer_info表中
		
		//启动工作流流程
		
        return prefix+"fill_merchantInfo_pre";
    }
	
	

}
