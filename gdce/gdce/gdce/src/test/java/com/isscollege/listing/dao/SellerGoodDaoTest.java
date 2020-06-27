package com.isscollege.listing.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 作者：殷研 2019年 7月11日 上午9:58:56
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerGoodDaoTest {

	@Autowired
	private SellerGoodDao sellerGoodDao;

	@Test
	public void getInfoSellerPublishTest() {
		boolean result = false;
		boolean except = true;

		if (sellerGoodDao.getInfoSellerPublish() != null && sellerGoodDao.getInfoSellerPublish().size() > 0) {
			result = true;
		}

		assertEquals(except, result);

	}

	@Test
	public void getInfoSellerCheckTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoSellerCheck() != null && sellerGoodDao.getInfoSellerCheck().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoSellerUnderTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoSellerUnder() != null && sellerGoodDao.getInfoSellerUnder().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoPurchUnderTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoPurchUnder() != null && sellerGoodDao.getInfoPurchUnder().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoPurchCheckTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoPurchCheck() != null && sellerGoodDao.getInfoPurchCheck().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoPurchPublishTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoPurchPublish() != null && sellerGoodDao.getInfoPurchPublish().size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoSellerPublishBy_uID_Test() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoSellerPublishBy_uID(2) != null
				&& sellerGoodDao.getInfoSellerPublishBy_uID(2).size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoSellerCheckBy_uID_Test() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoSellerCheckBy_uID(2) != null && sellerGoodDao.getInfoSellerCheckBy_uID(2).size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoSellerUnderBy_uID_Test() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoSellerUnderBy_uID(2) != null && sellerGoodDao.getInfoSellerUnderBy_uID(2).size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoPurchUnderBy_uID_Test() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoPurchUnderBy_uID(2) != null && sellerGoodDao.getInfoPurchUnderBy_uID(2).size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoPurchCheckBy_uID_Test() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoPurchCheckBy_uID(2) != null && sellerGoodDao.getInfoPurchCheckBy_uID(2).size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoPurchPublishBy_uID_Test() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoPurchPublishBy_uID(2) != null
				&& sellerGoodDao.getInfoPurchPublishBy_uID(2).size() > 0) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoBy_sNumberTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoBy_sNumber(1) != null && sellerGoodDao.getInfoBy_sNumber(1111) == null) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void getInfoBy_pNumberTest() {
		boolean result = false;
		boolean except = true;
		if (sellerGoodDao.getInfoBy_pNumber(1) != null && sellerGoodDao.getInfoBy_pNumber(1111) == null) {
			result = true;
		}
		assertEquals(except, result);
	}

	@Test
	public void modifyPassStateBy_pNumberTest() {
		assertEquals(1, sellerGoodDao.modifyPassStateBy_pNumber(1));
	}

	@Test
	public void modifyPassStateBy_sNumberTest() {
		assertEquals(1, sellerGoodDao.modifyPassStateBy_sNumber(1));
	}

	@Test
	public void modifyNotPassStateBy_pNumberTest() {
		assertEquals(1, sellerGoodDao.modifyNotPassStateBy_pNumber(1));
	}

	@Test
	public void modifyNotPassStateBy_sNumberTest() {
		assertEquals(1, sellerGoodDao.modifyNotPassStateBy_sNumber(1));
	}

	@Test
	public void addSellerCheckNotPassSuggestTest() {
		assertEquals(1, sellerGoodDao.addSellerCheckNotPassSuggest(2, "不通过"));
	}

	@Test
	public void addSellerPurchNotPassSuggestTest() {
		assertEquals(1, sellerGoodDao.addSellerCheckNotPassSuggest(2, "不通过"));
	}
}
