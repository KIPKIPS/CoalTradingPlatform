package com.isscollege.users.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.service.impl.TraderServiceImpl;

@Controller
@RequestMapping("file")
public class CompanyInfoUploadController {
	@Autowired
	TraderServiceImpl traderServiceImpl;

	// private static final Logger LOG
	// =Logger.getLogger(CompanyInfoUploadControllerTest.class);

	@RequestMapping("/modifyHeader")
	@ResponseBody
	public String modifyHeader(HttpSession session, HttpServletRequest request,
			@RequestParam("cBusinessLicense") MultipartFile mfile) throws Exception {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		// 获取用户名
		String uName = trader.getuName();
		// String uName = "税务登记证";
		// 构造上传文件全路径，并创建
		String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		realPath = realPath.replace("target/classes", "src/main/resources/static/companyInfo/" + uName);
		System.out.println(realPath);
		new File(realPath).mkdirs();
		// 构建上传文件保存名字
		String rename = trader.getuName() + "_cBusinessLicense" + ".jpg";

		String target = realPath + "/" + rename;
		// 保存文件
		mfile.transferTo(new File(target));
		// 往数据库存放文件名
		traderServiceImpl.fileModify("cBusinessLicense", rename, trader.getuID());
		// 返回文件名
		return realPath + "\\" + rename;
	}

	@RequestMapping("/modifyHeader2")
	@ResponseBody
	public String modifyHeader2(HttpSession session, HttpServletRequest request,
			@RequestParam("cTax") MultipartFile mfile) throws Exception {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		// 获取用户名
		String uName = trader.getuName();
		// String uName = "税务登记证";
		// 构造上传文件全路径，并创建
		String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		realPath = realPath.replace("target/classes", "src/main/resources/static/companyInfo/" + uName);
		System.out.println(realPath);
		new File(realPath).mkdirs();
		// 构建上传文件保存名字
		String rename = trader.getuName() + "_cTax" + ".jpg";

		String target = realPath + "/" + rename;
		// 保存文件
		mfile.transferTo(new File(target));
		// 往数据库存放文件名
		traderServiceImpl.fileModify("cTax", rename, trader.getuID());
		// 返回文件名
		return realPath + "\\" + rename;
	}

	@RequestMapping("/modifyHeader3")
	@ResponseBody
	public String modifyHeader3(HttpSession session, HttpServletRequest request,
			@RequestParam("cOrg") MultipartFile mfile) throws Exception {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		// 获取用户名
		String uName = trader.getuName();
		// String uName = "组织机构代码证";
		// 构造上传文件全路径，并创建
		String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		realPath = realPath.replace("target/classes", "src/main/resources/static/companyInfo/" + uName);
		System.out.println(realPath);
		new File(realPath).mkdirs();
		// 构建上传文件保存名字
		String rename = trader.getuName() + "_cOrg" + ".jpg";
		String target = realPath + "/" + rename;
		// 保存文件
		mfile.transferTo(new File(target));
		// 往数据库存放文件名
		traderServiceImpl.fileModify("cOrg", rename, trader.getuID());
		// 返回文件名
		return realPath + "\\" + rename;
	}

	@RequestMapping("/modifyHeader4")
	@ResponseBody
	public String modifyHeader4(HttpSession session, HttpServletRequest request,
			@RequestParam("cBank") MultipartFile mfile) throws Exception {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		// 获取用户名
		String uName = trader.getuName();
		// String uName = "企业开户许可证";
		// 构造上传文件全路径，并创建
		String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		realPath = realPath.replace("target/classes", "src/main/resources/static/companyInfo/" + uName);
		System.out.println(realPath);
		new File(realPath).mkdirs();
		// 构建上传文件保存名字
		String rename = trader.getuName() + "_cBank" + ".jpg";
		String target = realPath + "/" + rename;
		// 保存文件
		mfile.transferTo(new File(target));
		// 往数据库存放文件名
		traderServiceImpl.fileModify("cBank", rename, trader.getuID());
		// 返回文件名
		return realPath + "\\" + rename;
	}

	@RequestMapping("/modifyHeader5")
	@ResponseBody
	public String modifyHeader5(HttpSession session, HttpServletRequest request,
			@RequestParam("cPermission") MultipartFile mfile) throws Exception {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		// 获取用户名
		// String uName = ((Login_Info)
		// (session.getAttribute("trader"))).getuName().trim();
		String uName = trader.getuName();
		// String uName = "煤炭经营许可证";
		// 构造上传文件全路径，并创建
		String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		realPath = realPath.replace("target/classes", "src/main/resources/static/companyInfo/" + uName);
		System.out.println(realPath);
		new File(realPath).mkdirs();
		// 构建上传文件保存名字
		String rename = trader.getuName() + "_cPermission" + ".jpg";
		String target = realPath + "/" + rename;
		// 保存文件
		mfile.transferTo(new File(target));
		// 往数据库存放文件名
		traderServiceImpl.fileModify("cPermission", rename, trader.getuID());
		// 返回文件名
		return realPath + "\\" + rename;
	}

	@RequestMapping("/modifyHeader6")
	@ResponseBody
	public String modifyHeader6(HttpSession session, HttpServletRequest request,
			@RequestParam("cLegalPerson") MultipartFile mfile) throws Exception {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		// 获取用户名
		String uName = trader.getuName();
		// String uName = "法人身份证";
		// 构造上传文件全路径，并创建
		String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		realPath = realPath.replace("target/classes", "src/main/resources/static/companyInfo/" + uName);
		System.out.println(realPath);
		new File(realPath).mkdirs();
		// 构建上传文件保存名字
		String rename = trader.getuName() + "_cLegalPerson" + ".jpg";
		String target = realPath + "/" + rename;
		// 保存文件
		mfile.transferTo(new File(target));
		// 往数据库存放文件名
		traderServiceImpl.fileModify("cLegalPerson", rename, trader.getuID());
		// 返回文件名
		return realPath + "\\" + rename;
	}
}