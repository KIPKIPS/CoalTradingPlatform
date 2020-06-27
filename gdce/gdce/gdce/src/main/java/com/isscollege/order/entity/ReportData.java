package com.isscollege.order.entity;

import java.io.Serializable;

/**
 * 用于包装报表chart中的交易信息
 * @author 'zhangzhuo'
 *
 * 2019年7月5日
 */
public class ReportData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String coalType;
	private double quantity;
	
	
	public ReportData() {
		super();
	}
	public ReportData(String coalType, double quantity) {
		super();
		this.coalType = coalType;
		this.quantity = quantity;
	}
	
	
	public String getCoalType() {
		return coalType;
	}
	public void setCoalType(String coalType) {
		this.coalType = coalType;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "reportData [coalType=" + coalType + ", quantity=" + quantity + "]";
	}
}
