package com.chinaebi.pmp.workflow.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaebi.pmp.workflow.service.impl.MerchantWorkFlowService;


@Controller
public class RiskControlDepartmentController {
	
	private final static String prefix="workflow/RiskControlDepartment/";
	@Autowired
	private MerchantWorkFlowService addMerchantWorkFlowService;
	/**
	 * 商户查询初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/riskMerInfoQueryPre.do")
    public String riskMerInfoQueryPre() {
        return prefix+"risk_merinfo_query_pre";
    }
	/**
	 * 任务办理初始页面
	 * @return
	 */
	@RequestMapping(value = "/**/riskTaskHandlePre.do")
    public String riskTaskHandlePre() {
        return prefix+"risk_task_handler_pre";
    }

}
