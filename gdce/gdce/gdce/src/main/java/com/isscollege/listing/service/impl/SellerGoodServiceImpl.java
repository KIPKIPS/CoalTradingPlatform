package com.isscollege.listing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.listing.dao.SellerGoodDao;
import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.listing.service.ISellerGoodService;

@Service
public class SellerGoodServiceImpl implements ISellerGoodService {
	@Autowired
	private SellerGoodDao sellerGoodDao;

	// 查询卖家已发布信息
	@Override
	public List<Seller_Info> getInfoSellerPublish() {

		return sellerGoodDao.getInfoSellerPublish();
	}

	// 查询卖家待审核信息
	@Override
	public List<Seller_Info> getInfoSellerCheck() {

		return sellerGoodDao.getInfoSellerCheck();
	}

	// 查询卖家已下架信息
	@Override
	public List<Seller_Info> getInfoSellerUnder() {

		return sellerGoodDao.getInfoSellerUnder();
	}

	// 查询买家已下架信息
	@Override
	public List<Purch_Info> getInfoPurchUnder() {

		return sellerGoodDao.getInfoPurchUnder();
	}

	// 查询买家待审核信息
	@Override
	public List<Purch_Info> getInfoPurchCheck() {

		return sellerGoodDao.getInfoPurchCheck();
	}

	// 查询买家已发布信息
	@Override
	public List<Purch_Info> getInfoPurchPublish() {

		return sellerGoodDao.getInfoPurchPublish();
	}

	// 根据商品编号查看卖家待审核商品详情
	@Override
	public Seller_Info getInfoBy_sNumber(Integer sNumber) {

		return sellerGoodDao.getInfoBy_sNumber(sNumber);
	}

	// 根据商品编号查看买家待审核商品详情
	@Override
	public Purch_Info getInfoBy_pNumber(Integer pNumber) {

		return sellerGoodDao.getInfoBy_pNumber(pNumber);
	}

	// 买家商品审核通过
	@Override
	public int modifyPassStateBy_pNumber(Integer pNumber) {

		return sellerGoodDao.modifyPassStateBy_pNumber(pNumber);
	}

	// 卖家商品审核通过
	@Override
	public int modifyPassStateBy_sNumber(Integer sNumber) {

		return sellerGoodDao.modifyPassStateBy_sNumber(sNumber);
	}

	// 买家商品审核不通过
	@Override
	public int modifyNotPassStateBy_pNumber(Integer pNumber) {

		return sellerGoodDao.modifyNotPassStateBy_pNumber(pNumber);
	}

	// 卖家商品审核不通过
	@Override
	public int modifyNotPassStateBy_sNumber(Integer sNumber) {

		return sellerGoodDao.modifyNotPassStateBy_sNumber(sNumber);
	}

	// 卖家商品不通过意见
	@Override
	public int addSellerCheckNotPassSuggest(Integer sNumber, String uOpinion) {

		return sellerGoodDao.addSellerCheckNotPassSuggest(sNumber, uOpinion);
	}

	// 买家商品不通过意见
	@Override
	public int addSellerPurchNotPassSuggest(Integer pNumber, String uOpinion) {

		return sellerGoodDao.addSellerPurchNotPassSuggest(pNumber, uOpinion);
	}

	// 根据uID查询卖家个人已发布表单
	@Override
	public List<Seller_Info> getInfoSellerPublishBy_uID(Integer uID) {

		return sellerGoodDao.getInfoSellerPublishBy_uID(uID);
	}

	// 根据uID查询卖家个人待审核表单
	@Override
	public List<Seller_Info> getInfoSellerCheckBy_uID(Integer uID) {

		return sellerGoodDao.getInfoSellerCheckBy_uID(uID);
	}

	// 根据uID查询卖家个人已下架表单
	@Override
	public List<Seller_Info> getInfoSellerUnderBy_uID(Integer uID) {

		return sellerGoodDao.getInfoSellerUnderBy_uID(uID);
	}

	// 根据uID查询买家个人已下架表单
	@Override
	public List<Purch_Info> getInfoPurchUnderBy_uID(Integer uID) {

		return sellerGoodDao.getInfoPurchUnderBy_uID(uID);
	}

	// 根据uID查询买家个人待审核表单
	@Override
	public List<Purch_Info> getInfoPurchCheckBy_uID(Integer uID) {

		return sellerGoodDao.getInfoPurchCheckBy_uID(uID);
	}

	// 根据uID查询买家个人已发布表单
	@Override
	public List<Purch_Info> getInfoPurchPublishBy_uID(Integer uID) {

		return sellerGoodDao.getInfoPurchPublishBy_uID(uID);
	}

	// 根据uID查询cName
	@Override
	public String get_cName(Integer uID) {

		return sellerGoodDao.get_cName(uID);
	}

}
