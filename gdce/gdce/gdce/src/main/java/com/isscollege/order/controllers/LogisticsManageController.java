package com.isscollege.order.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logisticsManage")
public class LogisticsManageController {

	@RequestMapping("/toCheck")
	public String toCheck(){
		return "deal_seller";
	}
	
	@RequestMapping("/distributing")
	public String distributing(){
		return "deal_purch";
	}
	
	@RequestMapping("/complete")
	public String complete(){
		return "deal_seller";
	}
}
