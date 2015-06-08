<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <title>工作流当前任务查看</title>
       <meta http-equiv="pragma" content="no-cache"/>
       <meta http-equiv="cache-control" content="no-cache"/>
       <meta http-equiv="Expires" content="0"/>  
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css"/>
       <%@include file="../../resource.tag" %> 
       <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
	   <script type='text/javascript' src='<%=request.getContextPath()%>/js/views/workflow/RiskControlDepartment/risk_task_handler_pre.js'></script>	
</head>
<body style="overflow-x:hidden;" class="easyui-layout">
<div data-options="region:'north',title:'查询区',border:false" style="height:25%;">
   <form id="searchForm" name="searchForm" method="post"> 
     <table width="100%" class="searchTable">	
        <tr>
     	 <td class="title" align="right">任务类型</td>
     	 <td align="center">
           		<select id="taskType" name="taskType" class="easyui-combobox" 
				        data-options="valueField:'typeCode',textField:'typeDesc',
                        url:'getWorkFlowTaskTypeSelectList.do'">
				</select>
         </td>
         <td align="center" style="height: 30px" colspan="6">
        		<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="ajaxFormQueryForPage('searchForm','workFlowTaskQueryList.do','AAA','dataList','EEE',1);">查&nbsp;&nbsp;询</a>
				&nbsp;&nbsp;&nbsp;
				<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-undo'" onclick="$('#searchForm').form('reset');">重&nbsp;&nbsp;置</a>
         </td>
        </tr>
      </table>
	</form> 
	</div>
	<div data-options="region:'center',closed:true" id="AAA" style="width: 100%;">
		<table  class="easyui-datagrid" title="查询列表" style="width:100%;" align="center" id="dataList" data-options="singleSelect:true,pagination:true,pageSize:10">   
	          <thead>   
		        <tr>   
		            <th data-options="field:'innerMercode',align:'center'">电银商户号</th> 	
		            <th data-options="field:'merchantName',align:'center'">商户名称</th> 	
		            <th data-options="field:'merType',align:'center',formatter:formatterMerchantType">商户类别</th> 	
		            <th data-options="field:'processDefinitionName',align:'center'">任务类型</th> 	
		            <th data-options="field:'taskName',align:'center'">当前节点</th> 	
		            <th data-options="field:'innerMercode',align:'center'">商户拓展方</th> 	
		            <th data-options="field:'createTime',align:'center'">商户申请时间</th> 
		            <th data-options="field:'termNum',align:'center'">申请终端数</th> 
		            <th data-options="field:'merchantState',align:'center',formatter:formatterMerchantStatus">商户状态</th> 
		            <th data-options="field:'taskId',align:'center',formatter:formatterTaskId">操作</th> 
		        </tr>   
	          </thead>   
	     </table> 
     </div>
	<div id="EEE"></div>
	<div id="processImageDiv"></div> 
</body>
</html>