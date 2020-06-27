package com.isscollege.order.entity;

public class PurchWaybill {
	// 货源地
	private String sPlace;
	// 收获地
	private String pDeliverPlace;
	// 货物重量
	private double pCount;

	public PurchWaybill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchWaybill(String sPlace, String pDeliverPlace, double pCount) {
		super();
		this.sPlace = sPlace;
		this.pDeliverPlace = pDeliverPlace;
		this.pCount = pCount;
	}

	public String getsPlace() {
		return sPlace;
	}

	public void setsPlace(String sPlace) {
		this.sPlace = sPlace;
	}

	public double getpCount() {
		return pCount;
	}

	public void setpCount(double pCount) {
		this.pCount = pCount;
	}

	public String getpDeliverPlace() {
		return pDeliverPlace;
	}

	public void setpDeliverPlace(String pDeliverPlace) {
		this.pDeliverPlace = pDeliverPlace;
	}

	@Override
	public String toString() {
		return "PurchWaybill [sPlace=" + sPlace + ", pDeliverPlace=" + pDeliverPlace + ", pCount=" + pCount + "]";
	}
}