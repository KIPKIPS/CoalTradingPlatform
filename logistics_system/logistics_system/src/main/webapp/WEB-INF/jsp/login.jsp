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
    <style type="text/css">
		fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver;border-radius:8px}
		legend{padding:.5em;border:0;width:auto;margin-bottom:10px}
		
	</style>
	<script type="text/javascript">
	</script>
		
  </head>
  
  <body>
  <center>
	<fieldset style="width: 300px;">
	<legend style="">用户登陆</legend>
   		<form action="user/login" method="post">
   			用户名称:<input name="user_name" /><br/>
   			用户口令:<input type="password" name="password" /><br/>
   			验证码:<input id="inputcode" name="verifyCode" />
    		<img alt="验证码"  id="code" onclick="this.src='user/createValicode?'+ Math.floor(Math.random()*100)" src ="user/createValicode" width=100px height=50px;><br/>
    		看不清点能换<br/>
   			<input type="submit" value="登陆"/>
   		</form>
   	</fieldset>
  </center>
  
</body>
</html>
