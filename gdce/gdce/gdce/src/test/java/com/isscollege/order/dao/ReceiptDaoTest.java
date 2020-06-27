package com.isscollege.order.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptDaoTest {

	@Autowired
	private ReceiptDao receiptDao;

	@Test
	public void modifyOrderStateAndReceiptSrcTest() {
		String path = "201906170101/bankreceipt.jpg";
		String tradeNo = "201906170101";
		assertEquals(1, receiptDao.modifyOrderStateAndReceiptSrc(path, tradeNo));
	}

	@Test
	public void getTradeNoTest() {
		String orderNo = "20190617160618101";
		assertEquals("201906170101", receiptDao.getTradeNo(orderNo));
	}

	@Test
	public void getTransactionByTradeNo() {
		String tradeNo = "201906170101";
		assertNotNull(receiptDao.getTransactionByTradeNo(tradeNo));
	}

	@Test
	public void modifyReceiptStateByTradeNo() {
		String tradeNo = "201906170101";
		String receiptState = "0";
		assertEquals(1, receiptDao.modifyReceiptStateByTradeNo(tradeNo, receiptState));
	}

	@Test
	public void getListNoByTradeNo() {
		String tradeNo = "201906170101";
		int listNo = 1;
		assertEquals(listNo, receiptDao.getListNoByTradeNo(tradeNo));
	}

}
