<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.oracle.tna.service.*" %>
<%@ page import="org.springframework.context.support.*"%>
<%@ page import="org.springframework.web.context.*" %>
<% AbstractApplicationContext context = (AbstractApplicationContext)application.
										getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE); 
	ExamService examService = (ExamService)context.getBean("examService");
	request.setAttribute("examService", examService);
	session.setAttribute("items", examService.getItems());
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<script>
	function checkRadio(){         
		var radio0 = document.examForm.answer0.value;
		var radio1 = document.examForm.answer1.value;
		var radio2 = document.examForm.answer2.value;
		var radio3 = document.examForm.answer3.value;
		var radio4 = document.examForm.answer4.value;
		var radio5 = document.examForm.answer5.value;
		var radio6 = document.examForm.answer6.value;
		var radio7 = document.examForm.answer7.value;
		var radio8 = document.examForm.answer8.value;
		var radio9 = document.examForm.answer9.value;
		if(radio0 == ''||radio1 == ''||radio2 == ''||radio3 == ''||radio4 == ''||radio5 == ''||radio6 == ''||radio7 == ''||radio8 == ''||radio9 == ''){
			alert("您还有未答的题，请继续选择！");
			return false;
		}
		return true;
	}
</script>
	
 <div class="title">
     <p><img src="./images/icon-itemlib.jpg" /> 参加考试</p>
 </div>
 <form action="user/Exam.action" method="post" name="examForm" onSubmit="return checkRadio()">
 <table style="align:center;cellspacing:1">
   <c:forEach var="item" items="${sessionScope.items }" varStatus="status">
	  <tr>
	  	<td>
		  	<div style="color:#666666; size:2">
				${status.count}.${item.question }<br/>
			   	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="answer${status.index}" value="A" />${item.optionA }<br />
			   	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="answer${status.index}" value="B" />${item.optionB }<br />
			   	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="answer${status.index}" value="C" />${item.optionC }<br />
			   	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="answer${status.index}" value="D" />${item.optionD }<br /><br />
			</div>
		</td>
	  </tr>
   </c:forEach>
   </table>
   <input type="submit" value="交&nbsp;卷" /><br/><br/>
 </form>