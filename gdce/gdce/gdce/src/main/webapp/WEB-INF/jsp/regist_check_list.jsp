 <%@page import="com.isscollege.users.service.impl.Show_uncheckregist_serviceimpl"%>
<%@page import="com.isscollege.users.entity.Uncheck_regist"%>
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

  </head>
  
  <body>
<div style="width:70%; margin-left:15%; margin-right:15%">
<div style="width:100px; height:23px; background-color:#00C">
<font face="Microsoft YaHei UI" color="#FFFFFF">待审核列表</font>
</div>
<div style="height:7px; background-color:#00C">
</div>
<table border="0" cellspacing="0" cellpadding="0" style="width:100%" rules="rows">
<c:forEach items="${rList}" var="uncheck">
  			<tr>
            <td style="text-align:center; width:10%; height:50px">
            ${uncheck.uID}
            </td>
            <td style="width:90%;height:50px"><font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/showone?uID=${ uncheck.uID}">${uncheck.cName}</a></font>
            </td>
            </tr>
            </c:forEach>
</table>
</div><br>
    	<center>
 		当前第<input id=pageNum style="width:50px" oninput="value=value.replace(/[^\d]/g,'')" value="${pageInfo.pageNum} " />页/总共${pageInfo.pages}页  ，<button onclick="skip()">跳到</button>
 		<a href="registcheck/page?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a> 
 		<a href="registcheck/page?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a> 
 	   </center>
	 <script>
 	   function skip(){
 	   var pageNum=document.getElementById("pageNum").value
 	   
 	   location.href="registcheck/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages};
 	   }
 	   </script>
  </body>
</html>
