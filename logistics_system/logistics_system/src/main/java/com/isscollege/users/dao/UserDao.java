package com.isscollege.users.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isscollege.users.entity.Users;

@Mapper
public interface UserDao {

	@Select("select * from tb_users where user_name=#{user_name} and password=#{password}")
	Users login(Users user);
}
