package com.isscollege.order.service;

import java.util.List;

import com.isscollege.order.entity.OrderDetails;
import com.isscollege.order.entity.OrderInfo;
import com.isscollege.users.entity.Login_Info;

public interface IOrderInfoService {

	int addOrder(String tradeNo);

	int modifyContractState(String contractState, String tradeNo);

	OrderDetails queryOrderDetails(String tradeNo);

	List<OrderInfo> queryOrderList(Login_Info trader, String orderClass, String orderSource, String orderState);

}
