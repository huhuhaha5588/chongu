<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request">电信网络学院（TNA）</c:set>
<c:set var="mainBody" scope="request">admin/UserListBody.jsp</c:set>

<jsp:include page="/WEB-INF/jspf/common/adminLayout.jsp">
    <jsp:param name="subTitle" value="用户列表" />
</jsp:include>