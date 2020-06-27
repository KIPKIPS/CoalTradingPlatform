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

<title>My JSP 'success.jsp' starting page</title>

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
body {
	margin-left:20px;
}
.navBar {
	width: 250px;
	list-style: none;
	margin: 0;
	padding: 0;
	background: #4c6ca0;
	border-radius: 5px 5px 0 0;
	overflow: auto;
}

.navBar li {
	float: left;
}

.navBar li a {
	display: block;
	color: #fff;
	text-decoration: none;
	padding: 15px 20px;
}

.navBar li a:hover {
	background: #446190;
	color: red;
}

#divinfo {
	border-radius: 0 5px 5px 5px;
	width: 90%;
}

#divinfo a {
	color: black;
	text-decoration: none;
}

#divinfo div {
	margin: 0;
	padding: 0;
	border: solid 1px #4c6ca0;
	width: 100%;
}

#divinfo #productsList1 #productsListHeader {
	height: 40px;
	padding-top: 1%;
}

#divinfo #productsList1 #productsListHeader span {
	width: 20%;
	display: inline-block;
	text-align: center;
}

#divinfo #productsList1 div p span {
	text-align: center;
	display: inline-block;
	width: 20%;
}

}
#divinfo #productsList2 #productsListHeader {
	height: 40px;
	padding-top: 1%;
}

#divinfo #productsList2 #productsListHeader span {
	width: 16.6%;
	display: inline-block;
	text-align: center;
	height: 40px;
	padding-top: 1%;
}

#divinfo #productsList2 div p span {
	text-align: center;
	display: inline-block;
	width: 16.6%;
	padding-top: 16px;
	height:40px;
}

#divpage #center1 {
	margin: 15px 0;
}

#divpage #center1 .pageChangeButton {
	margin: 0 5px
}

#divpage #center1 #pageskip {
	margin-left: 5px;
}

