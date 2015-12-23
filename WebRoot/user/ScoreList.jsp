<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<c:set var="mainBody" value="user/ScoreListBody.jsp" scope="request"></c:set>
<c:set var="pageTitle" value="ScoreList.jsp" scope="request"></c:set>
<jsp:include page="/WEB-INF/jspf/common/layout.jsp" >
<jsp:param value="" name=""/>
</jsp:include>
