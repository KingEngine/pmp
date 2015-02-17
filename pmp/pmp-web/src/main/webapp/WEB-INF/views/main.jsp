<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="image/x-icon" href="<%=request.getContextPath()%>/images/favicon.ico?" rel="shortcut icon"/>
	<link rel="icon" href="<%=request.getContextPath()%>/images/favicon.ico?" type="image/x-icon"/>
	<%@include file="resource.tag" %>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:false" style="overflow:hidden;width:100%;height:16%;border-left:0px;border-top: 0px;border-right: 0px;">
		    <iframe src="getTopPage.do" frameborder="0" scrolling="no" width="100%"></iframe> 
	</div>
	<div data-options="region:'west',split:false" title="菜单列表" style="overflow:hidden;width:200px;">
		<iframe frameborder="0" scrolling="no" name="left"></iframe>
	</div> 
	<div data-options="region:'center',title:' ',iconCls:'icon-tip'"  class="easyui-tabs" id="rightMain"  >
	  <div title="测试">
	  	11111111111
	  </div>
	   <iframe id="rightMainUrl" src="getWelcomePage.do" name="rightFrame" frameborder="0" height="100%" width="100%" style="overflow:auto;">
	   </iframe>
	</div>
	<div data-options="region:'south',split:false" style="height:4%;">
	   <iframe src="getFootPage.do" frameborder="0" scrolling="no" width="100%"></iframe> 
	</div>
</body>
</html>