<%@page import="com.isscollege.users.entity.Uncheck_regist"%>
<%@page import="com.isscollege.users.service.impl.Show_uncheckregist_serviceimpl"%>
<%@page import="com.isscollege.users.dao.regist_check_Dao"%>
<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rigist_check_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<div style="width:70%; margin-left:15%; margin-right:15%">
<div style="width:100px; height:23px; background-color:#00C">
<font face="Microsoft YaHei UI" color="#FFFFFF">用户基本信息</font>
</div>
<div style="height:7px; background-color:#00C"></div>

<table border="0" cellspacing="0" cellpadding="0" style="width:100%" rules="rows">
  			<tr>
            <td style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">企业名称:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cName}</font>
            </td>
            </tr>
            <tr>
            <td  style="text-align:right; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">企业简称:</font>
            </td>
            <td style="width:5%">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cEasyName}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">法人代表:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cLegalPerson}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">注册地区:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cAddress}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">注册资金(万元):</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cMoney}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">联系人:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.uRealName}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">联系电话:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.uTelephone}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">传真:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cFax}</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:40%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">企业邮箱:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td  style="text-align:left; width:55%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cEmile}</font>
            </td>
            </tr>
</table>
</div>
<div style="width:70%; margin-left:15%; margin-right:15%">
<div style="width:100px; height:25px; background-color:#00C; display:inline">
<font face="Microsoft YaHei UI" color="#FFFFFF">相关资质查看</font></div>
    <div align="right" style="width:80px; float:right; display:inline">
    <font face="Microsoft YaHei UI" color="#000000" size="-1">有效期至</font>
    </div>
<div style="height:7px; background-color:#00C"></div>

<table border="0" cellspacing="0" cellpadding="0" style="width:100%" rules="rows">
  			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">营业执照号:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cBusinessLicense}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/download?item=cBusinessLicense&cName=${ur.cName}&uID=${ur.uID}" style="color:#00C;text-decoration:none; ">文件下载</a></font>
            </td>
            <td style="text-align:right; width:20%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">2020-1-1</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">税务登记号:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cTax}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/download?item=cTax&cName=${ur.cName}&uID=${ur.uID}" style="color:#00C;text-decoration:none; ">文件下载</a></font>
            </td>
            <td style="text-align:right; width:20%;height:50px">
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">组织机构代码证号:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cOrg}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/download?item=cOrg&cName=${ur.cName}&uID=${ur.uID}" style="color:#00C;text-decoration:none; ">文件下载</a></font>
            </td>
            <td style="text-align:right; width:20%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">2020-1-1</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">开户行:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cBank}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            </td>
            <td style="text-align:right; width:20%;height:50px">
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">开户行账户:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cBankAccount}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/download?item=cBankAccount&cName=${ur.cName}&uID=${ur.uID}" style="color:#00C;text-decoration:none; ">文件下载</a></font>
            </td>
            <td style="text-align:right; width:20%;height:50px">
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">煤炭经营许可证号:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cPermission}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/download?item=cPermission&cName=${ur.cName}&uID=${ur.uID}" style="color:#00C;text-decoration:none; ">文件下载</a></font>
            </td>
            <td style="text-align:right; width:20%;height:50px">
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">法人身份证:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cLegalPersonID}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000"><a href="registcheck/download?item=cLegalPersonID&cName=${ur.cName}&uID=${ur.uID}" style="color:#00C;text-decoration:none; ">文件下载</a></font>
            </td>
            <td style="text-align:right; width:20%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">2020-1-1</font>
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">可控煤炭资源(煤源，储煤产地)情况:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cResource}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            </td>
            <td style="text-align:right; width:20%;height:50px">
            </td>
            </tr>
              			<tr>
            <td  style="text-align:right; width:25%; height:50px">
            <font face="Microsoft YaHei UI" color="#000000">运输保障能力:</font>
            </td>
            <td style="width:5%;height:50px">
            </td>
            <td style="text-align:left; width:40%;height:50px">
            <font face="Microsoft YaHei UI" color="#000000">${ur.cTransport}</font>
            </td>
            <td style="text-align:center; width:10%;height:50px">
            </td>
            <td style="text-align:right; width:20%;height:50px">
            </td>
            </tr>
</table>
<div style="height:10px"></div>
    <div align="right" style="width: 25%; float: left; display: inline; height: 200px">
    <font face="Microsoft YaHei UI" color="#000000">供应商简介:</font>
    </div>
        <div align="left" style="width: 70.3%; float: right; display: inline; height: 200px">
    <textarea style="width:500px; height:200px">
${ur.cBrief}
    </textarea>
    </div>
    <div style="height:220px">
    </div>
    <hr>
<div style="width:100px; height:25px; background-color:#00C; display:inline">
<font face="Microsoft YaHei UI" color="#FFFFFF">审核</font></div>
<div style="height:7px; background-color:#00C"></div>
<div style="height:10px"></div>
<div align="right" style="width: 25%; float: left; display: inline; height: 200px">
    <font face="Microsoft YaHei UI" color="#000000">审核意见:</font>
    </div>
        <div align="left" style="width: 70.3%; float: right; display: inline; height: 200px">
   <form action="/registcheck/nopass" mathod="post"> 
   <textarea  name= "uID" id="uID" style="display:none">${ur.uID}</textarea>
</textarea>
   <textarea  name= "uopinion" id="uopinion" style="width:500px; height:200px">
</textarea>
    </div>
        <div style="height:220px">
    </div>

    <div align="center">
    <table border="0">
    <tr>
        <td align="center" style="width:20%"><input style="width:170px" type="submit" value="驳回"></td>
    <td align="center" style="width:20%"></td>
    </form>
    <td align="center" style="width:20%"><button style="width:170px" onclick="pass(${ur.uID})">通过</button></td>
    <td align="center" style="width:20%"></td>
    <td align="center" style="width:20%"><button style="width:170px" onclick="back()">返回</button></td>
        <script>
    function pass(uid)
    {
        window.location.href='registcheck/pass?uID='+uid;
    }
        function back()
    {
        window.location.href='registcheck/showlist';
    }
    </script>
    </tr>
    </table>
    </div>
    </div><br>
  </body>
</html>
