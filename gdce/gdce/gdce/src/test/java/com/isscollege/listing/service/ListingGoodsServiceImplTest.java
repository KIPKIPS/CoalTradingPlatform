package com.isscollege.listing.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.listing.service.impl.ListingGoodsServiceImpl;

/**
 * @author:Simona @date:2019年6月14日下午4:01:02
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class ListingGoodsServiceImplTest {

	@Autowired
	private ListingGoodsServiceImpl listingGoodsServiceImpl;

	@Test
	public void getAllPurchListingListTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsServiceImpl.getAllPurchListingList() != null
				&& listingGoodsServiceImpl.getAllPurchListingList().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getAllSellerListTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsServiceImpl.getAllSellerListingList() != null
				&& listingGoodsServiceImpl.getAllSellerListingList().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getPurchGoodsByIdTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsServiceImpl.getPurchGoodsById(1) != null
				&& listingGoodsServiceImpl.getPurchGoodsById(1111) == null) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getSellerGoodsByIdTest() {
		boolean result = false;
		boolean except = true;
		if (listingGoodsServiceImpl.getSellerGoodsById(1) != null
				&& listingGoodsServiceImpl.getSellerGoodsById(1111) == null) {
			result = true;
		}
		assertEquals(except, result);
	}

}
