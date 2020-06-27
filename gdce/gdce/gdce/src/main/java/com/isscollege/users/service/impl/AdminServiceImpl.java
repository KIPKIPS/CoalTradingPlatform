package com.isscollege.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.isscollege.users.dao.AdminDao;
import com.isscollege.users.dao.AdminRoleDao;
import com.isscollege.users.entity.Admin;
import com.isscollege.users.entity.Role;
import com.isscollege.users.service.IAdminService;
import com.isscollege.users.utils.MD5;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminRoleDao adminRoleDao;

	// ��¼
	@Override
	public Admin login(Admin admin) {
		String newPass = new MD5().getMD5ofStr(admin.getAdminPass());
		admin.setAdminPass(newPass);
		return adminDao.login(admin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.isscollege.users.service.IAdminService#addAdmin()
	 */
	@Override
	@Transactional(isolation = Isolation.DEFAULT)
	public Integer addAdmin(Admin admin, Role role) {
		// TODO Auto-generated method stub
		adminDao.insertAdmin(admin);
		return adminRoleDao.insertAdminRole(adminDao.selectAdminIDByAdminName(admin.getAdminName()), role.getRoleID());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.isscollege.users.service.IAdminService#removeAdmin()
	 */
	@Override
	@Transactional
	public int removeAdmin(Integer adminID) {
		// TODO Auto-generated method stub
		adminRoleDao.deleteAdminRoleByAdminID(adminID);
		return adminDao.deleteAdminByAdminID(adminID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.isscollege.users.service.IAdminService#queryAdmin()
	 */
	@Override
	public Admin queryAdminByAdminID(Integer adminID) {
		// TODO Auto-generated method stub
		return adminDao.selectAdminByAdminID(adminID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.isscollege.users.service.IAdminService#queryAllAdmin()
	 */
	@Override
	public List<Admin> queryAllAdmin() {
		// TODO Auto-generated method stub
		return adminDao.selectAllAdminExceptRoot();
	}

	@Override
	public Admin getAdminById(Integer adminID) {
		return adminDao.selectAdminByAdminID(adminID);
	}

	@Override
	public Admin getAdminWithRoleIdById(Integer adminID) {
		return adminDao.getAdminWithRoleIDByAdminID(adminID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.isscollege.users.service.IAdminService#queryAdminName(java.lang.
	 * String) true for exist while false for not.
	 */
	@Override
	public boolean queryAdminName(String name) {
		// TODO Auto-generated method stub
		return adminDao.selectAdminIDByAdminName(name) != null ? true : false;
	}

}
