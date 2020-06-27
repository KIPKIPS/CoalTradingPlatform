/**
 * 
 */
package com.isscollege.users.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.users.entity.Admin;
import com.isscollege.users.entity.Role;

/**
 * @author whg
 *
 */
@Mapper
public interface AdminRoleDao {
	//根据权限id查询所有管理员
	@Select("select a.* from tb_admin_role as ar, tb_admin as a"
			+ " where ar.roleID=#{roleID} and ar.adminID=a.adminID")
	List<Admin> selectAllAdminByRoleID(Integer roleID);
	
	//根据管理员id查询权限
	@Select("select r.* from tb_admin_role as ar, tb_role as r"
			+ " where ar.adminID=#{adminID} and ar.roleID=r.roleID")
	Role selectRoleByAdminID(Integer adminID);
	
	//根据权限id和管理员id修改管理员权限
	@Update("update tb_admin_role set roleID=#{roleID} "
			+ "where adminID=#{adminID}")
	int updateAdminRoleByAdminIDRoleID(@Param("adminID")Integer adminID,
			@Param("roleID")Integer roleID);
	
	//添加管理员权限id映射
	@Insert("insert into tb_admin_role(adminID, roleID)"
			+ " values(#{adminID},#{roleID})")
	int insertAdminRole(@Param("adminID")Integer adminID, @Param("roleID")Integer roleID);
	
	//删除管理员权限id映射
	@Delete("delete from tb_admin_role where adminID=#{adminID}")
	int deleteAdminRoleByAdminID(Integer adminID);
}
