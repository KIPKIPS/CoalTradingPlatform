package com.isscollege.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.listing.entity.Purch_Info;
import com.isscollege.listing.entity.Seller_Info;
import com.isscollege.order.entity.PurchWaybill;
import com.isscollege.order.entity.SellerWaybill;
import com.isscollege.order.entity.Transaction;

@Mapper
public interface ReceiptDao {
	// 通过tradeNo把对应状态改为1并且将path输入
	@Update("update tb_transaction set receiptState='1',receipt=#{path}" + "where tradeNo=#{tradeNo}")
	int modifyOrderStateAndReceiptSrc(@Param("path") String path, @Param("tradeNo") String tradeNo);

	// 通过tradeNo将path输入
	@Update("update tb_transaction set receipt=#{path} where tradeNo=#{tradeNo}")
	int modifyOrderReceiptSrc(@Param("path") String path, @Param("tradeNo") String tradeNo);

	// 通过tradeNo把对应状态改为1
	@Update("update tb_order_info set orderState='1' where tradeNo=#{tradeNo}")
	int modifyOrderState(@Param("tradeNo") String tradeNo);
	// 通过orderNo得到traderNo

	@Select("select tradeNo from tb_order_info where orderNo=#{orderNo}")
	String getTradeNo(@Param("orderNo") String orderNo);

	// 通过traderNo获取回执单
	@Select("select * from tb_transaction where tradeNo =#{tradeNo}")
	Transaction getTransactionByTradeNo(String tradeNo);

	// 通过traderNo更改回执单为已确认状态
	@Update("update tb_transaction set receiptState=#{state}  where tradeNo=#{tradeNo}")
	int modifyReceiptStateByTradeNo(@Param("tradeNo") String tradeNo, @Param("state") String state);

	// 根据TradeNo 获得listNo
	@Select("select listNo from tb_transaction where tradeNo = #{tradeNo}")
	int getListNoByTradeNo(@Param("tradeNo") String tradeNo);

	// 根据uID查询对应的作为卖方挂牌方的交易tradeNo
	@Select("select tradeNo from tb_transaction,tb_seller_info where tb_transaction.source = '1' and tb_transaction.listNo=tb_seller_info.sNumber and tb_seller_info.uID=#{uID} ")
	List<String> getSellertradeNoByuID(@Param("uID") int uID);

	// 根据uID查询对应的作为买方挂牌方的交易tradeNo
	@Select("select tradeNo from tb_transaction,tb_purch_info where tb_transaction.source = '2' and tb_transaction.listNo=tb_purch_info.pNumber and tb_purch_info.uID=#{uID} ")
	List<String> getPurchtradeNoByuID(@Param("uID") int uID);

	// 根据uID查询对应的作为摘牌方的交易tradeNo
	@Select("select tradeNo from tb_transaction where delistNo =#{uID}")
	List<String> getListNoByuID(@Param("uID") int uID);

	// 根据tradeNo从买方摘牌表查询物流所需数据
	@Select("select tb_purch_info.pDeliverPlace,tb_purch_info.sPlace,tb_purch_info.pCount from tb_transaction,tb_purch_info "
			+ "where tb_transaction.tradeNo=#{tradeNo} and tb_purch_info.pNumber =tb_transaction.listNo ")
	PurchWaybill getPurchbyTradeNo(@Param("tradeNo") String tradeNo);

	// 根据tradeNo从卖方挂牌表查询物流所属数据
	@Select("select b.sCount ,b.sDeliverPlace ,b.deliveryPlace from tb_transaction  a , tb_seller_info b where a.listNo=b.sNumber AND a.tradeNo=#{tradeNo} ")
	SellerWaybill getSellerByTradeNo(@Param("tradeNo") String tradeNo);

	// 买家挂牌，由卖家提交货源地、交易方式、物流商信息
	@Update("update tb_purch_info set sPlace=#{sPlace},exchangeMeans=#{exchangeMeans},logisticsbus=#{logisticsbus} where pNumber=#{pNumber}")
	public Integer update_purchInfo_by_pNum(@Param("sPlace") String sPlace,
			@Param("exchangeMeans") String exchangeMeans, @Param("logisticsbus") String logisticsbus,
			@Param("pNumber") int pNumber);

	// 卖家挂牌，由买家提交到货地
	@Update("update tb_seller_info set deliveryPlace=#{deliveryPlace} where sNumber=#{sNumber}")
	public Integer update_sellerInfo_by_purch_sNum(@Param("deliveryPlace") String deliveryPlace,
			@Param("sNumber") int sNumber);

	// 卖家挂牌，由卖家提交交易方式、物流商信息
	@Update("update tb_seller_info set exchangeMeans=#{exchangesMeans},logisticsbus=#{logisticsbus} where sNumber=#{sNumber}")
	public Integer update_sellerInfo_by_seller_sNum(@Param("exchangeMeans") String exchangeMeans,
			@Param("logisticsbus") String logisticsbus, @Param("sNumber") int sNumber);

	// 查询卖家挂牌表里的到货地、交易方式、物流商信息
	@Select("select c.deliveryPlace, c.exchangeMeans, c.logisticsbus from tb_order_info as a,tb_transaction as b,tb_seller_info as c where a.tradeNo=b.tradeNo and b.listNo=c.sNumber and a.tradeNo=#{tradeNo}")
	public Seller_Info get_seller_waybill(@Param("tradeNo") String tradeNo);

	// 查询买家挂牌表里的货源地、交易方式、物流商信息
	@Select("select c.sPlace,c.exchangeMeans,c.logisticsbus from tb_order_info as a,tb_transaction as b,tb_purch_info as c where a.tradeNo=b.tradeNo and b.listNo=c.pNumber and a.tradeNo=#{tradeNo}")
	public Purch_Info get_purch_waybill(@Param("tradeNo") String tradeNo);
}
