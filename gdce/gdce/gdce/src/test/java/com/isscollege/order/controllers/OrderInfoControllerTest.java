package com.isscollege.order.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.pagehelper.PageInfo;
import com.isscollege.order.entity.OrderInfo;
import com.isscollege.order.service.impl.OrderInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderInfoController.class)
public class OrderInfoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderInfoServiceImpl orderInfoService;

	@Test
	public void testAddOrder() throws Exception {
		given(orderInfoService.addOrder("201906211443")).willReturn(1);
		mockMvc.perform(get("/order/create").param("tradeNo", "201906211443")).andExpect(status().is3xxRedirection());

	}

	@Test
	// 测试查询订单列表
	public void testShowOrderList() throws Exception {
		List<OrderInfo> expected = new ArrayList<OrderInfo>();
		expected.add(new OrderInfo());
		given(orderInfoService.queryOrderList(new Login_Info(1, "小张", "123456", "1", "1"), "buy", "list", "0"))
				.willReturn(expected);
		PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(expected);
		Object[] object = { pageInfo, expected };

		// 测试接受post请求的 controller
		mockMvc.perform(post("/order/showOrderList").requestAttr("pageNum", "1").requestAttr("pages", "1")
				.requestAttr("orderClass", "buy").requestAttr("orderSource", "list"))
				.andExpect(status().is3xxRedirection());

	}

}
