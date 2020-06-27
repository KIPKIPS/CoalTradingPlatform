/**
 * 超管服务测试
 */
package com.isscollege.users.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.dao.AdminDao;
import com.isscollege.users.entity.Admin;
import com.isscollege.users.service.impl.AdminServiceImpl;

/**
 * @author whg
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTests {
	@Autowired
	private AdminDao dao;

	@Autowired
	AdminServiceImpl adminService;

	@Test
	public void insertAdminTest() throws Exception {
		Admin root = new Admin("whg", "123456", "woo", "152346783");
		assertEquals(dao.insertAdmin(root), 1);
	}

	@Test
	// 超管登陆测试
	public void input_username_password_result_true() {
		boolean result = false;
		boolean expect = true;
		Admin admin = new Admin("aaa", "123456");
		Admin login = adminService.login(admin);
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
		admin = adminService.login(admin);
		if (admin != null && admin.getAdminID() > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

}
