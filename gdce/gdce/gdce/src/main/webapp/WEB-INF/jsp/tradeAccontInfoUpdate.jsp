<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" -->
<html xmlns="http://www.w3.org/1999/html">
  <head lang="en">
    <base href="<%=basePath%>">
    
    <title>信息修改</title>
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 分辨率在1366x768时fieldset的width设置为：800px；分辨率在1920x1080时设为：700px； -->
	<!-- 分辨率在1366x768时HR的width设置为：740px；分辨率在1920x1080时设为：600px； -->
	<style>		   
        legend{
            background-color: blue;      
        }
        div{
            text-align: center;
        }    
        fieldset{
            width: 800px;
            text-align: right;
        }
        .HR{
        	width:740px;
            height: 2px;
            background: -webkit-linear-gradient(left,rgba(255,255,255,0),blue,rgba(55,255,255,0));
            background: linear-gradient(to right,rgba(255,255,255,0),blue,rgba(255,255,255,0));
        }
        
        .buttonSub{
            color: #fefee9;
            width: 70px;
            height: 32px;
            line-height: 100%;
            padding: 0.3em;
            font: 16px Arial,sans-serif bold;
            font-style: normal;
            text-decoration: none;
            vertical-align: text-bottom;
            font-size-adjust: none;
            outline: none;
            border-radius: 5px;
            border: 0 solid dodgerblue;
            background-size: auto;
            background-origin: padding-box;
            background-clip: padding-box;
            background-repeat: repeat;
            background-color: #4499ff;
        }
        
        .buttonBack{
            color: #fefee9;
            width: 70px;
            height: 32px;
            line-height: 100%;
            padding: 0.3em;
            font: 16px Arial,sans-serif bold;
            font-style: normal;
            text-decoration: none;
            vertical-align: text-bottom;
            font-size-adjust: none;
            outline: none;
            border-radius: 5px;
            border: 0 solid dodgerblue;
            background-size: auto;
            background-origin: padding-box;
            background-clip: padding-box;
            background-repeat: repeat;
            background-color: #4499ff;
        }
        
       .fileSub_btn{
       		color: #fefee9;
            width: 130px;
            height: 32px;
            line-height: 100%;
            padding: 0.3em;
            font: 16px Arial,sans-serif bold;
            font-style: normal;
            text-decoration: none;
            vertical-align: text-bottom;
            font-size-adjust: none;
            outline: none;
            border-radius: 5px;
            border: 0px solid dodgerblue;
            border-right:2px solid white;
            background-size: auto;
            background-origin: padding-box;
            background-clip: padding-box;
            background-repeat: repeat;
            background-color: #4499ff;
       }
       .fileSub_btn:hover{
       		background-color:deepskyblue;
       }
        
    </style>

  </head>
  
  <body>  
<center>
<fieldset style="border: 3px solid blue;" name="fieldset1" >
    <legend style="text-align: left"><b><font color="white" face="宋体">基本信息</font></b></legend>
