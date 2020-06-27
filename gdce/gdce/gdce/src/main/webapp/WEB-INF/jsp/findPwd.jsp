<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findPwd.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    
	<!-- <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	 -->
	
	<style>
	#center {
        position: absolute;
        margin-top: 300px;
        left: 50%;
        -ms-transform: translate(-50%,-50%);
        -moz-transform: translate(-50%,-50%);
        -o-transform: translate(-50%,-50%);
        transform: translate(-50%,-50%); 
    }
    
    body{    //全屏背景图
    	margin:0;
    	background:url(images/registBackground.jpg)no-repeat;
    	background-size:100% 100%;
    }
    
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">	</script>	
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	
	<script type="text/javascript">
	
	/*  //用户名
    function checkuName() {
        var name = document.getElementById("uName");
        var Value = name.value;
        var uName = /^[a-zA-Z]\w{5,17}$/;
        var message = document.getElementById("messageuName");
        if (!uName.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "长度为6-18，以字母开头，不可有特殊字符";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }
 */
    //密码校验

    function checkuPass() {
        var name = document.getElementById("uPass");
        var Value = name.value;
        var uPass = /^[a-zA-Z]\w{5,17}$/;
        var message = document.getElementById("messageuPass");
        if (!uPass.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "字母开头(数字加字母组合,6~18位)";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = " ";
            return true;
        }
    }

    //再次输入密码
    function checkrePass() {
        var name1 = document.getElementById("uPass");
        var name = document.getElementById("rePass");
        var Value1 = name1.value;
        var Value = name.value;
        var uPass = /^[a-zA-Z]\w{5,17}$/;

        var message = document.getElementById("messagerePass");
        if (!uPass.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "字母开头(数字加字母组合,6~18位)";
            return false;
        }
        else if (document.getElementById("uPass").value != document.getElementById("rePass").value) {
            message.style.color = "red";
            message.innerHTML = "两次密码不一致";
            return false;
        }
        else if (!document.getElementById("uPass").value) {
                message.style.color = "red";
                message.innerHTML = "密码不能为空";
                return false;
            }
        else {
            message.style.color = "green";
            message.innerHTML = " ";
            return true;
        }
    }
	
	//判断填写信息不为空
		function check1(){
		var o=document.getElementById('rePass')
		var x=document.getElementById('uName');
		var y=document.getElementById('uPass');
		var z=document.getElementById('cAnswer')
		if(x.value==""||y.value==""||z.value==""||o.value==""){
		alert('填写信息不能为空，请填写完全后再提交！');
 		flag = false;
 		return false;}
		return true;      
		}
    /* //密保答案
    function checkcAnswer() {
        var name = document.getElementById("cAnswer");
        var Value = name.value;
        var cAnswer = /^.{1,20}$/;
        var message = document.getElementById("messagecAnswer");
        if (!cAnswer.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "格式有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    } */

  /*   //验证码
    function checkVerify() {
        var name = document.getElementById("verify");
        var Value = name.value;
        var verify = /^\d{6}$/;
        var message = document.getElementById("messageVerify");
        if (!verify.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "应为6位数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    } */
	
</script>
  </head>
  
  <body >
   
     <!-- 主体  -->
    <div  style=" height: 700px;">
    			<center>
	              	<div style="text-align: center; margin-bottom: 10px;background: transparent;border-radius: 6px;width:50%;">
					      <h1 style="color: black;font-family:YouYuan;font-weight:bold;">找回密码</h1>					     
				    </div>
   				</center>
   				<div id = center>
    			<form   action="trader/findPwd" method="post"  >    				
					    <div>
						   <label for="exampleInputEmail1">用户名：</label>
						   <input  class="form-control" id="uName" name ="uName" onblur="checkuName()" style="width:200px;">
						   <span id="messageuName" style="color:red;border:1px solid transparent;"></span>
					  </div>
					  
					  <div>
					  	  <label for="exampleInputEmail1">密保问题：</label>
						  <select class="form-control" name="cQuestion" style="position: relative;color:black;width:200px;">
							  <option value="" disabled selected> 请选择</option>
							  <option value="您的出生地在哪里？">您的出生地在哪里？</option>
							  <option value="您的生日？">您的生日？</option>
							  <option value="您母亲的生日？">您母亲的生日？</option>
							  <option value="您父亲的生日？">您父亲的生日？</option>
						  </select>
						  <!-- <span style="color:red;border:1px solid transparent"></span> -->
                      </div><br/>
                      
                       <div>
					    <label for="exampleInputEmail1">密保答案：</label>
					    <input type="password" class="form-control" id="cAnswer" name ="cAnswer"  onblur="checkcAnswer()" style="width:200px;">
					    <span id="messagecAnswer" style="color:red; border:1px solid transparent;"></span>
					  </div>
					   <div>
					    <label for="exampleInputEmail1">新密码：</label>
					    <input type="password" class="form-control" id="uPass" name ="uPass" onblur="checkuPass()" style="width:200px;">
					    <span id="messageuPass" style="color:red;border:1px solid transparent"></span>
					  </div>
					  <div>
					    <label for="exampleInputEmail1">确认密码：</label>
					    <input type="password" class="form-control" id="rePass" name ="rePass" onblur="checkrePass()" style="width:200px;">
					    <span id="messagerePass" style="color:red;border:1px solid transparent"></span>
					  </div>
					  <div>					    					    	
					    	<label for="exampleInputPassword1">验证码：
					    	<input id="verifyCode" class="form-control" name="verifyCode" style="width:100px;"/>
					    	</label><img alt="验证码"  id="code" onclick="this.src='admin/createValicode?'+ Math.floor(Math.random()*100)" 
					    	src ="admin/createValicode" style=" width=75px ;height=60px;margin-left:23px;">
					    	<div style="height:40px;width:100px;font-size:10px;margin-left:120px;">看不清请点击图片切换</div><br/>
					    	
					  </div>
					  
					  <input type="submit" id="findPwd" class="btn  btn-primary submit" style="width: 80px;height:26px;" ></input>					  
						<div style="text-align: center;float:right;">
					  	<span style="color: black; font-size:13px;">放弃找回<a href = "/admin/index" style="color: orange;">返回登录</a></span>
					  </div>
					</form>		
				</div>
			</div>		
  </body>
</html>
