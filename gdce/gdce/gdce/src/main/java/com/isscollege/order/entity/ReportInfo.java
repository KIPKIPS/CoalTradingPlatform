package com.isscollege.order.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用于包装报表表格的数据
 * @author 'zhangzhuo'
 *
 * 2019年7月5日
 */
public class ReportInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String coalType;
	private double quantity;
	private double money;
	private Timestamp minDate;
	private Timestamp maxDate;
	
	
	public ReportInfo() {
		super();
	}
	public ReportInfo(String coalType, double quantity, double money, Timestamp minDate, Timestamp maxDate) {
		super();
		this.coalType = coalType;
		this.quantity = quantity;
		this.money = money;
		this.minDate = minDate;
		this.maxDate = maxDate;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Timestamp getMinDate() {
		return minDate;
	}
	public void setMinDate(Timestamp minDate) {
		this.minDate = minDate;
	}
	public Timestamp getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Timestamp maxDate) {
		this.maxDate = maxDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "ReportInfo [coalType=" + coalType + ", quantity=" + quantity + ", money=" + money + ", minDate="
				+ minDate + ", maxDate=" + maxDate + "]";
	}
}
