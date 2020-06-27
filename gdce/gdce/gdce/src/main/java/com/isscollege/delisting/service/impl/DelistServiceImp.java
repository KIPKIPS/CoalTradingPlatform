package com.isscollege.delisting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.delisting.dao.DelistDao;

@Service
public class DelistServiceImp implements IDelistService {
	@Autowired
	DelistDao delistdao;

	@Override
	public String isExist_purch_transaction(int Number) {
		return delistdao.isExist_purch_transaction(Number);
	}

	@Override
	public int addInfo_to_tb_transaction(int uID, int Number) {
		return delistdao.addInfo_to_tb_transaction(uID, Number);
	}

	@Override
	public String isExist_sell_transaction(int Number) {
		return delistdao.isExist_sell_transaction(Number);
	}
}
