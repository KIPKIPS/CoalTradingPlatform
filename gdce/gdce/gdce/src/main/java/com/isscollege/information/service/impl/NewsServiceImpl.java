package com.isscollege.information.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isscollege.information.dao.NewsDao;
import com.isscollege.information.entity.News;
import com.isscollege.information.service.INewsService;
import com.isscollege.users.entity.Opinion;

@Service
public class NewsServiceImpl implements INewsService {
	@Autowired
	NewsDao newsDao;

	public NewsServiceImpl(NewsDao newsDao2) {
		newsDao = newsDao2;
	}

	@Override
	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

	@Override
	public News getNewsById(Integer nID) {
		return newsDao.getNewsById(nID);
	}

	// 资讯审核通过
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Integer permitNews(Integer nPublisherID, Integer nID, String uOpinion) {
		Integer number2 = 0;
		Integer number1 = newsDao.modifyPermitNews(nPublisherID, nID);
		if (newsDao.getNewsOpinion(nID) == 1) {
			number2 = newsDao.modifyOpinion(nID, uOpinion);
		} else {
			number2 = newsDao.addNewsOpinion(nID, uOpinion);
		}
		return (number1 + number2);
	}

	// 资讯审核未通过
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Integer notPermitNews(Integer nPublisherID, Integer nID, String uOpinion) {
		Integer number2 = 0;
		Integer number1 = newsDao.modifyNotPermitNews(nPublisherID, nID);
		if (newsDao.getNewsOpinion(nID) == 1) {
			number2 = newsDao.modifyOpinion(nID, uOpinion);
		} else {
			number2 = newsDao.addNewsOpinion(nID, uOpinion);
		}
		return (number1 + number2);
	}

	// 查询审核通过的资讯
	@Override
	public List<News> getAllCheckedNews() {
		return newsDao.getAllCheckedNews();
	}

	// 添加新的资讯
	@Override
	public Integer addNews(Integer nEditorID, String nTheme, String nContent) {
		return newsDao.addNews(nEditorID, nTheme, nContent);
	}

	// 查询审核未通过的资讯
	@Override
	public List<News> getAllNoCheckedNews() {
		// TODO Auto-generated method stub
		return newsDao.getAllNoCheckedNews();
	}

	// 查询对应资讯的审核意见
	@Override
	public Opinion getOpinion(Integer nID) {
		// TODO Auto-generated method stub
		return newsDao.getOpinion(nID);
	}

}
