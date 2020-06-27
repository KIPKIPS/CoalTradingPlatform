<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'queryBalance.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
fieldset{
	border-radius: 5px 5px 5px 5px;
    border:3px solid blue;
    text-align:left;
    width:500px;
    background-color:#FFF0f5;
    position:relative;
	top:50px;
}
legend{
	border-radius: 5px 5px 5px 5px;
    border:3px solid blue;
    text-align:left;
    color:blue;
	font-weight:bold;
}
p{
	font-style: normal;
	color:blue;
	font-weight:bold;
	font-size:25px;
}
#input1 {
	width: 250px;
	height: 40px;
	border-radius: 7px;
	font-size: 20px;
}

#sumbit1 {
	background-color: #007eff;
	color: white;
	height: 40px;
	width: 60px;
	font-size: 15px;
	border-radius: 9px;
}
#exit{
	background-color: #007eff;
	color: white;
	height: 40px;
	width: 120px;
	font-size: 15px;
	border-radius: 9px;
}
body{
	
	background-image:url(images/yh.jpg);
	
	}
</style>
<script type="text/javascript">

	function checkMoney() {
	
		var reg = /^(\.*)(\d+)(\.?)(\d{0,2}).*$/g;
		var money = document.getElementById("input1").value;
		if (reg.test(money)) {
		    money = money.replace(reg, '$2$3$4');
		} else{
		    alert("只允许整数或者最多两位小数！")
		    money = "";
		}
		return money;
	}
	function exit(){
		location.href="bank/exit";
	}
</script>

</head>

<body>
	<center>
		<fieldset>
			<legend>余额查询</legend>
			<p>账户活动金额：<fmt:formatNumber value="${bankFinance.usableMoney}" pattern="#,##0.00"/>（元）</p>
			<p>账户冻结金额：<fmt:formatNumber value="${bankFinance.frozenMoney}" pattern="#,##0.00"/>（元）</p>
			<p>账户总余额：<fmt:formatNumber value="${bankFinance.balance}" pattern="#,##0.00"/>（元）</p>
			<center>
			<form id="form1" action="bank/PrestoreMoney" method="post">
				<input type="text" id="input1" name="balance" placeholder="请输入预存金额" onblur="value = checkMoney();"> 
				<input type="submit" id="sumbit1" value="预存">
			</form>
				<button id="exit" onclick="exit()">退出查询</button>
			</center>
		</fieldset>
	</center>

</body>
</html>
