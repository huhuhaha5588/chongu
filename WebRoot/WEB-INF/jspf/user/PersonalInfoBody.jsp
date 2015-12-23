<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.oracle.tna.web.LoginFilter"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="com.oracle.tna.service.UserService"%>
<%@ page import="com.oracle.tna.domain.User"%>
<%@ page import="org.springframework.context.support.AbstractApplicationContext"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	AbstractApplicationContext context = (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	UserService userService = (UserService) context.getBean("userService");
	User user = (User) session.getAttribute(LoginFilter.ATTR_USER);
	pageContext.setAttribute("user", user);
	pageContext.setAttribute("userService", userService);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>

<font color='red'><s:actionerror /></font>
<form action="user/PersonalInfo.action" method="post" onsubmit="return check();">
	<table  cellspacing="6">
		<tr>
			<td >
				&nbsp;账户名：&nbsp;${user.username }
			</td>
			
		</tr>
		<tr>
			<td >密&nbsp;&nbsp;码： <input type="password" id="password"
				name="password" maxlength="20" value="${user.password }" />
			</td>

			<td><font color="red" id="passwordErr"><i> <s:fielderror>
							<s:param>password</s:param>
						</s:fielderror>
				</i></font></td>
		</tr>
		<tr>
			<td >确认密码： <input type="password" id="repassword" name="repassword" 
				maxlength="20" value="" />
			</td>

			<td><font color="red" id="repasswordErr"><i> <s:fielderror>
							<s:param>repassword</s:param>
						</s:fielderror>
				</i></font></td>
		</tr>
		<tr>
			<td >真实姓名： <input type="text" name="name" id="name"
				maxlength="20" value="${user.name }" />
			</td>

			<td><font color="red" id="nameErr"><i> <s:fielderror>
							<s:param>name</s:param>
						</s:fielderror>
				</i></font></td>
		</tr>
		<tr>
			<td >身份证号： <input type="text" name="idnum" id="idnum"
				maxlength="18" value="${user.idnum }" />
			</td>
			<td><font color="red" id="idnumErr"><i> <s:fielderror>
							<s:param>idnum</s:param>
						</s:fielderror>
				</i></font></td>
		</tr>

		<tr>
			<td >联系电话： <input type="text" name="tel" id="tel"
				maxlength="20" value="${user.tel }" />
			</td>
			<td><font color="red" id="telErr"><i><s:fielderror>
							<s:param>tel</s:param>
						</s:fielderror>
				</i></font></td>
		</tr>
		<tr><td><br /></td></tr>
	</table>
	&nbsp;&nbsp;&nbsp;<input type="submit" name="" value="确认" /> 
	&nbsp;&nbsp;<input type="reset" name="" value="重置" />
</form>

<script type="text/javascript">

	function checkPassword() {
		var password = $("#password").val();
		if (password == "") {
			// 填充错误信息,并置空密码
			$("#passwordErr").text("请输入密码");
			$("#password").val("");
			return false;
		} else {
			// 置空错误信息
			$("#passwordErr").text("");
			return true;
		}
	}

	function checkRepassword() {
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		if (password != repassword) {
			// 填充错误信息,并置空密码
			$("#repasswordErr").text("两次密码不一致,请重新输入");
			return false;
		}else {
			$("#repasswordErr").text("");
			return true;
		}
	}
	
	function checkName() {
		var name = $("#name").val();
		if (name == "") {
			// 填充错误信息,并置空密码
			$("#nameErr").text("请输入姓名");
			$("#name").val("");
			return false;
		} else {
			// 置空错误信息
			$("#nameErr").text("");
			return true;
		}
	}

	function checkIdnum() {
		var idnum = $("#idnum").val();
		if (idnum == "") {
			// 填充错误信息,并置空密码
			$("#idnumErr").text("请输入身份证号");
			$("#idnum").val("");
			return false;
		} else {
			if(!checkIdnum1()) {
				$("#idnumErr").text("身份信息格式错误");
				return false;
			}
			$("#idnumErr").text("");
			return true;
		}
	}
	
	function checkIdnum1(){
		var idnum = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
		var value=document.getElementById("idnum").value.trim();
		if(idnum.test(value)){
			return true;
		}
		return false;
	}

	function checkTel() {
		var tel = $("#tel").val();
		if (tel == "") {
			// 填充错误信息,并置空密码
			$("#telErr").text("请输入联系电话");
			$("#tel").val("");
			return false;
		} else {
			if(!checkTel1()) {
				// 格式错误信息
				$("#telErr").text("联系电话格式错误");
				return false;
			}
			// 置空错误信息
			$("#telErr").text("");
			return true;
		}
	}
	
	function checkTel1(){
		var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
		var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
		var value=document.getElementById("tel").value.trim();
		if(isMob.test(value)||isPhone.test(value)){
			return true;
		}
		return false;
	}

	function check() {
		return checkPassword() && checkRepassword()
				&& checkName() && checkIdnum() && checkTel();
	}
</script>