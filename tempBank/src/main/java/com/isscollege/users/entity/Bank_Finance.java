package com.isscollege.users.entity;

import java.io.Serializable;

public class Bank_Finance implements Serializable {

	@Override
	public String toString() {
		return "Bank_Finance [bankAcount=" + bankAcount + ", bankPassword=" + bankPassword + ", cName=" + cName
				+ ", cRealName=" + cRealName + ", cLegalPerson=" + cLegalPerson + ", uRealName=" + uRealName
				+ ", uTeleNum=" + uTeleNum + ", balance=" + balance + ", usableMoney=" + usableMoney + ", frozenMoney="
				+ frozenMoney + "]";
	}

	private static final long serialVersionUID = 1L;

	/**
	 * tb_bank_finance.bankAcount (银行卡号)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String bankAcount;

	/**
	 * tb_bank_finance.bankPassword (登录密码)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String bankPassword;

	/**
	 * tb_bank_finance.cName (企业名称)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String cName;

	/**
	 * tb_bank_finance.cRealName (法人代表)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String cRealName;

	/**
	 * tb_bank_finance.cLegalPerson (法人身份证)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String cLegalPerson;

	/**
	 * tb_bank_finance.uRealName (联系人)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String uRealName;

	/**
	 * tb_bank_finance.uTeleNum (联系电话)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private String uTeleNum;

	/**
	 * tb_bank_finance.balance (余额)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private Double balance;

	/**
	 * tb_bank_finance.usableMoney (未冻结金额)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private Double usableMoney;

	/**
	 * tb_bank_finance.frozenMoney (冻结余额)
	 * 
	 * @ibatorgenerated 2019-06-25 14:43:10
	 */
	private Double frozenMoney;

	public String getBankAcount() {
		return bankAcount;
	}

	public void setBankAcount(String bankAcount) {
		this.bankAcount = bankAcount;
	}

	public String getBankPassword() {
		return bankPassword;
	}

	public void setBankPassword(String bankPassword) {
		this.bankPassword = bankPassword;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcRealName() {
		return cRealName;
	}

	public void setcRealName(String cRealName) {
		this.cRealName = cRealName;
	}

	public String getcLegalPerson() {
		return cLegalPerson;
	}

	public void setcLegalPerson(String cLegalPerson) {
		this.cLegalPerson = cLegalPerson;
	}

	public String getuRealName() {
		return uRealName;
	}

	public void setuRealName(String uRealName) {
		this.uRealName = uRealName;
	}

	public String getuTeleNum() {
		return uTeleNum;
	}

	public void setuTeleNum(String uTeleNum) {
		this.uTeleNum = uTeleNum;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getUsableMoney() {
		return usableMoney;
	}

	public void setUsableMoney(Double usableMoney) {
		this.usableMoney = usableMoney;
	}

	public Double getFrozenMoney() {
		return frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	public Bank_Finance(String bankAcount, String bankPassword, String cName, String cRealName, String cLegalPerson,
			String uRealName, String uTeleNum, Double balance, Double usableMoney, Double frozenMoney) {
		super();
		this.bankAcount = bankAcount;
		this.bankPassword = bankPassword;
		this.cName = cName;
		this.cRealName = cRealName;
		this.cLegalPerson = cLegalPerson;
		this.uRealName = uRealName;
		this.uTeleNum = uTeleNum;
		this.balance = balance;
		this.usableMoney = usableMoney;
		this.frozenMoney = frozenMoney;
	}

	public Bank_Finance(String bankAcount, String bankPassword, String cName, String cRealName, String cLegalPerson,
			String uRealName, String uTeleNum) {
		super();
		this.bankAcount = bankAcount;
		this.bankPassword = bankPassword;
		this.cName = cName;
		this.cRealName = cRealName;
		this.cLegalPerson = cLegalPerson;
		this.uRealName = uRealName;
		this.uTeleNum = uTeleNum;
	}

	public Bank_Finance() {
		super();
		// TODO Auto-generated constructor stub
	}

}
