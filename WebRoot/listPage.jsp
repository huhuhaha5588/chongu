<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request">冲谷软件  - 【零售信息化】增值服务商-购物中心 shopping mall 商业信息化管理系统、大型连锁超市POS/ERP管理系统、中小超市进销存管理系统、多渠道O2O一体化零售管理平台、生鲜管理系统、餐饮软件、收款机、条码打印机、条码秤、一维码二维码扫描平台、扫描枪、防盗、超市耗材等</c:set>
<c:set var="mainBody" scope="request">IndexBody.jsp</c:set>

<jsp:include page="/WEB-INF/jspf/listPage/listLayout.jsp">
    <jsp:param name="subTitle" value="首页" />
</jsp:include>