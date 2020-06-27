package com.isscollege.contract.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractDaoTest {
	@Autowired
	private GetSignedContractDao getSignedContractDao;

	@Test
	// 向摘牌方展示合同
	public void test1getContractDetails() {
		String except = "甲方：乙方";
		String result = getSignedContractDao.getContractDetails("20190101").getContract();
		assertEquals(except, result);
	}

	@Test
	// 向摘牌方展示合同
	public void test2getContractDetails() {
		String except = "甲方：乙方";
		String result = getSignedContractDao.getContractDetails("20190102").getContract();
		assertEquals(except, result);
	}

	@Test
	// 向摘牌方展示合同
	public void test3getContractDetails() {
		String except = null;
		String result = getSignedContractDao.getContractDetails("20190103").getContract();
		assertEquals(except, result);
	}

	@Test
	// 用户取消删除合同的全部数据
	public void test1removeAllContract() {
		int except = 1;
		int result = getSignedContractDao.removeAllContract("20190101");
		assertEquals(except, result);
	}

	@Test
	// 用户取消删除合同的全部数据
	public void test2removeAllContract() {
		int except = 1;
		int result = getSignedContractDao.removeAllContract("20190102");
		assertEquals(except, result);
	}

	@Test
	// 用户取消删除合同的全部数据
	public void test3removeAllContract() {
		int except = 0;
		int result = getSignedContractDao.removeAllContract("20190103");
		assertEquals(except, result);
	}
}
