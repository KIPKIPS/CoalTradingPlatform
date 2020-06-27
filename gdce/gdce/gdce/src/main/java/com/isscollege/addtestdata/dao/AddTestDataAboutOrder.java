/**
 * 
 */
package com.isscollege.addtestdata.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Apple
 *
 */
@Mapper
public interface AddTestDataAboutOrder {
	// 通过挂牌编号、用户ID往买方挂牌表插入数据(挂牌状态为2（已下架）)
	@Insert("insert into `tb_purch_info` (`pNumber`, `pListID`, `pName`, `pIssuer`, `pApplyDate`, `pDeliverEarliest`, `pDeliverLatest`, `pCoalType`, `pCoalBusType`, `pCount`, `pTransport`, `coalPrice`, `transPrice`, `pDeliverPlace`, `pSettlement`, `pCheck`, `pPayment`, `pQuoDeposit`, `pBidBond`, `pQnetar`, `pStar`, `pM`, `pAar`, `pVarmin`, `pVarmax`, `pMad`, `pStad`, `pVadmin`, `pVadmax`, `pQgrd`, `pStd`, `pVanmin`, `pVanmax`, `pGrad`, `pST`, `pHGI`, `pRemarks`, `pState`, `uID`, `adminID`, `sPlace`, `exchangeMeans`, `logisticsbus`) values(#{arg0},'津能热电20190617','张三','李四','2019-06-20 15:44:12','2019-07-01 00:00:00','2019-07-10 00:00:00','无烟煤','3','3','3','2','1','陕西西安','3','3','33','3','3','33','3','33','3','3','33','3','33','3','3','33','3','33','3','3','33','3','33','2',#{arg1},'3','山西','线下交易','邮政')")
	public int addDataIntoPurch(int pNO, int uID);

	// 通过挂牌编号、用户ID往卖方挂牌表插入数据(挂牌状态为2（已下架）)
	@Insert("insert into `tb_seller_info` (`sNumber`, `coalTtype`, `transType`, `sCount`, `sKCal`, `sCPrice`, `sS`, `sPlace`, `sFreight`, `sVolatilizeMin`, `sVolatilizeMax`, `sDeliverPlace`, `sAshContent`, `sMoisture`, `sState`, `uID`, `adminID`, `deliveryPlace`, `exchangeMeans`, `logisticsbus`) values(#{arg0},'原煤','','2','3','4','5','西安','7','89','5','西安','2','2','2',#{arg1},'3','西安','线下交易','邮政')")
	public int addDataIntoSeller(int sNO, int uID);

	// 通过交易编号、摘牌用户ID、挂牌编号和交易来源往交易表插入数据（合同和回执单状态均为11（双方都已确认））
	@Insert("insert into `tb_transaction` (`tradeNo`, `delistNo`, `listNo`, `contract`, `contractState`, `receipt`, `receiptState`, `source`) values(#{arg0},#{arg1},#{arg2},'合同协议书.pdf','11','.jpg','11',#{arg3})")
	public int addDataIntoTransaction(String tradeNo, int delistNo, int listNo, String source);

	// 通过交易编号、摘牌用户ID、挂牌编号、合同状态和交易来源往交易表插入数据（回执单状态为11（双方都已确认））
	@Insert("insert into `tb_transaction` (`tradeNo`, `delistNo`, `listNo`, `contract`, `contractState`, `receipt`, `receiptState`, `source`) values(#{arg0},#{arg1},#{arg2},'合同协议书.pdf',#{arg4},'.jpg','11',#{arg3})")
	public int addDataIntoTransaction_contract(String tradeNo, int delistNo, int listNo, String source,
			String contractState);

	// 通过订单编号、交易编号和订单状态往订单表插入数据
	@Insert("insert into `tb_order_info` (`orderNo`, `tradeNo`, `orderState`, `orderDate`) values(#{arg0},#{arg1},#{arg2},'20190701')")
	public int addDataIntoOrder(String orderNo, String tradeNo, String orderState);

	@Insert("insert into `tb_news` (`nEditorID`, `nTheme`, `nContent`, `nState`,`nPulisherID`) values(#{arg0},#{arg1},#{arg2},#{arg3},#{arg4})")
	public int addNews(Integer nEditorID, String nTheme, String nContent, Integer nState, Integer nPulisherID);

	// 通过挂牌编号、用户ID往买方挂牌表插入数据(挂牌状态为1（已发布）)
	@Insert("insert into `tb_purch_info` (`pNumber`, `pListID`, `pName`, `pIssuer`, `pApplyDate`, `pDeliverEarliest`, `pDeliverLatest`, `pCoalType`, `pCoalBusType`, `pCount`, `pTransport`, `coalPrice`, `transPrice`, `pDeliverPlace`, `pSettlement`, `pCheck`, `pPayment`, `pQuoDeposit`, `pBidBond`, `pQnetar`, `pStar`, `pM`, `pAar`, `pVarmin`, `pVarmax`, `pMad`, `pStad`, `pVadmin`, `pVadmax`, `pQgrd`, `pStd`, `pVanmin`, `pVanmax`, `pGrad`, `pST`, `pHGI`, `pRemarks`, `pState`, `uID`, `adminID`, `sPlace`, `exchangeMeans`, `logisticsbus`) values(#{arg0},'津能热电20190617','张三','李四','2019-06-20 15:44:12','2019-07-01 00:00:00','2019-07-10 00:00:00','无烟煤','3','3','3','2','1','陕西西安','3','3','33','3','3','33','3','33','3','3','33','3','33','3','3','33','3','33','3','3','33','3','33','1',#{arg1},'3','山西','线下交易','邮政')")
	public int addDataIntoPurchS1(int pNO, int uID);

	// 通过挂牌编号、用户ID往卖方挂牌表插入数据(挂牌状态为1（已发布）)
	@Insert("insert into `tb_seller_info` (`sNumber`, `coalTtype`, `transType`, `sCount`, `sKCal`, `sCPrice`, `sS`, `sPlace`, `sFreight`, `sVolatilizeMin`, `sVolatilizeMax`, `sDeliverPlace`, `sAshContent`, `sMoisture`, `sState`, `uID`, `adminID`, `deliveryPlace`, `exchangeMeans`, `logisticsbus`) values(#{arg0},'原煤','','2','3','4','5','西安','7','89','5','西安','2','2','1',#{arg1},'3','西安','线下交易','邮政')")
	public int addDataIntoSellerS1(int sNO, int uID);
}
