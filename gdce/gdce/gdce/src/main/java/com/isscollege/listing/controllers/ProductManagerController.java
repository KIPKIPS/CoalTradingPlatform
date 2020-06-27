package com.isscollege.listing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Product")
public class ProductManagerController {

	@RequestMapping("/ProductManager")
	private String productManager() {
		return "productManager";
	}

	@RequestMapping("/WaybillFinished")
	private String waybillFinished() {
		return "WaybillFinished";
	}
}
