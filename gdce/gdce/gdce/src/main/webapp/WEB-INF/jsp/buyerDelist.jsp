<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sellerDelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		caption {
			text-align:center;
			font-size: 1.5em;
			margin-bottom:1%;
		}
	</style>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/layoutit.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
	function ajaxSubmit(){
//来源于W3Cschool
 var xmlHttp;
 //浏览器兼容
 try
    {
   // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
    }
 catch (e)
    {
  // Internet Explorer
   try
      {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
   catch (e)
      {
      try
         {
         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
         }
      catch (e)
         {
         alert("您的浏览器不支持AJAX！");
         return false;
         }
      }
    }
    

    var url="Delist/getBuyerCName?no=${Purch_goods.pNumber}";
    //xmlHttp.open("提交方式",请求地址,是否异步);
	xmlHttp.open("post",url,true);
	//请求参数
    xmlHttp.send(null);
    //指定成功回调函数
    xmlHttp.onreadystatechange=function(){
      if(xmlHttp.readyState==4&&xmlHttp.status==200){
      //后台返回的内容
      var content=xmlHttp.responseText ;
    	var nameTD=document.getElementById("cName");
      	nameTD.textContent = content;
      }    
   } 
   }
	</script>

  </head>
  <body onload="ajaxSubmit()">
<!--整个页面信息-->
<div class="row clearfix" style="margin-left:-17%;margin-right:2%">

	<ul class="breadcrumb">
			<li>
				 <a href="javascript:void(0);" onclick="javascript:history.go(-1);">返回</a>
			</li>
			<li class="active">
				Data
			</li>
	</ul>
    <form action="Delist/getBuyerDelistInfo?no=${Purch_goods.pNumber}" method="post" onsubmit="return isEmptyAll()">
        <!--表单信息区域-->
        <div class="col-md-12 column">
			<table class="table table-hover">
				<caption>基本情况</caption>
				<tr class="success">
				    <td id="tips"><font size="2">申请单位:</font></td>
				    <td id="cName">${cName}</td>
				    <td id="tips"><font size="2">申请编号:</font></td>
				    <!-- 使用readonly属性，是表单值不可更改，但可以被提交获取 -->
				    <td>${Purch_goods.pListID}</td>
				    <td id="tips"><font size="2">申请人:</font></td>
				    <td>${Purch_goods.pName}</td>
                </tr>		
    		<tr class="error">
    			<td id="tips"><font size="2">煤种:</font></td>
                    <td>
                        ${Purch_goods.pCoalType},
                        ${Purch_goods.pCoalBusType}
                    </td>
                    <td id="tips"><font size="2">采购数量:</font></td>
                    <td>${Purch_goods.pCount}<font size="2">(万吨)</font></td>
                    <td id="tips">运输方式：</td>
                    <td>
                        ${Purch_goods.pTransport}
                    </td>
    		</tr>
    		<tr class="warning">
    			<td id="tips"><font size="2">交货地点:</font></td>
                    <td>${Purch_goods.pDeliverPlace}</td>
                    <td id="tips"><font size="2">结算方式:</font></td>
                    <td>
                        ${Purch_goods.pSettlement}
                    </td>
                    <td id="tips"><font size="2">验收方式:</font></td>
                    <td>
                        ${Purch_goods.pCheck}
                    </td>
    		</tr>
    		<tr class="info">
    			<td><font size="2">结算付款方式:</font>
    			<td>
                        ${Purch_goods.pPayment}
                    </td>
    			</td>
                   
                </tr>
                <tr class="success">
                    <td><font size="2">保证金要求:</font></td>
                    <td colspan="5">参加采购需求单报价时，要求通过保证金账户缴纳500000元报价保证金；<br>
                        中标信息公布后，未中标供应商所缴纳的报价保证金自动退回保证金账户。<br>
                        中标供应商与电厂签订采购合同时，按电厂要求金额缴纳履约保证金；供应商再缴纳保证金时，系统将之前缴纳的报价保证金自动退回到保证金账户。</td>
    		</tr>
				</tbody>
			</table>
		</div>



        <div id="quality">
            <!--信息头：煤质要求-->
            <div class="infoTitle"><font color="white">煤质要求</font></div>
            <div style="width: 897px;height: 29px;padding-top: 10px;">

            </div>
            <div id="quality_info">
                <div style="background: lightblue;height: 30px;padding-top: 10px;">收到基标准</div>
                <table border="1px" cellspacing="0px" width="100%" height="120px" cellpadding="0px">
                    <tr height="60px">
                        <td id="tips"><font size="2">收到基低位发热量Qnet,ar≥:</font></td>
                        <td>${Purch_goods.pQnetar}<font size="2">(Kcal/kg)</font></td>
                        <td id="tips"><font size="2">收到基全硫St,ar≤:</font></td>
                        <td>${Purch_goods.pStar}<font size="2">(%)</font></td>
                        <td id="tips"><font size="2" >全水分M≤:</font></td>
                        <td>${Purch_goods.pM}<font size="2">(%)</font></td>
                    </tr>
                    <tr>
                        <td id="tips"><font size="2">收到基灰分Aar≤:</font></td>
                        <td>${Purch_goods.pAar}<font size="2">(Kcal/kg)</font></td>
                        <td id="tips"><font size="2">收到基挥发分Var:</font></td>
                        <td colspan="3"><font size="2">${Purch_goods.pVarmin}(%)至
                            ${Purch_goods.pVarmax}(%)</font>
                        </td>
                    </tr>
                </table>
                <table border="1px" cellspacing="0px" width="100%" height="60px" cellpadding="0px">
                    <div style="background: lightblue;height: 30px;padding-top: 10px;">空气干燥基基准</div>
                    <tr>
                        <td id="tips"><font size="2">空干基水分Mad≤:</font></td>
                        <td>${Purch_goods.pMad}<font size="2">(%)</font></td>
                        <td id="tips"><font size="2">空干基全硫St,ar≤:</font></td>
                        <td>${Purch_goods.pStad}<font size="2">(%)</font></td>
                        <td id="tips" colspan="2"><font size="2">空干基挥发分Vad:</font></td>
                        <td><font size="2">${Purch_goods.pVadmin}(%)至
                            <${Purch_goods.pVadmax}(%)</font>
                        </td>
                    </tr>
                </table>
                <table border="1px" cellspacing="0px" width="100%" height="60px" cellpadding="0px">
                    <div style="background: lightblue;height: 30px;padding-top: 10px;">干基基准</div>
                    <tr>
                        <td id="tips"><font size="2">干基高位发热量Qgr,d≤:</font></td>
                        <td>${Purch_goods.pQgrd}<font size="2">(Kcal/kg)</font></td>
                        <td id="tips"><font size="2">干基全硫St,ar≤:</font></td>
                        <td>${Purch_goods.pStd}<font size="2">(%)</font></td>
                        <td id="tips" colspan="2"><font size="2">干燥无灰基挥发分:</font></td>
                        <td><font size="2">${purch_info.pVanmin}(%)至
                            ${Purch_goods.pVanmax}(%)</font>
                        </td>
                    </tr>
                </table>
                <table border="1px" cellspacing="0px" width="100%" height="120px" cellpadding="0px" style="border-top: 3px solid blue;" bgcolor="lightgray">
                    <tr>
                        <td id="tips"><font size="2">粒度(mm)≤:</font></td>
                        <td>${Purch_goods.pGrad}<font size="2">(Kcal/kg)</font></td>
                        <td id="tips"><font size="2">灰熔点ST(℃)≥:</font></td>
                        <td>${Purch_goods.pST}<font size="2">(%)</font></td>
                        <td id="tips" colspan="2"><font size="2">哈式可磨系数(HGI)≥:</font></td>
                        <td>${Purch_goods.pHGI}<font size="2">(%)</font></td>
                    </tr>
                    <tr>
                        <td>备注:</td>
                        <td colspan="6">${Purch_goods.pRemarks}</td>
                    </tr>
                </table>
                <div style="width: 100%;height: 39px;text-align: center;padding-top: 40px;">
                
                    <input type="submit" class="btn  btn-primary submit" value="摘牌"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" class="btn btn-default btn-inverse" value="返回" onclick="history.back()"/>
                </div>
            </div>
        </div>


    </form>
</div>
</body>
  
</html>
