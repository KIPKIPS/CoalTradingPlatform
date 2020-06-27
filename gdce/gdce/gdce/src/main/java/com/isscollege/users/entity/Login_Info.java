package com.isscollege.users.entity;

import java.io.Serializable;

public class Login_Info implements Serializable {
	private static final long serialVersionUID = 1L;
	private int uID;
	private String uName;
	private String uPass;
	private String loginState;
	// 新增uState
	private String uState;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Login_Info [uID=" + uID + ", uName=" + uName + ", uPass=" + uPass + ", loginState=" + loginState
				+ ", uState=" + uState + "]";
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}

	public String getuState() {
		return uState;
	}

	public void setuState(String uState) {
		this.uState = uState;
	}

	public Login_Info(int uID, String uName, String uPass, String loginState, String uState) {
		super();
		this.uID = uID;
		this.uName = uName;
		this.uPass = uPass;
		this.loginState = loginState;
		this.uState = uState;
	}

	public Login_Info() {
		super();
	}
}
