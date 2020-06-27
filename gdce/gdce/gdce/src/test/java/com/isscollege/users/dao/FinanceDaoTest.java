package com.isscollege.users.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.entity.Finance;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FinanceDaoTest {

	@Autowired
	FinanceDao financeDao;

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	// 测试登录方法
	@Test
	public void testLogin_Input_RightUser_Result_NotNull() {
		Finance login = financeDao.login(new Finance("yqm", "E10ADC3949BA59ABBE56E057F20F883E"));
		assertNotNull(login);
	}

	@Test
	public void testLogin_Input_WrongPasword_Result_Null() {
		Finance login = financeDao.login(new Finance("yqm", "123"));
		assertNull(login);
	}

	@Test
	public void testLogin_Input_WrongUser_Result_Null() {
		Finance login = financeDao.login(new Finance("asd", "E10ADC3949BA59ABBE56E057F20F883E"));
		assertNull(login);
	}

}
