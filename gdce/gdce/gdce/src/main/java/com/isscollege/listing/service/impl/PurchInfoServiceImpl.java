package com.isscollege.listing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isscollege.listing.dao.PurchInfoDao;
import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.service.IPurchInfoService;

@Service
public class PurchInfoServiceImpl implements IPurchInfoService {

	@Autowired
	PurchInfoDao purchInfoDao;

	// 插入卖家挂牌商品信息并冻结保证金
	@Transactional
	@Override
	public int addPurchInfo(Purch_Info purch_info) {
		// return purchInfoDao.addPurchInfo(purch_info) +
		// frozenMoney(purch_info.getuID(),purch_info.getpCount()*purch_info.getpQuoDeposit()*10000);
		return purchInfoDao.addPurchInfo(purch_info);
	}

	// 完善信息 (货源地 交易方式 物流商)
	@Override
	public int modifyPurch_infoEMLD(int pNumber, String exchangeMeans, String logisticsbus, String sPlace) {
		return purchInfoDao.modifyPurch_infoEMLD(pNumber, exchangeMeans, logisticsbus, sPlace);
	}

	// 根据uID得到银行账号
	@Override
	public String getCBankAccount(Integer uID) {
		return purchInfoDao.getCBankAccount(uID);
	}

	// 冻结报价保证金
	/*
	 * @Override public int frozenMoney(int uID, double money) { return
	 * purchInfoDao.increaseMuQuoDeposit(uID,money) +
	 * purchInfoDao.decreaseMuUsable(uID,money); }
	 */

	// 根据主键查所有信息
	@Override
	public Purch_Info getPurch_InfobypNumber(int pNumber) {
		return purchInfoDao.getPurch_InfobypNumber(pNumber);
	}

	@Override
	public String getCName(Integer uID) {
		return purchInfoDao.getCName(uID);
	}

	@Override
	public int modifyPState(String pNumber) {
		return purchInfoDao.modifyPState(pNumber);
	}
}
