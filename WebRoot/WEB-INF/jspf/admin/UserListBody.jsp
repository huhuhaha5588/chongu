<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.oracle.tna.service.UserService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.oracle.tna.domain.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
UserService userService = (UserService)context.getBean("userService");

pageContext.setAttribute("userService", userService);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
   	<base href="<%=basePath%>">   
   	<title>userList</title>
	<div id="u160_rtf">
		<p style="text-align:left;">
			共计${userService.allUsers.size()}个学生
		</p>
	</div>	
	<br />
	<div class="title">
       	<p><img src="./images/icon-itemlib.jpg" /> 用户信息列表</p>
       </div>
	<DIV id="mainlist" style="overflow:visible">
		<table style='align:center; width:99% ;cellspacing:1'>
	    	 <tr style="background:#F6F6F6;">
	    		<th>编号</th>
	    		<th>用户名</th>
	    		<th>真实姓名</th>
	    		<th>身份证号</th>
	    		<th>联系电话</th>
	    	</tr>
			<tr>
				<c:forEach items="${userService.allUsers}" var= "user">
				<tr>
					<td>${user.uid}</td>
					<td>${user.username} </td>
					<td>${user.name} </td>
					<td>${user.idnum} </td>
					<td>${user.tel} </td>
				</tr>
				</c:forEach>
				<c:if test="not empty service" >
   				</c:if>
   			</tr>
		    </table>        
		</DIV>

