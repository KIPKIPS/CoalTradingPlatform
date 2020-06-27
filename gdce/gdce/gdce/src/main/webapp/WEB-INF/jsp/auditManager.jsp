<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" %>   
<%@ page import="com.mysql.jdbc.Driver" %>   
<%@ page import="java.sql.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllUsers.jsp' starting page</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style>
        #pass{
            background-color: #0085ff;
            width:100px;
            height: 25px;
            border: 1px solid black;
            margin-top: 50px;
            position: absolute;
            margin-left:40%;
        }
        #notPass{
            background-color: #0085ff;
            width:100px;
            height: 25px;
            border: 1px solid black;
            margin-top: 50px;
            margin-left:50%;
            position: absolute
        }
    #pass:active{
        opacity: 0.5;
    }
        #notPass:active{
            opacity: 0.5;
        }
</style>
<script>
    function textOnfocus() {
        if(document.getElementById("text").placeholder=='请输入审核意见')
            document.getElementById("text").placeholder=''
    }
    //判断字数限制
    function  textOnblur() {
        if(!document.getElementById("text").placeholder)
            document.getElementById("text").placeholder='请输入审核意见'
    }
    String.prototype.getBytes = function() {
        var cArr = this.match(/[^\x00-\xff]/ig);
        return this.length + (cArr == null ? 0 : cArr.length);
    };
    var num=0;
    function textLimitCheck(thisArea, maxLength){
        var len = thisArea.value.getBytes();
        if (len > maxLength)
        {
            alert(maxLength + ' 个字限制. \r超出的将自动去除.');
            var tempStr = "";
            var areaStr = thisArea.value.split("");
            var tempLen = 0;
            for(var i=0,j=areaStr.length;i<j;i++){
                tempLen += areaStr[i].getBytes();
                if(tempLen<=maxLength){
                    tempStr += areaStr[i];
                }
            }
            thisArea.value = tempStr;

            thisArea.focus();
        }
        num=len;
        /*回写span的值，当前填写文字的数量*/
        messageCount.innerText = thisArea.value.length;
    }
    function notPass() {
        if(num==0){
            alert("请填写审核不通过详细信息！！！")
        }
    }
</script>
<body>
<iframe src="/SellerGoodInfo/purchpublish" style="width: 100%;height: 200px">

</iframe>
<p>审核意见：</p>
<textarea type="text" id="text" onKeyUp="textLimitCheck(this, 250);"spellcheck="false" style="width: 100%;height: 100px;" placeholder="请输入审核意见" onfocus="textOnfocus()" onblur="textOnblur()" ></textarea>
<br/>(限 250 个字符  已输入 <font color="#CC0000"><span id="messageCount">0</span></font> 个字)
<div id="pass">

    <p style="margin-left: 15px;margin-top: 1px;text-decoration : none;color: black">审核通过</p>

</div>
<div id="notPass" onmousedown="notPass()">
    <p style="margin-left: 8px;margin-top: 1px; text-decoration : none;color: black">审核不通过</p>
</div>

</body>
</html>
