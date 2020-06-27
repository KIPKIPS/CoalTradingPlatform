<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminRegist.jsp' starting page</title>
    
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
    th{text-align:center}
    </style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	//原生ajax
	//用户用户名是否重复验证
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
    
    //去后台验证
    var span=document.getElementById("state");
    var username=document.getElementById("adminName").value;
    if(username=='')
    {
    	span.innerHTML="<font color='red'>请输入用户名</font>";
    	return false;
    }
    var url="secondaryAdminManage/validateAdminName?action=ajax&adminName="+username;
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
      	}else{
      		span.innerHTML="<font color='green'>√</font>";
      	}	
      }    
   } 
   }
   
   //密码验证
   function checkPassword(){
		var password = document.getElementById("adminPass").value;
		var notice = document.getElementById("pass1");
		if(password.length>=6&&password.length<=12){
			notice.style.color="green";
			notice.style.fontSize="17px";
			notice.innerHTML="√";
			return true;
		}else {
			notice.style.color="red";
			notice.style.fontSize="13.5px";
			notice.innerHTML="密码请输入6~12位";
			return false;
			
		}
	}
	
	
	//密码重复验证
	   function checkPassword1(){
		var password = document.getElementById("adminPass").value;
		var password1 = document.getElementById("adminPass2").value;
		var notice = document.getElementById("pass2");
		if(password1== password && password!=''){
			notice.style.color="green";
			notice.style.fontSize="17px";
			notice.innerHTML="√";
			return true;
		}else if(password1!=''){
			notice.style.color="red";
			notice.style.fontSize="13.5px";
			notice.innerHTML="密码两次不一致!";
			return false;
			
		}else {
			notice.style.color="red";
			notice.style.fontSize="13.5px";
			notice.innerHTML="密码请输入6~12位";
			return false;
		}
	}
	
	//电话验证
	
		function checkPhone(){
			var TEL_REGEXP = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;      /* 电话正则表达式 */
			var phoneNumber = document.getElementById("adminTelephone").value;
			var notice = document.getElementById("phone");
			if(TEL_REGEXP.test(phoneNumber)){
			notice.style.color="green";
			notice.style.fontSize="17px";
			notice.innerHTML="√";
			return true;
			}else{
			notice.style.color="red";
			notice.style.fontSize="13.5px";
			notice.innerHTML="电话号码不规范!";
			return false;
			}
		}
		
	//真实姓名认证	
	function checkRealname(){
		var notice = document.getElementById("real");
		var realName = document.getElementById("adminRealName").value;
		if(realName==""){
			notice.style.color="red";
			notice.style.fontSize="13.5px";
			notice.innerHTML="真实姓名不能为空!";
			return false;
		}else{
			notice.style.color="green";
			notice.style.fontSize="17px";
			notice.innerHTML="√";
			return true;
		}
	}
		
	//所有信息验证，验证通过后可以点击创建	
		function checkAll(){
			var check1 = checkPassword();
			var check2 = checkPassword1();
			var check3 =checkPhone();
			var check4 = checkRealname();
			var sub=document.getElementById("submit");
			if(check1 && check2 && check3&&check4)
				sub.disabled=false;
			else 
				sub.disabled=true;
		}
   
	</script>
	
	<style type="text/css">
	#center {
        position: absolute;
        top: 38%;
        left: 50%;
        -ms-transform: translate(-50%,-50%);
        -moz-transform: translate(-50%,-50%);
        -o-transform: translate(-50%,-50%);
        transform: translate(-50%,-50%); 
    }
    
    
.main{
			width:450px;
			
            background-color: rgba(102, 146, 191, 0.44);
            /*边框*/
            border: solid 1px rgba(102, 146, 191, 0.68);
            /*边角弧度*/
            border-radius: 10px;
            /*阴影*/
/*             -moz-box-shadow:2px 2px 5px #333333; 
            -webkit-box-shadow:2px 2px 5px #333333; 
            box-shadow: 7px 15px 30px #285a63; */
}

.main:hover{
    /*边框*/
    border: solid 1px rgba(102, 146, 191, 0.68);
    /*边角弧度*/
    border-radius: 10px;
/*     box-shadow: 7px 15px 30px #285a63; */
}

	</style>
  </head>
  
  <body>
<div id="center">
	<div class="main">
		<div style="margin-left: 70px;margin-top: 20px">
		<fieldset> 
			<form action="secondaryAdminManage/register" method="post">
				<div>
					 <label for="exampleInputEmail1">用户名称:</label>
					 <input class="form-control" style="width: 300px" name="adminName" id="adminName" onchange="ajaxSubmit()" onblur="ajaxSubmit()" /><span id="state"></span><br/>
				</div>
				<div>
					 <label for="exampleInputPassword1">用户密码</label>
					 <input class="form-control" style="width: 300px" name="adminPass" id="adminPass" onchange="checkAll()" onblur="checkPassword()" type="password"/><span style="color:red;font-size:13.5px" id="pass1"></span><br/>
				</div>
				<div>
					 <label for="exampleInputPassword1">确认密码</label>
					 <input class="form-control" style="width: 300px" name="adminPass2" id="adminPass2" onchange="checkAll()" onblur="checkPassword1()" type="password"/><span style="color:red;font-size:13.5px" id="pass2"></span><br/>
				</div>
				<div>
					 <label for="exampleInputPassword1">真实姓名</label>
					 <input class="form-control" style="width: 300px" name="adminRealName" id="adminRealName" onchange="checkAll()" onblur="checkRealname()" ><span style="color:red;font-size:13.5px;" id="real"></span><br/>
				</div>
				<div>
					 <label for="exampleInputPassword1">联系电话</label>
					 <input class="form-control" style="width: 300px" name="adminTelephone" id="adminTelephone" onchange="checkAll()" onblur="checkPhone()" ><span style="color:red;font-size:13.5px" id="phone"></span><br/>
				</div>
				<div>
					 <label for="exampleInputPassword1">权限类型</label>
					 <select name="roleID" style="width: 140px;margin:5px 5px" >
                		<option value="1">资讯编辑人员</option>
                		<option value="2">注册用户审核人员</option>
                		<option value="3">交易审核人员</option>
                		<option value="4">资讯审核人员</option>
                		<option value="5">资讯维护人员</option>
                		<option value="6">超级管理员</option>
                		</select>
        				<br/>
        		</div>
				<div style="margin-left: 70px;margin-bottom: 10px;margin-top: 10px">
				<input  class="btn btn-default btn-success" style="margin-left: -70px" type="submit" id="submit" value="创建" disabled="true">
            	<a href="secondaryAdminManage/"><input style="margin-left: 20px" class="btn btn-default btn-danger" type='button' value="退出"></a>
				</div>
        	</form>
        	</fieldset>
		</div>
	</div>
  </body>
</html>
