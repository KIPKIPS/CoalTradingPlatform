/**
 * 权限服务实现类
 */
package com.isscollege.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.users.dao.AdminRoleDao;
import com.isscollege.users.entity.Role;
import com.isscollege.users.service.IAdminRoleService;

/**
 * @author whg
 *
 */
@Service
public class AdminRoleServiceImpl implements IAdminRoleService {
	@Autowired
	private AdminRoleDao repository;

	/* (non-Javadoc)
	 * @see com.isscollege.users.service.IRoleService#modifyAdminRole(com.isscollege.users.entity.Admin, java.lang.String)
	 */
	@Override
	public int modifyAdminRole(Integer adminID, Integer roleID) {
		// TODO Auto-generated method stub
		return repository.updateAdminRoleByAdminIDRoleID(adminID,
				roleID);
	}

	/* (non-Javadoc)
	 * @see com.isscollege.users.service.IAdminRoleService#queryRoleByAdminID(java.lang.Integer)
	 */
	@Override
	public Role queryRoleByAdminID(Integer adminID) {
		// TODO Auto-generated method stub
		return repository.selectRoleByAdminID(adminID);
	}

	/* (non-Javadoc)
	 * @see com.isscollege.users.service.IAdminRoleService#deleteAdminRoleByAdminID(java.lang.Integer)
	 */
	@Override
	public int deleteAdminRoleByAdminID(Integer adminID) {
		// TODO Auto-generated method stub
		return repository.deleteAdminRoleByAdminID(adminID);
	}

}
