<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <script> 
	var total=2;
	function showTime() {
		total--;
		var sec = total % 60;
		var mins = parseInt(total / 60);
		if (mins > 0){
			document.getElementById("time").innerHTML = mins + "分" + sec + "秒";
		}else{
			document.getElementById("time").innerHTML = sec + "秒";
		}
		if (total > 0) {
			setTimeout("showTime()", 1000);//每一秒钟执行一次检查
			inputCheck();
		} else {
			document.form.submit();
		}
	}
	
	function startTimer(){
		alert("成功下载");
		showTime();
	}
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成功下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="startTimer()">
    <center>下载成功！  </center>
    <br />
			<form name="form" action="admin/itemlist.jsp" method="get">
			<center><div id="time"></div></center> 
			</form>
    <center><a href="admin/itemlist.jsp">如果未跳转点击此处 </a></center>
  </body>
</html>
