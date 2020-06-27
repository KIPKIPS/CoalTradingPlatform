package com.isscollege.logistic.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.logistic.service.LogisticService;
import com.isscollege.order.dao.ReceiptDao;

/**
 * @author whg
 *	
 */
@Service
public class LogisticServiceImpl implements LogisticService{
	private Logger logger = org.slf4j.LoggerFactory.getLogger(LogisticServiceImpl.class);
	@Autowired
	private ReceiptDao receiptDao;
	
	//获取所有给定用户id的所有作为买方和卖方的订单id
	@Override
	public List<String> getTradeIDByUID(Integer uID) {		
		List<String> list = new ArrayList<String>();
		list.addAll(receiptDao.getPurchtradeNoByuID(uID));
		logger.info("-----------------------"+list.size()+"-------------------------");
		list.addAll(receiptDao.getSellertradeNoByuID(uID));
		logger.info("-----------------------"+list.size()+"-------------------------");
		list.addAll(receiptDao.getListNoByuID(uID));
		logger.info("-----------------------"+list.size()+"-------------------------");
		return  list;
	}

}
