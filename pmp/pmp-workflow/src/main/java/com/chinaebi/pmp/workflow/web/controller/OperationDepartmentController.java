package com.chinaebi.pmp.workflow.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.database.entity.MerInfo;
import com.chinaebi.pmp.workflow.service.impl.MerchantWorkFlowService;


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
	private MerchantWorkFlowService addMerchantWorkFlowService;
	
	/**
	 * 商户查询初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/operationMerInfoQueryPre.do")
    public String operationMerInfoQueryPre() {
        return prefix+"operation_merinfo_query_pre";
    }
	
	/**
	 * 商户查询初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/operationAddMerInfoPre.do")
    public String operationAddMerInfoPre() {
        return prefix+"operation_merinfo_add_pre";
    }
	
	
	/**
	 * 商户资料提交初始页面
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
	public Response fillMerchantInfo(
			MerInfo merInfo,
			@RequestParam("askForTermJson") String askForTermJson,
			@RequestParam(value = "merchantAttachment") MultipartFile merchantAttachment)
			throws Exception {
		addMerchantWorkFlowService.startWorkFlow(merInfo, askForTermJson,merchantAttachment);
		return new Response("00", "商户信息提交成功");
	}
}
