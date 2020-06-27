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
    
    <title>My JSP 'checkWaybillInfo.jsp' starting page</title>
    
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
	
	<style type="text/css">
    @import url("css/bootstrap.min.css");
	</style>
  </head>
  
    <body>
<div style="width:70%; margin-left:15%; margin-right:15%">
<div style="width:100px; height:23px; background-color:#00C">
<font face="Microsoft YaHei UI light" color="#FFFFFF">待确认列表</font>
</div>
<div style="height:7px; background-color:#00C">
</div>
<table border="0" cellspacing="0" cellpadding="0" style="width:100%" rules="rows">
  			<tr>
            <td bgcolor="#0066FF" style="text-align:center; width:20%; height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">运单编号</font>
            </td>
            <td bgcolor="#0066FF" style="text-align:center;width:20%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">交易编号</font>
            </td>
            <td bgcolor="#0066FF" style="text-align:center;width:20%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">货源地</font>
            </td>
            <td bgcolor="#0066FF" style="text-align:center;width:20%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">收货地</font>
            </td>
            <td bgcolor="#0066FF" style="text-align:center;width:20%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF">操作</font>
            </td>
            <td bgcolor="#0066FF" style="text-align:center;width:20%;height:35px"><font face="Microsoft YaHei UI light" color="#FFFFFF"></font>
            </td>
            </tr>
			<c:forEach items="${waybillList}" var="checkWaybill">
  			<tr>
            <td style="text-align:center; width:20%; height:50px">
            ${checkWaybill.waybill_id}
            </td>
            <td style="text-align:center;width:20%;height:50px">${checkWaybill.trade_id}
            </td>
            <td style="text-align:center;width:20%;height:50px"><font face="Microsoft YaHei UI light" color="#000000">${checkWaybill.good_source}</font>
            </td>
            <td style="text-align:center;width:20%;height:50px"><font face="Microsoft YaHei UI light" color="#000000">${checkWaybill.good_destination}</font>
            </td>
            <td style="text-align:center;width:20%;height:50px"><button type="button" class="btn btn-default btn-primary"  onclick="arrive(${ checkWaybill.waybill_id})">完善信息</button>
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
 	   
 	   location.href="showCheckWaybill/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages};
 	   }
 	   function next(){
 	   location.href="showCheckWaybill/page?pageNum="+${pageInfo.pageNum+1}+"&maxPage="+${pageInfo.pages};
 	   }
 	   function back(){
 	   location.href="showCheckWaybill/page?pageNum="+${pageInfo.pageNum-1}+"&maxPage="+${pageInfo.pages};
 	   }
 	   function arrive(id){
 	   location.href="waybill/showWaybillInfoDetails?waybill_id="+id;
 	   }
 	   </script>
  </body>
</html>
