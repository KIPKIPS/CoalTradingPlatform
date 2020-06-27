/**
 * Role ORM Test
 */
package com.isscollege.users.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.entity.Role;

/**
 * @author whg
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
	@Autowired
	private RoleDao roleDao;
	
	@Test
	public void selectAllRolesTest() {
		assertEquals(6, 
				roleDao.selectAllRoles().size());
	}
	
	@Test
	public void selectRoleByRoleIDTest() {
		assertTrue(new Role(1, "zixun").equals(
				roleDao.SelectRoleByRoleID(1)));
	}
}
