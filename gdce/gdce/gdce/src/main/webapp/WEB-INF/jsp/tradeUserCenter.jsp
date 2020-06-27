<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tradeUserCenter.jsp' starting page</title>
    
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
		
 	 <script type="text/javascript">
	function reinitIframe(){
		var iframe = document.getElementById("center");
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
  		<iframe src="/trader/tradeTopPage"  
    frameborder="0" marginheight="0" marginwidth="0" height="45px" width="100%" scrolling="no"></iframe>
    
        <iframe src="/trader/tradeMiddlePage" 
    frameborder="0" marginheight="0" marginwidth="0" height="90px" width="100%" scrolling="no"></iframe>
       
    	<iframe src="/trader/tradeBottomPage1" name="content1" id="center"
    frameborder="0" marginheight="18" marginwidth="0"  width="100%"  scrolling="no" onload="this.height=100"
   ></iframe>
     
  </body>
</html>
