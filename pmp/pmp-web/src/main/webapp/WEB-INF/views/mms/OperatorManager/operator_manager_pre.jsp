<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>操作员管理</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css"/>
    <%@include file="../../resource.tag" %> 
    <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/js/views/mms/OperatorManager/operator_manager_pre.js'></script>
</head>
<body class="easyui-layout" data-options="border:false">
	<div data-options="region:'north',title:'查询区',border:false" style="height:18%;">
		<form id="searchForm" name="searchForm" method="post"> 
	     <table class="searchTable">	
                <tr>
	                <td align="right" class="title">操作员名称&nbsp;&nbsp;</td>
	            	<td>
	                    <input class="easyui-validatebox" type="text" name="userName" id ="userName"/>
	                </td>
	                <td align="right" class="title">操作员状态&nbsp;&nbsp;</td>
	            	<td>
	                    <input class="easyui-validatebox" type="text" name="status" id ="status"/>
	                </td>
	              </tr>
	              <tr>
	                <td colspan="4" align="center">
		                <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="ajaxFormQueryForPage('searchForm','queryOperatorsForPage.do','AAA','dataList','EEE',1);">查询</a>
		                &nbsp;&nbsp;
		                 <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="showDialogWithOutParameter('getOperatorAddPre.do','操作员新增',500,'addOperatorDialog');">新增</a>
		                &nbsp;&nbsp;
		                <a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="$('#searchForm').form('reset');">重置</a>
		            </td>
                </tr>
              </table>
		</form>  
	</div>   
    <div data-options="region:'center',closed:true,border:false" id="AAA" style="width: 100%;">   
        <table class="easyui-datagrid" title="查询列表" width="100%" id="dataList" data-options="singleSelect:true,pagination:true,pageSize:10,rownumbers:true,fitColumns:true">   
	        <thead>   
		        <tr>   
		        	<th data-options="field:'userName',align:'center'">用户名</th> 	
		        	<th data-options="field:'id',align:'center',formatter:formatterOperation">操作</th> 	
		        </tr>
		     </thead>
	    </table>
    </div>  
	 <div id="addOperatorDialog"></div>
</body>
</html>



