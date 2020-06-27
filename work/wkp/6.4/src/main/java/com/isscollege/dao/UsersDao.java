package com.isscollege.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.entity.Users;

@Mapper // 标记当前类为功能映射文件--就相当于daoimpl
public interface UsersDao {
	@Insert("insert into users (username,password,sex) values (#{username},#{password},#{sex})")
	@Options(useGeneratedKeys = true, keyProperty = "userid")
	int insert(Users user);

	@Select("select * from users where username=#{username} and password=#{password}")
	Users login(Users user);

	@Select("select * from users")
	List<Users> getAllUsers();

	@Delete("delete from users where userid=#{userid}")
	int removeUserById(int userid);

	@Update("update users set password=#{password} where userid=#{userid}")
	int updateUser_pass(Users user);

	@Select("select * from users where userid=#{userid}")
	Users getUserById(Users user);

}