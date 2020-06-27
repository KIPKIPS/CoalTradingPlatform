<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'trade_user_regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/layoutit.css">
	<style>
		body {background-image:url(images/timg.jpg); background-repeat:no-repeat;background-position:center;background-size:cover;}
		.container {margin:0;}
		#userAccount { margin:10px 0 20px 0;}
		#userAccount input {background-color:rgba(150,190,200,0.8);}
		#userInfo { margin:10px 0 10px 0; font-size: 15px;}
		#userInfo div {margin:10px 0;}
		#userInfo div span {font-weight:bold;}
		#userInfo div input {background-color:rgba(255,255,255,0);}
		#checkInfoBtnArea button {margin:10px;}
		#userPass, #confirmPass {margin:10px 0 10px 0;}
		#userInfoSubmit {margin-top:10px}
		#userInfoSubmit #submitBtn {margin-right:10px;}
		#userInfoSubmit #resetBtn {margin:0 10px;}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
 	<script type="text/javascript">
 	
 		//输入格式正确再去查询账号是否存在，不正确则提示用户
 		/* function doCheck() {
 			var iptValue = $("#accountInpt").val();
			var returnVal=checkNumber(iptValue);
			if (returnVal) {
				alert("输入的是19位数字");
				ajaxSubmitGetAccountInfo();
			} else {
				alert("输入的不是19位数字，格式不正确！请认真输入！");
			}
 		} */
 	
 		//验证是否为19位数字
 		/* function checkNumber(value) {
			eval("var reg = /\^[0-9]{" + 19 + "\}$/;");
			var re = new RegExp(reg);
			if(re.test(value)) {
				return true;
			} else {
				return false;
			}
		}
 		
		function ajaxSubmitGetAccountInfo() {
			var iptVal=document.getElementById('accountInpt').value;
			alert("你输入的账户名为：" + iptVal.substring(0,4) + ", " + iptVal.substring(4,8) + ", " + iptVal.substring(8,12)+ ", " + iptVal.substring(12,16)+", " + iptVal.substring(16,19));		
			getAccountInfo(iptVal);
        } */
	
		/* 调用gdce接口：查询账号是否存在 */
		function getAccountInfo() {
			var cName=document.getElementById('accountInpt').value;
			$.ajax({
			type : "post",
			url : "http://10.61.88.30:8081/trader/getAccountInfoBycName",
			data : "cName=" + cName,
			success : function(msg) {
				if (msg == "") {
					alert("输入的企业名称不存在！请重新输入！");
					cleanUserInfo();
				} else {
					$("#userInfo").empty();
					$("#checkInfoBtnArea").empty();
					$("#userInfo").append("<div style='font-size:17px; font-weight:bold;'>请核对企业信息后进行注册：<div>");
					$("#userInfo").append("<div><span>法人代表：</span><input readonly='readonly' style='border:none;' name='cRealName' value='" + msg.cLegalPerson + "'></div>");
					$("#userInfo").append("<div><span>法人身份证：</span><input readonly='readonly' style='border:none;' name='cLegalPerson' value='" + msg.cLegalPersonID + "'></div>");
					$("#userInfo").append("<div><span>联系人：</span><input readonly='readonly' style='border:none;' name='uRealName' value='" + msg.uRealName + "'></div>");
					$("#userInfo").append("<div><span>联系电话：</span><input readonly='readonly' style='border:none;' name='uTeleNum' value='" + msg.uTelephone + "'></div>");
					
					
					$("#mainDiv").append("<div id='checkInfoBtnArea'></div>")
					$("#checkInfoBtnArea").empty();
					$("#checkInfoBtnArea").append("<button class='btn btn-primary' type='button' onclick='infoRight();' style='margin-left:0px;'>正确</button>");
					$("#checkInfoBtnArea").append("<button class='btn btn-primary' type='button' onclick='infoWrong();'>不正确</button>");
				}
			},
			error:function() {
				alert("错误回调~  o_0")
			}
			});
		}
		
		function infoRight() {
			$("#checkInfoBtnArea").empty();
			var cName=document.getElementById('accountInpt').value;
			checkWhetherAccountHasBeenRegistered(cName);
		}
		
		function infoWrong() {
			alert("请确保输入企业名称为该企业对应名称！重新输入！")
			$("#userInfo").empty();
			$("#checkInfoBtnArea").empty();
			$("#accountInpt").val("");
		}
		
		function cleanUserInfo() {
			$("#userInfo").empty();
			$("#checkInfoBtnArea").empty();
			$("#promptInfoArea").empty();
			$("#accountInpt").val("");
			/* 移除输入只读，查询按钮不可用 */
			$("#accountInpt").removeAttr("readonly");
			$("#queryBtn").removeAttr("disabled");
		}
		
		function cleanUserInfo2() {
			cleanUserInfo();
			$("#userPass").empty();
			$("#confirmPass").empty();
			$("#userInfoSubmit").empty();
			$("#bankPassword1").empty();
			$("#bankPassword2").empty();
		}
		
		
		
		/* 查询账号是否已被注册 */
		function checkWhetherAccountHasBeenRegistered(cName) {
			$.ajax({
			type : "post",
			url : "bank/validateUserAcount",
			data : "cName=" + cName,
			success : function(msg) {
				if(msg=="yes") {
					/* alert(msg); */
					/* 账号已被注册过，则提示用户账号已被注册 */
					$("#mainDiv").append("<div id='promptInfoArea'></div>");
					$("#promptInfoArea").append("<p style='color:red; font-size:20px; margin:10px 0 20px 0;'>此账号已被注册，不能重复注册！</p>");
					$("#promptInfoArea").append("<button class='btn btn-primary' type='button' name='cleanInfo' onclick='cleanUserInfo();'>确认</button>");
					
					/* 让输入框只读，查询按钮不能点击 */
					$("#accountInpt").attr("readonly", "readonly");
					$("#queryBtn").attr("disabled", true);
					
				} else if (msg=="no") {
					
					/* 账号没有被注册，则进行注册 */
					$("#mainDiv").append("<div id='userPass' class='input-group'></div>");
					$("#userPass").append("<span class='input-group-addon'>输入密码</span><input class='form-control' placeholder='字母开头，6-18位之间' maxlength='18' type='password' name='bankPassword' onblur='checkAccountPass();' />");
					$("#mainDiv").append("<div id='bankPassword1'></div>");
					
					$("#mainDiv").append("<div id='confirmPass' class='input-group'></div>");
					$("#confirmPass").append("<span class='input-group-addon'>确认密码</span><input class='form-control' placeholder='字母开头，6-18位之间' maxlength='18' type='password' name='bankPassword2' onblur='checkAccountPass2();' oninput='confirmPassPropertyChange();' />");
					$("#mainDiv").append("<div><span id='bankPassword2'></span></div>");
					
					$("#mainDiv").append("<div id='userInfoSubmit'></div>");
					$("#userInfoSubmit").append("<input class='btn btn-primary' id='submitBtn' type='submit' value='注册'><input class='btn btn-primary' id='resetBtn' type='reset' onclick='cleanUserInfo2();' value='取消'>");
					
					/* 让第二个输入框不能输入，第一个输入框密码验证正确之后，才能继续输入 */
					$("#confirmPass input").attr("readonly", "readonly");
					
					/* 让注册按钮不能点击，密码验证通过后才能点击 */
					$("#submitBtn").attr("disabled", true);
					$("body form").attr("action", "bank/tradeUserRegist");
					$("body form").attr("method", "post");
					
					/* 让输入框只读，查询按钮不能点击 */
					$("#accountInpt").attr("readonly", "readonly");
					$("#queryBtn").attr("disabled", true);
				} else {
					alert("出错了!");
				}
			},
			error:function() {
				alert("错误回调~  o_0")
			}
			});
		}
		
		/* $("#userPass input").blur(function() {
			alert("hello"); //没反应？？？
		}); */
		
		/* 验证密码格式是否正确 */
		function checkAccountPass() {
			var pass=$("#userPass input").val();
			/* 以字母开头，长度在6-18之间，只能包含字符、数字和下划线 */
			var reg=/^[a-zA-Z]\w{5,17}$/;
			if(reg.test(pass)) {
				/* console.log("格式正确"); */
				$("#bankPassword1").css({color:"green",fontSize:"10px"});
				$("#bankPassword1").empty();
				$("#bankPassword1").append("密码符合规范，继续输入以确认密码");
				$("#confirmPass input").removeAttr("readonly");
			} else {
				/* console.log("格式不正确"); */
				$("#bankPassword1").css({color:"red",fontSize:"10px"});
				$("#bankPassword1").empty();
				$("#bankPassword1").append("必须以字母开头，长度在6-18之间，只能包含字符、数字和下划线");
			}
			
		}
		
		/* 输入时确认密码输入到和密码长度一样并且两个相等时，允许注册按钮可以点击 */
		function confirmPassPropertyChange() {
			var pass1=$("#userPass input").val();
			var pass2=$("#confirmPass input").val();
			if(pass1.length==pass2.length) {
				if(pass1==pass2) {
					$("#bankPassword2").css({color:"green",fontSize:"10px"});
					$("#bankPassword2").empty();
					$("#bankPassword2").append("两次输入密码一致，可以进行注册");
					$("#submitBtn").removeAttr("disabled");
					console.log("前端验证完成，可以注册了（°-°）っ□ 干杯~");
				} else {
					$("#bankPassword2").css({color:"red",fontSize:"10px"});
					$("#bankPassword2").empty();
					$("#bankPassword2").append("两次输入密码不一致");
				}
			}	
		}
		
		/* 输入框离开焦点时判断长度是否一致，不一致肯定密码不一致 */
		function checkAccountPass2() {
			var pass1=$("#userPass input").val();
			var pass2=$("#confirmPass input").val();
			if(pass1.length!=pass2.length) {
				$("#bankPassword2").css({color:"red",fontSize:"10px"});
				$("#bankPassword2").empty();
				$("#bankPassword2").append("两次输入密码不一致");
			}
		}
		
		
	</script>

  </head>
  
  <body>
  <div class="container"> 
    
    <form>
    
    <div id="mainDiv" class="col-lg-5">
    	<h3>企业财务账户注册</h3>
    	<div style="font-size:13px; margin:20px 0 10px 0"><span>请输入企业名称：</span></div>
    	<div id="userAccount" class="input-group">
    		<input class="form-control" id="accountInpt" maxlength="19" type="text" name="cName">
    		<span class="input-group-btn">
    			<button class="btn btn-primary" id="queryBtn" type="button" onclick="getAccountInfo();">查询</button>
    		</span>
    	</div>
    	<div id="userInfo"></div>
    </div> 	
    </form>
  </div>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  </body>
  
</html>
