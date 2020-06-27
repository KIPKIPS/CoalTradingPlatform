/**
 * 管理员orm测试
 */
package com.isscollege.users.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.entity.Admin;

/**
 * @author whg
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {

	@Autowired
	private AdminDao adminDao;

	@Test
	public void adminDaoInsertAdminTest() {
		Admin root = new Admin("woohoogoo", "123456", "woo", "152346783");
		assertEquals(1, adminDao.insertAdmin(root));
	}

	@Test
	public void adminDaoDeleteAdminByAdminIDTest() {
		assertEquals(0, adminDao.deleteAdminByAdminID(3));
	}

	@Test
	public void adminDaoSelectAdminByAdminID() {
		assertTrue(new Admin(5, "whg", "123456", "woo", "152346783").equals(adminDao.selectAdminByAdminID(5)));
	}

	@Test
	public void selectAllAdminExceptRootTest() {
		assertEquals(8, adminDao.selectAllAdminExceptRoot().size());
	}

	@Test
	// 超管登陆测试
	public void input_username_password_result_true() {
		boolean result = false;
		boolean expect = true;
		Admin admin = new Admin("aaa", "e10adc3949ba59abbe56e057f20f883e");
		Admin login = adminDao.login(admin);
		if (login != null && login.getAdminID() > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	// 超管登陆测试(用户名、密码为空)
	public void input_null_null_result_false() {
		boolean result = false;
		boolean expect = false;
		Admin admin = new Admin("", "");
		admin = adminDao.login(admin);
		if (admin != null && admin.getAdminID() > 0) {
			result = true;
		}

		assertEquals(expect, result);
	}

	// 测试登录方法
	@Test
	public void testLogin_Input_RightUser_Result_NotNull() {
		Admin login = adminDao.login(new Admin("aaa", "E10ADC3949BA59ABBE56E057F20F883E"));
		assertNotNull(login);
	}

	@Test
	public void testLogin_Input_WrongPasword_Result_Null() {
		Admin login = adminDao.login(new Admin("baxc", "E10ADC3949BA59ABBE56E057F20F883E"));
		assertNull(login);
	}

	@Test
	public void testLogin_Input_WrongUser_Result_Null() {
		Admin login = adminDao.login(new Admin("aaa", "Q29DTJA9D7EA59ABBEX9K757F20F854W"));
		assertNull(login);
	}

}
