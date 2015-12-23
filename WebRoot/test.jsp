
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.oracle.tna.domain.UserScore"%>
<%@page import="com.oracle.tna.domain.User"%>
<%@page import="com.oracle.tna.service.ScoreService"%>
<%@page import="com.oracle.tna.service.UserService"%>
<%@page import="com.oracle.tna.domain.Score"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="java.util.List"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

AbstractApplicationContext context = (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
ScoreService scoreService = (ScoreService)context.getBean("scoreService");
List<UserScore> list = scoreService.getAllScores();
for(UserScore l:list){
	System.out.println(l);
}
	 
 UserService userService = (UserService)context.getBean("userService");
 List<User> Users = userService.getAllUsers();
 for(User a:Users){
	System.out.println(a.toString());
}
	     /*    System.out.println("This company is :\n" + customer.toString());
	        context.close(); */
%>







<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
