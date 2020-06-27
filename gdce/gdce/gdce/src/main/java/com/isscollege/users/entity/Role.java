/**
 * 权限实体类
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
public class Role implements Serializable{
	private static final long serialVersionUID = 4153327541813L;
	
	private int roleID;
	private String roleName;
	
	public Role() {
		super();
	}
	
	public Role(int roleID, String roleName) {
		this.roleID = roleID;
		this.roleName = roleName;
	}
	
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	//所有属性hashcode和
	@Override
	public int hashCode() {
		return roleID
				+ (roleName==null? 0:roleName.hashCode());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 当且仅当id与权限信息均相等才返回ture
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;

		Role role = (Role)o;
		if(role.getRoleID()==this.roleID &&
				role.getRoleName().equalsIgnoreCase(roleName))
			return true;
		return false;
	}
}
