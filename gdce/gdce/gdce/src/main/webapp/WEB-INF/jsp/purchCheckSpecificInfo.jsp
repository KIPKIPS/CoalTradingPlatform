<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shiyishi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style>
  @import url("css/bootstrap.min.css");
  				/*整个信息页面*/
				#father{
/*                     border: 1px solid red;  */
					width: 100%;
					height: 850px;
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
					text-align: left;
				}
				/*表单信息区域*/
				#info{
/* 					border: 1px solid red;  */
					width: 98.8%;
					height: 332px;
					margin: auto;
					margin-top: 10px;
				}
				/*信息头*/
				.infoTitle{
/* 					border: 1px solid green; */
					width: 130px;
					height: 36px;
					float: left;
					text-align: center;
					background-color: dodgerblue;
					padding-top: 14px;
				}
				/*煤质要求*/
				#quality{
/* 					border: 1px solid red; */
					width: 98.8%;
					height: 500px;
					margin: auto;
					margin-top: 0px;
				}
				/*煤质信息*/
				#quality_info{
					width: 98.8%;
					height: 480px;
/* 					border: 1px solid blue; */
					float: left;
				}
				/*信息头的提示*/
				#tipTitle{
/* 					border: 1px solid green; */
					width: 766.8px;
					height: 22px;
					float: left;
					text-align: left;
					margin-top: 18px;
				}
  
  
  		
        #pass{
            width:100px;
            margin-top: 10px;
            position: absolute;
            margin-left:25%;
        }
        #notPass{
           width:100px;
            margin-top: 26px;
            margin-left:50%;
            position: absolute;
        }
        #back{
        width:100px;
            margin-top: 10px;
            margin-left:75%;
            position: absolute;
        
        }
        #title{
        	
       		text-align:left;
       		width:100px;
        	margin-top: 1px;
            margin-left:0.3%;
           	
        }
    #pass:active{
        opacity: 0.5;
    }
        #notPass:active{
            opacity: 0.5;
        }
</style>

  </head>
  
  <body>
