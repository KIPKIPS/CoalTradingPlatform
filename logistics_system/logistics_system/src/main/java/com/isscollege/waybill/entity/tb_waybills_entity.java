package com.isscollege.waybill.entity;

import java.sql.Timestamp;

public class tb_waybills_entity {
	private int waybill_id;
	private String trade_id;
	private int dis_status;
	private String distributor;
	private String dis_phone;
	private String start_pos;
	private String end_pos;
	private int logistics_id;
	private double sum_carriage;
	private String good_source;
	private String good_destination;
	private Timestamp good_trs_time;
	private Timestamp good_rec_time;

	public tb_waybills_entity(int waybill_id, String trade_id, int dis_status, String distributor, String dis_phone,
			String start_pos, String end_pos, int logistics_id, double sum_carriage, String good_source,
			String good_destination, Timestamp good_trs_time, Timestamp good_rec_time) {
		super();
		this.waybill_id = waybill_id;
		this.trade_id = trade_id;
		this.dis_status = dis_status;
		this.distributor = distributor;
		this.dis_phone = dis_phone;
		this.start_pos = start_pos;
		this.end_pos = end_pos;
		this.logistics_id = logistics_id;
		this.sum_carriage = sum_carriage;
		this.good_source = good_source;
		this.good_destination = good_destination;
		this.good_trs_time = good_trs_time;
		this.good_rec_time = good_rec_time;
	}

	public Timestamp getGood_trs_time() {
		return good_trs_time;
	}

	public void setGood_trs_time(Timestamp good_trs_time) {
		this.good_trs_time = good_trs_time;
	}

	public Timestamp getGood_rec_time() {
		return good_rec_time;
	}

	public void setGood_rec_time(Timestamp good_rec_time) {
		this.good_rec_time = good_rec_time;
	}

	public tb_waybills_entity(String good_source, String good_destination) {
		super();
	}

	public String getGood_source() {
		return good_source;
	}

	public void setGood_source(String good_source) {
		this.good_source = good_source;
	}

	public String getGood_destination() {
		return good_destination;
	}

	public void setGood_destination(String good_destination) {
		this.good_destination = good_destination;
	}

	public tb_waybills_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "tb_waybills_entity [waybill_id=" + waybill_id + ", trade_id=" + trade_id + ", dis_status=" + dis_status
				+ ", distributor=" + distributor + ", dis_phone=" + dis_phone + ", start_pos=" + start_pos
				+ ", end_pos=" + end_pos + ", logistics_id=" + logistics_id + ", sum_carriage=" + sum_carriage
				+ ", good_source=" + good_source + ", good_destination=" + good_destination + ", good_trs_time="
				+ good_trs_time + ", good_rec_time=" + good_rec_time + "]";
	}

	public int getWaybill_id() {
		return waybill_id;
	}

	public void setWaybill_id(int waybill_id) {
		this.waybill_id = waybill_id;
	}

	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}

	public int getDis_status() {
		return dis_status;
	}

	public void setDis_status(int dis_status) {
		this.dis_status = dis_status;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getDis_phone() {
		return dis_phone;
	}

	public void setDis_phone(String dis_phone) {
		this.dis_phone = dis_phone;
	}

	public String getStart_pos() {
		return start_pos;
	}

	public void setStart_pos(String start_pos) {
		this.start_pos = start_pos;
	}

	public String getEnd_pos() {
		return end_pos;
	}

	public void setEnd_pos(String end_pos) {
		this.end_pos = end_pos;
	}

	public int getLogistics_id() {
		return logistics_id;
	}

	public void setLogistics_id(int logistics_id) {
		this.logistics_id = logistics_id;
	}

	public double getSum_carriage() {
		return sum_carriage;
	}

	public void setSum_carriage(double sum_carriage) {
		this.sum_carriage = sum_carriage;
	}
}
