package com.isscollege.delisting.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DelistDao {

	// 根据卖家挂牌编号查询是否已经被摘牌
	@Select("select * from tb_transaction where listNo=#{Number} AND source = '1'")
	public String isExist_sell_transaction(int Number);

	// 根据买家挂牌编号查询是否已经被摘牌
	@Select("select * from tb_transaction where listNo=#{Number} AND source = '2'")
	public String isExist_purch_transaction(int Number);

	// 添加信息到tb_transaction表
	@Insert("insert into tb_transaction(delistNo,listNo) value(#{uID},#{Number})")
	public int addInfo_to_tb_transaction(int uID, int Number);

}
