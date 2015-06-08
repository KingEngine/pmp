<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="resource.tag"%> 
<head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta name="Keywords" content="Travel, Flight, Airline"/>
	<meta http-equiv="pragma" content="no-cache"/> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="windows-target" content="_top" />
	<title>电银信息支付管理平台登录</title>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/views/login.js" ></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
 <div class="denglubody">
	<form action="login.do" method="post" name="loginForm" id="loginForm">
		<table style="margin-left: 280px;margin-top: 62px;">
		  <tr>
		  	<td><input type="text" class="easyui-textbox" data-options="buttonText:'用户名',buttonAlign:'left',buttonIcon:'icon-man',iconAlign:'left',width:280,height:25" name="j_username"/></td>
		  </tr>
		  <tr>
		  	<td><input type="password" class="easyui-textbox" data-options="buttonText:'密 &nbsp;&nbsp;码',buttonAlign:'left',buttonIcon:'icon-lock',iconAlign:'left',width:280,height:25" name="j_password"/></td>
		  </tr>
		  <tr>
		     <td><input type="text" id="j_randcode" name="j_randcode" class="easyui-textbox" data-options="buttonText:'验证码',buttonAlign:'left',buttonIcon:'icon-blank',height:25" maxlength="4"></input>
			  	<img id="imgRandcode" name="imgRandcode" src="<%=request.getContextPath()%>/getRandCode" />
			  	<a href="#" onclick="flushRandcode('<%=request.getContextPath()%>/getRandCode');">刷新</a>
		  	</td>
		  </tr>
		  <tr>
		     <td align="center">
		     	<img  src="<%=request.getContextPath()%>/images/login/denglu_but.png" onclick="login();" style="cursor: pointer;"/>
		     </td>
			</tr>
		</table>
	</form>
  </div>
</body>
</html>
