package com.isscollege.users.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.entity.Question;
import com.isscollege.users.entity.Trade_Account;
import com.isscollege.users.service.impl.TraderServiceImpl;

@Controller
@CrossOrigin
@RequestMapping("trader")
public class TraderController {
	@Autowired
	TraderServiceImpl traderService;

	private static final Logger LOG = Logger.getLogger(TraderController.class);

	// 用户登录
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		if (trader == null) {
			return "<script>window.parent.location.href='" + session.getServletContext().getContextPath()
					+ "/admin/index';</script>";
		}
		trader.setLoginState("0");
		traderService.logout(trader);
		session.invalidate();
		return "<script>window.parent.location.href='" + session.getServletContext().getContextPath()
				+ "/admin/index';</script>";
	}

	@RequestMapping("/tradeTopPage")
	public String tradeTopPage() {
		// System.out.println("tradeTopPage");
		return "trader_header";
	}

	@RequestMapping("/tradeUserCenter")
	public String tradeUserCenterPage() {
		// System.out.println("tradeUserCenterPage");
		return "tradeUserCenter";
	}

	@RequestMapping("/tradeMiddlePage")
	public String tradeMiddlePage() {
		// System.out.println("tradeMiddlePage");
		return "tradeMiddlePage";
	}

	@RequestMapping("/tradeLeftPage1")
	public String tradeLeftPage1() {
		// System.out.println("tradeLeftPage1");
		return "tradeLeftPage1";
	}

	@RequestMapping("/tradeLeftPage2")
	public String tradeLeftPage2() {
		// System.out.println("tradeLeftPage2");
		return "tradeLeftPage2";
	}

	@RequestMapping("/tradeLeftPage3")
	public String tradeLeftPage3() {
		// System.out.println("tradeLeftPage3");
		return "tradeLeftPage3";
	}

	@RequestMapping("/tradeLeftPage4")
	public String tradeLeftPage4() {
		// System.out.println("tradeLeftPage4");
		return "tradeLeftPage4";
	}

	@RequestMapping("/tradeBottomPage1")
	public String tradeBottomPage1() {
		// System.out.println("tradeBottomPage1");
		return "tradeBottomPage1";
	}

	@RequestMapping("/tradeBottomPage2")
	public String tradeBottomPage2() {
		// System.out.println("tradeBottomPage2");
		return "tradeBottomPage2";
	}

	@RequestMapping("/tradeBottomPage3")
	public String tradeBottomPage3() {
		// System.out.println("tradeBottomPage3");
		return "tradeBottomPage3";
	}

	@RequestMapping("/tradeBottomPage4")
	public String tradeBottomPage4() {
		// System.out.println("tradeBottomPage4");
		return "tradeBottomPage4";
	}

	@RequestMapping("/logisticsManage")
	public String logisticsManagePage() {
		// System.out.println("logisticsManagePage");
		return "logisticsManage";
	}

	@RequestMapping("/traderTopPage")
	public String traderTopPage() {
		// System.out.println("traderTopPage");
		return "trader_header";
	}

	@RequestMapping("/traderUserCenter")
	public String traderUsercenter() {
		// System.out.println("traderTopPage");
		return "traderUserCenter";
	}

	@RequestMapping("/tradeAccontInfoUpdate")
	public String tradeAccountInfoUpdate(HttpServletRequest req, HttpSession session) {
		// System.out.println("traderTopPage");
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		Trade_Account showInfo = traderService.showCompanyInfo(trader.getuID());
		if (showInfo != null) {
			req.setAttribute("trader", showInfo);
			return "tradeAccontInfoUpdate";
		} else {
			return "userinfo";
		}

	}

	@RequestMapping("/showorderlist")
	public String showOrderList() {
		return "show_order_list";
	}

	@RequestMapping("/showContractList")
	public String showContractList() {
		return "showContractList";
	}

	@RequestMapping("/tradeAccontInfoFormModify")
	@ResponseBody
	public String tradeAccontInfoFormModify(Trade_Account trade_Account, HttpSession session, String cAddress) {

		Login_Info trader = (Login_Info) session.getAttribute("trader");
		Integer uid = trader.getuID();
		String provFirst = cAddress.substring(0, cAddress.indexOf(","));// 截取","之前的字符串(身份)
		String provLast = cAddress.substring(cAddress.indexOf(",") + 1, cAddress.length());// 截取","之后的字符串(市县)
		cAddress = provFirst + " " + provLast;// 拼接字符串(省份+市县)
		trade_Account.setcAddress(cAddress);
		trade_Account.setuID(uid);
		Integer result = traderService.modifyInfo(trade_Account);
		try {
			if (result > 0) {
				return "<script>alert('修改成功，返回上一页');history.back();</script>";
			}
			return "<script>alert('无修改内容，返回上一页');history.back();</script>";

		} catch (Exception e) {
			return "<script>alert('系统错误1，返回上一页');history.back();</script>";
		}
	}

	@RequestMapping("/traderMiddlePage")
	public String traderMiddlePage() {
		// System.out.println("traderMiddlePage");
		return "traderMiddlePage";
	}

	@RequestMapping("/traderProductManager")
	public String traderProductManager() {
		// System.out.println("traderMiddlePage");
		return "productManager";
	}

	@RequestMapping("/tradeProducts_list")
	public String tradeProducts_list() {
		// System.out.println("traderMiddlePage");
		return "products_list";
	}

	@RequestMapping("/deal_seller")
	public String deal_seller() {
		// System.out.println("traderMiddlePage");
		return "deal_seller";
	}

	@RequestMapping("/deal_purch")
	public String deal_purch() {
		// System.out.println("traderMiddlePage");
		return "deal_purch";
	}

	@RequestMapping("/traderBottomPage")
	public String traderBottomPage() {
		// System.out.println("traderBottomPage");
		return "traderBottomPage";
	}

	@RequestMapping("/launchusercenter")
	public String launchusercenter() {
		// System.out.println("traderMiddlePage");
		return "traderUserCenter";
	}

	@RequestMapping("/registpage")
	public String registpage() {
		// System.out.println("traderMiddlePage");
		return "regist_user";
	}

	@RequestMapping("/sedregistpage")
	public String sedregistpage() {
		// System.out.println("traderMiddlePage");
		return "userinfo";
	}

	@RequestMapping("/findPwdpage")
	public String findPwd() {
		// System.out.println("traderMiddlePage");
		return "findPwd";
	}

	@RequestMapping("/userinfopage")
	public String userinfo() {
		// System.out.println("traderMiddlePage");
		return "userinfo";
	}

	// 交易用户登陆
	@ResponseBody
	@RequestMapping("/login")
	public String login(Login_Info trader, HttpServletRequest request, String verifyCode, HttpSession session)
			throws Exception {
		// 验证验证码
		request.setAttribute("uName", trader.getuName());
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();
		System.out.println("正确验证码" + rightVerifyCode);
		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确') \n " + "location.href='/admin/index?uName=" + trader.getuName()
					+ "'</script>";
		}

		LOG.info("登录信息:" + trader);
		Login_Info tempTrader = traderService.login(trader);

		if (tempTrader != null) {
			// 登录成功
			LOG.info("登录成功！");

			// 1、麻烦是登录后进不去发布买家和卖家商品信息页面的、找原因找到这儿的那些人别删掉或是注掉下面这一段
			// 2、这只是在做一个权限认证，即只完成一级注册不能发布商品信息 ，只有完善信息且通过管理员审核的才可以进去
			// 3、要想进去那个发布商品信息页，请在数据库里的tb_trade_account表里将与login_info表里对应的用户的最后一列属性uState将其值改为3，或者请自己走完完整的流程。。
			Login_Info tempTraderWithState = traderService.get_uState_by_uid(tempTrader.getuID());
			if (tempTraderWithState == null) {
				tempTrader.setuState("1");
				LOG.info("登录前信息" + tempTrader.getuState());
				session.setAttribute("trader", tempTrader);
			} else {
				LOG.info("登录前信息" + tempTraderWithState.getuState());
				session.setAttribute("trader", tempTraderWithState);
			}
			// 跳转至成功页面
			// return "<script>location.href=''</script>";
			return "<script>location.href='tradeUserCenter'</script>";
		} else {
			// 登录失败

			// 跳转登录界面
			return "<script>alert('用户名或密码不正确') \n location.href='/admin/index?uName=" + trader.getuName()
					+ "'</script>";
		}
	}

	// 普通用户注册
	@RequestMapping("/firstregist")
	@ResponseBody
	public String firstregist(Login_Info trader, Question question, String verifyCode, HttpSession session) {
		LOG.info(trader);
		LOG.info(question);
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();
		System.out.println("正确验证码" + rightVerifyCode);
		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确')  \n history.back()</script>";
		}
		Login_Info gettrader = traderService.firstregist(trader);
		if (gettrader != null) {
			return "<script>alert('用户已存在') \n history.back()</script>";

		} else {
			traderService.realfirstregist(trader);
			Login_Info sedgettrader = traderService.firstregist(trader);
			LOG.info(sedgettrader);
			question.setuID(sedgettrader.getuID());
			traderService.registtotb_question(question);

			return "<script>alert('注册成功！');location.href='/admin/index'</script>";
		}
	}

	// 检测用户名是否存在
	@PostMapping("/validateTraderName")
	@ResponseBody
	public String validateUserName(String uName) {
		return traderService.queryTraderName(uName) ? "no" : "yes";
	}

	// 完善用户信息
	@RequestMapping("/secondregist")
	@ResponseBody
	public String secondregist(Trade_Account trade_account, String uName, HttpSession session)
			throws Exception, Exception {

		Trade_Account gettrade_account = traderService.secondregist(trade_account);
		Login_Info trader = new Login_Info();
		trader.setuName(uName);
		String cAddress = trade_account.getcAddress();
		String provFirst = cAddress.substring(0, cAddress.indexOf(","));// 截取","之前的字符串(身份)
		String provLast = cAddress.substring(cAddress.indexOf(",") + 1, cAddress.length());// 截取","之后的字符串(市县)
		cAddress = provFirst + " " + provLast;// 拼接字符串(省份+市县)
		trade_account.setcAddress(cAddress);
		Login_Info gettrader = traderService.firstregist(trader);
		if (gettrade_account != null && gettrader == null) {
			return "<script>alert('公司已注册') \n history.back()</script>";

		} else {
			LOG.info(trade_account);
			LOG.info(trader);
			LOG.info(gettrader);
			trade_account.setuID(gettrader.getuID());
			LOG.info(trade_account);
			traderService.realsecondregist(trade_account);
			String realPath = session.getServletContext().getRealPath("upload");
			LOG.info(realPath);
			File A = new File(realPath + "/" + uName);
			A.mkdir();
			LOG.info(A);

			return "<script>location.href='/admin/index'</script>";
		}

	}

	// 找回密码
	@RequestMapping("/findPwd")
	@ResponseBody
	public String modifypassword(Question question, Login_Info trader, String verifyCode, HttpSession session) {
		String rightVerifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();
		System.out.println("正确验证码" + rightVerifyCode);
		if (!rightVerifyCode.equals(verifyCode.toLowerCase())) {
			return "<script>alert('验证码不正确')  \n history.back()</script>";
		}
		Login_Info gettrader = traderService.firstregist(trader);
		String newpass = trader.getuPass();
		gettrader.setuPass(newpass);
		LOG.info(gettrader);
		question.setuID(gettrader.getuID());
		LOG.info(question);
		Question getquestion = traderService.getanswer(question);

		if (getquestion == null) {
			return "<script>alert('密保答案错误') \n history.back()</script>";
		} else {

			traderService.modifypassword(gettrader);

			return "<script>alert('找回密码成功！');location.href='/admin/index'</script>";
		}

	}

	// 判断账户信息是否存在,存在则返回账户信息（银行子系统调用）
	@RequestMapping("/getAccountInfoBycName")
	@ResponseBody
	public Trade_Account getAccountInfoBycName(String cName, HttpServletRequest req, HttpServletResponse resp) {
		// CORS
		// 接受任意域名的请求
		// resp.setHeader("Access-Control-Allow-Origin", "*");
		Trade_Account trade_account = traderService.getAccountInfoBycName(cName);
		if (trade_account != null && trade_account.getuID() > 0) {
			// req.setAttribute("trade_account", trade_account);
			return trade_account;
		}

		return null;
	}

	@RequestMapping("/updateUserAccountInfoBycName")
	@ResponseBody
	public String updateUserAccountInfoBycName(String cName, String cBankAccount) {
		Integer returnVal = traderService.updateUserAccountInfoBycName(cName, cBankAccount);
		if (returnVal > 0 && returnVal != null) {
			return "updateSuccess";
		}

		return "updateFailure";
	}

}
