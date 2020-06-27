package com.isscollege.users.entity;

import java.io.Serializable;

public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cQuestionID;
	private String cQuestion;
	private String cAnswer;
	private int uID;
	@Override
	public String toString() {
		return "Question [cQuestionID=" + cQuestionID + ", cQuestion=" + cQuestion + ", cAnswer=" + cAnswer + ", uID="
				+ uID + "]";
	}
	public int getcQuestionID() {
		return cQuestionID;
	}
	public void setcQuestionID(int cQuestionID) {
		this.cQuestionID = cQuestionID;
	}
	public String getcQuestion() {
		return cQuestion;
	}
	public void setcQuestion(String cQuestion) {
		this.cQuestion = cQuestion;
	}
	public String getcAnswer() {
		return cAnswer;
	}
	public void setcAnswer(String cAnswer) {
		this.cAnswer = cAnswer;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param cQuestion
	 * @param cAnswer
	 * @param uID
	 */
	public Question(String cQuestion, String cAnswer, int uID) {
		super();
		this.cQuestion = cQuestion;
		this.cAnswer = cAnswer;
		this.uID = uID;
	}
	
	 
	public Question() {
		
	}

}
