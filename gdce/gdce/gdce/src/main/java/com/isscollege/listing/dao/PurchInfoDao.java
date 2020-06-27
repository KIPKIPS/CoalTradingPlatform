package com.isscollege.listing.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.listing.entity.Purch_Info;

@Mapper
public interface PurchInfoDao {

	// 插入买家挂牌商品信息
	@Insert("insert into tb_purch_info(pNumber,pListID,pName,pIssuer,"
			+ "pDeliverEarliest,pDeliverLatest,pCoalType,pCoalBusType,pCount,"
			+ "pTransport,pDeliverPlace,pSettlement,pCheck,pPayment,pQuoDeposit,"
			+ "pBidBond,pQnetar,pStar,pM,pAar,pVarmin,pVarmax,pMad,pStad,pVadmin,"
			+ "pVadmax,pQgrd,pStd,pVanmin,pVanmax,pGrad,pST,pHGI,pRemarks,pState,uID,adminID,coalPrice,transPrice)"
			+ "values(#{pNumber},#{pListID},#{pName},#{pIssuer},"
			+ "#{pDeliverEarliest},#{pDeliverLatest},#{pCoalType},#{pCoalBusType},"
			+ "#{pCount},#{pTransport},#{pDeliverPlace},#{pSettlement},"
			+ "#{pCheck},#{pPayment},#{pQuoDeposit},#{pBidBond},#{pQnetar},"
			+ "#{pStar},#{pM},#{pAar},#{pVarmin},#{pVarmax},#{pMad},"
			+ "#{pStad},#{pVadmin},#{pVadmax},#{pQgrd},#{pStd},#{pVanmin},#{pVanmax},#{pGrad},"
			+ "#{pST},#{pHGI},#{pRemarks},#{pState},#{uID},#{adminID},#{coalPrice},#{transPrice})")
	int addPurchInfo(Purch_Info purch_info);

	// 根据主键查所有信息
	@Select("select * from tb_purch_info where pNumber=#{pNumber}")
	public Purch_Info getPurch_InfobypNumber(int pNumber);

	// 完善信息 (货源地 交易方式 物流商)
	@Update("update tb_purch_info set exchangeMeans=#{exchangeMeans},logisticsbus=#{logisticsbus},sPlace=#{sPlace} where pNumber=#{pNumber}")
	int modifyPurch_infoEMLD(@Param("pNumber") int pNumber, @Param("exchangeMeans") String exchangeMeans,
			@Param("logisticsbus") String logisticsbus, @Param("sPlace") String sPlace);

	// 根据uID查询买家挂牌信息
	@Select("select * from tb_purch_info where uID = #{uID}")
	public Purch_Info getPurch_Info_ByID(int uID);

	// 根据uID拿cName
	@Select("select cName from tb_trade_account where uID=#{uID}")
	String getCName(Integer uID);

	// 根据uID得到银行账号
	@Select("select cBankAccount from tb_trade_account where uID = #{uID}")
	String getCBankAccount(Integer uID);

	// 将purch_info表中该列状态改为2
	@Update("update tb_purch_info set pstate = 2 where pNumber = #{pNumber}")
	public int modifyPState(@Param("pNumber") String pNumber);

	// 增加报价保证金余额
	/*
	 * @Update("update tb_finance set muQuoDeposit=muQuoDeposit+#{arg1} where uID=#{arg0}"
	 * ) int increaseMuQuoDeposit(int uID, double money);
	 */

	// 减少未冻结余额
	/*
	 * @Update("update tb_finance set muUsable=muUsable-#{arg1} where uID=#{arg0}"
	 * ) int decreaseMuUsable(int uID, double money);
	 */

}
