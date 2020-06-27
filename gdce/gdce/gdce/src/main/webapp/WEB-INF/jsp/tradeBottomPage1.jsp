<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tradeBottomPage1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	     
	.div-a{ float:left;width:14%;height:700px; border:0px solid #F00;}
    .div-b{ float:left;width:84%;height:auto;border:0px solid #000;}
            
	</style>
	
	 <script type="text/javascript">
	function reinitIframe(){
		var iframe = document.getElementById("iframe1");
		try{
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);
		iframe.height = height;
	}	catch (ex){}
	}
	window.setInterval("reinitIframe()", 200);
	
	</script> 
  </head>
  
  <body>
    <div class="div-a">
    <iframe src="/trader/tradeLeftPage1" 
            frameborder="0" marginheight="0" marginwidth="0" height="700px" width="100%" scrolling="no"></iframe>
	</div>

	<div class="div-b">
    <iframe src="/News/toShowNewsList" name="content2" id="iframe1"
            frameborder="0" marginheight="0" marginwidth="20px"  width="100%" scrolling="no"
            onload="this.height=100"></iframe>
	</div>
  </body>
</html>
