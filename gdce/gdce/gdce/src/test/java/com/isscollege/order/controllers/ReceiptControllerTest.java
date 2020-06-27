package com.isscollege.order.controllers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.ByteArrayInputStream;

import javax.servlet.ServletContext;

import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.druid.support.logging.Log;
import com.isscollege.order.service.impl.ReceiptServiceImpl;
import com.mysql.jdbc.log.Log4JLogger;

//还未完成**********************************************************************
@RunWith(SpringRunner.class)
@WebMvcTest(ReceiptController.class)
public class ReceiptControllerTest {
	private Log4JLogger logger = new Log4JLogger("debug");
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ServletContext context;
	@MockBean
	private MockMultipartFile mulFile;
	@MockBean
	private MockHttpSession session;
	@MockBean
	private ReceiptServiceImpl receiptService;
	
	@Before
	public void setup() {
		when(session.getServletContext()).thenReturn(context);
	}

	@Test
	public void testExample() throws Exception {
		String path="";
		String orderNo = "12345432";
		String tradeNo = "2019";
		byte[] content = new String("afsdghjkljkfgjfhsdasdhfjffghjfdgs").getBytes();
		
		given(context.getRealPath(path)).willReturn("E:\\main\\webapp");
		given(receiptService.modifyOrderStateAndReceiptSrc(tradeNo + "/" + "bankreceipt.jpg", tradeNo))
				.willReturn(1);
		given(mulFile.getContentType()).willReturn("image/jpg");
		given(mulFile.getName()).willReturn("file");
		given(mulFile.getBytes()).willReturn(content);
		given(mulFile.getInputStream()).willReturn(new ByteArrayInputStream(content));
		given(session.getServletContext()).willReturn(context);
		given(receiptService.getTradeNo(orderNo)).willReturn(tradeNo);
		
		mockMvc.perform(fileUpload("/order/uploadBankReceipt")
				.file(mulFile)
				.param("orderNo", orderNo)
				.session(session))
				.andExpect(status().is(200))
				.andExpect(MockMvcResultMatchers.content().string("login"))
				.andDo(new ResultHandler() {
					
					@Override
					public void handle(MvcResult result) throws Exception {
						// TODO Auto-generated method stub
						logger.logInfo(
						((MockMultipartHttpServletRequest)result.getRequest()).getFile("file"));
					}
				});
	}
}
// ************************************************************************************