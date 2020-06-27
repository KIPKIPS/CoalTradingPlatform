/**
 * 
 */
package com.isscollege.addtestdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.addtestdata.service.AddOrderServiceImpl;
import com.isscollege.utils.GetNumber;

/**
 * @author Apple
 *
 */
@Controller
@RequestMapping("add")
public class AddTestDataAboutOrderInfo {
	@Autowired
	AddOrderServiceImpl addOrder;

	@RequestMapping("/addOrderInfo")
	@ResponseBody
	public String addOrderOnfo() {
		// 初始化订单状态
		String orderState = "0";
		for (int i = 1; i < 161; i++) {
			// 插入用户1作为买方挂牌的数据
			addOrder.addDataIntoPurch(i, 1);
			// 插入用户1作为卖方挂牌的数据
			addOrder.addDataIntoSeller(i, 1);
		}
		for (int i = 161; i < 321; i++) {
			// 插入用户2作为买方挂牌的数据
			addOrder.addDataIntoPurch(i, 2);
			// 插入用户2作为卖方挂牌的数据
			addOrder.addDataIntoSeller(i, 2);
		}
		for (int i = 1; i < 161; i++) {
			// 添加用户2作为买方摘用户1的牌的数据
			addOrder.addDataIntoTransaction(GetNumber.getNumber("2" + i + "1"), 2, i, "1");
			// 添加用户2作为卖方摘用户1的牌的数据
			addOrder.addDataIntoTransaction(GetNumber.getNumber("2" + i + "2"), 2, i, "2");
			// 订单状态：待付款
			if (i >= 1) {
				orderState = "0";
			}
			// 订单状态：待发货
			if (i >= 41) {
				orderState = "1";
			}
			// 订单状态：已发货
			if (i >= 81) {
				orderState = "2";
			}
			// 订单状态：确认收货
			if (i >= 121) {
				orderState = "3";
			}
			// 生成对应订单
			addOrder.addDataIntoOrder(GetNumber.getNumber("a1" + i), GetNumber.getNumber("2" + i + "1"), orderState);
			addOrder.addDataIntoOrder(GetNumber.getNumber("b2" + i), GetNumber.getNumber("2" + i + "2"), orderState);
		}
		for (int i = 161; i < 321; i++) {
			// 添加用户1作为买方摘用户2的牌的数据
			addOrder.addDataIntoTransaction(GetNumber.getNumber("1" + i + "1"), 1, i, "1");
			// 添加用户1作为卖方摘用户2的牌的数据
			addOrder.addDataIntoTransaction(GetNumber.getNumber("1" + i + "2"), 1, i, "2");
			// 订单状态：待付款
			if (i >= 161) {
				orderState = "0";
			}
			// 订单状态：待发货
			if (i >= 201) {
				orderState = "1";
			}
			// 订单状态：已发货
			if (i >= 241) {
				orderState = "2";
			}
			// 订单状态：确认收货
			if (i >= 281) {
				orderState = "3";
			}
			// 生成对应订单
			addOrder.addDataIntoOrder(GetNumber.getNumber("a1" + i), GetNumber.getNumber("1" + i + "1"), orderState);
			addOrder.addDataIntoOrder(GetNumber.getNumber("b2" + i), GetNumber.getNumber("1" + i + "2"), orderState);
		}
		return "<script>alert('订单相关数据插入成功！')</script>";
	}

	// 通过挂牌编号、用户ID往挂牌表插入数据(挂牌状态为1（已发布）)
	@RequestMapping("/addListInfo")
	public void addListInfo() {
		for (int i = 321; i < 371; i++) {
			// 插入用户2作为买方挂牌的数据
			addOrder.addDataIntoPurchS1(i, 2);
			// 插入用户2作为卖方挂牌的数据
			addOrder.addDataIntoSellerS1(i, 2);
		}
	}

	@RequestMapping("/addContract")
	@ResponseBody
	public String addContract() {
		// 初始化合同状态
		String contractState = "00";
		for (int i = 371; i < 471; i++) {
			// 插入用户1作为买方挂牌的数据
			addOrder.addDataIntoPurch(i, 1);
			// 插入用户1作为卖方挂牌的数据
			addOrder.addDataIntoSeller(i, 1);
		}
		for (int i = 471; i < 571; i++) {
			// 插入用户2作为买方挂牌的数据
			addOrder.addDataIntoPurch(i, 2);
			// 插入用户2作为卖方挂牌的数据
			addOrder.addDataIntoSeller(i, 2);
		}
		for (int i = 371; i < 471; i++) {
			if (i > 370) {
				contractState = "00";
			}
			if (i > 420) {
				contractState = "01";
			}
			// 添加用户2作为买方摘用户1的牌的数据
			addOrder.addDataIntoTransaction_contract(GetNumber.getNumber("2" + i + "1"), 2, i, "1", contractState);
			// 添加用户2作为卖方摘用户1的牌的数据
			addOrder.addDataIntoTransaction_contract(GetNumber.getNumber("2" + i + "2"), 2, i, "2", contractState);
		}
		for (int i = 471; i < 571; i++) {
			if (i > 470) {
				contractState = "00";
			}
			if (i > 520) {
				contractState = "01";
			}
			// 添加用户1作为买方摘用户2的牌的数据
			addOrder.addDataIntoTransaction_contract(GetNumber.getNumber("1" + i + "1"), 1, i, "1", contractState);
			// 添加用户1作为卖方摘用户2的牌的数据
			addOrder.addDataIntoTransaction_contract(GetNumber.getNumber("1" + i + "2"), 1, i, "2", contractState);
		}
		return "<script>alert('合同相关数据插入成功！')</script>";
	}

	// 插入资讯内容
	@RequestMapping("/addNews")
	public String addNews() {
		String nContent;
		String nTheme;
		for (int i = 0; i < 50; i++) {
			nContent = "根据监测数据测算，2017年7月7日，中国煤炭价格指数（全国综合指数）为154.2，比上期上涨0.1,虽然长协煤价略降，但是市场煤价却迎来了大幅上涨，这中间到底发生了什么？";
			nTheme = "中国煤炭价格指数周评" + i;
			addOrder.addNews(1, nTheme, nContent, 0, 4);
		}
		return "<script>alert('咨询表数据插入成功！')</script>";
	}
}
