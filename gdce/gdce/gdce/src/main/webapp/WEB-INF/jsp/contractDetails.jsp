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
    
    <title>My JSP 'contractDetails.jsp' starting page</title>
    
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
		
		#contract {
			color: black;
		    font-size: 1.8em;
		    text-decoration: none;
		    margin-left: 20%;
		}
		iframe {
			width:70%;
			height:80%;
			position:absolute;
			margin-top:20px;
			margin-left: -13%;		
		}
		#show {
			margin-top:-175%;
		}
		.show {
			margin-left: -30%;
		}
		.button{
			margin-left: 5%;
   		 	margin-bottom: 50%;
		}
		.sign {
			float:right;
			margin-right:8%;
			margin-top:18%;
		}
	</style>

	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

  </head>
  
  <body>
    <a href="contract/${contract.contract}" target="contract" id="contract">合同协议书</a><br/>
    <iframe name="contract" src="contract/${contract.contract}">
    </iframe>
	<div class="sign">
		<div class="button">
		    <!-- 先判断合同状态，未确认则提示确认，已确认则显示查看订单 -->	    
		    <c:if test="${contractState == '01' }">
		    	<input type="button" value="确认" id="sign" class="btn btn-default btn-inverse" onclick="confirmOrder('${tradeNo}','${contractState}')" ><br/>
		    </c:if>
		    <c:if test="${contractState == '11' }">
		    	<a href="order/show?tradeNo=${tradeNo}" id="confirmed" class="btn btn-link btn-lg show">查看订单</a><br/>
		    </c:if>
	    </div>
	    <div class="button">
	   		<input type="button" value="取消" id="remove" class="btn btn-default btn-inverse" onclick="location.href='contract/remove?tradeNo=${tradeNo}'" ><br/>
	    </div>
    </div>
  </body>
  
  <script type="text/javascript">
  	//确认合同，确认之后生成订单并显示查看订单
  	 function confirmOrder(tradeNo,contractState) {
  	 	//alert(tradeNo + "==" + contractState)
  	 	var flag = confirm("确定签订此合同吗？");
  	 	if(flag) {
  	 		$.ajax({
  	 			type:"post",
  	 			url:"order/create",
  	 			data:"tradeNo="+tradeNo+"&contractState="+contractState,
  	 			success:function (msg) {
  	 				//签订完合同，刷新一次页面（确认合同时通过ajax提交的，数据库中的状态被修改但是页面中没有刷新，为了防止通过历史回退时页面还是待确认，可先执行一次刷新）
  	 				location.reload();	
  	 			}
  	 		}); 		
  	 	} 	
  	 }
  </script>
 </html> 
