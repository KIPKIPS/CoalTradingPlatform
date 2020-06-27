package com.isscollege.order.entity;

public class SellerWaybill {
	// 货源地
	private String sDeliverPlace;
	// 收货地
	private String deliveryPlace;
	// 货物重量
	private double sCount;

	public String getsDeliverPlace() {
		return sDeliverPlace;
	}

	public void setsDeliverPlace(String sDeliverPlace) {
		this.sDeliverPlace = sDeliverPlace;
	}

	public String getDeliverPlace() {
		return deliveryPlace;
	}

	public void setDeliverPlace(String deliverPlace) {
		this.deliveryPlace = deliverPlace;
	}

	public double getsCount() {
		return sCount;
	}

	public void setsCount(double sCount) {
		this.sCount = sCount;
	}

	@Override
	public String toString() {
		return "SellerWaybill [sDeliverPlace=" + sDeliverPlace + ", deliveryPlace=" + deliveryPlace + ", sCount="
				+ sCount + "]";
	}

}
