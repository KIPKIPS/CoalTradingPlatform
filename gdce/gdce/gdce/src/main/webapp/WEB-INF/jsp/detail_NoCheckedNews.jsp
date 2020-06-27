<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'detail_CheckedNews.jsp' starting page</title>

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
.pTheme {
	font-size: 30px;
	font-weight: 1500;
}
.div1{
    width:70%;
    margin:0 auto;
}
.textdiv {
	border-top-style: dashed;
	border-width: 1px;
	width: 70%;
	text-indent: 3em;
	letter-spacing: 2px;
	margin:0 auto;
	font-size:20px;
}
  .a1{
    	text-decoration: none;
  }
  .ul1{
        list-style-type: none;
        float:left;
  }
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
   //去掉时间后面的 .0
   window.onload = function(){
       var a = "${news.nTime}";
       a = a.substring(0, 19);
       document.getElementById("p2").innerHTML = ("发布时间：" + a); 
   }
</script>
</head>

<body>
	<div style = "margin-left: -30%;">
			    <div class = "div1">
		    <ul class="breadcrumb">
			<li>
				 <a href="javascript:void(0);" onclick="javascript:history.go(-1);">资讯列表</a>
			</li>
			<li class="active">
				资讯详情
			</li>
		    </div>
		<center>
			<p class="pTheme">${news.nTheme}</p>
			<p id="p2"></p>
		</center>
		<div class="textdiv">${news.nContent}</div>
	</div>
	<br>
	资讯未通过原因：<p class="uOpinion">${opinion.uOpinion}</p>
</body>
</html>