package com.isscollege.listing.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.impl.SellerGoodServiceImpl;

@Controller
@RequestMapping("SellerGoodInfo")
public class SellerGoodController {
	@Autowired
	private SellerGoodServiceImpl sellerGoodService;

	// 根据uID查询卖家个人待审核表单
	@RequestMapping("/sellerCheck")
	public String sellerCheck(Integer uID, HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<Seller_Info> sellerCheckList = sellerGoodService.getInfoSellerCheckBy_uID(uID);

		PageInfo<Seller_Info> pageInfo = new PageInfo<Seller_Info>(sellerCheckList);
		req.setAttribute("sellerCheckList", sellerCheckList);
		req.setAttribute("pageInfo", pageInfo);
		return "sellerCheckedGoodInfo";
	}

	// 根据uID查询卖家个人已发布表单
	@RequestMapping("/sellerPublish")
	public String sellerPublish(Integer uID, HttpServletRequest req) {
		PageHelper.startPage(1, 3);

		List<Seller_Info> sellerPublishList = sellerGoodService.getInfoSellerPublishBy_uID(uID);

		PageInfo<Seller_Info> pageInfo = new PageInfo<Seller_Info>(sellerPublishList);
		req.setAttribute("sellerPublishList", sellerPublishList);
		req.setAttribute("pageInfo", pageInfo);
		return "sellerPublishedGoodInfo";
	}

	// 根据uID查询卖家个人已下架表单
	@RequestMapping("/sellerUnder")
	public String sellerunder(Integer uID, HttpServletRequest req) {
		PageHelper.startPage(1, 3);

		List<Seller_Info> sellerUnderList = sellerGoodService.getInfoSellerUnderBy_uID(uID);

		PageInfo<Seller_Info> pageInfo = new PageInfo<Seller_Info>(sellerUnderList);
		req.setAttribute("sellerUnderList", sellerUnderList);
		req.setAttribute("pageInfo", pageInfo);
		return "sellerUnderedGoodInfo";
	}

	// 根据uID查询买家个人待审核表单
	@RequestMapping("/purchCheck")
	public String purchCheck(Integer uID, HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<Purch_Info> purchCheckList = sellerGoodService.getInfoPurchCheckBy_uID(uID);

		PageInfo<Purch_Info> pageInfo = new PageInfo<Purch_Info>(purchCheckList);
		req.setAttribute("purchCheckList", purchCheckList);
		req.setAttribute("pageInfo", pageInfo);
		return "purchCheckedGoodInfo";
	}

	// 根据uID查询买家个人已下架表单
	@RequestMapping("/purchUnder")
	public String purchunder(Integer uID, HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<Purch_Info> purchUnderList = sellerGoodService.getInfoPurchUnderBy_uID(uID);

		PageInfo<Purch_Info> pageInfo = new PageInfo<Purch_Info>(purchUnderList);
		req.setAttribute("purchUnderList", purchUnderList);
		req.setAttribute("pageInfo", pageInfo);
		return "purchUnderedGoodInfo";
	}

	// 根据uID查询买家个人已发布表单
	@RequestMapping("/purchPublish")
	public String purchpublish(Integer uID, HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<Purch_Info> purchPublishList = sellerGoodService.getInfoPurchPublishBy_uID(uID);

		PageInfo<Purch_Info> pageInfo = new PageInfo<Purch_Info>(purchPublishList);
		req.setAttribute("purchPublishList", purchPublishList);
		req.setAttribute("pageInfo", pageInfo);
		return "purchPublishedGoodInfo";
	}

	// 根据商品编号查看买家待审核商品详情，进入审核
	@RequestMapping("/purchCheckSpecificInfo")
	public String purchCheckSpecificInfo(Integer uID, Integer pNumber, HttpServletRequest req) {

		Purch_Info specificGoodInfo = sellerGoodService.getInfoBy_pNumber(pNumber);
		String cName = sellerGoodService.get_cName(uID);
		req.setAttribute("specificGoodInfo", specificGoodInfo);
		req.setAttribute("cName", cName);
		return "purchCheckSpecificInfo";

	}

	// 根据商品编号查看买家商品详情
	@RequestMapping("/purchSpecificInfo")
	public String purchSpecificInfo(Integer uID, Integer pNumber, HttpServletRequest req) {

		Purch_Info specificGoodInfo = sellerGoodService.getInfoBy_pNumber(pNumber);
		String cName = sellerGoodService.get_cName(uID);
		req.setAttribute("specificGoodInfo", specificGoodInfo);
		req.setAttribute("cName", cName);
		return "purchSpecificInfo";

	}

