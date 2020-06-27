package com.isscollege.users.controllers;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.users.entity.Admin;
import com.isscollege.users.service.impl.AdminServiceImpl;
import com.isscollege.utils.VerifyUtil;

@Controller
@RequestMapping("admin")
public class AdminController {

	// 日志־
	private static final Logger LOG = Logger.getLogger(AdminController.class);

	@Autowired
	AdminServiceImpl adminService;

	// 用户登陆主页
	@RequestMapping("/index")
	public String index(String adminName, HttpServletRequest request, String muAccount, String uName) throws Exception {
		LOG.info("回填信息:" + adminName);

		request.setAttribute("adminName", adminName);
		request.setAttribute("muAccount", muAccount);
		request.setAttribute("uName", uName);
		return "login";
	}

	@RequestMapping("/exit")
	public String exit() throws Exception {
		return "exit";
	}

	@RequestMapping("/adminTopPage")
	public String adminTopPage() {
		return "admin_header";
	}

	@RequestMapping("/adminUsercenter")
	public String adminUsercenter() {
		return "adminUsercenter";
	}

	@RequestMapping("/adminMiddlePage")
	public String adminMiddlePage() {
		return "adminMiddlePage";
	}

	@RequestMapping("/adminDefaultPage")
	public String adminDefaultPage() {
		return "adminDefaultPage";
	}

	@RequestMapping("/adminCheckBottomPage")
	public String adminCheckBottomPage() {
		return "adminDefaultPage";
	}

	@RequestMapping("/adminCheckIndex")
	public String adminCheckIndex() {
		return "adminCheckIndex";
	}

	@RequestMapping("/regist_check_list")
	public String regist_check_list() {
		return "redirect:/registcheck/showlist";
	}

	@RequestMapping("/adminCheckcenter")
	public String adminCheckcenter() {
		return "adminCheckcenter";
	}

	@RequestMapping("/adminBottomPage")
	public String adminBottomPage() {
		return "adminBottomPage";// 进入管理员用户中心时，默认显示审核页面
	}

	// 管理员登陆
	@ResponseBody
	@RequestMapping("/login")
	public String login(Admin admin, String verifyCode, HttpSession session, HttpServletRequest request)
			throws Exception {

		// 验证验证码
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();
		System.out.println("正确验证码" + rightVerifyCode);
		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确') \n location.href='index?adminName=" + admin.getAdminName() + "'</script>";
		}

		LOG.info("注册前信息:" + admin);

		Admin tempAdmin = adminService.login(admin);

		if (tempAdmin != null) {
			Admin tempAdminWithRoleID = adminService.getAdminWithRoleIdById(tempAdmin.getAdminID());
			LOG.info("登录前信息" + tempAdminWithRoleID.getRoleID());
			session.setAttribute("admin", tempAdminWithRoleID);
			System.out.println(session.getId());
			if (tempAdminWithRoleID.getRoleID() == 6) {
				return "<script>location.href='/secondaryAdminManage/superAdminUsercenter'</script>";
			} else {
				return "<script>location.href='/admin/adminUsercenter'</script>";
			}
			/*
			 * // switch (tempAdminWithRoleID.getRoleID()) { // 1为咨询编辑人员 case 1:
			 * return
			 * "<script>location.href='/gdce/admin/adminUsercenter'</script>";
			 * // 2为注册审核人员 case 2: return
			 * "<script>location.href='/gdce/admin/adminUsercenter'</script>";
			 * // 3为交易审核人员 case 3: return
			 * "<script>location.href='/gdce/admin/adminUsercenter'</script>";
			 * // 4位咨询审核人员 case 4: return
			 * "<script>location.href='/gdce/admin/adminUsercenter'</script>";
			 * // 5为咨询维护人员 case 5: return
			 * "<script>location.href='/gdce/admin/adminUsercenter'</script>";
			 * // 6超管 case 6: return
			 * "<script>location.href='/gdce/secondaryAdminManage/superAdminUsercenter'</script>";
			 * } return "";
			 */

		} else {
			// 登录失败

			return "<script>alert('用户名或密码不正确') ; location.href='index?adminName=" + admin.getAdminName() + "'</script>";
		}

	}

	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(session.getId());
		String path = session.getServletContext().getContextPath();
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			cookies = null;

		/*
		 * if (cookies != null) { for (Cookie cookie: cookies) {
		 * cookie.getName(); cookie. }
		 */

		return "<script>window.parent.location.href='" + path + "/admin/exit';</script>";

	}

	@RequestMapping("/regist")
	public String regist() {
		return "adminRegist";
	}

	@RequestMapping("/adminManage")
	public String adminManage() {
		return "adminManage";
	}

	@RequestMapping(value = "/createValicode", method = RequestMethod.GET)
	public void valicode(HttpServletResponse response, HttpSession session) throws Exception {
		Object[] objects = VerifyUtil.createImage();

		// 验证码存入session
		session.setAttribute("verifyCode", objects[0]);

		// 图片输出
		BufferedImage image = (BufferedImage) objects[1];
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		// return
		// "<script>window.parent.location.href='http://localhost:8083/tempBank/bank/frozen';</script>";
		return "http://10.61.88.30:8083/bank/frozen";
	}

}
