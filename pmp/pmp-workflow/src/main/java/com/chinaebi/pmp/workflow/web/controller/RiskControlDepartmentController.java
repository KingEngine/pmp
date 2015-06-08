package com.chinaebi.pmp.workflow.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.database.entity.MerRiskConfig;
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
	@RequestMapping(value = "/**/riskMerchantQualificationVerifyPre.do")
    public String riskTaskHandlePre(@RequestParam("taskId") String taskId,
    		Model model) {
		try {
			//通过taskId得到taskName
			
			//根据taksname决定需要的操作
			
			
			Map<String,Object> attributes = addMerchantWorkFlowService.getMerInfoFromTaskId(taskId);
			model.addAllAttributes(attributes);
		} catch (BusinessException e) {
			
		}
        return prefix+"risk_merchant_qualification_verify_pre";
    }
	/**
	 * 设置商户风控信息
	 * @param taskId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/**/setMerchantRiskInfo.do")
    public String setMerchantRiskInfo(@RequestParam("taskId") String taskId,//任务id
    		@RequestParam("suggestion")String suggestion,//审核意见
    		@RequestParam("merRiskType") int merRiskType,//商户风险级别
    		MerRiskConfig merRiskConfig,//商户风控信息
    		Model model) {
		System.out.println(merRiskConfig.getCardType());
        return prefix+"risk_merchant_qualification_verify_pre";
    }
	
}