	// 根据商品编号查看卖家待审核商品详情，进入审核
	@RequestMapping("/sellerCheckSpecificInfo")
	public String sellerCheckSpecificInfo(Integer sNumber, HttpServletRequest req) {

		Seller_Info specificGoodInfo = sellerGoodService.getInfoBy_sNumber(sNumber);

		req.setAttribute("specificGoodInfo", specificGoodInfo);
		return "sellerCheckSpecificInfo";

	}

	// 根据商品编号查看卖家商品详情
	@RequestMapping("/sellerSpecificInfo")
	public String sellerSpecificInfo(Integer sNumber, HttpServletRequest req) {

		Seller_Info specificGoodInfo = sellerGoodService.getInfoBy_sNumber(sNumber);

		req.setAttribute("specificGoodInfo", specificGoodInfo);
		return "sellerSpecificInfo";

	}

	// 查询买家待审核商品列表
	@RequestMapping("/purchCheckSecond")
	public String ppurchCheckSecond(HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<Purch_Info> purchCheckSecondList = sellerGoodService.getInfoPurchCheck();

		PageInfo<Purch_Info> pageInfo = new PageInfo<Purch_Info>(purchCheckSecondList);
		req.setAttribute("purchCheckSecondList", purchCheckSecondList);
		req.setAttribute("pageInfo", pageInfo);
		return "purchCheckSecond";
	}

	// 查询卖家待审核商品列表
	@RequestMapping("/sellerCheckSecond")
	public String sellerCheckSecond(HttpServletRequest req) {
		PageHelper.startPage(1, 3);
		List<Seller_Info> sellerCheckSecondList = sellerGoodService.getInfoSellerCheck();

		PageInfo<Seller_Info> pageInfo = new PageInfo<Seller_Info>(sellerCheckSecondList);
		req.setAttribute("sellerCheckSecondList", sellerCheckSecondList);
		req.setAttribute("pageInfo", pageInfo);
		return "sellerCheckSecond";
	}

	// 买家商品审核通过
	@RequestMapping("/purchCheckPass")
	@ResponseBody
	public String purchCheckPass(HttpSession session, Integer pNumber) {
		int modifyPassStateBy_pNumber = sellerGoodService.modifyPassStateBy_pNumber(pNumber);

		if (modifyPassStateBy_pNumber == 1)

			return "<script>alert('审核通过！！！跳转回待审核信息页面') \n location.href='"
					+ session.getServletContext().getContextPath() + "/SellerGoodInfo/purchCheckSecond'</script>";

		else
			return "<script>alert('审核不通过')</script>";

	}

	// 买家商品审核不通过
	@RequestMapping("/purchCheckNotPass")
	@ResponseBody
	public String purchCheckNotPass(Integer pNumber, String uOpinion, HttpSession session) {
		sellerGoodService.addSellerPurchNotPassSuggest(pNumber, uOpinion);
		int modifyNotPassStateBy_pNumber = sellerGoodService.modifyNotPassStateBy_pNumber(pNumber);

		if (modifyNotPassStateBy_pNumber == 1)
			return "<script>alert('审核不通过！！！跳转回待审核信息页面') \n location.href='"
					+ session.getServletContext().getContextPath() + "/SellerGoodInfo/purchCheckSecond'</script>";

		else
			return "<script>alert('错误')</script>";

	}

	// 卖家商品审核通过
	@RequestMapping("/sellerCheckPass")
	@ResponseBody
	public String sellerCheckPass(Integer sNumber, HttpSession session) {
		int modifyPassStateBy_sNumber = sellerGoodService.modifyPassStateBy_sNumber(sNumber);

		if (modifyPassStateBy_sNumber == 1)
			return "<script>alert('审核通过！！！跳转回待审核信息页面') \n location.href='"
					+ session.getServletContext().getContextPath() + "/SellerGoodInfo/sellerCheckSecond'</script>";

		else
			return "<script>alert('审核不通过')</script>";

	}

	// 卖家商品审核不通过
	@RequestMapping("/sellerCheckNotPass")
	@ResponseBody
	public String sellerCheckNotPass(Integer sNumber, String uOpinion, HttpSession session) {

		sellerGoodService.addSellerCheckNotPassSuggest(sNumber, uOpinion);

		int modifyNotPassStateBy_sNumber = sellerGoodService.modifyNotPassStateBy_sNumber(sNumber);

		if (modifyNotPassStateBy_sNumber == 1)

			return "<script>alert('审核不通过！！！跳转回待审核信息页面') \n location.href='"
					+ session.getServletContext().getContextPath() + "/SellerGoodInfo/sellerCheckSecond'</script>";

		else
			return "<script>alert('错误')</script>";

	}

