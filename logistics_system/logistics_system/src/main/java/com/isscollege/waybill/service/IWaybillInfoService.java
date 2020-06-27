package com.isscollege.waybill.service;

import java.util.List;

import com.isscollege.waybill.entity.FinalInfo;
import com.isscollege.waybill.entity.WaybillInfo;

public interface IWaybillInfoService {

	int insertWaybillInfo(String trade_id, String good_source, String good_destination, int logistics_id,
			double log_weight);

	FinalInfo getState0InfoByTradeNo(String trade_id);

	FinalInfo getState1InfoByTradeNo(String trade_id);

	FinalInfo getState2InfoByTradeNo(String trade_id);

	// 通过运单号获取运单信息
	public abstract WaybillInfo getWaybillInfoByWaybill_id(int waybill_id);

	// 通过运单号修改运单配送信息
	public abstract int modifyWaybillInfoDisInfoByWaybill_id(WaybillInfo waybillInfo);

	// 通过物流商名称得到对应ID
	public int getLogistics_id(String lod_name);

	List<WaybillInfo> getCheckWaybillInfo();

	List<WaybillInfo> getFinishedWaybillInfo();
}