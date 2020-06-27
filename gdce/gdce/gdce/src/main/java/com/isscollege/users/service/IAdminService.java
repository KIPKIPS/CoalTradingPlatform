package com.isscollege.users.service;

import java.util.List;

import com.isscollege.users.entity.Admin;
import com.isscollege.users.entity.Role;
//管理员服务接口
public interface IAdminService {
	public abstract Integer addAdmin(Admin admin, Role role);

	public abstract int removeAdmin(Integer AdminID);

	public abstract Admin queryAdminByAdminID(Integer AdminID);

	public abstract List<Admin> queryAllAdmin();

	// true for exist while false for not.
	public abstract boolean queryAdminName(String name);

	// 登录
	public abstract Admin login(Admin admin);

	public abstract Admin getAdminById(Integer adminID);

	public abstract Admin getAdminWithRoleIdById(Integer adminID);

}
