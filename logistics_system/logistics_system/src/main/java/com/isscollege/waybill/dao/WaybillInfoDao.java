package com.isscollege.waybill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.waybill.entity.WaybillInfo;

@Mapper
public interface WaybillInfoDao {
	// 插入数据 从外部获取的数据传入订单号、货源地、收货地、物流商号、物品重量
	@Insert("insert into tb_waybills(trade_id,good_source,good_destination,logistics_id,log_weight) values(#{trade_id},#{good_source},#{good_destination},#{logistics_id},#{log_weight})")
	int insertWaybillInfo(@Param("trade_id") String trade_id, @Param("good_source") String good_source,
			@Param("good_destination") String good_destination, @Param("logistics_id") int logistics_id,
			@Param("log_weight") double log_weight);

	// 通过物流商名称查询对应物流商ID
	@Select("select logistics_id from tb_logistics where lod_name = #{lod_name}")
	int getLogistics_id(@Param("lod_name") String lod_name);

	// 通过trade_id查询状态为0的信息
	@Select("select * from tb_waybills where trade_id = #{trade_id} and dis_status = 0")
	WaybillInfo getState0InfoByTradeNo(@Param("trade_id") String trade_id);

	// 通过trade_id查询状态为1的信息
	@Select("select * from tb_waybills where trade_id = #{trade_id} and dis_status = 1")
	WaybillInfo getState1InfoByTradeNo(@Param("trade_id") String trade_id);

	// 通过trade_id查询状态为2的信息
	@Select("select * from tb_waybills where trade_id = #{trade_id} and dis_status = 2")
	WaybillInfo getState2InfoByTradeNo(@Param("trade_id") String trade_id);

	// 通过运单号获取运单信息
	@Select("select * from tb_waybills where waybill_id=#{waybill_id}")
	WaybillInfo getWaybillInfoByWaybill_id(@Param("waybill_id") int waybill_id);

	// 通过运单号修改运单配送信息
	@Update("update tb_waybills set distributor =#{distributor},dis_phone=#{dis_phone},start_pos=#{start_pos},end_pos=#{end_pos},dis_status=#{dis_status},good_trs_time =#{good_trs_time} where waybill_id=#{waybill_id}")
	int modifyWaybillInfoDisInfoByWaybill_id(WaybillInfo waybillInfo);

	// 查询待确认运单信息
	@Select("select * from tb_waybills where dis_status='0'")
	List<WaybillInfo> getCheckWaybillInfo();

	// 查询已完成运单信息
	@Select("select * from tb_waybills where dis_status='2'")
	List<WaybillInfo> getFinishedWaybillInfo();

}
