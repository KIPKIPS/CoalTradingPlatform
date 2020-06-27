package com.isscollege.users.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.dao.RoleDao;
import com.isscollege.users.entity.Role;
import com.isscollege.users.service.impl.RoleServiceImpl;

/**
 * @author whg
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
public class RoleServiceTest {
	@Autowired
	private RoleServiceImpl service;
	
	@Test
	public void testExample() {
		assertEquals(1, 
				service.queryRoleByRoleID(1)
				.getRoleID());
	}
}

/*
 * 
 */
//public class RoleServiceTest {
//	private RoleServiceImpl service;
//
//	@MockBean
//	private RoleDao repository;
//	
//	@Before //@After @BeforeEach @AfterEach
//	public void setup() {
//		service = new RoleServiceImpl(repository);
//		
//		/*
//		 * BDD -----Behavior Driven Development style
//		 */
//		when(repository.SelectRoleByRoleID(1))
//		.thenReturn(
//				new Role(1, "role")
//				);
//	}
//	
//	@Test
//	public void testExample() {
//		assertEquals(1, 
//				service.queryRoleByRoleID(1)
//				.getRoleID());
//	}
//}






























/*@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
	@Autowired
	private RoleServiceImpl roleService;
	
	@Test
	public void queryTest() {
		assertEquals(1, 
				roleService.queryRoleByRoleID(1).getRoleID());
	}
}*/


/*@RunWith(SpringRunner.class)
public class RoleServiceTest {
	@MockBean
	private RoleDao repository;
	
	private RoleServiceImpl roleService;
	 
	@Before //@After @BeforeEach @AfterEach
	public void setup() {
		roleService = new RoleServiceImpl(repository);
		
		//BDD-----Behavior Driven Development style
		when(repository.SelectRoleByRoleID(1))
			.thenReturn(new Role(1, "role"));
	}
	
	@Test
	public void queryTest() {
		assertEquals(1, 
				roleService.queryRoleByRoleID(1).getRoleID());
	}
}*/
