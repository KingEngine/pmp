/*********************************************************************
 * 
 * Copyright (C) 2011, Shanghai Chinaebi
 * All rights reserved.
 * http://www.chinaebi.com.cn/
 * 
 *********************************************************************/
package com.chinaebi.pmp.common.constant;

import java.util.ArrayList;
import java.util.List;

import com.chinaebi.pmp.common.entity.BalanceAccountType;
import com.chinaebi.pmp.common.entity.CertificateType;
import com.chinaebi.pmp.common.entity.CompanyType;
import com.chinaebi.pmp.common.entity.MerchantTradeType;
import com.chinaebi.pmp.common.entity.MerchantType;
import com.chinaebi.pmp.common.entity.TradeStatus;

/**
 * 全局字典说明
 * @author king
 * 2014-10-15
 */
public class Constants {
	/**
	 * 交易状态
	 */
	public final static List<TradeStatus> TRADE_STATUS = new ArrayList<TradeStatus>();
	/**
	 * 商户类型
	 */
	public final static List<MerchantType> MERCHANT_TYPE = new ArrayList<MerchantType>();
	/**
	 * 公司类型
	 */
	public final static List<CompanyType> COMPANY_TYPE = new ArrayList<CompanyType>();
	/**
	 * 证件类型
	 */
	public final static List<CertificateType> CERTIFICATE_TYPE = new ArrayList<CertificateType>();
	/**
	 * 结算周期类型
	 */
	public final static List<BalanceAccountType> BALANCEACCOUNT_TYPE = new ArrayList<BalanceAccountType>();
	/**
	 * 商户行业类型
	 */
	public final static List<MerchantTradeType> MERCHANTTRADE_TYPE = new ArrayList<MerchantTradeType>();
	
	static{
		//交易状态
		TRADE_STATUS.add(new TradeStatus("","全部"));
		TRADE_STATUS.add(new TradeStatus("0","成功"));
		TRADE_STATUS.add(new TradeStatus("1","失败"));
		TRADE_STATUS.add(new TradeStatus("2","待处理"));
		//商户类型
		MERCHANT_TYPE.add(new MerchantType("1", "企业"));
		MERCHANT_TYPE.add(new MerchantType("2", "个体工商户"));
		//公司类型
		COMPANY_TYPE.add(new CompanyType("110","国有企业"));
		COMPANY_TYPE.add(new CompanyType("120","集体企业"));
		COMPANY_TYPE.add(new CompanyType("130","股份合作企业"));
		COMPANY_TYPE.add(new CompanyType("140","联营企业"));
		COMPANY_TYPE.add(new CompanyType("150","有限责任公司"));
		COMPANY_TYPE.add(new CompanyType("160","股份有限公司"));
		COMPANY_TYPE.add(new CompanyType("170","私营企业"));
		COMPANY_TYPE.add(new CompanyType("200","港、澳、台商投资企业"));
		COMPANY_TYPE.add(new CompanyType("300","外商投资企业"));
		COMPANY_TYPE.add(new CompanyType("400","个体经营"));
		//证件类型
		CERTIFICATE_TYPE.add(new CertificateType("01","营业执照"));
		CERTIFICATE_TYPE.add(new CertificateType("02","事业单位登记证"));
		CERTIFICATE_TYPE.add(new CertificateType("03","社会团体登记证"));
		CERTIFICATE_TYPE.add(new CertificateType("04","民办非企业登记证"));
		CERTIFICATE_TYPE.add(new CertificateType("05","外地常设机构登记证"));
		CERTIFICATE_TYPE.add(new CertificateType("06","军队开户许可证"));
		CERTIFICATE_TYPE.add(new CertificateType("07","批文"));
		CERTIFICATE_TYPE.add(new CertificateType("08","外汇账户核准件"));
		CERTIFICATE_TYPE.add(new CertificateType("09","证明"));
		CERTIFICATE_TYPE.add(new CertificateType("10","开户许可证"));
		CERTIFICATE_TYPE.add(new CertificateType("15","居民身份证"));
		CERTIFICATE_TYPE.add(new CertificateType("16","临时身份证"));
		CERTIFICATE_TYPE.add(new CertificateType("17","军人身份证件"));
		CERTIFICATE_TYPE.add(new CertificateType("18","武警身份证件"));
		CERTIFICATE_TYPE.add(new CertificateType("19","通行证"));
		CERTIFICATE_TYPE.add(new CertificateType("20","护照"));
		CERTIFICATE_TYPE.add(new CertificateType("21","其他"));
		CERTIFICATE_TYPE.add(new CertificateType("22","临时户口"));
		CERTIFICATE_TYPE.add(new CertificateType("23","户口簿"));
		CERTIFICATE_TYPE.add(new CertificateType("24","边境证"));
		//结算类型
		BALANCEACCOUNT_TYPE.add(new BalanceAccountType("1", "T+1"));
		//商户所属行业
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("99", "通讯"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("100", "航空机票"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("101", "酒店/旅游"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("102", "服务/缴费"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("103", "综合商城"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("104", "金融/保险"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("105", "虚拟/游戏"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("106", "医药/保健"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("107", "教育/招生"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("108", "交友/咨询"));
		MERCHANTTRADE_TYPE.add(new MerchantTradeType("109", "其他"));
	}
	
	public final static String ADDMERCHANT_WORKFLOW_INSTANCE="addMerchant";//增机实例
}
