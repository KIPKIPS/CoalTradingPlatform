package com.isscollege.order.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.impl.PurchInfoServiceImpl;
import com.isscollege.listing.service.impl.SellerInfoServiceImpl;
import com.isscollege.order.entity.Transaction;
import com.isscollege.order.service.impl.ReceiptServiceImpl;

@Controller
@RequestMapping("order")
public class ReceiptController {

	@Autowired
	private ReceiptServiceImpl receiptServiceImpl;

	@Autowired
	private SellerInfoServiceImpl sellerInfoServiceImpl;

	@Autowired
	private PurchInfoServiceImpl purchInfoServiceImpl;

	// 上传回执单
	@RequestMapping("uploadBankReceipt")
	@ResponseBody
	public String uploadBankReceipt(String orderNo, MultipartFile file, HttpSession session) throws IOException {
		System.out.println(orderNo);
		String realPath = session.getServletContext().getRealPath(""); // 获得session所在位置
		realPath = realPath.replace("main\\webapp", "bankreceipt");// 将realPath中的替换为新的地址
		System.out.println("upLoad文件夹的位置为:" + realPath);
		// System.out.println(file.getContentType().toString());
		String type = file.getContentType();
		System.out.println(type);
		String tradeNo = receiptServiceImpl.getTradeNo(orderNo);
		System.out.println(tradeNo);
		if (!type.equals("image/jpeg") && !type.equals("image/jpg"))
			return "<script>alert('只能上传jpg格式文件') \n history.back()</script>";

		if (!file.isEmpty() && file.getSize() > 0) {
			System.out.println("上传了");
			// 创建文件夹以orderNo命名
			File dest = new File(realPath + "/" + tradeNo);
			dest.mkdirs();
			// 得到所创建的文件夹的地址
			String path = dest.getPath();
			// 重命名并上传的对应文件夹
			file.transferTo(new File(path + "/" + "bankreceipt.jpg"));
			// 重新定义存储在数据库中的回执单的相对路径
			String newPath = tradeNo + "/" + "bankreceipt.jpg";
			System.out.println(newPath);
			// 更改数据库中的回执单路径信息和回执单状态
			int m = receiptServiceImpl.modifyOrderStateAndReceiptSrc(newPath, tradeNo);
			System.out.println(m);
		}
		return "上传回执单成功";
	}

