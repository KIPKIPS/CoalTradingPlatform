package com.isscollege.listing.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;

public interface ISellerGoodService {
	// 查询卖家已发布信息
	List<Seller_Info> getInfoSellerPublish();

	// 查询卖家待审核信息
	List<Seller_Info> getInfoSellerCheck();

	// 查询卖家已下架信息
	List<Seller_Info> getInfoSellerUnder();

	// 查询买家已下架信息
	List<Purch_Info> getInfoPurchUnder();

	// 查询买家待审核信息
	List<Purch_Info> getInfoPurchCheck();

	// 查询买家已发布信息
	List<Purch_Info> getInfoPurchPublish();

	// 根据uID查询卖家个人已发布表单
	List<Seller_Info> getInfoSellerPublishBy_uID(Integer uID);

	// 根据uID查询卖家个人待审核表单
	List<Seller_Info> getInfoSellerCheckBy_uID(Integer uID);

	// 根据uID查询卖家个人已下架表单
	List<Seller_Info> getInfoSellerUnderBy_uID(Integer uID);

	// 根据uID查询买家个人已下架表单
	List<Purch_Info> getInfoPurchUnderBy_uID(Integer uID);

	// 根据uID查询买家个人待审核表单
	List<Purch_Info> getInfoPurchCheckBy_uID(Integer uID);

	// 根据uID查询买家个人已发布表单
	List<Purch_Info> getInfoPurchPublishBy_uID(Integer uID);

	// 根据商品编号查看卖家待审核商品详情
	Seller_Info getInfoBy_sNumber(Integer sNumber);

	// 根据商品编号查看买家待审核商品详情
	Purch_Info getInfoBy_pNumber(Integer pNumber);

	// 根据uID查询cName
	String get_cName(Integer uID);

	// 买家商品审核通过
	int modifyPassStateBy_pNumber(Integer pNumber);

	// 卖家商品审核通过
	int modifyPassStateBy_sNumber(Integer sNumber);

	// 买家商品审核不通过
	int modifyNotPassStateBy_pNumber(Integer pNumber);

	// 卖家商品审核不通过
	int modifyNotPassStateBy_sNumber(Integer sNumber);

	// 卖家商品不通过意见
	int addSellerCheckNotPassSuggest(@Param("sNumber") Integer sNumber, @Param("uOpinion") String uOpinion);

	// 买家商品不通过意见
	int addSellerPurchNotPassSuggest(@Param("pNumber") Integer pNumber, @Param("uOpinion") String uOpinion);
}
