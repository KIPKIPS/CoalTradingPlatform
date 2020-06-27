package com.isscollege.order.service;

import java.util.List;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.order.entity.PurchWaybill;
import com.isscollege.order.entity.SellerWaybill;
import com.isscollege.order.entity.Transaction;

public interface IReceiptService {

	String getTradeNo(String orderNo);

	// 添加回执单路径,修改回执单状态
	int modifyOrderStateAndReceiptSrc(String path, String tradeNo);

	// 修改订单状态
	int modifyOrderState(String tradeNo);

	// 添加回执单路径
	int modifyOrderReceiptSrc(String path, String tradeNo);

	// 通过TraderNo 获取回执单路径
	abstract Transaction getTransactionByTradeNo(String tradeNo);

	// 通过TraderNo 修改回执单为已确认状态
	abstract int modifyReceiptStateByTradeNo(String tradeNo, String state);

	// 根据TradeNo 获得OderNo
	abstract int getListNoByTradeNo(String tradeNo);

	// 根据uID查询对应的作为卖方挂牌方的交易tradeNo
	abstract List<String> getSellertradeNoByuID(int uID);

	// 根据uID查询对应的作为买方挂牌方的交易tradeNo
	abstract List<String> getPurchtradeNoByuID(int uID);

	// 根据uID查询对应的作为摘牌方的交易tradeNo
	abstract List<String> getListNoByuID(int uID);

	// 根据tradeNo从买方摘牌表查询物流所需数据
	abstract PurchWaybill getPurchbyTradeNo(String tradeNo);

	// 根据tradeNo从卖方摘牌表查询物流所需数据
	abstract SellerWaybill getSellerByTradeNo(String tradeNo);

	// 买家挂牌，由卖家提交货源地、交易方式、物流商信息
	abstract int modify_purchInfo_by_seller_sNum(String sPlace, String exchangeMeans, String logisticsbus, int pNumber);

	// 卖家挂牌，由买家提交到货地
	abstract int modify_sellerInfo_by_purch_pNum(String deliveryPlace, int sNumber);

	// 卖家挂牌，由卖家提交交易方式、物流商信息
	abstract int modify_sellerInfo_by_seller_pNu(String exchangeMeans, String logisticsbus, int sNumber);

	// 查询卖家挂牌表里的到货地、交易方式、物流商信息
	abstract Seller_Info get_sellerInfo_waybill(String tradeNo);

	// 查询买家挂牌表里的货源地、交易方式、物流商信息
	abstract Purch_Info get_purchInfo_waybill(String tradeNo);
}
