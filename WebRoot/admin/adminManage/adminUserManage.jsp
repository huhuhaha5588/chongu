<%@page import="com.oracle.tna.domain.AdminUser"%>
<%@ page import="com.oracle.tna.domain.Item" %>
<%@ page import="com.oracle.tna.service.AdminUserService"%>
<%@ page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	AbstractApplicationContext context= (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	AdminUserService adminUserService = (AdminUserService)context.getBean("adminUserService");
	List<AdminUser> adminUsers =  adminUserService.search(request.getParameter("userName"));
	request.setAttribute("adminUsers",adminUsers);
 %>
<c:set var="adminUsers" value="${adminUsers}" ></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<base href="<%=basePath%>">
<html>
<head>
    <title>用户管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.sorted.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="admin/AddAdminUser.action" method="get">    
    用户名称：
    <input type="text" name="userName" id="userName"class="abc input-default" placeholder="请输入要查询的用户名" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>真实姓名</th>
        <th>最后登录时间</th>
        <th>操作</th>
    </tr>
    </thead>
    	 <c:forEach items="${adminUsers}" var="adminUser">
	     <tr>
            <td>${adminUser.aid}</td>
			<td>${adminUser.adminUserName} </td>
			<td>${adminUser.name} </td>
            <td>${adminUser.lastlogintime}</td>
            <td>
                <a href="edit.html">编辑</a>                
            </td>
        </tr>	
        </c:forEach>
		<c:if test="not empty service" >
		</c:if>
</table>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="add.html";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
