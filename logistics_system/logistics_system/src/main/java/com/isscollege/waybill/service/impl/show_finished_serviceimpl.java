package com.isscollege.waybill.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.waybill.dao.show_finished_dao;
import com.isscollege.waybill.entity.tb_waybills_entity;
import com.isscollege.waybill.service.show_finished_service;

@Service
public class show_finished_serviceimpl implements show_finished_service {

	@Autowired
	show_finished_dao FinishedDao;

	@Override
	public List<tb_waybills_entity> ShowList() {
		return FinishedDao.list_finished_bill();
	}

	@Override
	public tb_waybills_entity showOne(int uid) {
		return FinishedDao.one_finished(uid);
	}

	@Override
	public int arrive(int uid, Timestamp ArriveTime) {
		return FinishedDao.arrive(ArriveTime, uid);
	}

}
