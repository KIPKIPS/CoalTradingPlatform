package com.isscollege.listing.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Simona @date:2019年6月14日下午2:30:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListingGoodsDaoTest {

	@Autowired
	private ListingGoodsDao listingGoodsDao;

	@Test
	public void getAllPurchListTest() {
		boolean result = false;
		boolean except = true;

		if (listingGoodsDao.getAllPurchList() != null && listingGoodsDao.getAllPurchList().size() > 0) {
			result = true;
		}

		assertEquals(except, result);

	}

	@Test
	public void getAllSellerListTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsDao.getAllSellerList() != null && listingGoodsDao.getAllSellerList().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getPurchGoodsByIdTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsDao.getPurchGoodsById(1) != null && listingGoodsDao.getPurchGoodsById(1111) == null) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getSellerGoodsByIdTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsDao.getSellerGoodsById(1) != null && listingGoodsDao.getSellerGoodsById(1111) == null) {
			result = true;
		}
		assertEquals(except, result);
	}

}
