<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addNews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/layoutit.css">
	<style type="text/css">
		.topic{
			text-align:left;
		}
		.div1{
    width:70%;
    margin:0 auto;
}
 .a1{
    	text-decoration: none;
  }
  .ul1{
        list-style-type: none;
        float:right;
  }
  
		
		#nTheme{
			width:100%;
		}
		#nContent{
			width:100%;
			height:300px;
		}
		#left{
		    position:relative;
		    top:10px;
			width:50%;
			float:left;
			
		}
		#right{
		    position:relative;
		    top:10px;
			width:50%;
			float:right;
			
		}
		
		
	</style>
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$("#addNews").click(
  			function(){
  				
  				if($("#nTheme").val()==""||$("#nTheme").val().length>30){
  					alert("资讯标题为空或超过30字，请重新填写！"); 					
  				}else if($("#nContent").val()==""||$("#nContent").val().length>255){
  					alert("资讯内容为空或超过255字，请重新填写！");
  				}else{
  				$.ajax({
  					type:"post",
  					url:"News/addNews",
  					data:"nTheme="+$("#nTheme").val()+"&nContent="+$("#nContent").val(),
  					success:function(msg){
  								if(msg=="success"){
  									alert("提交成功，请等待审核人员审核！");
  									location.href="News/index1";
  								}
  								else{
  									alert("提交失败，该资讯已存在！");
  								}
  							},
  					error:	function(){
  								alert("资讯信息填写有误，请重新填写！");
  							}
  				});
  				}
  			}
  		);
  	});
  </script>

  </head>
  <body>
  <div style = "margin-left: -30%;">
			    <div class = "div1">
		    <ul class="breadcrumb">
			<li>
				 <a href="javascript:void(0);" onclick="javascript:history.go(-1);">资讯列表</a>
			</li>
			<li class="active">
				增加资讯
			</li>
		    </div>
  <center>
  <div style="width:60%;">
  <form>
    <div class="topic">资讯标题：</div><div class="other"><input type="text" id="nTheme" placeholder="不能超过30个字。" style="background-color:rgb(200,208,202);"></div>
    <div class="topic">资讯内容：</div>
    <textarea id="nContent" style="overflow:heidden;background-color:rgb(200,208,202);" placeholder="不能超过255个字。"></textarea>
	<div id="left"><input type="button" class="btn btn-default btn-primary" value="提交" id="addNews"></div>
	<div id="right"><input type="reset" class="btn btn-default btn-primary" value="重置"></div>
	</form>
	</div>
</center>
  </body>
</html>
