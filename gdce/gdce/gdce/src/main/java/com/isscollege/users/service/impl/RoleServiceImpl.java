/**
 * 
 */
package com.isscollege.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.users.dao.RoleDao;
import com.isscollege.users.entity.Role;
import com.isscollege.users.service.IRoleService;

/**
 * @author whg
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleDao repository;

	/* (non-Javadoc)
	 * @see com.isscollege.users.service.IRoleService#queryRoleByRoleID(java.lang.Integer)
	 * 通过权限id查询权限内容
	 */
	@Override
	public Role queryRoleByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return repository.SelectRoleByRoleID(roleID);
	}

	/* (non-Javadoc)
	 * @see com.isscollege.users.service.IRoleService#queryAllRole()
	 * 查询所有权限
	 */
	@Override
	public List<Role> queryAllRole() {
		// TODO Auto-generated method stub
		return repository.selectAllRoles();
	}
	
	

}
