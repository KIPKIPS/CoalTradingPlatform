package com.isscollege.contract.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.contract.entity.Contract;
import com.isscollege.contract.entity.ContractList;
import com.isscollege.contract.service.impl.GetContractImpl;
import com.isscollege.listing.service.impl.PurchInfoServiceImpl;
import com.isscollege.listing.service.impl.SellerInfoServiceImpl;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.utils.GetNumber;

@Controller
@RequestMapping("contract")
public class ContractController {

	@Autowired
	private GetContractImpl getContractImpl;

	@Autowired
	SellerInfoServiceImpl sellerInfoService;

	@Autowired
	PurchInfoServiceImpl purchInfoServiceImpl;

	// 显示未确认的合同页面
	@RequestMapping("/contractShowUnsignedPage")
	public String ShowContract(HttpSession session, HttpServletRequest req) {
		PageHelper.startPage(1, 9);
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		List<ContractList> unsignedContractList = getContractImpl.getUnsignedContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(unsignedContractList);
		session.setAttribute("unsignedContractList", unsignedContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowUnsignedPage";
	}

	// 未确认合同--翻页
	@RequestMapping("/unsignedPage")
	public String unsignedPage(Integer pageNum, Integer maxPage, HttpServletRequest req, HttpSession session) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		PageHelper.startPage(pageNum, 9);
		List<ContractList> unsignedContractList = getContractImpl.getUnsignedContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(unsignedContractList);
		session.setAttribute("unsignedContractList", unsignedContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowUnsignedPage";

	}

	// 上传合同
	@RequestMapping("/contractUpload")
	public String contractUpload(MultipartFile file, HttpSession session, String tradeNo, HttpServletRequest req)
			throws IOException {

		req.setAttribute("tradeNo", tradeNo);
		System.out.println("upLoad...");
		System.out.println("原始文件类型为：" + file.getContentType());
		String realPath = session.getServletContext().getRealPath("contract");
		System.out.println("upLoad文件夹的位置为：" + realPath);
		String contract = file.getOriginalFilename();
		getContractImpl.modifyContractStateInto01(tradeNo, contract);
		if (!file.isEmpty() && file.getSize() > 0) {
			file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
		}
		// 成功则返回查看未确认合同页面
		return "showContractList";
	}

	// 确认合同
	@RequestMapping("/contractConfirm")
	public String contractConfirm(HttpSession session, HttpServletRequest req, String tradeNo) {
		req.setAttribute("tradeNo", tradeNo);
		//System.out.println("订单编号：" + tradeNo);
		getContractImpl.modifyContractStateInto11(tradeNo);
		Contract contract = getContractImpl.getContractDetails(tradeNo);
		String contractState = getContractImpl.queryContractState(tradeNo);
		req.setAttribute("tradeNo", tradeNo);
		req.setAttribute("contractState", contractState);
		req.setAttribute("contract", contract);
		return "contractDetails";
	}

	// 显示尚未上传合同的交易
	@RequestMapping("/contractShowUnupdatePage")
	public String contractShowUnupdatePage(HttpSession session, HttpServletRequest req) {
		PageHelper.startPage(1, 9);
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		List<ContractList> unupdateContractList = getContractImpl.getUnupdateContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(unupdateContractList);
		session.setAttribute("unupdateContractList", unupdateContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowUnupdatePage";
	}

	// 未上传合同--翻页
	@RequestMapping("/unupdatePage")
	public String unupdatePage(Integer pageNum, Integer maxPage, HttpServletRequest req, HttpSession session) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		PageHelper.startPage(pageNum, 9);
		List<ContractList> unupdateContractList = getContractImpl.getUnupdateContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(unupdateContractList);
		session.setAttribute("unupdateContractList", unupdateContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowUnupdatePage";
	}

	@RequestMapping("/contractCenter")
	public String contractCenter() {
		return "contractCenter";
	}

	// purch方摘牌成功
	@RequestMapping("/contractPurchSuccess")
	public String contractPurchSuccess(HttpSession session) {
		// 交付成功-->创建默认合同（状态00 tradeNo自动生成，listNo从session获取,purch中source=2）
		int delistNo = (int) session.getAttribute("delistNo");
		int listNo = (int) session.getAttribute("listNo");
		String pNumber = (String) session.getAttribute("pNumber");
		String tradeNo = GetNumber.getNumber(Integer.toString(delistNo));
		String source = "2";
		purchInfoServiceImpl.modifyPState(pNumber);
		// req.setAttribute("delistNo", delistNo);
		// req.setAttribute("listNo", listNo);
		// req.setAttribute("source", source);
		getContractImpl.addContract(tradeNo, delistNo, listNo, source);
		// 成功则返回合同管理页面
		return "showContractList";
	}

	// sell方摘牌成功
	@RequestMapping("/contractSellSuccess")
	public String contractSellSuccess(HttpSession session) {
		// 交付成功-->创建默认合同（状态00 tradeNo自动生成，listNo从session获取,sell中source=1）
		int delistNo = (int) session.getAttribute("delistNo");
		int listNo = (int) session.getAttribute("listNo");
		String tradeNo = GetNumber.getNumber(Integer.toString(delistNo));
		String sNumber = (String) session.getAttribute("sNumber");
		// 交纳成功，改变挂牌信息表状态
		sellerInfoService.modifySState(sNumber);
		// Sell成功 source=1
		String source = "1";
		// req.setAttribute("delistNo", delistNo);
		// req.setAttribute("listNo", listNo);
		// req.setAttribute("source", source);
		getContractImpl.addContract(tradeNo, delistNo, listNo, source);

		return "showContractList";
	}

	// 创建合同的页面
	@RequestMapping("/contractCreatePage")
	public String contractCreatePage(HttpSession session, HttpServletRequest req, String tradeNo) {
		String unuploadtradeNo = tradeNo;
		req.setAttribute("unuploadtradeNo", unuploadtradeNo);
		System.out.println(unuploadtradeNo);
		return "contractCreatePage";
	}

	@RequestMapping("/contractIndex")
	public String contractIndex() {
		return "contractIndex";
	}

	@RequestMapping("/contractShowBothSignedPage")
	// 获取双方都已签订的合同
	public String contractShowBothSignedPage(HttpSession session, HttpServletRequest req) {
		PageHelper.startPage(1, 9);
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		List<ContractList> bothSignedContractList = getContractImpl.getAllSignedContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(bothSignedContractList);
		session.setAttribute("bothSignedContractList", bothSignedContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowBothSignedPage";
	}

	// 双方都已签订合同---翻页
	@RequestMapping("/bothSignedPage")
	public String bothSignedPage(Integer pageNum, Integer maxPage, HttpServletRequest req, HttpSession session) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		PageHelper.startPage(pageNum, 9);
		List<ContractList> bothSignedContractList = getContractImpl.getAllSignedContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(bothSignedContractList);
		session.setAttribute("bothSignedContractList", bothSignedContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowBothSignedPage";

	}

	@RequestMapping("/contractShowSignedPage")
	// 获取自己已签订、等待对方确认的合同
	public String contractShowSignedPage(HttpSession session, HttpServletRequest req) {
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		PageHelper.startPage(1, 9);
		List<ContractList> signedContractList = getContractImpl.getSignedContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(signedContractList);
		session.setAttribute("signedContractList", signedContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowSignedPage";
	}

	// 挂牌方已确认合同---翻页
	@RequestMapping("/signedPage")
	public String signedPage(Integer pageNum, Integer maxPage, HttpServletRequest req, HttpSession session) {
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= maxPage) {
			pageNum = maxPage;
		}
		Login_Info trader = (Login_Info) session.getAttribute("trader");// 从session中获取该用户的uid？
		int uID = trader.getuID();
		PageHelper.startPage(pageNum, 9);
		List<ContractList> signedContractList = getContractImpl.getSignedContract(uID);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(signedContractList);
		session.setAttribute("signedContractList", signedContractList);
		req.setAttribute("pageInfo", pageInfo);
		return "contractShowSignedPage";
	}

	// 显示合同内容
	@RequestMapping("/shows")
	public String getContractDetails(String tradeNo, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// System.out.println("查找到的合同编号" + tradeNo);
		//
		Contract contract = getContractImpl.getContractDetails(tradeNo);
		//
		// System.out.println("合同内容" + contract);

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// 先查询合同状态
		String contractState = getContractImpl.queryContractState(tradeNo);
		System.out.println(tradeNo);
		if (contractState.equals("00")) {
			out.print("<script>");
			out.print("alert('合同尚未上传');");
			out.print("</script>");
			return null;

		} else {
			req.setAttribute("tradeNo", tradeNo);
			req.setAttribute("contractState", contractState);
			req.setAttribute("contract", contract);
			return "contractDetails";
		}
	}

	// 用户取消后删除合同全部内容
	@RequestMapping("/remove")
	public String removeContract(String tradeNo, HttpServletRequest req) {
		System.out.println("要删除的合同编号" + tradeNo);
		getContractImpl.removeAllContract(tradeNo);

		return "showContractList";

	}

	/*
	 * 查看合同列表
	 */
	@RequestMapping("/showContractList")
	@ResponseBody
	public Object[] showContractList(Integer pageNum, Integer pages, String orderClass, String orderSource,
			String orderState, HttpSession session, HttpServletRequest req) {
		Login_Info trader = (Login_Info) session.getAttribute("trader");
		if (pageNum <= 1) {
			pageNum = 1;
		} else if (pageNum >= pages) {
			pageNum = pages;
		}
		PageHelper.startPage(pageNum, 15);// 通过拦截最近的一条sql语句进行分页，对于直接插数据建立的list不会分页
		List<ContractList> orderList = getContractImpl.queryContractList(trader, orderClass, orderSource, orderState);
		PageInfo<ContractList> pageInfo = new PageInfo<ContractList>(orderList);
		Object[] object = { pageInfo, orderList };
		return object;
	}

}
