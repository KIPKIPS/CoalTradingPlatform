<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllUsers.jsp' starting page</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{text-decoration: none}
		table{width: 100%} 
		table,tr,th{border: 1px solid gray;border-collapse:collapse;}
		div{border: 0px solid red;}

	</style>
 
    

  </head>
  
  <body>
	<table>
		<thead>
	 	<tr><th colspan=14>已完成运单</th></tr>
    		<tr>
    			<th>运单编号</th>
    			<th>交易编号</th>
    			<th>配送状态</th>
    			<th>配送人</th>
    			<th>配送人联系方式</th>
    			<th>起始位置</th>
    			<th>终止位置</th>
    			<th>物流商编号</th>
    			<th>总运费</th>
    			<th>货源地</th>
    			<th>收货地</th>
    			<th>发货时间</th>
    			<th>到货时间</th>
	 		</tr>
    	</thead>
    		<tbody>
    	<c:forEach var="listing" items="${waybillList}">
    		<tr>
    			<th>${listing.waybill_id}</th>
    			<th>${listing.trade_id}</th>
    			<th>${listing.dis_status}</th>
    			<th>${listing.distributor}</th>
    			<th>${listing.dis_phone}</th>
    			<th>${listing.start_pos}</th>
    			<th>${listing.end_pos}</th>
    			<th>${listing.logistics_id}</th>
    			<th>${listing.sum_carriage}</th>
    			<th>${listing.good_source}</th>
    			<th>${listing.good_destination}</th>
    			<th>${listing.good_trs_time}</th>
    			<th>${listing.good_rec_time}</th>
    			<th>
    			<button style="width:50px">查看</button>
    			</th>
    		</tr>
    		</c:forEach>	
		</tbody>
		</table>
    	<center>
 		当前第<input id=pageNum style="width:50px" maxlength="10" oninput="value=value.replace(/[^\d]/g,'')" value="${pageInfo.pageNum} " />页/总共${pageInfo.pages}页  ，<button onclick="skip()">跳到</button>
 		<a href="waybill/page?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}&flag=1">上一页</a> 
 		<a href="waybill/page?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}&flag=1">下一页</a> 
 	   </center>
 	</body> 
	<script>
 	   function skip(){
 	   var pageNum=document.getElementById("pageNum").value
 	   if(pageNum)
 	   location.href="waybill/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages}+"&flag=1";
 	   }
 	   
 	</script>
</html>
