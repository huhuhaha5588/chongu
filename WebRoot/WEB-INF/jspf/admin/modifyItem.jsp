<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.oracle.tna.domain.Item" %>
<%@ page import="com.oracle.tna.service.ItemService"%>
<%@ page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
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
<c:set var="answers" value="${itemService.getOption()}" />
<!--  判断回填到表单的数据来自dispItemAction,还是来自 modifyItemAction-->	
	<c:if test="${item != null}">
		<c:set var="question" value="${item.question}"/>
		<c:set var="optiona" value="${item.optionA}"/>
		<c:set var="optionb" value="${item.optionB}"/>
		<c:set var="optionc" value="${item.optionC}"/>
		<c:set var="optiond" value="${item.optionD}"/>
		<c:set var="answer" value="${item.answer}"/>
	</c:if>
	<c:if test="${item == null}">
		<c:set var="question" value="${param.question}"/>
		<c:set var="optiona" value="${param.optiona}"/>
		<c:set var="optionb" value="${param.optionb}"/>
		<c:set var="optionc" value="${param.optionc}"/>
		<c:set var="optiond" value="${param.optiond}"/>
		<c:set var="answer" value="${param.answer}"/>
	</c:if>
<script type="text/javascript">
function checkmodify()
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<base href="<%=basePath%>">
<form name="form" action="modifyItemAction" method="post" onSubmit="return checkmodify()">
					题目：<INPUT type="text" name="question" value="${question}"><br />
						<font color="red">
						<s:fielderror>
				  		<s:param>question</s:param>
				  		</s:fielderror>
				  		</font><br />
					选项A：<INPUT type="text" name="optiona" value="${optiona}"><br />
						<font color="red">
						<s:fielderror>
				  		<s:param>optiona</s:param>
				  		</s:fielderror>
				  		</font><br />
					选项B：<INPUT type="text" name="optionb" value="${optionb}"><br />
						<font color="red">
						<s:fielderror>
				  		<s:param>optionb</s:param>
				  		</s:fielderror>	
				  		</font><br />
					选项C：<INPUT type="text" name="optionc" value="${optionc}"><br />
						<font color="red">
						<s:fielderror>
				  		<s:param>optionc</s:param>
				  		</s:fielderror>
				  		</font><br />
					选项D：<INPUT type="text" name="optiond" value="${optiond}"><br />
						<font color="red">
						<s:fielderror>
				  		<s:param>optiond</s:param>
				  		</s:fielderror>
				  		</font><br />
					答案：<c:forEach items="${answers}" var="answers">
							<input type='radio' name='answer' value="${answers}"
	  			   			<c:if test="${answer eq answers}">
	  			   			checked
	  			   			</c:if> >${answers}
						</c:forEach><br />
						<font color="red">
						<s:fielderror>
				  		<s:param>answer</s:param>
				  		</s:fielderror>
				  		</font><br />
					<input type="hidden" name="qid" value="${item.qid}" /><br /><br />
					<INPUT type="submit" value="确&nbsp; 定"   >&nbsp;&nbsp;&nbsp;
					<INPUT type="reset" value="重&nbsp; 置"   >
					</form>