<%@page import="com.isscollege.users.utils.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminManage.jsp' starting page</title>
    
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
    
    
/*     S
    $(document).ready(function(e) { 
    var counter = 0;
    if (window.history && window.history.pushState) {
        $(window).on('popstate', function () {
            window.history.pushState('forward', null, '#');
            //window.location.href="ad.html";   // 回退时跳转到新页面
            window.history.forward(1);
            alert("不可回退");
        });
    }

    window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
    window.history.forward(1);
});
     */
    
/*     表格隔行变色 */
    function SetTableColor() {

  	var tbl = document.getElementById("tblMain");
  	var trs = tbl.getElementsByTagName("tr");
    var color = 0;
  	for (var i = 1; i < trs.length; i++) {
 	var j = i + 1;
 	if (j % 2== 0) { 
   	trs[i].style.background = "#ffffff";
 	}else if(color == 1){
	trs[i].style.background = "#fcf8e3";
	color = 0;
	}else if(color == 0)
	{
	trs[i].style.background = "#dff0d8";
	color = 1;
	}
	
}
}
    </script>

  </head>
 
  <body onload="SetTableColor()">
		<div class="col-md-12 column">
			<h3 class="text-center text-info">
				平台用户人员管理
			</h3>
		</div>    
<div class="container">
	<div class="row clearfix">
		<div>
			<table id="tblMain" class="table table-hover table-bordered">
				<thead>
					<tr>
					<th>管理员编号</th><th>管理员名称</th><th>真实姓名</th><th>管理员电话</th><th>权限类型</th><th>修改权限</th><th>权限确认</th><th>删除角色</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="adminWithRole" items="${adminManageList}">
						<tr>
						<th>${adminWithRole.admin.adminID}</th>
  						<th>${adminWithRole.admin.adminName}</th>
  						<th>${adminWithRole.admin.adminRealName}</th>
  						<th>${adminWithRole.admin.adminTelephone}</th>
  						<th>${adminWithRole.role.roleName}</th>
  						<th>
  							<div>
            				<select id="${adminWithRole.admin.adminID}:roleID">
                				<option value="0">--------不改动--------</option>
                				<c:forEach var="role" items="${roleList}">
                					<option value="${role.roleID}">${role.roleName}</option>
                				</c:forEach>
                			</select>
                			</div>
       	 				</th>
        <th>
            <button type="button" class="btn btn-block btn-default btn-info" onclick="modify(${adminWithRole.admin.adminID})">确认修改</button>
            <script>
            	function modify(adminID){
            		var flag=confirm("是否确认修改？");
            		var select = document.getElementById(adminID+":roleID");
            		if(select.value=="0"){
            			alert("请选择要修改的权限！");
            			return false;
            			}
            		if(flag){
            			location.href="secondaryAdminManage/modifyRole?adminID="+adminID+"&roleID="+select.value;
            		}
            	}
            </script>
        </th>
        <th>
            <button class="btn btn-block btn-default btn-danger" onclick="remove(${adminWithRole.admin.adminID})">删除</button>
            <script>
    				function remove(adminID){
    					var flag=confirm("是否确认删除?");
    					if(flag){
    						location.href="secondaryAdminManage/remove?adminID="+adminID;
    					}
    				}
    		</script>
        </th>
  						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<center>
<a href="secondaryAdminManage/toRegister"><button class="btn btn-default btn-primary">创建二级管理员</button></a>
<a href="admin/logout"><button class="btn btn-default btn-primary">退出系统</button></a>
</center>
  </body>
</html>

