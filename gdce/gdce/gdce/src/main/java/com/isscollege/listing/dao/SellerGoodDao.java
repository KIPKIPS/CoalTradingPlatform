package com.isscollege.listing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;

@Mapper
public interface SellerGoodDao {

	// 查询卖家已发布信息
	@Select("select * from tb_seller_info where sstate='1' order by sNumber desc")
	List<Seller_Info> getInfoSellerPublish();

	// 查询卖家待审核信息
	@Select("select * from tb_seller_info where sstate='0' order by sNumber desc")
	List<Seller_Info> getInfoSellerCheck();

	// 查询卖家已下架信息
	@Select("select * from tb_seller_info where sstate='2' order by sNumber desc")
	List<Seller_Info> getInfoSellerUnder();

	// 查询买家已下架信息
	@Select("select * from tb_purch_info where pstate='2' order by pNumber desc")
	List<Purch_Info> getInfoPurchUnder();

	// 查询买家待审核信息
	@Select("select * from tb_purch_info where pstate='0' order by pNumber desc")
	List<Purch_Info> getInfoPurchCheck();

	// 查询买家已发布信息
	@Select("select * from tb_purch_info where pstate='1' order by pNumber desc")
	List<Purch_Info> getInfoPurchPublish();

	// 根据uID查询卖家个人已发布表单
	@Select("select * from tb_seller_info where sstate='1' and uID=#{uID} order by sNumber desc")
	List<Seller_Info> getInfoSellerPublishBy_uID(Integer uID);

	// 根据uID查询卖家个人待审核表单
	@Select("select * from tb_seller_info where sstate='0' and uID=#{uID} order by sNumber desc")
	List<Seller_Info> getInfoSellerCheckBy_uID(Integer uID);

	// 根据uID查询卖家个人已下架表单
	@Select("select * from tb_seller_info where sstate='2' and uID=#{uID} order by sNumber desc")
	List<Seller_Info> getInfoSellerUnderBy_uID(Integer uID);

	// 根据uID查询买家个人已下架表单
	@Select("select * from tb_purch_info where pstate='2' and uID=#{uID} order by pNumber desc")
	List<Purch_Info> getInfoPurchUnderBy_uID(Integer uID);

	// 根据uID查询买家个人待审核表单
	@Select("select * from tb_purch_info where pstate='0' and uID=#{uID} order by pNumber desc")
	List<Purch_Info> getInfoPurchCheckBy_uID(Integer uID);

	// 根据uID查询买家个人已发布表单
	@Select("select * from tb_purch_info where pstate='1' and uID=#{uID} order by pNumber desc")
	List<Purch_Info> getInfoPurchPublishBy_uID(Integer uID);

	// 根据商品编号查看卖家待审核商品详情
	@Select("select * from tb_seller_info where sNumber=#{sNumber}")
	Seller_Info getInfoBy_sNumber(Integer sNumber);

	// 根据商品编号查看买家待审核商品详情
	@Select("select * from tb_purch_info where pNumber=#{pNumber} ")
	Purch_Info getInfoBy_pNumber(Integer pNumber);

	// 根据uID查询cName
	@Select("select cName from tb_trade_account where uID=#{uID} ")
	String get_cName(Integer uID);

	// 买家商品审核通过
	@Update("update tb_purch_info set pstate='1' where pNumber=#{pNumber} ")
	int modifyPassStateBy_pNumber(Integer pNumber);

	// 卖家商品审核通过
	@Update("update tb_seller_info set sstate='1' where sNumber=#{sNumber} ")
	int modifyPassStateBy_sNumber(Integer sNumber);

	// 买家商品审核不通过
	@Update("update tb_purch_info set pstate='3' where pNumber=#{pNumber} ")
	int modifyNotPassStateBy_pNumber(Integer pNumber);

	// 卖家商品审核不通过
	@Update("update tb_seller_info set sstate='3' where sNumber=#{sNumber} ")
	int modifyNotPassStateBy_sNumber(Integer sNumber);

	// 卖家商品不通过意见
	@Insert("insert into tb_opinion(uID,uOpinion,oType) values(#{sNumber},#{uOpinion},'3')")
	@Options(useGeneratedKeys = true, keyProperty = "oID")
	int addSellerCheckNotPassSuggest(@Param("sNumber") Integer sNumber, @Param("uOpinion") String uOpinion);

	// 买家商品不通过意见
	@Insert("insert into tb_opinion(uID,uOpinion,oType) values(#{pNumber},#{uOpinion},'2')")
	@Options(useGeneratedKeys = true, keyProperty = "oID")
	int addSellerPurchNotPassSuggest(@Param("pNumber") Integer pNumber, @Param("uOpinion") String uOpinion);
	// 可只在dao层加上注解

}
