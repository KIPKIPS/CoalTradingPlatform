 <%@page import="com.isscollege.waybill.service.impl.show_transporting_serviceimpl"%>
<%@page import="com.isscollege.waybill.entity.tb_waybills_entity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<style type="text/css">
    @import url("css/bootstrap.min.css");
	</style>
  </head>
  
  <body>
<div style="width:70%; margin-left:15%; margin-right:15%">
<div style="width:100px; height:23px; background-color:#00C">
<font face="Microsoft YaHei UI light" color="#FFFFFF">配送中列表</font>
</div>
<div style="height:7px; background-color:#00C">
</div>
<table border="0" cellspacing="0" cellpadding="0" style="width:100%" rules="rows">
  			<tr>
            <td bgcolor="#0066FF" style="text-align:center; width:15%; height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">运单编号</font>
            </td>
            <td bgcolor="#0066FF" style="width:45%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">交易编号</font>
            </td>
            <td bgcolor="#0066FF" style="width:10%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">货源地</font>
            </td>
            <td bgcolor="#0066FF" style="width:10%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">收货地</font>
            </td>
            <td bgcolor="#0066FF" style="width:10%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">发货时间</font>
            </td>
            <td bgcolor="#0066FF" style="width:10%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF"></font>
            </td>
            </tr>
<c:forEach items="${tList}" var="transporting">
  			<tr>
            <td style="text-align:center; width:15%; height:50px">
            ${transporting.waybill_id}
            </td>
            <td style="width:45%;height:50px"><font face="Microsoft YaHei UI light" color="#000000"><a href="ShowTransporting/showone?waybill_id=${ transporting.waybill_id}">${transporting.trade_id}</a></font>
            </td>
            <td style="width:10%;height:50px"><font face="Microsoft YaHei UI light" color="#000000">${transporting.good_source}</font>
            </td>
            <td style="width:10%;height:50px"><font face="Microsoft YaHei UI light" color="#000000">${transporting.good_destination}</font>
            </td>
            <td style="width:10%;height:50px"><font face="Microsoft YaHei UI light" color="#000000">${transporting.good_trs_time}</font>
            </td>
            <td style="width:10%;height:50px"><font face="Microsoft YaHei UI light" color="#000000"><button class="btn btn-default btn-primary"  onclick="arrive(${ transporting.waybill_id})">确认收货</button></font>
            </td>
            </tr>
            </c:forEach>
</table>
</div><br>
    	<center>
 		<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		
				当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页  ，
				<button type="button" class="btn btn-default btn-primary" onclick="back()">上一页</button>
				<button type="button" class="btn btn-default btn-primary" onclick="next()">下一页</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 	<input id=pageNum  style="width:40px;border-radius: 4px" oninput="value=value.replace(/[^\d]/g,'')" value="${pageInfo.pageNum} " />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 	<button type="button" class="btn btn-default btn-primary" onclick="skip()">跳到</button>
		</div>
	</div>
	
</div>
 	   </center>
	 <script>
 	   function skip(){
 	   var pageNum=document.getElementById("pageNum").value
 	   
 	   location.href="ShowTransporting/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages};
 	   }
 	   function next(){
 	   location.href="ShowTransporting/page?pageNum="+${pageInfo.pageNum+1}+"&maxPage="+${pageInfo.pages};
 	   }
 	   function back(){
 	   location.href="ShowTransporting/page?pageNum="+${pageInfo.pageNum-1}+"&maxPage="+${pageInfo.pages};
 	   }
 	       function arrive(waybill_id)
    {
        if(confirm('确认收货吗？'))
        window.location.href='ShowTransporting/arrive?waybill_id='+waybill_id;
        else
         window.location.href='ShowTransporting/showlist';
    }
 	   </script>
  </body>
</html>