<form method="post" action="trader/tradeAccontInfoFormModify" name="form1" onsubmit="return checkAllEle()">
    <table>
    <tr>
        <th>供应商名称:<input type="text" id="cName" name="cName" onblur="checkcName()" value=${trader.cName}><br><span id="messagecName"><br></span></th>
        <th>企业类型:<input type="text" readonly="readonly" id="cType" name="cType" value=${trader.cType}><br><span id="messagecType"}><br></span></th>
    </tr>
    <tr>
        <th>法人代表:<input type="text" id="cLegalPerson" name="cLegalPerson" onblur="checkcLegalPerson()" value=${trader.cLegalPerson}><br><span id="messagecLegalPerson" ><br></span></th>
        <th>法人身份证:<input type="text" id="cLegalPersonID" name="cLegalPersonID" onblur="checkcLegalPersonID()" value=${trader.cLegalPersonID}><br><span id="messagecLegalPersonID"><br></span></th>
    </tr>
    <tr>
        <th><div style="text-align:left;padding-left:50px">
        <!-- <th>注册地区:<input type="text" id="cAddress" name="cAddress" value=${trader.cAddress}><br><span id="messagecAddress" ><br></span></th> -->
    	注册地区:<select id="address1" name="cAddress" style="height:25px" onchange="areaChange()">
    		<option class="option-1">北京</option>
            <option class="option-2">广西</option>
            <option class="option-3">山东</option>
            <option class="option-4">湖南</option>
            <option class="option-5">山西</option>
            <option class="option-6">陕西</option>     
    	</select>&nbsp;省(直辖市)&nbsp;
    	<select id="address2"  name="cAddress" style="height:25px">
    		<option class="option-7">朝阳</option>
        	<option class="option-8">南宁</option>
        	<option class="option-9">济南</option>
        	<option class="option-10">长沙</option>
        	<option class="option-11">太原</option>
        	<option class="option-12">西安</option>       	
    	</select>&nbsp;市(区)</div><br>
    	</th>
        <th>企业邮箱:<input type="text" id="cEmile" name="cEmile" onblur="checkcEmile()" value=${trader.cEmile}><br><span id="messagecEmile" ><br></span></th>
    </tr>
    <tr>
        <th>联系电话:<input type="text" id="uTelephone" name="uTelephone" onblur="checkuTelephone()" value=${trader.uTelephone}><br><span id="messageuTelephone" ><br></span></th>
        <th>传真:<input type="text" id="cFax" name="cFax" onblur="checkcFax()" value=${trader.cFax}><br><span id="messagecFax" ><br></span></th>
    </tr>
        <th>邮政编码:<input type="text" id="cPostalCode" name="cPostalCode" onblur="checkcPostalCode()" value=${trader.cPostalCode}><br><span id="messagecPostalCode" ><br></span></th>
        <th>注册资金(万元):<input type="text" id="cMoney" name="cMoney" onblur="checkcMoney()" value=${trader.cMoney}><br><span id="messagecMoney" ><br></span></th>
    <tr>
        <th>营业执照号:<input type="text" id="cBusinessLicense" name="cBusinessLicense" value=${trader.cBusinessLicense} onblur="checkcBusinessLicense()"><br><span id="messagecBusinessLicense" ><br></span></th>
        <th>组织机构代码:<input type="text" id="cOrg" name="cOrg" value=${trader.cOrg} onblur="checkcOrg()"><br><span id="messagecOrg" ><br></span></th>
    </tr>
    <tr>
        <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经营许可证编号:<input type="text" id="cPermission" name="cPermission" value=${trader.cPermission} onblur="checkcPermission()"><br><span id="messagecPermission" ><br></span></th>
        <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税务登记证代码:<input type="text" id="cTax" name="cTax" value=${trader.cTax} onblur="checkcTax()"><br><span id="messagecTax" ><br></span></th>
    </tr>
    <tr>
        <th><div style="text-align:right;padding-right:-50px">开户银行:<select id="cBank" name="cBank" style="width:160px;height:25px;">
        		<option>${trader.cBank}</option>
        		<option>中国建设银行</option>
        		<option>中国工商银行</option>
        		<option>中国农业银行</option>
        		<option>中国交通银行</option>
        		<option>邮政储蓄银行</option>
        	</select></div><span id="messagecBank" ><br></span></th>
        <th>账号:<input type="text" id="cBankAccount" name="cBankAccount" onblur="checkcBankAccount()" value=${trader.cBankAccount}><br><span id="messagecBankAccount"><br></span></th>
    </tr>
    <tr> <!-- 分辨率在1366x768时cols设置为：83px,padding-left为:100px；分辨率在1920x1080时设为：90%,padding-left为:13.5%； -->
        <th colspan="2"><div style="text-align:left;padding-left:100px;font-family:DFKai-SB">煤源存放地点、数量、质量:</div>
        <textarea rows="4" cols="83px" id="cResource" name="cResource" onkeyup="checkLenResource(this)">${trader.cResource}</textarea>
        <div style="text-align:left;padding-left:100px;"><span id="messagecResource" style="font-Weight:normal"></span></div></th>
    </tr>
    <tr>
        <th colspan="2"><div style="text-align:left;padding-left:100px">运输方式及保障方式:</div>
        <textarea rows="4" cols="83px" id="cTransport" name="cTransport" onkeyup="checkLenTransport(this)">${trader.cTransport}</textarea>
        <div style="text-align:left;padding-left:100px"><span id="messagecTransport" style="font-Weight:normal"></span></div></th>
    </tr>
    <tr>
        <th colspan="2"><div style="text-align:left;padding-left:100px">供应商介绍:</div>
        <textarea rows="4" cols="83px" id="cBrief" name="cBrief" onkeyup="checkLenBrief(this)">${trader.cBrief}</textarea>
        <div style="text-align:left;padding-left:100px"><span id="messagecBrief" style="font-Weight:normal"></span></div></th>
    </tr>   
    </table><br>
    
    <!-- <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="100%" color=blue SIZE=3><br> -->
    <div class="HR" style="margin:0 auto;"></div><br>
    <!-- <HR style="border:1 dashed #987cb9" width="90%" color=#987cb9 SIZE=1> -->
    
    <div>
	<input type="submit"
               id="submitcheck"
               class="buttonSub"
               value="提  交"
               onmouseout="btnOut();"
               onmouseover="btnFoc();"
               onmousedown="btnDown();"
               onmouseup="btnFoc();"
               >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" 
			onclick="window.history.back()" 
			value="返回"
			class="buttonBack"
			onmouseout="btnOut_back();"
            onmouseover="btnFoc_back();"
            onmousedown="btnDown_back();"
            onmouseup="btnFoc_back();"
            >
	</div>
	<br>
