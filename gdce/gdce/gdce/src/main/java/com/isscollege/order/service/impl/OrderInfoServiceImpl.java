package com.isscollege.order.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isscollege.order.dao.OrderInfoDao;
import com.isscollege.order.entity.OrderDetails;
import com.isscollege.order.entity.OrderInfo;
import com.isscollege.order.service.IOrderInfoService;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.utils.GetNumber;

@Repository
public class OrderInfoServiceImpl implements IOrderInfoService {
	@Autowired
	private OrderInfoDao orderInfoDao;

	public OrderInfoDao getOrderInfoDao() {
		return orderInfoDao;
	}

	public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
		this.orderInfoDao = orderInfoDao;
	}

	// 修改合同状态
	@Override
	public int modifyContractState(String contractState, String tradeNo) {
		return orderInfoDao.modifyContractState(contractState, tradeNo);
	}

	// 生成订单
	@Override
	public int addOrder(String tradeNo) {
		// 拿到摘牌方的用户编号(交易编号的后两位)
		StringBuffer tradeNum = new StringBuffer(tradeNo);
		String uId = tradeNum.reverse().substring(0, 2);
		uId = new StringBuffer(uId).reverse().toString();
		String orderNo = GetNumber.getNumber(uId);
		// 以当前时间作为订单创建时间
		Timestamp orderDate = new Timestamp(System.currentTimeMillis());
		// 创建订单的时候，将收货时间设置为订单创建时间+3天
		Timestamp receiveDate = new Timestamp(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000);

		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderNo(orderNo);
		orderInfo.setTradeNo(tradeNo);
		orderInfo.setOrderDate(orderDate);
		orderInfo.setReceiveDate(receiveDate);

		return orderInfoDao.addOrderInfo(orderInfo);
	}

	// 查询订单详情
	@Override
	public OrderDetails queryOrderDetails(String tradeNo) {
		String orderNo = orderInfoDao.queryOrderNo(tradeNo);
		// 得到买方挂牌时订单的详情
		OrderDetails purchOrderDetails = orderInfoDao.queryPurchOrderDetails(orderNo);

		// 当查询买方挂牌详情结果为空时查询卖方挂牌时订单的详情
		if (purchOrderDetails == null) {
			OrderDetails sellerOrderDetails = orderInfoDao.querySellerOrderDetails(orderNo);
			if (sellerOrderDetails != null) {
				return sellerOrderDetails;
			} else {
				return null;
			}

		}
		return purchOrderDetails;

	}

	// 查找订单列表
	@Override
	public List<OrderInfo> queryOrderList(Login_Info trader, String orderClass, String orderSource, String orderState) {
		if (orderClass.equals("buy")) {
			if (orderSource.equals("list")) {
				// 买方挂牌订单
				return orderInfoDao.queryOrderList_list_purch(trader.getuID(), "2", orderState);
			} else {
				// 买方摘牌订单
				return orderInfoDao.queryOrderList_delist(trader.getuID(), "1", orderState);
			}
		} else {
			if (orderSource.equals("list")) {
				// 卖方挂牌订单
				return orderInfoDao.queryOrderList_list_seller(trader.getuID(), "1", orderState);
			} else {
				// 卖方摘牌订单
				return orderInfoDao.queryOrderList_delist(trader.getuID(), "2", orderState);
			}
		}
	}

}
