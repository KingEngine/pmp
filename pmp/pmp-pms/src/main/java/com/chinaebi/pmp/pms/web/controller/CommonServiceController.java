package com.chinaebi.pmp.pms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.common.constant.Constants;
import com.chinaebi.pmp.common.entity.BalanceAccountType;
import com.chinaebi.pmp.common.entity.CertificateType;
import com.chinaebi.pmp.common.entity.CompanyType;
import com.chinaebi.pmp.common.entity.MerchantRiskLevel;
import com.chinaebi.pmp.common.entity.MerchantStatus;
import com.chinaebi.pmp.common.entity.MerchantTradeType;
import com.chinaebi.pmp.common.entity.MerchantType;
import com.chinaebi.pmp.common.entity.OperatorRoleType;
import com.chinaebi.pmp.common.entity.OperatorStatus;
import com.chinaebi.pmp.common.entity.TerminalMode;
import com.chinaebi.pmp.common.entity.TerminalType;
import com.chinaebi.pmp.common.entity.TradeStatus;
import com.chinaebi.pmp.common.exception.BusinessException;
import com.chinaebi.pmp.common.exception.WebException;
import com.chinaebi.pmp.database.entity.AcqBank;
import com.chinaebi.pmp.database.entity.Channel;
import com.chinaebi.pmp.database.entity.DeductChannel;
import com.chinaebi.pmp.database.entity.MerExpandOrganization;
import com.chinaebi.pmp.database.entity.TradeType;
import com.chinaebi.pmp.database.entity.UnionpayAreaCode;
import com.chinaebi.pmp.pms.service.ICommonService;

/**
 * 通用服务控制器
 *  
 * @author king 
 * 2015年2月12日
 */
@Controller
public class CommonServiceController {
	
	@Autowired
	@Qualifier(Annotations.SERVICE_COMMON)
	private ICommonService commonService;
	
	/**
	 * 查询渠道列表
	 */
	@RequestMapping(value = "/**/getChannelSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<Channel> getChannelSelectList() throws BusinessException {
		return commonService.getChannels();
	}
	/**
	 * 交易类型列表
	 */
	@RequestMapping(value = "/**/getTradeTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TradeType> getTradeTypeSelectList(@RequestParam("channelId")Integer channelId) throws BusinessException {
		return commonService.getTradeTypesByChannelId(channelId);
	}
	/**
	 * 交易类型列表
	 */
	@RequestMapping(value = "/**/getCacheTradeType.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TradeType> getAllTradeTypeSelectList() throws BusinessException {
		return commonService.getCacheTradeTypes();
	}
	/**
	 * 交易状态列表
	 */
	@RequestMapping(value = "/**/getTradeStatusSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TradeStatus> getTradeStatusSelectList() throws BusinessException {
		return Constants.TRADE_STATUS;
	}
	/**
	 * 交易银行列表
	 */
	@RequestMapping(value = "/**/getAcqBankSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<AcqBank> getAcqBankSelectList() throws BusinessException {
		return commonService.getAcqBanks();
	}
	/**
	 * 扣款渠道列表
	 */
	@RequestMapping(value = "/**/getDeductChannelSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<DeductChannel> getDeductChannelSelectList() throws BusinessException {
		return commonService.getCacheDeductChannels();
	}
	/**
	 * 商户类型列表
	 */
	@RequestMapping(value = "/**/getMerchantTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<MerchantType> getMerchantTypeSelectList() throws BusinessException {
		return Constants.MERCHANT_TYPE;
	}
	/**
	 * 查询公司类型
	 */
	@RequestMapping(value = "/**/getCompanyTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<CompanyType> getCompanyTypeSelectList() throws BusinessException {
		return Constants.COMPANY_TYPE;
	}
	/**
	 * 查询证件类型
	 */
	@RequestMapping(value = "/**/getCertificateTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<CertificateType> getCertificateTypeSelectList() throws BusinessException {
		return Constants.CERTIFICATE_TYPE;
	}
	/**
	 * 查询区域代码
	 */
	@RequestMapping(value = "/**/getAreaSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<UnionpayAreaCode> getAreaSelectList(@RequestParam("parentAreaCode")Integer parentAreaCode) throws BusinessException {
		return commonService.getUnionpayAreaCodes(parentAreaCode);
	}
	/**
	 * 结算周期类型
	 */
	@RequestMapping(value = "/**/getBalanceAccountTypeList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<BalanceAccountType> getBalanceAccountTypeList() throws BusinessException {
		return Constants.BALANCEACCOUNT_TYPE;
	}
	/**
	 * 商户行业类型
	 */
	@RequestMapping(value = "/**/getMerchantTradeTypeList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<MerchantTradeType> getMerchantTradeTypeList() throws BusinessException {
		return Constants.MERCHANTTRADE_TYPE;
	}
	/**
	 * 扣款费率公式页面
	 */
	@RequestMapping(value = "/**/getDiscountFeeDetailPage.do", method = { RequestMethod.GET,RequestMethod.POST })
	public String showDiscountFeeDetailPage() throws BusinessException {
		return "feemodel_details";
	}
	/**
	 * 操作员角色类型下拉选择框
	 */
	@RequestMapping(value = "/**/getOperatorRoleTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<OperatorRoleType> showOperatorRoleTypes() throws BusinessException {
		return Constants.OPERATOR_ROLE_TYPE;
	}
	/**
	 * 操作员角色类型下拉选择框
	 */
	@RequestMapping(value = "/**/getOperatorStatusSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<OperatorStatus> showOperatorStatus() throws BusinessException {
		return Constants.OPERATOR_STATUS;
	}
	/**
	 * 商户状态下拉列表
	 */
	@RequestMapping(value = "/**/getMerchantStatus.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<MerchantStatus> showMerchantStatus() throws BusinessException {
		return Constants.MERCHANT_STATUS;
	}
	/**
	 * 终端类型
	 */
	@RequestMapping(value = "/**/getTerminalTypeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TerminalType> getTerminalTypeSelectList() throws BusinessException {
		return Constants.TERMINAL_TYPE;
	}
	/**
	 * 终端方式
	 */
	@RequestMapping(value = "/**/getTerminalModeSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<TerminalMode> getTerminalModeSelectList() throws BusinessException {
		return Constants.TERMINAL_MODE;
	}
	
	/**
	 * 终端方式
	 * @throws WebException 
	 */
	@RequestMapping(value = "/**/getMerExpandOrganizationSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<MerExpandOrganization> getMerExpandOrganizationSelectList(@RequestParam("parentId") Integer parentId) throws WebException {
		MerExpandOrganization param = new MerExpandOrganization();
		param.setParentId(parentId);
		try {
			return commonService.getMerExpandOrganizations(param);
		} catch (BusinessException e) {
			throw new WebException();
		}
	}
	/**
	 * 商户风险级别
	 */
	@RequestMapping(value = "/**/getMerchantRiskLevelSelectList.do", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public List<MerchantRiskLevel> getMerchantRiskLevelSelectList() throws BusinessException {
		return Constants.MERCHANT_RISKLEVEL;
	}
}
