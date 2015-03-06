package com.chinaebi.pmp.workflow.service;


/**
 * 商户添加接口服务
 * 
 * @author king
 * 2015年2月16日
 */
public interface IMerchantService {
	
	/**
	 * 检查商户名称唯一性
	 */
	public void validateMerchantNameUnique();

}
