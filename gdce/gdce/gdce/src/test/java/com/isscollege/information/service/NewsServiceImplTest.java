package com.isscollege.information.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.isscollege.information.dao.NewsDao;
import com.isscollege.information.service.impl.NewsServiceImpl;

@RunWith(SpringRunner.class)
public class NewsServiceImplTest {
	private NewsServiceImpl newsService;
	@MockBean
	private NewsDao newsDao;
	@Before
	public void setUp(){
		newsService = new NewsServiceImpl(newsDao);
	}
	
	//测试 资讯审核通过
	@Test
	public void permitNewsTest1(){
		Integer expect = 2;
		String opinion =  "不符合规矩";
		when(newsDao.modifyPermitNews(5, 2)).thenReturn(1);
		when(newsDao.getNewsOpinion(2)).thenReturn(1);
		when(newsDao.modifyOpinion(2,opinion)).thenReturn(1);
		Integer result = newsService.permitNews(5, 2, opinion);
		System.out.println(result);
		assertEquals(expect,result);
	}
	//测试 资讯审核通过
	@Test
	public void permitNewsTest2(){
		Integer expect = 2;
		String opinion =  "不符合规矩";
		when(newsDao.modifyPermitNews(5, 2)).thenReturn(1);
		when(newsDao.getNewsOpinion(2)).thenReturn(0);
		when(newsDao.addNewsOpinion(2, opinion)).thenReturn(1);
		Integer result = newsService.permitNews(5, 2, opinion);
		System.out.println(result);
		assertEquals(expect,result);
	}
	
	//测试资讯审核未通过
	@Test
	public void notPermitNewsTest1(){
		Integer expect = 2;
		String opinion = "存在错别字";
		when(newsDao.modifyNotPermitNews(5, 2)).thenReturn(1);
		when(newsDao.getNewsOpinion(2)).thenReturn(1);
		when(newsDao.modifyOpinion(2,opinion)).thenReturn(1);
		Integer result = newsService.notPermitNews(5, 2, opinion);
		System.out.println(result);
		assertEquals(expect,result);
	}
	
	//测试资讯审核未通过
	@Test
	public void notPermitNewsTest2(){
		Integer expect = 2;
		String opinion = "存在错别字";
		when(newsDao.modifyNotPermitNews(5, 2)).thenReturn(1);
		when(newsDao.getNewsOpinion(2)).thenReturn(0);
		when(newsDao.addNewsOpinion(2, opinion)).thenReturn(1);
		Integer result = newsService.notPermitNews(5, 2, opinion);
		System.out.println(result);
		assertEquals(expect,result);
	}
}
