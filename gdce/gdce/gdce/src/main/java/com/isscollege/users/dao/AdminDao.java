package com.isscollege.users.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isscollege.users.entity.Admin;

@Mapper
public interface AdminDao {

	// 登录
	@Select("select * from tb_admin where adminName=#{adminName} and adminPass=#{adminPass}")
	public Admin login(Admin admin);

	// 插入管理员
	@Insert("insert into tb_admin(adminName, adminPass, adminRealName, adminTelephone)"
			+ "values (#{adminName},#{adminPass},#{adminRealName},#{adminTelephone})")
	int insertAdmin(Admin admin);

	// 通过id删除管理员
	@Delete("Delete from tb_admin where adminID=#{adminID}")
	int deleteAdminByAdminID(Integer adminID);

	// 通过id查找管理员
	@Select("select * from tb_admin where adminID=#{adminID}")
	Admin selectAdminByAdminID(int adminID);

	@Select("select * from tb_admin")
	List<Admin> getAllAdminInfo();

	@Select("select * from tb_admin,tb_admin_role where tb_admin.adminID=tb_admin_role.adminID AND tb_admin.adminID= #{adminID}")
	Admin getAdminWithRoleIDByAdminID(Integer adminID);

	// 查询除了root管理员外的所有的管理员
	@Select("select * from tb_admin as am, tb_role as rl, "
			+ "tb_admin_role as ar where rl.roleName!='超级管理员'"
			+ " and am.adminID=ar.adminID and ar.roleID=rl.roleID")
	List<Admin> selectAllAdminExceptRoot();

	// 根据管理员名字查询其id
	@Select("select adminID from tb_admin where adminName=#{adminName}")
	Integer selectAdminIDByAdminName(String adminName);
}
