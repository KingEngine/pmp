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
<body >
	<div class="easyui-panel" style="width: 100%;">
	   <form id="addForm" name="addForm" method="post"> 
	     <table class="addTable">	
                <tr>
	                <td align="right" class="title_bold">操作员类型</td>
	            	<td align="left" nowrap="nowrap">
						<select id="roleType" name="roleType" class="easyui-combobox" 
						        data-options="valueField:'roleTypeCode',textField:'roleTypeDesc',
		                        url:'getOperatorRoleTypeSelectList.do',required:true">
						</select>
					</td>
				</tr>
				<tr>
	                <td align="right" class="title_bold">操作员名称</td>
	            	<td>
	                    <input type="text" name="userName" id ="userName" class="easyui-validatebox" data-options="required:true"/>
	                </td>
	            </tr>
	            <tr>
	                <td align="right" class="title_bold">操作员密码</td>
	            	<td>
	                    <input type="text" name="userPassword" id ="userPassword" class="easyui-validatebox" data-options="required:true"/>
	                </td>
	            </tr>
	            <tr>
	                <td align="right" class="title_bold">操作员确认密码</td>
	            	<td>
	                    <input type="text" name="userConfirmPassword" id ="userConfirmPassword" class="easyui-validatebox" data-options="required:true"/>
	                </td>
	            </tr>
				<tr>
	                <td align="right" class="title_bold">操作员状态</td>
	                <td align="left" nowrap="nowrap">
						<select id="status" name="status" class="easyui-combobox" 
						        data-options="valueField:'statusCode',textField:'statusDesc',
		                        url:'getOperatorStatusSelectList.do',required:true">
						</select>
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center">
		                <a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="ajaxSubmitDialogForm('addOperator.do','addForm','addOperatorDialog');">保存</a>
		                &nbsp;&nbsp;
		            	<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="$('#addForm').form('reset');">重置</a>
		            </td>
                </tr>
              </table>
		</form>  
	</div>
</body>
</html>



