package com.isscollege.contract.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.contract.dao.GetSignedContractDao;
import com.isscollege.contract.entity.Contract;
import com.isscollege.contract.service.impl.GetContractImpl;

@RunWith(SpringRunner.class)

public class contractServiceImplTest {

	private GetContractImpl getContractservice;
	@MockBean
	private GetSignedContractDao getSignedContractDao;

	@Before
	public void setUp() {
		getContractservice = new GetContractImpl(getSignedContractDao);
		when(getSignedContractDao.removeAllContract("20190101")).thenReturn(1);
		when(getSignedContractDao.removeAllContract("20190102")).thenReturn(1);
		when(getSignedContractDao.removeAllContract("20190103")).thenReturn(1);
		when(getSignedContractDao.getContractDetails("20190101")).thenReturn(new Contract());
		when(getSignedContractDao.getContractDetails("20190102")).thenReturn(new Contract());
		when(getSignedContractDao.getContractDetails("20190103")).thenReturn(new Contract());
	}

	@Test
	// 用户取消删除合同的全部数据
	public void test1removeAllContract() {
		String tradeNo = "20190101";
		int except = 1;
		int result = getSignedContractDao.removeAllContract("20190101");
		// when(getSignedContractDao.removeAllContract("20190101")).thenReturn(1);
		assertEquals(except, result);
	}

	@Test
	public void test2removeAllContract() {
		String tradeNo = "20190102";
		int except = 1;
		int result = getSignedContractDao.removeAllContract("20190102");
		// when(getSignedContractDao.removeAllContract("20190102")).thenReturn(1);
		assertEquals(except, result);
	}

	@Test
	public void test3removeAllContract() {
		String tradeNo = "20190103";
		int except = 0;
		int result = getSignedContractDao.removeAllContract("20190103");
		// when(getSignedContractDao.removeAllContract("20190103")).thenReturn(1);
		assertEquals(except, result);
	}

	@Test
	// 向摘牌方展示合同
	public void test1getContractDetails() {
		String tradeNo = "20190101";
		String except = "甲方：乙方";
		String result = getSignedContractDao.getContractDetails("20190101").getContract();
		/*
		 * when(getSignedContractDao.getContractDetails("20190101")).thenReturn(
		 * new Contract());
		 */
		assertEquals(except, result);
	}

	@Test
	public void test2getContractDetails() {
		String tradeNo = "20190102";
		String except = "甲方：乙方";
		String result = getSignedContractDao.getContractDetails("20190102").getContract();
		/*
		 * when(getSignedContractDao.getContractDetails("20190102")).thenReturn(
		 * new Contract());
		 */
		assertEquals(except, result);
	}

	@Test
	public void test3getContractDetails() {
		String tradeNo = "20190103";
		String except = null;
		String result = getSignedContractDao.getContractDetails("20190103").getContract();
		/*
		 * when(getSignedContractDao.getContractDetails("20190103")).thenReturn(
		 * new Contract());
		 */
		assertEquals(except, result);
	}
}
