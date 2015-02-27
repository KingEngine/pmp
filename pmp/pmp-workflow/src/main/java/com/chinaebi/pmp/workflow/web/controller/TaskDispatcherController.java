package com.chinaebi.pmp.workflow.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.entity.Response;
import com.chinaebi.pmp.workflow.service.impl.AddMerchantWorkFlowService;


/**
 * 任务分发控制器
 * 
 * @author king
 * 2015年2月23日
 */
@Controller
public class TaskDispatcherController {
	@Autowired
	private AddMerchantWorkFlowService addMerchantWorkFlowService;
	
	@RequestMapping(value = "dispatcherTask.do")
	public String dispatcherTask(@RequestParam("taskId") String taskId,
			Model model
			) {
		// 获取任务节点名称
		String taskName = addMerchantWorkFlowService.getTaskNameByTaskId(taskId);
		model.addAttribute("taskId",taskId);
		//查询参数
		//返回资质审核页面
		return "workflow/RiskControlDepartment/merchant_qualification_verify_pre";
		
	}
	@RequestMapping(value = "handler.do")
	@ResponseBody
	public Response handlerTask(@RequestParam("taskId") String taskId,@RequestParam("suggestion") String suggestion) {
		return addMerchantWorkFlowService.completeTask(taskId,suggestion);
	}
}
