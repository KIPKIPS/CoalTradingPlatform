package com.isscollege.waybill.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.waybill.entity.WaybillInfo;
import com.isscollege.waybill.service.impl.WaybillInfoServiceImpl;

/**
 * @author whg
 *
 */
@Controller
@RequestMapping("showCheckWaybill")
public class ShowCheckWaybillController {
	@Autowired
	private WaybillInfoServiceImpl waybillInfoServiceImpl;

	// 将waybill信息存入到数据库
	@RequestMapping("insertWaybillInfo")
	@ResponseBody
	public String insertWaybillInfo(String trade_id, String good_source, String good_destination, String lod_name,
			int log_weight) {
		int logistics_id = waybillInfoServiceImpl.getLogistics_id(lod_name);
		waybillInfoServiceImpl.insertWaybillInfo(trade_id, good_source, good_destination, logistics_id, log_weight);
		return "<script>alert('物流信息提交完成') \n history.back()</script>";
	}
	
	@RequestMapping("/showWaybillInfoDetails")
	@ResponseBody
	// 显示待确认运单详细信息
	public ModelAndView showWaybillInfoDetails(String waybill_id) {
		int currentWaybill_id = Integer.parseInt(waybill_id);
		// 查询当前运单
		WaybillInfo waybillInfo = waybillInfoServiceImpl.getWaybillInfoByWaybill_id(currentWaybill_id);
		ModelAndView mav = new ModelAndView("perfectBillInfo", "waybillInfo", waybillInfo);
		return mav;
	}
	
	@RequestMapping("/modifyWaybillInfoDisInfoByWaybill_id")
	@ResponseBody
	// 显示待确认运单详细信息
	public String modifyWaybillInfoDisInfoByWaybill_id(String waybill_id, WaybillInfo waybillInfo) {
		int currentWaybill_id = Integer.parseInt(waybill_id);
		waybillInfo.setWaybill_id(currentWaybill_id);
		int num = waybillInfoServiceImpl.modifyWaybillInfoDisInfoByWaybill_id(waybillInfo);
		if (num > 0) {
			return "<script>alert('完善信息成功！') \n history.back()</script>";
		}
		return "<script>alert('完善信息失败！当前物流信息异常') \n history.back()</script>";
	}
	

	// 查询待确认表单
	@RequestMapping("/getCheckWaybillInfo")
	public String getCheckWaybillInfo(HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<WaybillInfo> waybillList = waybillInfoServiceImpl.getCheckWaybillInfo();
		PageInfo<WaybillInfo> pageInfo = new PageInfo<WaybillInfo>(waybillList);
		req.setAttribute("waybillList", waybillList);
		req.setAttribute("pageInfo", pageInfo);
		return "checkWaybillInfo";
	}
	
	// 分页
	@RequestMapping("/page")
	public String page(Integer pageNum, Integer maxPage, HttpServletRequest req) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}

		PageHelper.startPage(pageNum, 3);
		List<WaybillInfo> waybillList = waybillInfoServiceImpl.getCheckWaybillInfo();
		PageInfo<WaybillInfo> pageInfo = new PageInfo<WaybillInfo>(waybillList);
		req.setAttribute("waybillList", waybillList);
		req.setAttribute("pageInfo", pageInfo);
		return "checkWaybillInfo";
	}
}
