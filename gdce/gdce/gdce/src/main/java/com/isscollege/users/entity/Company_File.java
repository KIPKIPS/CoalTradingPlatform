package com.isscollege.users.entity;

import java.io.Serializable;

public class Company_File implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cID;
	private String cBusinessLicense;
	private String cTax;
	private String cOrg;
	private String cBank;
	private String cLegalPerson;
	private String cPermission;
	private int uID;
	@Override
	public String toString() {
		return "Company_File [cID=" + cID + ", cBusinessLicense=" + cBusinessLicense + ", cTax=" + cTax + ", cOrg="
				+ cOrg + ", cBank=" + cBank + ", cLegalPerson=" + cLegalPerson + ", cPermission=" + cPermission
				+ ", uID=" + uID + "]";
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
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
	public String getcLegalPerson() {
		return cLegalPerson;
	}
	public void setcLegalPerson(String cLegalPerson) {
		this.cLegalPerson = cLegalPerson;
	}
	public String getcPermission() {
		return cPermission;
	}
	public void setcPermission(String cPermission) {
		this.cPermission = cPermission;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	/**
	 * @param cBusinessLicense
	 * @param cTax
	 * @param cOrg
	 * @param cBank
	 * @param cLegalPerson
	 * @param cPermission
	 * @param uID
	 */
	public Company_File(String cBusinessLicense, String cTax, String cOrg, String cBank, String cLegalPerson,
			String cPermission, int uID) {
		super();
		this.cBusinessLicense = cBusinessLicense;
		this.cTax = cTax;
		this.cOrg = cOrg;
		this.cBank = cBank;
		this.cLegalPerson = cLegalPerson;
		this.cPermission = cPermission;
		this.uID = uID;
	}
	public Company_File() {
		
	}
	

}
