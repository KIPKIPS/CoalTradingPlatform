<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style type="text/css">
		input{
			float:right
		}
				   
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
  
  <body >

<div class="container-fluid" style="background: rgb(0,86,144);border-radius: 36px;height: 30px;">
	<span style="color: white;line-height: 31px; margin-left: 106px;">完善用户详情</span>
</div>

     <!-- 主体  -->
    <div class="main"  id="particles">
    	    <!-- <div style="width: 80%;height: 8%;margin: auto;"></div> -->
    		<div style="width: 94%;height: 64%;margin: auto;">
                   <div style="width: 65%;height: 100%;margin: auto;">
                   	    <!-- 标签信息 -->
                   	    <div style="    border-bottom: 3px solid steelblue;margin-bottom: 39px; padding: 4px;margin-top:20px; ">
                   	    	<span style="    background: steelblue;padding: 8px;  color: white;">基本信息</span>
                   	    </div>
                   	  
                   	   <form   action="trader/secondregist"  enctype="multipart/form-data" method="post" >
                   	   
    			        <table style="text-align:left;">
    			        <tr>
                     
                          <th>用户名：<input type="text" id="uName" name="uName"   ><br></th>
                           <th>&nbsp;&nbsp;&nbsp;&nbsp;用户真实姓名：<input type="text" id="uRealName" name="uRealName"   ><br></th>
                        </tr>
                        <tr>
                          <th>供应商名称：<input type="text" id="cName" name="cName" onchange="checkAll()" onblur="checkcName()" ><br><span id="messagecName"><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;企业类型：<input type="text"  id="cType" name="cType" ><br><span id="messagecType"}><br></span></th>
                        </tr>
                        <tr>
                          <th>法人代表：<input type="text" id="cLegalPerson" name="cLegalPerson" onchange="checkAll()" onblur="checkcLegalPerson()"><br><span id="messagecLegalPerson" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;法人身份证：<input type="text" id="cLegalPersonID" name="cLegalPersonID" onchange="checkAll()"  onblur="checkcLegalPersonID()" ><br><span id="messagecLegalPersonID"><br></span></th>
                        </tr>
                        <tr>
                          <th><div style="text-align:left;padding-left:50px">
        <!-- <th>注册地区:<input type="text" id="cAddress" name="cAddress" ><br><span id="messagecAddress" ><br></span></th> -->
    	注册地区:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="address1" name="cAddress" style="height:25px" onchange="areaChange()">
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
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;企业邮箱：<input type="text" id="cEmile" name="cEmile" onchange="checkAll()"  onblur="checkcEmile()" ><br><span id="messagecEmile" ><br></span></th>
                        </tr>
                        <tr>
                          <th>财务人员联系电话：<input type="text" id="muTelephone" name="muTelephone" onblur="checkmuTelephone()" ><br><span id="messagemuTelephone" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;财务姓名：<input type="text" id="muName" name="muName"  ></th>
                        </tr>
                         <tr>
                          
                          <th>财务mail：<input type="text" id="muMail" name="muMail"  ></th>
                        </tr>
                        <tr>
                          <th>联系电话：<input type="text" id="uTelephone" name="uTelephone" onchange="checkAll()"  onblur="checkuTelephone()" ><br><span id="messageuTelephone" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;传真：<input type="text" id="cFax" name="cFax" onchange="checkAll()" onblur="checkcFax()" ><br><span id="messagecFax" ><br></span></th>
                        </tr>
                          <th>邮政编码：<input type="text" id="cPostalCode" name="cPostalCode" onchange="checkAll()" onblur="checkcPostalCode()" ><br><span id="messagecPostalCode" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;注册资金(万元)：<input type="text" id="cMoney" name="cMoney"  onchange="checkAll()" onblur="checkcMoney()"><br><span id="messagecMoney" ><br></span></th>
                        <tr>
                          <th>营业执照号：<input type="text" id="cBusinessLicense" name="cBusinessLicense"  onchange="checkAll()" onblur="checkcBusinessLicense()"><br><span id="messagecBusinessLicense" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;组织机构代码：<input type="text" id="cOrg" name="cOrg" onchange="checkAll()" onblur="checkcOrg()"><br><span id="messagecOrg" ><br></span></th>
                        </tr>
                        <tr>
                          <th>经营许可证编号：<input type="text" id="cPermission" name="cPermission"  onchange="checkAll()" onblur="checkcPermission()"><br><span id="messagecPermission" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;税务登记证代码：<input type="text" id="cTax" name="cTax" onchange="checkAll()" onblur="checkcTax()"><br><span id="messagecTax" ><br></span></th>
                        </tr>
                        <tr>
                          <th>开户银行：<input type="text" id="cBank" name="cBank"  onchange="checkAll()" onblur="checkcBank()"><br><span id="messagecBank" ><br></span></th>
                          <th>&nbsp;&nbsp;&nbsp;&nbsp;账号：<input type="text" id="cBankAccount" name="cBankAccount"  onchange="checkAll()" onblur="checkcBankAccount()" ><br><span id="messagecBankAccount"><br></span></th>
                        </tr>
                        
                        <tr>
                          <th colspan="2">煤源存放地点、数量、质量：<br><textarea rows="4" cols="94%" id="cResource" name="cResource"  onblur="checkcResource()"></textarea></th>
                        </tr>
                        <tr>
                          <th colspan="2">运输方式及保障方式：<br><textarea rows="4" cols="94%" id="cTransport" name="cTransport"  onblur="checkcTransport()"></textarea></th>
                        </tr>
                        <tr>
                          <th colspan="2">供应商介绍：<br><textarea rows="4" cols="94%" id="cBrief" name="cBrief"  onblur="checkcBrief()"></textarea></th>
                        </tr>
                        
                       
                       <tr>
                        <td colspan="3"><input type="submit" class="btn btn-primary" style="width:80px;margin:33px 100px 0px 100px;">
                        
                                        <button type="button" class="btn btn-primary" style="width:80px;margin:33px 100px 0px 100px;" >返回</button></td>        
                        </tr>
            
                    </table>
    			         
    			        </form>
    			       
    			        
          
    			       
