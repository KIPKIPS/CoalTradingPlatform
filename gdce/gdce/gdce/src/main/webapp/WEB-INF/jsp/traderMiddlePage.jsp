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
            float:left;
            margin-left: 13%;
            height: 100%;

        }
        #div1 ul{
            padding:0px;        
            margin-top: 30px;
            float:left;
            white-space:nowrap;
        }
        #div1 li{
            list-style: none;
            padding: 0px;
            float: left;
            margin-left: 20px;
            font-family:"宋体";
            font-weight:bold ;
            font-size: 17px;
            display: inline;
            
        }
        #div1 li a{
            text-decoration: none;
        }
        
	</style>
	
  </head>
  
  <body>
    <div id="div1">
               <img  src="images/logo.jpg">
        <ul id="ul1">

            <!-- <li><a href="" target="content">物流运单</a></li>
            <li><a href="" target="content">商品订单</a></li>  -->
            <li><a href="/trader/traderProductManager" target="content">商品管理</a></li>
            <li><a href="/trader/deal_purch" target="content">发布买家商品</a></li>
            <li><a href="/trader/deal_seller" target="content">发布卖家商品</a></li>
            <li><a href="/trader/tradeAccontInfoUpdate" target="content">修改企业信息</a></li>
            <li><a href="/trader/tradeProducts_list" target="content">商品列表</a></li>
            <li><a href="/trader/sedregistpage" target="content">完善企业信息</a></li>
            <li><a href="/trader/showorderlist" target="content">订单管理</a></li>
            <li><a href="/contract/contractCenter" target="content">合同管理</a></li>
            
        </ul>
    </div>
  </body>
</html>
