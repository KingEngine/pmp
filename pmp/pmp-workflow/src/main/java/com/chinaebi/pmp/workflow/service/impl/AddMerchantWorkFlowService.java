package com.chinaebi.pmp.workflow.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstanceQuery;

import com.chinaebi.pmp.common.constant.Constants;
import com.chinaebi.pmp.database.entity.MerInfo;

public class AddMerchantWorkFlowService {
	
	private RuntimeService runtimeService;
	
	
	
	/**
	 * 开始流程
	 */
	public void startWorkFlow(MerInfo merInfo){
		//将数据保存到mer_info表中
		
		String businessKey = merInfo.getMid()+"";
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("merInfo",merInfo);
		runtimeService.startProcessInstanceByKey(Constants.ADDMERCHANT_WORKFLOW_INSTANCE, businessKey, variables);
	}
	
	//分页查询运行中的实例
	public void queryRunningInstancesForPage(){
		ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey(Constants.ADDMERCHANT_WORKFLOW_INSTANCE).active().orderByProcessInstanceId().desc();
		query.listPage(1, 10);
	}

}
