<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.chinaebi.pmp.common.constant.WebConstants"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
int rand = new java.util.Random().nextInt(10000);
%>
<meta http-equiv="pragma" content="no-cache"/>
<meta name="Keywords" content="Travel, Flight, Airline"/>
<meta http-equiv="pragma" content="no-cache"/> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="windows-target" content="_top" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css?<%=rand%>"/>
<script type='text/javascript' src='<%=request.getContextPath()%>/js/jquery-1.11.1.min.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/js/softkeyboard.js'></script>
<title>电银信息支付管理平台-商户登录</title>
<script type="text/javascript"> 
    if (top.location != self.location) {
        top.location = self.location;
    }
    function submitForm(){
        document.userLoginForm.submit();
    }
    //给登陆按钮绑定回车
   if (document.addEventListener){
       document.addEventListener("keypress", fireFoxHandler, true);
   } else {
       document.attachEvent("onkeypress",ieHandler);
   }
   function fireFoxHandler(evt){
       if(evt.keyCode==13){
        var evt = document.createEvent("MouseEvents");
            evt.initEvent("click",true,true);//ff针对图片不能绑定直接click
        document.getElementById("login").dispatchEvent(evt); 
         // document.getElementById("login").click();
          return false;
       }
  }
  function ieHandler(evt){
      if(evt.keyCode==13){
         document.getElementById("login").click();
         return false;
      }
  }

  function checkInput(obj){
      if(obj){
          var v = obj.value;
          if(v!='' && !isFigure(v)) obj.value='';
      }
  }
function flushImg(){
	document.getElementById("ImgPwd").src="<%=request.getContextPath()%>/CheckCode?temp="+ (new Date().getTime().toString(36));
}
function showSoftkeyboard(){
	 document.getElementById('pwd').value = '';
	 password1 = document.getElementById('pwd');
	 showkeyboard();
	// document.getElementById('pwd').readOnly = 1;
}
// 样式 style="ime-mode:disabled" 禁止中文输入  
function noPermitInput(e){    
       var evt = window.event || e ;  
        if(isIE()){  
            evt.returnValue=false; //ie 禁止键盘输入  
        }else{  
            evt.preventDefault(); //fire fox 禁止键盘输入  
        }     
}  
function isIE() {  
    if (window.navigator.userAgent.toLowerCase().indexOf("msie") >= 1)  
        return true;  
    else  
        return false;  
} 
</script>
<link type="image/x-icon" href="<%=request.getContextPath()%>/favicon.ico?" rel="shortcut icon">
</head>
<body>

<%
try {
	session.removeAttribute(WebConstants.SESSION_LOGGED_ON_USER);
    session.removeAttribute(WebConstants.SESSION_LOGGED_ON_MID);
    session.invalidate();
} catch(Exception e){
}
%>
<div id="wrap">
    <div class="denglubody">
    	<div id="versionFont" >1.9.0</div>
        <div class="denglushuru">
           <form method="post"  name="userLoginForm" id="userLoginForm" action="<%=request.getContextPath()%>/spring_security_login">
            <input id="role" name="role" type="hidden" value="admin" />
            <input id="mid" name="mid" type="hidden" value="1" />
                <ul class="denglu_list" >
                    <li><span>操作员：</span>
                    <input class="denglu" onkeyup="checkInput(this);" maxlength="9" type="text" name="uid"  id="uid" value="<%=request.getAttribute("uid")!=null ? request.getAttribute("uid") : "" %>"/></li>
                    <li><span>密&nbsp;&nbsp;码：</span><input class="denglu" type="password" name="pwd"  id="pwd"  maxLength="15" style="width: 120px" onfocus="showSoftkeyboard();" onkeypress="noPermitInput(event)" onclick="showSoftkeyboard();"/>
                    <span style="CURSOR: pointer;padding-top: 4px;width:40px" onclick="showSoftkeyboard();"><img border="0" src="<%=request.getContextPath()%>/images/keyboard.png"></span></li>
                     <li class="yanzheng"><span>验证码：</span> 
                    <input type="text" name="ckpwd" type="text" id="ckpwd" onkeyup="checkInput(this);" maxlength="4" />
                    <span class="yanzhengma" ><img id="ImgPwd" name="ImgPwd" src="<%=request.getContextPath()%>/CheckCode" /> <a href="#"  onclick="flushImg();">刷新</a></span>
                   </li>
                   <li>
                    <table>
						<tr>
						   <td style="color:red;width:135px; " id="logmsg">
						   		<c:out value="${loginerror}"></c:out>
						   </td>
						   <td>
						     <img  src="<%=request.getContextPath()%>/images/login/denglu_but.png" onclick="submitForm();" id = "login" onfocus="this.blur()" style="cursor: pointer;"/>
						   </td>
						</tr>
					</table>
                </ul>
            </form>
        </div>
    </div>
    </div>
     <script type="text/javascript">document.getElementById("uid").focus();//定位焦点。</script>
</body>
</html>
