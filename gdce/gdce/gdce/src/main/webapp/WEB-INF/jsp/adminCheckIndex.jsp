<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminCheckIndex.jsp' starting page</title>
    
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
            /*margin-left: 60px;*/

            width:auto;
            height:80px;
       /*     border:1px solid blue;*/
            text-align: center;

        }
        img{

            width:auto;
            float:left;
            margin-left: 13%;
            height: 100%;

        }
        #div1 ul{
            padding:0px;        
            margin-top: 30px;
            float:left;
            white-space:nowrap;
        }
        #div1 li{
            list-style: none;
            padding: 0px;
            float: left;
            margin-left: 20px;
            font-family:"宋体";
            font-weight:bold ;
            font-size: 17px;
            display: inline;
            
        }
        #div1 li a{
            text-decoration: none;
        }
        
	</style>
	<script type="text/javascript" language="javascript">
/* 		通过session获取roleID，判断用户有没有权限进行该操作 */
		function checkRole2(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin!=2){
            alert("您没有权限进行此操作，详情请联系超级管理员！");
            window.parent.content2.location.href="/admin/adminDefaultPage";
            }
         else {
         	window.parent.content2.location.href="/admin/regist_check_list";
        			}
   		 }
   		 
   		 function checkRole3(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin!=3){
            alert("您没有权限进行此操作，详情请联系超级管理员！");
            window.parent.content2.location.href="/admin/adminDefaultPage";
            }
         else {
         	window.parent.content2.location.href="/Check/CheckManager";
        			}
   		 }
   		 
   		function checkRole4(){
        var isAdmin = ${sessionScope.admin.roleID};
        if(isAdmin!=4){
            alert("您没有权限进行此操作，详情请联系超级管理员！");
            window.parent.content2.location.href="/admin/adminDefaultPage";
            }
         else {
         	window.parent.content2.location.href="/News/toNewsJsp";
        			}
   		 }
   		 
	</script>
  </head>
  
  <body>
        <div id="div1">
        <ul id="ul1">
            <li><div onclick=" checkRole2();" target="content2" style="cursor:pointer;" >用户信息</div></li>
            <li><div onclick=" checkRole3();" target="content2" style="cursor:pointer;" >买卖挂牌信息</div></li>
            <li><div onclick=" checkRole4();" target="content2" style="cursor:pointer;" >资讯信息</div></li>
        </ul>
    </div>
  </body>
</html>
