package com.isscollege.order.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String orderNo;
	private String tradeNo;
	private String orderState;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp orderDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp receiveDate;

	public String getOrderNo() {
		return orderNo;
	}

	public OrderInfo(String orderNo, String tradeNo, String orderState, Timestamp orderDate, Timestamp receiveDate) {
		super();
		this.orderNo = orderNo;
		this.tradeNo = tradeNo;
		this.orderState = orderState;
		this.orderDate = orderDate;
		this.receiveDate = receiveDate;
	}

	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Timestamp receiveDate) {
		this.receiveDate = receiveDate;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderNo=" + orderNo + ", tradeNo=" + tradeNo + ", orderState=" + orderState + ", orderDate="
				+ orderDate + ", receiveDate=" + receiveDate + "]";
	}

}
