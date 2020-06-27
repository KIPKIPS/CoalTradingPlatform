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
   <script src="js/jquery-1.8.3.js" type="text/javascript"></script>
    <!-- <script src="js/outer.js" type="text/javascript"></script> -->
	<script type="text/javascript">
		$(function(){
			//表格隔行变色
			$("table>tbody>tr:even").css("background","gray");
			$("table>tbody>tr:odd").css("background","pink");
		
			
			
		});
	</script>
  </head>
  
  <body>
  	${user.username}先生/女士，欢迎您,<a href="user/logout">退出</a>
	<table>
		<thead>
    		<tr>
    			<th>用户编号</th>
    			<th>用户姓名</th>
    			<th>用户口令</th>
    			<th>用户性别</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    		<tbody>
    	<c:forEach var="user" items="${userList}">
    		<tr>
    			<th>${user.userid}</th>
    			<th>${user.username}</th>
    			<th>${user.password}</th>
    			<th>${user.sex}</th>
    			<th>
    			<button onclick="rem(${user.userid},${pageInfo.pageNum},${pageInfo.pages})">删除</button>
    			<script>
    				function rem(userid,pageNum,maxPage){
    					/* alert(userid+"  sss  "+pageNum+"   fff  "+maxPage); */
    					var flag=confirm("是否确认删除?");
    					if(flag){
    						location.href="user/remove?userid="+userid+"&pageNum="+pageNum+"&maxPage="+maxPage;
    					}
    				}
    			</script>
    			&nbsp;&nbsp;&nbsp;&nbsp;修改
</th>
    		</tr>
    		</c:forEach>
    		</tbody>
    	</table>
	<center>
 		当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页  ，
 		<a href="user/getAllUsers?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a> 
 		<a href="user/getAllUsers?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a> 
 	</center>
 	</body>
</html>
