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
  <script>
    var flag=0;
    function supplyOnmousedown() {

        document.getElementById("sell").style.opacity=0.5;
        document.getElementById("supply").style.opacity=1;
        document.getElementById("sellercheck").style.display='none';
        document.getElementById("purchcheck").style.display='block'

    }
    function sellOnmousedown() {

        document.getElementById("supply").style.opacity=0.5;
        document.getElementById("sell").style.opacity=1;
        document.getElementById("sellercheck").style.display='block';
        document.getElementById("purchcheck").style.display='none'
    }

</script>
<style>
    #supply{
        background-color: #4c6ca0;
        width:100px;
        height: 42px;
        border: 1px solid black;
        left: 10px;
        position: absolute;
        opacity: 1;
        top:51px;
        border:0px solid;
        border-top-left-radius:5px;
    }
    #sell{
        background-color: #4c6ca0;
        width:100px;
        height: 42px;
        border: 1px solid black;
        top:51px;
        opacity: 0.5;
        left: 110px;
        position: absolute;
        border:0px solid;
        border-top-right-radius:5px;
        
    }
</style>

<body>


    <a style="margin-left:10px;">审核管理</a>

<div onmousedown="supplyOnmousedown()" id="supply">

    <p onclick="rem1()"   style="margin-left: 32px;margin-top: 15px;text-decoration : none;color: black">求购</p>
    <script type="text/javascript">
    function rem1(){
   
var leftiframeid = document.getElementById('purchcheck');//left为对应iframe的id
leftiframeid.src = "SellerGoodInfo/purchCheckSecond";//ileft.html为frame的页面

    }
function changeFrameHeight(){
        var ifm= document.getElementById("purchcheck");
        ifm.height=document.documentElement.clientHeight-56;
        var ifm1= document.getElementById("sellercheck");
        ifm1.height=document.documentElement.clientHeight-56;
    }
    window.onresize=function(){ changeFrameHeight();}
    $(function(){changeFrameHeight();});
    
    </script>

</div>
<div onmousedown="sellOnmousedown()" id="sell">
    <p  onclick="rem2()" style="margin-left: 32px;margin-top: 15px; text-decoration : none;color: black">出售</p>
     
     <script> function rem2(){
   
var leftiframeid = document.getElementById('sellercheck');//left为对应iframe的id
leftiframeid.src = "SellerGoodInfo/sellerCheckSecond";//ileft.html为frame的页面

    }
    
    </script>
    
</div>
<div style="width: 99.8%;height: 475px;">


    <iframe src="SellerGoodInfo/purchCheckSecond" id="purchcheck" onload="changeFrameHeight()"  style="frameborder:0; scrolling:auto;border:2px solid #4c6ca0; position:absolute;left: 0;right: 0;width: 98.9%;height: 550px;margin-top:70px;margin-left:10px;display: block;">

    </iframe>


    <iframe src="SellerGoodInfo/sellerCheckSecond" id="sellercheck" onload="changeFrameHeight()"  style="frameborder:0;scrolling:auto;border:2px solid #4c6ca0;position:absolute;left: 0;right: 0; width: 98.9%;height: 550px;margin-top:70px;margin-left:10px;display: none;">

    </iframe>


</div>


</body>
</html>
