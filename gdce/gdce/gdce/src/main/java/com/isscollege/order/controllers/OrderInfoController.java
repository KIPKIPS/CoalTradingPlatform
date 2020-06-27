package com.isscollege.order.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.order.entity.OrderDetails;
import com.isscollege.order.entity.OrderInfo;
import com.isscollege.order.service.impl.OrderInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;

@Controller
@RequestMapping("order")
public class OrderInfoController {

	@Autowired
	private OrderInfoServiceImpl orderInfoService;

	/*
	 * 合同确认之后生成订单
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String addOrder(String tradeNo, String contractState) {
		// 先判断合同状态，未确定则修改合同状态
		if (!contractState.equals("11")) {
			// 修改合同状态成功
			if (orderInfoService.modifyContractState("11", tradeNo) == 1) {
				// System.out.println("success");
				// 生成订单成功
				if (orderInfoService.addOrder(tradeNo) == 1) {
					return "success";
				}
			}
		}
		return "false";
	}

	/*
	 * 查看订单
	 */
	@RequestMapping("/show")
	@ResponseBody
	public ModelAndView showOrder(String tradeNo) {
		OrderDetails orderDetails = orderInfoService.queryOrderDetails(tradeNo);
		ModelAndView mav = new ModelAndView("orderDetails", "orderDetails", orderDetails);
		return mav;
	}

	/*
	 * 查看订单列表
	 */
	@RequestMapping("/showOrderList")
	@ResponseBody
	public Object[] showOrderList(Integer pageNum, Integer pages, String orderClass, String orderSource,
			String orderState, HttpSession session, HttpServletRequest req) {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= pages) {
			pageNum = pages;
		}
		PageHelper.startPage(pageNum, 15);// 通过拦截最近的一条sql语句进行分页，对于直接插数据建立的list不会分页
		List<OrderInfo> orderList = orderInfoService.queryOrderList(trader, orderClass, orderSource, orderState);
		PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(orderList);
		Object[] object = { pageInfo, orderList };
		return object;
	}

	/**
	 * @param orderList
	 * @return
	 */
	private String type(List<OrderInfo> orderList) {
		// TODO Auto-generated method stub
		return null;
	}

}
