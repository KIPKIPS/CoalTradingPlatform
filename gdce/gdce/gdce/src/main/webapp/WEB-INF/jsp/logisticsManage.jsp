<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>物流管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  	<!--待确认、配送中、已完成-->
		<style>
			body{
				color:#333;
				text-align: left;
				/* font-size: 12px; */
			}
			/*总页面设置*/
			#container{
				/* border: 1px solid red; */
				width:100%;
				/*li width: 1228px; */
				height: 662px;
				/* margin: auto; */
			}
			/*选择下拉框*/
			#changeLogisticsStatus{
				/* border: 1px solid blue; */
				/* width: 1188px; */
				width:200px;
				height: 50px;
				/*li padding: 10px; */
				/*li padding-left: 30px;
				margin-left:5px; */
			}
			/*iframe*/
			#infoShow{
				/* border: 1px solid black; */
				width:100%;
				/*li width: 1168px; */
				height: 566px;
				/*li padding: 8px;
				margin-left: 20px; */
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<!-- 下拉选择框change事件 -->
		<script>
			$(function(){
				var srcArr = new Array("/logisticManageController/remainChecked","logisticManageController/transPorting","logisticManageController/remainFinished")
				$("#logisticsStatus").change(function(){
					$("#infoShow")[0].src=srcArr[this.value];
				});
			});
		</script>
	</head>
  
  <body>
		<div id="container">
			<div>
				<font size="4">物流管理</font><hr />
			</div>
			<div id="changeLogisticsStatus">
				<select name="logisticsStatus" id="logisticsStatus" style="width: 120px;font-size: 17px;text-align: center;"  class="form-control">
					<option name="logisticsStatus" value=0>待确认</option>
					<option name="logisticsStatus" value=1>派送中</option>
					<option name="logisticsStatus" value=2>已完成</option>
				</select>
			</div>
			<div>
				<iframe src="/logisticManageController/remainChecked" style="position:absolute" id="infoShow" frameborder=no></iframe>
			</div>
		</div>
	</body>
</html>
