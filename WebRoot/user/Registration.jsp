<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href='<c:url value="css/style.css"/>' rel="stylesheet" type="text/css" />
<script>
	$(function(){
		  alert("250250");	  
		  $.validator.setDefaults({
		  	submitHandler:function(){alert("submitted!");}
		  }); 
	$("#commentForm").validate({
		  rules:{
					username:{required: true},
					password:{required: true},
					idnum:{url:true,minlength: 18},
					tel:{required: true,minlength: 11}
                    },
                    messages: {
                        username: {
                            required:"请输入账户名",
                        },
                        password:{
                            required:"请输入密码",
                        },
                        idnum :"请输入身份证号码",
             	          tel:"请输入电话号码"
                    }
});
});
</script>
</head>
<body bgcolor="#0591C2">
	<div id="login">
		<div class="main_body">
			<div class="left">
				<img src="images/image-login-left.jpg" />
			</div>
			<div class="right">
				<center>
					<img src="images/image-adminlogin.jpg" />
				</center>
		<form action="user/Registration.action" method="post" class="submit" id="commentForm">
		<table  width="50%" cellspacing="6">
	
	
			<tr>
				<!-- <label for="cname">用户名</label> -->
				<td align="right">账户名：</td>
				<td><input id="cname" type="text" name="username" maxlength="20" class="required" value="${param.username}" /></td>
			</tr>
			<s:fielderror>
				<s:param>username</s:param>
			</s:fielderror>

			<tr>
				<td align="right">密 码：</td>
				<td><input type="text" name="password" maxlength="20" value=" " /></td>
			</tr>
			<tr>
				<s:fielderror>
					<s:param>password</s:param>
				</s:fielderror>
			</tr>
			<tr>
				<td align="right">重新输入密 码：</td>
				<td><input type="text" name="repassword" maxlength="20" value=" " /></td>
			</tr>
			<tr>
				<td align="right">真实姓名：</td>
				<td><input type="text" name="name" maxlength="20" value="${param.name} " /></td>
			</tr>
			<s:fielderror>
				<s:param>name</s:param>
			</s:fielderror>
			<tr>
				<td align="right">身份证号：</td>
				<td><input type="text" name="idnum" maxlength="20" value="${param.idnum }" /></td>
			</tr>
			<s:fielderror>
				<s:param>idnum</s:param>
			</s:fielderror>
			<tr>
				<td align="right">联系电话：</td>
				<td><input type="text" name="tel" maxlength="20" value="${param.tel}" /></td>
			</tr>
			<s:fielderror>
				<s:param>tel</s:param>
			</s:fielderror>
			<tr>
				<td align="right"></td>
				<td><input type="submit" name="" value="确认" /> <input
					type="reset" name="" value="重置"  class="submit"/></td>
			</tr>
		</table>
	</form>
			</div>
		</div>
	</div>
</body>

</html>

