package com.isscollege.listing.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.impl.SellerInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;

/*
 * 卖家挂牌
 */

@Controller
@RequestMapping("/seller")
public class DealSellerController {

	@Autowired
	SellerInfoServiceImpl sellerInfoService;
	//提交买方挂牌表单
	@RequestMapping("/submit_deal")
	@ResponseBody
	public String submit_deal(Seller_Info seller_info, HttpSession session) {

		try {
			// 1.从session中拿出用户编号，并写入挂牌数据中
			Login_Info login_info = (Login_Info) session.getAttribute("trader");
			seller_info.setuID(login_info.getuID());
			// 2.设置挂牌状态0：待审查
			seller_info.setsState("0");
			// 3.设置审查管理员
			seller_info.setAdminID(-1);
			// 4.将数据交给service处理，并拿到返回值
			int result = sellerInfoService.addSellerInfo(seller_info);
			// 5.处理返回值
			if (result > 0) {
				return "<script>alert('挂牌成功,等待审核......'); location.href='/trader/tradeProducts_list';</script>";
			} else {
				return "<script>alert('系统错误,请稍后重试'); location.href='/trader/tradeProducts_list';</script>";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "<script>alert('个人信息有误，请重新登陆'); window.parent.location.href='/admin/index';</script>";
		}

	}

	@RequestMapping("/sellFrozenMoney")
	private String sellFrozenMoney() {
		// 卖方挂牌暂时无保证金----直接跳转到center
		return "sellDelistConfirm";
	}
}