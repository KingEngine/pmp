package com.chinaebi.pmp.workflow.web.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.workflow.service.impl.AddMerchantWorkFlowService;


/**
 * 运行部门操作
 *  
 * @author king 
 * 2015年2月10日
 */
@Controller
public class OperationDepartmentController {
	private final static String prefix="workflow/OperationDepartment/";
	@Autowired
	private AddMerchantWorkFlowService addMerchantWorkFlowService;
	
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
	 * @throws Exception 
	 */
	@RequestMapping(value = "/**/fillMerchantInfo.do")
	@ResponseBody
    public Response fillMerchantInfo(MerInfo merInfo) throws Exception {
		merInfo.setLastBatch(new BigInteger("1"));
		addMerchantWorkFlowService.startWorkFlow(merInfo);;
		//启动工作流流程
       return new Response("00", "商户信息提交成功");
    }
}
