<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <title>商户信息查看</title>
       <meta http-equiv="pragma" content="no-cache"/>
       <meta http-equiv="cache-control" content="no-cache"/>
       <meta http-equiv="Expires" content="0"/>  
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css"/>
       <%@include file="../resource.tag" %> 
       <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
	   <script type='text/javascript' src='<%=request.getContextPath()%>/js/views/workflow/merinfo_query_pre.js'></script>	
</head>
<body style="overflow-x:hidden;">
<div class="easyui-panel" style="width: 100%;" title="查询区">
   <form id="searchForm" name="searchForm" method="post"> 
     <table width="100%" class="searchTable">	
        <tr>
     	 <td class="title" align="right">商户名称&nbsp;&nbsp;</td>
     	 <td align="center">
           <input type="text" name="name" id="name"/>
         </td>
         <td class="title" align="right">电银商户号&nbsp;&nbsp;</td>
     	 <td align="center">
           <input type="text" class="easyui-numberbox"/>
         </td>
         <td class="title" align="right">商户类别&nbsp;&nbsp;</td>
     	 <td align="center">
           <select id="merType" name="merType" class="easyui-combobox" 
				        data-options="valueField:'typeCode',textField:'typeDesc',
                        url:'getMerchantTypeSelectList.do'">
			</select>
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">任务类型&nbsp;&nbsp;</td>
     	 <td align="center">
           <input type="text" name="name" id="name"/>
         </td>
        </tr>
        <tr>
        	<td align="center" style="height: 30px" colspan="6">
        		<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="ajaxFormQueryForPage('searchForm','queryMerInfoForPage.do','AAA','dataList','EEE',1);">查询</a>
				<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-undo'" onclick="$('#searchForm').form('reset');">重置</a>
        	</td>
        </tr>
      </table>
	</form> 
	</div>
	<div class="easyui-panel" style="width:100%;" id="AAA">
		<table  class="easyui-datagrid" title="查询列表" style="width:100%;" align="center" id="dataList" data-options="singleSelect:true,pagination:true,pageSize:10">   
	          <thead>   
		        <tr>   
		            <th data-options="field:'innerMerCode',align:'center'">电银商户号</th> 	
		            <th data-options="field:'name',align:'center'">商户名称</th> 
		            <th data-options="field:'merType',align:'center',formatter:formatterMerchantType_">商户类别</th> 	
		            <th data-options="field:'taskName',align:'center'">任务类型</th> 	
		            <th data-options="field:'taskName',align:'center'">当前节点名称</th> 	
		            <th data-options="field:'taskName',align:'center'">商户拓展方</th> 	
		            <th data-options="field:'taskName',align:'center'">商户申请时间</th> 	
		            <th data-options="field:'taskName',align:'center'">申请终端数</th> 	
		            <th data-options="field:'taskName',align:'center'">备注</th> 	
		           	
	
		        </tr>   
	          </thead>   
	     </table> 
     </div>
	<div id="EEE"></div>
	<div id="processImageDiv"></div> 
</body>
</html>