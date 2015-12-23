<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.oracle.tna.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
 
<div class="title">
    <p><img src="./images/icon-itemlib.jpg" /> 考试成绩</p>
</div>
<div class="mainlist">

<c:if test="${requestScope.score.score >= 60 }">
	恭喜你通过本次考试
</c:if>
<c:if test="${requestScope.score.score < 60 }">
	很抱歉，你没有通过这次考试
</c:if>
           。分数：${requestScope.score.score }
           
<table style='align:center ;width:99% ;cellspacing:1 '>
	 <tr>
		  <th></th>
		  <th>标准答案</th>
		  <th>你的选择</th>
	 </tr>
	 <c:forEach var="s_answer" items="${requestScope.s_answers }" varStatus="status">
		  <tr>
			   <td>第${status.count}题</td>
			   <td>${requestScope.s_answers[status.index] }</td>
			   <td>
				    <c:if test="${requestScope.s_answers[status.index] eq requestScope.answers[status.index] }">
				    	${requestScope.answers[status.index]}
				    </c:if>
				    <c:if test="${requestScope.s_answers[status.index] != requestScope.answers[status.index] }">
				   		<font style='color:red'>${requestScope.answers[status.index]}</font>
				    </c:if>
			   </td>
		  </tr>
	 </c:forEach>
	 <tr>
		  <td>总分</td>
		  <td></td>
		  <td>${requestScope.score.score }</td>
	 </tr>
</table>
</div>