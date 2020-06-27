package com.isscollege.delisting.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isscollege.delisting.service.impl.DelistServiceImp;
import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.impl.PurchInfoServiceImpl;
import com.isscollege.listing.service.impl.SellerInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.service.impl.TraderServiceImpl;

@Controller
@RequestMapping("Delist")
public class DelistController {
	@Autowired
	DelistServiceImp delistServiceImp;
	@Autowired
	TraderServiceImpl traderServiceImpl;
	@Autowired
	PurchInfoServiceImpl purchInfoServiceImpl;
	@Autowired
	SellerInfoServiceImpl sellerInfoServiceImpl;
	private static final Logger LOG = Logger.getLogger(DelistController.class);

	@RequestMapping("/sellerDelistPage")
	public String sellerDelistPage() {

		return "sellerDelist";
	}

	@RequestMapping("/buyerDelistPage")
	public String buyerDelistPage() {
		// System.out.println("reportChartPage");
		return "buyerDelist";
	}

	// 返回卖家信息到页面,把对应信息放到session
	@RequestMapping("/getSellerDelistInfo")
	@ResponseBody
	public String getSellerDelistInfo(String no, HttpSession session) {
		int sNumber = Integer.parseInt(no);
		System.out.println(sNumber);
		Seller_Info seller_info = sellerInfoServiceImpl.getSeller_InfobysNumber(sNumber);
		String sState = seller_info.getsState();

		session.setAttribute("sNumber", no);

		LOG.info(seller_info);
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		session.setAttribute("delistNo", uID);
		session.setAttribute("listNo", sNumber);
		if (sState == "2") {
			return "<script>alert('已经被摘牌') \n history.back()</script>";
		} else {
			return "<script>location.href='/seller/sellFrozenMoney'</script>";
		}
	}

	// 返回买家信息到页面,把对应信息放到session
	@RequestMapping("/getBuyerDelistInfo")
	@ResponseBody
	public String getBuyerDelistInfo(String no, HttpSession session) {
		int pNumber = Integer.parseInt(no);
		System.out.println("pNumber   " + no);
		Purch_Info purch_info = purchInfoServiceImpl.getPurch_InfobypNumber(pNumber);
		String pState = purch_info.getpState();
		session.setAttribute("pBidBond", purch_info.getpBidBond());
		session.setAttribute("pQuoDespsit", purch_info.getpQuoDeposit());
		session.setAttribute("pNumber", no);
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		session.setAttribute("delistNo", uID);
		session.setAttribute("listNo", pNumber);
		String bankAcount = purchInfoServiceImpl.getCBankAccount(uID);
		System.out.println("uID   " + uID);
		session.setAttribute("bankAcount", bankAcount);
		System.out.println("bankID   " + bankAcount);
		System.out.println("bzj   " + purch_info.getpBidBond());
		if (pState == "2") {
			return "<script>alert('已经被摘牌') \n history.back()</script>";
		} else {

			return "<script>location.href='/purch/purchFrozenMoney'</script>";
		}

	}

	// 给页面返回买家公司名
	@RequestMapping("/getBuyerCName")
	@ResponseBody
	public String getBuyerCName(String no) {
		int pNumber = Integer.parseInt(no);

		Purch_Info purch_info = purchInfoServiceImpl.getPurch_InfobypNumber(pNumber);
		LOG.info(purch_info);
		int uID = purch_info.getuID();
		String cName = traderServiceImpl.getCompanyName(uID);
		System.out.println(cName);
		return cName;

	}

}
