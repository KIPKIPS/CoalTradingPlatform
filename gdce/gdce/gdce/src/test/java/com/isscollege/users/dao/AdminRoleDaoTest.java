/**
 * 管理员角色ID ORM测试
 */
package com.isscollege.users.dao;

import static org.junit.Assert.assertEquals;
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
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminRoleDaoTest {
	@Autowired
	private AdminRoleDao adminRoleDao;
	
	@Test
	public void selectAllAdminByRoleIDTest() {
		assertTrue(adminRoleDao.selectAllAdminByRoleID(2).get(0).equals(
						new Admin(1, "资讯审核人员", "123456", "whg", "12345678")));
	}
	
	@Test
	public void selectRoleByAdminIDTest() {
		assertEquals(1, adminRoleDao.selectRoleByAdminID(0).getRoleID());
	}
	
	@Test
	public void insertAdminRoleTest() {
		assertEquals(1, 
				adminRoleDao.insertAdminRole(3, 4));
	}
	
	@Test
	public void updateAdminRoleByAdminIDRoleIDTest() {
		assertEquals(1, adminRoleDao.updateAdminRoleByAdminIDRoleID(1, 2));
	}
}
