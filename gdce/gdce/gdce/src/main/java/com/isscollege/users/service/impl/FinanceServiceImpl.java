package com.isscollege.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.users.dao.FinanceDao;
import com.isscollege.users.entity.Finance;
import com.isscollege.users.service.IFinanceService;
import com.isscollege.users.utils.MD5;

@Service
public class FinanceServiceImpl implements IFinanceService {

	@Autowired
	FinanceDao financeDao;

	// 登录
	@Override
	public Finance login(Finance finance) {
		String newPass = new MD5().getMD5ofStr(finance.getMuPass());
		finance.setMuPass(newPass);
		return financeDao.login(finance);
	}

}
