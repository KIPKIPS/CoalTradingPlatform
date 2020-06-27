package com.isscollege.contract.entity;

import java.io.Serializable;

public class Contract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tradeNo;// 交易编号
	private int delistNo;// 摘牌编号
	private int listNo;// 挂牌编号
	private String contract;// 合同内容
	private String contractState;// 合同状态
	private String receipt;// 回执单
	private String receiptState;// 回执单状态
	private String source;// 挂牌来源 1-->卖方挂 2-->买方挂

	@Override
	public String toString() {
		return " " + tradeNo + "	" + delistNo + "	" + listNo + "	" + contract + ",	" + contractState;
	}

	public Contract(String tradeNo, int delistNo, int listNo, String contract, String contractState, String receipt,
			String receiptState, String source) {
		super();
		this.tradeNo = tradeNo;
		this.delistNo = delistNo;
		this.listNo = listNo;
		this.contract = contract;
		this.contractState = contractState;
		this.receipt = receipt;
		this.receiptState = receiptState;
		this.source = source;
	}

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public int getDelistNo() {
		return delistNo;
	}

	public void setDelistNo(int delistNo) {
		this.delistNo = delistNo;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getReceiptState() {
		return receiptState;
	}

	public void setReceiptState(String receiptState) {
		this.receiptState = receiptState;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
