package com.isscollege.listing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.listing.dao.ListingGoodsDao;
import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.IListingGoodsService;

@Service
public class ListingGoodsServiceImpl implements IListingGoodsService{
	@Autowired
	private ListingGoodsDao listingGoodsDao;
	
	//查询所有买家挂牌商品
	@Override
	public List<Purch_Info> getAllPurchListingList(){
		return listingGoodsDao.getAllPurchList();
	}
	
	//查询所有卖家挂牌商品
	@Override
	public List<Seller_Info> getAllSellerListingList(){
		return listingGoodsDao.getAllSellerList();
	}
	
	//根据买家挂牌编号查询对应商品
	@Override
	public Purch_Info getPurchGoodsById(Integer pNumber) {
		return listingGoodsDao.getPurchGoodsById(pNumber);
	}
	
	//根据卖家挂牌编号查询对应商品
	@Override
	public Seller_Info getSellerGoodsById(Integer sNumber) {
		return listingGoodsDao.getSellerGoodsById(sNumber);
	}

}
