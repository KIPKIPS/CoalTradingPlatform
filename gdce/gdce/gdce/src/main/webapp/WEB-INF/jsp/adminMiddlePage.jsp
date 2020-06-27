<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminMiddlePage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		#div1{
    	background: #a0ffa8;
   	 	width:100%;
    	height:110px;
    	}

    	#div1 img{
    	margin-top: 18px;
    	float:left;
    	height:70px;
    	width:auto;
    	}

    	#div1 ul{
   	 	margin-top: 0;
   	 	display: inline;	
    	}

   		#div1 li{
   		text-align: center;
   		margin-top: 30px;
    	list-style: none;
    	float: left;
    	margin-left: 80px;
    	font-family:"YouYuan";
    	font-weight:bold ;
    	font-size: 22px;
    	}
    	
    	.ddiv{  
    	display:block;
        text-align: center;
        height:30px;
        width:120px;
        border: 1px solid ;
        border-radius: 25px;
        text-decoration: none;
    	}
   		.ddiv:hover {
        color: #2f34ff;
        background-color:white;
        border:1px solid darkslategray;
    	}
    	
    </style>

	
	<script type="text/javascript">
	function loadrole(){
	var i = ${admin.roleID}
	if(i==1) {
	window.parent.content.location.href="/News/index1";
	var divcolor2 = document.getElementById('di2');
	var divcolor3 = document.getElementById('di3');
	var divcolor4 = document.getElementById('di4');
	divcolor2.style.color="lightGRAY";
	divcolor3.style.color="lightGRAY";
	divcolor4.style.color="lightGRAY";
	
	}
	else if(i==2){
	 window.parent.content.location.href="/admin/regist_check_list";
	var divcolor1 = document.getElementById('di1');
	var divcolor3 = document.getElementById('di3');
	var divcolor4 = document.getElementById('di4');
	divcolor1.style.color="lightGRAY";
	divcolor3.style.color="lightGRAY";
	divcolor4.style.color="lightGRAY";
	 }
	else if(i==3){
	 window.parent.content.location.href="/Check/CheckManager";
	var divcolor1 = document.getElementById('di1');
	var divcolor2 = document.getElementById('di2');
	var divcolor4 = document.getElementById('di4');
	divcolor1.style.color="lightGRAY";
	divcolor2.style.color="lightGRAY";
	divcolor4.style.color="lightGRAY";
	 }
	else if(i==4){
	 window.parent.content.location.href="/News/toNewsJsp";
	var divcolor1 = document.getElementById('di1');
	var divcolor2 = document.getElementById('di2');
	var divcolor3 = document.getElementById('di3');
	divcolor1.style.color="lightGRAY";
	divcolor2.style.color="lightGRAY";
	divcolor3.style.color="lightGRAY";
	 }
	else if(i==5){
	 window.parent.content.location.href="/News/toNewsJsp";
	var divcolor1 = document.getElementById('di1');
	var divcolor2 = document.getElementById('di2');
	var divcolor3 = document.getElementById('di3');
	var divcolor4 = document.getElementById('di4');
	divcolor1.style.color="lightGRAY";
	divcolor2.style.color="lightGRAY";
	divcolor3.style.color="lightGRAY";
	divcolor4.style.color="lightGRAY";
	 }
	}
	</script>
	
	<script type="text/javascript" language="javascript">
		function checkRole1(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin==1){
            window.parent.content2.location.href="/News/index1";
            }
         else {
          alert("您没有权限进行此操作，详情请联系超级管理员！");
         	 window.parent.content2.location.href="/admin/adminDefaultPage";
         	
        			}
   		 }
	
/* 		通过session获取roleID，判断用户有没有权限进行该操作 */
		function checkRole2(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin==2){
            window.parent.content2.location.href="/admin/regist_check_list";
            }
         else {
         alert("您没有权限进行此操作，详情请联系超级管理员！");
         	window.parent.content2.location.href="/admin/adminDefaultPage";
        			}
   		 }
   		 
   		 function checkRole3(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin==3){
            window.parent.content2.location.href="/Check/CheckManager";
            }
         else {
         	alert("您没有权限进行此操作，详情请联系超级管理员！");
            window.parent.content2.location.href="/admin/adminDefaultPage";
        			}
   		 }
   		 
   		function checkRole4(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin==4){
            window.parent.content2.location.href="/News/toNewsJsp";
            }
         else {
         	alert("您没有权限进行此操作，详情请联系超级管理员！");
            window.parent.content2.location.href="/admin/adminDefaultPage";
        			}
   		 }
   		 
	</script>
	

  </head>
  
  <body onload="loadrole()"> 
     
  <div id="div1">
        <img style="float:left" src="images/logo.jpg">
        <ul id="ul1">
      		<li><div onclick=" checkRole1();" target="content" style="cursor:pointer;" id="di1" class="ddiv">咨询编辑</div></li>
      		<li><div onclick=" checkRole2();" target="content" style="cursor:pointer;" id="di2" class="ddiv">注册审核</div></li>
            <li><div onclick=" checkRole3();" target="content"  style="cursor:pointer;" id="di3" class="ddiv">交易审核</div></li>
            <li><div onclick=" checkRole4();" target="content"  style="cursor:pointer;" id="di4" class="ddiv">咨询审核</div></li>
        </ul>
    </div>

  </body>
<!--   	<script type="text/javascript">
  	window.onload=function(){
	var roleid = ${sessionScope.admin.roleID};
	if(roleid==3){
	var divcolor = document.getElementById('di3');
	divcolor.style.color="red";
		}
	}
	</script> -->
</html>
