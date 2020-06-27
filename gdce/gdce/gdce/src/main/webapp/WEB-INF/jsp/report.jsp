<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'report.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		option{
			background-color:orange;
		}
		input[type="button"] {
			   background-color: #4CAF50; /* Green */
			    border: none;
			    color: white;
			    padding: 3px 17px;
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    font-size: 13px;
			    margin: 4px 2px;
			    cursor: pointer;
			    border-radius: 12px;
		}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script src="js/jquery.table2excel.js"></script>
	<script src="js/highcharts.src.js"></script>
	<script src="js/exporting.src.js"></script>
	<script type="text/javascript">
	
		//iframe初始化和下拉框事件
		$(function(){
			//初始化页面
			$("iframe").attr("src","report/table");
			$("option:first").attr("selected","selected");
			var array = new Array("report/table","report/chart");
			$("select").change(function(){
				if($("select").val()==0){
					$("input[type='button']").css("display","block");
				}else{
					$("input[type='button']").css("display","none");
				}
				$("iframe").attr("src",array[$("select").val()]);
			});
		});
		//导出功能
		$(function(){
			$("input[type='button']").click(function(){
				/* 生成文件名字 */
				var date = new Date();
				var filename="煤炭销量中心-" + (date.getMonth()+1) + "-" + date.getDate() + "-" + date.getMilliseconds()+".xls";
				/* 注意选取iframe下元素的方式 */
				/* 页面先加载父窗口，再加载子窗口，所以在文档加载时改变table属性为diplay为none，或者在body里添加元素，是看不到现象的 */
				$("iframe").contents().find("table").table2excel({   
					/* 过滤标签   ： exclude: "标签选择器",*/ 
                    name: "Excel Document Name.xlsx",    
                    filename: filename,    
                   /* 过滤 
                    exclude_img: true,    
                    exclude_links: true,    
                    exclude_inputs: true   */  
                }); 
			});
		});
	</script>
  </head>
  
  	<body>
		<div style="width:100%;margin-top:20px">
			<div style="width: 4%;height:32.8px;float: left;">
				<img src="images/report.jpg" width="100%" height="100%">
			</div>
			<div style="width: 10%;float: left;">&nbsp;&nbsp;
			<select name="report" style="height: 25px;width:80px;text-align: center;background-color:lightblue; margin: 4px 2px;">
				<option name="report" value=0>图表</option>
				<option name="report" value=1>统计图</option>
			</select>
			</div>
			<div style="width: 80%;float: left;">
				<input type="button" value="导出" />
			</div>
			<div style="clear: both;"></div>
		</div>
		<iframe width="100%" height="612px" frameborder="0" style="margin-top:30px;"></iframe>
	</body>
</html>
