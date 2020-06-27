package com.isscollege.waybill.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class WaybillInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 运单编号
	private int waybill_id;
	// 交易编号
	private String trade_id;
	// 配送状态 0：待确认 1：配送中 2：已完成
	private int dis_status;
	// 配送人
	private String distributor;
	// 配送人联系方式
	private String dis_phone;
	// 起始位置
	private String start_pos;
	// 终止位置
	private String end_pos;
	// 物流商编号
	private int logistics_id;
	// 总运费
	private double sum_carriage;
	// 货源地
	private String good_source;
	// 收货地
	private String good_destination;

	// 发货时间
	private Timestamp good_trs_time;
	// 收到货时间
	private Timestamp good_rec_time;

	private double log_weight;

	public double getLog_weight() {
		return log_weight;
	}

	public void setLog_weight(double log_weight) {
		this.log_weight = log_weight;
	}

	/**
	 * @return the waybill_id
	 */
	public int getWaybill_id() {
		return waybill_id;
	}

	/**
	 * @return the good_trs_time
	 */
	public Timestamp getGood_trs_time() {
		return good_trs_time;
	}

	/**
	 * @param good_trs_time
	 *            the good_trs_time to set
	 */
	public void setGood_trs_time(Timestamp good_trs_time) {
		this.good_trs_time = good_trs_time;
	}

	/**
	 * @return the good_rec_time
	 */
	public Timestamp getGood_rec_time() {
		return good_rec_time;
	}

	/**
	 * @param good_rec_time
	 *            the good_rec_time to set
	 */
	public void setGood_rec_time(Timestamp good_rec_time) {
		this.good_rec_time = good_rec_time;
	}

	/**
	 * @param waybill_id
	 *            the waybill_id to set
	 */
	public void setWaybill_id(int waybill_id) {
		this.waybill_id = waybill_id;
	}

	/**
	 * @return the trade_id
	 */
	public String getTrade_id() {
		return trade_id;
	}

	/**
	 * @param trade_id
	 *            the trade_id to set
	 */
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}

	/**
	 * @return the dis_status
	 */
	public int getDis_status() {
		return dis_status;
	}

	/**
	 * @param dis_status
	 *            the dis_status to set
	 */
	public void setDis_status(int dis_status) {
		this.dis_status = dis_status;
	}

	/**
	 * @return the distributor
	 */
	public String getDistributor() {
		return distributor;
	}

	/**
	 * @param distributor
	 *            the distributor to set
	 */
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	/**
	 * @return the dis_phone
	 */
	public String getDis_phone() {
		return dis_phone;
	}

	/**
	 * @param dis_phone
	 *            the dis_phone to set
	 */
	public void setDis_phone(String dis_phone) {
		this.dis_phone = dis_phone;
	}

	/**
	 * @return the start_pos
	 */
	public String getStart_pos() {
		return start_pos;
	}

	/**
	 * @param start_pos
	 *            the start_pos to set
	 */
	public void setStart_pos(String start_pos) {
		this.start_pos = start_pos;
	}

	/**
	 * @return the end_pos
	 */
	public String getEnd_pos() {
		return end_pos;
	}

	/**
	 * @param end_pos
	 *            the end_pos to set
	 */
	public void setEnd_pos(String end_pos) {
		this.end_pos = end_pos;
	}

	/**
	 * @return the logistics_id
	 */
	public int getLogistics_id() {
		return logistics_id;
	}

	/**
	 * @param logistics_id
	 *            the logistics_id to set
	 */
	public void setLogistics_id(int logistics_id) {
		this.logistics_id = logistics_id;
	}

	/**
	 * @return the sum_carriage
	 */
	public double getSum_carriage() {
		return sum_carriage;
	}

	/**
	 * @param sum_carriage
	 *            the sum_carriage to set
	 */
	public void setSum_carriage(double sum_carriage) {
		this.sum_carriage = sum_carriage;
	}

	/**
	 * @return the good_source
	 */
	public String getGood_source() {
		return good_source;
	}

	/**
	 * @param good_source
	 *            the good_source to set
	 */
	public void setGood_source(String good_source) {
		this.good_source = good_source;
	}

	/**
	 * @return the good_destination
	 */
	public String getGood_destination() {
		return good_destination;
	}

	/**
	 * @param good_destination
	 *            the good_destination to set
	 */
	public void setGood_destination(String good_destination) {
		this.good_destination = good_destination;
	}

	public WaybillInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "WaybillInfo [waybill_id=" + waybill_id + ", trade_id=" + trade_id + ", dis_status=" + dis_status
				+ ", distributor=" + distributor + ", dis_phone=" + dis_phone + ", start_pos=" + start_pos
				+ ", end_pos=" + end_pos + ", logistics_id=" + logistics_id + ", sum_carriage=" + sum_carriage
				+ ", good_source=" + good_source + ", good_destination=" + good_destination + ", good_trs_time="
				+ good_trs_time + ", good_rec_time=" + good_rec_time + ", log_weight=" + log_weight + "]";
	}

}
