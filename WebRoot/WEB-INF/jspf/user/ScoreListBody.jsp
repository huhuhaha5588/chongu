<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.oracle.tna.service.ScoreService" %>
<%@ page import="com.oracle.tna.web.LoginFilter" %>
<%@ page import="com.oracle.tna.domain.*" %>
<%@ page import="org.springframework.context.support.*"%>
<%@ page import="org.springframework.web.context.*" %>
<%  AbstractApplicationContext context = (AbstractApplicationContext)application.
										getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE); 									
	ScoreService scoreService = (ScoreService)context.getBean("scoreService");
	request.setAttribute("scores", scoreService.getScoresByUid(((User)session.getAttribute(LoginFilter.ATTR_USER)).getUid()));
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">

 <div class="title">
     <p><img src="./images/icon-itemlib.jpg" /> 考 试 记 录 列 表</p>
 </div>
 <div class="mainlist">
 <table style='align:center; width:99% ;cellspacing:1'>
	 <tr>
		  <th>编  号</th>
		  <th>考试时间</th>
		  <th>分  数</th>
	 </tr>
	 <c:forEach var="score" items="${requestScope.scores }" varStatus="status">
		  <tr style='align="center"'>
			   <td>${status.count}</td>
			   <td>${score.date }</td>
			   <td>${score.score }</td>
		  </tr>
	 </c:forEach>
</table>
</div>
