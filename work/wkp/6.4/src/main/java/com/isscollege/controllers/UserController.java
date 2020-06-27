package com.isscollege.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.entity.Users;
import com.isscollege.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class);
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		System.out.println("hello...");
		return "hello,user";
	}

	@RequestMapping("/index")
	public String index() {
		System.out.println("index...");
		return "regist";
	}

	@RequestMapping("/regist")
	public String regist(Users user) {
		LOG.info(user + "   注册前的信息");
		userService.insert(user);
		LOG.info(user + "   添加成功后，携带userid的");
		if (user.getUserid() > 0) {
			return "login";
		} else {
			return "regist";
		}
	}

	@RequestMapping("/login")
	public String login(Users user, Integer pageNum, HttpServletRequest req, HttpSession session) {
		LOG.info("   login...");
		Users user2 = userService.login(user);
		if (user2 != null) {
			session.setAttribute("user", user2);
			pageNum = pageNum == null ? 1 : pageNum;
			PageHelper.startPage(pageNum, 3);// (当前第几页，每页几条数据)
			List<Users> userList = userService.getAllUsers();
			PageInfo<Users> pageInfo = new PageInfo<>(userList);
			req.setAttribute("pageInfo", pageInfo);
			req.setAttribute("userList", userList);
			return "showAllUsers";
		} else {
			return "login";
		}
	}

	@RequestMapping("/getAllUsers")
	public String getAllUserInfo(Integer pageNum, Integer maxPage, HttpServletRequest req) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 3);
		List<Users> userList = userService.getAllUsers();
		PageInfo<Users> pageInfo = new PageInfo<>(userList);
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("userList", userList);
		return "showAllUsers";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping("/remove")
	public String removeUser(Integer userid, Integer pageNum, Integer maxPage, HttpServletRequest req) {
		System.out.println("remove...." + userid);
		userService.removeUserById(userid);
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 3);
		List<Users> userList = userService.getAllUsers();
		PageInfo<Users> pageInfo = new PageInfo<>(userList);
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("userList", userList);
		return "showAllUsers";
	}
}
