<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'seller_delisting_back.jsp' starting page</title>
    
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
		fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver;border-radius:8px}
		legend{padding:.5em;border:0;width:auto;margin-bottom:10px}
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
				#downloadback{
				width:100px;
				height:30px;
				}
				#checkback{
				width:100px;
				height:30px;
				}
				#inputfinalinfo{
				width:100px;
				height:30px;
				}
				#fieldset1{
				margin-left:0px;
				margin-top:70px;
				float:left;
				background:url(images/background01.jpg);
				}
				#myform{
				margin-left:1020px;
				background-color:whitez;
				
				}
				#loginbg{
				width:800px;
				height:300px;
				float:left;
				background:url(images/background01.jpg);
				}
				#background01{
				background-image:images/background01.jpg;
				 width:70%;height:400px;
				 }
				 #maindiv{
				margin-left:800px;
				 }
				 
			
	</style>
	<script type="text/javascript">
	function downloadback(){window.location.href = 'order/downloadReceipt?tradeNo='+${tradeNo}
	}
	function checkback(){window.location.href = 'order/modifyReceiptStateByTradeNo?tradeNo='+${tradeNo}
	}
	function transtoinfo(){location.href=
	"order/tradefinal?tradeNo="+${tradeNo} + "&traderControl=" + ${traderControl};
	}
	</script>
  </head>
  
  <body>
  <!--  
  	<div id="maindiv">
  <input type="button" value="下载回执单" id="downloadback" onclick='downloadback()' />
   <input type="button" value="确认回执单" id="checkback" onclick='checkback()'/>
   <input type="button" value="填写后续信息" id="inputfinalinfo"  onclick='transtoinfo()'/><br/>
   </div>
   -->
<center>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <button type="button"  value="下载回执单" id="downloadback" onclick='downloadback()'  class="btn btn-default btn-primary">下载回执单</button>
		</div>
	</div>
</div><br/><br/>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <button type="button"  value="确认回执单" id="checkback" onclick='checkback()' class="btn btn-default btn-primary">确认回执单</button>
		</div>
	</div>
</div><br/><br/>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <button type="button"  value="填写后续信息" id="inputfinalinfo"  onclick='transtoinfo()'class="btn btn-default btn-primary">填写后续信息</button>
		</div>
	</div>
</div>
<div id="bottom">
				<img src="images/deal_bottom.PNG" width="100%" height="149px" style="margin-top: 260px;"/>			
</div>
			</center>
  </body>
</html>
