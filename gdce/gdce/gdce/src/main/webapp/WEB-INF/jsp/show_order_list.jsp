<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 获取项目的绝对路径 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_order_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style type="text/css">
		.headerAll{
			width:450px;
			height:40px;
			border-radius: 5px 5px 0 0;
			color:#fff;
			background-color:#39b3d7;
			border-color:#269abc;		
		}
		.header{
			width:148px;
			height:40px;
			text-align:center;
			line-height:40px;
			float:left;		
		}
		#orderListHeader{
			width:100%;
			margin:0;
			padding:0;
		}
		#orderListHeader div{
			width:20%;
			float:left;
			margin:0;
			padding:0;
			text-align:center;
		}
		#orderTable{
			border-collapse:collapse;		
			width:100%;		
		}
		th,td{
			width:20%;
			height:50px;
			border-style:solid none;
			border-width:2px;
			border-color:#269abc;
			text-align:center;
		}
		.left{
			border-left:solid 2px #269abc;
		}
		.right{
			border-right:solid 2px #269abc;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			window.onload=function() {
				getOrderList(1,1);
			}
			$("select").change(
				function(){
					getOrderList(1,1);
				}
			);
		function getOrderList(pageNum,pages){	
	 		$.ajax({
  			type:"post",
  			url:"order/showOrderList",
  			data:"pageNum="+pageNum+"&pages="+pages+"&orderClass="+$("#orderClass").val()+"&orderSource="+$("#orderSource").val()+"&orderState="+$("#orderState").val(),
  			success:function(msg){				
  						orderPageInfo = JSON.stringify(msg[0]);
			   			orderList = JSON.stringify(msg[1]);
  						$("#orderList").empty();
  						$("#orderListFooter").empty();
						$.each(JSON.parse(orderList), function(i,item){
							$("#orderList")
								.append("<tr><td class='left'>" 
									+ item.orderNo + "</td><td>" 
									+ item.tradeNo + "</td><td>" 
									+ item.orderDate + "</td><td>" 
									+ item.receiveDate + "</td><td class='right'><input type='button' id='otherFunction"+i+"' class='btn btn-sm btn-warning'>&nbsp;&nbsp;<input type='button' id='showOrderDetail"+i+"' class='btn btn-sm btn-info' value='查看订单详情'></td></tr>"
							)
							$("#showOrderDetail"+i).click(
								function(){
									location.href="order/show?tradeNo="+item.tradeNo;
								}
							);
							if($("#orderState").val()=="0"){					
								if($("#orderClass").val()=="buy"){
									if($("#orderSource").val()=="list"){
										$("#otherFunction"+i).val("处理回执单");
										$("#otherFunction"+i).click(function(){location.href="order/purchback?tradeNo="+item.tradeNo+"&orderNo="+item.orderNo+"&traderControl=1"});
									}else{
										$("#otherFunction"+i).val("处理回执单");
										$("#otherFunction"+i).click(function(){location.href="order/purchback?tradeNo="+item.tradeNo+"&orderNo="+item.orderNo+"&traderControl=2"});
									}
								}else{
									if($("#orderSource").val()=="list"){
										$("#otherFunction"+i).val("确认回执单");
										$("#otherFunction"+i).click(function(){location.href="order/sellerback?tradeNo="+item.tradeNo+"&orderNo="+item.orderNo+"&traderControl=3"});
									}else{
										$("#otherFunction"+i).val("确认回执单");
										$("#otherFunction"+i).click(function(){location.href="order/sellerback?tradeNo="+item.tradeNo+"&orderNo="+item.orderNo+"&traderControl=4"});
								}
							}
							}else{
								$("input").remove("#otherFunction"+i);
							}
						});
						
						$("#orderListFooter").append("<center id='center'></center>");
						$("#center").append("当前第" + JSON.parse(orderPageInfo).pageNum + "页/总共"+JSON.parse(orderPageInfo).pages+"页 ");
						$("#center").append("<input type='button' id='lastPage' class='btn btn-sm btn-link' value = '上一页'>&nbsp;&nbsp;");
						$("#lastPage").click(
							function(){
								getOrderList(JSON.parse(orderPageInfo).pageNum-1,JSON.parse(orderPageInfo).pages);
							}
						);
						$("#center").append("<input type='button' id='nextPage' class='btn btn-sm btn-link' value = '下一页'>&nbsp;&nbsp;&nbsp;");
						$("#nextPage").click(
							function(){
								getOrderList(JSON.parse(orderPageInfo).pageNum+1,JSON.parse(orderPageInfo).pages);
							}
						);
						$("#center").append("跳转到第<input id='input' value='"+JSON.parse(orderPageInfo).pageNum+"' type='text' style='width:35px;'>页");
			 			$("#input").bind("input propertychange",function() {
 							$("#input").val($("#input").val().replace(/[^\d]/g,'')); 
						});
			 			$("#center").append("<input type='button' id='pageskip' class='btn btn-sm btn-primary' value='跳转' >");
			 			$("#pageskip").click(
			 				function(){
			 	   				getOrderList($("#input").val(),JSON.parse(orderPageInfo).pages);
			 				}
			 			);
					},
			error: 	function(){
						alert("没有该类型的订单，请重新选择或刷新页面重试。");
					}
  			}); 
		}
		});
		
		
	</script>
  </head>
  
  <body>
  	<div class="headerAll">
  		<div class="header">
    	<font>订单类型</font>
    	<select id="orderClass">
    		<option value="buy">求购</option>
    		<option value="sell">出售</option>
    	</select>
		</div>
		<div class="header">
    	<font>订单来源</font>
    	<select id="orderSource">
    		<option value="list">挂牌</option>
    		<option value="delist">摘牌</option>
    	</select>
    	</div>
    	<div class="header">
   		<font>订单状态</font>
    	<select id="orderState">
    		<option value="0">待付款</option>
    		<option value="1">待发货</option>
    		<option value="2">已发货</option>
    		<option value="3">已完成</option>
    	</select>
    	</div>
   	</div>
   	<div>
   		<table id="orderTable" >
   			<thead id="orderListHeader">
   				<tr>
   					<th class="left">订单编号</th>
   					<th>交易编号</th>
   					<th>订单日期</th>
   					<th>收货日期</th>
   					<th class="right">操作</th>
   				</tr>
   			</thead>
   			<tbody id="orderList"></tbody>
   		</table>
   	</div>
   	<div id="orderListFooter"></div>
  </body>
</html>
