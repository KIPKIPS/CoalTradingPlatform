package com.isscollege.users.controllers;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.users.entity.Users;
import com.isscollege.users.service.impl.UserServiceImpl;
import com.isscollege.users.utils.MD5;
import com.isscollege.users.utils.VerifyUtil;

@Controller
@RequestMapping("/user")
public class UserControllers {
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/index")
	public String index() {
		System.out.println("index...");

		return "login";
	}

	@ResponseBody
	@RequestMapping("/login")
	public String login(Users user, String verifyCode, HttpSession session) {
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();

		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确') \n history.back()</script>";
		}
		String newPass = new MD5().getMD5ofStr(user.getPassword());
		user.setPassword(newPass);
		Users login = userService.login(user);
		System.out.println(user);
		if (login != null) {
			session.setAttribute("user", login);
			return "<script>location.href='http://10.61.88.30:8082/logistics_system/user/skip'</script>";
		} else
			return "<script>location.href='http://10.61.88.30:8082/logistics_system/user/index'</script>";

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

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping("/skip")
	public String skip(HttpSession session) {

		return "logisticsManage";
	}

}
