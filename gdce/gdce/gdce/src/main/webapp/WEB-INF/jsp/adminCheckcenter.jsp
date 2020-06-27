<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminCheckcenter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<script type="text/javascript">
	function reinitIframe()
	{
	var iframe = document.getElementById("bottom");
	try{
	var bHeight = iframe.contentWindow.document.body.scrollHeight;
	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	var height = Math.max(bHeight, dHeight);
	iframe.height = height;
	}catch (ex){}
	}
	window.setInterval("reinitIframe()", 200);
	
	function loadrole(){
	var i = ${admin.roleID}
	alert(i);
	if(i==1) window.parent.content.location.href="/news/add";
	else if(i==2) window.parent.content2.location.href="/admin/regist_check_list";
	else if(i==3) window.parent.content2.location.href="/Check/CheckManager";
	else if(i==4) window.parent.content2.location.href="/News/toNewsJsp";
	else if(i==5) window.parent.content2.location.href="/News/toNewsJsp";
	}
	</script>
  </head>
  
  <body>
    <iframe src="/admin/adminCheckIndex" 
    frameborder="0" marginheight="0" marginwidth="0" height="60px;" width="100%" scrolling="no"></iframe>
    
    <iframe id="bottom" src="/admin/adminCheckBottomPage" 
    name="content2" frameborder="0" marginheight="0" marginwidth="0" width="100%" 
     scrolling="no"  onload="loadrole()"></iframe>
  </body>
</html>
