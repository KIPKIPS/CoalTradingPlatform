 <%@page import="com.isscollege.waybill.service.impl.show_transporting_serviceimpl"%>
<%@page import="com.isscollege.waybill.entity.tb_waybills_entity"%>
<%@page import="com.isscollege.waybill.dao.show_transporting_dao"%>
<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rigist_check_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<div style="width:70%; margin-left:15%; margin-right:15%">
<div style="width:100px; height:23px; background-color:#00C">
<font face="Microsoft YaHei UI light" color="#FFFFFF">运单基本信息</font>
</div>
<div style="height:7px; background-color:#00C"></div>

<table border="0" cellspacing="0" cellpadding="0" style="width:100%" rules="rows">
  			<tr>
            <td style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">运单编号:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.waybill_id}</font>
            </td>
            </tr>
            <tr>
            <td  style="text-align:right; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">交易编号:</font>
            </td>
            <td style="width:5%">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.trade_id}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">配送人:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.distributor}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">配送人联系方式:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.dis_phone}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">起始位置:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.start_pos}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">终止位置:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.end_pos}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">物流商编号:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.logistics_id}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">总运费:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.sum_carriage}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">货源地:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.good_source}</font>
            </td>
            </tr>
            
                          			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">收货地:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${tr.good_destination}</font>
            </td>
            </tr>
</table>
</div>


    <div align="center">
    <table border="0">
    <tr>
    <td align="center" style="width:20%"><button style="width:170px" onclick="arrive(${tr.waybill_id})">收货</button></td>
    <td align="center" style="width:20%"></td>
    <td align="center" style="width:20%"></td>
    <td align="center" style="width:20%"></td>
    <td align="center" style="width:20%"><button style="width:170px" onclick="back()">返回</button></td>
    <script>
 	       function arrive(waybill_id)
    {
        if(confirm('确认收货吗？'))
        window.location.href='ShowTransporting/arrive?waybill_id='+waybill_id;
        else
         window.location.href='ShowTransporting/showlist';
    }
        function back()
    {
        window.location.href='ShowTransporting/showlist';
    }
    </script>
    </tr>
    </table>
    </div>
<br>
  </body>
</html>