#divpage {
	width: 90%;
}
.inputpage{
    width:4%;
    height:34px;
    border-radius: 4px;
}
 .span1{
    font-size:17px;
 }
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	window.onload = function() {
		getAllPurchList(1, 1);
	}
	function getAllPurchList(pagenum, maxpage) {
	    $("#li1").css("background-color","#6495ED");
	    $("#li2").css("background-color","#A9A9A9");
		if (pagenum <= 1) {
			pagenum = 1;
		} else if (pagenum >= maxpage) {
			pagenum = maxpage;
		}
		$.ajax({
			type : "post",
			url : "getAllListingList/getAllPurchListingList",
			data : "pageNum=" + pagenum + "&maxPage=" + maxpage,
			success : function(msg) {
				purList = JSON.stringify(msg[0]);
				purPageInfo = JSON.stringify(msg[1]);
				$("#divinfo").empty();
				$("#divpage").empty();
				$("#divinfo").append("<div id='productsList1'></div>");
				$("#productsList1").append("<div id='productsListHeader'><span >挂牌编号</span><span>单据编号</span><span >申请日期</span><span >交货时间</span><span >煤炭分类</span></div>");
				jQuery.each(JSON.parse(purList), function(i, item) {
					$("#productsList1").append("<div id = 'div1" + i + "'><a href='getAllListingList/getPurchGoodsById?pNumber=" + item.pNumber + "'><p><span>" + item.pNumber + "</span><span>" + item.pListID + "</span><span>" + item.pApplyDate + "</span><span>" + item.pDeliverEarliest + "--" + item.pDeliverLatest + "</span><span>" + item.pCoalType + "</span></p></a></div>")
					$("#div1" + i + "").mouseover(function() {
						$("#div1" + i + "").css("background-color", "#A9A9A9");
					});
					$("#div1" + i + "").mouseout(function() {
						$("#div1" + i + "").css("background-color", "white");
					});
				});
				$('#divpage').append("<center id='center1'</center>")
				$('#center1').append("<span class = 'span1'>当前第" + JSON.parse(purPageInfo).pageNum + "页/总共" + JSON.parse(purPageInfo).pages + "页 </span>");
				$('#center1').append("<input class='btn btn-default btn-primary' type='button' onclick='getAllPurchList(" + (JSON.parse(purPageInfo).pageNum - 1) + "," + JSON.parse(purPageInfo).pages + ");' value = '上一页'>&nbsp;&nbsp;");
				$('#center1').append("<input class='btn btn-default btn-primary' type='button' onclick='getAllPurchList(" + (JSON.parse(purPageInfo).pageNum + 1) + "," + JSON.parse(purPageInfo).pages + ");' value = '下一页'>&nbsp;&nbsp;");

				$('#center1').append("<input class = 'inputpage' id = 'input1' value='" + JSON.parse(purPageInfo).pageNum + "' type='text'>&nbsp;&nbsp;");
				$('#input1').bind("input propertychange", function() {
					$("#input1").val($("#input1").val().replace(/[^\d]/g, ''));
				});
				$('#center1').append("<input  class = 'btn btn-default btn-primary' type='button' id='pageskip' value='跳转' >");
				$('#pageskip').bind("click", function() {
					getAllPurchList($("#input1").val(), JSON.parse(purPageInfo).pages);
				});
			}
		});
	}

	function getAllSellerList(pagenum, maxpage) {
	    $("#li2").css("background-color","#6495ED");
	    $("#li1").css("background-color","#A9A9A9");
		if (pagenum <= 1) {
			pagenum = 1;
		} else if (pagenum >= maxpage) {
			pagenum = maxpage;
		}
		$.ajax({
			type : "post",
			url : "getAllListingList/getAllSellerListingList",
			data : "pageNum=" + pagenum + "&maxPage=" + maxpage,
			success : function(msg) {
				sellerList = JSON.stringify(msg[0]);
				sellerPageInfo = JSON.stringify(msg[1]);
				$("#divinfo").empty();
				$("#divpage").empty();
				$("#divinfo").append("<div id='productsList2'></div>");
				$("#productsList2").append("<div id='productsListHeader'><span id='span21'>挂牌编号</span><span id='span26'>煤种</span><span id='span22'>供应数量（万吨）</span><span id='span23'>	原煤单价(元/吨)</span><span id='span24'>运费单价(元/吨)</span><span id='span25'>发货地</span></div>");
				jQuery.each(JSON.parse(sellerList), function(i, item) {
					$("#productsList2").append("<div id = 'div2" + i + "'><a href='getAllListingList/getSellerGoodsById?sNumber=" + item.sNumber + "'><p><span>" + item.sNumber + "</span><span>" + item.coalTtype + "</span><span>" + item.sCount + "</span><span>" + item.sCPrice + "</span><span>" + item.sFreight + "</span><span>" + item.sPlace + "</span></p></a></div>")
					$("#div2" + i + "").mouseover(function() {
						$("#div2" + i + "").css("background-color", "#A9A9A9");
					});
					$("#div2" + i + "").mouseout(function() {
						$("#div2" + i + "").css("background-color", "white");
					});
				});
				$('#divpage').append("<center id='center1'></center>")
				$('#center1').append("<span class = 'span1'>当前第" + JSON.parse(sellerPageInfo).pageNum + "页/总共" + JSON.parse(sellerPageInfo).pages + "页 </span>");
				$('#center1').append("<input class='btn btn-default btn-primary' type='button' onclick='getAllSellerList(" + (JSON.parse(sellerPageInfo).pageNum - 1) + "," + JSON.parse(sellerPageInfo).pages + ");' value = '上一页'>&nbsp;&nbsp;");
				$('#center1').append("<input class='btn btn-default btn-primary' type='button' onclick='getAllSellerList(" + (JSON.parse(sellerPageInfo).pageNum + 1) + "," + JSON.parse(sellerPageInfo).pages + ");' value = '下一页'>&nbsp;&nbsp;");

				$('#center1').append("<input class = 'inputpage' id = 'input1' value='" + pagenum + "' type='text'>&nbsp;&nbsp;");
				$('#input1').bind("input propertychange", function() {
					$("#input1").val($("#input1").val().replace(/[^\d]/g, ''));
				});
				$('#center1').append("<input class = 'btn btn-default btn-primary' type='button' id='pageskip' value='跳转' >");
				$('#pageskip').bind("click", function() {
					getAllSellerList($("#input1").val(), JSON.parse(sellerPageInfo).pageNum);
				});
			}
		});
	}
</script>

</head>

<body>
	<ul class="navBar">
		<li id="li1"><a href="javascript:void(0);"
			onclick="getAllPurchList(1,1)">买方挂牌信息</a></li>
		<li id="li2"><a href="javascript:void(0);"
			onclick="getAllSellerList(1,1)">卖方挂牌信息</a></li>
	</ul>
	<div id="divinfo"></div>
	<div id="divpage"></div>
</body>
</html>
