package com.isscollege.listing.service;

import com.isscollege.listing.entity.Purch_Info;

public interface IPurchInfoService {

	public int addPurchInfo(Purch_Info purch_info);

	// 完善信息 (货源地 交易方式 物流商)
	public abstract int modifyPurch_infoEMLD(int pNumber, String exchangeMeans, String logisticsbus, String sPlace);

	// 根据uID得到银行账号
	public String getCBankAccount(Integer uID);

	// 冻结资金
	// public int frozenMoney(int uID, double money);

	// 根据主键查所有信息
	public abstract Purch_Info getPurch_InfobypNumber(int pNumber);

	public String getCName(Integer uID);

	public int modifyPState(String pNumber);
}
