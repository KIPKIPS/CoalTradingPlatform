<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shiyishi1.jsp' starting page</title>
    
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
		a{text-decoration: none}
		table{width: 100%} 
		table,tr,th{border: 1px solid gray;border-collapse:collapse;}
		div{border: 0px solid red;}
       
        /*设置所有td的内边距*/
			td{
				width: 150px;
				border-right: none;
				border-left: none;
			}
			
			/*整个信息显示页面*/
			#father{
				/* border: 1px solid red; */
				width: 100%;
				height: 240px;
				margin: auto;
			}
			/*表单信息区域*/
			#info{
				/* border: 1px solid black; */
				width: 98.8%;
				height: 380px;
				margin: auto;
				margin-top: 10px;
			}
			/*信息头*/
			#infoTitle{
				/* border: 1px solid green; */
				width: 130px;
				height: 40px;
				float: left;
				text-align: center;
				line-height:15px;
				background-color: dodgerblue;
				margin-top:0px;
			}
			
			/* 表格区域 */
			#infoTab{
				/* border: 1px solid red; */
				width:98.8%;
				height:200px;
			}
			
			#tips{
				text-align: left;
				font-size:15px;
				font-weight:700;
			}
			 #pass{          
            width:100px;
           
            margin-top: 10px;
            position: absolute;
            margin-left:30%;
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
            margin-left:70%;
            position: absolute;
        
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
<div id="father">
		
			
				<!--表单信息区域-->
				<div id="info">
					<!--信息头-->
					<div id="infoTitle"><br/><font color="white">报价信息</font></div>
					<div id="infoTab">
						<table border="1px" cellspacing="0px" width="100%" height="100%" align="center" cellpadding="5px" bgcolor="white">
							<tr>
								<td id="tips">供应数量(万吨):</td>
								<td>${specificGoodInfo.sCount}</td>
								<td id="tips">热值(KCal/kg)≥:</td>
								<td>${specificGoodInfo.sKCal}</td>
								<td id="tips">原煤单价(元/吨):</td>
								<td>${specificGoodInfo.sCPrice}</td>
							</tr>
							<tr>
								<td id="tips">全硫(%)≤:</td>
								<td>${specificGoodInfo.sS}</td>
								<td id="tips">产地:</td>
								<td>${specificGoodInfo.sPlace}</td>
								<td id="tips">运费单价：</td>
								<td>${specificGoodInfo.sFreight}<font color="#FF0000"></font>元/吨</td>
							</tr>
							<tr>
								<td id="tips">发站(发货港口):</td>
								<td>${specificGoodInfo.sDeliverPlace}</td>
								<td id="tips">煤种:</td>
								<td>${specificGoodInfo.coalTtype}</td>
								<td  id="tips">运输方式:</td>
								<td>${specificGoodInfo.transType}</td>
							</tr>
							<tr>
								<td id="tips">空干基灰分(%)≤:</td>
								<td>${specificGoodInfo.sAshContent}</td>
								<td id="tips">全水分(%)≤:</td>
								<td>${specificGoodInfo.sMoisture}</td>
								<td id="tips">挥发分(%):</td>
								<td>${specificGoodInfo.sVolatilizeMin}<font size="2">&nbsp;&nbsp;
								至&nbsp;&nbsp;</font>${specificGoodInfo.sVolatilizeMax}</td>
							</tr>
						</table>
					
					</div> 
					</div>
					</div>  
<p>审核意见：</p>
<form action="SellerGoodInfo/sellerCheckNotPass" method="post">	    			
<textarea name="uOpinion" type="text" id="text" onKeyUp="textLimitCheck(this, 250);"spellcheck="false" style="width: 100%;height: 100px;" placeholder="请输入审核意见" onfocus="textOnfocus()" onblur="textOnblur()" ></textarea>
<br/>(限 250 个字符  已输入 <font color="#CC0000"><span id="messageCount">0</span></font> 个字)
<input name="sNumber" style="display:none" value="${specificGoodInfo.sNumber}"/>
<div onmousedown="notPass()">
    
    <input type="submit" class="btn btn-default btn-primary"  id="notPass"   value="审核不通过"/>
   
</div>
</form>	
 <div >

    <button id="pass" class="btn btn-default btn-primary"  onclick="tt(${specificGoodInfo.sNumber})">审核通过</button>
	<input type="button" class="btn btn-default btn-primary"  id="back" value="取消" onclick="history.back()"/>

<script type="text/javascript">
  function tt(sNumber){
  
  
  location.href="SellerGoodInfo/sellerCheckPass?sNumber="+${specificGoodInfo.sNumber};
  }
  </script>
</div>
<div style="width:100%;height:50px"></div>

  </body>
    <script>
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
