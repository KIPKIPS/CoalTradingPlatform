<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sellerDelistConfirm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<script type="text/javascript">
function confirmFrozen(){
location.href="/contract/contractSellSuccess";
}
/* 	var url = "http://192.168.1.111:8083/tempBank/bank/frozen"
	var frozenMoney = 1;
	var bankAcount = "aaa";
	alert(url);
	$.ajax({
	type : "post",
	url : url,
	data:{"frozenMoney":frozenMoney,"bankAcount":bankAcount},
	success:function(msg){
	if(msg=="right"){
	alert("保证金交付成功,请等待对方上传合同");
	location.href="/gdce/contract/contractSellSuccess";
	}
	else if(msg=="wrong"){
	alert("保证金交付失败，请检查您的余额");
	
	}
	},
	error:function(msg){
	alert("回调失败");
	}
	}); 
} */
</script>
  </head>
  
  <body>
    <center>
   <fieldset >
	摘牌成功！
	<br>
<!-- 	 -->
	<button onclick="confirmFrozen()"> 确认 </button>
  </fieldset>

   </center>
   
  </body>
</html>
