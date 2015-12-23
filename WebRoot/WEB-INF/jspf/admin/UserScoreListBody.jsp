<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.oracle.tna.service.ScoreService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.oracle.tna.domain.UserScore"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<%
	ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	ScoreService scoreService = (ScoreService)context.getBean("scoreService");
	pageContext.setAttribute("scoreService", scoreService);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div id="u160_rtf">
		<p style="text-align:left;">
			共计${scoreService.allScores.size()}条记录
		</p>
	</div>
	<br />
<div class="title">
        	<p><img src="./images/icon-itemlib.jpg" /> 考 试 记 录 列 表</p>
</div>
<DIV id="mainlist" style="overflow:visible">
	
   <table width="99%" cellspacing="1" >
	    	<tr style="background:#F6F6F6;">
	    		<th>编号</th>
	    		<th>用户名</th>
	    		<th>真实姓名</th>
	    		<th>考试时间</th>
	    		<th>分数</th>
	    	</tr>
					
						<c:forEach items="${scoreService.allScores}" var= "score">
						<tr>
							<td>${score.uid}</td>
							<td>${score.username} </td>
							<td>${score.name} </td>
							<td>${score.date} </td>
							<td>${score.score} </td>
						</tr>
						</c:forEach>
						<c:if test="not empty service" >
	    				</c:if>
	    	
	    </table>
</DIV>
