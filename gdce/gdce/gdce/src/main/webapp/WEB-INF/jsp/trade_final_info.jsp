<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'purch_delisting_back.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	@import"css/bootstrap.min.css";
	</style>
 <style type="text/css">
		
		#bottom{
				/*border:1px solid green;*/
				width:1250px;
				height: 199px;
			}
			irfame{float:left;
			}
			#but1{
			}
			#header{width: 400px;
				height: 80px;
				
				padding-left: 160px;
				margin-top:50px;
				
			}
				#ul1{
			
				margin: auto;
				padding-left: 160px;
				}
				#uploadback{
				width:100px;
				height:30px;
				}
				#fieldset1{
				margin-left:0px;
				margin-top:70px;
				float:left;
				background:url(images/background01.jpg);
				}
				#div1{
			
				margin-left:250px;
				}
				
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
		
	function uploadback(){window.location.href = 'order/uploadBankReceipt?orderNo=20190617160618101'
	}
	function uploadpage(){
	document.getElementById("form1").style.display='none';
	document.getElementById("form2").style.display='none';
	document.getElementById("form3").style.display='none';
		if(${traderControl}==1){
		document.getElementById("").style.display='';
		}
		else if(${traderControl}==2){
		document.getElementById("form2").style.display='';
		}
		else if(${traderControl}==3){
		document.getElementById("form1").style.display='';
		}
		else if(${traderControl}==4){
		document.getElementById("form3").style.display='';
		}
	}
	function doAjax2(){

	$.ajax({
        type: "post", //数据发送的方式（post 或者 get）
       url:"http://localhost:8082/logistics_system/waybill/http://localhost:8082/logistics_system/waybill/insertWaybillInfo",//要发送的后台地址
        data:"lod_name="+ $("#logisticsbus2").val()+"&trade_id= ${tradeNo}&good_source=" + $("#sPlace2").val()
        +"&good_destination=${good_destination}&log_weight=${log_weight}",
        //要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType: "json", //后台处理后返回的数据格式
        success: function(msg) {//ajax请求成功后触发的方法
            alert('请求成功');
        },
        error: function(msg) {//ajax请求失败后触发的方法
            alert(msg); //弹出错误信息
        }
    });
		
}
	</script>
  </head>
  
  <body onload=uploadpage()>
<!--  
<div id="div1">
<form id="form1" name="Form1" action="order/completeInfoSellorListingSellorCommit?tradeNo=${tradeNo}" method="post"  enctype="multipart/form-data">
      		交易方式:<input id="inputname" name="exchangeMeans" /><br/>
   			物流商:<input id="inputpass" name="logisticsbus" /><br/>
<input type="submit" value="卖方挂牌卖方提交信息"/></form>
<form  id="form2" name="Form2" action="order/completeInfoSellorListingPurchCommit?tradeNo=${tradeNo}" method="post"  enctype="multipart/form-data">
  			到货地:<input id="inputname" name="deliveryPlace" /><br/>
   			
<input type="submit" value="卖方挂牌买方提交信息"/></form>
<form id="form3" name="Form3" action="order/completeInfoPurchListingSellerCommit?tradeNo=${tradeNo}" method="post"  enctype="multipart/form-data">
			货源地:<input id="inputpass" name="sPlace" /><br/>
  			交易方式:<input id="inputname" name="exchangeMeans" /><br/>
   			物流商:<input id="inputpass" name="logisticsbus" /><br/>
<input type="submit" value="买方挂牌卖方提交信息"/></form>
</div>
-->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" id="form1" name="Form1" action="order/completeInfoSellorListingSellorCommit?tradeNo=${tradeNo}" method="post"  enctype="multipart/form-data">
				<div class="form-group">
					 <label for="exampleInputEmail1">交易方式:</label><select  name="exchangeMeans" class="form-control" id="exampleInputEmail1"  />
					<option value="线上交易">线上交易
					</option>
					<option value="线下交易">线下交易
					</option>
					 </select>			
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">物流商:</label><select name="logisticsbus" class="form-control" id="exampleInputPassword1" >
					<option value="中通">中通
					</option>
					<option value="申通">申通
					</option>
					<option value="京东">京东
					</option>
					 </select>
				</div>
			
			 <button type="submit" class="btn btn-default">提交信息</button>
			</form>
		</div>
	</div>
</div>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form  role="form" id="form2" name="Form2" action="order/completeInfoSellorListingPurchCommit?tradeNo=${tradeNo}" method="post"  enctype="multipart/form-data">
				<div class="form-group">
					 <label for="exampleInputEmail1">到货地:</label><input  name="deliveryPlace" class="form-control" id="exampleInputEmail1" type="text" />
				</div>
				
			
			 <button type="submit" class="btn btn-default">提交信息</button>
			</form>
		</div>
	</div>
</div>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form  role="form" id="form3" name="Form3" action="order/completeInfoPurchListingSellerCommit?tradeNo=${tradeNo}" method="post"  enctype="multipart/form-data">
				<div class="form-group">
					 <label for="exampleInputPassword1">货源地:</label><input  name="sPlace" class="form-control" id="exampleInputPassword1" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputEmail1">交易方式:</label><select  name="exchangeMeans" class="form-control" id="exampleInputEmail1"  />
					<option value="线上交易">线上交易
					</option>
					<option value="线下交易">线下交易
					</option>
					 </select>			
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">物流商:</label><select name="logisticsbus" class="form-control" id="exampleInputPassword1" >
					<option value="中通">中通
					</option>
					<option value="申通">申通
					</option>
					<option value="京东">京东
					</option>
					 </select>
				</div>
			
			 <button type="submit" class="btn btn-default" >提交信息</button>
			</form>
		</div>
	</div>
</div>
  </body>
</html>
