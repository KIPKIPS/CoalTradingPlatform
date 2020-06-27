package com.isscollege.users.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isscollege.users.entity.Role;
import com.isscollege.users.service.impl.AdminRoleServiceImpl;
import com.isscollege.users.service.impl.RoleServiceImpl;

/**
 * @author whg 处理超管管理二级管理员的请求
 */
@Controller
@RequestMapping("/secondaryAdminManage")
public class SecondaryAdminManageController {

	@Autowired
	private AdminRoleServiceImpl adminRoleService;

	
	//请求注册管理员页面
	@GetMapping("/toRegister")
	public String toRegister() {
		return "adminRegister";
	}

	
	//修改二级管理员的权限
	@GetMapping("/modifyRole")
	public String modifyRole(@RequestParam Integer adminID, @RequestParam Integer roleID) {
		if (adminRoleService.modifyAdminRole(adminID, roleID) > 0)
		return "redirect:/secondaryAdminManage/";
		return "adminManage";
	}
	@PostMapping("/modifyRole")
	public String modifyRoleWithPost(HttpServletRequest req) {
		adminRoleService.modifyAdminRole(1, 
				((Role)req.getAttribute("role")).getRoleID()
				);
		return "adminManage";
	}
	
}