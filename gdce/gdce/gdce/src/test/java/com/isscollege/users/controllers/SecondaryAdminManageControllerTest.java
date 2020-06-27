/**
 * 超管管理二级管理员控制器测试
 */
package com.isscollege.users.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.isscollege.users.entity.Role;
import com.isscollege.users.service.impl.AdminRoleServiceImpl;
import com.isscollege.users.service.impl.AdminServiceImpl;
import com.isscollege.users.service.impl.RoleServiceImpl;

/**
 * @author whg
 *	
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SecondaryAdminManageController.class)
public class SecondaryAdminManageControllerTest {
	//模拟mvc环境
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdminRoleServiceImpl adminRoleService;
	@MockBean
	private AdminServiceImpl adminService;
	@MockBean
	private RoleServiceImpl roleService;
	
	@Test
	public void testExample() throws Exception {
		//BDD-----Behavior Driven Development style
		given(adminRoleService.modifyAdminRole(1, 25))
			.willReturn(1);
		//测试接受get请求的 controller
		mockMvc.perform(
				get("/secondaryAdminManage/modifyRole")
				.param("adminID", "1")
				.param("roleID", "25")
				.accept(MediaType.TEXT_HTML))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/secondaryAdminManage/"));
		//测试接受post controller
		mockMvc.perform(
				post("/secondaryAdminManage/modifyRole")
					.requestAttr("role", new Role(1, "role"))
					).andExpect(request().attribute("role", new Role(1, "role")));
	}
}
