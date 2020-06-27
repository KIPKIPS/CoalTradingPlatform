/**
 * 权限服务
 */
package com.isscollege.users.service;

import com.isscollege.users.entity.Role;

/**
 * @author whg
 *
 */
public interface IAdminRoleService {
	//修改管理员权限
	int modifyAdminRole(Integer adminID, Integer roleID);
	
	//根据管理员id查询其权限
	Role queryRoleByAdminID(Integer adminID);
	
	//删除管理员权限id映射
	int deleteAdminRoleByAdminID(Integer adminID);
}
