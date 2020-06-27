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
	   *{
	   		margin:0;
	   		padding:0;
	    }
	   #div1{
            width:auto;
            height:80px;
        }
        img{
            width:auto;
            /* margin-left: 13%; */
            height: 100%;
        }
        #ul1{
            margin-top: 30px;
            float:left;
        }
        li{
            list-style: none;
            float: left;
            margin-left: 100px;
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
   <center>
    <div id="div1">
       <img src="images/logo.jpg">
    </div>
    </center>
  </body>
</html>
