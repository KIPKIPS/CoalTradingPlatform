package com.isscollege.listing.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.impl.SellerInfoServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoServiceImplTest {

	@Autowired
	SellerInfoServiceImpl sellerInfoServiceImpl;

	@Test
	public void SellerInfoServiceImplAddSellerInfoTest() {

		Seller_Info seller_info = new Seller_Info(111, 1.0, 5500.0, 325.0, 1.2, "大同", 10.0, 30.0, 40.0, "天津港", 2.5,
				12.0, "0", 1, -1, "烟煤", "火车", null, null, null);
		assertEquals(1, sellerInfoServiceImpl.addSellerInfo(seller_info));

	}

	@Test
	public void SellerInfoDaoAddSellerInfoTest1() {
		Seller_Info seller_info = new Seller_Info(111, 1.0, 5500.0, 325.0, 1.2, "多伦", 10.0, 50.0, 60.0, "连云港", 3.5,
				15.0, "0", 1, -1, "原煤", "汽车", null, null, null);
		assertEquals(1, sellerInfoServiceImpl.addSellerInfo(seller_info));

	}

	@Test
	public void SellerInfoDaoAddSellerInfoTest2() {
		Seller_Info seller_info = new Seller_Info(111, 1.0, 5500.0, 325.0, 1.2, "长庆", 10.0, 30.0, 40.0, "上海港", 4.5,
				20.0, "0", 1, -1, "原煤", "飞机", null, null, null);
		assertEquals(1, sellerInfoServiceImpl.addSellerInfo(seller_info));

	}

}
