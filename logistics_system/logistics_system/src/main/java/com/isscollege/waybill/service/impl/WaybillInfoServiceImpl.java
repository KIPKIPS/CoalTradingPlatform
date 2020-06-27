package com.isscollege.waybill.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isscollege.waybill.dao.WaybillInfoDao;
import com.isscollege.waybill.entity.FinalInfo;
import com.isscollege.waybill.entity.WaybillInfo;
import com.isscollege.waybill.service.IWaybillInfoService;

@Repository
public class WaybillInfoServiceImpl implements IWaybillInfoService {

	@Autowired
	WaybillInfoDao waybillInfoDao;

	// 插入数据
	@Override
	public int insertWaybillInfo(String trade_id, String good_source, String good_destination, int logistics_id,
			double log_weight) {
		return waybillInfoDao.insertWaybillInfo(trade_id, good_source, good_destination, logistics_id, log_weight);
	}

	// 通过trade_id查询状态为未确认的运单的数据
	@Override
	public FinalInfo getState0InfoByTradeNo(String trade_id) {
		WaybillInfo waybillInfo = waybillInfoDao.getState0InfoByTradeNo(trade_id);
		if (waybillInfo != null) {
			FinalInfo finalInfo = new FinalInfo(waybillInfo);
			return finalInfo;
		} else
			return null;
	}

	// 通过trade_id查询状态为已确认的运单的数据
	@Override
	public FinalInfo getState1InfoByTradeNo(String trade_id) {
		WaybillInfo waybillInfo = waybillInfoDao.getState1InfoByTradeNo(trade_id);
		if (waybillInfo != null) {
			FinalInfo finalInfo = new FinalInfo(waybillInfo);
			return finalInfo;
		} else
			return null;
	}

	// 通过trade_id查询状态为已完成的运单的数据
	@Override
	public FinalInfo getState2InfoByTradeNo(String trade_id) {
		WaybillInfo waybillInfo = waybillInfoDao.getState2InfoByTradeNo(trade_id);
		if (waybillInfo != null) {
			FinalInfo finalInfo = new FinalInfo(waybillInfo);
			return finalInfo;
		} else
			return null;
	}

	@Override
	public WaybillInfo getWaybillInfoByWaybill_id(int waybill_id) {
		return waybillInfoDao.getWaybillInfoByWaybill_id(waybill_id);
	}

	@Override
	public int modifyWaybillInfoDisInfoByWaybill_id(WaybillInfo waybillInfo) {
		// 获取当前系统时间
		Timestamp trs_time = new Timestamp(System.currentTimeMillis());
		waybillInfo.setGood_trs_time(trs_time);
		// 修改状态
		waybillInfo.setDis_status(1);

		return waybillInfoDao.modifyWaybillInfoDisInfoByWaybill_id(waybillInfo);
	}

	@Override
	public List<WaybillInfo> getCheckWaybillInfo() {

		return waybillInfoDao.getCheckWaybillInfo();
	}

	@Override
	public List<WaybillInfo> getFinishedWaybillInfo() {

		return waybillInfoDao.getFinishedWaybillInfo();
	}

	// 通过物流商名称得到对应ID
	@Override
	public int getLogistics_id(String lod_name) {

		return waybillInfoDao.getLogistics_id(lod_name);
	}

}
