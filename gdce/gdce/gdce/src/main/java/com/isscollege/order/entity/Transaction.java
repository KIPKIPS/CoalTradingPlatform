package com.isscollege.order.entity;

import java.io.Serializable;

public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String traderNo;
	private Integer delistNo;
	private Integer listNo;
	private String contract;
	private String contractState;
	private String receipt;
	private String receiptState;
	private String source;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the traderNo
	 */
	public String getTraderNo() {
		return traderNo;
	}

	/**
	 * @param traderNo
	 *            the traderNo to set
	 */
	public void setTraderNo(String traderNo) {
		this.traderNo = traderNo;
	}

	/**
	 * @return the delistNo
	 */
	public Integer getDelistNo() {
		return delistNo;
	}

	/**
	 * @param delistNo
	 *            the delistNo to set
	 */
	public void setDelistNo(Integer delistNo) {
		this.delistNo = delistNo;
	}

	/**
	 * @return the listNo
	 */
	public Integer getListNo() {
		return listNo;
	}

	/**
	 * @param listNo
	 *            the listNo to set
	 */
	public void setListNo(Integer listNo) {
		this.listNo = listNo;
	}

	/**
	 * @return the contract
	 */
	public String getContract() {
		return contract;
	}

	/**
	 * @param contract
	 *            the contract to set
	 */
	public void setContract(String contract) {
		this.contract = contract;
	}

	/**
	 * @return the contractState
	 */
	public String getContractState() {
		return contractState;
	}

	/**
	 * @param contractState
	 *            the contractState to set
	 */
	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	/**
	 * @return the receipt
	 */
	public String getReceipt() {
		return receipt;
	}

	/**
	 * @param receipt
	 *            the receipt to set
	 */
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	/**
	 * @return the receiptState
	 */
	public String getReceiptState() {
		return receiptState;
	}

	/**
	 * @param receiptState
	 *            the receiptState to set
	 */
	public void setReceiptState(String receiptState) {
		this.receiptState = receiptState;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [traderNo=" + traderNo + ", delistNo=" + delistNo + ", listNo=" + listNo + ", contract="
				+ contract + ", contractState=" + contractState + ", receipt=" + receipt + ", receiptState="
				+ receiptState + ", source=" + source + "]";
	}

}
