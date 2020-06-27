<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style type="text/css">
		h3 {margin-bottom:15px;margin-left:26%}
		img {width:100%;height:100%;opacity: 0.5; position: absolute;background-repeat:no-repeat;background-position:center;background-size:cover;}
		#accountInfo {height:20px; line-height:2px; margin:20px 0;}
		#bankToRegistBtn {margin:0 10px 0 0;}
		#bankToIndexBtn {margin:0 10px;}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		window.onload=function() {
			
			updateUserAccountInfoBycName();
		}
		
		function updateUserAccountInfoBycName() {
			cName="${bank_Finance.cName}";
			bankAcount="${bank_Finance.bankAcount}";
			console.log(cName + ", " + bankAcount);
			$.ajax({
			type : "post",
			url : "http://10.61.88.30:8081/trader/updateUserAccountInfoBycName",
			data : "cName=" + cName + "&cBankAccount=" + bankAcount,
			success : function(msg) {
				console.log(msg);
				if (msg == "updateSuccess") {
					console.log("账号已同步到gdce");
				} else {
					console.log("账号同步失败");
				}
			},
			error:function() {
				alert("错误回调~  o_0")
			}
			});
		}
		
	</script>

  </head>
  
  <body>
  <img src="images/regsuss.jfif">
  <div class="container">
 
    	<!-- <div>注册信息：</div> -->
    	<%-- <div><span>密码：</span><span>${bank_Finance.bankPassword}</span></div> --%>
    	<%-- <div><span>企业名称：</span><span>${bank_Finance.cName}</span></div>
    	<div><span>法人代表：</span><span>${bank_Finance.cRealName}</span></div>
    	<div><span>法人身份证：</span><span>${bank_Finance.cLegalPerson}</span></div>
    	<div>联系人：<span></span><span>${bank_Finance.uRealName}</span></div>
    	<div>联系电话：<span></span><span>${bank_Finance.uTeleNum}</span></div> --%>
    	<div class="col-lg-5" style="margin-left: 27%;margin-top: 6%;" >
    		<h3>恭喜您注册成功！</h3>
    		<table class="table table-bordered table-hover table-condensed">
    		<thead>    
    			<tr><th colspan="2">注册信息</th></tr>
    		</thead>
    		<tbody>
    			<tr class="success"><td>企业名称</td><td>${bank_Finance.cName}</td></tr>
    			<tr class="danger"><td>法人代表</td><td>${bank_Finance.cRealName}</td></tr>
    			<tr class="success"><td>法人身份证</td><td>${bank_Finance.cLegalPerson}</td></tr>
    			<tr class="danger"><td>联系人</td><td>${bank_Finance.uRealName}</td></tr>
    			<tr class="success"><td>联系电话</td><td>${bank_Finance.uTeleNum}</td></tr>
    		</tbody>
    	</table>
    	
    	<div id="accountInfo" class="alert alert-info"><span>你的银行账号为(请牢记)：</span><span>${bank_Finance.bankAcount}</span></div>
    	
    	<button id="bankToRegistBtn" class="btn btn-default" type="button" onclick="javascript:location.href='bank/toRegist'">继续注册</button>
    	<button id="bankToIndexBtn" class="btn btn-default" type="button" onclick="javascript:location.href='bank/index'">返回登录</button>
    	</div>
  </div>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>  	
  </body>
</html>
