package com.isscollege.information.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * tb_news.nID (资讯编号)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
	private Integer nID;

	/**
	 * tb_news.nEditorID (资讯编辑员编号)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
	private Integer nEditorID;

	/**
	 * tb_news.nTheme (资讯标题)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
	private String nTheme;

	/**
	 * tb_news.nContent (资讯内容)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
	private String nContent;

	/**
	 * tb_news.nTime (资讯发布时间)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp nTime;

	/**
	 * tb_news.nState (资讯审核状态（0为未审核，1为审核通过）)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
	private String nState;

	/**
	 * tb_news.nPublisherID (资讯审核员编号)
	 * 
	 * @ibatorgenerated 2019-06-17 10:27:27
	 */
	private Integer nPublisherID;

	public Integer getnID() {
		return nID;
	}

	public void setnID(Integer nID) {
		this.nID = nID;
	}

	public Integer getnEditorID() {
		return nEditorID;
	}

	public void setnEditorID(Integer nEditorID) {
		this.nEditorID = nEditorID;
	}

	public String getnTheme() {
		return nTheme;
	}

	public void setnTheme(String nTheme) {
		this.nTheme = nTheme;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnTime() {
		return nTime;
	}

	public void setnTime(Timestamp nTime) {
		this.nTime = nTime;
	}

	public String getnState() {
		return nState;
	}

	public void setnState(String nState) {
		this.nState = nState;
	}

	public Integer getnPublisherID() {
		return nPublisherID;
	}

	public void setnPublisherID(Integer nPublisherID) {
		this.nPublisherID = nPublisherID;
	}

	@Override
	public String toString() {
		return "News [nID=" + nID + ", nEditorID=" + nEditorID + ", nTheme=" + nTheme + ", nContent=" + nContent
				+ ", nTime=" + nTime + ", nState=" + nState + ", nPublisherID=" + nPublisherID + "]";
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(Integer nID, Integer nEditorID, String nTheme, String nContent, Timestamp nTime, String nState,
			Integer nPublisherID) {
		super();
		this.nID = nID;
		this.nEditorID = nEditorID;
		this.nTheme = nTheme;
		this.nContent = nContent;
		this.nTime = nTime;
		this.nState = nState;
		this.nPublisherID = nPublisherID;
	}

}
