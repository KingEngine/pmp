<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>操作员权限设置页面</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css"/>
    <%@include file="../../resource.tag" %> 
    <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
</head>
<body class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'工作流权限',split:true" style="height: 35%;">
	    <ul id="workflow_authorities" class="easyui-tree" data-options="url:'getOperatorAuthorities.do?menuType=work_flow&userName=${userName}',animate:true,checkbox:true,lines:true"> 
		</ul>  
    </div>   
    <div data-options="region:'center',title:'管理平台权限',split:true" style="height: 57%;">
    	<ul id="mms_authorities" class="easyui-tree" data-options="url:'getOperatorAuthorities.do?menuType=mms&userName=${userName}',animate:true,checkbox:true,lines:true"> 
		</ul>
    </div>   
	<div data-options="region:'south',split:true" style="height: 8%;">
		<center>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="updateAuthorities('${userName}')">确定分配权限</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="history.back();">返回</a>
		</center>
	</div>  
</body>
<script type="text/javascript">
	
	function updateAuthorities(userName) {
		var workFlowNodes = $('#workflow_authorities').tree('getChecked');
		var mmsNodes = $('#mms_authorities').tree('getChecked');
		var workFlowJson="{\"workFlowMenus\":[";
		var mmsFlowJson="{\"mmsMenus\":[";
		if (typeof (workFlowNodes) != 'undefined') {
			for (var i = 0; i < workFlowNodes.length; i++) {
				workFlowJson += "{menuId:" + workFlowNodes[i].id + "";
				if (typeof (workFlowNodes[i].attributes) != 'undefined') {
					if (typeof (workFlowNodes[i].attributes.department) != 'undefined') {
						workFlowJson += ",menuDepartment:\""+ workFlowNodes[i].attributes.department + "\"";
					}
				}
				workFlowJson += "}";
				if (i < workFlowNodes.length-1) {
					workFlowJson += ",";
				}
			}
		}
		workFlowJson += "]}";
		if (typeof (mmsNodes) != 'undefined') {
			for (var i = 0; i < mmsNodes.length; i++) {
				mmsFlowJson += "{menuId:" + mmsNodes[i].id + "}";
				if (i < mmsNodes.length-1) {
					mmsFlowJson += ",";
				}
			}
		}
		mmsFlowJson +="]}";
		$.ajax({
			type : "POST",
			url : "addOperatorAuthorities.do",
			async:false,
			data : {
				"workFlowMenuJson" : workFlowJson,
				"mmsMenuJson" : mmsFlowJson,
				"userName":userName
			},
			success : function(data){
				$.messager.alert('消息', data.respCodeDesc, 'info');
				if("00"==data.respCode){
					history.go(-2);
				}
			}
		});
	}
</script>
</html>



