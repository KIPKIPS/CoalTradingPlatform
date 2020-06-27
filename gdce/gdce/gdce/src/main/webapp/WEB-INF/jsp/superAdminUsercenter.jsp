<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usercenter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style>
	*{
	margin:0;
	padding:0;	
	}      
	</style>
	
  </head>
  
  <body>
  
    <iframe src="/secondaryAdminManage/superAdminTopPage"  frameborder="0" marginheight="0" marginwidth="0" height="45px" width="100%" scrolling="no"></iframe>
    <iframe src="/secondaryAdminManage/superAdminMiddlePage" frameborder="0" marginheight="0" marginwidth="0" height="90px" width="100%" scrolling="no"></iframe>
    <iframe src="/secondaryAdminManage/superAdminBottomPage" name="content" frameborder="0" marginheight="0" height="700px" marginwidth="0"  width="100%" scrolling="no"></iframe>
   
  </body>
</html>
