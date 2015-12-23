<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.oracle.tna.domain.Item" %>
<%@ page import="com.oracle.tna.service.ItemService"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.context.support.AbstractApplicationContext"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	AbstractApplicationContext context= (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	ItemService itemService = (ItemService)context.getBean("itemService");
	List<Item> list = itemService.showAllItems();
	request.setAttribute("list",list);
 %>
<script type="text/javascript">
	function confirmdelete()
	{
		if(!confirm("确定要删除？"))
		{
			window.event.returnValue = false;
		}else{
			window.event.returnValue = true;
		}
	}
</script>
<c:set var="items" value="${list}" ></c:set>
<base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<a href="admin/addItem.jsp">
	<span style="color:#FF8005;">添加考题</span>
</a>
<a href="user/DownLoadItems?">
	<span style="color:#FF8005;">下载考题</span>
</a>
<c:forEach items="${items}" var="item" varStatus="id">
	<div class="item">
		<b>${id.count}</b>.&nbsp;
		${item.question}
		答案: <span style="font-weight:bold;color:#F80015;">
		${item.answer}</span>								
		<a href="deleteitem.action?qid=${item.qid}" onClick="confirmdelete()">
		<span style="color:#FF8005;">删除</span>
		</a>
		<a href="dispItemAction.action?qid=${item.qid}">
		<span style="color:#FF8005;">编辑</span>
		</a><br />	
		<p class="answer">							
			${item.optionA}<br />
			${item.optionB}<br />
			${item.optionC}<br />
			${item.optionD}<br />
			<hr/>
		</p>
	</div>							
</c:forEach>