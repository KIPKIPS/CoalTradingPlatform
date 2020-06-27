package com.isscollege.contract.contrallers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import com.isscollege.contract.entity.Contract;
import com.isscollege.contract.service.impl.GetContractImpl;
import com.isscollege.order.controllers.OrderInfoController;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderInfoController.class)
public class contractControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private GetContractImpl getContractservice;

	@Test
	// 取消交易
	public void testremoveAllContract() throws Exception {
		given(getContractservice.removeAllContract("20190101")).willReturn(1);
		// 测试接受get请求的 controller
		mockMvc.perform(get("/contract/remove").param("tradeNo", "20190101")).andExpect(status().isOk());
	}

	@Test
	// 展示合同
	public void testgetContractDetails() throws Exception {
		given(getContractservice.getContractDetails("20190101")).willReturn(new Contract());
		mockMvc.perform(get("/contract/shows").param("tradeNo", "20190101"))
				.andExpect((ResultMatcher) ((ResultActions) status()).andExpect(status().isOk()))
				.andExpect(view().name("redirect:/contractDetails/"));
	}
}
