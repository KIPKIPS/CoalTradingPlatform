package com.isscollege.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.users.dao.TraderDao;
import com.isscollege.users.entity.Company_File;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.entity.Question;
import com.isscollege.users.entity.Trade_Account;
import com.isscollege.users.service.ITraderService;
import com.isscollege.users.utils.MD5;

@Service
public class TraderServiceImpl implements ITraderService {
	@Autowired
	TraderDao traderDao;

	// 用户退出
	@Override
	public Integer logout(Login_Info user) {

		return traderDao.logout(user);
	}

	// 登录
	@Override
	public Login_Info login(Login_Info trader) {
		String newPass = new MD5().getMD5ofStr(trader.getuPass());
		trader.setuPass(newPass);
		return traderDao.login(trader);
	}

	@Override
	public Login_Info firstregist(Login_Info trader) {
		System.out.println(trader);

		return traderDao.isExist(trader);
	}

	@Override
	public Integer realfirstregist(Login_Info trader) {
		String newPass = new MD5().getMD5ofStr(trader.getuPass());
		trader.setuPass(newPass);
		return traderDao.registtotb_login_info(trader);
	}

	@Override
	public Trade_Account secondregist(Trade_Account trade_account) {
		return traderDao.isExistCom(trade_account);
	}

	@Override
	public Integer realsecondregist(Trade_Account trade_account) {
		return traderDao.registtotb_trade_account(trade_account);
	}

	@Override
	public Question getanswer(Question question) {

		return traderDao.isright(question);
	}

	@Override
	public Integer modifypassword(Login_Info trader) {
		String newPass = new MD5().getMD5ofStr(trader.getuPass());
		trader.setuPass(newPass);
		return traderDao.modifypassword(trader);
	}

	@Override
	public Integer registtotb_company_file(Company_File company_file) {

		return traderDao.registtotb_company_file(company_file);

	}

	@Override
	public Trade_Account showCompanyInfo(int uid) {

		return traderDao.showCompanyInfo(uid);
	}

	@Override
	public Integer modifyInfo(Trade_Account trade_Account) {

		return traderDao.modifyInfo(trade_Account);
	}

	@Override
	public Integer fileModify(String infoName, String path, Integer uID) {

		return traderDao.fileModify(infoName, path, uID);
	}

	@Override
	public Integer registtotb_question(Question question) {

		return traderDao.registtotb_question(question);
	}

	@Override
	public Trade_Account getAccountInfoBycName(String cName) {

		return traderDao.doesTheAccountExist(cName);
	}

	@Override
	public String getCompanyName(int uID) {
		return traderDao.getCompanyName(uID);
	}

	@Override
	public Login_Info get_uState_by_uid(int uID) {
		return traderDao.get_uState(uID);
	}

	@Override
	public boolean queryTraderName(String uName) {
		return traderDao.select_uName_by_uName(uName) != null ? true : false;
	}

	@Override
	public Integer updateUserAccountInfoBycName(String cName, String cBankAccount) {
		return traderDao.updateUserAccountInfoBycName(cName, cBankAccount);
	}

}
