<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jump_prompt.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#goBack {
			color:red;
			margin:15px 0 10px 15px;
		}
		#jumpNow {
			margin:0 0 10px 15px;
		}
		#jumpNow button {
			margin-left:0;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script>
		window.onload=function() {
			$("#goBack").empty();
			$("#goBack").append("<span>提交成功，</span>");
			$("#goBack").append("<span id='seconds'>5</span>");
			$("#goBack").append("<span>秒后自动跳转到资讯信息审核列表界面...</span>");
			count();
		}
		
		function count() {
			var num=document.getElementById('seconds').innerHTML;
			num--;
			document.getElementById('seconds').innerHTML=num;
			if(num==0) {
				location.href='News/toNewsJsp';
			}
			setTimeout("count()",1000);
		}	
		
		function jumpNow() {
			location.href='News/toNewsJsp';
		}
	</script>
  </head>
  
  <body>
    <div id="goBack"></div>
    <div id="jumpNow">
    	<button type='button' onclick='jumpNow()'>立即跳转</button>
    </div>
  </body>
</html>
