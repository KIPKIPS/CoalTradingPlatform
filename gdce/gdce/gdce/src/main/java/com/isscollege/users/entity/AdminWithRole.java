package com.isscollege.users.entity;

import javax.persistence.Entity;

/**
 * @author whg
 *
 */
//管理员权限映射类
@Entity
public class AdminWithRole{
	private Admin admin;
	private Role role;
	
	public AdminWithRole(Admin a, Role r) {
		this.admin = a;
		this.role = r;
	}
	
	public void setAdmin(Admin a) {
		this.admin = a;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void setRole(Role r) {
		this.role=r;
	}
	
	public Role getRole() {
		return role;
	}
}
