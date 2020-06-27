package com.isscollege.waybill.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.waybill.entity.tb_waybills_entity;
import com.isscollege.waybill.service.impl.show_finished_serviceimpl;

@Controller
@RequestMapping("ShowFinished")
public class show_finished_controller {
	@Autowired
	show_finished_serviceimpl impl;

	@RequestMapping("/showlist")
	public String ShowList(HttpServletRequest req) throws Exception {
		PageHelper.startPage(1, 10);
		List<tb_waybills_entity> tList = impl.ShowList();
		PageInfo<tb_waybills_entity> pageInfo = new PageInfo<tb_waybills_entity>(tList);
		req.setAttribute("tList", tList);
		req.setAttribute("pageInfo", pageInfo);
		return "finished_list";
	}

	@RequestMapping("/showone")
	public String ShowOne(HttpServletRequest req, @RequestParam("waybill_id") int uid) throws Exception {
		tb_waybills_entity tr = impl.showOne(uid);
		req.setAttribute("tr", tr);
		return "finished_one";
	}

	@RequestMapping("/arrive")
	public String arrive(HttpServletRequest req, @RequestParam("waybill_id") int waybill_id) throws Exception {
		Timestamp ArriveTime = new Timestamp(System.currentTimeMillis());
		impl.arrive(waybill_id, ArriveTime);
		return "redirect:/ShowFinished/showlist";
	}

	@RequestMapping("/page")
	public String page(Integer pageNum, Integer maxPage, HttpServletRequest req) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}

		PageHelper.startPage(pageNum, 10);
		List<tb_waybills_entity> tList = impl.ShowList();
		PageInfo<tb_waybills_entity> pageInfo = new PageInfo<tb_waybills_entity>(tList);
		req.setAttribute("tList", tList);
		req.setAttribute("pageInfo", pageInfo);
		return "finished_list";

	}
}
