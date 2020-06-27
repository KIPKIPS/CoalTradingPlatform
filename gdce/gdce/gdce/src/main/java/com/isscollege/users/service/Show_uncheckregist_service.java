package com.isscollege.users.service;

import java.util.List;

import com.isscollege.users.entity.Uncheck_regist;

public interface Show_uncheckregist_service {// service接口
	public List<Uncheck_regist> show();

	public Uncheck_regist ShowOne(int uid);

	public int pass(int uid);

	public int NoPass(int uid, String uopinion);

	public String show_uncheck_user_file_cBusinessLicense(int uid);

	public String show_uncheck_user_file_cTax(int uid);

	public String show_uncheck_user_file_cOrg(int uid);

	public String show_uncheck_user_file_cBank(int uid);

	public String show_uncheck_user_file_cLegalPerson(int uid);

	public String show_uncheck_user_file_cPermission(int uid);

	public String selectuname(int uid);
}
