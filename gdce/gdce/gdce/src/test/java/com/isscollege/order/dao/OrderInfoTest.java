package com.isscollege.order.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.order.entity.OrderInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoTest {

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Test
	// 测试创建一个订单
	public void testAddOrderInfo() {
		Integer expected = 1;
		Integer result = orderInfoDao.addOrderInfo(new OrderInfo("201906211442", "201906211443", "0",
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
		assertEquals(expected, result);
	}

	@Test
	// 测试根据交易编号查询订单编号
	public void testQueryOrderNo() {
		String expected = "201906211442";
		String result = orderInfoDao.queryOrderNo("201906211443");
		assertEquals(expected, result);
	}

	@Test
	// 测试修改合同状态
	public void testModifyContractState() {
		Integer expected = 1;
		Integer result = orderInfoDao.modifyContractState("01", "201906170101");
		assertEquals(expected, result);
	}

	@Before
	// 用于单独执行后面的测试写分割方法
	public void setup() {
	}

	@Test
	// 测试查询订单列表12_1(查找用户作为卖方挂牌的不同状态的订单,来源为卖方挂牌，订单状态为待付款)
	public void testQueryOrderList_1_0_s() {
		assertNotNull(orderInfoDao.queryOrderList_list_seller(1, "1", "0"));
	}

	@Test
	// 测试查询订单列表12_2(查找用户作为卖方挂牌的不同状态的订单,来源为卖方挂牌，订单状态为待发货)
	public void testQueryOrderList_1_1_s() {
		assertNotNull(orderInfoDao.queryOrderList_list_seller(1, "1", "1"));
	}

	@Test
	// 测试查询订单列表12_3(查找用户作为卖方挂牌的不同状态的订单,来源为买方挂牌，订单状态为已发货)
	public void testQueryOrderList_2_2_s() {
		assertNotNull(orderInfoDao.queryOrderList_list_seller(1, "2", "2"));
	}

	@Test
	// 测试查询订单列表12_4(查找用户作为卖方挂牌的不同状态的订单,来源为买方挂牌，订单状态为确认收货)
	public void testQueryOrderList_2_3_s() {
		assertNotNull(orderInfoDao.queryOrderList_list_seller(1, "2", "3"));
	}

	@Test
	// 测试查询订单列表12_5(查找用户作为买方挂牌的不同状态的订单,来源为卖方挂牌，订单状态为待付款)
	public void testQueryOrderList_1_0_p() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "1", "0"));
	}

	@Test
	// 测试查询订单列表12_6(查找用户作为买方挂牌的不同状态的订单,来源为卖方挂牌，订单状态为待发货)
	public void testQueryOrderList_1_1_p() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "1", "1"));
	}

	@Test
	// 测试查询订单列表12_7(查找用户作为买方挂牌的不同状态的订单,来源为买方挂牌，订单状态为已发货)
	public void testQueryOrderList_2_2_p() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "2", "2"));
	}

	@Test
	// 测试查询订单列表12_8(查找用户作为买方挂牌的不同状态的订单,来源为买方挂牌，订单状态为确认收货)
	public void testQueryOrderList_2_3_p() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "2", "3"));
	}

	@Test
	// 测试查询订单列表12_9(查找用户摘牌的不同状态的订单,来源为卖方挂牌，订单状态为待付款)
	public void testQueryOrderList_1_0() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "1", "0"));
	}

	@Test
	// 测试查询订单列表12_10(查找用户摘牌的不同状态的订单,来源为卖方挂牌，订单状态为待发货)
	public void testQueryOrderList_1_1() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "1", "1"));
	}

	@Test
	// 测试查询订单列表12_11(查找用户摘牌的不同状态的订单,来源为买方挂牌，订单状态为已发货)
	public void testQueryOrderList_2_2() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "2", "2"));
	}

	@Test
	// 测试查询订单列表12_12(查找用户摘牌的不同状态的订单,来源为买方挂牌，订单状态为确认收货)
	public void testQueryOrderList_2_3() {
		assertNotNull(orderInfoDao.queryOrderList_list_purch(1, "2", "3"));
	}

}
