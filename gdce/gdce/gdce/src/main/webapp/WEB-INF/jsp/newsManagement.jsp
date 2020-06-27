<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'consultManagement.jsp' starting page</title>
    
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
	#select1{
	width:110px;
	height:33px;
	
	}
	
	</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  </head>
  <body>  
  	
	</br>
  		&nbsp&nbsp
  		<select id = "select1" onchange = fun1();>
  		
    		<option value="1">已发布资讯</option>
    		
    		<option value="3">审核未通过资讯</option>
    		
    	</select>
    	<a href="News/add"><button type="button"  class="btn btn-default btn-primary" type='button' id='cc'>新增资讯</button>
    	</a>
		
		
		<br>
		
       <iframe id="myiframe1" src="News/toShowNewsList" frameborder="0" marginheight="0" marginwidth="0"; width="1000px;height=100px;" 
     scrolling="no" onload="this.height=100" ></iframe>
     
       
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript"> 
	function fun1(){
	var select =document.getElementById("select1");
	
	if(select.value =="1"){
	
	    document.getElementById("myiframe1").src="News/toShowNewsList"}
	

	if(select.value =="3"){
	    document.getElementById("myiframe1").src="News/toShowNoNewsList"}
	}
	
	function reinitIframe(){
		var iframe = document.getElementById("myiframe1");
		try{
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);
		iframe.height = height;
	}	catch (ex){}
	}
	window.setInterval("reinitIframe()", 200);
	
	</script>
     </body>
     
</html>
