<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>煤炭销售统计图</title>
    
    <meta charset="utf-8">
	<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/exporting.js"></script>
	<script type="text/javascript" src="js/sunset.js"></script>
	<script type="text/javascript" src="js/highcharts-3d.js"></script>
	<script type="text/javascript" src="js/offline-exporting.js" ></script>
	<style type="text/css">
		.form-control {
			  display: block;
			  width: 100%;
			  height: 34px;
			  padding: 6px 12px;
			  font-size: 14px;
			  line-height: 1.428571429;
			  color: #555555;
			  vertical-align: middle;
			  background-color: #ffffff;
			  background-image: none;
			  border: 1px solid #cccccc;
			  border-radius: 4px;
			  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
			          box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
			  -webkit-transition: border-color ease-in-out 0.15s, box-shadow ease-in-out 0.15s;
			          transition: border-color ease-in-out 0.15s, box-shadow ease-in-out 0.15s;
		}
	</style>
	<script type="text/javascript">
		/* 定义图表类型全局变量 */
	    var currentType="column";
	    var currentTitle = "煤炭交易总量柱状图";
	    /* 处理后台数据：1.截取时间2.将销量转换为数字类型 */
		var minOrderDate = "${minDate}";
		var maxOrderDate = "${maxDate}";
		var coalType1 = Number("${coalType1}");
		var coalType2 = Number("${coalType2}");
		var coalType3 = Number("${coalType3}");
		var coalType4 = Number("${coalType4}");
		var coalType5 = Number("${coalType5}");
		
	  /* 	 菜单汉化 */
	    Highcharts.setOptions({
			lang:{
				downloadJPEG:"下载JPEG图片",
				downloadPDF:"下载PDF文件",
				downloadPNG:"下载PNG文件",
				downloadSVG:"下载SVG文件",
				printChart:"打印图表",
			}
		});
		
		//绘制3d饼图
		function draw_3d_pie(){
			Highcharts.chart('pie_3d_chart', {
					chart: {
							type: 'pie',
							options3d: {
									enabled: true,
									alpha: 45
							}
					},
					title: {
							text: '国电煤炭交易环形图'
					},
					plotOptions: {
							pie: {
									innerSize: 60,
									depth: 45
							}
					},
					credits : {
		       		   enabled: false//不显示LOGO
		    		},
		    		navigation:{
		    			buttonOptions:{
		    				enabled:false
		    			}
		    		},
					series: [{
							name: '销售量',
							data: [
									['烟煤', coalType1],
									['无烟煤', coalType2],
									['褐煤', coalType3],
									['贫瘦煤', coalType4],
									['其它', coalType5],
							]
					}]
			});
		}
		//绘制3d柱状图
		function draw_3d_column(){
			new Highcharts.Chart({
					chart: {
							renderTo: 'column_3d_chart',
							type: 'column',
							options3d: {
									enabled: true,
									alpha: 15,
									beta: 15,
									depth: 50,
									viewDistance: 25
							},
							backgroundColor:'honeydew'
					},
					title: {
							text: '国电煤炭交易3d柱状图'
					},
					plotOptions: {
							column: {
									depth: 25
							},
							series: {
			                  		showInLegend: false
			              	}
					},
					navigation:{
		    			buttonOptions:{
		    				enabled:false
		    			}
		    		},
					credits : {
		       		   enabled: false//不显示LOGO
		    		},
					series: [{
							name:'销售量',
							data: [coalType1, coalType2, coalType3, coalType4,coalType5]
					}]
			});
		}
		
		 /* 绘制chart方法 */
		function drawChart() {
			/* 本地导出设置 */
			Highcharts.chart("container", {
				exporting: {
					chartOptions: {
						plotOptions: {
							series: {
								dataLabels: {
									enabled: true
								}
							}
						}
					},
				},
			   /* chart类型 */
			    chart : {
			      type: currentType,
			      backgroundColor:'oldlace'
			   },
			   /* 标题 */
			   title : {
			      text: currentTitle 
			   },
			   /* 副标题 */
			   subtitle : {
			      text: '统计时间:' + minOrderDate + '-' + maxOrderDate
			   },
			   /* x轴 */
			    xAxis : {
			      categories: ['烟煤','无烟煤','褐煤','贫瘦煤','其他'],
			      crosshair: true
			   },
			   /* y轴 */
			    yAxis : {
			      min: 0,
			      title: {
			         text: '销售量(万吨)'         
			      }      
			   },
			 /*   设置相同横坐标柱子间距 */
			    plotOptions : {
			      column: {
			         pointPadding: 0.2,
			         borderWidth: 0,
			       	 dataLabels: {
	 		            enabled: true //设置显示对应y的值
	 		        }
			      },
			      //设置下方隐藏
			      series: {
	                  showInLegend: false
	              }
			   },
			   credits : {
	       		   enabled: false//不显示LOGO
	    		},
			   
			 	/*   放置呈现在图中的数据 */
			   series: [{
			        name: '煤种销售总量',
			            data: [coalType1, coalType2, coalType3, coalType4,coalType5]
			        }],
			   	/* 导出文件像素设置、按钮样式设置 */
			   exporting: {
			   		/* url: 'http://127.0.0.1:8004', */
			   		sourceWidth: 400,
					sourceHeight: 200,
					buttons: {
						contextButton: {
							text: '导出',
							symbol: 'circle',
							symbolStrokeWidth: 1,
							symbolFill: '#bada55',
							symbolStroke: '#330033',
							symbolSize: 15,
							/* menuItems: null,
							onclick: function () {
								this.exportChart();
							} */
						}
					}
				},
				/* 菜单列表背景色 */
				navigation: {
					menuStyle: {
						background: 'cornsilk'
					}
				}
			});
		}
		$(function(){
			/* 统计图种类数组 */
			titleArr = new Array("煤炭交易总量柱状图","煤炭交易总量饼状图","煤炭交易总量曲线图");
			typeArr = new Array("column","pie","spline");
			/* 下拉框change事件 */
			$("select").change(function(){
				$("h3 small").text(typeArr[$("select")[0].value] + " Chart");
				currentType = typeArr[$("select")[0].value];
				currentTitle = titleArr[$("select")[0].value];
				drawChart();
			});
		});
	</script>
  </head>
  
  <body>
  	<br /><h3>十年交易总量统计图 </h3>
  	<div style="height:80%">
	  	<div style="width:40%;text-align:center;float:left;height:100%;background-color:whitesmoke">
		  	<div style="width:48%;height:48%;margin:1%;float:left;text-align:center;background-color: ghostwhite">
		  		<div style="width:30%;height:30%;background-color: lightgoldenrodyellow">
		  			<img src="images/reportLogo.jpg" width="100%" height="100%">
		  		</div><br/>
		  		<p style="font-size:17"><br/>&nbsp;&nbsp;国电煤炭总销额：</p>
		  		<p style="font-size:15"><b>￥3500万元</b></p>
		  	</div>
		  	<div style="width:48%;height:48%;margin:1%;float:left" id="pie_3d_chart"></div>
		  	<div style="width:98%;height:48%;margin:1%;float:left" id="column_3d_chart"></div>
		  	<div style="clear: both"></div>
	  	</div>
	  	<!-- 放置下拉框 -->
	  	<div style="width:100%;height:10%">
	  			<div style="float:left;width:3%;height:34px;"></div>
		  		<font style="display:block;float:left;text-algin:center;padding-top:3px;font-size:19;font-weight: 3" >图表类型</font>
		  		<div style="float:left;width:1%;height:34px;"></div>
			  	<select name="chartType"  class="form-control" style="float: left;width:12%">
			  		<option name="chartType" value=0>柱状图</option>
			  		<option name="chartType" value=1>饼状图</option>
			  		<option name="chartType" value=2>曲线图</option>
			  	</select>
		</div>
	 	<!-- 用于放置柱状图 -->
		<div id="container" style="width: 57%; height: 89%; margin: 0 auto;float:left;margin-left:3%"></div>
		<div style="clear: both"></div>
	</div>
	<script>
		$(function(){
			drawChart();
			draw_3d_pie();
			draw_3d_column();
		});
		
		
	</script>
</body>
</html>
