/**
 * 
 */
package com.isscollege.waybill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CarriageDao {

	// 根据运单号waybill_id查询得到货物起始位置
	@Select("select start_pos from tb_waybills where waybill_id = #{waybill_id}")
	public String get_start_pos(@Param("waybill_id") int waybill_id);

	// 根据运单号waybill_id查询得到货物终止位置
	@Select("select end_pos from tb_waybills where waybill_id = #{waybill_id}")
	public String get_end_pos(@Param("waybill_id") int waybill_id);

	// 查tb_distance表得到距离distance
	@Select("select distance from tb_distance where start_end_pos = #{start_end_pos} or start_end_pos = #{start_end_pos1}")
	public double get_distance(@Param("start_end_pos") String start_end_pos,
			@Param("start_end_pos1") String start_end_pos1);

	// 通过运单号查询得到货物重量
	@Select("select log_weight from tb_waybills where waybill_id = #{waybill_id}")
	public int get_log_weight(@Param("waybill_id") int waybill_id);

	// 通过运单号查询运输单价
	@Select("select a.carriage from tb_logistics as a,tb_waybills as b where b.logistics_id = a.logistics_id and b.waybill_id = #{waybill_id}")
	public double get_carriage_by_wid(@Param("waybill_id") int waybill_id);

	// 更新总运费sum_carriage
	@Update("update tb_waybills set sum_carriage = (#{sum_carriage}) where waybill_id = #{waybill_id}")
	public int modify_sum_carriage_by_wid(@Param("sum_carriage") double sum_carriage,
			@Param("waybill_id") int waybill_id);

}
