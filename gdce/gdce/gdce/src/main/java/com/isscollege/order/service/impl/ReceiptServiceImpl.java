package com.isscollege.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.order.dao.ReceiptDao;
import com.isscollege.order.entity.PurchWaybill;
import com.isscollege.order.entity.SellerWaybill;
import com.isscollege.order.entity.Transaction;
import com.isscollege.order.service.IReceiptService;

@Service

public class ReceiptServiceImpl implements IReceiptService {
	@Autowired
	private ReceiptDao receiptDao;

	// 测试用构造方法
	public ReceiptServiceImpl(ReceiptDao receiptDao2) {
		receiptDao = receiptDao2;
	}

	// 通过orderNo来查询得到traderNo
	@Override
	public String getTradeNo(String orderNo) {

		return receiptDao.getTradeNo(orderNo);
	}

	// 通过tradeNo 修改回执单状态为待收货状态并将回执单路径存入进去
	@Override
	public int modifyOrderStateAndReceiptSrc(String path, String tradeNo) {

		return receiptDao.modifyOrderStateAndReceiptSrc(path, tradeNo);
	}

	// 通过tradeNo 修改订单状态为待收货状态
	@Override
	public int modifyOrderState(String tradeNo) {

		return receiptDao.modifyOrderState(tradeNo);
	}

	// 通过tradeNo 将回执单路径存入进去
	@Override
	public int modifyOrderReceiptSrc(String path, String tradeNo) {

		return receiptDao.modifyOrderReceiptSrc(path, tradeNo);
	}

	// 通过TraderNo 获取回执单路径
	@Override
	public Transaction getTransactionByTradeNo(String tradeNo) {
		return receiptDao.getTransactionByTradeNo(tradeNo);
	}

	// 通过TraderNo 修改回执单为已确认状态
	@Override
	public int modifyReceiptStateByTradeNo(String tradeNo, String state) {
		return receiptDao.modifyReceiptStateByTradeNo(tradeNo, state);
	}

	// 根据TradeNo 获得listNo
	@Override
	public int getListNoByTradeNo(String tradeNo) {
		System.out.println("ser" + tradeNo);
		return receiptDao.getListNoByTradeNo(tradeNo);

	}

	// 根据uID查询对应的作为卖方挂牌方的交易tradeNo
	@Override
	public List<String> getSellertradeNoByuID(int uID) {
		return receiptDao.getSellertradeNoByuID(uID);
	}

	// 根据uID查询对应的作为买方挂牌方的交易tradeNo
	@Override
	public List<String> getPurchtradeNoByuID(int uID) {
		return receiptDao.getPurchtradeNoByuID(uID);
	}

	// 根据uID查询对应的作为摘牌方的交易tradeNo
	@Override
	public List<String> getListNoByuID(int uID) {
		return receiptDao.getListNoByuID(uID);
	}

	// 根据tradeNo从买方摘牌表查询物流所需数据
	@Override
	public PurchWaybill getPurchbyTradeNo(String tradeNo) {
		return receiptDao.getPurchbyTradeNo(tradeNo);
	}

	// 根据tradeNo从卖方摘牌表查询物流所需数据
	@Override
	public SellerWaybill getSellerByTradeNo(String tradeNo) {
		return receiptDao.getSellerByTradeNo(tradeNo);
	}

	// 买家挂牌，由卖家提交货源地、交易方式、物流商信息
	@Override
	public int modify_purchInfo_by_seller_sNum(String sPlace, String exchangeMeans, String logisticsbus, int pNumber) {
		return receiptDao.update_purchInfo_by_pNum(sPlace, exchangeMeans, logisticsbus, pNumber);
	}

	// 卖家挂牌，由买家提交到货地
	@Override
	public int modify_sellerInfo_by_purch_pNum(String deliveryPlace, int sNumber) {
		return receiptDao.update_sellerInfo_by_purch_sNum(deliveryPlace, sNumber);
	}

	// 卖家挂牌，由卖家提交交易方式、物流商信息
	@Override
	public int modify_sellerInfo_by_seller_pNu(String exchangeMeans, String logisticsbus, int sNumber) {
		return receiptDao.update_sellerInfo_by_seller_sNum(exchangeMeans, logisticsbus, sNumber);
	}

	// 查询卖家挂牌表里的到货地、交易方式、物流商信息
	@Override
	public Seller_Info get_sellerInfo_waybill(String tradeNo) {
		return receiptDao.get_seller_waybill(tradeNo);
	}

	// 查询买家挂牌表里的货源地、交易方式、物流商信息
	@Override
	public Purch_Info get_purchInfo_waybill(String tradeNo) {
		return receiptDao.get_purch_waybill(tradeNo);
	}
}
