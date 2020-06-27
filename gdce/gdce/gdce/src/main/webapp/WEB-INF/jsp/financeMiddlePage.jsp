<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'middle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
	 #div1{
            /*margin-left: 60px;*/
            width:auto;
            height:80px;
       /*     border:1px solid blue;*/
            text-align: center;

        }
        img{
            width:auto;
            margin-left: 13%;
            height: 100%;
        }
        #ul1{
            margin-top: 30px;
            float:left;
        }
        li{
            list-style: none;
            float: left;
            margin-left: 50px;
            font-family:"宋体";
            font-weight:bold ;
            font-size: 17px;
        }
        a{
            text-decoration: none;
        }
	</style>
	
  </head>
  
  <body>
    <div id="div1">
               <img style="float:left" src="images/logo.jpg">
        <ul id="ul1">

<!--             <li><a href="/gdce/trader/traderProductManager" target="content">物流运单</a></li>
            <li><a href="/gdce/trader/traderProductManager" target="content">商品订单</a></li>  -->
            <li><a href="/" target="content">账户余额</a></li>
        </ul>
    </div>
  </body>
</html>
