<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>卖方发布交易商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		.btn {
			  display: inline-block;
			  padding: 6px 12px;
			  margin-bottom: 0;
			  font-size: 14px;
			  font-weight: normal;
			  line-height: 1.428571429;
			  text-align: center;
			  white-space: nowrap;
			  vertical-align: middle;
			  cursor: pointer;
			  background-image: none;
			  border: 1px solid transparent;
			  border-radius: 4px;
			  -webkit-user-select: none;
			     -moz-user-select: none;
			      -ms-user-select: none;
			       -o-user-select: none;
			          user-select: none;
			}
		.btn-default {
			  color: #333333;
			  background-color: #ffffff;
			  border-color: #cccccc;
			}
		.btn-primary {
			  color: #ffffff;
			  background-color: #428bca;
			  border-color: #357ebd;
			}
	</style>
	
	<!-- 本段代码完成 ：文本框只能输入数字的功能 -->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	/* 页面加载完成后立即执行 */
		$(function(){ 
			onlyNum("#num");
			onlyNum("#calValue");
			onlyNum("#price");
			onlyNum("#totalSul");
			onlyNum("#freight");
			onlyNum("#volatile1");
			onlyNum("#volatile2");
			onlyNum("#adba");
			onlyNum("#aw");
		}); 
		
		/* 限制文本框只能输入数字 */
		function onlyNum(id){
		$(id).keyup(function(){ 
		$(this).val($(this).val().replace(/[^0-9.]/g,'')); 
		}).bind("paste",function(){ 
		$(this).val($(this).val().replace(/[^0-9.]/g,'')); 
		})
		
		}
	</script>	
		
	<style>
			/*设置所有td的内边距*/
			td{
				width: 150px;
				border-right: none;
				border-left: none;
			}
			/*设置提示信息靠右显示*/
			#tips{
				text-align: right;
			}
			/*整个信息显示页面*/
			#father{
				/* border: 1px solid red; */
				width: 80%;
				/*li width: 1250px; */
				height: 440px;
				margin: auto;
			}
			/*表单信息区域*/
			#info{
				/* border: 1px solid black; */
				width: 900px;
				height: 380px;
				margin: auto;
				margin-top: 100px;
			}
			/*信息头*/
			#infoTitle{
				/* border: 1px solid green; */
				width: 130px;
				height: 40px;
				float: left;
				text-align: center;
				background-color: dodgerblue;
				margin-top:0px;
			}
			/*信息头的提示*/
			#tipTitle{
				/* border: 1px solid green; */
				width: 400px;
				height: 22px;
				float: left;
				text-align: left;
				margin-top: 18px;
			}
			/* 表格区域 */
			#infoTab{
				/* border: 1px solid red; */
				width:900px;
				height:240px;
			}
			/*表格底部区域*/
			#bottomOfTable{
				/* border: 1px solid blue; */
				width: 100%;
				height: 117px;
				margin: auto;
			}
			/*报价说明*/
			#baojia{
				/* border: 1px solid red; */
				width: 860px;
				height: 40px;
				padding: 20px;
			}
			/*按钮区域*/
			#submitBut{
				/* border: 1px solid blue; */
				text-align: center;
			}
		</style>
		<script>
			//验证%表单数据正确性
			$(function(){
				$(".percentage").blur(function(){
					$("#percentageTip").text("");
					if($(this).val()>100){
						$(this).val("");
						$("#percentageTip").text("请填写0-100之间的数值");
					}
				});
			});
		
			//表单为空时，给出相关提示
			$(function(){
				$(":input").blur(function(){
					if($(this).val().trim()==""){
						$(this).css("border-color","red");
						$(this).prop("placeholder","内容不能为空");
					}else{
						$(this).css("border-color","black");
					}
				});
			});
			
			//提交表单
			$(function(){
				var flag=0;
				$("#btnSubmit").click(function(){
					$(":input").each(function(i){
						if($(this).val().trim()==""){
							$(this).css("border-color","red");
							$(this).prop("placeholder","内容不能为空");
							flag=1;
							return false;
						}else{
							$(this).css("border-color","black");
							flag=0;
						}
					});
					if(flag==0){
						$("#dataForm").submit();
					}else{
						alert("提交失败，请检查数据");
						return false;
					}
				});
			});
		</script>
  </head>
	<body>
		<!--整个信息显示页面-->
		<div id="father">
		
			<form action="seller/submit_deal" method="post"  id="dataForm">
				<!--表单信息区域-->
				<div id="info">
					<!--信息头-->
					<div id="infoTitle"><font color="white">报价信息</font></div>
					<!--信息头的提示-->
					<div id="tipTitle"><font size="2" color="red">&nbsp;&nbsp;注：报价信息内容均为必填,部分输入框只能收录数字</font></div>
					<div style="width: 366.8px;height: 22px;float: left;text-align: right;margin-top: 18px;"><font size="2" color="red" id="percentageTip"></font></div>
					<div id="infoTab">
						<table border="1px" cellspacing="0px" width="100%" height="100%" align="center" cellpadding="5px" bgcolor="white">
							<tr>
								<td id="tips"><font size="2">供应数量(万吨):</font></td>
								<td><input type="text" maxlength="32" id="num" name="sCount"/></td>
								<td id="tips"><font size="2">热值(KCal/kg)≥:</font></td>
								<td><input type="text" maxlength="32" id="calValue" name="sKCal"/></td>
								<td id="tips"><font size="2">原煤单价(元/吨):</font></td>
								<td><input type="text" maxlength="32" id="price" name="sCPrice"  style="width: 146px;"/></td>
							</tr>
							<tr>
								<td id="tips"><font size="2">全硫(%)≤:</font></td>
								<td><input type="text" maxlength="32" id="totalSul" name="sS" class="percentage"/></td>
								<td id="tips"><font size="2">产地:</font></td>
								<td><input type="text" maxlength="32" id="orign" name="sPlace"/></td>
								<td id="tips"><font size="2">运费单价(元/吨):</font></td>
								<td><input type="text" maxlength="32" size="3" id="freight" name="sFreight" style="width:146px"/></td>
							</tr>
							<tr>
								<td id="tips"><font size="2">发站(发货港口):</font></td>
								<td><input type="text"  maxlength="32" id="port" name="sDeliverPlace"/></td>
								<td id="tips"><font size="2">煤种:</font></td>
									<td>
										<select name="coalTtype" style="width:160px">
											<option name="pCoalType" value="烟煤">烟煤</option>
											<option name="pCoalType" value="无烟煤">无烟煤</option>
											<option name="pCoalType" value="褐煤">褐煤</option>
											<option name="pCoalType" value="贫瘦煤">贫瘦煤</option>
											<option name="pCoalType" value="其他">其他</option>
										</select>
									</td>
								<td  id="tips"><font size="2">运输方式</font></td>
									<td>
										<select name="transType" style="width: 146px;">
											<option name="pTransport" value="火车">火车</option>
											<option name="pTransport" value="汽车">汽车</option>
											<option name="pTransport" value="船运">船运</option>
											<option name="pTransport" value="其他">其他</option>
										</select>
									</td>
							</tr>
							<tr>
								<td id="tips"><font size="2">空干基灰分(%)≤:</font></td>
								<td><input type="text"  maxlength="32" id="adba" name="sAshContent" class="percentage" /></td>
								<td id="tips"><font size="2">全水分(%)≤:</font></td>
								<td><input type="text"  maxlength="32" id="aw" name="sMoisture" class="percentage"/></td>
								<td id="tips"><font size="2">挥发分(%):</font></td>
								<td><input type="text" size="2" maxlength="32" id="volatile1" name="sVolatilizeMin" style="width:55px" class="percentage"/><font size="2">&nbsp;&nbsp;
								至&nbsp;&nbsp;</font><input type="text" size="2" maxlength="32" id="volatile2" name="sVolatilizeMax" style="width:55px" class="percentage"/></td>
							</tr>
						</table>
					</div>
					<!--表格底部区域-->
					<div id="bottomOfTable">
						<!--报价说明-->
						<div id="baojia">
							<font color="#FF0000" size="2">
							报价说明：供应商报价中的"全硫","挥发性";"灰分"请按照采购方在煤质要求中提出的基准填写！
							</font>
						</div>
						<!--按钮区域-->
						<div id="submitBut">
							<input type="button" id="btnSubmit" value="发布商品" class="btn btn-default btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="返回" onclick="history.back()" class="btn btn-default btn-primary" />
						</div>
					</div>
				</div>
				
			</form>
		</div>
	</body>
</html>
