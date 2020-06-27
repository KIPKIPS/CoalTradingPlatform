package com.isscollege.logistic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isscollege.logistic.service.Impl.LogisticServiceImpl;
import com.isscollege.users.entity.Login_Info;

/**
 * @author whg
 *
 */
@Controller
@RequestMapping("logisticManageController")
public class LogisticManageController {
	@Autowired
	private LogisticServiceImpl logisticService;

	@GetMapping("/remainChecked")
	public String remainChecked(HttpSession session, HttpServletRequest req) throws JsonProcessingException {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr;
		jsonStr = objectMapper.writeValueAsString(logisticService.getTradeIDByUID(trader.getuID()));
		req.setAttribute("tradeIDList", jsonStr);
		// System.out.println(logisticService.getTradeIDByUID(trader.getuID()));
		return "remainCheckedWaybill";

	}

	@RequestMapping("/remainFinished")
	public String remainFinished(HttpSession session, HttpServletRequest req) throws JsonProcessingException {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr;
		jsonStr = objectMapper.writeValueAsString(logisticService.getTradeIDByUID(trader.getuID()));
		req.setAttribute("tradeIDList", jsonStr);
		System.out.println(logisticService.getTradeIDByUID(trader.getuID()));
		return "remainFinishedWaybill";
	}

	@GetMapping("/transPorting")
	public String transPorting(HttpSession session, HttpServletRequest req) throws JsonProcessingException {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr;
		jsonStr = objectMapper.writeValueAsString(logisticService.getTradeIDByUID(trader.getuID()));
		req.setAttribute("tradeIDList", jsonStr);
		System.out.println(logisticService.getTradeIDByUID(trader.getuID()));
		return "transPorting";
	}

}
