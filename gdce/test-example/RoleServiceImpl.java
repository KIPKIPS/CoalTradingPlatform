/**
 * 
 */
package com.isscollege.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
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

	public RoleServiceImpl(RoleDao repository2) {
		// TODO Auto-generated constructor stub
		repository = repository2;
	}

	/* (non-Javadoc)
	 * @see com.isscollege.users.service.IRoleService#queryRoleByRoleID(java.lang.Integer)
	 */
	@Override
	public Role queryRoleByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return repository.SelectRoleByRoleID(roleID);
	}

}
