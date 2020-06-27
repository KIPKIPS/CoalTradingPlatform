package com.isscollege.users.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer adminID;
	private String adminName;
	private String adminPass;
	private String adminRealName;
	private String adminTelephone;
	private Integer roleID;

	public Admin(Integer adminID, String adminName, String adminPass, String adminRealName, String adminTelephone,
			Integer roleID) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.adminPass = adminPass;
		this.adminRealName = adminRealName;
		this.adminTelephone = adminTelephone;
		this.roleID = roleID;
	}

	public Admin(String adminName, String adminPass) {
		super();
		this.adminName = adminName;
		this.adminPass = adminPass;
	}

	public Admin(String adminName, String adminPass, String adminRealName, String adminTelephone) {
		super();
		this.adminName = adminName;
		this.adminPass = adminPass;
		this.adminRealName = adminRealName;
		this.adminTelephone = adminTelephone;
	}

	public Admin(Integer adminID, String adminName, String adminPass, String adminRealName, String adminTelephone) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.adminPass = adminPass;
		this.adminRealName = adminRealName;
		this.adminTelephone = adminTelephone;
	}

	/**
	 * @return the roleID
	 */
	public Integer getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID
	 *            the roleID to set
	 */
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the adminID
	 */
	public Integer getAdminID() {
		return adminID;
	}

	/**
	 * @param adminID
	 *            the adminID to set
	 */
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName
	 *            the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the adminPass
	 */
	public String getAdminPass() {
		return adminPass;
	}

	/**
	 * @param adminPass
	 *            the adminPass to set
	 */
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	/**
	 * @return the adminRealName
	 */
	public String getAdminRealName() {
		return adminRealName;
	}

	/**
	 * @param adminRealName
	 *            the adminRealName to set
	 */
	public void setAdminRealName(String adminRealName) {
		this.adminRealName = adminRealName;
	}

	/**
	 * @return the adminTelephone
	 */
	public String getAdminTelephone() {
		return adminTelephone;
	}

	/**
	 * @param adminTelephone
	 *            the adminTelephone to set
	 */
	public void setAdminTelephone(String adminTelephone) {
		this.adminTelephone = adminTelephone;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", adminPass=" + adminPass
				+ ", adminRealName=" + adminRealName + ", adminTelephone=" + adminTelephone + ", roleID=" + roleID
				+ "]";
	}
	
	//admin对象的所有属性hashcode和
	@Override
	public int hashCode() {
		return (adminID==null?0:adminID.hashCode())
				+ (adminName==null?0:adminName.hashCode())
				+ (adminPass==null?0:adminPass.hashCode())
				+ (adminTelephone==null?0:adminTelephone.hashCode())
				+ (adminRealName==null?0:adminRealName.hashCode())
				+ (roleID==null?0:roleID.hashCode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object) 属性值都相等才返回true
	 */
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		Admin admin = (Admin) o;
		if ((admin.adminID.equals(adminID)) && admin.adminName.equals(this.adminName)
				&& admin.adminPass.equals(this.adminPass) && admin.adminRealName.equals(this.adminRealName)
				&& admin.adminTelephone.equals(this.adminTelephone))
			return true;
		return false;
	}

}