	// 表单分页
	@RequestMapping("/page")
	public String page(Integer pageNum, Integer maxPage, Integer uID, int flag, HttpServletRequest req) {
		// 校验当前页是否超出范围
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}

		switch (flag) {
		// 卖家个人待审核商品分页
		case 0:
			PageHelper.startPage(pageNum, 3);
			List<Seller_Info> sellerCheckList = sellerGoodService.getInfoSellerCheckBy_uID(uID);
			PageInfo<Seller_Info> pageInfo = new PageInfo<Seller_Info>(sellerCheckList);
			req.setAttribute("sellerCheckList", sellerCheckList);

			req.setAttribute("pageInfo", pageInfo);

			return "sellerCheckedGoodInfo";
		// 卖家个人已发布商品分页
		case 1:
			PageHelper.startPage(pageNum, 3);
			List<Seller_Info> sellerPublishList = sellerGoodService.getInfoSellerPublishBy_uID(uID);
			PageInfo<Seller_Info> pageInfo_1 = new PageInfo<Seller_Info>(sellerPublishList);
			req.setAttribute("sellerPublishList", sellerPublishList);

			req.setAttribute("pageInfo", pageInfo_1);
			return "sellerPublishedGoodInfo";
		// 卖家个人已下架商品分页
		case 2:
			PageHelper.startPage(pageNum, 3);

			List<Seller_Info> sellerUnderList = sellerGoodService.getInfoSellerUnderBy_uID(uID);

			PageInfo<Seller_Info> pageInfo_2 = new PageInfo<Seller_Info>(sellerUnderList);
			req.setAttribute("sellerUnderList", sellerUnderList);
			req.setAttribute("pageInfo", pageInfo_2);
			return "sellerUnderedGoodInfo";
		// 买家个人待审核商品分页
		case 3:
			PageHelper.startPage(pageNum, 3);
			List<Purch_Info> purchCheckList = sellerGoodService.getInfoPurchCheckBy_uID(uID);

			PageInfo<Purch_Info> pageInfo_3 = new PageInfo<Purch_Info>(purchCheckList);
			req.setAttribute("purchCheckList", purchCheckList);
			req.setAttribute("pageInfo", pageInfo_3);
			return "purchCheckedGoodInfo";
		// 买家个人已下架商品分页
		case 4:
			PageHelper.startPage(pageNum, 3);
			List<Purch_Info> purchUnderList = sellerGoodService.getInfoPurchUnderBy_uID(uID);

			PageInfo<Purch_Info> pageInfo_4 = new PageInfo<Purch_Info>(purchUnderList);
			req.setAttribute("purchUnderList", purchUnderList);
			req.setAttribute("pageInfo", pageInfo_4);
			return "purchUnderedGoodInfo";
		// 买家个人已发布商品分页
		case 5:
			PageHelper.startPage(pageNum, 3);
			List<Purch_Info> purchPublishList = sellerGoodService.getInfoPurchPublishBy_uID(uID);

			PageInfo<Purch_Info> pageInfo_5 = new PageInfo<Purch_Info>(purchPublishList);
			req.setAttribute("purchPublishList", purchPublishList);
			req.setAttribute("pageInfo", pageInfo_5);
			return "purchPublishedGoodInfo";
		// 所有买家待审核商品分页
		case 6:
			PageHelper.startPage(pageNum, 3);
			List<Purch_Info> purchCheckSecondList = sellerGoodService.getInfoPurchCheck();

			PageInfo<Purch_Info> pageInfo_6 = new PageInfo<Purch_Info>(purchCheckSecondList);
			req.setAttribute("purchCheckSecondList", purchCheckSecondList);
			req.setAttribute("pageInfo", pageInfo_6);
			return "purchCheckSecond";
		// 所有卖家待审核商品分页
		case 7:
			PageHelper.startPage(pageNum, 3);
			List<Seller_Info> sellerCheckSecondList = sellerGoodService.getInfoSellerCheck();
			PageInfo<Seller_Info> pageInfo_7 = new PageInfo<Seller_Info>(sellerCheckSecondList);
			req.setAttribute("sellerCheckSecondList", sellerCheckSecondList);

			req.setAttribute("pageInfo", pageInfo_7);

			return "sellerCheckSecond";

		}
		return null;

	}

}
