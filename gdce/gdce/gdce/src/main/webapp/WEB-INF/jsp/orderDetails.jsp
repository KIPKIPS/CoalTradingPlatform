<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderDetails.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/layoutit.css">
	
	<style type="text/css">
		caption {
			text-align:center;
			font-size: 1.5em;
			margin-bottom:1%;
		}
		.row {
			margin-left: -20%;
    		margin-right: 2%;
		}
	</style>
	
	<script type="text/javascript">
	   //去掉时间后面的 .0
	   window.onload = function(){
	       var create = "${orderDetails.orderDate}";
	       var receive = "${orderDetails.receieveDate}"
	       create = create.substring(0, 19);
	       receive = receive.substring(0, 19);
	       document.getElementById("create").innerHTML = (create); 
	       document.getElementById("receive").innerHTML = (receive);
	   }
   </script>
	
  </head>
  
  <body>
   	<div class="row clearfix">
		<ul class="breadcrumb">
			<li>
				 <a href="javascript:void(0);" onclick="javascript:history.go(-1);">返回</a>
			</li>
			<li class="active">
				Data
			</li>
		</ul>
		<div class="col-md-12 column">
			<table class="table table-hover">
				<caption>订单详情</caption>
				<tr class="success">
    			<td>订单编号</td>
    			<td>${orderDetails.orderNo}</td>
    			<td>卖方公司</td>
    			<td>${orderDetails.sellerName}</td>
    			<td>卖方联系方式</td>
    			<td>${orderDetails.sellerTele}</td>
    		</tr>			
    		<tr class="error">
    			<td>买方公司</td>
    			<td>${orderDetails.purchName}</td>
    			<td>买方联系方式</td>
    			<td>${orderDetails.purchTele}</td>
    			<td>煤种</td>
    			<td>${orderDetails.coalType}</td>
    		</tr>
    		<tr class="warning">
    			<td>吨数（万吨）</td>
    			<td>${orderDetails.quantity}</td>
    			<td>金额（万元）</td>
    			<td>${orderDetails.money}</td>
    			<td>货源地</td>
    			<td>${orderDetails.salePlace}</td>
    		</tr>
    		<tr class="info">
    			<td>到货地</td>
    			<td>${orderDetails.deliveryPlace}</td>
    			<td>订单创建时间</td>
    			<td id="create"></td>
    			<td>收货时间</td>
    			<td id="receive"></td>
    		</tr>
    		<tr class="success">
    			<td>交易方式</td>
    			<td>${orderDetails.exchangeMeans}</td>
    			<td>订单状态</td>
    			<!-- 根据数据库中的订单状态数字在页面显示对应的状态 -->
    			<c:choose>
	    			<c:when test="${orderDetails.orderState == '0' }">
	    				<td colspan="3">待付款</td>
	    			</c:when>
	    			<c:when test="${orderDetails.orderState == '1' }">
	    				<td colspan="3">待发货</td>
	    			</c:when>
	    			<c:when test="${orderDetails.orderState == '2' }">
	    				<td colspan="3">已发货</td>
	    			</c:when>
	    			<c:when test="${orderDetails.orderState == '3' }">
	    				<td colspan="3">确认收货</td>
	    			</c:when>
    			</c:choose>  			
    		</tr>
				</tbody>
			</table>
		</div>	
	</div>
   	
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
  </body>
</html>
