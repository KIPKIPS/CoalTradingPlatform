<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tradeMilldePage.jsp' starting page</title>
    
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
    	background: #a0ffa8;
   	 	width:100%;
    	height:110px;
    	}

    	#div1 img{
    	margin-top: 18px;
    	float:left;
    	height:70px;
    	width:auto;
    	}

    	#div1 ul{
   	 	margin-top: 0;
   	 	display: inline;	
    	}

   		#div1 li{
   		text-align: center;
   		margin-top: 15px;
    	list-style: none;
    	float: left;
    	margin-left: 80px;
    	font-family:"YouYuan";
    	font-weight:bold ;
    	font-size: 22px;
    	}
    	
    	a{  
    	display:block;
        text-align: center;
        height:30px;
        width:120px;
        border: 1px solid ;
        border-radius: 25px;
        text-decoration: none;
    	}
   		a:hover {
        color: #2f34ff;
        background-color:white;
        border:1px solid darkslategray;
    	}
    	
    </style>
		
  </head>
  
  <body>
    <div id="div1">
    <img  src="images/logo.jpg"><br/>
        <ul id="ul1" float="left">
            <li><a href="/trader/tradeBottomPage1" target="content1">首页</a></li>
            <li><a href="/trader/tradeBottomPage2" target="content1">交易中心</a></li>
            <li><a href="/trader/tradeBottomPage3" target="content1">用户中心</a></li>
            <li><a href="/trader/tradeBottomPage4" target="content1">物流中心</a></li>
        </ul>
    </div>
  </body>
  
  
</html>
