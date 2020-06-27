<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'constractCreate.jsp' starting page</title>
    
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
   请选择合同文件:
       	<form action="contract/contractUpload?tradeNo=${unuploadtradeNo}" enctype="multipart/form-data" method="post">
			<input type="file" name="file" accept=".pdf,.doc,.txt"><br/>
		 	<input type="submit" value="上传">
		</form>
<!--    listNo,delistNo==request获取
   contract==上传
   tradeNo自动生成，constractState==01; -->
  </body>
</html>
