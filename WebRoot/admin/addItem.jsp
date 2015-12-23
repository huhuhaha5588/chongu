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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<base href="<%=basePath%>">
<c:set var="mainBody" scope="request">admin/addItem.jsp</c:set>
<c:set var="pageTitle" scope="request">添加考题</c:set>
<jsp:include page="/WEB-INF/jspf/common/adminLayout.jsp">
<jsp:param value="" name=""/>
</jsp:include>
