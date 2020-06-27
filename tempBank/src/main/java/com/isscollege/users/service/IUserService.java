package com.isscollege.users.service;

import java.util.List;

import com.isscollege.users.entity.Bank_Finance;

public interface IUserService {
	// 登录
	Bank_Finance login(Bank_Finance bank_Finance);

	// 预存金额
	Integer PrestoreMoney(Double balance, String bankAcount);

	// 冻结保证金
	Integer modifyFrozenMoney(String bankAcount, Double frozenMoney);

	// 查询余额和冻结金额
	Bank_Finance queryBalance(String bankAcount);

	// 解冻保证金
	boolean unfrozenBalance(String bankAcount, double amount) throws Exception;

	// 查询账号是否存在
	public boolean queryUserAcount(String cName);

	// 注册
	Integer tradeUserRegist(Bank_Finance bank_Finance);

	// 查询所有账户信息
	List<Bank_Finance> queryAllAccount();

}
