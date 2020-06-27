package com.isscollege.order.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.contract.dao.GetSignedContractDao;
import com.isscollege.order.dao.OrderInfoDao;
import com.isscollege.order.entity.OrderInfo;
import com.isscollege.order.service.impl.OrderInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;

@RunWith(SpringRunner.class)
public class OrderInfoServiceImplTest {

	private OrderInfoServiceImpl orderInfoService;

	@MockBean
	private OrderInfoDao orderInfoDao;

	@MockBean
	private GetSignedContractDao getSignedContract;

	@Before
	public void setup() {
		orderInfoService = new OrderInfoServiceImpl();
		// 单元测试不会自动将Dao注入，相当于一个手动注入Dao的过程
		orderInfoService.setOrderInfoDao(orderInfoDao);

		when(getSignedContract.queryContractState("201906170102")).thenReturn("2");
		when(orderInfoDao.modifyContractState("1", "201906170102")).thenReturn(1);
	}

	@Test
	// 测试查询合同状态
	public void testQueryContractState() {
		String expected = "2";
		String result = getSignedContract.queryContractState("201906170102");
		assertEquals(expected, result);
	}

	@Test
	// 测试修改合同状态
	public void testModifyContractState() {
		Integer expected = 1;
		Integer result = orderInfoService.modifyContractState("1", "201906170102");
		assertEquals(expected, result);
	}

	// 查询订单列表测试的前置参数
	Login_Info trader = new Login_Info(1, "小张", "123456", "1", "1");
	String state = "0";
	OrderInfo orderInfo = new OrderInfo("20190706123", "2019070612", "0", new Timestamp(2019 - 07 - 06),
			new Timestamp(2019 - 07 - 06));

	@Test
	// 查询买方挂牌订单
	public void testQueryOrderList_list_purch() {
		orderInfoService = new OrderInfoServiceImpl();
		// 单元测试不会自动将Dao注入，相当于一个手动注入Dao的过程
		orderInfoService.setOrderInfoDao(orderInfoDao);
		List<OrderInfo> expected = new ArrayList<OrderInfo>();
		expected.add(orderInfo);
		given(orderInfoDao.queryOrderList_list_purch(trader.getuID(), "2", state)).willReturn(expected);

		List<OrderInfo> result = orderInfoService.queryOrderList(trader, "buy", "list", state);
		assertEquals(expected, result);
	}

	@Test
	// 查询买方摘牌订单
	public void testQueryOrderList_delist_purch() {
		orderInfoService = new OrderInfoServiceImpl();
		// 单元测试不会自动将Dao注入，相当于一个手动注入Dao的过程
		orderInfoService.setOrderInfoDao(orderInfoDao);
		List<OrderInfo> expected = new ArrayList<OrderInfo>();
		expected.add(orderInfo);
		given(orderInfoDao.queryOrderList_delist(trader.getuID(), "1", state)).willReturn(expected);

		List<OrderInfo> result = orderInfoService.queryOrderList(trader, "buy", "delist", state);
		assertEquals(expected, result);
	}

	@Test
	// 查询卖方挂牌订单
	public void testQueryOrderList_list_seller() {
		orderInfoService = new OrderInfoServiceImpl();
		// 单元测试不会自动将Dao注入，相当于一个手动注入Dao的过程
		orderInfoService.setOrderInfoDao(orderInfoDao);
		List<OrderInfo> expected = new ArrayList<OrderInfo>();
		expected.add(orderInfo);
		given(orderInfoDao.queryOrderList_list_seller(trader.getuID(), "1", state)).willReturn(expected);

		List<OrderInfo> result = orderInfoService.queryOrderList(trader, "sell", "list", "0");
		assertEquals(expected, result);
	}

	@Test
	// 查询卖方摘牌订单
	public void testQueryOrderList_delist_seller() {
		orderInfoService = new OrderInfoServiceImpl();
		// 单元测试不会自动将Dao注入，相当于一个手动注入Dao的过程
		orderInfoService.setOrderInfoDao(orderInfoDao);
		List<OrderInfo> expected = new ArrayList<OrderInfo>();
		expected.add(orderInfo);
		given(orderInfoDao.queryOrderList_delist(trader.getuID(), "2", state)).willReturn(expected);

		List<OrderInfo> result = orderInfoService.queryOrderList(trader, "sell", "delist", "0");
		assertEquals(expected, result);
	}
}
