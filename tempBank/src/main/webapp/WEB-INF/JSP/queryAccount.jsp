<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryAccount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/layoutit.css">
	<style type="text/css">
		caption {
			text-align:center;
			font-size: 1.5em;
			margin-bottom:1%;
		}
		.row {
			margin-left: -8%;
    		margin-right: 2%;
		}
		.pass {
			width:40%;
		}
	</style>

  </head>
  
  <body>
  	<div class="col-md-12 column row">
			<table class="table table-hover">
				<caption>银行账户信息</caption>
				<tr class="success">
					<td>企业名称</td>
	    			<td>银行卡号</td>
	    			<td class="pass">登陆密码</td>
	    			<td>法人代表</td>
	    		</tr>
	    		<c:forEach var="bAccount" items="${allAccount}">
			    	<tr>
			    		<td>${bAccount.cName}</td>
			    		<td>${bAccount.bankAcount}</td>
			    		<td class="pass">${bAccount.bankPassword}</td>
			    		<td>${bAccount.cRealName}</td>
			    	</tr>
		    	</c:forEach>	
			</table>
		</div>	
    	
  </body>
</html>