<center>
<fieldset style="border: 3px  white;text-align: left;">
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
  	
    
</fieldset></center><br>

    			        
    			        
                   </div>
    		</div>
    
    </div>
    





<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    function checkcName() { //验证供应商名称
        var name = document.getElementById("cName");
        var Value = name.value;
        var message = document.getElementById("messagecName");
        if (Value.trim().length < 6 || Value.trim().length > 18) {
            message.style.color = "red";
            message.innerHTML = "供应商名称只能是6-18位之间";
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

    function checkcFax() { //验证传真
        var name = document.getElementById("cFax");
        var Value = name.value;
        var cFax = /^.{1,20}$/;
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

    function checkcPostalCode() { //验证邮政编码
        var name = document.getElementById("cPostalCode");
        var Value = name.value;
        var cPostalCode = /[1-9]\d{5}(?!\d)/;
        var message = document.getElementById("messagecPostalCode");
        if (!cPostalCode.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "邮政编码为六位数字";
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
        var cOrg = /^.{3,20}$/;
        var message = document.getElementById("messagecOrg");
        if (Value.trim().length!=9 || !cOrg.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "格式有误";
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
            message.innerHTML = "应为14位数字";
            return false;
        }
        else {
            message.style.color = "green";
            message.innerHTML = "√";
            return true;
        }
    }

    function checkcTax() { //验证税务登记证代码：6位行政区划代码(阿拉伯数字)+9位组织机构代码(数字)
		var name = document.getElementById("cTax");
        var Value = name.value;
        var cTax = /^\d{15}$/;
        var message = document.getElementById("messagecTax");
        if (!cTax.test(Value)) {
            message.style.color = "red";
            message.innerHTML = "应为15位数字";
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
	    var cLegalPerson = /^.{2,20}$/;
	    var message = document.getElementById("messagecLegalPerson");
	    if (!cLegalPerson.test(Value)) {
	        message.style.color = "red";
	        message.innerHTML = "格式有误";
	        return false;
	    }
	    else {
	        message.style.color = "green";
	        message.innerHTML = "√";
	        return true;
	    }
	}

	function checkcAddress() { //验证注册地区
	    var name = document.getElementById("cAddress");
	    var Value = name.value;
	    var cAddress = /^.{1,20}$/;
	    var message = document.getElementById("messagecAddress");
	    if (!cAddress.test(Value)) {
	        message.style.color = "red";
	        message.innerHTML = "格式有误";
	        return false;
	    }
	    else {
	        message.style.color = "green";
	        message.innerHTML = "√";
	        return true;
	    }
	}

	function checkcMoney() { //验证注册资金
	    var name = document.getElementById("cMoney");
	    var Value = name.value;
	    var cMoney = /^\d+(\.\d+)?$/;
	    var message = document.getElementById("messagecMoney");
	    if (!cMoney.test(Value)) {
	        message.style.color = "red";
	        message.innerHTML = "应为非负纯数字";
	        return false;
	    }
	    else {
	        message.style.color = "green";
	        message.innerHTML = "√";
	        return true;
	    }
	}

	function checkcBank() { //验证开户银行
	    var name = document.getElementById("cBank");
	    var Value = name.value;
	    var cBank = /^[\u4e00-\u9fa5]{0,}$/;
	    var message = document.getElementById("messagecBank");
	    if (!cBank.test(Value)) {
	        message.style.color = "red";
	        message.innerHTML = "格式错误";
	        return false;
	    }
	    else {
	        message.style.color = "green";
	        message.innerHTML = "√";
	        return true;
	    }
	}

	function checkcBankAccount() { //验证账号
	    var name = document.getElementById("cBankAccount");
	    var Value = name.value;
	    var cBankAccount = /^\d{19}$/g;
	    var message = document.getElementById("messagecBankAccount");
	    if (!cBankAccount.test(Value)) {
	        message.style.color = "red";
	        message.innerHTML = "卡号应为19位";
	        return false;
	    }
	    else {
	        message.style.color = "green";
	        message.innerHTML = "√";
	        return true;
	    }
	}
	

	
	
	
	function checkAll(){
	
	var check1=checkcName();
	var check2=checkcLegalPersonID();
	var check3=checkcEmile();
	var check4=checkuTelephone();
	var check5=checkcFax();
	var check6=checkcPostalCode();
	var check7=checkcBusinessLicense();
	var check8=checkcOrg();
	var check9=checkcPermission();
	var check10=checkcTax();
	var check11=checkcLegalPerson();
	
	var check13=checkcMoney();
	var check14=checkcBank();
	var check15=checkcBankAccount();
	var message=document.getElementById("submit");
	if(check1&&check2&&check3&&check4&&check5&&check6&&check7&&check8&&check9&&check10&&check11&&check13&&check14&&check15)
	message.disabled=false;
	else
	message.disabled=true;
	}
      </script>



  </body>
</html>
