<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showNewsList.jsp' starting page</title>

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
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<style type="text/css">
body {
	margin-left:20px;
}
#verifyNewsInfo {
	width: 100%;
}

#verifyNewsInfo a {
	color: black;
	text-decoration: none;
}

#verifyNewsInfo #newsList #newsListHeader {
	height: 40px;
	padding-top: 15px;
	font-size: 15px;
	font-weight: bold;
}

#verifyNewsInfo #newsList #newsListHeader span {
	width: 25%;
	display: inline-block;
	text-align: center;
}

#verifyNewsInfo #newsList #newsListHeader #headerSpanA {
	width: 10%;
}

#verifyNewsInfo #newsList #newsListHeader #headerSpanB {
	width: 15%;
}

#verifyNewsInfo #newsList #newsListHeader #headerSpanC {
	width: 45%;
}

#verifyNewsInfo #newsList #newsListHeader #headerSpanD {
	width: 30%;
}

#verifyNewsInfo #newsList div p span {
	text-align: center;
	display: inline-block;
	width: 25%;
}
/* 	#verifyNewsInfo #newsList div:nth-child(2n) {background-color:#B0C4DE;}
	#verifyNewsInfo #newsList div:nth-child(2n-1) {background-color:#D3D3D3;} */
#verifyNewsInfo #newsList div p .span1, .span2 {
	width: 10%;
}

#verifyNewsInfo #newsList div p .span2 {
	width: 15%;
}

#verifyNewsInfo #newsList div p .span3 {
	width: 45%;
}

#verifyNewsInfo #newsList div p .span4 {
	width: 30%;
}

#changePage #center1 {
	margin: 15px 0;
}

#changePage #center1 .pageChangeButton {
	margin: 0 5px;
}

#changePage #center1 #pageskip {
	margin-left: 5px;
}

#changePage {
	width: 90%;
}

.newsListColor0 {
	background-color: #f5f5f5;
	border-top-style: solid;
	border-width: 1px;
	border-top-color: #DDDDDD;
	height: 50px;
	width: 100%;
	padding-top: 13px;
}

.newsListColor1 {
	background-color: #dff0d8;
	border-top-style: solid;
	border-width: 1px;
	border-top-color: #DDDDDD;
	height: 50px;
	width: 100%;
	padding-top: 13px;
}

.newsListColor2 {
	background-color: #faf2cc;
	border-top-style: solid;
	border-width: 1px;
	border-top-color: #DDDDDD;
	height: 50px;
	width: 100%;
	padding-top: 13px;
}

.inputpage{
    width:10%;
    height:5%;
    border-radius: 4px;
}
 .span1{
    font-size:17px;
 }
</style>

<script>
	window.onload = function() {
		getAllNews(1, 1);
	}
	function getAllNews(pagenum, maxpage) {
		if (pagenum <= 1) {
			pagenum = 1;
		} else if (pagenum >= maxpage) {
			pagenum = maxpage;
		}
		var rand;
		var j = 1
		var x;
		$.ajax({
			type : "post",
			url : "News/getAllNoCheckedNews",
			data : "pageNum=" + pagenum + "&maxPage=" + maxpage,
			success : function(msg) {
				newsList = JSON.stringify(msg[0]);
				newsPageInfo = JSON.stringify(msg[1]);
				$("#verifyNewsInfo").empty();
				$("#changePage").empty();
				$("#verifyNewsInfo").append("<div id='newsList'></div>");
				$("#newsList").append("<div id='newsListHeader'><span id='headerSpanA'>序号</span><span id='headerSpanC'>资讯标题</span><span id='headerSpanD'>资讯发布时间</span></div>");
				jQuery.each(JSON.parse(newsList), function(i, item) {
					if ((i + 1) % 2 == 1) {
						rand = 0;
					} else if (j == 1) {
						j = 2
						rand = 2;
					} else if (j == 2) {
						j = 1
						rand = 1;
					}
					$("#newsList").append("<div id = 'divnewsList" + i + "' class = 'newsListColor" + rand + "'><a href='News/getOpinion?nID=" + item.nID + "'><p><span class='span1'>" + (i + 1) + "</span><span class='span3'>" + item.nTheme + "</span><span class='span4'>" + item.nTime + "</span></p></a></div>")
					$("#divnewsList" + i + "").mouseover(function() {
						x = $("#divnewsList" + i + "").css("background-color");
						$("#divnewsList" + i + "").css("background-color", "#dad5d5");
					});
					$("#divnewsList" + i + "").mouseout(function() {
						$("#divnewsList" + i + "").css("background-color", x);
					});
				});
				$('#changePage').append("<center id='center1'></center>");
				$('#center1').append("<span class = 'span1'>当前第" + JSON.parse(newsPageInfo ).pageNum + "页/总共" + JSON.parse(newsPageInfo ).pages + "页 </span>;");
				$('#center1').append("<input class='btn btn-default btn-primary' type='button' onclick='getAllNews(" + (JSON.parse(newsPageInfo).pageNum - 1) + "," + JSON.parse(newsPageInfo).pages + ");' value = '上一页'>&nbsp;&nbsp;");
				$('#center1').append("<input class='btn btn-default btn-primary' type='button' onclick='getAllNews(" + (JSON.parse(newsPageInfo).pageNum + 1) + "," + JSON.parse(newsPageInfo).pages + ");' value = '下一页'>&nbsp;&nbsp;");

				$('#center1').append("<input class = 'inputpage' id = 'input1' value='" + JSON.parse(newsPageInfo).pageNum + "' type='text' style='width:35px;height:30px;'>&nbsp;&nbsp;");
				$('#input1').bind("input propertychange", function() {
					$("#input1").val($("#input1").val().replace(/[^\d]/g, ''));
				});
				$('#center1').append("<input class = 'btn btn-default btn-primary' type='button' id='pageskip' value='跳转' >");
				$('#pageskip').bind("click", function() {
					getAllNews($("#input1").val(), JSON.parse(newsPageInfo).pages);
				});
			}
		});
	}
</script>
</head>
<body>
	<div id="verifyNewsInfo"></div>
	<div id="changePage"></div>
</body>
</html>
