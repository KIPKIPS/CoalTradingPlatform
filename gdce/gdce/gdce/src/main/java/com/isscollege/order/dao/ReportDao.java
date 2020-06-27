package com.isscollege.order.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isscollege.order.entity.ReportInfo;
import com.isscollege.order.entity.ReportData;

@Mapper
public interface ReportDao {
	
	//查询报表chart中的数据，煤种、总量
	@Select("SELECT coalType,SUM(quantity)AS quantity FROM "
			+ "(SELECT coalType,SUM(quantity) AS quantity FROM view_order_details_purch "
			+ "WHERE orderDate > #{arg0} AND orderDate <= #{arg1} GROUP BY coalType "
			+ "UNION SELECT coalType,SUM(quantity) AS quantity FROM view_order_details_seller "
			+ "WHERE orderDate > #{arg0} AND orderDate <= #{arg1} GROUP BY coalType) report_data GROUP BY coaltype;")
	public ArrayList<ReportData> getReportDatas(String minDate,String maxDate);
	
	//查询报表表格中的数据，煤种、总量、最早交易日期、最晚交易日期
	@Select("SELECT coalType,SUM(quantity) AS quantity,SUM(money) AS money,MIN(minDate) AS minDate,MAX(maxDate) AS maxDate "
			+ "FROM (SELECT coalType,SUM(quantity) AS quantity,SUM(money) AS money,MIN(orderDate) AS minDate,MAX(orderDate) AS MaxDate "
			+ "FROM view_order_details_purch GROUP BY coalType "
			+ "UNION SELECT coalType,SUM(quantity) AS quantity,SUM(money) AS money,MIN(orderDate) AS minDate,MAX(orderDate) AS MaxDate "
			+ "FROM view_order_details_seller GROUP BY coalType) report_data GROUP BY coaltype ORDER BY quantity DESC;")
	public ArrayList<ReportInfo> getReportInfos();
}
