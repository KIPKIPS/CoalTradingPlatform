package com.isscollege.users.service;

import com.isscollege.users.entity.Company_File;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.entity.Question;
import com.isscollege.users.entity.Trade_Account;

public interface ITraderService {
	// 用户退出登录
	public Integer logout(Login_Info trader);

	// 登录
	public abstract Login_Info login(Login_Info trader);

	// 用户名是否已存在检验
	public abstract boolean queryTraderName(String uName);

	// 普通用户是否可以简单注册
	public abstract Login_Info firstregist(Login_Info trader);

	// 普通用户简单注册
	public abstract Integer realfirstregist(Login_Info trader);

	// 普通用户详细注册
	public abstract Integer realsecondregist(Trade_Account trade_account);

	// 普通用户是否可以详细注册
	public abstract Trade_Account secondregist(Trade_Account trade_account);

	// 验证密保问题
	public abstract Question getanswer(Question question);

	// 修改密码
	public abstract Integer modifypassword(Login_Info trader);

	// 增加公司文件信息
	public abstract Integer registtotb_company_file(Company_File company_file);

	// 显示公司信息详情
	public Trade_Account showCompanyInfo(int uid);

	// 上传修改的信息
	public Integer modifyInfo(Trade_Account trade_Account);

	// 修改上传企业资质到数据库（文件名）
	public Integer fileModify(String infoName, String path, Integer uID);

	// 放密保信息到密保表
	public abstract Integer registtotb_question(Question question);

	// 根据公司名返回公司详细信息
	public Trade_Account getAccountInfoBycName(String cName);

	// 得到交易用户的用户注册状态
	public abstract Login_Info get_uState_by_uid(int uID);

	// 根据公司名修改银行卡号
	public Integer updateUserAccountInfoBycName(String cName, String cBankAccount);

	// 根据uID查公司名
	public String getCompanyName(int uID);

}
