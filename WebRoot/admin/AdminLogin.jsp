<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录页面</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
	<script type="text/javascript">
		function checkUsername() {
	
			var username = $("#username").val();
			if (username == "") {
				// 填充错误信息
				$("#usernameErr").html("<font color='red'>请输入用户名</font>");
				return false;
			} else {
				// 置空错误信息
				$("#usernameErr").html("");
				return true;
			}
		}
	
		function checkPasswd() {
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
	
		function check() {
			return checkUsername() && checkPassword();
		}
	
		
</script>
<style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
</head>

<body bgcolor="#0591C2">
	
		<div class="container">
				
				
				
				<form class="form-signin" name="adminLoginForm" action='<c:url value="AdminLogin"/>'
					method="post" onsubmit="return check()">
					
					<h2 class="form-signin-heading">登录系统</h2>
							<input type='text' class="input-block-level" id='adminUserName'
								name='adminUserName' value='${param.adminUserName}' placeholder="账号" /> 
							<font color='red'><s:actionerror /></font>

							<font color="red"><span id="usernameErr"></span></font>
								
						
						
							<input type='password' class="input-block-level" id='password' name='password' value='' placeholder="密码" />
						<p><button class="btn btn-large btn-primary" type="submit">登录</button></p>
					<font color='red' size='-1'>
									 <s:fielderror>
											<s:param>adminUserName</s:param>
										</s:fielderror>
									
								</font>
							<font color="red"><span id="passwordErr"></span></font>
							<font color='red' size='-1'> <s:fielderror>
											<s:param>password</s:param>
										</s:fielderror>
								</font>
								
		</form>
				
	</div>
</body>
</html>

