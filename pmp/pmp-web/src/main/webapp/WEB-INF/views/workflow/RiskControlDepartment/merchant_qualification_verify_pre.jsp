<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <title>商户资质审核</title>
       <meta http-equiv="pragma" content="no-cache"/>
       <meta http-equiv="cache-control" content="no-cache"/>
       <meta http-equiv="Expires" content="0"/>  
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css"/>
       <%@include file="../../resource.tag" %> 
       <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
</head>
<body style="overflow-x:hidden;">
	<div class="easyui-panel" style="width: 100%;" title="">
	   <form id="addForm" name="addForm" method="post">
	     <input type="hidden" name="taskId" id="taskId" value="${taskId}"/> 
	    
	     <table width="100%" class="addTable">	
	        <tr>
	        	<td class="title_weight" colspan="6">POS商户信息 ${taskId}</td>
	        </tr>
	        <tr>
	        	<td>
	        		<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-filesave'" onclick="ajaxSubmitFormWithParameter('addForm','handler.do',false,'agree')">同意</a>
	        		<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-filesave'" onclick="ajaxSubmitFormWithParameter('addForm','handler.do',false,'disagree')">不同意</a>
	        	</td>
	        </tr>
	       </table>
	    </form>
	</div>
</body>
</html>