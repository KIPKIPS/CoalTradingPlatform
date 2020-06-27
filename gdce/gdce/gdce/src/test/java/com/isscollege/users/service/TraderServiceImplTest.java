/**
 * 
 */
package com.isscollege.users.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.service.impl.TraderServiceImpl;

/**
 * @author Apple
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TraderServiceImplTest {

	@Autowired
	private TraderServiceImpl traderService;

	// 用户退出测试
	@Test
	public void input_Login_Info_result_1() {
		Login_Info trader = new Login_Info();
		trader.setuID(1);
		trader.setLoginState("0");
		int i = traderService.logout(trader);
		assertEquals(1, i);
	}

}
