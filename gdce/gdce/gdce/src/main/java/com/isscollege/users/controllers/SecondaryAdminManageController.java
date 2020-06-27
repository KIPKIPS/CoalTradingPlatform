package com.isscollege.users.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.users.entity.Admin;
import com.isscollege.users.entity.AdminWithRole;
import com.isscollege.users.service.impl.AdminRoleServiceImpl;
import com.isscollege.users.service.impl.AdminServiceImpl;
import com.isscollege.users.service.impl.RoleServiceImpl;
import com.isscollege.users.utils.MD5;

/**
 * @author whg 处理超管管理二级管理员的请求
 */
@Controller
@RequestMapping("/secondaryAdminManage")
public class SecondaryAdminManageController {

	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private AdminRoleServiceImpl adminRoleService;
	@Autowired
	private RoleServiceImpl roleService;

	@RequestMapping("/superAdminTopPage")
	public String superAdminTopPage() {
		return "admin_header";
	}

	@RequestMapping("/superAdminMiddlePage")
	public String superAdminMiddlePage() {
		return "superAdminMiddlePage";
	}

	// 查询所有已存在的管理员，并显示出来
	@RequestMapping("/superAdminBottomPage")
	public String superAdminBottomPage(HttpServletRequest req) {
		req.removeAttribute("adminManageList");

		List<AdminWithRole> adminRoleList = new ArrayList<AdminWithRole>();
		for (Admin a : adminService.queryAllAdmin()) {
			adminRoleList.add(new AdminWithRole(a, adminRoleService.queryRoleByAdminID(a.getAdminID())));
		}

		// add all role list to req
		req.setAttribute("roleList", roleService.queryAllRole());

		req.setAttribute("adminManageList", adminRoleList);

		return "adminManage";

	}

	@RequestMapping("/superAdminUsercenter")
	public String superAdminUsercenter() {
		return "superAdminUsercenter";
	}

	// 查询所有已存在的管理员，并显示出来
	@RequestMapping("/adminManage")
	public String productManager(HttpServletRequest req) {
		req.removeAttribute("adminManageList");
		List<AdminWithRole> adminRoleList = new ArrayList<AdminWithRole>();
		for (Admin a : adminService.queryAllAdmin()) {
			adminRoleList.add(new AdminWithRole(a, adminRoleService.queryRoleByAdminID(a.getAdminID())));
		}
		req.setAttribute("adminManageList", adminRoleList);
		return "adminManage";
	}

	// 请求注册管理员页面
	@GetMapping("/toRegister")
	public String toRegister() {
		return "adminRegister";
	}

	// 创建二级管理员
	@PostMapping("/register")
	public String register(@RequestParam String adminName, @RequestParam String adminPass,
			@RequestParam String adminRealName, @RequestParam String adminTelephone, @RequestParam Integer roleID) {
		adminService.addAdmin(new Admin(adminName, new MD5().getMD5ofStr(adminPass), adminRealName, adminTelephone),
				roleService.queryRoleByRoleID(roleID));
		return "redirect:/secondaryAdminManage/";
	}

	// query if the request uname exist
	@PostMapping("/validateAdminName")
	@ResponseBody
	public String validateUserName(String adminName) {
		return adminService.queryAdminName(adminName) ? "no" : "yes";
	}

	// 删除管理员
	@GetMapping("/remove")
	public String remove(@RequestParam String adminID) {
		adminService.removeAdmin(Integer.parseInt(adminID));
		return "redirect:/secondaryAdminManage/";
	}

	// 修改管理员权限
	@GetMapping("/modifyRole")
	public String modifyRole(@RequestParam Integer adminID, @RequestParam Integer roleID) {
		adminRoleService.modifyAdminRole(adminID, roleID);
		return "redirect:/secondaryAdminManage/";
	}

	// 查询所有已存在的管理员，并显示出来，返回管理二级管理员主界面
	@GetMapping("/")
	public String queryAllSecondaryManager(HttpServletRequest req) {
		req.removeAttribute("adminManageList");

		List<AdminWithRole> adminRoleList = new ArrayList<AdminWithRole>();
		for (Admin a : adminService.queryAllAdmin()) {
			adminRoleList.add(new AdminWithRole(a, adminRoleService.queryRoleByAdminID(a.getAdminID())));
		}

		// add all role list to req
		req.setAttribute("roleList", roleService.queryAllRole());

		req.setAttribute("adminManageList", adminRoleList);

		return "adminManage";
	}
}