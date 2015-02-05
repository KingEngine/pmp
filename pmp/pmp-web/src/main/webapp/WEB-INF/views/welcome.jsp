<%@ page contentType="text/html; charset=utf-8" language="java"%>
<% 
    String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="Expires" content="0">  
<style>
.welcome-font {
	color: #05326a;
	font-family: "微软雅黑", "宋体", Tahoma, Arial;
	font-size: 14px;
}
</style>
<title>Welcome</title>
</head>
<body background="<%= path%>/images/main/welcome-bg.jpg">
	<div style="margin-top: 30px;" class="welcome-font">
		欢迎您!
	</div>
</body>
</html>