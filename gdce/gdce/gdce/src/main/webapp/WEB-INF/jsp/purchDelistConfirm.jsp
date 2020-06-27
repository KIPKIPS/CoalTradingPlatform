<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delistConfirm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- 10.61.88.30 -->
<script type="text/javascript">
function confirmFrozen(){
	var url = "http://10.61.88.30:8083/bank/frozen";
	var url2 = "http://10.61.88.30:8083/bank/unfrozen";
	var unfrozenMoney = ${pQuoDespsit};	
	var frozenMoney = ${pBidBond};
	var bankAcount = "${bankAcount}";	
	$.ajax({

	type : "get",
	url : url2,
	data:{"unfrozenMoney":unfrozenMoney,"bankAcount":bankAcount},
	success:function(msg){
	if(msg=="success"){
	alert("保证金解冻成功");
	}
	else if(msg=="false"){
	alert("保证金解冻失败");
	
	}
	},
	error:function(msg){
	alert("回调失败1");
	}
	}); 
	
	$.ajax({
	type : "post",
	url : url,
	data:{"frozenMoney":frozenMoney,"bankAcount":bankAcount},
	success:function(msg){
	if(msg=="right"){
	alert("保证金交付成功,请等待对方上传合同");
	location.href="http://10.61.88.30:8081/contract/contractPurchSuccess";
	/*?  */
	}
	else if(msg=="wrong"){
	alert("保证金交付失败，请检查您的余额");
	
	}
	},
	error:function(msg){
	alert("回调失败");
	}
	}); 
}
</script>
  </head>
  
  <body>
    <center>
   <fieldset>
	确认摘牌操作：</br>
	解冻报价保证金：${pQuoDespsit}万元</br>
	之后冻结履约保证金：${pBidBond}万元</br>
	银行账号${bankAcount}</br>
	
	<br>
<!-- 	 -->
	<button onclick="confirmFrozen()"> 确认交纳 </button>
 </fieldset>

   </center>
   
  </body>
</html>
