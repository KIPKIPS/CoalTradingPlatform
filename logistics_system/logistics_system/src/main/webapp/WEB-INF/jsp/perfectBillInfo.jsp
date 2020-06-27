<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	#myform{
	margin-left:500px;
	margin-top:70px;}
	</style>
	<script type="text/javascript">
	
		//电话验证
	
		function checkPhone(){
			var TEL_REGEXP = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;      /* 电话正则表达式 */
			var phoneNumber = document.getElementById("dis_phone").value;
			var notice = document.getElementById("phone");
			if(TEL_REGEXP.test(phoneNumber)){
			notice.style.color="green";
			notice.style.fontSize="17px";
			notice.innerHTML="√";
			document.getElementById("sure").disabled=false;
			return true;
			}else{
			notice.style.color="red";
			notice.style.fontSize="13.5px";
			notice.innerHTML="电话号码不规范!";
			document.getElementById("sure").disabled=true;
			return false;
			}
		}
	function back()
    {
        window.location.href='showCheckWaybill/getCheckWaybillInfo';
    }
	</script>
	
	
  </head>
  <body>	


	
	<div id="formbg">
	</div>
   		<form   action="showCheckWaybill/modifyWaybillInfoDisInfoByWaybill_id?waybill_id=${waybillInfo.waybill_id} " method="post"  id="myform" onsubmit='return check1()'>
   		<br/>
   			配送人:<input id="distributor" name="distributor" /><br/>
   			配送人联系方式:<input id="dis_phone" name="dis_phone" onchange="checkPhone()" onblur="checkPhone()" /><span style="color:red;font-size:13.5px" id="phone"></span><br/>
   			货源地:<input id="good_source" name="good_source" value="${waybillInfo.good_source}" readonly="readonly"/><br/>
   			收货地:<input id="good_destination" name="good_destination" value="${waybillInfo.good_destination}" readonly="readonly"/><br/>
   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
   			起始位置选择：<select name="start_pos">
   				<option value="西安">西安
				</option>
				<option value="宝鸡">宝鸡
				</option>
				<option value="太原">太原
				</option>
				<option value="大同">大同
				</option>
				
   			</select><br>
   			终止位置选择：<select name="end_pos">
   				<option value="西安">西安
				</option>
				<option value="宝鸡">宝鸡
				</option>
				<option value="太原">太原
				</option>
				<option value="大同">大同
				</option>
				
   			</select><br>
    
   			<input type="submit" value="确认" id="sure"  onclick disabled="true"/>
   			<input type='button' value="退出" onclick="back()">
   			<br/><br/>
   	
   			   		
   		
   		
   		</form>

  
</body>

</html>
