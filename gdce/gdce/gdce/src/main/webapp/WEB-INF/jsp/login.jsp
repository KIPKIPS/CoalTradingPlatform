<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- /*默认360极速浏览器*/ -->
	<meta name="renderer" content=webkit>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
	@import"css/bootstrap.min.css";
	</style>

    <style type="text/css">
		fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver;border-radius:8px}
		legend{padding:.5em;border:0;width:auto;margin-bottom:10px}
		#bottom{
				/*border:1px solid green;*/
				width:1250px;
				height: 199px;
			}
			irfame{float:left;
			}
			#but1{
			}
			#header{width: 530px;
				height: 80px;
				
				padding-left: 160px;
				margin-top:50px;
				
			}
				#ul1{
			
				margin: auto;
				padding-left: 160px;
				}
				#login{
				width:100px;
				height:30px;
				}
				#fieldset1{
				margin-left:150px;
				margin-top:70px;
				float:left;
				background:url(images/background01.jpg);
			
				}
				#myform{
				margin-left:670px;
				margin-top:0px;
				position:absolute; 
				width:380px;
				height:368px;
				 z-index:2; 
				
				 
				
				
				}
				#formbg{
				 position:absolute; 
				 z-index:0; 
				background-color:white;
				opacity: 0.45;
					width:356px;
				height:333px;
				top:200px;
				left:860px;
				border:1px;
				border-color:green;
				 border-style: solid;  
				}
				#loginbg{
				width:800px;
				height:300px;
				float:left;
				background:url(images/background01.jpg);
				}
				#background01{
				background-image:images/background01.jpg;
				 width:910PX;height:400px;
				 }
				#codetext{font-size: 12px; 
				color:red;
				}
				#loginnew{
				margin-left:89px;}
				#loginnewsubmit{
				width:181px;
				height:30px;}
	</style>
	<script type="text/javascript">
	      function $(id){
          return document.getElementById(id);
      }
  function changeCode(){
      $("code").src = "ValidateCodeServlet?a="+new Date();
  }
	function radioadmin(){
		document.getElementById('inputname').name='adminName';
		document.getElementById('inputpass').name='adminPass';
		document.getElementById('myform').action='admin/login';}
	function radiofinance(){
		document.getElementById('myform').action='finance/login';
		document.getElementById('inputname').name='muAccount';
		document.getElementById('inputpass').name='muPass';}
	function radiotrader(){
		document.getElementById('myform').action='trader/login';
		document.getElementById('inputname').name='uName';
		document.getElementById('inputpass').name='uPass';
	}
	function check1(){
		var x=document.getElementById('inputname');
		var y=document.getElementById('inputpass');
		if(x.value==""||y.value==""){
		alert('用户名和密码不能为空');
 		flag = false;
 		return false;}
		return true;      
		}
function infoback(){
var x=document.getElementById('inputname');
var y=document.getElementById('inputpass');
location.href = 'admin/'
}
function chan(){
		document.getElementById('inputname').value='${adminName}'+'${muAccount}'+'${uName}';
		
}

	</script>
  </head>
  <body onload=chan()><div id="header">
  	<img src="images/logo.jpg" width=100% height=100%/>
  	</div>		
<center>
	<div style="width: 1066px;height:332px;" id="fieldset1">
	<div id="formbg">
	</div>
   		<form   action="admin/login" method="post"  id="myform" onsubmit='return check1()'>
   		<br/>
   			用户名称:<input id="inputname" name="adminName" value=""/><br/><br/><br/>
   			用户口令:<input id="inputpass"type="password" name="adminPass" /><br/></br>
   			
    		&nbsp;&nbsp;&nbsp;&nbsp;验证码:<input id="inputcode" name="verifyCode" style="width:100px" />
    		<img alt="验证码"  id="code" onclick="this.src='admin/createValicode?'+ Math.floor(Math.random()*100)" src ="admin/createValicode" width=72px height=50px;>
    <br/><div id="codetext">看不清验证码，点击图片切换</div><br/>
    	<!--  
   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录 " id="login" /><br/>
   			-->
   			<div class="col-md-8 column" id="loginnew">
			 <button id="loginnewsubmit"type="submit" class="btn btn-default btn-primary btn-block" 
			 onclick=changecode() >登录</button>
		</div><br/><br/>
   			<input type="radio" name="radio1" value="admin" checked="checked" onclick='radioadmin()'>平台管理用户
   			<input type="radio" name="radio1" value="finance" onclick='radiofinance()'>财务用户
   			<input type="radio" name="radio1" value="trader" onclick='radiotrader()'>交易用户<br/>
   			   		<input class="btn btn-default btn-primary"   id="but1" type = "button" value = "注册交易账号" onclick = "window.location.href = 'trader/registpage'">
   		<input  class="btn btn-default btn-primary"  id="but1"  type = "button" value = "找回密码" onclick = "window.location.href = 'trader/findPwdpage'">
   		
   		
   		</form>
   	</div>
 </center>
  <center><!--  
<div id="bottom">
				<img src="images/deal_bottom.PNG" width="100%" height="149px" style="margin-top: 0px;"/>			
</div>
-->
			</center>

</body>
</html>
