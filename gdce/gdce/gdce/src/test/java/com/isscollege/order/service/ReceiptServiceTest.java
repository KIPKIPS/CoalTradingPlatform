package com.isscollege.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.order.dao.ReceiptDao;
import com.isscollege.order.entity.Transaction;
import com.isscollege.order.service.impl.ReceiptServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
// 集成测试
// public class ReceiptServiceTest {
// @Autowired
// private ReceiptServiceImpl service;
//
// @Test
// public void testModifyOrderStateAndReceiptSrc() {
// assertEquals(1,
// service.modifyOrderStateAndReceiptSrc("201906170101/bankreceipt.jpg",
// "201906170101"));
// }
//
// @Test
// public void testGetTradeNo() {
// assertEquals("201906170101", service.getTradeNo("20190617160618101"));
// }
// }

// 单元测试
public class ReceiptServiceTest {
	private ReceiptServiceImpl service;

	@MockBean
	private ReceiptDao receiptDao;

	@Before
	public void setup() {
		service = new ReceiptServiceImpl(receiptDao);
		when(receiptDao.getTradeNo("20190617160618101")).thenReturn("201906170101");
		when(receiptDao.modifyOrderStateAndReceiptSrc("201906170101/bankreceipt.jpg", "201906170101")).thenReturn(1);
		when(receiptDao.getTransactionByTradeNo("201906170101")).thenReturn(new Transaction());
		when(receiptDao.getListNoByTradeNo("201906170101")).thenReturn(1);
		when(receiptDao.modifyReceiptStateByTradeNo("201906170101", "0")).thenReturn(1);
	}

	@Test
	public void testGetTradeNo() {
		assertEquals("201906170101", service.getTradeNo("20190617160618101"));
	}

	@Test
	public void testModifyOrderStateAndReceiptSrc() {
		assertEquals(1, service.modifyOrderStateAndReceiptSrc("201906170101/bankreceipt.jpg", "201906170101"));
	}

	@Test
	public void testGetTransactionByTradeNo() {
		assertNotNull(receiptDao.getTransactionByTradeNo("201906170101"));
	}

	@Test
	public void testGetListNoByTradeNo() {
		assertEquals(1, receiptDao.getListNoByTradeNo("201906170101"));
	}

	@Test
	public void testModifyReceiptStateByTradeNo() {
		assertEquals(1, receiptDao.modifyReceiptStateByTradeNo("201906170101", "0"));
	}

}