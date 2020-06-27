<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>煤炭销售图表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
			th{
				text-align: center;
				height:40px;
				width: 20%;
			}
			td{
				height:40px;
				text-align: center;
			}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script>
		$(function(){
			$("thead").css("background-color","honeydew")
			$("tbody tr:odd").css("background-color","oldlace");
			$("tbody tr:even").css("background-color","ghostwhite");
		});
	</script>

  </head>
  
  <body>
		<br /><h3>煤炭销售总量表：</h3>
		<table width="100%" cellspacing="0px"  align="center" style="margin-top:30px">
			<thead>
				<tr>
					<th>编号</th>
					<th>煤种名</th>
					<th>销售量(万吨)</th>
					<th>销售额(万元)</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rfList}" var="coal" varStatus="status">
					<c:if test="${coal.quantity==0}">
						<tr>
							<td>${status.count}</td>
							<td>${coal.coalType}</td>
							<td colspan="3">暂无销售记录</td>
						</tr>
					</c:if>
					<c:if test="${coal.quantity!=0}">
						<tr>
							<td>${status.count}</td>
							<td>${coal.coalType}</td>
							<td>${coal.quantity}</td>
							<td>${coal.money}</td>
							<td>${coal.minDate.toString().substring(0,10)}&nbsp;至&nbsp;${coal.maxDate.toString().substring(0,10)}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
