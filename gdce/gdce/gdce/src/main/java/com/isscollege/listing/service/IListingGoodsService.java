package com.isscollege.listing.service;

import java.util.List;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;

public interface IListingGoodsService {
	//查询所有买家挂牌商品
	public List<Purch_Info> getAllPurchListingList();
	
	//查询所有卖家挂牌商品
	public List<Seller_Info> getAllSellerListingList();
	
	//根据买家挂牌编号查询对应商品
	public Purch_Info getPurchGoodsById(Integer pNumber);
	
	//根据卖家挂牌编号查询对应商品
	public Seller_Info getSellerGoodsById(Integer sNumber);
	
}
