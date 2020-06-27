package com.isscollege.users.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.users.entity.Bank_Finance;
import com.isscollege.users.service.impl.UserServiceImpl;
import com.isscollege.users.utils.VerifyUtil;

@Controller
// 该注解声明该类下的所有方法都可以被外域请求
@CrossOrigin
@RequestMapping("/bank")
public class UserController {
	private static final Logger LOG = Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/index")
	public String index() {
		return "login";
	}

	// 退出
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "login";
	}

	// 登录
	@ResponseBody
	@RequestMapping("/login")
	public String login(Bank_Finance bank_Finance, String verifyCode, HttpSession session) throws Exception {
		// 验证验证码
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();

		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确') \n history.back()</script>";
		}
		LOG.info("登录信息:" + bank_Finance);
		Bank_Finance tempFinance = userService.login(bank_Finance);
		System.out.println(tempFinance);
		if (tempFinance != null) {
			// 登录成功
			LOG.info("登录成功！");
			session.setAttribute("bank_finance", tempFinance);
			// 跳转至成功页面
			return "<script>location.href='" + session.getServletContext().getContextPath()
					+ "/bank/queryBalance';</script>";
		} else {
			// 登录失败
			System.out.println("wdvwevw");
			// 跳转登录界面
			return "<script>alert('用户名或密码不正确') \n history.back()</script>";
		}
	}

	// 冻结功能
	@RequestMapping("/frozen")
	@ResponseBody
	public String modifyFrozenMoney(String bankAcount, Double frozenMoney, HttpServletResponse rep) {
		/*
		 * // 用于跨域访问 rep.setHeader("Access-Control-Allow-Origin", "*"); //
		 * 设置跨域请求的方式 rep.setHeader("Access-Control-Allow-Method", "post,get");
		 */
		System.out.println("..........." + userService.queryBalance(bankAcount).getUsableMoney());
		if (userService.queryBalance(bankAcount).getUsableMoney() > frozenMoney) {
			if (userService.modifyFrozenMoney(bankAcount, frozenMoney) == 2) {
				return "right";
			}
		}
		return "wrong";
	}

	// 预存功能
	@PostMapping("/PrestoreMoney")
	public String PrestoreMoney(Double balance, HttpServletResponse resp, HttpSession session) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		Bank_Finance bankFinance = (Bank_Finance) session.getAttribute("bank_finance");
		PrintWriter pw = resp.getWriter();
		if (bankFinance != null && !bankFinance.getBankAcount().equals("")) {
			Integer result = userService.PrestoreMoney(balance, bankFinance.getBankAcount());
			if (result != null && result == 2) {
				pw.print("<script>");
				pw.print("alert('预存成功');");
				pw.print("location.href='queryBalance'");
				pw.print("</script>");
			} else {
				pw.print("<script>");
				pw.print("alert('预存失败');");
				pw.print("location.href='queryBalance'");
				pw.print("</script>");
			}
		} else {
			pw.print("<script>");
			pw.print("alert('请先登录！');");
			pw.print("location.href='toLogin'");
			pw.print("</script>");
		}
		return null;
	}

	// 查询余额和冻结金额
	@RequestMapping("/queryBalance")
	public String queryBalance(HttpSession session, HttpServletRequest req) {
		Bank_Finance bank_Finance = (Bank_Finance) session.getAttribute("bank_finance");
		if (bank_Finance != null) {
			Bank_Finance bankFinance = userService.queryBalance(bank_Finance.getBankAcount());
			if (bankFinance != null) {
				req.setAttribute("bankFinance", bankFinance);
			}
		}
		return "queryBalance";
	}

	// 请求注册
	@GetMapping("/toRegist")
	public String toRegister() {
		return "trade_user_regist";
	}

	// 跳转到注册成功页面
	@GetMapping("/toRegistSuccess")
	public String toRegistSuccess() {
		return "regist_success";
	}

	// 跳转到登录页面
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	// 验证账户是否已存在（已被注册）
	@PostMapping("/validateUserAcount")
	@ResponseBody
	public String validateUserName(String cName) {
		// 存在返回"yes"，不存在返回"no"
		return userService.queryUserAcount(cName) ? "yes" : "no";
	}

	// 注册账户
	@RequestMapping("/tradeUserRegist")
	@ResponseBody
	public String tradeUserRegist(HttpServletResponse resp, HttpSession session, @RequestParam String cName,
			@RequestParam String bankPassword, @RequestParam String bankPassword2, @RequestParam String cRealName,
			@RequestParam String cLegalPerson, @RequestParam String uRealName, @RequestParam String uTeleNum)
			throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if (bankPassword.equals(bankPassword2)) {
			Bank_Finance bank_Finance = new Bank_Finance("bankAcount", bankPassword, cName, cRealName, cLegalPerson,
					uRealName, uTeleNum);
			Integer returnVal = userService.tradeUserRegist(bank_Finance);

			// 成功页面理应不能取到密码
			bank_Finance.setBankPassword("o_0");
			session.setAttribute("bank_Finance", bank_Finance);
			if (returnVal != null && returnVal > 0) {
				// 跳转至成功页面
				return "<script>location.href='" + session.getServletContext().getContextPath()
						+ "/bank/toRegistSuccess';</script>";
			}
		} else {
			return "<script>alert('两次密码不一致,注册失败~'); location.href='/bank/toRegist';</script>";
		}
		return "regist_success";
	}

	// 验证码
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

	// 解冻指定冻结金额
	@GetMapping("/unfrozen")
	@ResponseBody
	public String unfrozenMoney(String bankAcount, Double unfrozenMoney) {
		try {
			// 语句执行正常返回，true代表解冻成功，false代表sql语句执行正常，但更新数据失败，并且没有抛异常
			return userService.unfrozenBalance(bankAcount, unfrozenMoney) ? "success" : "false";
		} catch (IllegalArgumentException e) {
			// 指定的解冻金额大于已冻结金额
			LOG.info(e.getMessage());
			return e.getMessage();
		} catch (Exception e) {
			// 未知异常
			LOG.info(e.getStackTrace());
			return "unexpected exception occured !!!";
		}
	}

	@RequestMapping("/query")
	public String queryAllAccount(HttpServletRequest req) {
		List<Bank_Finance> allAccount = userService.queryAllAccount();
		req.setAttribute("allAccount", allAccount);
		return "queryAccount";

	}

}
