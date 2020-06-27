package com.isscollege.listing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;


@Mapper
public interface ListingGoodsDao {
	//查询所有买家挂牌商品
	@Select("select * from tb_purch_info where pState = '1'")
	List<Purch_Info> getAllPurchList();
	
	//查询所有卖家挂牌商品
	@Select("select * from tb_seller_info where sState = '1'")
	List<Seller_Info> getAllSellerList();
    
	//根据买家挂牌编号查询对应商品
	@Select("select * from tb_purch_info where pNumber = #{pNumber}")
    Purch_Info getPurchGoodsById(Integer pNumber);
   
	//根据卖家挂牌编号查询对应商品
	@Select("select * from tb_seller_info where sNumber = #{sNumber}")
    Seller_Info getSellerGoodsById(Integer sNumber);
}
