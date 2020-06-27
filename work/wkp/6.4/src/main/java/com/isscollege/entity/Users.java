package com.isscollege.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String username;
	private String password;
	private String sex;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", sex=" + sex + "]";
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Integer userid, String username, String password, String sex) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

}