package com.isscollege.contract.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractDaoTestForLmy {
	@Autowired
	private GetSignedContractDao getSignedContractDao;

	@Test
	// 摘牌方未确认的合同
	// 用户"10014"对于200000001号合同未进行确认
	public void testgetUnsignedContract() {
		String result = getSignedContractDao.getUnsignedContract(10014).get(0).getTradeNo();
		assertEquals("200000001", result);
	}

	@Test
	// 挂牌方已上传并确认的合同
	// 用户"10013"对于200000001号合同已进行确认并上传
	public void testgetSignedContract() {
		String result = getSignedContractDao.getSignedContract(10013).get(0).getTradeNo();
		assertEquals("200000001", result);
	}

	@Test
	// 双方都已确认的合同
	// 用户"10014"和用户"10013"都对200000003号合同进行了确认
	public void testgetBothSignedContract() {
		String result = getSignedContractDao.getAllSignedContract(10014).get(0).getTradeNo();
		assertEquals("200000003", result);
	}

	@Test
	// 修改合同状态，将其改为11
	public void testmodifyContractStateInto11() {
		int result = getSignedContractDao.modifyContractStateInto11("200000001");
		assertEquals(1, result);
	}
}
