<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tradeLeftPage2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style>
        #div1{
            display: table-cell;
            width:180px;
            height:700px;
            border-radius: 15px;
            background-color: #a0ffa8;
        }
        a{
            font-size: 18px;
            font-family: "YouYuan";
            text-align: center;
            line-height: 50px;
            color: #ffffff;
            text-decoration: none;
        }

        .div2{
            margin-top: 50px;
            margin-left: 12px;
            text-align: center;
            width:150px;
            height:45px;
            border-radius: 10px;
            background: #5a9aff;
        }

    </style>
	
	<script type="text/javascript">
	
	    function cue(){
			alert("功能待开发！")
		} 
		//识别交易用户的注册状态		 
	    function identify_trader_state1(){
			var i = ${trader.uState};
			//i等于1、2时，只能看，等于3时，可以交易
			if(i==1){
				alert("您尚未完善企业详细信息，请完善后再进行相应操作！");
				window.parent.content2.location.href="/trader/sedregistpage";
			}
			else if(i==2){
				alert("企业详细信息审核中，请耐心等候！");				
			}
			else window.parent.content2.location.href="/trader/deal_purch";
		}  
		
		  function identify_trader_state2(){
			var i = ${trader.uState};
			//i等于1、2时，只能看，等于3时，可以交易
			if(i==1){
				alert("您尚未完善企业详细信息，请完善后再进行相应操作！");
				window.parent.content2.location.href="/trader/sedregistpage";
			}
			else if(i==2){
				alert("企业详细信息审核中，请耐心等候！");				
			}
			else window.parent.content2.location.href="/trader/deal_seller";
		}
	</script>
	
  </head>
  
  <body>
    	<div id="div1">
            <div class="div2">
                <a href="/trader/tradeProducts_list" target="content2">商品列表</a>
            </div>
            <div class="div2">
                <a onclick="identify_trader_state1()" style="cursor:pointer;">买家发布商品</a>
            </div>
            <div class="div2">
                <a onclick="identify_trader_state2 ()" style="cursor:pointer;">卖家发布商品</a>
            </div>
            <div class="div2">
                <a onclick="cue()" style="cursor:pointer;">竞价采购</a>
            </div>
            <div class="div2">
                <a onclick="cue()" style="cursor:pointer;">竞价拍卖</a>
            </div>              
    </div>
  </body>
</html>
