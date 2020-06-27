package com.isscollege.users.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.users.entity.Uncheck_regist;
import com.isscollege.users.service.impl.Show_uncheckregist_serviceimpl;

@Controller
@RequestMapping("registcheck")
public class Registcheck_Controller {
	@Autowired
	Show_uncheckregist_serviceimpl impl;

	// 页面列表展示提交申请但未通过审核的所有用户
	@RequestMapping("/showlist")
	public String ShowList(HttpServletRequest req) throws Exception {
		PageHelper.startPage(1, 10);
		List<Uncheck_regist> rList = impl.show();
		PageInfo<Uncheck_regist> pageInfo = new PageInfo<Uncheck_regist>(rList);
		req.setAttribute("rList", rList);
		req.setAttribute("pageInfo", pageInfo);
		return "regist_check_list";
	}

	// 展示单个提交但未通过审核的用户的详细信息
	@RequestMapping("/showone")
	public String ShowOne(HttpServletRequest req, @RequestParam("uID") int uid) throws Exception {
		Uncheck_regist ur = impl.ShowOne(uid);
		req.setAttribute("ur", ur);
		return "regist_check";
	}

	// 使该用户通过审核
	@RequestMapping("/pass")
	public String pass(HttpServletRequest req, @RequestParam("uID") int uid) throws Exception {
		impl.pass(uid);
		return "redirect:/registcheck/showlist";
	}

	// 分页
	@RequestMapping("/page")
	public String page(Integer pageNum, Integer maxPage, HttpServletRequest req) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}

		PageHelper.startPage(pageNum, 10);
		List<Uncheck_regist> rList = impl.show();
		PageInfo<Uncheck_regist> pageInfo = new PageInfo<Uncheck_regist>(rList);
		req.setAttribute("rList", rList);
		req.setAttribute("pageInfo", pageInfo);
		return "regist_check_list";

	}

	// 使该用户不通过审核
	@RequestMapping("/nopass")
	public String NoPass(HttpServletRequest req, HttpServletResponse response, @RequestParam("uID") int uid,
			@RequestParam("uopinion") String uopinion) throws Exception {
		// System.out.println(impl.nopass(uid, uopinion));
		if (uopinion.equals("")) {
			response.setContentType("text/html; charset=UTF-8"); // 转码
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('审核意见不能为空');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			impl.NoPass(uid, uopinion);
		}
		return "redirect:/registcheck/showlist";
	}

	// 文件下载
	@RequestMapping("/download")
	public String downLoad(HttpServletResponse response, @RequestParam String item, @RequestParam String cName,
			@RequestParam int uID) throws IOException {
		String filePath = "src/main/resources/static/companyInfo/";
		String fileName = "";
		switch (item) {
		case "cBusinessLicense":
			fileName = impl.show_uncheck_user_file_cBusinessLicense(uID);
			break;

		case "cTax":
			fileName = impl.show_uncheck_user_file_cTax(uID);
			break;

		case "cOrg":
			fileName = impl.show_uncheck_user_file_cOrg(uID);
			break;

		case "cBank":
			fileName = impl.show_uncheck_user_file_cBank(uID);
			break;

		case "cLegalPerson":
			fileName = impl.show_uncheck_user_file_cLegalPerson(uID);
			break;

		case "cPermission":
			fileName = impl.show_uncheck_user_file_cPermission(uID);
			break;
		}
		fileName = fileName + ".jpg";
		String uname = impl.selectuname(uID);
		File file = new File(filePath + uname + "/" + fileName);
		if (file.exists()) { // 判断文件父目录是否存在
			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

			byte[] buffer = new byte[1024];
			FileInputStream fis = null; // 文件输入流
			BufferedInputStream bis = null;

			OutputStream os = null; // 输出流
			try {
				os = response.getOutputStream();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer);
					i = bis.read(buffer);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (bis != null) {
					bis.close();
				}
				if (fis != null) {
					fis.close();
				}
			}

			System.out.println("----------file download" + fileName);
		} else {
			response.setContentType("text/html; charset=UTF-8"); // 转码
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('文件不存在');");
			out.println("history.back();");
			out.println("</script>");
		}
		return null;
	}
}
