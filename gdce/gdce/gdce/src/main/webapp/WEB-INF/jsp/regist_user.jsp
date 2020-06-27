<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist_user.jsp' starting page</title>
    
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
    
    body{
    	margin:0;
    	background:url(images/registBackground.jpg)no-repeat;
    	background-size:100% 100%;
    }
	</style>
	
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">		
	// 用户名已存在校验	
	function ajaxSubmit(){
	//来源于W3Cschool
 	var xmlHttp;
 	//浏览器兼容
 	try
    {
  	 // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
    }
	 catch (e)
    {
 	 // Internet Explorer
  	 try
      {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
   catch (e)
      {
      try
         {
         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
         }
      catch (e)
         {
         alert("您的浏览器不支持AJAX！");
         return false;
         }
      }
    }
    var name = document.getElementById("uName");
        var Value = name.value;
        var message = document.getElementById("erro_uname");
    
    var span=document.getElementById("erro_uname");
    var username=document.getElementById("uName").value;
    var url="trader/validateTraderName?action=ajax&uName="+username;
    //xmlHttp.open("提交方式",请求地址,是否异步);
	xmlHttp.open("post",url,true);
	//请求参数
    xmlHttp.send(null);
    //指定成功回调函数
    xmlHttp.onreadystatechange=function(){
      if(xmlHttp.readyState==4&&xmlHttp.status==200){
      //后台返回的内容
      var content=xmlHttp.responseText ;
    	var sub=document.getElementById("submit");
      	if(content=="no"){
      		span.innerHTML="<font color='red'>用户名已存在</font>";     	
      	}
      	else if (Value.trim().length < 6 || Value.trim().length > 18) {
            message.style.color = "red";
            message.innerHTML = "用户名称只能是6-18位之间";
            return false;
        } 
        else if (isNaN(Value) == false) {
            message.style.color = "red";
            message.innerHTML = "用户名称不能只含有数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
      		
      }    
   } 
   }
	
    /* 	//用户名合法性检验
    	function checkuName() { 
        var name = document.getElementById("uName");
        var Value = name.value;
        var message = document.getElementById("erro_uname");
        if (Value.trim().length < 6 || Value.trim().length > 18) {
            message.style.color = "red";
            message.innerHTML = "用户名称只能是6-18位之间";
            return false;
        } else if (isNaN(Value) == false) {
            message.style.color = "red";
            message.innerHTML = "用户名称不能只含有数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    } */

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
                message.innerHTML = "√";
                return true;
            }
        }

        //再次输入密码
        function checkreAnswer() {
            var name1 = document.getElementById("uPass");
            var name = document.getElementById("reAnswer");
            var Value1 = name1.value;
            var Value = name.value;
            var uPass = /^[a-zA-Z]\w{5,17}$/;
            
            var message = document.getElementById("messagereAnswer");
            
            if (!uPass.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "字母开头(数字加字母组合,6~18位)";
            return false;
            }
            else if (document.getElementById("uPass").value!=document.getElementById("reAnswer").value) {
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
                message.innerHTML = "√";
                return true;
            }
        }
		
		//判断填写信息不为空
		function check1(){
		var x=document.getElementById('uName');
		var y=document.getElementById('uPass');
		var z=document.getElementById('cAnswer')
		if(x.value==""||y.value==""||z.value==""){
		alert('填写信息不能为空，请填写完全后再提交！');
 		flag = false;
 		return false;}
		return true;      
		}


        //密保答案
        function checkcAnswer() {
            
            var message = document.getElementById("messagecAnswer");
             if (!document.getElementById("cAnswer").value) {
                message.style.color = "red";
                message.innerHTML = "密保答案不能为空";
                return false;
            }
            else {            	
                message.style.color = "green";
                message.innerHTML = "√";
                return true;
            }
        }
</script>
	
  </head>
  
  <body >

     <!-- 主体  -->
    <div style="    height:700px;">
    	    
				<center>
	              	<div style="text-align: center; margin-bottom: 10px; background: transparent;border-radius: 6px;width:50%;">
					      <h1 style="color:black ;font-family:YouYuan;font-weight:bold;">注册国电煤炭平台交易用户</h1>    
				    </div>
				</center>
				<div id=center >
    			<form   action="/trader/firstregist" method="post" onsubmit='return check1()'>
			
				
    			 <div >
						   <label for="exampleInputEmail1">用户名：</label>
						   <input class="form-control" id="uName" name ="uName" onblur="ajaxSubmit()" style="width:200px;">                         
                           <span id="erro_uname" style="color:red;border:1px solid transparent;" ></span>
				 </div>
						  
					  <div  >
					    	<label for="exampleInputEmail1">登录密码：</label>
					    	<input type="password" class="form-control" id="uPass" name ="uPass" onblur="checkuPass()" style="width:200px;">
					    	<span id="messageuPass" style="color:red;border:1px solid transparent"></span>
					  </div>
					  
					  <div  >
					    	<label for="exampleInputPassword1">确认密码：</label>
					    	<input type="password" class="form-control" id="reAnswer" name ="reAnswer" onblur="checkreAnswer()" style="width:200px;">
					    	<span id="messagereAnswer" style="color:red;border:1px solid transparent"></span>
					  </div>
					  
					  <div >
					  	  <label for="exampleInputPassword1">密保问题：</label>
					  	  <br/>
						  <select  name="cQuestion" class="form-control" 
						  style="position: relative;color:black;height:35px;width:200px;border-radius:4px;">
							  <option value="" disabled selected> 请选择</option>
							  <option value="您的出生地在哪里？">您的出生地在哪里？</option>
							  <option value="您的生日？">您的生日？</option>
							  <option value="您母亲的生日？">您母亲的生日？</option>
							  <option value="您父亲的生日？">您父亲的生日？</option>
						  </select>
						  	  <!-- <span style="color:red;border:1px solid transparent" ></span> -->
                      </div>
                      <br/>
                       <div  >
					    	<label for="exampleInputPassword1">密保答案：</label>
					    	<input type="text" class="form-control" id="cAnswer" name ="cAnswer" onblur="checkcAnswer()" style="width:200px;">
					    	<span id="messagecAnswer" style="color:red;border:1px solid transparent"></span>
					   </div>
					  
					  <div>					    					    	
					    	<label for="exampleInputPassword1">验证码：
					    	<input id="verifyCode" class="form-control" name="verifyCode" style="width:100px;"/>
					    	</label>
					    	<img alt="验证码"  id="code" onclick="this.src='admin/createValicode?'+ Math.floor(Math.random()*100)" 
					    	src ="admin/createValicode" style=" width=75px ;height=60px;margin-left:23px;">
					    	<div style="height:40px;width:100px;font-size:10px;margin-left:120px;">看不清请点击图片切换</div><br/>
					    	
					  </div>
					  
					  <input type="submit" class="btn btn-default btn-success"id="register"style="width: 60px; height:26px;font-size:12px;"></input>
					  <div style="text-align: center;float:right;">
					  	<span style="color: black; font-size:16px;">已有账号<a href = "/admin/index" style="color: orange">立即登录</a></span>
					  </div>										  				  	  
					</form>   
					</div>            		
           </div>					
  </body>
</html>

