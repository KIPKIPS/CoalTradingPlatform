package com.isscollege.waybill.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.waybill.dao.show_transporting_dao;
import com.isscollege.waybill.entity.tb_waybills_entity;
import com.isscollege.waybill.service.show_transpoting_service;

@Service
public class show_transporting_serviceimpl implements show_transpoting_service {

	@Autowired
	show_transporting_dao TransDao;

	@Override
	public List<tb_waybills_entity> ShowList() {
		return TransDao.list_transporting_bill();
	}

	@Override
	public tb_waybills_entity showOne(int uid) {
		return TransDao.one_transporting(uid);
	}

	@Override
	public int arrive(int uid, Timestamp ArriveTime) {
		return TransDao.arrive(ArriveTime, uid);
	}

}
