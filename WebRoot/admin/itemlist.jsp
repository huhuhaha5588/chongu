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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="mainBody" scope="request">admin/itemlist.jsp</c:set>
<c:set var="pageTitle" scope="request">题库管理</c:set>
<jsp:include page="/WEB-INF/jspf/common/adminLayout.jsp">
<jsp:param value="subTitle" name="题库管理"/>
</jsp:include>