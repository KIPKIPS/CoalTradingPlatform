package com.isscollege.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.order.entity.OrderDetails;
import com.isscollege.order.entity.OrderInfo;
import com.isscollege.order.entity.Transaction;

@Mapper
public interface OrderInfoDao {

	// 向订单表中添加一个新的订单
	@Insert("insert into tb_order_info(orderNo,tradeNo,orderDate,receiveDate) values(#{orderNo},#{tradeNo},#{orderDate},#{receiveDate})")
	int addOrderInfo(OrderInfo orderInfo);

	// 根据交易编号查询订单编号
	@Select("select orderNo from tb_order_info where tradeNo = #{tradeNo}")
	String queryOrderNo(String tradeNo);

	// 修改合同状态
	@Update("update tb_transaction set contractState = #{contractState} where tradeNo = #{tradeNo}")
	int modifyContractState(@Param("contractState") String contractState, @Param("tradeNo") String tradeNo);

	// 查询卖方挂牌时的订单详情
	@Select("select * from view_order_details_seller where orderNo = #{orderNo}")
	OrderDetails querySellerOrderDetails(String orderNo);

	// 查询买方挂牌时的订单详情
	@Select("select * from view_order_details_purch where orderNo = #{orderNo}")
	OrderDetails queryPurchOrderDetails(String orderNo);

	// 查找用户作为卖方挂牌的不同状态的订单(ps:参数类型不一致时需要用索引来引用值,可以用arg来传递对应的参数)
	@Select("select * from tb_order_info where orderState = #{arg2} and tradeNo in (select t.tradeNo from tb_transaction t,tb_seller_info s where t.listNo = s.sNumber and t.source=#{arg1} and s.uID = #{arg0})")
	List<OrderInfo> queryOrderList_list_seller(Integer uID, String source, String orderState);

	// 查找用户作为买方挂牌的不同状态的订单(ps:参数类型不一致时需要用索引来引用值,可以用arg来传递对应的参数)
	@Select("select * from tb_order_info where orderState = #{arg2} and tradeNo in (select t.tradeNo from tb_transaction t,tb_purch_info p where t.listNo = p.pNumber and t.source=#{arg1} and p.uID = #{arg0})")
	List<OrderInfo> queryOrderList_list_purch(Integer uID, String source, String orderState);

	// 查找用户摘牌的不同状态的订单
	@Select("select * from tb_order_info where orderState = #{arg2} and tradeNo in (select t.tradeNo from tb_transaction t where t.source=#{arg1} and t.delistNo = #{arg0})")
	List<OrderInfo> queryOrderList_delist(Integer uID, String source, String orderState);

	@Select("select * from tb_transaction where traderNo =#{traderNo}")
	Transaction getReceiptPathByTraderNo(String traderNo);

}
