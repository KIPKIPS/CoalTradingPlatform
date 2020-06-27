package com.isscollege.waybill.service;

import java.sql.Timestamp;
import java.util.List;

import com.isscollege.waybill.entity.tb_waybills_entity;

public interface show_transpoting_service {

	public List<tb_waybills_entity> ShowList();

	public tb_waybills_entity showOne(int uid);

	public int arrive(int uid, Timestamp ArriveTime);
}
