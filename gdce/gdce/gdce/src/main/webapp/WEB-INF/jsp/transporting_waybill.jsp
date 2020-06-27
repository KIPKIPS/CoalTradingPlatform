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
    
    <title>My JSP 'showAllUsers.jsp' starting page</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
    @import url("css/bootstrap.min.css");
	<style type="text/css">
		a{text-decoration: none}
		table{width: 100%} 
		table,tr,th{border: 1px solid gray;border-collapse:collapse;}
		div{border: 0px solid red;}

	</style>
 	
 	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
 	<script type="text/javascript">
 	
 	function setUp(){
 	 	var list = ${tradeIDList}
 		for(var i = 0;i<list.length;i++)
 		{
 			getInfo(list[i]);
 		}
 	}
 	

 	
 	function getInfo(tradeNo){
		$.ajax({
		type:"post",
   		url:"http://localhost:8082/logistics_system/waybill/getState1InfoByTradeNo",
   		dataType: "json", 
   		data:"tradeNo="+tradeNo,
   		success:function(data){
   		console.log(data);
   		if(data!=null)
   			$("#tblMain").append("<tr><th>"+data.trade_id+"</th><th>"+data.waybill_id+"</th><th>"+data.distributor+"</th><th>"+data.dis_phone+"</th><<th>"+data.good_source+"</th><th>"+data.good_destination+"</th><tr>");
   		}
		})
	}
 	
 	</script>
    

  </head>
  
  <body onload="setUp()">

	<table id="tblMain" class="table table-hover table-bordered">
		<thead>
	 	<tr><th colspan=6>待确认</th></tr>
    		<tr>
    			<th>订单号</th>
    			<th>运单号</th>
    			<th>配送人</th>
    			<th>配送人联系方式</th>
    			<th>发货地</th>
    			<th>收货地</th>
	 		</tr>
    	</thead>
    	<tbody>
    	
		</tbody>
		</table>
    	<center>
 		<%-- 当前第<input id=pageNum style="width:50px" maxlength="10" oninput="value=value.replace(/[^\d]/g,'')" value="${pageInfo.pageNum} " />页/总共${pageInfo.pages}页  ，<button onclick="skip()">跳到</button>
 		<a href="SellerGoodInfo/page?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}&flag=0&uID=${sessionScope.trader.uID}">上一页</a> 
 		<a href="SellerGoodInfo/page?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}&flag=0&uID=${sessionScope.trader.uID}">下一页</a>  --%>
 	   </center>
 	</body> 
	<script>
 	  /*  function skip(){
 	   var pageNum=document.getElementById("pageNum").value;
 	   var uID=${sessionScope.trader.uID};
 	   if(pageNum)
 	   location.href="SellerGoodInfo/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages}+"&uID="+uID+"&flag=0";
 	   }
 	   function rem(sNumber){
      		location.href="SellerGoodInfo/sellerSpecificInfo?sNumber="+sNumber;	
   	  	} */
   	  	/*     表格隔行变色 */
    function SetTableColor() {
  	var tbl = document.getElementById("tblMain");
  	var trs = tbl.getElementsByTagName("tr");
    var color = 0;
  	for (var i = 1; i < trs.length; i++) {
 	var j = i + 1;
 	if (j % 2== 0) { 
   	trs[i].style.background = "#ffffff";
 	}else if(color == 1){
	trs[i].style.background = "#fcf8e3";
	color = 0;
	}else if(color == 0)
	{
	trs[i].style.background = "#dff0d8";
	color = 1;
	}
	
}
}
 	   
 	</script>
</html>
