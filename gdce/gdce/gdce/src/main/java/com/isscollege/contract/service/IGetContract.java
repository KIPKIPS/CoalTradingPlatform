package com.isscollege.contract.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isscollege.contract.entity.Contract;
import com.isscollege.contract.entity.ContractList;
import com.isscollege.users.entity.Login_Info;

@Service
public interface IGetContract {

	// 挂牌方在确认合同时候，已经签约过合同，所以未确认的合同只可能在摘牌方存在
	// 即->查找该uid作为摘牌方的时候，合同状态为10的合同列
	// 即->uid=delistNo,ContractState=10
	List<ContractList> getUnsignedContract(int uID); // 获取UID后，显示该UID作为摘牌方的，未确认的合同列

	// 已签约===》作为挂牌方，上传的合同即为已签约////双方都已签订合同（共2种）
	// 1.作为挂牌方合同刚上传。
	// 1.1即source=1（卖方挂牌），uid=tb_seller_info.uid（卖方挂牌表），listNo=tb_seller_info.sNumber（卖方挂牌交易表），ContractState=10
	// 1.2或====》source=2（买方挂牌），uid=tb_purch_info.uid（买方挂牌表），listNo=tb_purch_info.sNumber（买方挂牌交易表），ContractState=10
	List<ContractList> getSignedContract(int uID);// 获取UID后，显示该UID所有已签约的合同列

	// 2.双方都已确认
	// 即ConstractState=11
	List<ContractList> getAllSignedContract(int uID);

	// 获取为上传的合同
	List<ContractList> getUnupdateContract(int uID);

	// 将合同状态改为11
	int modifyContractStateInto11(String tradeNo);

	// 将合同状态改为01
	int modifyContractStateInto01(String tradeNo, String contract);

	// 插入一条默认合同数据(获取listNo/delistNo,state=00)
	int addContract(String tradeNo, int delistNo, int listNo, String source);

	// 上传合同文件
	int modifyContractFile(String tradeNo, String contract);

	// 查找用户对这比交易是摘牌方还是挂牌方
	// select结果不为null，则是挂牌方，反之则为摘牌方
	ContractList checkIdentify(int uID, String tradeNo);

	// 向摘牌方展示合同
	public Contract getContractDetails(String tradeNo);

	// 用户取消删除合同的全部数据
	public int removeAllContract(String tradeNo);

	String queryContractState(String tradeNo);

	int modifyContractState(String contractState, String tradeNo);

	List<ContractList> queryContractList(Login_Info trader, String orderClass, String orderSource, String orderState);
}
