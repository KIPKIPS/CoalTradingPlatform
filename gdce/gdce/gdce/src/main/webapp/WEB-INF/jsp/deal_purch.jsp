<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deal_purch.jsp' starting page</title>
    
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
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	
	//判断最早交货日期和最晚交货日期是否正确
		function judgeCalender(){
			return $("#pDeliverLatest").val()>=$("#pDeliverEarliest").val();
		}
	
	/* 页面加载完成后立即执行 */
		$(function(){
			/* 定义银行账户全局变量	 */
			var cBankAccount = "";
			onlyNum("#num");
			onlyNum("#omargin_value");
			onlyNum("#pmargin_value");
			onlyNum("#Qnet");
			onlyNum("#St");
			onlyNum("#M");
			onlyNum("#pAar");
			onlyNum("#pVarmin");
			onlyNum("#pVarmax");
			onlyNum("#pMad");
			onlyNum("#pSt2");
			onlyNum("#pVadmin");
			onlyNum("#pVadmax");
			onlyNum("#pQgrd");
			onlyNum("#pStd");
			onlyNum("#last1");
			onlyNum("#last2");
			onlyNum("#St2");
			onlyNum("#pGrad");
			onlyNum("#pHGI");
			onlyNum("#pST");
			onlyNum("#coalPrice");
			onlyNum("#transPrice");
		}); 
		
		/* 限制文本框只能输入数字 */
		function onlyNum(id){
			$(id).keyup(function(){ 
				$(this).val($(this).val().replace(/[^0-9.]/g,'')); 
			}).bind("paste",function(){ 
				$(this).val($(this).val().replace(/[^0-9.]/g,'')); 
		})
		}
		
		/* 交货日期选定后，校验发货日期是否早于发布日期，最晚发货日期是否大于最早发货日期 */
		$(function(){
			$("#pDeliverEarliest,#pDeliverLatest").blur(function(){
				if($("#pDeliverEarliest").val() != "" && $("#pDeliverEarliest").val()<$("#application_date").val()){
					$("#pDeliverEarliest").val("yyyy-mm-dd");
					$("#dateTip").text("最早发货日期应该晚于发布日期，且早于最晚交货日期");
					return;
				}
				if($("#pDeliverLatest").val()!="" && $("#pDeliverEarliest").val() != "" && $("#pDeliverLatest").val()<$("#pDeliverEarliest").val()){
					$("#pDeliverLatest").val("yyyy-mm-dd");
					$("#dateTip").text("最早发货日期应该晚于发布日期，且早于最晚交货日期");
					return;
				}
				if($("#pDeliverLatest").val()!="" && $("#pDeliverLatest").val()<$("#application_date").val()){
					$("#pDeliverLatest").val("yyyy-mm-dd");
					$("#dateTip").text("最早发货日期应该晚于发布日期，且早于最晚交货日期");
					return;
				}
				$("#dateTip").text("");
				
			});
		});
		
		
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
			$(":text").blur(function(){
				if($(this).val().trim()==""){
					$(this).css("border-color","red");
					$(this).prop("placeholder","内容不能为空");
				}else{
					$(this).css("border-color","black");
				}
			});
		});
	</script>	
	
		<style>
				/*整个信息页面*/
				#father{
					/* border: 1px solid red; */
					width: 80%;/*li 1250px  */
					/* margin-top:10px;/*li  */ */
					height: 1022px;
					margin: auto;
				}
				
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
				/*表单信息区域*/
				#info{
					/* border: 1px solid red;  */
					width: 900px;
					height: 332px;
					margin: auto;
					margin-top: 20px;
				}
				/*信息头*/
				.infoTitle{
					/* border: 1px solid green; */
					width: 130px;
					height: 26px;
					float: left;
					text-align: center;
					background-color: dodgerblue;
					padding-top: 14px;
				}
				/*煤质要求*/
				#quality{
					/* border: 1px solid red; */
					width: 900px;
					height: 600px;
					margin: auto;
					margin-top: 0px;
				}
				/*煤质信息*/
				#quality_info{
					width: 900px;
					height: 560px;
					/* border: 1px solid blue; */
					float: left;
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
			</style>
		
		<script type="text/javascript">
		
			//显示单据编号和公司名称
			function setCName(){
				var application_date=document.getElementById("application_date");
				var date = new Date();
				var year = date.getFullYear();
				var month = ("0" + (date.getMonth() + 1)).slice(-2);
				var days = ("0" + date.getDate()).slice(-2);
				$("#application_date").val(year + "-" + month + "-" + days);
				$("#application_date").prop("readonly","readonly");
			
				$.ajax({
					type:"post",
					url:"purch/getCName",
					data:null,
					dataType: "text",
					success:function(msg){
					$("#cName").val(msg);
					$("#pListId").val(msg+"-"+year+"-"+month+"-"+days+date.getMilliseconds());
					}
				});
			}
		
			//保证金不要求时，为不可编辑状态
			$(function(){
				$("#noRequest1").click(function(){
					$("#omargin_value").val("10.00");
					$("#omargin_value").attr("readonly","true");
				});
				$("#yesRequest1").click(function(){
					$("#omargin_value").removeAttr("readonly");
				});
				$("#noRequest2").click(function(){
					$("#pmargin_value").val("10.00");
					$("#pmargin_value").attr("readonly","true");
				});
				$("#yesRequest2").click(function(){
					$("#pmargin_value").removeAttr("readonly");
				});
			});
				
			//得到用户公司银行账户
			$(function(){
				$.ajax({
					type:"post",
					url:"purch/getCBankAccount",
					data:null,
					success:function(msg){
						if(msg==null){
							alert("长时间未操作，请重新登录");
						}else{
							cBankAccount = msg;
						}
					}
				});
			});
			
			
			//在提交表单时 ，判断是否有未填项，判断交货日期是否正确
			$(function(){
				var flag=0;
				$("#btnSubmit").click(function(){
					$(":text,#pDeliverEarliest,#pDeliverLatest").each(function(i){
						if($(this).val().trim()==""){
							$(this).css("border-color","red");
							$(this).prop("placeholder","内容不能为空");
							flag=1;
							return false;
						}else{
							$(this).css("border-color","black");
						}
					});
					if(flag!=1 && judgeCalender()){
						count = $("#num").val() * $("#omargin_value").val()*10000;
						alert(cBankAccount);
						$.ajax({						
							type:"post",
							url:"http://10.61.88.30:8083/bank/frozen",
							data:"bankAcount="+ cBankAccount + "&frozenMoney=" + count,							
							success:function(msg){
								if(msg=="right"){
									$("#dataForm").submit();
									$(":input").val("");
								}else if(msg=="wrong"){
									alert("保证金不足，请先预存");
								}else{
									alert("返回值无效");
								}
							},
							error: function(msg){
								alert("错误回调");
							}
						})
					}else{
						flag=0;
						if(judgeCalender()){
							alert("请填写所有数据");
						}else{
							alert("最晚交货日期不能早于最早交货日期")
						}
						return false; 
					}
				});
			});
		</script>
	</head>
		
	<body onload=setCName()>
		<!--整个页面信息-->
		<div id="father">
			<form action="purch/submit_deal" method="post" id="dataForm">
				<!--表单信息区域-->
				<div id="info">
					<!--信息头-->
					<div class="infoTitle"><font color="white">基本情况</font></div>
					<!--信息头的提示-->
					<div id="tipTitle"><font size="2" color="red">&nbsp;&nbsp;注：以下信息均为必填,部分输入框只能写入数字</font></div>
					<div style="width: 366.8px;height: 22px;float: left;margin-top: 18px;text-align:right;">
						<font id="dateTip" size="2" color="red">&nbsp;&nbsp;</font>
					</div>
					<table border="1px" cellspacing="0px" width="100%" height="240px" align="center" cellpadding="5px" bgcolor="white">
						<tr>
							<td id="tips"><font size="2">申请单位:</font></td>
							<td><input type="text" maxlength="32" readonly="readonly" id="cName"/></td>
							<td id="tips"><font size="2">申请编号:</font></td>
							<!-- 使用readonly属性，是表单值不可更改，但可以被提交获取 -->
							<td><input type="text" maxlength="32" style="width:150px;" readonly="readonly" id="pListId" name="pListID"/></td>
							<td id="tips"><font size="2">申请人:</font></td>
							<td><input type="text" maxlength="32" id="applicant" name="pName"/></td>
						</tr>
						<tr>
							<td id="tips"><font size="2" >签发人:</font></td>
							<td><input type="text" maxlength="32" id="signer" name="pIssuer"/></td>
							<td id="tips"><font size="2" >申请日期:</font></td>
							<td><input type="date" maxlength="32"  id="application_date"/></td>
							<td id="tips"><font size="2">交货日期：</font></td>
							<td><input type="date" style="width: 120px;" name="pDeliverEarliest" id="pDeliverEarliest"/>至
							<input type="date" style="width: 120px;" name="pDeliverLatest" id="pDeliverLatest"/>
							<!-- <input type="text" name="stu_birth" class="Wdate" onfocus="WdatePicker({maxDate:'%y-%M-{%d}',readOnly:'true'})">至
							<input type="text" name="stu_birth" class="Wdate" onfocus="WdatePicker({maxDate:'%y-%M-{%d}',readOnly:'true'})"> -->
							</td>
						</tr>
						<tr>
							<td id="tips"><font size="2">煤种:</font></td>
							<td><select name="pCoalType">
									<option name="pCoalType" value="烟煤">烟煤</option>
									<option name="pCoalType" value="无烟煤">无烟煤</option>
									<option name="pCoalType" value="褐煤">褐煤</option>
									<option name="pCoalType" value="贫瘦煤">贫瘦煤</option>
									<option name="pCoalType" value="其他">其他</option>
								</select>
								<select name="pCoalBusType" style="width: 73px;">
									<option name="pCoalBusType" value="原煤">原煤</option>
									<option name="pCoalBusType" value="混煤">混煤</option>
									<option name="pCoalBusType" value="中煤">中煤</option>
									<option name="pCoalBusType" value="煤泥">煤泥</option>
									<option name="pCoalBusType" value="其他">其他</option>
								</select>
							</td>
							<td id="tips"><font size="2">采购数量:</font></td>
							<td><input type="text"  style="width: 50px;width:110px;" id="num" name="pCount"/><font size="2">(万吨)</font></td>
							<td  id="tips"><font size="2">运输方式</font></td>
							<td>
								<select name="pTransport" style="width: 146px;">
									<option name="pTransport" value="火车">火车</option>
									<option name="pTransport" value="汽车">汽车</option>
									<option name="pTransport" value="船运">船运</option>
									<option name="pTransport" value="其他">其他</option>
								</select>
							</td>
						</tr>
						<tr>
							<td id="tips"><font size="2">交货地点:</font></td>
							<td><input type="text"  maxlength="32" id="place" name="pDeliverPlace"/></td>
							<td id="tips"><font size="2">结算方式:</font></td>
							<td>
								<select name="pSettlement" style="width: 146px;">
									<option name="pSettlement" value="一票结算">一票结算</option>
									<option name="pSettlement" value="二票结算">二票结算</option>
									<option name="pSettlement" value="铁路大票">铁路大票</option>
									<option name="pSettlement" value="煤款税票">煤款税票</option>
									<option name="pSettlement" value="其他">其他</option>
								</select>
							</td>
							<td id="tips"><font size="2">验收方式:</font></td>
							<td>
								<select name="pCheck" style="width:146px">
									<option name="pCheck" value="到场验收">到场验收</option>
									<option name="pCheck" value="到场第三方验收">到场第三方验收</option>
									<option name="pCheck" value="港口第三方验收">港口第三方验收</option>
								</select>
							</td>
						</tr>
						<tr>
							<td  id="tips"><font size="2">原煤单价:</font></td>
							<td><input type="text" name="coalPrice" id="coalPrice" style="width:107px"/><font size="2">(元/吨)</font></td>
							<td  id="tips"><font size="2">运费单价:</font></td>
							<td><input type="text" name="transPrice" id="transPrice" style="width:109px"/><font size="2">(元/吨)</font></td>
							<td id="tips"><font size="2">结算付款方式:</font></td>
							<td>
							<select id="pPayment" name="pPayment" style="width:146px;">
								<option name="pPayment" values="线下支付">线下支付</option>
								<option name="pPayment" values="银行卡转账">银行卡转账</option>
								<option name="pPayment" values="在线支付">在线支付</option>
							</select>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								报价保证金缴纳:
								<input type="radio" name="omargin" vlaue="不要求" id="noRequest1" onclick="pmargin_disabled('omargin_value')"/>不要求
								<input type="radio" name="omargin" vlaue="要求" checked="checked" id="yesRequest1" onclick="pmargin_changeable('omargin_value')"/>要求
								<input type="text" style="width: 40px;" value="10.00" id="omargin_value" name="pQuoDeposit"/>元/吨
							</td>
							<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								报价保证金缴纳:
								<input type="radio" name="pmargin" vlaue="不要求" id="noRequest2" onclick="pmargin_disabled('pmargin_value')"/>不要求
								<input type="radio" name="pmargin" vlaue="要求" checked="checked" id="yesRequest2" onclick="pmargin_changeable('pmargin_value')"/>要求
								<input type="text" style="width: 40px;" value="10.00" id="pmargin_value" name="pBidBond"/>元/吨
							</td>
						</tr>
					</table>
					
				</div>
			<div id="quality">
				<!--信息头：煤质要求-->
				<div class="infoTitle"><font color="white">煤质要求</font></div>
				<div style="width: 400px;height: 29px;padding-top: 10px;float:left;">
					<font color="red" size="2">请仔细填写以下所有内容：</font>
				</div>
				<div style="width: 366.8px;height: 29px;padding-top: 10px;text-align:right;float:left">
					<font color="red" size="2" id="percentageTip"></font>
				</div>
				<div id="quality_info">
					<div style="background: lightblue;height: 30px;padding-top: 10px;">收到基标准</div>
					<table border="1px" cellspacing="0px" width="100%" height="120px" cellpadding="0px">
						<tr height="60px">
							<td id="tips"><font size="2">收到基低位发热量Qnet,ar≥:</font></td>
							<td><input type="text" style="width:30px" id="Qnet" name="pQnetar"/><font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">收到基全硫St,ar≤:</font></td>
							<td><input type="text" style="width:30px" id="St" name="pStar" class="percentage"/><font size="2">(%)</font></td>
							<td id="tips"><font size="2" >全水分M≤:</font></td>
							<td><input type="text" style="width:30px" id="M" name="pM" class="percentage"/><font size="2">(%)</font></td>
						</tr>
						<tr>
							<td id="tips"><font size="2">收到基灰分Aar≤:</font></td>
							<td><input type="text" style="width:30px" name="pAar" id="pAar"/><font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">收到基挥发分Var:</font></td>
							<td><font size="2" colspan="3"><input type="text" style="width:30px" name="pVarmin" id="pVarmin" class="percentage"/>(%)至
								<input type="text" style="width:30px" name="pVarmax" id="pVarmax"  class="percentage"/>(%)</font>
							</td>
						</tr>
					</table>
					<table border="1px" cellspacing="0px" width="100%" height="60px" cellpadding="0px">
						<div style="background: lightblue;height: 30px;padding-top: 10px;">空气干燥基基准</div>
						<tr>
							<td id="tips"><font size="2">空干基水分Mad≤:</font></td>
							<td><input type="text" style="width:30px" name="pMad" id="pMad"  class="percentage"/><font size="2">(%)</font></td>
							<td id="tips"><font size="2">空干基全硫St,ar≤:</font></td>
							<td><input type="text" style="width:30px" id="St2" name="pStad" class="percentage"/><font size="2">(%)</font></td>
							<td id="tips" colspan="2"><font size="2">空干基挥发分Vad:</font></td>
							<td><font size="2"><input type="text" style="width:30px" name="pVadmin" id="pVadmin" class="percentage"/>(%)至
								<input type="text" style="width:30px" name="pVadmax" id="pVadmax" class="percentage"/>(%)</font>
							</td>
						</tr>
					</table>
					<table border="1px" cellspacing="0px" width="100%" height="60px" cellpadding="0px">
						<div style="background: lightblue;height: 30px;padding-top: 10px;">干基基准</div>
						<tr>
							<td id="tips"><font size="2">干基高位发热量Qgr,d≤:</font></td>
							<td><input type="text" style="width:30px" name="pQgrd" id="pQgrd"/><font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">干基全硫St,ar≤:</font></td>
							<td><input type="text" style="width:30px" name="pStd" id="pStd" class="percentage"/><font size="2">(%)</font></td>
							<td id="tips" colspan="2"><font size="2">干燥无灰基挥发分:</font></td>
							<td><font size="2"><input type="text" style="width:30px" id="last1" name="pVanmin" class="percentage"/>(%)至
								<input type="text" style="width:30px" id="last2" name="pVanmax" class="percentage"/>(%)</font>
							</td>
						</tr>
					</table>
					<table border="1px" cellspacing="0px" width="100%" height="120px" cellpadding="0px" style="border-top: 3px solid blue;" bgcolor="lightgray">
						<tr>
							<td id="tips"><font size="2">粒度(mm)≤:</font></td>
							<td><input type="text" style="width:30px" name="pGrad" id="pGrad"/><font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">灰熔点ST(℃)≥:</font></td>
							<td><input type="text" style="width:30px" name="pST" id="pST"  class="percentage"/><font size="2">(%)</font></td>
							<td id="tips" colspan="2"><font size="2">哈式可磨系数(HGI)≥:</font></td>
							<td><input type="text" style="width:30px" name="pHGI" id="pHGI" class="percentage"/><font size="2">(%)</font></td>
						</tr>
						<tr>
							<!-- <td rowspan="2" align="right">备注:</td> -->
							<td rowspan="2" colspan="7">
								<div style="width:100%;height:100%;text-align:center">
									<div style="width:77px;float:left">
										<font size=3 style="display:block;margin:0px;float:left;padding-top:7px;padding-left:18px">备注：</font>
									</div>
									<div style="width:786px;float:left">
										<textarea style="width: 100%;height:80px;" name="pRemarks" id="note"></textarea>
									</div>
								</div>
							</td>
						</tr>
					</table>
					<div style="width: 100%;height: 39px;text-align: center;padding-top: 40px;">
						<input type="button" value="提交" id="btnSubmit" class="btn btn-default btn-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="返回" onclick="history.back()" class="btn btn-default btn-primary" />
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
