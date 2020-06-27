<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'contractShowUnupdatePage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>	
	
	a{text-decoration: none}
	table{width: 100%}
	tr{height:40px} 	
	table,tr,th{border: 1px solid gray;border-collapse:collapse}
	thead{font-size:25px;font-family:"YouYuan";background:#f5ff91}
</style>	
	<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
    
	<script type="text/javascript">
		$(function(){
			//表格隔行变色
			$("table>tbody>tr:even").css("background","#ead5ff");
			$("table>tbody>tr:odd").css("background","#f5ff91");		
		});
	</script>
	
  </head>
  
  <body>
  <br/>
  <center>
    	<table>
	    <!-- <tr><th colspan='7'>已完成合同列表</th></tr> -->
	    	<thead>
	        <tr><th>交易编号</th><th>挂牌方</th><th>摘牌方</th><th>合同内容</th><th>合同状态</th></tr>
	        </thead>
	        <tbody>
	         <c:forEach var="unupdateContractList" items="${unupdateContractList}">
	         <tr>
	    	<th>${unupdateContractList.tradeNo}</th>
  			<th>${unupdateContractList.c1}</th>
  			<th>${unupdateContractList.c2}</th>
  			<th>合同尚未上传</th>
  			<th><a href="contract/contractCreatePage?tradeNo=${unupdateContractList.tradeNo}">待上传</a></th>
  			</tr>
  			</c:forEach>
  			</tbody>
	</table> 
	
<br>
 		当前第<input id=pageNum style="width:50px" oninput="value=value.replace(/[^\d]/g,'')" value="${pageInfo.pageNum} " />页/总共${pageInfo.pages}页  ，<button onclick="skip()">跳到</button>
 		<a href="contract/unupdatePage?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a> 
 		<a href="contract/unupdatePage?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a> 
 	   </center>
	 <script>
 	   function skip(){
 	   var pageNum=document.getElementById("pageNum").value
 	   
 	   location.href="contract/bothSignedPage?pageNum="+pageNum+"&maxPage="+${pageInfo.pages};
 	   }
 	   </script>
  </body>
</html>
