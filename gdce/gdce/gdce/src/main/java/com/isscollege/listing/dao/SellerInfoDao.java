package com.isscollege.listing.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.listing.entity.Seller_Info;

@Mapper
public interface SellerInfoDao {

	// 插入卖方挂牌数据
	@Insert("insert into tb_seller_info(sCount,sKCal,sCPrice,sS,sPlace,sFreight,sVolatilizeMin,sVolatilizeMax,sDeliverPlace,"
			+ "sAshContent,sMoisture,sState,uID,adminID,coalTtype,transType) values(#{sCount},#{sKCal},#{sCPrice},#{sS},#{sPlace},#{sFreight},#{sVolatilizeMin},"
			+ "#{sVolatilizeMax},#{sDeliverPlace},#{sAshContent},#{sMoisture},#{sState},#{uID},#{adminID},#{coalTtype},#{transType})")
	@Options(useGeneratedKeys = true, keyProperty = "sNumber")
	int addSellerInfo(Seller_Info seller_info);

	// 完善信息 (交易方式ExchangeMeans 物流商Logisticsbus)
	@Update("update tb_seller_info set exchangeMeans=#{exchangeMeans},logisticsbus=#{logisticsbus} where sNumber=#{sNumber}")
	int modifySellerInfoEML(Seller_Info seller_info);

	// 完善信息 (到货地)
	@Update("update tb_seller_info set deliveryPlace=#{deliveryPlace} where sNumber=#{sNumber}")
	int modifySellerInfoDeliveryPlace(@Param("sNumber") int sNumber, @Param("deliveryPlace") String deliveryPlace);

	// 根据uID查卖方信息
	@Select("select * from tb_seller_info where uID=#{uID}")
	public Seller_Info getSeller_Info_ByID(int uID);

	// 根据sNumber查询卖家信息
	@Select("select * from tb_seller_info where sNumber=#{sNumber}")
	public Seller_Info getSeller_InfobysNumber(int sNumber);

	// 将sell_info表中该列状态改为2
	@Update("update tb_seller_info set sstate = 2 where sNumber = #{sNumber}")
	public int modifySState(@Param("sNumber") String sNumber);
}
