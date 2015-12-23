<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="mainBody" scope="request">user/PersonalInfoBody.jsp</c:set>
<c:set var="pageTitle" scope="request">个人信息修改</c:set>
<jsp:include page="/WEB-INF/jspf/common/layout.jsp">
<jsp:param value="" name=""/>
</jsp:include>
