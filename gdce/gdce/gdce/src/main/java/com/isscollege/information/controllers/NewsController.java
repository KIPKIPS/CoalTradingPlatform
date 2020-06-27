package com.isscollege.information.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.information.entity.News;
import com.isscollege.information.service.impl.NewsServiceImpl;
import com.isscollege.users.entity.Admin;
import com.isscollege.users.entity.Opinion;

@Controller
@RequestMapping("News")
public class NewsController {
	@Autowired
	private NewsServiceImpl newsService;

	// 跳转到资讯编辑管理页面
	@RequestMapping("/index1")
	public String index1() {
		return "newsManagement";
	}

	// 跳转到增加资讯页面
	@RequestMapping("/add")
	public String index2() {
		return "addNews";
	}

	// 查询所有未审核的资讯并进行分页
	@RequestMapping("/getAllNews")
	@ResponseBody
	public Object[] getAllNews(Integer pageNum, Integer maxPage) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 15);

		List<News> newsList = newsService.getAllNews();
		PageInfo<News> newsPageInfo = new PageInfo<>(newsList);
		Object[] object = { newsList, newsPageInfo };
		return object;
	}
	// 跳转到待审核资讯页面

	@RequestMapping("/toNewsJsp")
	public String toNewsJsp(HttpServletRequest req) {
		return "verifyNewsInfoPage";
	}

	// 根据前台传回的nID查询资讯并跳到资讯详情页
	@RequestMapping("/getNewsById")
	public String getNewsById(String nID, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 对传入的nID判断，避免地址栏拼参导致后台出错，只能是数字
		Pattern pattern = Pattern.compile("^[0-9]*$");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if (pattern.matcher(nID).matches()) {
			News news = newsService.getNewsById(Integer.parseInt(nID));
			if (news != null && news.getnID() > 0) {
				// 将标题以及正文中自带的换/n/r进行转义，避免前台解析时出错
				news.setnTheme(news.getnTheme().replaceAll("\r\n", "<br>&nbsp;&nbsp;"));
				news.setnContent(news.getnContent().replaceAll("\r\n", "<br>&nbsp;&nbsp;"));
				req.setAttribute("news", news);
				return "details_news";
			}
		}
		PrintWriter pw = resp.getWriter();
		pw.print("<script>");
		pw.print("alert('未找到该资讯！');");
		pw.print("location.href='toNewsJsp';");
		pw.print("</script>");
		return null;
	}

	// 资讯通过
	@RequestMapping("/permitNews")
	public String permitNews(Integer nID, String uOpinion, HttpSession session, HttpServletResponse resp)
			throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		if (uOpinion.equals("")) {
			uOpinion = "未填写意见";
		}
		Admin admin = (Admin) session.getAttribute("admin");
		Integer result = newsService.permitNews(admin.getAdminID(), nID, uOpinion);
		if (result != null && result == 2) {
			return "jump_prompt";
		}
		pw.print("<script>");
		pw.print("alert('操作失败！！');");
		pw.print("location.href='News/getNewsById?nID=" + nID + "';");
		pw.print("</script>");
		return null;
	}

	// 资讯不通过
	@RequestMapping("/notPermitNews")
	public String notPermitNews(Integer nID, String uOpinion, HttpSession session, HttpServletResponse resp)
			throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		if (uOpinion.equals("")) {
			pw.print("<script>");
			pw.print("alert('意见不允许为空');");
			// pw.print("location.href='News/getNewsById?nID="+nID+"';");
			pw.print("</script>");
			return null;
		}
		Admin admin = (Admin) session.getAttribute("admin");
		Integer result = newsService.notPermitNews(admin.getAdminID(), nID, uOpinion);
		if (result != null && result == 2) {
			return "jump_prompt";

		}
		pw.print("<script>");
		pw.print("alert('操作失败！！');");
		pw.print("location.href='News/getNewsById?nID=" + nID + "';");
		pw.print("</script>");
		return null;
	}

	// 查询所有已通过的资讯
	@RequestMapping("/getAllCheckedNews")
	@ResponseBody
	public Object[] getAllCheckedNews(Integer pageNum, Integer maxPage) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 10);

		List<News> checkNewsList = newsService.getAllCheckedNews();
		PageInfo<News> checkNewsPageInfo = new PageInfo<>(checkNewsList);
		Object[] object = { checkNewsList, checkNewsPageInfo };
		return object;
	}

	@RequestMapping("toShowNewsList")
	public String toShowNewsList() {
		return "showNewsList";
	}
    //查询选中的资讯
	@RequestMapping("/getCheckedNewsById")
	public String getCheckedNewsById(String nID, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 对传入的nID判断，避免地址栏拼参导致后台出错，只能是数字
		Pattern pattern = Pattern.compile("^[0-9]*$");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if (pattern.matcher(nID).matches()) {
			News news = newsService.getNewsById(Integer.parseInt(nID));
			if (news != null && news.getnID() > 0) {
				// 将标题以及正文中自带的换/n/r进行转义，避免前台解析时出错
				news.setnTheme(news.getnTheme().replaceAll("\r\n", "</br>&nbsp;&nbsp;"));
				news.setnContent(news.getnContent().replaceAll("\r\n", "</br>&nbsp;&nbsp;"));
				req.setAttribute("news", news);
				return "detail_CheckedNews";
			}
		}
		PrintWriter pw = resp.getWriter();
		pw.print("<script>");
		pw.print("alert('未找到该资讯！');");
		pw.print("location.href='toShowNewsList';");
		pw.print("</script>");
		return null;
	}

	@RequestMapping("/toCheckedNewsJsp")
	public String toCheckedNewsJsp(HttpServletRequest req) {
		return "showNewsList";
	}

	// 添加新的资讯
	@RequestMapping("/addNews")
	@ResponseBody
	public String addNews(String nTheme, String nContent, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (newsService.addNews(admin.getAdminID(), nTheme, nContent) == 1) {
			return "success";
		}
		return "fail";

	}

	// 查询审核未通过的资讯
	@RequestMapping("/getAllNoCheckedNews")
	@ResponseBody
	public Object[] getAllNoCheckedNews(Integer pageNum, Integer maxPage) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		PageHelper.startPage(pageNum, 15);

		List<News> noCheckNewsList = newsService.getAllNoCheckedNews();
		PageInfo<News> noCheckNewsPageInfo = new PageInfo<>(noCheckNewsList);
		Object[] object = { noCheckNewsList, noCheckNewsPageInfo };
		return object;
	}

	// 跳到审核未通过列表
	@RequestMapping("toShowNoNewsList")
	public String toShowNoNewsList() {
		return "noPassCheckNewsList";
	}

	// 资讯未通过原因
	@RequestMapping("/getOpinion")
	public String getOpinion(String nID, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 对传入的nID判断，避免地址栏拼参导致后台出错，只能是数字
		Pattern pattern = Pattern.compile("^[0-9]*$");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if (pattern.matcher(nID).matches()) {
			News news = newsService.getNewsById(Integer.parseInt(nID));
			Opinion opinion = newsService.getOpinion(Integer.parseInt(nID));

			if (news != null && news.getnID() > 0) {
				// 将标题以及正文中自带的换/n/r进行转义，避免前台解析时出错
				news.setnTheme(news.getnTheme().replaceAll("\r\n", "</br>&nbsp;&nbsp;"));
				news.setnContent(news.getnContent().replaceAll("\r\n", "</br>&nbsp;&nbsp;"));
				opinion.setuOpinion(opinion.getuOpinion().replaceAll("\r\n", "</br>&nbsp;&nbsp;"));
				req.setAttribute("news", news);
				req.setAttribute("opinion", opinion);
				return "detail_NoCheckedNews";
			}
		}
		PrintWriter pw = resp.getWriter();
		pw.print("<script>");
		pw.print("alert('未找到该资讯！');");
		pw.print("location.href='toShowNewsList';");
		pw.print("</script>");
		return null;
	}

}
