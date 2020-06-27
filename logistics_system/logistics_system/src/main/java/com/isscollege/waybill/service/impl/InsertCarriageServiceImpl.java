package com.isscollege.waybill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isscollege.waybill.dao.CarriageDao;
import com.isscollege.waybill.service.IInsertCarriageService;

@Repository
public class InsertCarriageServiceImpl implements IInsertCarriageService {

	@Autowired
	CarriageDao carriageDao;

	@Override
	public String get_start_pos(int waybill_id) {

		return carriageDao.get_start_pos(waybill_id);
	}

	@Override
	public String get_end_pos(int waybill_id) {

		return carriageDao.get_end_pos(waybill_id);
	}

	@Override
	public double get_distance(String start_end_pos, String strat_end_pos1) {

		return carriageDao.get_distance(start_end_pos, strat_end_pos1);
	}

	@Override
	public int get_log_weight(int waybill_id) {

		return carriageDao.get_log_weight(waybill_id);
	}

	@Override
	public double get_carriage_by_wid(int waybill_id) {

		return carriageDao.get_carriage_by_wid(waybill_id);
	}

	@Override
	public int modify_sum_carriage_by_wid(double sum_carriage, int waybill_id) {

		return carriageDao.modify_sum_carriage_by_wid(sum_carriage, waybill_id);
	}

}
