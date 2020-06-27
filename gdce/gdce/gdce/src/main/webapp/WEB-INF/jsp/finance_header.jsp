<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'finance.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style>
            #header{
             background-color:rgb(12, 14, 15);
            line-height:25px;
            }
           #a{
                position:absolute;
                left:800px;
                color:aliceblue;
               line-height:50px;
                
               
           }
           a.b:link{
                position:absolute;
                left:1100px;
                line-height:50px;
               color:aliceblue;
                text-decoration: none;
}
            a.b:visited{
            color:aliceblue;
            }
             a.b:hover{
                 color:maroon;
             }
             a.b:active{
              color:#00FF00;
              text-decoration:none;
             }
              a.c:link{
                position:absolute;
                left:100px;
                line-height:50px;
                color:aliceblue;
                text-decoration: none;
}
            a.c:visited{
            color:aliceblue;
            }
             a.c:hover{
                 color:maroon;
             }
             a.c:active{
              color:#00FF00;
              text-decoration:none;
             }
            </style>
  </head>
  
  <body>
    <div id="header" style=width:100%;height:50px;>
              <span id="a">${sessionScope.finance.muAccount}先生/女士欢迎您</span>
              <span><a href="finance/logout" class="b">[退出]</a></span>
             
            </div>
  </body>
</html>
