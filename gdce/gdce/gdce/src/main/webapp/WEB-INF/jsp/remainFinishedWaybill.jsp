<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showAllUsers.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
@import url("css/bootstrap.min.css");

<
style type ="text/css">a {
	text-decoration: none
}

table {
	width: 100%
}

table, tr, th {
	border: 1px solid gray;
	border-collapse: collapse;
}

div {
	border: 0px solid red;
}
</style>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">

	/*     表格隔行变色 */
	function SetTableColor() {
		var tbl = document.getElementById("tablePage");
		var trs = tbl.getElementsByTagName("tr");
		var color = 0;
		for (var i = 0; i < trs.length; i++) {
			var j = i + 1;
			if (j % 2 == 0) {
				trs[i].style.background = "#ffffff";
			} else if (color == 1) {
				trs[i].style.background = "#fcf8e3";
				color = 0;
			} else if (color == 0) {
				trs[i].style.background = "#dff0d8";
				color = 1;
			}
		}
	}
</script>


</head>


<body onload="getInfo2()">
	<!-- table代码 -->
	<table class="table table-hover table-bordered"
		style="max-height: 300px;width: 900px; margin:0 auto;">

		<thead>
			<tr>
				<th colspan=14>已完成</th>
			</tr>
			<tr>
				<th>订单号</th>
				<th>运单编号</th>
				<th>配送人</th>
				<th>配送人联系方式</th>
				<th>起始位置</th>
				<th>终止位置</th>
				<th>总运费</th>
				<th>货源地</th>
				<th>收货地</th>
				<th>发货时间</th>
				<th>到货时间</th>
			</tr>
		</thead>
		<tbody id="tablePage">
		</tbody>
	</table>

	<!-- 底边分页栏代码 -->
	<div style="width:300px; margin:0 auto;">
		<ul class="pagination" id="pageList" style="line-height: 100px">

			<li id="spanPre" class="disabled"><a href="javascript:pre();">&laquo;</a></li>
			<li style="display: none" id="spanpage1" class="active"><a
				href="javascript:nPage(1)" id="qwe">1</a></li>
			<li id="spanNext"><a href="javascript:next()">&raquo;</a></li>
		</ul>
		<div style="width:500px;margin-top: -55px;margin-left: 80px">
			<span class='span1' style="margin-right: 10px">当前第<span
				id="pageNo"></span>页/总共<span id="pageSum"></span>页
			</span> 跳转到<input onkeyup="value=value.replace(/[^\d\.]/g,'')" id="nextPage"
				style="width: 30px"><input
				onclick="toPagen(document.getElementById('nextPage').value)"
				style="margin-left: 10px" class='btn btn-default btn-primary'
				type='button' id='pageskip' value='跳转'>
		</div>

	</div>



	<script>


    var theTable = document.getElementById("tablePage");
    var spanPre = document.getElementById("spanPre");
    var spanNext = document.getElementById("spanNext");
    var pageList = document.getElementById("pageList");
    var spanPageN = pageList.getElementsByTagName("li");


    var numberRowsInTable;

    var pageSize = 15;
    var page = 1;
    var pageNo = 1;
    var pageSum = 0;

 	function toPagen(n){
 		if(n>pageSum)
 			{
 				alert("超出范围！");
 				document.getElementById("nextPage").value = "";
 				return false;
 			}
 		else nPage(n);
 	}
 
 	function getInfo2(){
		var tradeIDList = new Array;
		tradeIDList = ${tradeIDList};
		console.log(tradeIDList);
		$.ajax({
		type:"post",
   		url:"http://10.61.88.30:8082/logistics_system/waybill/getState2InfoByList",
   		dataType: "json", 
   		contentType:"application/json",
   		data:JSON.stringify(tradeIDList),
   		success:function(data){
   		console.log(data);
		if(data!=null)
   			{
   				var list = new Array;
   				list = data;
   				for(var i = 0;i<list.length;i++)
   				$("#tablePage").append("<tr><th>"+data[i].trade_id+"</th><th>"+data[i].waybill_id+"</th><th>"+data[i].distributor+"</th><th>"+data[i].dis_phone+"</th><th>"+data[i].start_pos+"</th><th>"+data[i].end_pos+"</th><th>"+data[i].sum_carriage+"</th><th>"+data[i].good_source+"</th><th>"+data[i].good_destination+"</th><th>"+data[i].good_trs_time+"</th><th>"+data[i].good_rec_time+"</th></tr>");
   			 numberRowsInTable = theTable.rows.length;
   			 document.getElementById("qwe").click();
   			 pageSum=Math.ceil(list.length/pageSize);
   			 document.getElementById("pageSum").innerHTML=pageSum;
   			 document.getElementById("pageNo").innerHTML=pageNo;
   			}
   			SetTableColor();
   		}
		})
	}


    //清除列表的active样式
    function clearActive(){
        for(var i=1;i<spanPageN.length-1;i++){
            console.log(spanPageN[i].id);
            spanPageN[i].setAttribute("class","");
        }
    }
    //下一页
    function next(){


        hideTable();

        //当前最后一行行数
        currentRow = pageSize * page;
        maxRow = currentRow + pageSize;
        // 判断是否到了table最后几行数据
        if ( maxRow > numberRowsInTable ) {
            maxRow = numberRowsInTable;

        }
        for ( var i = currentRow; i< maxRow; i++ ){
            theTable.rows[i].style.display = '';
        }

        page++;
        pageNo++;
        if ( maxRow == numberRowsInTable ){
            console.log(maxRow+"=======");
            nextOff();

        }
        preOn();
        document.getElementById("pageNo").innerHTML=pageNo;
        showPageActive(page);

    }

    //上一页
    function pre(){

        hideTable();
        page--;
		pageNo--;
        currentRow = pageSize * page;
        maxRow = currentRow - pageSize;
        if ( currentRow > numberRowsInTable ) currentRow = numberRowsInTable;
        for ( var i = maxRow; i< currentRow; i++ ){
            //清除display样式，display将使用默认
            theTable.rows[i].style.display = '';
        }

        if ( maxRow == 0 ){
            preOff();

        }
        document.getElementById("pageNo").innerHTML=pageNo;
        showPageActive(page);
        nextOn();

    }

    //第几页
    function nPage(n){
        hideTable();

        currentRow = pageSize * (n-1);
        maxRow = currentRow + pageSize;
        if ( currentRow > numberRowsInTable ) currentRow = numberRowsInTable;
        for ( var i = currentRow; i<maxRow; i++ ){
            theTable.rows[i].style.display = '';
        }


        if(n==1){
            preOff();
        }else if(n*pageSize==numberRowsInTable) {
            nextOff();
        }else{
            nextOn();
            preOn();
        }
        showPageActive(n);

    }

    function hideTable(){
        for ( var i = 0; i<numberRowsInTable; i++ ){
            theTable.rows[i].style.display = 'none';
        }
    }

    //将当前页设为active
    function showPageActive(p){
        //清除之前的
        clearActive();
        var nowpage =  document.getElementById('spanpage'+p);

    }

    //总共页数
    function pageCount(){
        var count = 0;
        //判断是否整除
        if ( numberRowsInTable%pageSize != 0 ) count = 1;
        return parseInt(numberRowsInTable/pageSize) + count;
    }


    //上一页下一页链接的禁用和打开
    function preOn(){
        spanPre.innerHTML=" <a href='javascript:pre();'>&laquo;</a>";
        spanPre.setAttribute("class", "");
    }
    function preOff(){
        //bootstrap设置禁用样式之后还是可以点击一次，所以这里直接修改innerHTML解决这个问题。
        spanPre.innerHTML=" <a href='javascript:void(0);'>&laquo;</a>";
        spanPre.className = "disabled";
    }
    function nextOn(){
        spanNext.innerHTML="<a href='javascript:next()'>&raquo;</a>";
        spanNext.setAttribute("class", "");
    }
    function nextOff(){
        spanNext.innerHTML="<a href='javascript:void(0)'>&raquo;</a>";
        spanNext.setAttribute("class", "disabled");
    }


    //隐藏表格 ,只显示第一页的内容
    function hide(){
        for ( var i = pageSize; i<numberRowsInTable; i++ ){
            theTable.rows[i].style.display = 'none';
        }
        preOff();
        nextOn();
    }

    hide();
</script>
</html>
