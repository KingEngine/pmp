package com.chinaebi.pmp.workflow.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.constant.WebConstants;
import com.chinaebi.pmp.database.entity.Page;
import com.chinaebi.pmp.workflow.entity.MerInfoWorkFlowEntity;
import com.chinaebi.pmp.workflow.entity.WorkFlowEntity;
import com.chinaebi.pmp.workflow.service.impl.MerchantWorkFlowService;


/**
 * 工作流通用方法
 * 
 * @author king
 * 2015年2月17日
 */
@Controller
public class WorkFlowCommonController {
	
	private final static String prefix="workflow/";
	
	@Autowired
	private MerchantWorkFlowService merchantWorkFlowService;
	
	
	/**
	 * 任务查询列表初始页面
	 */
	@RequestMapping(value = "/**/workFlowTaskQueryPre.do")
    public String workFlowTaskQueryPre() {
        return prefix+"workflow_task_query_pre";
    }
	/**
	 * 商户信息查看
	 */
	@RequestMapping(value = "/**/merInfoQueryPre.do")
    public String merInfoQueryPre() {
        return prefix+"merinfo_query_pre";
    }
	/**
	 * 查询需要处理的列表
	 */
	@RequestMapping(value = "/**/workFlowTaskQueryList.do")
	@ResponseBody
	public Page<WorkFlowEntity> workFlowTaskQueryList(HttpServletRequest request,
			HttpServletResponse response) {
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<WorkFlowEntity> page = new Page<WorkFlowEntity>();
		if (StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if (StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else
			page.setPageSize(10);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return merchantWorkFlowService.queryRunningInstancesForPage(page,userName);
	}
	@RequestMapping(value = "/**/showProcessImage.do")
	public String showProcessImage(@RequestParam("taskId")String taskId,Model model) {
		model.addAttribute("taskId", taskId);
		model.addAttribute("acs", merchantWorkFlowService.findCoordinateByTaskId(taskId));
		return prefix+"process_image";
	}
	@RequestMapping(value = "/**/showProcessDefintionImage.do")
	public void showProcessDefintionImage(
			@RequestParam("taskId") String taskId, Model model,
			HttpServletResponse response) throws IOException {
		InputStream resourceAsStream = merchantWorkFlowService.queryProcessDefinitionByTaskId(taskId);
		ServletOutputStream responseOutputStream = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			responseOutputStream.write(b, 0, len);
		}
		responseOutputStream.flush();
		responseOutputStream.close();
	}
	
	/**
	 * 查询商户信息
	 */
	@RequestMapping(value = "/**/queryMerInfoForPage.do")
	@ResponseBody
	public Page<MerInfoWorkFlowEntity> queryMerInfoForPage(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="name",required=false)String name,
			@RequestParam(value="innerMercode",required=false)String innerMercode,
			@RequestParam(value="merType",required=false)String merType
			) {
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<MerInfoWorkFlowEntity> page = new Page<MerInfoWorkFlowEntity>();
		if (StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if (StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else
			page.setPageSize(10);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name",name);
		params.put("innerMercode",innerMercode );
		params.put("merType", merType);
		return merchantWorkFlowService.queryMerInfoForPage(page,params);
	}
	
	@RequestMapping(value = "/**/queryMerInfoWithWorkFlowForPage.do")
	@ResponseBody
	public Page<Map<String, Object>> queryMerInfoWithWorkFlowForPage(
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="name",required=false)String name,
			@RequestParam(value="innerMercode",required=false)String innerMercode,
			@RequestParam(value="merType",required=false)String merType) {
		String curPage = request.getParameter(WebConstants.PAGE_NUMBER);
		String pageSize = request.getParameter(WebConstants.ROWS);
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		if (StringUtils.isNotBlank(curPage))
			page.setPageNo(Integer.parseInt(curPage.trim()));
		if (StringUtils.isNotBlank(pageSize))
			page.setPageSize(Integer.parseInt(pageSize.trim()));
		else
			page.setPageSize(10);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name",name);
		params.put("innerMercode",innerMercode );
		params.put("merType", merType);
		return merchantWorkFlowService.queryMerInfoWithFlowForPage(page, params);
	}
	
}
