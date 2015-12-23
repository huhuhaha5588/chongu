<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.oracle.tna.service.UserService"%>
<%@page import="com.oracle.tna.domain.AdminUser"%>
<%@page import="com.oracle.tna.web.AdminLoginFilter"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.oracle.tna.domain.User"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
UserService userService = (UserService)context.getBean("userService");
pageContext.setAttribute("userService", userService);
AdminUser adminUser = (AdminUser)session.getAttribute(AdminLoginFilter.ATTR_ADMINUSER); 
pageContext.setAttribute("adminUser", adminUser);
%>
<!-- AdminUser adminUser = (AdminUser)session.getAttribute(LoginFilter.ATTR_ADMINUSER); -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div id="navigation">
	<div id="inner">
		 <c:if test="${not empty adminUser}">
	    	<p>当前用户：${adminUser.adminUserName}</p>
	    </c:if>
	    <c:if test="${adminUser eq null}">
	    	<p>请登录</p>
	    </c:if>
	    <ul>
	        <li><a href="admin/index.jsp" class="index">首&nbsp;&nbsp;&nbsp;&nbsp;页</a><li>
	        <li><a href="admin/UserList.jsp" class="personal">用户列表</a><li>
	        <li><a href="admin/UserScoreList.jsp" class="exam">考试记录</a><li>
	        <li><a href="admin/itemlist.jsp" class="examlog">题库管理</a><li>
	        <li><a href="admin/AdminLogout.action" class="logout">退&nbsp;&nbsp;出</a><li>
	    </ul>
	</div>
</div>