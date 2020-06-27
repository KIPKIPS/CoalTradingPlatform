package com.isscollege.contract.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.contract.entity.Contract;
import com.isscollege.contract.entity.ContractList;

//将引用的2次transaction表分为b1,b2
//b2：摘牌方；b1：挂牌方
@Mapper
public interface GetSignedContractDao {

	// 挂牌方在确认合同时候就已经签约过合同，所以未确认的合同只可能在摘牌方存在
	// 即->查找该uid作为摘牌方的时候，合同状态为01的合同列
	// 即->uid=delistNo,ContractState=01
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1, b2.cName AS c2,a.contract,a.contractState FROM tb_transaction AS a,tb_purch_info AS c1,tb_seller_info AS c2,tb_trade_account AS b1,tb_trade_account AS b2 WHERE (a.delistNo = b2.uID AND b2.uid = #{uID} AND a.contractState =01 AND source = 1 AND a.listNo = c2.sNumber AND c2.uID = b1.uID) OR (a.delistNo = b2.uID AND b2.uid = #{uID} AND a.contractState =01 AND source = 2 AND a.listNo = c1.pNumber AND c2.uID = b1.uID)")
	List<ContractList> getUnsignedContract(int uID);

	// 已签约的合同的类型有===》作为挂牌方，上传的合同即为已签约//或者//双方都已签订合同（共2种）
	// 1.作为挂牌方合同刚上传。
	// 1.1即source=1（卖方挂牌），uid=tb_seller_info.uid（卖方挂牌表），listNo=tb_seller_info.sNumber（卖方挂牌交易表），ContractState=01
	// 1.2或====》source=2（买方挂牌），uid=tb_purch_info.uid（买方挂牌表），listNo=tb_purch_info.pNumber（买方挂牌交易表），ContractState=01
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1, b2.cName AS c2,a.contract,a.contractState FROM tb_transaction AS a,tb_purch_info AS c1,tb_seller_info AS c2,tb_trade_account AS b1,tb_trade_account AS b2 WHERE (b1.uID = c2.uID AND b1.uid = #{uID} AND a.listNo = c2.sNumber AND b2.uID = a.delistNo AND a.contractState =01 AND a.source = 1 ) OR (b1.uID = c1.uID AND c1.pNumber = a.listNo AND a.contractState = 01 AND b1.uID = #{uID} AND source = 2 AND b2.uID = a.delistNo)")
	List<ContractList> getSignedContract(int uID);

	// 2.双方都已确认
	// 2.1即ConstractState=11
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1, b2.cName AS c2,a.contract,a.contractState FROM tb_transaction AS a,tb_purch_info AS c1,tb_seller_info AS c2,tb_trade_account AS b1,tb_trade_account AS b2 WHERE ((b1.uID = c2.uID AND a.listNo = c2.sNumber AND a.contractState =11 AND source = 1 AND b2.uID = a.delistNo) AND (b1.uID=#{uID} OR b2.uID=#{uID})) OR ((b1.uID = c1.uID AND c1.pNumber = a.listNo AND a.contractState = 11 AND source = 2 AND b2.uID = a.delistNo) AND (b1.uID=#{uID} OR b2.uID=#{uID}))")
	List<ContractList> getAllSignedContract(int uID);

	// 查找该用户未上传的合同（无论他是挂牌方还是摘牌方）
	// 即作为挂牌方时候state=00 && 作为摘牌方时候state=00
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1, b2.cName AS c2,a.contract,a.contractState FROM tb_transaction AS a,tb_purch_info AS c1,tb_seller_info AS c2,tb_trade_account AS b1,tb_trade_account AS b2 WHERE (b1.uID = c2.uID AND b1.uid = #{uID} AND a.listNo = c2.sNumber AND a.contractState =00 AND source = 1 AND b2.uID = a.delistNo) OR (b1.uID = c1.uID AND c1.pNumber = a.listNo AND a.contractState = 00 AND b1.uID = #{uID} AND source = 2 AND b2.uID = a.delistNo) OR (b1.uID = c2.uID	AND b2.uid = #{uID} AND a.listNo = c2.sNumber AND a.contractState =00 AND source = 1 AND b2.uID = a.delistNo) OR (b1.uID = c1.uID AND c1.pNumber = a.listNo AND a.contractState = 00 AND b2.uID = #{uID} AND source = 2 AND b2.uID = a.delistNo)")
	List<ContractList> getUnupdateContract(int uID);

	// 完成确认 将合同状态变为11
	@Update("update tb_transaction set contractState = '11' where tradeNo = #{tradeNo}")
	public int modifyContractStateInto11(@Param("tradeNo") String tradeNo);

	// 完成确认 将合同状态变为01
	@Update("update tb_transaction set contractState = '01',contract = #{contract} where tradeNo = #{tradeNo}")
	public int modifyContractStateInto01(@Param("tradeNo") String tradeNo, @Param("contract") String contract);

	// 创建默认的合同：tradeNo自动生成，delistNo、listNo从页面获取，contract为默认（未上传），state为00，source从页面获取
	// 从purch页面传来 则source=2，从seller页面传来，则source=1
	@Insert("insert into tb_transaction(tradeNo,delistNo, listNo,contract, contractState,source)"
			+ "values (#{tradeNo},#{delistNo},#{listNo},'default.jpg','00',#{source})")
	public int addContract(@Param("tradeNo") String tradeNo, @Param("delistNo") int delistNo,
			@Param("listNo") int listNo, @Param("source") String source);

	// insert合同文件
	@Update("update tb_transaction set contract = '#{contract}' where tradeNo = #{tradeNo}")
	public int modifyContractFile(@Param("tradeNo") String tradeNo, @Param("contract") String contract);

	// 判断此UID在此tradeNo中是否是摘牌方
	// 1 source==1 改UID与delistNo相匹配
	// 2 source==2该UID与delistNo相匹配
	@Select("select * from tb_transaction where tb_transaction.tradeNo=#{tradeNo} AND ")
	public ContractList checkIdentify(int uID, String tradeNo);

	// 向摘牌方展示合同
	@Select("select * from tb_transaction where tb_transaction.tradeNo=#{tradeNo}")
	Contract getContractDetails(String tradeNo);

	// 用户取消删除合同的全部数据
	@Delete("delete from tb_transaction where tb_transaction.tradeNo=#{tradeNo}")
	int removeAllContract(String tradeNo);

	// 根据交易编号查询合同状态
	@Select("select contractState from tb_transaction where tradeNo = #{tradeNo}")
	String queryContractState(String tradeNo);

	// 修改合同状态
	@Update("update tb_transaction set contractState = #{contractState} where tradeNo = #{tradeNo}")
	int modifyContractState(@Param("contractState") String contractState, @Param("tradeNo") String tradeNo);

	// 查询买方挂牌的合同列表
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1,b2.cName AS c2,t.contract,t.contractState FROM tb_transaction AS t,tb_purch_info AS s,tb_trade_account AS b1,tb_trade_account AS b2 WHERE b1.uID=s.uID AND s.pNumber=t.listNo AND t.delistNo=b2.uID AND t.source=2 AND b1.uID=#{arg0} AND t.contractState=#{arg2}")
	List<ContractList> queryContractList_list_purch(Integer uID, String source, String orderState);

	// 查询买方摘牌的合同列表
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1,b2.cName AS c2,t.contract,t.contractState FROM tb_transaction AS t,tb_seller_info AS s,tb_trade_account AS b1,tb_trade_account AS b2 WHERE b1.uID=s.uID AND s.sNumber=t.listNo AND t.delistNo=b2.uID AND t.source=1 AND b2.uID=#{arg0} AND t.contractState=#{arg2}")
	List<ContractList> queryContractList_delist_purch(Integer uID, String source, String orderState);

	// 查询卖方挂牌的合同列表
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1,b2.cName AS c2,t.contract,t.contractState FROM tb_transaction AS t,tb_seller_info AS s,tb_trade_account AS b1,tb_trade_account AS b2 WHERE b1.uID=s.uID AND s.sNumber=t.listNo AND t.delistNo=b2.uID AND t.source=1 AND b1.uID=#{arg0} AND t.contractState=#{arg2}")
	List<ContractList> queryContractList_list_seller(Integer uID, String source, String orderState);

	// 查询卖方摘牌的合同列表
	@Select("SELECT DISTINCT tradeNo,b1.cName AS c1,b2.cName AS c2,t.contract,t.contractState FROM tb_transaction AS t,tb_purch_info AS s,tb_trade_account AS b1,tb_trade_account AS b2 WHERE b1.uID=s.uID AND s.pNumber=t.listNo AND t.delistNo=b2.uID AND t.source=2 AND b2.uID=#{arg0} AND t.contractState=#{arg2}")
	List<ContractList> queryContractList_delist_seller(Integer uID, String source, String orderState);

}