<!--整个页面信息-->
		<div id="father">
				<!--表单信息区域-->
				<div id="info">
					<!--信息头-->
					<div class="infoTitle"><font color="white">基本情况</font></div>
					<table border="1px" cellspacing="0px" width="100%" height="240px" align="center" cellpadding="5px" bgcolor="white">
						<tr>
							<td id="tips"><font size="2">申请单位:</font></td>
							<td>${cName}</td>
							<td id="tips"><font size="2">申请编号:</font></td>
							<!-- 使用readonly属性，是表单值不可更改，但可以被提交获取 -->
							<td>${specificGoodInfo.pListID}</td>
							<td id="tips"><font size="2">申请人:</font></td>
							<td>${specificGoodInfo.pName}</td>
						</tr>
						<tr>
							<td id="tips"><font size="2" >签发人:</font></td>
							<td>${specificGoodInfo.pIssuer}</td>
							<td id="tips"><font size="2" >申请日期:</font></td>
							<td><fmt:formatDate value="${specificGoodInfo.pApplyDate}"  pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
							<td id="tips"><font size="2">交货日期：</font></td>
							<td><fmt:formatDate value="${specificGoodInfo.pDeliverEarliest}"  pattern="yyyy-MM-dd"></fmt:formatDate>至
							<fmt:formatDate value="${specificGoodInfo.pDeliverLatest}"  pattern="yyyy-MM-dd"></fmt:formatDate>
							
							</td>
						</tr>
						<tr>
							<td id="tips"><font size="2">煤种:</font></td>
							<td>${specificGoodInfo.pCoalType} &nbsp;&nbsp;&nbsp;${specificGoodInfo.pCoalBusType}</td>
							<td id="tips"><font size="2">采购数量:</font></td>
							<td>${specificGoodInfo.pCount}<font size="2">(万吨)</font></td>
							<td  id="tips"><font size="2">运输方式：</font></td>
							<td>${specificGoodInfo.pTransport}</td>
						</tr>
						<tr>
							<td id="tips"><font size="2">交货地点:</font></td>
							<td>${specificGoodInfo.pDeliverPlace}</td>
							<td id="tips"><font size="2">结算方式:</font></td>
							<td>${specificGoodInfo.pSettlement}</td>
							<td id="tips"><font size="2">验收方式:</font></td>
							<td>${specificGoodInfo.pCheck}</td>
						</tr>
						<tr>
							<td  id="tips" ><font size="2">原煤单价：</font></td>
							<td colspan="2">${specificGoodInfo.coalPrice}</td>
							<td  id="tips" ><font size="2">运费单价：</font></td>
							<td colspan="2">${specificGoodInfo.transPrice}</td>
						</tr>
						<tr>
							<td><font size="2">结算付款方式:</font></td>
							<td colspan="5">${specificGoodInfo.pPayment}</td>
						</tr>
						<tr>
							<td colspan="3">
								<font size="2">报价保证金缴纳:</font>
								${specificGoodInfo.pQuoDeposit}元/吨
							</td>
							<td/>
							<td colspan="2">
								<font size="2">履约保证金缴纳:</font>
								${specificGoodInfo.pBidBond}元/吨
							</td>
						</tr>
					</table>
					
				</div>
			<div id="quality">
				<!--信息头：煤质要求-->
				<div class="infoTitle"><font color="white">煤质要求</font></div>
				<div id="quality_info">
					<div style="background: lightblue;border-right:1px solid ;border-left:1px solid ;height: 30px;padding-top: 10px;">收到基标准</div>
					<table border="1px" cellspacing="0px" width="100%" height="120px" cellpadding="0px">
						<tr height="60px">
							<td id="tips"><font size="2">收到基低位发热量Qnet,ar≥:</font></td>
							<td>${specificGoodInfo.pQnetar}<font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">收到基全硫St,ar≤:</font></td>
							<td>${specificGoodInfo.pStar}<font size="2">(%)</font></td>
							<td id="tips"><font size="2" >全水分M≤:</font></td>
							<td>${specificGoodInfo.pM}<font size="2">(%)</font></td>
						</tr>
						<tr>
							<td id="tips"><font size="2">收到基灰分Aar≤:</font></td>
							<td colspan="2">${specificGoodInfo.pAar}<font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">收到基挥发分Var:</font></td>
							<td colspan="2"><font size="2">${specificGoodInfo.pVarmin}(%)至
								${specificGoodInfo.pVarmax}(%)</font>
							</td>
						</tr>
					</table>
					<div style="background: lightblue;border-right:1px solid ;border-left:1px solid ;height: 30px;padding-top: 10px;">空气干燥基基准</div>
					<table border="1px" cellspacing="0px" width="100%" height="60px" cellpadding="0px">
						
						<tr>
							<td id="tips"><font size="2">空干基水分Mad≤:</font></td>
							<td>${specificGoodInfo.pMad}<font size="2">(%)</font></td>
							<td id="tips"><font size="2">空干基全硫St,ar≤:</font></td>
							<td>${specificGoodInfo.pStad}<font size="2">(%)</font></td>
							<td id="tips" colspan="2"><font size="2">空干基挥发分Vad:</font></td>
							<td><font size="2">${specificGoodInfo.pVadmin}(%)至${specificGoodInfo.pVadmax}(%)</font>
							</td>
						</tr>
					</table>
					<div style="background: lightblue;border-right:1px solid ;border-left:1px solid ;height: 30px;padding-top: 10px;">干基基准</div>
					<table border="1px" cellspacing="0px" width="100%" height="60px" cellpadding="0px">
						<tr>
							<td id="tips"><font size="2">干基高位发热量Qgr,d≤:</font></td>
							<td>${specificGoodInfo.pQgrd}<font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">干基全硫St,ar≤:</font></td>
							<td>${specificGoodInfo.pStd}<font size="2">(%)</font></td>
							<td id="tips" colspan="2"><font size="2">干燥无灰基挥发分:</font></td>
							<td><font size="2">${specificGoodInfo.pVanmin}(%)至${specificGoodInfo.pVanmax}(%)</font>
							</td>
						</tr>
					</table>
					<table border="1px" cellspacing="0px" width="100%" height="120px" cellpadding="0px" style="border-top: 3px solid blue;" bgcolor="lightgray">
						<tr>
							<td id="tips"><font size="2">粒度(mm)≤:</font></td>
							<td>${specificGoodInfo.pGrad}<font size="2">(Kcal/kg)</font></td>
							<td id="tips"><font size="2">灰熔点ST(℃)≥:</font></td>
							<td>${specificGoodInfo.pST}<font size="2">(%)</font></td>
							<td id="tips" colspan="2"><font size="2">哈式可磨系数(HGI)≥:</font></td>
							<td>${specificGoodInfo.pHGI}<font size="2">(%)</font></td>
						</tr>
						<tr>
							<td rowspan="2" align="right">备注:</td>
							<td rowspan="2" colspan="6"><textarea readonly="readonly"  style="width:100%;height:30px">${specificGoodInfo.pRemarks}</textarea></td>
						</tr>
					</table>
					
				</div>

		</div>
		</div>
    <div id="title">审核意见:</div>
	<form action="SellerGoodInfo/purchCheckNotPass" method="post">  			
		<textarea name="uOpinion" type="text" id="text" onKeyUp="textLimitCheck(this, 250);"spellcheck="false" style="width: 100%;height: 100px;" placeholder="请输入审核意见" onfocus="textOnfocus()" onblur="textOnblur()" ></textarea>
		<br/>(限 250 个字符  已输入 <font color="#CC0000"><span id="messageCount">0</span></font> 个字)
		<input name="pNumber" style="display:none" value="${specificGoodInfo.pNumber}"/>
		<div  onmousedown="notPass()">
		<input id="notPass" class="btn btn-default btn-primary" type="submit"  value="审核不通过"/>
 		</div>
	</form> 
 	<div >
		<button id="pass" class="btn btn-default btn-primary" onclick="tt(${specificGoodInfo.pNumber})">审核通过</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="btn btn-default btn-primary" id="back" value="取消" onclick="history.back()"/>

    </div>
