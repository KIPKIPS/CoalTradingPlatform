package com.isscollege.delisting.service.impl;

public interface IDelistService {

	// 根据买家挂牌编号查询是否已经被摘牌
	public String isExist_purch_transaction(int Number);

	// 根据卖家挂牌编号查询是否已经被摘牌
	public String isExist_sell_transaction(int Number);

	// 添加信息到transaction表
	public int addInfo_to_tb_transaction(int uID, int Number);

}
