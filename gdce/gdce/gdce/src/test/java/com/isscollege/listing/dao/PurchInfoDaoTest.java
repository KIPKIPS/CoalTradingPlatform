package com.isscollege.listing.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.listing.entity.Purch_Info;

/*
 * 测试PurchInfoDao
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PurchInfoDaoTest {

	@Autowired
	private PurchInfoDao purchInfoDao;

	@Test
	public void PurchInfoDaoAddPurchInfoTest() {
		Purch_Info purch_Info = new Purch_Info(null, "国电煤炭交易平台-2019-6-14", "张天一", "李蒙", null,
				new Date("Sat Jun 15 00:00:00 CST 2019"), new Date("Sat Jun 22 00:00:00 CST 2019"), "烟煤", "原煤", 20.0,
				"火车", "陕西省咸阳市", "一票结算", "到场第三方验收", "交通银行", 10.0, 10.0, 5500.0, 20.0, 20.0, 10.0, 10.0, 20.0, 15.0, 20.0,
				10.0, 20.0, 5500.0, 20.0, 10.0, 20.0, 1000.0, 5000.0, 15.0, "以上信息用作测试", "0", 2, -1, 1300.0, 110.0, null,
				null, null);
		assertEquals(1, purchInfoDao.addPurchInfo(purch_Info));

	}

	@Test
	public void PurchInfoDaoAddPurchInfoTest1() {
		Purch_Info purch_Info = new Purch_Info(null, "国电煤炭交易平台-2019-6-15", "张请", "王丕", null,
				new Date("Sat Jun 17 00:00:00 CST 2019"), new Date("Sat Jun 25 00:00:00 CST 2019"), "烟煤", "原煤", 30.0,
				"汽车", "河北省邯郸市", "一票结算", "到场第三方验收", "", 10.0, 20.0, 5500.0, 20.0, 20.0, 20.0, 30.0, 20.0, 15.0, 20.0,
				10.0, 20.0, 5500.0, 20.0, 10.0, 20.0, 2000.0, 7000.0, 20.0, "以上信息用作测试", "0", 2, -1, 1400.0, 120.0, null,
				null, null);
		assertEquals(1, purchInfoDao.addPurchInfo(purch_Info));

	}

	@Test
	public void PurchInfoDaoAddPurchInfoTest2() {
		Purch_Info purch_Info = new Purch_Info(null, "国电煤炭交易平台-2019-6-6", "刘一平", "张欣欣", null,
				new Date("Sat Jun 15 00:00:00 CST 2019"), new Date("Sat Jun 22 00:00:00 CST 2019"), "烟煤", "原煤", 20.0,
				"飞机", "浙江省杭州市", "一票结算", "到场第三方验收", "交通银行", 10.0, 20.0, 5600.0, 20.0, 20.0, 70.0, 80.0, 80.0, 15.0, 20.0,
				10.0, 10.0, 5500.0, 10.0, 10.0, 20.0, 1500.0, 5000.0, 15.0, "以上信息用作测试", "0", 2, -1, 1300.0, 120.0, null,
				null, null);
		assertEquals(1, purchInfoDao.addPurchInfo(purch_Info));

	}

}
