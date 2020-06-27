package com.isscollege.information.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.information.entity.News;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsDaoTest {
	@Autowired
	private NewsDao newsDao;

	@Test
	public void getAllNewsTest() {
		boolean expect = true;
		boolean result = false;
		Integer newsListSize = newsDao.getAllNews().size();
		if (newsListSize > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	// 审核未通过列表
	@Test
	public void getAllNoCheckedNewsTest() {
		boolean expect = true;
		boolean result = false;
		Integer newsListSize = newsDao.getAllNoCheckedNews().size();
		if (newsListSize > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void getNewsByIdTest1() {
		boolean expect = false;
		boolean result = false;
		News news = newsDao.getNewsById(-1);
		if (news != null && news.getnID() > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void getNewsByIdTest2() {
		boolean expect = true;
		boolean result = false;
		News news = newsDao.getNewsById(2);
		if (news != null && news.getnID() > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void getNewsByIdTest3() {
		boolean expect = false;
		boolean result = false;
		News news = newsDao.getNewsById(0);
		if (news != null && news.getnID() > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void modifyPermitNewsTest1() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.modifyPermitNews(-2, -2);
		if (num != null && num == 1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void modifyPermitNewsTest2() {
		boolean expect = true;
		boolean result = false;
		Integer num = newsDao.modifyPermitNews(2, 2);
		if (num != null && num == 1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void modifyNotPermitNewsTest() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.modifyNotPermitNews(0, 0);
		if (num != null && num == 1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void getNewsOpinionTest1() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.getNewsOpinion(2);
		if (num != null && num > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void getNewsOpinionTest2() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.getNewsOpinion(-2);
		if (num != null && num > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void getNewsOpinionTest3() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.getNewsOpinion(0);
		if (num != null && num > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void addNewsOpinionTest1() {
		boolean expect = true;
		boolean result = false;
		Integer num = newsDao.addNewsOpinion(2, "不符合要求");
		if (num != null && num == 1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void addNewsOpinionTest2() {
		boolean expect = true;
		boolean result = false;
		Integer num = newsDao.addNewsOpinion(-2, "不符合要求");
		if (num != null && num == 1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void addNewsOpinionTest3() {
		boolean expect = true;
		boolean result = false;
		Integer num = newsDao.addNewsOpinion(0, "不符合要求");
		if (num != null && num == 1) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void modifyOpinionTest1() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.modifyOpinion(2, "我觉得不行");
		if (num != null && num > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void modifyOpinionTest2() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.modifyOpinion(-2, "我觉得不行");
		if (num != null && num > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}

	@Test
	public void modifyOpinionTest3() {
		boolean expect = false;
		boolean result = false;
		Integer num = newsDao.modifyOpinion(0, "我觉得不行");
		if (num != null && num > 0) {
			result = true;
		}
		assertEquals(expect, result);
	}
}
