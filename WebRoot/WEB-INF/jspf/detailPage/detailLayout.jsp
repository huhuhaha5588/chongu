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
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
        <meta name="description" content="冲谷软件主要业务价值包括-商购物中心shopping mall、商业信息化管理系统、大型连锁超市POS/ERP管理系统、中小超市进销存管理系统、多渠道O2O一体化零售管理平台、生鲜管理系统、餐饮软件、收款机、条码打印机、条码秤、一维码二维码扫描平台、扫描枪、防盗、超市耗材等方面的系统产品及解决方案">
		<meta name="keywords" content="购物中心信息管理、连锁超市POS/ERP管理系统、线上线下一体化-多渠道零售O2O、超市硬件">
        <script type="text/javascript" src='style/jquery-2.1.3.min.js'></script>
        
        <link href="css/font_detailPage.css" rel="stylesheet" type="text/css">
        <script language="javascript" type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script language="javascript" type="text/javascript" src="js/jquery.marquee.js"></script>
		<script language="javascript" type="text/javascript" src="js/jquery.content.js"></script>
        
    </head>
    <body>
     
     	<div id="container"> 
	         <div id="headcontainer">
	         	<jsp:include page="/WEB-INF/jspf/detailPage/headcontainer.jsp" />
	         </div>
	         
	         <div id="index_menu_c"> 
	         	<jsp:include page="/WEB-INF/jspf/detailPage/menu.jsp" />
	         </div>
	         
	         <div id="content">  
	          	
	          	<div class="content_c"> 
      				<div class="content_left">
      					<div class="content_list_s">
      						<jsp:include page="/WEB-INF/jspf/detailPage/leftNavigation.jsp" />
      					</div>
      					<jsp:include page="/WEB-INF/jspf/detailPage/contains.jsp" />
	          		</div>
	          	</div>
	          	
	         </div>
	             
	         <div id="footer">
	             <jsp:include page="/WEB-INF/jspf/detailPage/footer.jsp" />
	         </div>
	         
        </div>
        <div class="main-im">
	         	<jsp:include page="/WEB-INF/jspf/detailPage/im.jsp" />
	    </div>
    </body>
</html>
