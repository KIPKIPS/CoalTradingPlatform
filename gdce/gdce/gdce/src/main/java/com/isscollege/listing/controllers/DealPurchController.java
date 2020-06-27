package com.isscollege.listing.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.service.impl.PurchInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;

/*
 * 买家挂牌
 */
@Controller
@RequestMapping("purch")
public class DealPurchController {

	@Autowired
	PurchInfoServiceImpl purchInfoServiceImpl;

	@RequestMapping("/getCName")
	@ResponseBody
	// 得到用户的公司名称,传递给前端页面的回调函数
	public String getCName(HttpSession session) {
		Login_Info login_info = (Login_Info) session.getAttribute("trader");
		String cName = purchInfoServiceImpl.getCName(login_info.getuID());
		return cName;
	}

	// 处理表单中的date类型，使其转换为字符串类型，存储在javaBean中
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/submit_deal")
	@ResponseBody
	//提交卖方挂牌表单
	public String submit_deal(Purch_Info purch_info, HttpSession session) {
		try {
			// 1.得到用户数据
			Login_Info login_info = (Login_Info) session.getAttribute("trader");
			// 2.设置挂牌信息状态和待审核管理员
			purch_info.setpState("0");
			purch_info.setAdminID(-1);
			// 3.设置用户编号
			purch_info.setuID(login_info.getuID());
			// 4.交给service处理，添加挂牌信息并冻结保证金
			int result = purchInfoServiceImpl.addPurchInfo(purch_info);
			// 5.处理返回值
			if (result == 1)
				return "<script>alert('挂牌成功,等待审核......'); location.href='/trader/tradeProducts_list';</script>";
			else {
				return "<script>alert('系统错误,请稍后重试'); location.href='/trader/tradeProducts_list';</script>";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "<script>alert('个人信息有误，请重新登陆'); window.parent.location.href='/admin/index';</script>";
		}
	}

	// 根据当前用户id查询该公司银行账户
	@RequestMapping("/getCBankAccount")
	@ResponseBody
	public String getCBankAccount(HttpSession session) {
		try {
			Login_Info trader = (Login_Info) session.getAttribute("trader");
			return purchInfoServiceImpl.getCBankAccount(trader.getuID());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/purchFrozenMoney")
	private String purchFrozenMoney() {
		return "purchDelistConfirm";
	}
}
