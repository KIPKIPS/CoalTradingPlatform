<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sellerSpecificInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
 @import url("css/bootstrap.min.css");
			/*设置所有td的内边距*/
			td{
				width: 150px;
				border-right: none;
				border-left: none;
			}
			
			/*整个信息显示页面*/
			#father{
				/* border: 1px solid red; */
				width: 100%;
				height: 440px;
				margin: auto;
			}
			/*表单信息区域*/
			#info{
				/* border: 1px solid black; */
				width: 98.8%;
				height: 380px;
				margin: auto;
				margin-top: 10px;
			}
			/*信息头*/
			#infoTitle{
				/* border: 1px solid green; */
				width: 130px;
				height: 40px;
				float: left;
				text-align: center;
				line-height:15px;
				background-color: dodgerblue;
				margin-top:0px;
			}
			
			/* 表格区域 */
			#infoTab{
				/* border: 1px solid red; */
				width:98.8%;
				height:200px;
			}
			
			#tips{
				text-align: left;
				font-size:15px;
				font-weight:700;
			}
			

			/*按钮区域*/
			#submitBut{
				/* border: 1px solid blue; */
				text-align: center;
				margin-top: 100px;
			}
	</style>
  </head>
  
  <body>
<div id="father">
		
			
				<!--表单信息区域-->
				<div id="info">
					<!--信息头-->
					<div id="infoTitle"><br/><font color="white">报价信息</font></div>
					<div id="infoTab">
						<table border="1px" cellspacing="0px" width="100%" height="100%" align="center" cellpadding="5px" bgcolor="white">
							<tr>
								<td id="tips">供应数量(万吨):</td>
								<td>${specificGoodInfo.sCount}</td>
								<td id="tips">热值(KCal/kg)≥:</td>
								<td>${specificGoodInfo.sKCal}</td>
								<td id="tips">原煤单价(元/吨):</td>
								<td>${specificGoodInfo.sCPrice}</td>
							</tr>
							<tr>
								<td id="tips">全硫(%)≤:</td>
								<td>${specificGoodInfo.sS}</td>
								<td id="tips">产地:</td>
								<td>${specificGoodInfo.sPlace}</td>
								<td id="tips">运费单价：</td>
								<td>${specificGoodInfo.sFreight}<font color="#FF0000"></font>元/吨</td>
							</tr>
							<tr>
								<td id="tips">发站(发货港口):</td>
								<td>${specificGoodInfo.sDeliverPlace}</td>
								<td id="tips">煤种:</td>
								<td>${specificGoodInfo.coalTtype}</td>
								<td  id="tips">运输方式:</td>
								<td>${specificGoodInfo.transType}</td>
							</tr>
							<tr>
								<td id="tips">空干基灰分(%)≤:</td>
								<td>${specificGoodInfo.sAshContent}</td>
								<td id="tips">全水分(%)≤:</td>
								<td>${specificGoodInfo.sMoisture}</td>
								<td id="tips">挥发分(%):</td>
								<td>${specificGoodInfo.sVolatilizeMin}<font size="2">&nbsp;&nbsp;
								至&nbsp;&nbsp;</font>${specificGoodInfo.sVolatilizeMax}</td>
							</tr>
						</table>
					</div>
					
						<!--按钮区域-->
						<div id="submitBut">
							<input type="button" class="btn btn-default btn-primary" value="返回" onclick="history.back()"/>
						</div>
					
				</div>
				
			
		</div>
  </body>
</html>