</form>
</fieldset></center><br>
<center>
<fieldset style="border: 3px solid blue;text-align: left;">
    <legend><b><font color="white" face="宋体">企业资质</font></b></legend>
    <table>
    &nbsp;&nbsp;<form enctype="multipart/form-data" id="uploadForm">				
		<input type="file" name="cBusinessLicense" id="file" style="display: none" accept="image/*">
		<input type="button" onclick="cBusinessLicenseUpdate()" class="fileSub_btn" id="tip1" value="上传营业执照"/>
		<!-- <font color="green"><span id="tip1"></span></font> -->		
  	</form>
  	
  	<form enctype="multipart/form-data" id="uploadForm2">	 		
		<input type="file" name="cTax" id="file2" style="display: none" accept="image/*">
		<input type="button" onclick="cTaxUpdate()" class="fileSub_btn" id="tip2" value="上传税务登记证"/>
		<!-- <font color="green"><span id="tip2"></span></font> -->	
  	</form>
  	
  	<form enctype="multipart/form-data" id="uploadForm4">	
		<input type="file" name="cBank" id="file4" style="display: none" accept="image/*">
		<input type="button" onclick="cBankUpdate()" class="fileSub_btn" id="tip4" value="上传开户许可证"/>
		<!-- <font color="green"><span id="tip4"></span></font> -->	
  	</form>
  	
  	<form enctype="multipart/form-data" id="uploadForm6">		
		<input type="file" name="cLegalPerson" id="file6" style="display: none" accept="image/*">
		<input type="button" onclick="cLegalPersonUpdate()" class="fileSub_btn" id="tip6" value="上传法人身份证"/>
		<!-- <font color="green"><span id="tip6"></span></font> -->	
  	</form>
  	
  	<form enctype="multipart/form-data" id="uploadForm3">			
		<input type="file" name="cOrg" id="file3" style="display: none" accept="image/*">
		<input type="button" onclick="cOrgUpdate()" class="fileSub_btn" id="tip3" value="上传组织机构代码证"/>
		<!-- <font color="green"><span id="tip3"></span></font> -->
  	</form>
  	
  	<form enctype="multipart/form-data" id="uploadForm5">	
		<input type="file" name="cPermission" id="file5" style="display: none" accept="image/*">
		<input type="button" onclick="cPermissionUpdate()" class="fileSub_btn" id="tip5" value="上传煤炭经营许可证"/>
		<!-- <font color="green"><span id="tip5"></span></font> -->	
  	</form>
  	
  	</table>
  	<center><font color="green">资质上传仅支持.jpg类型文件!</font></center> 
    
