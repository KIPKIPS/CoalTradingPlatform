package com.isscollege.listing.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.impl.ListingGoodsServiceImpl;
import com.isscollege.listing.service.impl.PurchInfoServiceImpl;

@Controller
@RequestMapping("getAllListingList")
public class ListingGoodsController {
	@Autowired
	ListingGoodsServiceImpl serviceDao;
	PurchInfoServiceImpl purchInfoservicedao;
	@RequestMapping("/getAllPurchListingList")
	@ResponseBody
	// 查询所有买家挂牌商品
	public Object[] getAllPurchListingList(Integer pageNum, Integer maxPage, HttpServletRequest req) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 8);

		List<Purch_Info> purList = serviceDao.getAllPurchListingList();
		PageInfo<Purch_Info> pageInfo1 = new PageInfo<>(purList);
		Object[] object = {purList,pageInfo1};
		return object;
	}

	@RequestMapping("/getAllSellerListingList")
	@ResponseBody
	// 查询所有卖家挂牌商品
	public Object[] getAllSellerListingList(Integer pageNum, Integer maxPage, HttpServletRequest req) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 8);
		List<Seller_Info> sellerList = serviceDao.getAllSellerListingList();
		PageInfo<Seller_Info> pageInfo2 = new PageInfo<>(sellerList);
		Object[] object = {sellerList,pageInfo2};
		return object;
	}

	@RequestMapping("/toProducts_list")
	public String toProducts_list() {
		return "products_list";
	}

	// 根据买家商品挂牌编号获得商品，并跳转到卖家摘牌界面
	@RequestMapping("/getPurchGoodsById")
	public String getPurchGoodsById(String pNumber,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		Pattern pattern = Pattern.compile("^[0-9]*$");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if(pattern.matcher(pNumber).matches()){
		    Purch_Info Purch_goods = serviceDao.getPurchGoodsById(Integer.parseInt(pNumber));
			if(Purch_goods != null && Purch_goods.getpNumber() > 0){
				   
				   req.setAttribute("Purch_goods", Purch_goods);
				  
				   return "buyerDelist";
				}
		}
		PrintWriter pw = resp.getWriter();
		pw.print("<script>");
		pw.print("alert('未找到该商品！');");
		pw.print("location.href='toproducts_list';");
		pw.print("</script>");
		return null;
	}
	// 根据卖家商品挂牌编号获得商品，并跳转到买家摘牌界面
	@RequestMapping("/getSellerGoodsById")
	public String getSellerGoodsById(String sNumber, HttpServletRequest req,HttpServletResponse resp) throws IOException {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if(pattern.matcher(sNumber).matches()){
		    Seller_Info Seller_goods = serviceDao.getSellerGoodsById(Integer.parseInt(sNumber));
			if(Seller_goods != null && Seller_goods.getsNumber() > 0){
				   req.setAttribute("Seller_goods", Seller_goods);
				   return "sellerDelist";
				}
		}
		PrintWriter pw = resp.getWriter();
		pw.print("<script>");
		pw.print("alert('未找到该商品！');");
		pw.print("location.href='toproducts_list';");
		pw.print("</script>");
		return null;
	}
}
