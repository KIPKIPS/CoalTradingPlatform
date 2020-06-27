package com.isscollege.waybill.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isscollege.waybill.entity.FinalInfo;
import com.isscollege.waybill.entity.WaybillInfo;
import com.isscollege.waybill.service.impl.WaybillInfoServiceImpl;

@Controller
@CrossOrigin
@RequestMapping("waybill")
public class WaybillInfoController {
	// 日志־
	private static final Logger LOG = Logger.getLogger(WaybillInfoController.class);

	@Autowired
	private WaybillInfoServiceImpl waybillInfoServiceImpl;

	// 将waybill信息存入到数据库 从外部获取订单号、货源地、收货地、物流商名字和重量
	@RequestMapping("insertWaybillInfo")
	@ResponseBody
	public String insertWaybillInfo(String trade_id, String good_source, String good_destination, String lod_name,
			double log_weight) {
		LOG.info("插入的订单号" + trade_id + ";货源地" + good_source + ";收货地:" + good_destination + ";物流商名字:" + lod_name + ";重量:"
				+ log_weight);
		int logistics_id = waybillInfoServiceImpl.getLogistics_id(lod_name);// 从物流商名字查询得到ID并存入数据库
		waybillInfoServiceImpl.insertWaybillInfo(trade_id, good_source, good_destination, logistics_id, log_weight);
		return "success";
	}

	// 通过tradeNo查询状态为0运单信息并返回一个object，其中包含所有运单信息
	@RequestMapping("getState0InfoByTradeNo")
	@ResponseBody
	public Object getState0InfoByTradeNo(String tradeNo) throws JsonProcessingException {
		String trade_id = tradeNo;
		LOG.info("接收到的运单号" + trade_id);
		FinalInfo waybillInfo = waybillInfoServiceImpl.getState0InfoByTradeNo(trade_id);
		if (waybillInfo != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonStr;
			jsonStr = objectMapper.writeValueAsString(waybillInfo);
			LOG.info("运单信息" + jsonStr);
			return jsonStr;
		} else {
			System.out.println("null");
			return null;
		}
	}

	// 通过tradeNo查询状态为1运单信息并返回一个object，其中包含所有运单信息
	@RequestMapping("getState1InfoByTradeNo")
	@ResponseBody
	public Object getState1InfoByTradeNo(String tradeNo) throws JsonProcessingException {
		String trade_id = tradeNo;
		LOG.info("接收到的运单号" + trade_id);
		FinalInfo waybillInfo = waybillInfoServiceImpl.getState1InfoByTradeNo(trade_id);
		if (waybillInfo != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonStr;
			jsonStr = objectMapper.writeValueAsString(waybillInfo);
			LOG.info("运单信息" + jsonStr);
			return jsonStr;
		} else {
			System.out.println("null");
			return null;
		}
	}

	// 通过tradeNo查询状态为2运单信息并返回一个object，其中包含所有运单信息
	@RequestMapping("getState2InfoByTradeNo")
	@ResponseBody
	public Object getState2InfoByTradeNo(String tradeNo) throws JsonProcessingException {
		String trade_id = tradeNo;
		LOG.info("接收到的运单号" + trade_id);
		FinalInfo waybillInfo = waybillInfoServiceImpl.getState2InfoByTradeNo(trade_id);
		if (waybillInfo != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonStr;
			jsonStr = objectMapper.writeValueAsString(waybillInfo);
			LOG.info("运单信息" + jsonStr);
			return jsonStr;
		} else {
			System.out.println("null");
			return null;
		}
	}

	@RequestMapping("test")
	public String test() {
		return "test";
	}

	@RequestMapping("/showWaybillInfoDetails")
	@ResponseBody
	// 显示待确认运单详细信息
	public ModelAndView showWaybillInfoDetails(String waybill_id) {
		LOG.info("当前运单号" + waybill_id);
		int currentWaybill_id = Integer.parseInt(waybill_id);
		// 查询当前运单
		WaybillInfo waybillInfo = waybillInfoServiceImpl.getWaybillInfoByWaybill_id(currentWaybill_id);
		LOG.info("运单详细信息" + waybillInfo);
		ModelAndView mav = new ModelAndView("complete_info", "waybillInfo", waybillInfo);
		return mav;
	}

	@RequestMapping("/modifyWaybillInfoDisInfoByWaybill_id")
	@ResponseBody
	// 显示待确认运单详细信息
	public String modifyWaybillInfoDisInfoByWaybill_id(String waybill_id, WaybillInfo waybillInfo) {
		int currentWaybill_id = Integer.parseInt(waybill_id);
		waybillInfo.setWaybill_id(currentWaybill_id);
		LOG.info("当前运单需要填写的信息：" + waybillInfo);
		int num = waybillInfoServiceImpl.modifyWaybillInfoDisInfoByWaybill_id(waybillInfo);
		if (num > 0) {

			return "<script>alert('完善信息成功！') \n "
					+ "location.href='http://10.61.88.30:8082/logistics_system/carriage/sum_carriage?waybill_id="
					+ waybill_id + "'</script>";
		}
		return "<script>alert('完善信息失败！当前物流信息异常') \n history.back()</script>";
	}

	// 通过接受多个tradeNo并以list的形式返回多个信息 状态为0
	@RequestMapping("/getState0InfoByList")
	@ResponseBody
	public Object getState0InfoByList(@RequestBody List<String> tradeIDList) throws JsonProcessingException {
		List<FinalInfo> logisticsList = new ArrayList<FinalInfo>();
		LOG.info("接收的订单表" + tradeIDList);
		for (int i = 0; i < tradeIDList.size(); i++) {
			String trade_id = tradeIDList.get(i);
			FinalInfo waybillInfo = waybillInfoServiceImpl.getState0InfoByTradeNo(trade_id);
			if (waybillInfo != null) {
				logisticsList.add(waybillInfo);
			}
		}
		LOG.info("运单信息" + logisticsList);
		return logisticsList;
	}

	// 通过接受多个tradeNo并以list的形式返回多个信息 状态为1
	@RequestMapping("/getState1InfoByList")
	@ResponseBody
	public Object getState1InfoByList(@RequestBody List<String> tradeIDList) throws JsonProcessingException {
		List<FinalInfo> logisticsList = new ArrayList<FinalInfo>();
		LOG.info("接收的订单表" + tradeIDList);
		for (int i = 0; i < tradeIDList.size(); i++) {
			String trade_id = tradeIDList.get(i);
			FinalInfo waybillInfo = waybillInfoServiceImpl.getState1InfoByTradeNo(trade_id);
			if (waybillInfo != null) {
				logisticsList.add(waybillInfo);
			}
		}
		LOG.info("运单信息" + logisticsList);
		return logisticsList;
	}

	// 通过接受多个tradeNo并以list的形式返回多个信息 状态为2
	@RequestMapping("/getState2InfoByList")
	@ResponseBody
	public Object getState2InfoByList(@RequestBody List<String> tradeIDList) throws JsonProcessingException {
		List<FinalInfo> logisticsList = new ArrayList<FinalInfo>();
		LOG.info("接收的订单表" + tradeIDList);
		for (int i = 0; i < tradeIDList.size(); i++) {
			String trade_id = tradeIDList.get(i);
			FinalInfo waybillInfo = waybillInfoServiceImpl.getState2InfoByTradeNo(trade_id);
			if (waybillInfo != null) {
				logisticsList.add(waybillInfo);
			}
		}
		LOG.info("运单信息" + logisticsList);
		return logisticsList;
	}
}
