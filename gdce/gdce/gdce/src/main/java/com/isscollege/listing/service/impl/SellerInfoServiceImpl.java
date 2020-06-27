package com.isscollege.listing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.listing.dao.SellerInfoDao;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.ISellerInfoService;

@Service
public class SellerInfoServiceImpl implements ISellerInfoService {

	@Autowired
	SellerInfoDao sellerInfoDao;

	// 插入卖家挂牌商品信息
	@Override
	public int addSellerInfo(Seller_Info seller_info) {
		return sellerInfoDao.addSellerInfo(seller_info);
	}

	// 完善信息 (交易方式ExchangeMeans 物流商Logisticsbus)
	@Override
	public int modifySellerInfoEML(Seller_Info seller_info) {
		return sellerInfoDao.modifySellerInfoEML(seller_info);
	}

	@Override
	public int modifySellerInfoDeliveryPlace(int sNumber, String deliveryPlace) {
		return sellerInfoDao.modifySellerInfoDeliveryPlace(sNumber, deliveryPlace);
	}

	@Override
	public Seller_Info getSeller_InfobysNumber(int sNumber) {
		return sellerInfoDao.getSeller_InfobysNumber(sNumber);
	}

	@Override
	public int modifySState(String sNumber) {
		return sellerInfoDao.modifySState(sNumber);
	}
}
