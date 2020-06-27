/**
 * 
 */
package com.isscollege.users.service;

import java.util.List;

import com.isscollege.users.entity.Role;

/**
 * @author whg
 *
 */
public interface IRoleService {
	Role queryRoleByRoleID(Integer roleID);
	
	List<Role> queryAllRole();
}
