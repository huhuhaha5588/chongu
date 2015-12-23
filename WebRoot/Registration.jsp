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
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href='<c:url value="css/style.css"/>' rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	function checkUserNameForm() {
		var username = $("#username").val();
		if (username == "") {
			$("#usernameErr").html("请输入用户名");
			return false;
		}
		$("#usernameErr").html("");
		return true;
	}
	
	
	function checkPasswordForm() {	
	var password = $("#password").val();
		if (password == "") {
			$("#passwordErr").text("请填写密码");
			return false;
		}
		$("#passwordErr").text("");
		return true;
	}
	
	function checkRePasswordForm() {
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		if (repassword != password) {
			$("#repasswordErr").text("两次密码输入不一致");
			return false;
		}
		$("#repasswordErr").text("");
		return true;
	}
	
	function checkNameForm() {
		var name = $("#name").val();
		if (name == "") {
			$("#nameErr").text("请填写真实姓名");
			return false;
		}
		$("#nameErr").text("");
		return true;
	}
	
	function checkIdnumForm() {
		var idnum = $("#idnum").val();
		if (idnum == "") {
			$("#idnumErr").text("请填写身份证号");
			return false;
		}else{
			if(!checkIdnum()){
				$("#idnumErr").text("身份证号格式错误");
				return false;
			}
		}
		$("#idnumErr").text("");
		return true;
	}
	
	function checkIdnum(){
		var idnum = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
		var value=document.getElementById("idnum").value.trim();
		if(idnum.test(value)){
		return true;
	}
	return false;
}
	
	function checkTelForm() {
		var tel = $("#tel").val();
		if (tel == "") {
			$("#telErr").text("请填写电话号码");
			return false;
		}else{
			if(!checkTel()){
				$("#telErr").text("电话号码格式错误");
			return false;
			}
		}
		$("#telErr").text("");
		return true;
	}
	
	function checkTel(){
	var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
	var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
	var value=document.getElementById("tel").value.trim();
	if(isMob.test(value)||isPhone.test(value)){
		return true;
	}
	return false;
}

	function checkForm() {
		return (checkUserNameForm() && checkPasswordForm() && checkRePasswordForm() && checkNameForm()
				&& checkIdnumForm() && checkTelForm());
	}
</script>
</head>
<body>
	<div id="main_page">
		<div id="header">
			<img src="images/image-logo.png" />
		</div>
		<div id="body">

			<div id="content">
				<div class="title">
					<p>
						<img src="images/icon-title.jpg" />注册个 人 资 料
					</p>
				</div>
				<div class="main">
					<h2>
						<img src="images/icon-modifyInfo.jpg" /> 请注册用户信息
					</h2>
					<form action="Registration" onsubmit="return checkForm();" method='POST'>
						<table>
							<tr>
<s:actionerror/>		
								<td align="right">用户名： <input
									type='text' id="username" name='username'
									value='${param.username}' />

								</td>

								<td><font id='usernameErr' color='red'> <i> <s:fielderror>
												<s:param>username</s:param>
											</s:fielderror>
															
									</i></font></td>
							</tr>

							<tr>
								<td align="right">密&nbsp;码： <input
									type='password' id='password' name='password' value='' />

								</td>

								<td><font id='passwordErr' color='red' size="-1"> <i>
											<s:fielderror>
												<s:param>password</s:param>
											</s:fielderror>
									</i></font></td>


							</tr>
							
							<tr>
								<td align="right">确认密码： <input id='repassword'
									type="password" name="repassword" value="" /></td>

								<td><font id='repasswordErr' color='red' size="-1">
										<i> <s:fielderror>
												<s:param>repassword</s:param>
											</s:fielderror>
									</i>
								</font></td>
							</tr>
							
							<tr>
								<td align="right">真实姓名： <input type="text" name="name"
									id="name" maxlength="20" value="${param.name}" /></td>

								<td><font id='nameErr' color='red' size="-1"> <i>
											<s:fielderror>
												<s:param>name</s:param>
											</s:fielderror>
									</i></font></td>
							</tr>

							<tr>
								<td align="right">身份证： <input type="text" name="idnum"
									id='idnum' maxlength="20" value="${param.idnum}" /></td>

								<td><font id='idnumErr' color='red' size="-1"> <i>
											<s:fielderror>
												<s:param>idnum</s:param>
											</s:fielderror>
									</i></font></td>
							</tr>

							<tr>
								<td align="right">电 话： <input type="text" name="tel"
									id='tel' maxlength="20" value="${param.tel}" /></td>

								<td><font id='telErr' color='red' size="-1"> <i>
											<s:fielderror>
												<s:param>tel</s:param>
											</s:fielderror>
									</i></font></td>
							</tr>
							
							<tr>
							
								<td align="right"><input type="submit" name="" value="确认" /><input type="reset" name="" value="重置" class="submit" /></td>
								<td> </td>
							</tr>
							<tr><td><a href="/TNA/user/LoginUser.jsp">返回登录页</a> </td></tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>

