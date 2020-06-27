package com.isscollege.waybill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.waybill.service.impl.InsertCarriageServiceImpl;

@Controller
@CrossOrigin
@RequestMapping("carriage")
public class CarriageController {
	@Autowired
	private InsertCarriageServiceImpl impl;

	@RequestMapping("sum_carriage")
	@ResponseBody
	public String sum_carriage(int waybill_id) {

		// 得到物流的起始和终止地点
		String start_pos = impl.get_start_pos(waybill_id);
		String end_pos = impl.get_end_pos(waybill_id);

		// 拼接起始、终止地点，使之与距离表的地点存储形式相对应
		String start_end_pos1 = start_pos + "-" + end_pos;
		String start_end_pos2 = end_pos + "-" + start_pos;

		// 得到物流的货物运输距离（单位：公里）
		double distance;
		distance = impl.get_distance(start_end_pos1, start_end_pos2);

		// 得到货物的运输单价（每吨每公里多少钱）
		double carriage;
		carriage = impl.get_carriage_by_wid(waybill_id);

		// 得到货物的运输重量（万吨）
		int log_weight;
		log_weight = impl.get_log_weight(waybill_id);

		// 计算总运费
		double sum_carriage;
		sum_carriage = distance * carriage * log_weight * 10000.0;

		// 将总运费更新到tb_waybills表里
		impl.modify_sum_carriage_by_wid(sum_carriage, waybill_id);
		return "<script>window.parent.location.href='http://10.61.88.30:8082/logistics_system/user/skip'</script>";
	}

	@RequestMapping("test")
	public String test() {

		return "test";
	}
}
