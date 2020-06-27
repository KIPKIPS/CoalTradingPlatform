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
        flag=0;
        document.getElementById('select').value=0;
        onChange();
    }
    function sellOnmousedown() {

        document.getElementById("supply").style.opacity=0.5;
        document.getElementById("sell").style.opacity=1;
        flag=1;
        document.getElementById('select').value=0;
        onChange();
        console.log(flag);
    }
    function onChange() {
        if(flag==0){

            if(document.getElementById('select').value==0){

                document.getElementById("show1").style.display='block';
                document.getElementById("show2").style.display='none';
                document.getElementById("show3").style.display='none';
                document.getElementById("show4").style.display='none';
                document.getElementById("show5").style.display='none';
                document.getElementById("show6").style.display='none';
            }
            if(document.getElementById('select').value==1){
                console.log("v1");
                document.getElementById("show1").style.display='none';
                document.getElementById("show2").style.display='block';
                document.getElementById("show3").style.display='none';
                document.getElementById("show4").style.display='none';
                document.getElementById("show5").style.display='none';
                document.getElementById("show6").style.display='none';
            }
            if(document.getElementById('select').value==2){
                console.log("v2");
                document.getElementById("show1").style.display='none';
                document.getElementById("show2").style.display='none';
                document.getElementById("show3").style.display='block';
                document.getElementById("show4").style.display='none';
                document.getElementById("show5").style.display='none';
                document.getElementById("show6").style.display='none';
            }
        }
        if(flag==1){

            if(document.getElementById('select').value==0){
                document.getElementById("show1").style.display='none';
                document.getElementById("show2").style.display='none';
                document.getElementById("show3").style.display='none';
                document.getElementById("show4").style.display='block';
                document.getElementById("show5").style.display='none';
                document.getElementById("show6").style.display='none';
            }
            if(document.getElementById('select').value==1){
                document.getElementById("show1").style.display='none';
                document.getElementById("show2").style.display='none';
                document.getElementById("show3").style.display='none';
                document.getElementById("show4").style.display='none';
                document.getElementById("show5").style.display='block';
                document.getElementById("show6").style.display='none';
            }
            if(document.getElementById('select').value==2){
                document.getElementById("show1").style.display='none';
                document.getElementById("show2").style.display='none';
                document.getElementById("show3").style.display='none';
                document.getElementById("show4").style.display='none';
                document.getElementById("show5").style.display='none';
                document.getElementById("show6").style.display='block';
            }
        }

    }

</script>
<style>
    #supply{
        background-color: #4c6ca0;
        width:100px;
        height: 50px;
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
        height: 50px;
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

<div style="width: 100%;height: 10px">
    <a>商品管理</a>
    <div style="background-color: gray;margin-top: 5px; width: 100%;height: 2px"></div>
</div>
<div onmousedown="supplyOnmousedown()" id="supply">

    <p style="margin-left: 30px;margin-top: 15px;text-decoration : none;color: black">求购</p>

</div>
<div onmousedown="sellOnmousedown()" id="sell">
    <p style="margin-left: 30px;margin-top: 15px; text-decoration : none;color: black">出售</p>
</div>
<div style="width: 99.8%;height: 475px;margin-left:100px;margin-top: 44px">

    <select onchange="onChange()" onmousedown="onChange()" id="select" style="margin-left: 102px;width:70px;height: 45px;text-align: center;opacity: 1 ">
        <option value="0">已发布</option>
        <option value="1">待审核</option>
        <option value="2">已下架</option>
    </select>

    <iframe src="SellerGoodInfo/purchPublish?uID=${sessionScope.trader.uID}" id="show1" style="position:absolute;left: 0;right: 0; width: 98.9%;height: 449px;margin-left:6px;display: block;">

    </iframe>
    <iframe src="SellerGoodInfo/purchCheck?uID=${sessionScope.trader.uID}" id="show2" style="position:absolute;left: 0;right: 0;width: 98.9%;height: 449px;margin-left:6px;display: none;">

    </iframe>
    <iframe src="SellerGoodInfo/purchUnder?uID=${sessionScope.trader.uID}" id="show3" style="position:absolute;left: 0;right: 0; width: 98.9%;height: 449px;margin-left:6px;display: none;">

    </iframe>
    <iframe src="SellerGoodInfo/sellerPublish?uID=${sessionScope.trader.uID}" id="show4" style="position:absolute;left: 0;right: 0;width: 98.9%;height: 449px;margin-left:6px;display: none;">

    </iframe>
    <iframe src="SellerGoodInfo/sellerCheck?uID=${sessionScope.trader.uID}" id="show5" style="position:absolute;left: 0;right: 0; width: 98.9%;height: 449px;margin-left:6px;display: none;">

    </iframe>
    <iframe src="SellerGoodInfo/sellerUnder?uID=${sessionScope.trader.uID}" id="show6" style="position:absolute;left: 0;right: 0;width: 98.9%;height: 449px;margin-left:6px;display: none;">

    </iframe>

</div>

</body>
</html>
