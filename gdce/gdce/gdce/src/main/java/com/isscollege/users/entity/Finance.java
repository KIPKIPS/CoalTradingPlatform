package com.isscollege.users.entity;

import java.io.Serializable;

public class Finance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer muNumber;
	private String muAccount;
	private String muPass;
	private Double muPrestore;
	private Double muUsable;
	private Double muQuoDeposit;
	private Double muBidBond;
	private Integer uID;

	/**
	 * @return the uID
	 */
	public Integer getuID() {
		return uID;
	}

	/**
	 * @param uID
	 *            the uID to set
	 */
	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public Finance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Finance(Integer muNumber, String muAccount, String muPass, Double muPrestore, Double muUsable,
			Double muQuoDeposit, Double muBidBond) {
		super();
		this.muNumber = muNumber;
		this.muAccount = muAccount;
		this.muPass = muPass;
		this.muPrestore = muPrestore;
		this.muUsable = muUsable;
		this.muQuoDeposit = muQuoDeposit;
		this.muBidBond = muBidBond;
	}

	public Finance(String muAccount, String muPass) {
		super();
		this.muAccount = muAccount;
		this.muPass = muPass;
	}

	/**
	 * @return the muNumber
	 */
	public Integer getMuNumber() {
		return muNumber;
	}

	/**
	 * @param muNumber
	 *            the muNumber to set
	 */
	public void setMuNumber(Integer muNumber) {
		this.muNumber = muNumber;
	}

	/**
	 * @return the muAccount
	 */
	public String getMuAccount() {
		return muAccount;
	}

	/**
	 * @param muAccount
	 *            the muAccount to set
	 */
	public void setMuAccount(String muAccount) {
		this.muAccount = muAccount;
	}

	/**
	 * @return the muPass
	 */
	public String getMuPass() {
		return muPass;
	}

	/**
	 * @param muPass
	 *            the muPass to set
	 */
	public void setMuPass(String muPass) {
		this.muPass = muPass;
	}

	/**
	 * @return the muPrestore
	 */
	public Double getMuPrestore() {
		return muPrestore;
	}

	/**
	 * @param muPrestore
	 *            the muPrestore to set
	 */
	public void setMuPrestore(Double muPrestore) {
		this.muPrestore = muPrestore;
	}

	/**
	 * @return the muUsable
	 */
	public Double getMuUsable() {
		return muUsable;
	}

	/**
	 * @param muUsable
	 *            the muUsable to set
	 */
	public void setMuUsable(Double muUsable) {
		this.muUsable = muUsable;
	}

	/**
	 * @return the muQuoDeposit
	 */
	public Double getMuQuoDeposit() {
		return muQuoDeposit;
	}

	/**
	 * @param muQuoDeposit
	 *            the muQuoDeposit to set
	 */
	public void setMuQuoDeposit(Double muQuoDeposit) {
		this.muQuoDeposit = muQuoDeposit;
	}

	/**
	 * @return the muBidBond
	 */
	public Double getMuBidBond() {
		return muBidBond;
	}

	/**
	 * @param muBidBond
	 *            the muBidBond to set
	 */
	public void setMuBidBond(Double muBidBond) {
		this.muBidBond = muBidBond;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Finance [muNumber=" + muNumber + ", muAccount=" + muAccount + ", muPass=" + muPass + ", muPrestore="
				+ muPrestore + ", muUsable=" + muUsable + ", muQuoDeposit=" + muQuoDeposit + ", muBidBond=" + muBidBond
				+ ", uID=" + uID + "]";
	}

}
