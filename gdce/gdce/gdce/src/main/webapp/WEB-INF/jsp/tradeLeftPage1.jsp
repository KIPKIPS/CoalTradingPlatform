<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tradeLeftPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <style>
        #div1{
            display: table-cell;
            width:180px;
            height:700px;
            border-radius: 15px;
            background-color: #a0ffa8;
        }
        a{
            font-size: 18px;
            font-family: "YouYuan";
            text-align: center;
            line-height: 50px;
            color: #ffffff;
            text-decoration: none;
        }

        .div2{
            margin-top: 50px;
            margin-left: 12px;
            text-align: center;
            width:150px;
            height:45px;
            border-radius: 10px;
            background: #5a9aff;
        }

    </style>
	
	<script>
		function cue(){
			alert("功能待开发！")
		}
	</script>
	
  </head>
  
  <body>
   		<div id="div1">
            <div class="div2">
                <a href="/News/toShowNewsList" target="content2">资讯列表</a>
            </div>
            <div class="div2">
                <a href="/trader/tradeProducts_list" target="content2">商品列表</a>
            </div>
            <div class="div2">
                <a href="/report/report" target="content2">报表中心</a>
            </div>
            <div class="div2" style="cursor:pointer;">
                <a onclick="cue()" style="cursor:pointer;">长协交易</a>
            </div>
            <div class="div2" style="cursor:pointer;">
                <a onclick="cue()" style="cursor:pointer;">VIP信息</a>
            </div>           
        </div>
  </body>
</html>
