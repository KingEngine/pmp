package com.chinaebi.pmp.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chinaebi.pmp.common.constant.Annotations;
import com.chinaebi.pmp.database.IAcqBankDao;
import com.chinaebi.pmp.database.IChannelDao;
import com.chinaebi.pmp.database.IMultiTableDao;
import com.chinaebi.pmp.database.entity.AcqBank;
import com.chinaebi.pmp.database.entity.Channel;
import com.chinaebi.pmp.database.entity.TradeType;
import com.chinaebi.pmp.pms.service.ICommonService;


@Service(Annotations.SERVICE_COMMON)
public class CommonServiceImpl implements ICommonService{

	@Autowired
	@Qualifier(Annotations.DAO_CHANNEL)
	private IChannelDao channelDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_MULTITABLE)
	private IMultiTableDao muliIMultiTableDao;
	
	@Autowired
	@Qualifier(Annotations.DAO_ACQBANK)
	private IAcqBankDao acqBankDao;
	
	public List<Channel> getChannelSelectList() {
		try {
			return channelDao.selectList(new Channel());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<TradeType> getTradeTypeSelectList(Integer channelId) {
		return muliIMultiTableDao.getTradeTypeByChannelId(channelId);
	}
	
	public List<AcqBank> getAcqBankSelectList() {
		AcqBank acqBank = new AcqBank();
		acqBank.setStatus(0);
		try {
			return acqBankDao.selectList(acqBank);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
