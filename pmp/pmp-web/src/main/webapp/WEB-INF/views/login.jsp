<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	int rand = new java.util.Random().nextInt(10000);
%>
<head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta name="Keywords" content="Travel, Flight, Airline"/>
	<meta http-equiv="pragma" content="no-cache"/> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="windows-target" content="_top" />
	<title>电银信息支付管理平台登录</title>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/views/login.js?<%=rand%>" ></script>
</head>
<body>
 <center>
	<form action="login.do" method="post">
		<table>
		  <tr><td colspan="2" align="left"><h3>用户登录</h3></td></tr>
		  <tr>
		  	<td align="left">用户名:</td><td><input type="text" name="j_username"/></td>
		  </tr>
		  <tr>
		  	<td align="left">密码:</td><td><input type="password" name="j_password"/></td>
		  </tr>
		  <tr>
		  	<td align="left">验证码：</td><td><input type="text" id="j_randcode" name="j_randcode" maxlength="4"></input>
			  	<img id="imgRandcode" name="imgRandcode" src="<%=request.getContextPath()%>/getRandCode" />
			  	<a href="#" onclick="flushRandcode('<%=request.getContextPath()%>/getRandCode');">刷新</a>
		  	</td>
		  </tr>
		  <tr>
		    <td colspan="2" align="center"><input type="submit" value="登录"/></td>
		  </tr>
		</table>
		
		
	</form>
  </center>
</body>
</html>
