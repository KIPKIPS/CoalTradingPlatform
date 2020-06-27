package com.isscollege.contract.entity;

import java.io.Serializable;

public class ContractList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tradeNo;
	private String c1;
	private String c2;
	private String contract;
	private String contractState;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
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

	public ContractList(String tradeNo, String c1, String c2, String contract, String contractState) {
		super();
		this.tradeNo = tradeNo;
		this.c1 = c1;
		this.c2 = c2;
		this.contract = contract;
		this.contractState = contractState;
	}

	public ContractList() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return " " + tradeNo + "	" + c1 + "	" + c2 + "	" + contract + "		" + contractState + "\n";
	}

}
