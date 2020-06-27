package com.isscollege.order.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isscollege.order.entity.ReportData;
import com.isscollege.order.entity.ReportInfo;
import com.isscollege.order.service.impl.ReportServiceImpl;

@Controller
@RequestMapping("report")
public class ReportController {
	
	@Autowired
	ReportServiceImpl reportServiceImpl;
	//初始化煤种信息
	ArrayList<String> coalTypes = new ArrayList<String>(Arrays.asList("无烟煤","烟煤","褐煤","贫瘦煤","其他"));
	ArrayList<ReportData> rdList = null;
	ArrayList<ReportInfo> rfList = null;

	//从数据库查询煤种销售信息，传递给reportTable.jsp,制作销售总量图表
	@RequestMapping("/table")
	public ModelAndView reportTable(ModelAndView mv){
		//添加视图
		mv.setViewName("reportTable");
		//添加煤种信息列表
		mv.addObject("coalTypes", coalTypes);
		//添加查询结果：煤炭交易信息
		rfList = reportServiceImpl.getReportInfos();
		//处理销量为0的结果，即查询结果中没有该煤种
		int flag=0;
		for(String coalType:coalTypes){
			flag=0;
			for(ReportInfo orderCount:rfList){
				if(coalType.equals(orderCount.getCoalType())){
					flag=1;
					break;
				}
			}
			if(flag==0){
				rfList.add(new ReportInfo(coalType,0,0,null,null));
			}
		}
		mv.addObject("rfList",rfList);
		return mv;
	}
	//查询时间范围和煤种销售总量,制作统计图
	@RequestMapping("/chart")
	public ModelAndView reportChart(ModelAndView mv){
		
		//设定查询时间跨度为十年，拼接最早时间，最晚时间（今天）字符串
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		String monthStr = month<10?"0"+month:month+"";
		String dateStr = date<10?"0"+date:date+"";
		String minDate = (year-10) + ":01:01";
		String maxDate = year + ":" + monthStr + ":" + dateStr;
		
		//添加视图信息
		mv.setViewName("reportChart");
		//添加最早交易时间
		mv.addObject("minDate", minDate);
		//添加最晚交易时间
		mv.addObject("maxDate",maxDate);
		//接收查询结果
		rdList = reportServiceImpl.getReportDatas(minDate, maxDate);
		//添加销售量
		int flag=0;
		int i = 0;
		for (String coalType : coalTypes) {
			flag=0;
			i++;
			for(ReportData data:rdList){
				if(data.getCoalType().equals(coalType)){
					mv.addObject("coalType"+i,data.getQuantity());
					flag=1;
					break;
				}
			}
			if(flag==0){
				mv.addObject("coalType"+i,0);
			}
		}
		return mv;
	}
	@RequestMapping("/report")
	public String report(){
		return "report";
	}
}
