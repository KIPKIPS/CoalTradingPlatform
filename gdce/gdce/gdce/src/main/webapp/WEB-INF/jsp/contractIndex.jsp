<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'contractIndex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style>
	 #div1{
            /*margin-left: 60px;*/
            width:auto;
            height:80px;
            text-align: center;

        }
        #div1 ul{
            padding:0px;        
            margin-top: 30px;
            float:left;
            white-space:nowrap;
        }
        #div1 li{
            list-style: none;
            padding: 0px;
            float: left;
            margin-left: 150px;
            font-family:"宋体";
            font-weight:bold ;
            font-size: 17px;
            display: inline;
            
        }
        #div1 li a{
            font-size:25px;
            text-decoration: none;
        }
        u{
        height:3px;
        width:90%;
        color: #dfc5f9;
        }
        
	</style>

<script type="text/javascript">
function skip(i){
	
	if(i==1) window.parent.content3.location.href="/contract/contractShowBothSignedPage";
	else if(i==2) window.parent.content3.location.href="/contract/contractShowUnsignedPage";
	else if(i==3) window.parent.content3.location.href="/contract/contractShowSignedPage";
	else if(i==4) window.parent.content3.location.href="/contract/contractShowUnupdatePage";
/* 	switch(i)
	{
	case 1:window.parent.content3.location.href="/gdce/contract/contractShowBothSignedPage";break;
	case 2:window.parent.content3.location.href="/gdce/contract/contractShowUnsignedPage";break;
	case 3:window.parent.content3.location.href="/gdce/contract/contractShowSignedPage";break;
	} */
}
</script>	
  </head>
  
  <body>
  
  		<font size="4">合同管理</font>
<div style="background-color: gray;margin-top: 5px; width: 100%;height: 2px"></div>
<br/>
  			<div id="changeLogisticsStatus">
				<select onchange=skip(this.options[this.options.selectedIndex].value) name="logisticsStatus" 
				id="logisticsStatus" class="form-control" style="width: 250px;font-size: 17px;text-align: center;height:35px;
				border-radius:5px; ">
					<option name="logisticsStatus" value=1>双方都已确认的合同</option>
					<option name="logisticsStatus" value=2>己方未确认的合同</option>
					<option name="logisticsStatus" value=3>对方未确认的合同</option>
					<option name="logisticsStatus" value=4>未上传的合同</option>
				</select>
				
			</div>
  			
          <!--   <div id="div1">
        <ul id="ul1">
            <li><a href="/gdce/contract/contractShowBothSignedPage" target="content3">已完成双方确认的合同</a></li>
            <li><a href="/gdce/contract/contractShowUnsignedPage" target="content3">未确认合同</a></li>
            <li><a href="/gdce/contract/contractShowSignedPage" target="content3">等待对方确认的合同</a></li>
        </ul>
    </div> -->
  </body>
</html>