</fieldset></center><br>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){ // 数据预加载
		
		var cMoney = "${trader.cMoney}";		//钱数去整数后无用小数点(如400.0->400)
		document.getElementById("cMoney").value = parseFloat(cMoney);
		
		var Resource ="${trader.cResource}".length; 
		curr = 200 - Resource;
		document.getElementById("messagecResource").style.fontSize = "13px"; 
		document.getElementById("messagecResource").style.color = "grey";
		document.getElementById("messagecResource").innerHTML = "您还可以输入" + curr.toString() + "个文字!"; //预加载煤源存放地点、数量、质量
		
		var Transport ="${trader.cTransport}".length; 
		curr = 50 - Transport;
		document.getElementById("messagecTransport").style.fontSize = "13px"; 
		document.getElementById("messagecTransport").style.color = "grey";
		document.getElementById("messagecTransport").innerHTML = "您还可以输入" + curr.toString() + "个文字!"; //预加载运输方式及保障方式
		
		var Brief ="${trader.cBrief}".length; 
		curr = 100 - Brief;
		document.getElementById("messagecBrief").style.fontSize = "13px";
		document.getElementById("messagecBrief").style.color = "grey";
		document.getElementById("messagecBrief").innerHTML = "您还可以输入" + curr.toString() + "个文字!"; //预加载供应商介绍
		
		var address = "${trader.cAddress}";
		document.getElementById("address1").value = address.substring(0,address.indexOf(" "));// 截取","之前的字符串(身份)
		
		var p1 = address.substring(0,address.indexOf(" "));
		var p2 = document.getElementById("address2");
		var prov = address.substring(address.indexOf(" ") + 1, address.length);
		document.getElementById("address2").innerHTML="<option>" + prov + "</option>"; //预加载 二级级联
		/* switch(p1) 
		{
			case"广西": p2.innerHTML="<option>南宁</option><option>柳州</option><option>桂林</option><option>梧州</option><option>北海</option>";break;
			case"山东": p2.innerHTML="<option>济南</option><option>青岛</option><option>淄博</option><option>枣庄</option><option>东营</option>";break;
			case"湖南": p2.innerHTML="<option>长沙</option><option>株洲</option><option>湘潭</option><option>衡阳</option><option>邵阳</option>";break;
			case"山西": p2.innerHTML="<option>太原</option><option>大同</option><option>阳泉</option><option>长治</option><option>晋城</option>";break;
			case"陕西": p2.innerHTML="<option>西安</option><option>铜川</option><option>宝鸡</option><option>咸阳</option><option>渭南</option>";break;
	
			} */
		
		//document.getElementById("address2").value = address.substring(address.indexOf(" ") + 1, address.length);// 截取","之后的字符串(市县)		
	});
	
	function btnDown(){//提交按钮点击时
        var down=document.getElementsByClassName("buttonSub")[0];
        down.style.cssText="background-color:royalblue;";
    }

    function btnFoc(){//提交按钮鼠标在上方时
        var foc=document.getElementsByClassName("buttonSub")[0];
        foc.style.cssText="background-color:deepskyblue;";
    }
    function btnOut(){//提交按钮松开鼠标时(失焦)
        var out=document.getElementsByClassName("buttonSub")[0];
        out.style.cssText="background-color:#4499ff;";
    }
    
    function btnDown_back(){//提交按钮点击时
        var down=document.getElementsByClassName("buttonBack")[0];
        down.style.cssText="background-color:royalblue;";
    }

    function btnFoc_back(){//提交按钮鼠标在上方时
        var foc=document.getElementsByClassName("buttonBack")[0];
        foc.style.cssText="background-color:deepskyblue;";
    }
    function btnOut_back(){//提交按钮松开鼠标时(失焦)
        var out=document.getElementsByClassName("buttonBack")[0];
        out.style.cssText="background-color:#4499ff;";
    }
	
	function areaChange(){ // 省市级联
		var x = document.getElementById("address1");
        var y = document.getElementById("address2");
        	y.options.length = 0;
        	if(x.selectedIndex == 0)
            {
                y.options.add(new Option("丰台","丰台"));
                y.options.add(new Option("朝阳","朝阳"));
                y.options.add(new Option("海淀","海淀"));
                y.options.add(new Option("房山","房山"));
                y.options.add(new Option("通州","通州"));
            }
            if(x.selectedIndex == 1)
            {
                y.options.add(new Option("南宁","南宁"));
                y.options.add(new Option("柳州","柳州"));
                y.options.add(new Option("桂林","桂林"));
                y.options.add(new Option("梧州","梧州"));
                y.options.add(new Option("北海","北海"));
            }
            if(x.selectedIndex == 2)
            {
                y.options.add(new Option("济南","济南"));
                y.options.add(new Option("青岛","青岛"));
                y.options.add(new Option("淄博","淄博"));
                y.options.add(new Option("枣庄","枣庄"));
                y.options.add(new Option("东营","东营"));
            }
            if(x.selectedIndex == 3)
            {
                y.options.add(new Option("长沙","长沙"));
                y.options.add(new Option("株洲","株洲"));
                y.options.add(new Option("湘潭","湘潭"));
                y.options.add(new Option("衡阳","衡阳"));
                y.options.add(new Option("邵阳","邵阳"));
            }
            if(x.selectedIndex == 4)
            {
                y.options.add(new Option("太原","太原"));
                y.options.add(new Option("大同","大同"));
                y.options.add(new Option("阳泉","阳泉"));
                y.options.add(new Option("长治","长治"));
                y.options.add(new Option("晋城","晋城"));
            }
            if(x.selectedIndex == 5)
            {
                y.options.add(new Option("西安","西安"));
                y.options.add(new Option("铜川","铜川"));
                y.options.add(new Option("宝鸡","宝鸡"));
                y.options.add(new Option("咸阳","咸阳"));
                y.options.add(new Option("渭南","渭南"));
            }
	}
	
    function cBusinessLicenseUpdate() { //更新企业营业执照
    		$("#file").click().change(function() {
    			$.ajax({
    				type:"post",
    				url:"file/modifyHeader",
    				enctype : "multipart/form-data",
					data : new FormData($("#uploadForm")[0]),//新的文件对象（新的图片名称）
					processData : false, //data的值是FormData对象，不需要对数据进行处理
					contentType : false, //FormData对象由form表单构建                                      
					cache : false,
					success:function(msg){
						$("#tip1").attr({"value":"上传成功!"})
					},
					error:function(){
						alert("上传失败！请校对格式");
					}			
    			});
    		})
    	}
    	
    	function cTaxUpdate(){//更新税务登记证
    		$("#file2").click().change(function() {			
    			$.ajax({
    				type:"post",
    				url:"file/modifyHeader2",
    				enctype : "multipart/form-data",
					data : new FormData($("#uploadForm2")[0]),//新的文件对象（新的图片名称）
					processData : false, //data的值是FormData对象，不需要对数据进行处理
					contentType : false, //FormData对象由form表单构建                                      
					cache : false,
					success:function(msg){
						$("#tip2").attr({"value":"上传成功!"})
					},
					error:function(){
						alert("上传失败！请校对格式");
					}			
    			});
    		})
    	
    	}
    	
    	function cOrgUpdate(){//更新组织机构代码证
    		$("#file3").click().change(function() {		
    			$.ajax({
    				type:"post",
    				url:"file/modifyHeader3",
    				enctype : "multipart/form-data",
					data : new FormData($("#uploadForm3")[0]),//新的文件对象（新的图片名称）
					processData : false, //data的值是FormData对象，不需要对数据进行处理
					contentType : false, //FormData对象由form表单构建                                      
					cache : false,
					success:function(msg){
						$("#tip3").attr({"value":"上传成功!"})
					},
					error:function(){
						alert("上传失败！请校对格式");
					}			
    			});
    		})
    	}
    	
    	function cBankUpdate(){//更新企业开户许可证
    		$("#file4").click().change(function() {		
    			$.ajax({
    				type:"post",
    				url:"file/modifyHeader4",
    				enctype : "multipart/form-data",
					data : new FormData($("#uploadForm4")[0]),//新的文件对象（新的图片名称）
					processData : false, //data的值是FormData对象，不需要对数据进行处理
					contentType : false, //FormData对象由form表单构建                                      
					cache : false,
					success:function(msg){
						$("#tip4").attr({"value":"上传成功!"})
					},
					error:function(){
						alert("上传失败！请校对格式");
					}			
    			});
    		})
    	}
    	
    	function cPermissionUpdate(){//更新煤炭经营许可证
    		$("#file5").click().change(function() {		
    			$.ajax({
    				type:"post",
    				url:"file/modifyHeader5",
    				enctype : "multipart/form-data",
					data : new FormData($("#uploadForm5")[0]),//新的文件对象（新的图片名称）
					processData : false, //data的值是FormData对象，不需要对数据进行处理
					contentType : false, //FormData对象由form表单构建                                      
					cache : false,
					success:function(msg){
						$("#tip5").attr({"value":"上传成功!"})
					},
					error:function(){
						alert("上传失败！请校对格式");
					}			
    			});
    		})
    	}
    	
    	function cLegalPersonUpdate(){//更新法人身份证
    		$("#file6").click().change(function() {		
    			$.ajax({
    				type:"post",
    				url:"file/modifyHeader6",
    				enctype : "multipart/form-data",
					data : new FormData($("#uploadForm6")[0]),//新的文件对象（新的图片名称）
					processData : false, //data的值是FormData对象，不需要对数据进行处理
					contentType : false, //FormData对象由form表单构建                                      
					cache : false,
					success:function(msg){
						$("#tip6").attr({"value":"上传成功!"})
					},
					error:function(){
						alert("上传失败！请校对格式");
					}			
    			});
    		})
    	}

    //提交验证
    function checkcName() { //验证供应商名称
        var name = document.getElementById("cName");
        var Value = name.value;
        var message = document.getElementById("messagecName");
        if (Value.trim().length <= 0) {
            message.style.color = "red";
            message.innerHTML = "供应商名称不能为空";
            return false;
        } else if (isNaN(Value) == false) {
            message.style.color = "red";
            message.innerHTML = "供应商名称不能含有数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }
	
	function checkcLegalPerson() { //验证法人代表
        var name = document.getElementById("cLegalPerson");
        var Value = name.value;
        var cLegalPerson = /^[\u4e00-\u9fa5]{2,4}$/;
        var message = document.getElementById("messagecLegalPerson");
        if (!cLegalPerson.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "法人代表有误";
            return false;
               }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }
	
    function checkcLegalPersonID() { //验证法人身份证
        var name = document.getElementById("cLegalPersonID");
        var Value = name.value;
        var cLegalPersonID = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        var message = document.getElementById("messagecLegalPersonID");
        if (!cLegalPersonID.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "身份证号有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcEmile() { //验证企业邮箱
        var name = document.getElementById("cEmile");
        var Value = name.value;
        var cEmile = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        var message = document.getElementById("messagecEmile");
        if (!cEmile.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "邮箱格式有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkuTelephone() { //验证联系电话
        var name = document.getElementById("uTelephone");
        var Value = name.value;
        var uTelephone = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        var message = document.getElementById("messageuTelephone");
        if (!uTelephone.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "联系电话格式有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcFax() { //验证传真(8位数字)
        var name = document.getElementById("cFax");
        var Value = name.value;
        var cFax = /^(\d{3,4}-)?\d{7,8}$/;
        var message = document.getElementById("messagecFax");
        if (!cFax.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "传真格式有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcPostalCode() { //验证邮政编码(6位数字)
        var name = document.getElementById("cPostalCode");
        var Value = name.value;
        var cPostalCode = /[1-9]\d{5}(?!\d)/;
        var message = document.getElementById("messagecPostalCode");
        if (!cPostalCode.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "邮政编码格式有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }
    
     function checkcMoney(){ //验证注册资金(非零正整数)
        var name = document.getElementById("cMoney");
        var Value = name.value;
        var cMoney = /^[1-9]\d*$/;
        var message = document.getElementById("messagecMoney");
        if (!cMoney.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "不为零且为正整数";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }
    
    function checkcBusinessLicense() { //验证营业执照号15位数字
		var name = document.getElementById("cBusinessLicense");
        var Value = name.value;
        var cBusinessLicense = /^\d{15}$/;
        var message = document.getElementById("messagecBusinessLicense");
        if (!cBusinessLicense.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "营业执照号为15位数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcOrg() { //验证组织机构代码(8位数字或大写拉丁字母+1位数字或大写拉丁字母)
		var name = document.getElementById("cOrg");
        var Value = name.value;
        var cOrg = /^[A-Z0-9]+$/;
        var message = document.getElementById("messagecOrg");
        if (Value.trim().length!=9 || !cOrg.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "9位包含数字和大写拉丁字母";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcPermission() { //验证经营许可证编号（煤炭）14位数字
		var name = document.getElementById("cPermission");
        var Value = name.value;
        var cPermission = /^\d{14}$/;
        var message = document.getElementById("messagecPermission");
        if (!cPermission.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "14位数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcTax() { //验证税务登记证代码:6位行政区划代码(阿拉伯数字)+9位组织机构代码(数字)
		var name = document.getElementById("cTax");
        var Value = name.value;
        var cTax = /^\d{15}$/;
        var message = document.getElementById("messagecTax");
        if (!cTax.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "行政区划码(6位数字)+组织机构码(9位数字)";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }
    
    function checkcBankAccount() { //验证账号:19位
        var name = document.getElementById("cBankAccount");
        var Value = name.value;
        var cBankAccount = /^\d{19}$/g;
        var message = document.getElementById("messagecBankAccount");
        if (!cBankAccount.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "银行账号长度有误";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        	}
        }
       
	function checkAllEle(){ //验证通过方可上传
		if(checkcName()&&checkcLegalPersonID()&&checkcLegalPerson()&&checkcEmile()&&checkuTelephone()&&checkcFax()&&checkcPostalCode()&&checkcMoney()&&checkcBusinessLicense()&&checkcOrg()&&checkcPermission()&&checkcTax()&&checkcBankAccount()){
			$('form1').submit()
		}
		else{
		return false;
		}
	}
	
	//textarea字数限制
	/* $("cResource").on("input propertychange",function(){
		var $this = $(this),
		_val = $this.val(),
		count = "";
		if(_val.length > 5){
			$this.val(_val.substring(0,5));
		}
		count = 5 - $this.val().length;
		$("#messagecResource").text(count);
	}) */
	
	function checkLenResource(obj){ //煤源存放地点、数量、质量字数限制:200
		var maxChars = 200;
		if(obj.value.length > maxChars) obj.value = obj.value.substring(0,maxChars);
		var curr = maxChars - obj.value.length;
		document.getElementById("messagecResource").style.color = "grey";
		document.getElementById("messagecResource").innerHTML = "您还可以输入" + curr.toString() + "个文字!";
		if(curr == 0) {
			document.getElementById("messagecResource").style.color = "red";
			document.getElementById("messagecResource").innerHTML = "字数达到上限!";
			
			}
	}
	
	function checkLenTransport(obj){ //运输方式及保障方式字数限制:50
		var maxChars = 50;
		if(obj.value.length > maxChars) obj.value = obj.value.substring(0,maxChars);
		var curr = maxChars - obj.value.length;
		document.getElementById("messagecTransport").style.color = "grey";
		document.getElementById("messagecTransport").innerHTML = "您还可以输入" + curr.toString() + "个文字!";
		if(curr == 0) {
			document.getElementById("messagecTransport").style.color = "red";
			document.getElementById("messagecTransport").innerHTML = "字数达到上限!";
			}
		
	}
	
	function checkLenBrief(obj){//供应商介绍字数限制:100
		var maxChars = 100;
		if(obj.value.length > maxChars) obj.value = obj.value.substring(0,maxChars);
		var curr = maxChars - obj.value.length;
		document.getElementById("messagecBrief").style.color = "grey";
		document.getElementById("messagecBrief").innerHTML = "您还可以输入" + curr.toString() + "个文字!";
		if(curr == 0) {
			document.getElementById("messagecBrief").style.color = "red";
			document.getElementById("messagecBrief").innerHTML = "字数达到上限!";
			}		
	}
</script>
</body>
</html>
