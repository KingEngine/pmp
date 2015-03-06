package com.chinaebi.pmp.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 业务帮助类
 * 
 * @author king 2015年3月4日
 */
public class BusinessUtil {
	/**
	 * 使用商户id + 到毫秒级的时间 组装批次号
	 * 
	 * @param mid
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getTermBatchId(Integer mid) {
		return mid + new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date());
	}
	// 添加组任务
			// 风控
			/*
			 * identityService.saveGroup(new GroupEntity("RISK_DEPARTMENT"));
			 * identityService.saveUser(new UserEntity("risk"));
			 * identityService.createMembership("risk","RISK_DEPARTMENT"); //运行
			 * identityService.saveGroup(new GroupEntity("OPERATION_DEPARTMENT"));
			 * identityService.saveUser(new UserEntity("operation"));
			 * identityService.createMembership("operation","OPERATION_DEPARTMENT");
			 * //业管 identityService.saveGroup(new
			 * GroupEntity("BUSINESS_DEAPARTMENT")); identityService.saveUser(new
			 * UserEntity("business"));
			 * identityService.createMembership("business","BUSINESS_DEAPARTMENT");
			 */
}