	// 下载回执单
	@RequestMapping("/downloadReceipt")
	@ResponseBody
	public String downloadReceipt(String tradeNo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {

		// 查询回执单是否上传
		Transaction transaction = receiptServiceImpl.getTransactionByTradeNo(tradeNo);

		if (transaction != null) {

			// 订单如果不为空 查看订单回执单状态
			if (transaction.getReceiptState().equals("0")) {
				// 回执单未上传
				return "<script>alert('回执单未上传') \n history.back()</script>";
			} else {

				// 执行回执单下载
				String fileName = transaction.getReceipt();
				String realPath = session.getServletContext().getRealPath("");
				realPath = realPath.replace("main\\webapp", "bankreceipt");// 将realPath中的替换为新的地址
				File file = new File(realPath + "/" + fileName);
				// System.out.println("file:" + file.getPath());

				// 如果文件存在
				if (file.exists()) {
					// 配置文件下载
					response.setHeader("content-type", "application/octet-stream");
					response.setContentType("application/octet-stream");

					// 下载文件能正常显示中文
					String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");

					response.setHeader("Content-disposition", "attachment;filename=" + downloadFileName);

					// System.out.println("downfilename " + downloadFileName);
					// 文件下载
					byte[] buffer = new byte[1024];
					FileInputStream fis = null;
					BufferedInputStream bis = null;

					try {
						fis = new FileInputStream(file);
						bis = new BufferedInputStream(fis);
						OutputStream os = response.getOutputStream();
						int i = bis.read(buffer);
						while (i != -1) {
							os.write(buffer, 0, i);
							i = bis.read(buffer);
						}
					} catch (Exception e) {
						System.out.println("Download failed!");
					} finally {
						if (bis != null) {
							try {
								bis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}

				return "";

			}

		} else {
			// 前端传回traderNo 错误

			return "<script>alert('前端传回traderNo 错误') \n history.back()</script>";
		}
	}

	// 通过TraderNo 修改回执单为已确认状态
	@ResponseBody
	@RequestMapping("/modifyReceiptStateByTradeNo")
	public String modifyReceiptStateByTradeNo(String tradeNo) {
		// 通过tradeNo查询订单
		Transaction transaction = receiptServiceImpl.getTransactionByTradeNo(tradeNo);
		if (transaction == null) {
			return "<script>alert('订单不存在？？？ ') \n history.back()</script>";
		}

		// 根据回执单状态 执行相应动作
		switch (transaction.getReceiptState()) {
		case "0":
			return "<script>alert('回执单未上传 ！！！请等待上传后再进行确认操作') \n history.back()</script>";

		case "1":
			receiptServiceImpl.modifyReceiptStateByTradeNo(tradeNo, "2");
			return "<script>alert('确认成功') \n history.back()</script>";
		case "2":
			return "<script>alert('回执单已确认成功') \n history.back()</script>";
		}
		return "<script>alert('数据库回执单状态非法！！！') \n history.back()</script>";
	}

	@RequestMapping("/test")
	public String test(HttpServletRequest req) {

		return "test";

	}

	@RequestMapping("/testwrzh")
	public String testwrzh(HttpServletRequest req) {

		return "purch_delisting_back";

	}

	@RequestMapping("/testwrzh2")
	public String testwrzh2(HttpServletRequest req) {

		return "seller_delisting_back";

	}

	// 完善信息 卖方挂牌 卖方提交信息 (交易方式 物流商)
	@RequestMapping("/completeInfoSellorListingSellorCommit")
	@ResponseBody
	public String completeInfoSellorListingSellorCommit(String tradeNo, String exchangeMeans, String logisticsbus) {
		System.out.println("完善信息" + tradeNo);
		int listNo = receiptServiceImpl.getListNoByTradeNo(tradeNo);
		System.out.println("完善交易方式 物流商信息" + listNo);
		if (listNo > 0) {
			// 获取到listNo 组装好Seller_info
			Seller_Info seller_info = new Seller_Info(listNo, exchangeMeans, logisticsbus);
			// 完善信息
			int num = sellerInfoServiceImpl.modifySellerInfoEML(seller_info);
			if (receiptServiceImpl.get_sellerInfo_waybill(tradeNo).getDeliveryPlace() != "西安"
					&& receiptServiceImpl.get_sellerInfo_waybill(tradeNo).getExchangeMeans() != "线下交易"
					&& receiptServiceImpl.get_sellerInfo_waybill(tradeNo).getLogisticsbus() != "邮政")
				receiptServiceImpl.modifyOrderState(tradeNo);
			if (num > 0) {
				// 查询数据

				String good_source = receiptServiceImpl.getSellerByTradeNo(tradeNo).getsDeliverPlace();
				String good_destination = receiptServiceImpl.getSellerByTradeNo(tradeNo).getDeliverPlace();
				double log_weight = receiptServiceImpl.getSellerByTradeNo(tradeNo).getsCount();
				// 完善成功
				return "<script>alert('完善成功') \n location.href='http://10.61.88.30:8082/logistics_system/waybill/insertWaybillInfo?lod_name="
						+ logisticsbus + "&trade_id=" + tradeNo + "&good_source=" + good_source + "&good_destination="
						+ good_destination + "&log_weight=" + log_weight + "'</script>";
			}
			return "<script>alert('完善失败') \n history.back()</script>";
		}
		return "<script>alert('挂牌号不正确') \n history.back()</script>";
	}

	// 完善信息 卖方挂牌 买方提交信息 (到货地)
	@RequestMapping("/completeInfoSellorListingPurchCommit")
	@ResponseBody
	public String completeInfoSellorListingPurchCommit(String tradeNo, String deliveryPlace) {
		int listNo = receiptServiceImpl.getListNoByTradeNo(tradeNo);
		System.out.println("完善到货地 信息:  " + listNo);
		if (listNo > 0) {
			// 获取到listNo
			// 完善信息
			int num = sellerInfoServiceImpl.modifySellerInfoDeliveryPlace(listNo, deliveryPlace);
			if (receiptServiceImpl.get_sellerInfo_waybill(tradeNo).getDeliveryPlace() != "西安"
					&& receiptServiceImpl.get_sellerInfo_waybill(tradeNo).getExchangeMeans() != "线下交易"
					&& receiptServiceImpl.get_sellerInfo_waybill(tradeNo).getLogisticsbus() != "邮政")
				receiptServiceImpl.modifyOrderState(tradeNo);
			if (num > 0) {
				// 完善成功
				return "<script>alert('完善成功') \n history.back()</script>";
			}
			return "<script>alert('完善失败') \n history.back()</script>";
		}
		return "<script>alert('挂牌号不正确') \n history.back()</script>";
	}

	// 完善信息 买方挂牌 卖方提交信息 (到后地)
	@RequestMapping("/completeInfoPurchListingSellerCommit")
	@ResponseBody
	public String completeInfoPurchListingSellerCommit(String tradeNo, String exchangeMeans, String logisticsbus,
			String sPlace) {
		int listNo = receiptServiceImpl.getListNoByTradeNo(tradeNo);
		System.out.println("完善到货地 信息:  " + listNo);
		if (listNo > 0) {
			// 获取到listNo
			// 完善信息
			int num = purchInfoServiceImpl.modifyPurch_infoEMLD(listNo, exchangeMeans, logisticsbus, sPlace);
			if (receiptServiceImpl.get_purchInfo_waybill(tradeNo).getsPlace() != "山西"
					&& receiptServiceImpl.get_purchInfo_waybill(tradeNo).getExchangeMeans() != "线下交易"
					&& receiptServiceImpl.get_purchInfo_waybill(tradeNo).getLogisticsbus() != "邮政") {
				receiptServiceImpl.modifyOrderState(tradeNo);
				System.out.println("进入成功");
			}

			if (num > 0) {
				// 完善成功
				String good_source = receiptServiceImpl.getPurchbyTradeNo(tradeNo).getsPlace();
				String good_destination = receiptServiceImpl.getPurchbyTradeNo(tradeNo).getpDeliverPlace();
				Double log_weight = receiptServiceImpl.getPurchbyTradeNo(tradeNo).getpCount();
				// 向物流表发送数据
				System.out.println("信息1" + good_source + "信息2" + good_destination + "信息3" + log_weight);
				return "<script>alert('完善成功') \n location.href='http://10.61.88.30:8082/logistics_system/waybill/insertWaybillInfo?lod_name="
						+ logisticsbus + "&trade_id=" + tradeNo + "&good_source=" + good_source + "&good_destination="
						+ good_destination + "&log_weight=" + log_weight + "'</script>";
				// return "<script>alert('完善成功') \n history.back()</script>";
			}
			return "<script>alert('完善失败') \n history.back()</script>";
		}
		return "<script>alert('挂牌号不正确') \n history.back()</script>";
	}

	// 跳转填写信息页面
	@RequestMapping("/tradefinal")

	public String tradefinal(HttpServletRequest request, String tradeNo, String traderControl)
			throws JsonProcessingException {
		request.setAttribute("traderControl", traderControl);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr;
		jsonStr = objectMapper.writeValueAsString(tradeNo);

		request.setAttribute("tradeNo", tradeNo);

		System.out.println(traderControl);
		return "trade_final_info";
	}

	// 跳转到卖家处理后续
	@RequestMapping("/sellerback")
	public String sellerback(HttpServletRequest request, String tradeNo, String orderNo, String traderControl)
			throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr;
		jsonStr = objectMapper.writeValueAsString(tradeNo);
		request.setAttribute("traderControl", traderControl);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("tradeNo", jsonStr);

		System.out.println("6666traderNo" + tradeNo);
		return "seller_delisting_back";
	}

	// 跳转到买家处理后续
	@RequestMapping("/purchback")
	public String purchback(HttpServletRequest request, String tradeNo, String orderNo, String traderControl)
			throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr;
		jsonStr = objectMapper.writeValueAsString(tradeNo);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("tradeNo", jsonStr);
		request.setAttribute("traderControl", traderControl);
		System.out.println("6666traderNo" + tradeNo);
		return "purch_delisting_back";
	}

	// 调用物流controller
	@ResponseBody
	@RequestMapping("/testwrzh3")
	public String testwrzh(String tradeNo, String orderNo) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		list1 = receiptServiceImpl.getSellertradeNoByuID(1);
		list2 = receiptServiceImpl.getPurchtradeNoByuID(1);
		list3 = receiptServiceImpl.getListNoByuID(1);
		System.out.println("111sk" + list1);
		System.out.println("222sk");
		System.out.println("222sk" + list2);

		System.out.println("333sk" + list3);
		list1.addAll(list2);
		list1.addAll(list3);
		System.out.println("sk" + list1);
		System.out.println("长度" + list1.size());
		return "<script>location.href='http://10.61.88.30:8082/admin/'</script>";
	}
}
