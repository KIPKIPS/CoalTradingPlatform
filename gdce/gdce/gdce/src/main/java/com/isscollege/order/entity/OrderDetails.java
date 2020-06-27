package com.isscollege.order.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	// 订单编号
	private String orderNo;
	// 卖方公司名
	private String sellerName;
	// 卖方联系方式
	private String sellerTele;
	// 买方公司名
	private String purchName;
	// 买方联系方式
	private String purchTele;
	// 煤种
	private String coalType;
	// 吨数
	private Double quantity;
	// 金额
	private Double money;
	// 货源地
	private String salePlace;
	// 到货地
	private String deliveryPlace;
	// 订单创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp orderDate;
	// 收货时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp receiveDate;
	// 交易方式
	private String exchangeMeans;
	// 订单状态
	private String orderState;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(String orderNo, String sellerName, String sellerTele, String purchName, String purchTele,
			String coalType, Double quantity, Double money, String salePlace, String deliveryPlace, Timestamp orderDate,
			Timestamp receiveDate, String exchangeMeans, String orderState) {
		super();
		this.orderNo = orderNo;
		this.sellerName = sellerName;
		this.sellerTele = sellerTele;
		this.purchName = purchName;
		this.purchTele = purchTele;
		this.coalType = coalType;
		this.quantity = quantity;
		this.money = money;
		this.salePlace = salePlace;
		this.deliveryPlace = deliveryPlace;
		this.orderDate = orderDate;
		this.receiveDate = receiveDate;
		this.exchangeMeans = exchangeMeans;
		this.orderState = orderState;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerTele() {
		return sellerTele;
	}

	public void setSellerTele(String sellerTele) {
		this.sellerTele = sellerTele;
	}

	public String getPurchName() {
		return purchName;
	}

	public void setPurchName(String purchName) {
		this.purchName = purchName;
	}

	public String getPurchTele() {
		return purchTele;
	}

	public void setPurchTele(String purchTele) {
		this.purchTele = purchTele;
	}

	public String getCoalType() {
		return coalType;
	}

	public void setCoalType(String coalType) {
		this.coalType = coalType;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getSalePlace() {
		return salePlace;
	}

	public void setSalePlace(String salePlace) {
		this.salePlace = salePlace;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public Timestamp getOrderDate() {
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

	public Timestamp getReceieveDate() {
		return receiveDate;
	}

	public void setReceieveDate(Timestamp receieveDate) {
		this.receiveDate = receieveDate;
	}

	public String getExchangeMeans() {
		return exchangeMeans;
	}

	public void setExchangeMeans(String exchangeMeans) {
		this.exchangeMeans = exchangeMeans;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderNo=" + orderNo + ", sellerName=" + sellerName + ", sellerTele=" + sellerTele
				+ ", purchName=" + purchName + ", purchTele=" + purchTele + ", coalType=" + coalType + ", quantity="
				+ quantity + ", money=" + money + ", salePlace=" + salePlace + ", deliveryPlace=" + deliveryPlace
				+ ", orderDate=" + orderDate + ", recieveDate=" + receiveDate + ", exchangeMeans=" + exchangeMeans
				+ ", orderState=" + orderState + "]";
	}

}
