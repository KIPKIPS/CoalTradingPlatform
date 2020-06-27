package com.isscollege.users.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isscollege.users.entity.Finance;

@Mapper
public interface FinanceDao {
	// 管理员登录
	@Select("select * from tb_finance where muAccount=#{muAccount} and muPass=#{muPass}")
	public Finance login(Finance finance);
}
