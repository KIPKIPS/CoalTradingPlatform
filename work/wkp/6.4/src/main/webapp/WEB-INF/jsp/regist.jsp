<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <center>
   <fieldset style="width: 300px;">
		<legend style="">用户注册</legend>
   		<form action="user/regist" method="post">
   			用户名称:<input name="username"><br/>
   			用户口令:<input type="password" name="password"><br/>
   			<span style="margin-left: -41px;">用户性别:</span>
   				   <span style="margin-left: 35px;">
   				     	 男<input type="radio" value="男" name="sex" checked>
   				     	 &nbsp;
   				     	 女<input type="radio" value="男" name="sex">
   				  </span><br/><br/> 
   			<input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;
   			<input type="reset" value="重置">
   		</form>
   	</fieldset>
   	</center>
 </body>
 </html>