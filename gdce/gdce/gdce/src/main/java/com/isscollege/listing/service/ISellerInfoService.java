package com.isscollege.listing.service;

import com.isscollege.listing.entity.Seller_Info;

public interface ISellerInfoService {

	// 插入卖家挂牌信息
	public int addSellerInfo(Seller_Info seller_info);

	// 完善信息 (交易方式ExchangeMeans 物流商Logisticsbus)
	public abstract int modifySellerInfoEML(Seller_Info seller_info);

	// 完善信息 (到货地)
	int modifySellerInfoDeliveryPlace(int sNumber, String deliveryPlace);

	// 根据主键查卖家信息
	public Seller_Info getSeller_InfobysNumber(int sNumber);

	public int modifySState(String sNumber);
}
