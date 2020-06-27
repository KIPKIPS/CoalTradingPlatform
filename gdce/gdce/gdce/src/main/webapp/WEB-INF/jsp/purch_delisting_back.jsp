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
		fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver;border-radius:8px}
		legend{padding:.5em;border:0;width:auto;margin-bottom:10px}
		#bottom{
				/*border:1px solid green;*/
				width:1250px;
				height: 199px;
			}
			irfame{float:left;
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
				 
				.file {
    			position: relative;
    			display: inline-block;
    			background-color: #428bca;
    			border-color: #357ebd;
   				border: 1px solid ;
    			border-radius: 4px;
			    padding: 4px 12px;
			    overflow: hidden;
			    color: #fff;
			    text-decoration: none;
			    text-indent: 0;
			    line-height: 20px;
				}
				
				.file input {
    			position: absolute;
   				font-size: 100px;
   			 	right: 0;
			    top: 0;
			    opacity: 0;
				}
				
				.file:hover {
    			background: #3276b1;
    			border-color: #78C3F3;
    			color: #fff;
    			text-decoration: none;
				}
				 
	</style>
		<script type="text/javascript">
	function uploadback(){window.location.href = 'order/uploadBankReceipt?orderNo=20190617160618101'
	}
	function transtoinfo(){location.href=
	"order/tradefinal?tradeNo="+${tradeNo} + "&traderControl=" + ${traderControl};
	}
	function uploadpage(){
	
		if(${traderControl}==1){
		document.getElementById("insertinfo").style.display='none';
		}
		
	}
	
	//将选择的回执单地址显示在下面
	function FileChange(){
		var notice = document.getElementById("notice");
		var path = document.getElementById("recipt").value;
		notice.innerHTML=path;

	}
	</script>
  </head>
  
  <body onload=uploadpage()> 
  	
<center>

<form name="Form2" action="order/uploadBankReceipt?orderNo=${orderNo}"  method="post"  enctype="multipart/form-data">
	<a class="file"><input onchange="FileChange()" id="recipt" type="file" name="file" accept="image/*" value="选择回执单文件" />点击选择回执单</a><br><span id="notice">未选择要上传的回执单文件</span><br>
	<input type="submit" value="上传回执单" class="btn btn-default btn-primary"/>
</form>
<!--  
<div id="but1">
   <input type="button" value="填写剩余信息" id="inputfinalinfo"  onclick='transtoinfo()'/><br/>
</div>
-->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column" id="insertinfo">
			 <button type="button"  value="填写剩余信息" id="inputfinalinfo"  onclick='transtoinfo()'class="btn btn-default btn-primary">填写剩余信息</button>
		</div>
	</div>
</div>
<div id="bottom">
				<img src="images/deal_bottom.PNG" width="100%" height="149px" style="margin-top: 260px;"/>			
</div>
			</center>
  </body>
</html>
