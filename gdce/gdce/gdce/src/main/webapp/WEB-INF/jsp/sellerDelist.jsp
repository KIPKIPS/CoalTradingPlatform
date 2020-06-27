<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sellerDelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		caption {
			text-align:center;
			font-size: 1.5em;
			margin-bottom:1%;
		}
	</style>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/layoutit.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
	function F(){
			//location.href="Delist/getSellerDelistInfo";
	}
	</script>

  </head>
  
  <body >
  
<!--整个信息显示页面-->
	<div class="row clearfix" style="margin-left:-17%;margin-right:2%">
	 	<ul class="breadcrumb">
			<li>
				 <a href="javascript:void(0);" onclick="javascript:history.go(-1);">返回</a>
			</li>
			<li class="active">
				Data
			</li>
	 	</ul>  
		 <form action="Delist/getSellerDelistInfo?no=${Seller_goods.sNumber}" method="post"  onsubmit="return isEmptyAll()">
	        <div class="col-md-12 column">
				<table class="table table-hover">
					<caption>报价信息</caption> 
					<tr class="success">
	                    <td id="tips"><font size="2">供应数量(万吨):</font></td>
	                    <td>${Seller_goods.sCount}</td>
	                    <td id="tips"><font size="2">热值(KCal/kg)≥:</font></td>
	                    <td>${Seller_goods.sKCal}</td>
	                    <td id="tips"><font size="2">原煤单价(元/吨):</font></td>
	                    <td>${Seller_goods.sCPrice}</td>
	                </tr>
	                <tr class="error">
	                    <td id="tips"><font size="2">全硫(%)≤:</font></td>
	                    <td>${Seller_goods.sS}</td>
	                    <td id="tips"><font size="2">产地:</font></td>
	                    <td>${Seller_goods.sPlace}</td>
	                    <td id="tips"><font size="2">运费单价：</font></td>
	                    <td>${Seller_goods.sFreight}<font color="#FF0000"></font>元/吨</td>
	                </tr>
	                <tr class="warning">
	                    <td id="tips"><font size="2">挥发分(%):</font></td>
	                    <td>${Seller_goods.sVolatilizeMin}<font size="2">&nbsp;&nbsp;
	                        至&nbsp;&nbsp;</font>${Seller_goods.sVolatilizeMax}</td>
	                    <td id="tips"><font size="2">发站(发货港口):</font></td>
	                    <td> ${Seller_goods.sDeliverPlace} </td>
	                    <td id="tips"></td>
	                    <td></td>
	                </tr>
	                <tr class="info">
	                    <td id="tips"><font size="2">空干基灰分(%)≤:</font></td>
	                    <td>${Seller_goods.sAshContent}</td>
	                    <td id="tips"><font size="2">全水分(%)≤:</font></td>
	                    <td>${Seller_goods.sMoisture}</td>
	                    <td id="tips"></td>
	                    <td></td>
	                </tr>
	            </table>
	            <!--表格底部区域-->
	            <div id="bottomOfTable">
	
	                <!--按钮区域-->
	                <div id="submitBut" style="margin-left:45%;">
	                    <input type="submit" class="btn  btn-primary submit" value="摘牌"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="button" class="btn btn-default btn-inverse" value="返回" onclick="history.back()"/>
	                </div>
	            </div>
	        </div>
	
	    </form>
	 </div>

</body>

</html>
