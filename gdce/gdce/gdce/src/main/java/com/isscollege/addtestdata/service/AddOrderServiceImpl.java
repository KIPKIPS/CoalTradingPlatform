/**
 * 
 */
package com.isscollege.addtestdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.addtestdata.dao.AddTestDataAboutOrder;

/**
 * @author Apple
 *
 */
@Service
public class AddOrderServiceImpl {
	@Autowired
	private AddTestDataAboutOrder addOrderDao;

	// 通过挂牌编号、用户ID往买方挂牌表插入数据(挂牌状态为2（已下架）)
	public int addDataIntoPurch(int pNO, int uID) {
		System.out.println("通过挂牌编号、用户ID往买方挂牌表插入数据");
		return addOrderDao.addDataIntoPurch(pNO, uID);
	}

	// 通过挂牌编号、用户ID往卖方挂牌表插入数据(挂牌状态为2（已下架）)
	public int addDataIntoSeller(int sNO, int uID) {
		System.out.println(" 通过挂牌编号、用户ID往卖方挂牌表插入数据");
		return addOrderDao.addDataIntoSeller(sNO, uID);
	}

	// 通过交易编号、摘牌用户ID、挂牌编号和交易来源往交易表插入数据（合同和回执单状态均为11（双方都已确认））
	public int addDataIntoTransaction(String tradeNo, int delistNo, int listNo, String source) {
		System.out.println("通过交易编号、摘牌用户ID、挂牌编号和交易来源往交易表插入数据");
		return addOrderDao.addDataIntoTransaction(tradeNo, delistNo, listNo, source);
	}

	// 通过交易编号、摘牌用户ID、挂牌编号、合同状态和交易来源往交易表插入数据（回执单状态为11（双方都已确认））
	public int addDataIntoTransaction_contract(String tradeNo, int delistNo, int listNo, String source,
			String contractState) {
		System.out.println("通过交易编号、摘牌用户ID、挂牌编号、合同状态和交易来源往交易表插入数据");
		return addOrderDao.addDataIntoTransaction_contract(tradeNo, delistNo, listNo, source, contractState);
	}

	// 通过订单编号、交易编号和订单状态往订单表插入数据
	public int addDataIntoOrder(String orderNo, String tradeNo, String orderState) {
		System.out.println("通过订单编号、交易编号和订单状态往订单表插入数据");
		return addOrderDao.addDataIntoOrder(orderNo, tradeNo, orderState);
	}

	// 插入资讯
	public int addNews(Integer nEditorID, String nTheme, String nContent, Integer nState, Integer nPulisherID) {
		System.out.println("插入资讯");
		return addOrderDao.addNews(nEditorID, nTheme, nContent, nState, nPulisherID);
	}

	// 通过挂牌编号、用户ID往买方挂牌表插入数据(挂牌状态为1（已发布）)
	public int addDataIntoPurchS1(int pNO, int uID) {
		System.out.println("通过挂牌编号、用户ID往买方挂牌表插入数据(挂牌状态为1（已发布）)");
		return addOrderDao.addDataIntoPurchS1(pNO, uID);
	}

	// 通过挂牌编号、用户ID往卖方挂牌表插入数据(挂牌状态为1（已发布）)
	public int addDataIntoSellerS1(int sNO, int uID) {
		System.out.println("// 通过挂牌编号、用户ID往卖方挂牌表插入数据(挂牌状态为1（已发布）)");
		return addOrderDao.addDataIntoSellerS1(sNO, uID);
	}
}
