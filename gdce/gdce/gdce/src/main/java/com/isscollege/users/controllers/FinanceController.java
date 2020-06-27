package com.isscollege.users.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.users.entity.Finance;
import com.isscollege.users.service.impl.FinanceServiceImpl;

@Controller
@RequestMapping("finance")
public class FinanceController {

	private static final Logger LOG = Logger.getLogger(FinanceController.class);

	@Autowired
	FinanceServiceImpl financeService;

	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return "<script>window.parent.location.href='" + session.getServletContext().getContextPath()
				+ "/admin/index';</script>";
	}

	@RequestMapping("/financeTopPage")
	public String financeTopPage() {
		// System.out.println("traderTopPage");
		return "finance_header";
	}

	@RequestMapping("/financeMiddlePage")
	public String financeMiddlePage() {
		// System.out.println("traderTopPage");
		return "financeMiddlePage";
	}

	@RequestMapping("/financeBottomPage")
	public String financeBottomPage() {
		// System.out.println("traderTopPage");
		return "financeBottomPage";
	}

	@RequestMapping("/financeUserCenter")
	public String financeUsercenter() {
		// System.out.println("traderTopPage");
		return "financeUserCenter";
	}

	// 财务账号登陆
	@ResponseBody
	@RequestMapping("/login")
	public String login(Finance finance, String verifyCode, HttpSession session, HttpServletRequest request)
			throws Exception {
		// 验证验证码
		request.setAttribute("muAccount", finance.getMuAccount());
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();
		System.out.println("正确验证码" + rightVerifyCode);
		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确') \n " + "location.href='/admin/index?muAccount=" + finance.getMuAccount()
					+ "'</script>";
		}
		LOG.info("登录信息:" + finance);
		Finance tempFinance = financeService.login(finance);

		if (tempFinance != null) {
			// 登录成功
			LOG.info("登录成功！");
			session.setAttribute("finance", tempFinance);
			// 跳转至成功页面
			return "<script>location.href='/finance/financeUserCenter'</script>";
		} else {
			// 登录失败

			// 跳转登录界面
			return "<script>alert('用户名或密码不正确') \n" + " location.href='/admin/index?muAccount=" + finance.getMuAccount()
					+ "'</script>";

		}
	}

}
