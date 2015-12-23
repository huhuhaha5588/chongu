<%@ page import="com.oracle.tna.domain.Item" %>
<%@ page import="com.oracle.tna.service.ItemService"%>
<%@ page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	AbstractApplicationContext context= (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	ItemService itemService = (ItemService)context.getBean("itemService");
	request.setAttribute("itemService", itemService);
 %>
<c:set var="answer" value="${itemService.getOption()}" />
<script type="text/javascript">
function checkadd()
{
	if(document.form.question.value=="")
	{
		alert("请输入问题！");
		return false;
	}
	if(document.form.optiona.value=="")
	{
		alert("请输入选项！");
		return false;
	}
	if(document.form.optionb.value=="")
	{
		alert("请输入选项！");
		return false;
	}
	if(document.form.optionc.value=="")
	{
		alert("请输入选项！");
		return false;
	}
	if(document.form.optiond.value=="")
	{
		alert("请输入选项！");
		return false;
	}
	if(document.form.answer.value=="")
	{
		alert("请选择答案！");
		return false;
	}
	return true; 
}
</script>
    <base href="<%=basePath%>">
 <form name="form" onSubmit="return checkadd()" action="addItemAction" method="post">
		题目：<INPUT type="text" name="question" value="${param.question}"></br>
		<font color="red">
		<s:fielderror>
				<s:param>question</s:param>
				</s:fielderror>
		 		</font><br />
		选项A：<INPUT type="text" name="optiona" value="${param.optiona}"></br>
		<font color="red">
		<s:fielderror>
				<s:param>optiona</s:param>
				</s:fielderror>
		 		</font></br>
		选项B：<INPUT type="text" name="optionb" value="${param.optionb}"></br>
		<font color="red">
		<s:fielderror>
				<s:param>optionb</s:param>
				</s:fielderror>	
		 		</font></br>
		选项C：<INPUT type="text" name="optionc" value="${param.optionc}"></br>
		<font color="red">
		<s:fielderror>
				<s:param>optionc</s:param>
				</s:fielderror>
		 		</font></br>
		选项D：<INPUT type="text" name="optiond" value="${param.optiond}"></br>
		<font color="red">
		<s:fielderror>
				<s:param>optiond</s:param>
				</s:fielderror>
		 		</font></br>
		答案：<c:forEach items="${answer}" var="answer">
			<input type='radio' name='answer' value="${answer}"
		   			<c:if test="${param.answer eq answer}">
		   			checked
		   			</c:if> >${answer}
		</c:forEach></br>
		<font color="red">
		<s:fielderror>
				<s:param>answer</s:param>
				</s:fielderror>
		 		</font></br>
		<INPUT type="submit" value="确&nbsp; 定"   >&nbsp;&nbsp;&nbsp;
		<INPUT type="reset" value="重&nbsp; 置"   >
</form>