<div style="width:100%;height:50px"></div>
    		
  </body>
  <script>
  	function tt(pNumber){
		location.href="SellerGoodInfo/purchCheckPass?pNumber="+${specificGoodInfo.pNumber};
    }
    
    function textOnfocus() {
        if(document.getElementById("text").placeholder=='请输入审核意见')
            document.getElementById("text").placeholder=''
    }
    //判断字数限制
    function  textOnblur() {
        if(!document.getElementById("text").placeholder)
            document.getElementById("text").placeholder='请输入审核意见'
    }
    String.prototype.getBytes = function() {
        var cArr = this.match(/[^\x00-\xff]/ig);
        return this.length + (cArr == null ? 0 : cArr.length);
    };
    var num=0;
    function textLimitCheck(thisArea, maxLength){
        var len = thisArea.value.getBytes();
        if (len > maxLength)
        {
            alert(maxLength + ' 个字限制. \r超出的将自动去除.');
            var tempStr = "";
            var areaStr = thisArea.value.split("");
            var tempLen = 0;
            for(var i=0,j=areaStr.length;i<j;i++){
                tempLen += areaStr[i].getBytes();
                if(tempLen<=maxLength){
                    tempStr += areaStr[i];
                }
            }
            thisArea.value = tempStr;

            thisArea.focus();
        }
        num=len;
        /*回写span的值，当前填写文字的数量*/
        messageCount.innerText = thisArea.value.length;
    }
    function notPass() {
        if(num==0){
            alert("请填写审核不通过详细信息！！！")
        }
    }
</script>
</html>
