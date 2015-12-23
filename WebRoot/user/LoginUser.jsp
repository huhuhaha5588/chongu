<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  	<base href="<%= basePath %>" />
    <title>客户管理系统: 登录</title>
    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href='<c:url value="css/style.css"/>' rel="stylesheet" type="text/css" />
    <script type="text/javascript">
		function checkLoginUserNameForm(){
			var username=$("#username").val();
			if(username==""){
				$("#usernameErr").html("请输入用户名");
				return false;
			}
			$("#usernameErr").html("");
			return true;
		}
		
		function checkLoginPasswordForm(){
			var password=$("#password").val();
			if(password==""){
				$("#passwordErr").text("请输入密码");
				return false;
			}
			$("#passwordErr").text("");
			return true;
		}
		
		function checkLoginForm(){
			return checkLoginUserNameForm() && checkLoginPasswordForm();
		}
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
					<img  src="images/image-userlogin.jpg" />
				</center>
				
				<form name="LoginFrom" action='<c:url value="user/Login.action" />'
					onsubmit="return checkLoginForm();" method='POST'>
					<table>      
						<tr>

							<td>用户名:<input type='text' id="username" name='username' value='${param.username}' />
								<br /> <br />
							</td>
							
							<td><font id='usernameErr' color='red' size="-1">
								<i> <s:fielderror>
											<s:param>username</s:param>
										</s:fielderror>
										
								</i></font></td>
						</tr>

						<tr>
							<td>密&nbsp;码:<input type='password' id='password'
								name='password' value='' /> <br /> <br />
							</td>
							<td><font id='passwordErr' color='red' size="-1">
								 <i>
										<s:fielderror>
											<s:param>password</s:param>
										</s:fielderror>
								</i></font></td>
						</tr>
					</table>
					<span style="font-size:small"><font id='passwordErr' color='red' size="-1"><s:actionerror /></font></span>
					<p>
						<input type="submit" name="" value="确&nbsp;&nbsp;认"  /> 
						<input type="reset" name="" value="取&nbsp;&nbsp;消" /> 
							&nbsp;&nbsp;<a href="/TNA/Registration.jsp"><input type="button" name="" value="注册用户" /></a>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
