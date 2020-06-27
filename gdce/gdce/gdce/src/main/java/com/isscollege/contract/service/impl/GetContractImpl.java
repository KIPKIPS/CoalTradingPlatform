package com.isscollege.contract.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.contract.dao.GetSignedContractDao;
import com.isscollege.contract.entity.Contract;
import com.isscollege.contract.entity.ContractList;
import com.isscollege.contract.service.IGetContract;
import com.isscollege.users.entity.Login_Info;

@Service
public class GetContractImpl implements IGetContract {
	@Autowired
	private GetSignedContractDao getContractDao;

	// 单元测试
	public GetContractImpl(GetSignedContractDao getContractDao2) {
		getContractDao = getContractDao2;
	}

	@Override
	public List<ContractList> getUnsignedContract(int uID) {
		return getContractDao.getUnsignedContract(uID);
	}

	@Override
	public List<ContractList> getSignedContract(int uID) {
		return getContractDao.getSignedContract(uID);
	}

	@Override
	public List<ContractList> getAllSignedContract(int uID) {
		return getContractDao.getAllSignedContract(uID);
	}

	@Override
	public List<ContractList> getUnupdateContract(int uID) {
		return getContractDao.getUnupdateContract(uID);
	}

	@Override
	public int addContract(String tradeNo, int delistNo, int listNo, String source) {
		return getContractDao.addContract(tradeNo, delistNo, listNo, source);
	}

	@Override
	public int modifyContractFile(String tradeNo, String contract) {
		return getContractDao.modifyContractFile(tradeNo, contract);
	}

	@Override
	public ContractList checkIdentify(int uID, String tradeNo) {
		return getContractDao.checkIdentify(uID, tradeNo);
	}

	@Override
	public int modifyContractStateInto11(String tradeNo) {
		//System.out.println("订单状态" + getContractDao.modifyContractStateInto11(tradeNo));
		return getContractDao.modifyContractStateInto11(tradeNo);
	}

	@Override
	public int modifyContractStateInto01(String tradeNo, String contract) {
		return getContractDao.modifyContractStateInto01(tradeNo, contract);
	}

	@Override
	public Contract getContractDetails(String tradeNo) {
		return getContractDao.getContractDetails(tradeNo);
	}

	@Override
	public int removeAllContract(String tradeNo) {
		return getContractDao.removeAllContract(tradeNo);
	}

	// 查询合同状态
	@Override
	public String queryContractState(String tradeNo) {
		return getContractDao.queryContractState(tradeNo);
	}

	// 修改合同状态
	@Override
	public int modifyContractState(String contractState, String tradeNo) {
		return getContractDao.modifyContractState(contractState, tradeNo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.isscollege.contract.service.IGetContract#queryContractList(com.
	 * isscollege.users.entity.Login_Info, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<ContractList> queryContractList(Login_Info trader, String orderClass, String orderSource,
			String orderState) {
		if (orderClass.equals("buy")) {
			if (orderSource.equals("list")) {
				// 买方挂牌合同
				return getContractDao.queryContractList_list_purch(trader.getuID(), "2", orderState);
			} else {
				// 买方摘牌合同
				return getContractDao.queryContractList_delist_purch(trader.getuID(), "1", orderState);
			}
		} else {
			if (orderSource.equals("list")) {
				// 卖方挂牌合同
				return getContractDao.queryContractList_list_seller(trader.getuID(), "1", orderState);
			} else {
				// 卖方摘牌合同
				return getContractDao.queryContractList_delist_seller(trader.getuID(), "2", orderState);
			}
		}
	}

}
