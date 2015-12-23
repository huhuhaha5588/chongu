<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
    	<base href="<%= basePath %>" />
        <title>${pageTitle}</title>
        <meta HTTP-EQUIV=Content-Type content="text/html; charset=utf-8">
        <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css" />
        <script type="text/javascript" src='style/jquery-2.1.3.min.js'></script>
    </head>
    <body bgcolor='white'>
     
     	<div id="main_page">
            <div id="header">
                <img src="images/image-logo.png"/>
            </div>
            <div id="body">
                <div id="navigation">
                	<jsp:include page="/WEB-INF/jspf/common/navigation.jsp" />
                </div>
                <div id="content">
                    <!--body页面部分-->
                   <jsp:include page="/WEB-INF/jspf/${mainBody}" />
                </div>  <!--content-->
            </div>  <!--body-->
            <div id="footer">
                <%@include file="/WEB-INF/jspf/common/footer.jsp" %>
            </div>
        </div>
    </body>
</html>
