package com.isscollege.users.entity;

public class Opinion {

	private int oID;
	private int uID;
	private String uOpinion;

	public Opinion() {
		super();
	}

	public Opinion(int uID, String uOpinion) {
		super();
		this.uID = uID;
		this.uOpinion = uOpinion;
	}

	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getuOpinion() {
		return uOpinion;
	}

	public void setuOpinion(String uOpinion) {
		this.uOpinion = uOpinion;
	}

	@Override
	public String toString() {
		return "Opinion [oID=" + oID + ", uID=" + uID + ", uOpinion=" + uOpinion + "]";
	}

}
