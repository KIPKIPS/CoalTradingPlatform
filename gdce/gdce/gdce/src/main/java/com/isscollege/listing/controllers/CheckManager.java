package com.isscollege.listing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Check")
public class CheckManager {

	@RequestMapping("/CheckManager")
	private String CheckController() {
		return "checkManager";
	}
}