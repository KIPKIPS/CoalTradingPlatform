/**
 * 只能根据id查询权限和查询所有权限
 */
package com.isscollege.users.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isscollege.users.entity.Role;

/**
 * @author whg
 *
 */
@Mapper
public interface RoleDao {
	//查询所有权限
	@Select("Select * from tb_role")
	List<Role> selectAllRoles();
	
	//据id查询权限
	@Select("Select * from tb_role where roleID=#{roleID}")
	Role SelectRoleByRoleID(int roleID);
}
