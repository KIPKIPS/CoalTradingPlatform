package com.isscollege.users.entity;

import java.io.Serializable;

public class Trade_Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int uID;
	private String uRealName;
	private String uTelephone;
	private String muName;
	private String muTelephone;
	private String muMail;
	private String cName;
	private String cType;
	private String cLegalPerson;
	private String cLegalPersonID;
	private String cAddress;
	private String cEmile;
	private String cEasyName;
	private String cFax;
	private double cMoney;
	private String cBusinessLicense;
	private String cTax;
	private String cOrg;
	private String cBank;
	private String cBankAccount;
	private String cPermission;
	private String cResource;
	private String cTransport;
	private String cBrief;
	private String cPostalCode;
	private String uState;

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getuRealName() {
		return uRealName;
	}

	public void setuRealName(String uRealName) {
		this.uRealName = uRealName;
	}

	public String getuTelephone() {
		return uTelephone;
	}

	public void setuTelephone(String uTelephone) {
		this.uTelephone = uTelephone;
	}

	public String getMuName() {
		return muName;
	}

	public void setMuName(String muName) {
		this.muName = muName;
	}

	public String getMuTelephone() {
		return muTelephone;
	}

	public void setMuTelephone(String muTelephone) {
		this.muTelephone = muTelephone;
	}

	public String getMuMail() {
		return muMail;
	}

	public void setMuMail(String muMail) {
		this.muMail = muMail;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcLegalPerson() {
		return cLegalPerson;
	}

	public void setcLegalPerson(String cLegalPerson) {
		this.cLegalPerson = cLegalPerson;
	}

	public String getcLegalPersonID() {
		return cLegalPersonID;
	}

	public void setcLegalPersonID(String cLegalPersonID) {
		this.cLegalPersonID = cLegalPersonID;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcEmile() {
		return cEmile;
	}

	public void setcEmile(String cEmile) {
		this.cEmile = cEmile;
	}

	public String getcEasyName() {
		return cEasyName;
	}

	public void setcEasyName(String cEasyName) {
		this.cEasyName = cEasyName;
	}

	public String getcFax() {
		return cFax;
	}

	public void setcFax(String cFax) {
		this.cFax = cFax;
	}

	public double getcMoney() {
		return cMoney;
	}

	public void setcMoney(double cMoney) {
		this.cMoney = cMoney;
	}

	public String getcBusinessLicense() {
		return cBusinessLicense;
	}

	public void setcBusinessLicense(String cBusinessLicense) {
		this.cBusinessLicense = cBusinessLicense;
	}

	public String getcTax() {
		return cTax;
	}

	public void setcTax(String cTax) {
		this.cTax = cTax;
	}

	public String getcOrg() {
		return cOrg;
	}

	public void setcOrg(String cOrg) {
		this.cOrg = cOrg;
	}

	public String getcBank() {
		return cBank;
	}

	public void setcBank(String cBank) {
		this.cBank = cBank;
	}

	public String getcBankAccount() {
		return cBankAccount;
	}

	public void setcBankAccount(String cBankAccount) {
		this.cBankAccount = cBankAccount;
	}

	public String getcPermission() {
		return cPermission;
	}

	public void setcPermission(String cPermission) {
		this.cPermission = cPermission;
	}

	public String getcResource() {
		return cResource;
	}

	public void setcResource(String cResource) {
		this.cResource = cResource;
	}

	public String getcTransport() {
		return cTransport;
	}

	public void setcTransport(String cTransport) {
		this.cTransport = cTransport;
	}

	public String getcBrief() {
		return cBrief;
	}

	public void setcBrief(String cBrief) {
		this.cBrief = cBrief;
	}

	public String getcPostalCode() {
		return cPostalCode;
	}

	public void setcPostalCode(String cPostalCode) {
		this.cPostalCode = cPostalCode;
	}

	public String getuState() {
		return uState;
	}

	public void setuState(String uState) {
		this.uState = uState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param uID
	 * @param uRealName
	 * @param uTelephone
	 * @param muName
	 * @param muTelephone
	 * @param muMail
	 * @param cName
	 * @param cType
	 * @param cLegalPerson
	 * @param cLegalPersonID
	 * @param cAddress
	 * @param cEmile
	 * @param cEasyName
	 * @param cFax
	 * @param cMoney
	 * @param cBusinessLicense
	 * @param cTax
	 * @param cOrg
	 * @param cBank
	 * @param cBankAccount
	 * @param cPermission
	 * @param cResource
	 * @param cTransport
	 * @param cBrief
	 * @param cPostalCode
	 */
	public Trade_Account(int uID, String uRealName, String uTelephone, String muName, String muTelephone, String muMail,
			String cName, String cType, String cLegalPerson, String cLegalPersonID, String cAddress, String cEmile,
			String cEasyName, String cFax, double cMoney, String cBusinessLicense, String cTax, String cOrg,
			String cBank, String cBankAccount, String cPermission, String cResource, String cTransport, String cBrief,
			String cPostalCode) {
		super();
		this.uID = uID;
		this.uRealName = uRealName;
		this.uTelephone = uTelephone;
		this.muName = muName;
		this.muTelephone = muTelephone;
		this.muMail = muMail;
		this.cName = cName;
		this.cType = cType;
		this.cLegalPerson = cLegalPerson;
		this.cLegalPersonID = cLegalPersonID;
		this.cAddress = cAddress;
		this.cEmile = cEmile;
		this.cEasyName = cEasyName;
		this.cFax = cFax;
		this.cMoney = cMoney;
		this.cBusinessLicense = cBusinessLicense;
		this.cTax = cTax;
		this.cOrg = cOrg;
		this.cBank = cBank;
		this.cBankAccount = cBankAccount;
		this.cPermission = cPermission;
		this.cResource = cResource;
		this.cTransport = cTransport;
		this.cBrief = cBrief;
		this.cPostalCode = cPostalCode;
	}

	public Trade_Account() {

	}

	@Override
	public String toString() {
		return "Trade_Account [uID=" + uID + ", uRealName=" + uRealName + ", uTelephone=" + uTelephone + ", muName="
				+ muName + ", muTelephone=" + muTelephone + ", muMail=" + muMail + ", cName=" + cName + ", cType="
				+ cType + ", cLegalPerson=" + cLegalPerson + ", cLegalPersonID=" + cLegalPersonID + ", cAddress="
				+ cAddress + ", cEmile=" + cEmile + ", cEasyName=" + cEasyName + ", cFax=" + cFax + ", cMoney=" + cMoney
				+ ", cBusinessLicense=" + cBusinessLicense + ", cTax=" + cTax + ", cOrg=" + cOrg + ", cBank=" + cBank
				+ ", cBankAccount=" + cBankAccount + ", cPermission=" + cPermission + ", cResource=" + cResource
				+ ", cTransport=" + cTransport + ", cBrief=" + cBrief + ", cPostalCode=" + cPostalCode + ", uState="
				+ uState + "]";
	}

}
