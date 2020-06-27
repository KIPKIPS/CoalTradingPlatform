/**
 * 超管管理二级管理员控制器测试
 */
package com.isscollege.users.controllers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.isscollege.users.entity.Role;
import com.isscollege.users.service.impl.AdminRoleServiceImpl;

/**
 * @author whg
 *	
 */


/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SecondaryAdminManageControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testExample() throws Exception {
		mockMvc.perform(
				get("/secondaryAdminManage/toRegister")
				.accept(MediaType.ALL))
		.andExpect(status().is(200))
		.andDo(print());
	}
	
}*/

@RunWith(SpringRunner.class)
@WebMvcTest(SecondaryAdminManageController.class)

// *  使用@WebMvcTest时初始化应用环境会扫描并注入容器的一些必要的组件
// *  @Controller, @ControllerAdvice, @JsonComponent, Converter,
// *  GenericConverter, Filter, WebMvcConfigurer, and HandlerMethodArgumentResolver
 
public class SecondaryAdminManageControllerTest {
	//模拟mvc环境
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdminRoleServiceImpl adminRoleService;
	
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



















