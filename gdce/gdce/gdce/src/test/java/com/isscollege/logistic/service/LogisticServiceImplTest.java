package com.isscollege.logistic.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.logistic.service.Impl.LogisticServiceImpl;

/**
 * @author whg
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogisticServiceImplTest {
	@Autowired
	private LogisticServiceImpl service;
	
	@Test
	public void test() {
		assertTrue(service.getTradeIDByUID(1).size()>1);
	}
}
