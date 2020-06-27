package com.isscollege.information.service;

import java.util.List;

import com.isscollege.information.entity.News;
import com.isscollege.users.entity.Opinion;

public interface INewsService {
	// 查询未审核的资讯
	public List<News> getAllNews();

	// 根据资讯编号查询对应的资讯
	public News getNewsById(Integer nID);

	// 资讯审核通过
	public Integer permitNews(Integer nPublisherID, Integer nID, String uOpinion);

	// 资讯审核未通过
	public Integer notPermitNews(Integer nPublisherID, Integer nID, String uOpinion);

	// 添加新的资讯
	public Integer addNews(Integer nEditorID, String nTheme, String nContent);

	// 查询审核通过的资讯
	public List<News> getAllCheckedNews();

	// 查询审核未通过的资讯
	public List<News> getAllNoCheckedNews();

	// 查询对应资讯的审核意见
	public Opinion getOpinion(Integer nID);
}
