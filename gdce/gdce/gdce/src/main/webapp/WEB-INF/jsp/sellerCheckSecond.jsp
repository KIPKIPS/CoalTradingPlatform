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
    
    <title>My JSP 'seller9999.jsp' starting page</title>
    
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
 
    

  </head>
  
  <body>
	<table id="tblMain" class="table table-hover table-bordered">
		<thead>
	 <tr><th colspan=6>待审核</th></tr>
    		<tr>
    			<th>价格(元/吨)</th>
    			<th>数量(万吨)</th>
    			<th>低位发热量(Kcal)</th>
    			<th>产地</th>
    			<th>发货地</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    		<tbody>
    	<c:forEach var="listing" items="${sellerCheckSecondList}">
    		<tr>
    			<th>${listing.sCPrice}</th>
    			<th>${listing.sCount}</th>
    			<th>${listing.sKCal}</th>
    			<th>${listing.sPlace}</th>
    			<th>${listing.sDeliverPlace}</th>
    			<th>
    			<button class="btn btn-default btn-primary" onclick="rem(${listing.sNumber})">查看</button>	
    			</th>
    		</tr>
    		</c:forEach>
		</tbody>
		</table>
    	<center>
 		当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页  ，
				<button type="button" class="btn btn-default btn-primary" onclick="back()">上一页</button>
				<button type="button" class="btn btn-default btn-primary" onclick="next()">下一页</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 	<input id=pageNum  style="width:40px;border-radius: 4px" oninput="value=value.replace(/[^\d]/g,'')" value="${pageInfo.pageNum} " />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 	<button type="button" class="btn btn-default btn-primary" onclick="skip()">跳到</button>
 	   </center>
 	   <script>
 	   		function skip(){
 	   			var pageNum=document.getElementById("pageNum").value
 	   			if(pageNum)
 	   			location.href="SellerGoodInfo/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages}+"&flag=7";
 	   	}
 	   	 function next(){
 	   location.href="SellerGoodInfo/page?pageNum="+${pageInfo.pageNum+1}+"&maxPage="+${pageInfo.pages}+"&flag="+7;
 	   }
 	   function back(){
 	   location.href="SellerGoodInfo/page?pageNum="+${pageInfo.pageNum-1}+"&maxPage="+${pageInfo.pages}+"&flag="+7;
 	   }
    		function rem(sNumber){
    			location.href="SellerGoodInfo/sellerCheckSpecificInfo?sNumber="+sNumber;		
    	}
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
 	</body> 
</html>
 
