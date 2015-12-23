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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<base href="<%=basePath%>">
<c:set var="mainBody" scope="request">admin/modifyItem.jsp</c:set>
<c:set var="pageTitle" scope="request">编辑</c:set>
<jsp:include page="/WEB-INF/jspf/common/adminLayout.jsp">
<jsp:param value="" name=""/>
</jsp:include>