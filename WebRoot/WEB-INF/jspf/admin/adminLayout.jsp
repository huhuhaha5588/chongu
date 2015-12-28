<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oracle.tna.domain.AdminUser"%>
<%@page import="com.oracle.tna.web.AdminLoginFilter"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
AdminUser adminUser = (AdminUser)session.getAttribute(AdminLoginFilter.ATTR_ADMINUSER); 
pageContext.setAttribute("adminUser", adminUser);
%>

<html>
    <head>
    	<base href="<%= basePath %>" />
        <title>${pageTitle}</title>
        <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css" />
        <script type="text/javascript" src='style/jquery-2.1.3.min.js'></script>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    	<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   		<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
    </head>
    <div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${adminUser.adminUserName}</span><a href="admin/AdminLogout.action" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>
			<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    
    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',homePage : '12',menu:
        				[{text:'系统管理',items:
        					[
					        	{id:'12',text:'机构管理',href:'admin/index.jsp'},
					        	{id:'3',text:'角色管理',href:'admin/index2.jsp'},
					        	{id:'4',text:'用户管理',href:'User/index.html'},
					        	{id:'6',text:'菜单管理',href:'Menu/index.html'}
				        	]
	        			}]
	        			},
	        			{id:'7',homePage : '9',menu:
		        			[{text:'业务管理',items:
		        			[
		        				{id:'9',text:'查询业务',href:'Node/index.html'}
		        			]
	        			}]
	        			}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
