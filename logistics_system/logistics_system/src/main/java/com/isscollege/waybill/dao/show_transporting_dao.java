package com.isscollege.waybill.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.waybill.entity.tb_waybills_entity;

@Mapper
public interface show_transporting_dao {

	@Select("select * from tb_waybills where dis_status=1")
	public List<tb_waybills_entity> list_transporting_bill();

	@Select("select * from tb_waybills where waybill_id=#{waybill_id}")
	public tb_waybills_entity one_transporting(int waybill_id);

	@Update("update tb_waybills set dis_status=2,good_rec_time=#{ArriveTime} where waybill_id=#{waybill_id}")
	public int arrive(@Param(value = "ArriveTime") Timestamp ArriveTime, @Param(value = "waybill_id") int waybill_id);
}
