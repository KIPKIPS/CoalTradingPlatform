<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'verify_details_news.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/xcConfirm.css">
	<style type="text/css">
		#underApprovalDetailsInfo {
			width:50%;
			margin:10px auto;
		}
		
		#underApprovalDetailsInfo table,tr,td,th{
              border: 1px solid grey;
              border-collapse:collapse ;
        }
        #auditOpinionMsg {
        	width:50%;
        	margin:10px auto;
        }
        #auditOpinionMsg textarea {
        	boder-color:black;
        	border-radius:5px;
        	width:450px;
        	height:100px;
        	padding:10px;
        	resize:none;

        }
        #auditOpinionMsg p {
        	font-size:10px;
        	margin:10px 0 0 5px;
        }
        #auditOpinion {
        	width:50%;
        	margin:5px auto;
        }
        
        #auditOpinion #agree {
        	height:35px;
        	width:120px;
        	margin:5px 40px 10px 0;
        }
        #auditOpinion #disagree {
        	height:35px;
        	width:120px;
        	margin:5px 20px 10px 40px;
        }
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/xcConfirm.js"></script>
	<script>
		window.onload=function() {
			$("#underApprovalDetailsInfo").empty();
			$("#underApprovalDetailsInfo").append("<h3>资讯详细内容：</h3>");
			$("#underApprovalDetailsInfo").append("<table></table>");
			$("#underApprovalDetailsInfo table").append("<tr><th>资讯编号</th><td>${news.nID}</td></tr>");
			$("#underApprovalDetailsInfo table").append("<tr><th>资讯编辑员编号</th><td>${news.nEditorID}</td></tr>");
			$("#underApprovalDetailsInfo table").append("<tr><th>资讯标题</th><td>${news.nTheme}</td></tr>");
			$("#underApprovalDetailsInfo table").append("<tr><th>资讯内容</th><td>${news.nContent}</td></tr>");
			$("#underApprovalDetailsInfo table").append("<tr><th>资讯发布时间</th><td>${news.nTime}</td></tr>");
			
			var comment=document.getElementById('comment');
            comment.addEventListener('input', function() {
                var txtLength=comment.value.length;
                document.getElementById('textCount').innerHTML=txtLength;
                if (txtLength==200) {
                    window.wxc.xcConfirm("最大字数限制为200，不能再输入了！", window.wxc.xcConfirm.typeEnum.warning);
                }
            });
		}
		
		function agreeVerify() {
			document.getElementById('opinionForm').action="News/permitNews";
			var comment=document.getElementById('comment').value;
			if(!comment) {
				window.wxc.xcConfirm("未填写审核意见,是否提交？", window.wxc.xcConfirm.typeEnum.confirm);
			} else {
				//审核通过，插入（有则更改，无则插入）到审核意见表，资讯状态变为1审核通过
				window.wxc.xcConfirm("审核通过，确认提交?", window.wxc.xcConfirm.typeEnum.confirm);
			}
			
		}
		
		function disagreeVerify() {
			document.getElementById('opinionForm').action="News/notPermitNews";
			var comment=document.getElementById('comment').value;
			if(comment) {
				//审核不通过，插入（有则更改，无则插入）到审核意见表，资讯状态变为2待修改
				window.wxc.xcConfirm("审核不通过意见已填写，确认提交？", window.wxc.xcConfirm.typeEnum.confirm);
				
			} else {
				window.wxc.xcConfirm("未填写不通过原因，不能提交！", window.wxc.xcConfirm.typeEnum.info);
			}
		}
		
	</script>
  </head>
  		
  <body>

	<div id='underApprovalDetailsInfo'></div>
    <div id='auditOpinionMsg'>
    	<h3>审核意见填写（不通过必须填写原因）：</h3>
    	<form id="opinionForm" action="" method="post">
    	    <input type="hidden"  name= "nID" value="${news.nID}" >
    		<textarea id="comment" name="uOpinion" maxlength="200"></textarea>
    	</form>
    	<p><span id="textCount">0</span>/200 (审核意见请限制在200字以内！)</p>
    </div>
    <div id='auditOpinion'>
    	<button id="agree" type="submit" onclick="agreeVerify();">同意发布</button>
    	<button id="disagree" type="submit" onclick="disagreeVerify();">审核不通过</button>
    </div>
  </body>
</html>
