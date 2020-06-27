package com.isscollege.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isscollege.users.dao.UserDao;
import com.isscollege.users.entity.Bank_Finance;
import com.isscollege.users.service.IUserService;
import com.isscollege.users.utils.CreateUserAccount;
import com.isscollege.users.utils.MD5;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDao userDao;

	// 登录
	@Override
	public Bank_Finance login(Bank_Finance bank_Finance) {
		// TODO Auto-generated method stub
		String newPass = new MD5().getMD5ofStr(bank_Finance.getBankPassword());

		bank_Finance.setBankPassword(newPass);
		System.out.println(bank_Finance);
		return userDao.login(bank_Finance);

	}

	// 预存功能
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer PrestoreMoney(Double balance, String bankAcount) {
		Integer result_modifyBalance = userDao.modifyBalance(balance, bankAcount);
		Integer result_modifyUsableMoneyByBalance = userDao.modifyUsableMoneyByBalance(balance, bankAcount);
		return (result_modifyBalance + result_modifyUsableMoneyByBalance);
	}

	// 冻结功能
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer modifyFrozenMoney(String bankAcount, Double frozenMoney) {
		Integer modifyFrozenMoney = userDao.modifyFrozenMoney(bankAcount, frozenMoney);
		Integer modifyUsableMoney = userDao.modifyUsableMoney(bankAcount, frozenMoney);
		return (modifyFrozenMoney + modifyUsableMoney);
	}

	// 查询余额和冻结金额
	@Override
	public Bank_Finance queryBalance(String bankAcount) {
		// TODO Auto-generated method stub
		return userDao.queryBankFinance(bankAcount);
	}

	// 注册
	@Override
	public Integer tradeUserRegist(Bank_Finance bank_Finance) {

		// System.out.println(bank_Finance.getBankPassword());
		// System.out.println("22222 " + bank_Finance.getBankAcount() + " " +
		// bank_Finance.getcName() + " "
		// + bank_Finance.getBankPassword() + " " + bank_Finance.getcRealName()
		// + " "
		// + bank_Finance.getcLegalPerson() + " " + bank_Finance.getuRealName()
		// + " "
		// + bank_Finance.getuTeleNum());
		// 生成账号
		String bankAcount = CreateUserAccount.getAccountNumber();
		bank_Finance.setBankAcount(bankAcount);

		// 加密
		String newPass = new MD5().getMD5ofStr(bank_Finance.getBankPassword());
		bank_Finance.setBankPassword(newPass);

		return userDao.tradeUserRegist(bank_Finance);

	}

	@Override
	public boolean queryUserAcount(String cName) {
		// 查询账号是否已存在，存在返回true，不存在返回false
		return userDao.queryUserAcountBycName(cName) != null ? true : false;
	}

	// 解冻指定金额
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean unfrozenBalance(String bankAcount, double amount) throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		Bank_Finance finance = userDao.queryBankFinanceForUpdate(bankAcount);
		if ((finance.getFrozenMoney() - amount) < 0)
			throw new IllegalArgumentException("账户： " + finance.getBankAcount() + " 被冻结金额为 ：" + finance.getFrozenMoney()
					+ " 不足以解冻， 请求解冻金额为：" + amount);
		finance.setUsableMoney(finance.getUsableMoney() + amount);
		finance.setFrozenMoney(finance.getFrozenMoney() - amount);
		return userDao.modifyBalanceFoUnfrozen(finance).intValue() == 1 ? true : false;
	}

	@Override
	public List<Bank_Finance> queryAllAccount() {
		return userDao.queryAllAccount();
	}

}
