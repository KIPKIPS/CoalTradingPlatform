package com.isscollege.waybill.service;

public interface IInsertCarriageService {

	public String get_start_pos(int waybill_id);

	public String get_end_pos(int waybill_id);

	public double get_distance(String start_end_pos, String start_end_pos1);

	public int get_log_weight(int waybill_id);

	public double get_carriage_by_wid(int waybill_id);

	public int modify_sum_carriage_by_wid(double sum_carriage, int waybill_id);

}
