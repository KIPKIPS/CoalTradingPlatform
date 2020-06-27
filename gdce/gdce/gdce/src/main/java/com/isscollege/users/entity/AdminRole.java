/**
 * 
 */
package com.isscollege.users.entity;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author whg
 *
 */
//权限实体类
@Entity
public class AdminRole implements Serializable {
	private static final long serialVersionUID = 1245332523L;
		
	private Integer adminID;
	private Integer roleID;
	
	public AdminRole(Integer adminID, Integer roleID) {
		this.adminID=adminID;
		this.roleID=roleID;
	}
	
	public AdminRole() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

}
