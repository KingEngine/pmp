<%@page contentType="text/html; charset=utf-8" %>
<%@page import="org.springframework.security.core.Authentication" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/top.css"/>
<body style="margin: 0px; padding: 0px;">
<div style="width:100%;">
   <img  src="<%=request.getContextPath()%>/images/top/head.jpg" width="100%" height="40%"/>
     ${session}
 	<ul class="nav">
		<c:forEach items="${firstMenus}" var="menu" varStatus="status">
			<li><a style="cursor:pointer;" href="<%=request.getContextPath()%>/getLeftMenuList.do?firstMenuId=${menu.menuId}" target="left">${menu.menuName}</a></li>
		</c:forEach>
	</ul> 
</div>