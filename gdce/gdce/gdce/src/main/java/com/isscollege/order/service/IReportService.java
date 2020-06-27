package com.isscollege.order.service;

import java.util.ArrayList;

import com.isscollege.order.entity.ReportData;
import com.isscollege.order.entity.ReportInfo;

public interface IReportService {
	
	//查询chart数据
	public ArrayList<ReportData> getReportDatas(String minDate,String maxDate);
	
	//查询表格数据
	public ArrayList<ReportInfo> getReportInfos();
}
