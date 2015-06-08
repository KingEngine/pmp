package com.chinaebi.pmp.workflow.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaebi.pmp.workflow.service.impl.MerchantWorkFlowService;

@Controller
public class BusinessDepartmentController {

	private final static String prefix="workflow/BusinessDepartment/";
	@Autowired
	private MerchantWorkFlowService addMerchantWorkFlowService;
	/**
	 * 商户查询初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/businessMerInfoQueryPre.do")
    public String riskMerInfoQueryPre() {
        return prefix+"business_merinfo_query_pre";
    }
	/**
	 * 任务办理初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/businessTaskHandlePre.do")
    public String riskTaskHandlePre() {
        return prefix+"business_task_handler_pre";
    }
}
