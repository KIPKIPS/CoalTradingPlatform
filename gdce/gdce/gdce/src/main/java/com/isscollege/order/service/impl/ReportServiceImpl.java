package com.isscollege.order.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.order.dao.ReportDao;
import com.isscollege.order.entity.ReportData;
import com.isscollege.order.entity.ReportInfo;
import com.isscollege.order.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	ReportDao reportDao;
	
	//查询chart数据
	@Override
	public ArrayList<ReportData> getReportDatas(String minDate,String maxDate){
		return reportDao.getReportDatas(minDate, maxDate);
	}

	//查询表格数据
	@Override
	public ArrayList<ReportInfo> getReportInfos() {
		return reportDao.getReportInfos();
	}

}
