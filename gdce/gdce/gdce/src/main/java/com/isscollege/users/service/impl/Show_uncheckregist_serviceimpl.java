package com.isscollege.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.users.dao.regist_check_Dao;
import com.isscollege.users.entity.Uncheck_regist;
import com.isscollege.users.service.Show_uncheckregist_service;

@Service
public class Show_uncheckregist_serviceimpl implements Show_uncheckregist_service {// service接口实现类

	@Autowired
	private regist_check_Dao check_Dao;

	@Override
	public List<Uncheck_regist> show() {
		return check_Dao.list_uncheck_user();
	}

	@Override
	public Uncheck_regist ShowOne(int uid) {
		return check_Dao.show_uncheck_user(uid);
	}

	@Override
	public int pass(int uid) {
		return check_Dao.pass(uid);
	}

	@Override
	public int NoPass(int uid, String uopinion) {
		return check_Dao.NoPass(uid, uopinion);
	}

	@Override
	public String show_uncheck_user_file_cBusinessLicense(int uid) {
		return check_Dao.show_uncheck_user_file_cBusinessLicense(uid);
	}

	@Override
	public String show_uncheck_user_file_cTax(int uid) {

		return check_Dao.show_uncheck_user_file_cTax(uid);
	}

	@Override
	public String show_uncheck_user_file_cOrg(int uid) {
		return check_Dao.show_uncheck_user_file_cOrg(uid);
	}

	@Override
	public String show_uncheck_user_file_cBank(int uid) {

		return check_Dao.show_uncheck_user_file_cBank(uid);
	}

	@Override
	public String show_uncheck_user_file_cLegalPerson(int uid) {
		return check_Dao.show_uncheck_user_file_cLegalPerson(uid);
	}

	@Override
	public String show_uncheck_user_file_cPermission(int uid) {
		return check_Dao.show_uncheck_user_file_cPermission(uid);
	}

	@Override
	public String selectuname(int uid) {
		return check_Dao.selectuname(uid);
	}

}
