<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style type="text/css">
	 #a{
	 position:relative;
	 top:190px;
	
	 }
	body{
	
	background-image:url(images/yh.jpg);
	
	background-attachment：fixed;
	}
	#b{
	 position:relative;
	 left:80px;
	 color:blue;
	}
	 #code{
	 position:relative;
	 top:10px;
	 left:5px;
	 }
	 #c{
	 width:400px;
	 height:200px;
	  background-color:#FFF0f5;
	 }
	 #d{
	 position:relative;
	 left:0px;
	 color:#9400D3;
	 }
	 #inputcode{
	 width:100px;
	  position:relative;
	  left:10px;
	 }
	 #login{
	 position:relative;
	 top:20px;
	 }
	 #regist{
	 position:relative;
	 top:20px;
	 left:20px;
	 }
	</style>
  <script type="text/javascript">
	      function $(id){
          return document.getElementById(id);
      }
  function changeCode(){
   $("code").src = "ValidateCodeServlet?a="+new Date();
  }
	
	
	
		function check(){
			var x=document.getElementById('inputname');
			var y=document.getElementById('inputpass');
			if(x.value==""||y.value==""){
				alert('用户名和密码不能为空');
 				return false;
 			} else if(!checkNumber(x.value)) {
 				alert("输入的账号不是19位数字，不符合规范。");
 				return false;
 			} else if(!isValidCard(x.value)) {
 				alert("不是符合规范的账号！");
 				return false;
 			} else if(!checkPass(y.value)) {
 				alert("密码不符合规范！");
 				return false;
 			}

			return true;      
		}
		
		//验证是否为19位数字
 		function checkNumber(value) {
			eval("var reg = /\^[0-9]{" + 19 + "\}$/;");
			var re = new RegExp(reg);
			if(re.test(value)) {
				return true;
			} else {
				return false;
			}
		}
		
		//luhn算法验证账号是否符合规范
		function isValidCard(num) {
				num = (num + '').replace(/\D+/g, '').split('').reverse();
				if(!num.length) {
					return false;
				}
				var total = 0,
					i;
				for(i = 0; i < num.length; i++) {
					num[i] = parseInt(num[i]);
					total += i % 2 ? 2 * num[i] - (num[i] > 4 ? 9 : 0) : num[i];
				}
				if(total === 0) {
					return false;
				}
				return(total % 10) == 0;
		}
		
		//验证密码是否符合规范
		function checkPass(pass) {
			var reg=/^[a-zA-Z]\w{5,17}$/;
			if(reg.test(pass)) {
				return true;
			} else {
				return false;
			}
		}

	</script>
  <body>
  <div id="b">
  欢迎光临
  </div>
    <center>
   <div id="a">
   <form action="bank/login" method="post"  id="myform" onsubmit='return check()'>
   <fieldset id="c">
       <div id="d">用户登录</div>    </br>
                                    用户名称:<input id="inputname" name="bankAcount" /><br/><br/>
   			用户密码:<input id="inputpass"type="password" name="bankPassword" /><br/>
   		            验证码:<input id="inputcode" name="verifyCode" />
    		<img alt="验证码"  id="code" onclick="this.src='bank/createValicode?'+ Math.floor(Math.random()*100)" src ="bank/createValicode" width=72px height=50px;><br>
    		<input type="submit" value="登录 " id="login"/>
    		<input  id="regist" type = "button" value = "注册账号"  onclick = "window.location.href = 'bank/toRegist'">
   </fieldset>
   </form>
   </div>
   </center>
   
  </body>
</html>
