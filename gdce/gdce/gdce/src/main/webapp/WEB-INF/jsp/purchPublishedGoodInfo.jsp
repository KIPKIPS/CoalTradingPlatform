<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    
	#tblMain{
	text-align: center;
	
	}
	</style>
 
    

  </head>
  
  <body>

	<table id="tblMain" class="table table-hover table-bordered">

		<thead>
	 <tr><th colspan=11>已发布</th></tr>
    		<tr>
    			<th>煤种</th>
    			<th>商业分类</th>
    			<th>数量(万吨)</th>
    			<th>交货地</th>
    			<th>交货日期</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    		<tbody>
    	<c:forEach var="listing" items="${purchPublishList}">
    		<tr>
    		    <th>${listing.pCoalType}</th>
    		    <th>${listing.pCoalBusType}</th>
    			<th>${listing.pCount}</th>
    			<th>${listing.pDeliverPlace}</th>
    			<th><fmt:formatDate value="${listing.pDeliverEarliest}"  pattern="yyyy-MM-dd"  ></fmt:formatDate>至<fmt:formatDate value="${listing.pDeliverLatest}"  pattern="yyyy-MM-dd" ></fmt:formatDate></th>
    			<th>
    				<button class="btn btn-default btn-primary" onclick="rem(${listing.pNumber},${sessionScope.trader.uID})">查看</button>
    				
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
 	   var pageNum=document.getElementById("pageNum").value;
 	   var uID=${sessionScope.trader.uID};
 	   if(pageNum)
 	   location.href="SellerGoodInfo/page?pageNum="+pageNum+"&maxPage="+${pageInfo.pages}+"&uID="+uID+"&flag=5";
 	   }
 	    function next(){
 	   location.href="SellerGoodInfo/page?pageNum="+${pageInfo.pageNum+1}+"&maxPage="+${pageInfo.pages}+"&flag="+5+"&uID="+${sessionScope.trader.uID};
 	   }
 	   function back(){
 	   location.href="SellerGoodInfo/page?pageNum="+${pageInfo.pageNum-1}+"&maxPage="+${pageInfo.pages}+"&flag="+5+"&uID="+${sessionScope.trader.uID};
 	   }
 	   function rem(pNumber,uID){
      		location.href="SellerGoodInfo/purchSpecificInfo?pNumber="+pNumber+"&uID="+uID;	
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
