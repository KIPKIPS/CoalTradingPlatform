package com.isscollege.listing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Audit")
public class AuditManager {

	@RequestMapping("/AuditManager")
	private String AuditController() {
		return "auditManager";
	}
}