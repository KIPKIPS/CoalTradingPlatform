package com.isscollege.listing.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.isscollege.listing.service.impl.SellerGoodServiceImpl;

@RunWith(SpringRunner.class)
// @WebMvcTest(SellerGoodController.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
// @WebAppConfiguration
public class SellerGoodControllerTest {
	@MockBean
	private SellerGoodServiceImpl sellerGoodService;
	@Autowired
	private MockMvc mockmvc;

	@Test

	public void testetst() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/SellerGoodInfo/purchCheckNotPass")).andExpect(status().isOk())
				.andDo(print());

	}

}
