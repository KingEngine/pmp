<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <title>当天交易查询</title>
       <meta http-equiv="pragma" content="no-cache"/>
       <meta http-equiv="cache-control" content="no-cache"/>
       <meta http-equiv="Expires" content="0"/>  
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/table.css"/>
       <%@include file="../../resource.tag" %> 
       <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
</head>

<script type="text/javascript">
	
	function formatterTradeState(value,row,index){
		if(value==2){
			return "成功";
		}else if(value==3){
			return "待处理";
		}else{
			return "失败";
		}
	}
	
	function formatterDeductReferWithColor(value,row,index) {
    	if(null != value && ''!= value){
    		var index = value.length-(value.length-6);
    		var strs1 = value.substring(0, index);
        	var strs = value.substring(index, value.length);
        	return strs1+"<font color='red'>"+strs+"</font>";
    	}
    	return '';
    }
	function formatterDeductRefer(value,row,index) {
		if(null != value && ''!= value){
    		var index = value.length-(value.length-6);
        	var strs = value.substring(index, value.length);
        	return strs;
    	}
    	return "";
    }
	
	function formatterPoitcde(value,row,index) {
		 if(value=="021"){
    		 return "刷卡有密码";
    	 }else if(value=="022"){
    		 return "刷卡无密码";
    	 }else if(value=="011"){
    		 return "手工输入卡号有密码";
    	 }else if(value=="012"){
    		 return "手工输入卡号无密码";
    	 }else if(value=="051"){
    		 return "IC卡有密码";
    	 }else if(value=="052"){
    		 return "IC卡无密码";
    	 }else{
    		 return "未知";
    	 }
    }
</script>

<body>
<div class="easyui-panel" style="width: 100%;">
   <form id="searchForm" name="searchForm" method="post"> 
     <table width="100%" border="0" cellspacing="0" class="tableBorder">	
        <tr>
     	 <td class="title" align="right">交易渠道:</td>
     	 <td align="center">
           <select id="tradeChannel" name="tradeChannel" class="easyui-combobox" style="width:200px;" 
                   data-options="valueField:'cid',textField:'chanAbbrev',
                   url:'getChannelSelectList.do',
                   onSelect:function(data){
	                   	var url = 'getTradeTypeSelectList.do?channelId='+data.cid;    
	                    $('#tradeType').combobox('reload', url);   
                   }
            "/>
         </td>
         <td class="title" align="right">交易类型:</td>
     	 <td align="center">
            <select id="tradeType" name="tradeType"  data-options="valueField:'tradeCode',textField:'tradeName'" class="easyui-combobox" style="width:200px;"/>  
         </td>
         <td class="title" align="right">交易状态:</td>
     	 <td align="center">
            <select id="tradeStatus" name="tradeStatus"  data-options="valueField:'statusKey',textField:'statusDesc',url:'getTradeStatusSelectList.do'" class="easyui-combobox" style="width:200px;"/>  
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">银行:</td>
     	 <td align="center">
           <select id="acqBank" name="acqBank"  data-options="valueField:'xpeSystemNum',textField:'acpBankName',url:'getAcqBankSelectList.do'" class="easyui-combobox" style="width:200px;"/>
         </td>
         <td class="title" align="right">银联商户号:</td>
     	 <td align="center">
            <select id="unionpayMerId" name="unionpayMerId"  data-options="" class="easyui-combobox" style="width:200px;"/>
         </td>
         <td class="title" align="right">扣款渠道:</td>
     	 <td align="center">
              
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">POS商户简称:</td>
     	 <td align="center">
          
         </td>
         <td class="title" align="right">电银商户号:</td>
     	 <td align="center">
            
         </td>
         <td class="title" align="right">增值交易商户号:</td>
     	 <td align="center">
              
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">终端编号:</td>
     	 <td align="center">
          
         </td>
         <td class="title" align="right">手机/电话/用户/APN:</td>
     	 <td align="center">
            
         </td>
         <td class="title" align="right">银行卡号:</td>
     	 <td align="center">
              
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">系统跟踪号:</td>
     	 <td align="center">
          
         </td>
         <td class="title" align="right">银联参考号:</td>
     	 <td align="center">
            
         </td>
         <td class="title" align="right">商户订单号:</td>
     	 <td align="center">
              
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">银行返回码:</td>
     	 <td align="center" colspan="5"></td>
        </tr>
        <tr>
        	<td align="center" style="height: 30px" colspan="6">
        		<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="ajaxPageQuery('searchForm','getCurrentTradePage.do','resultDiv','tableList',1);">查询</a>
				<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-undo'" onclick="$('#searchForm').form('reset');">重置</a>
        	</td>
        </tr>
      </table>
	</form> 
	</div>
	<div id="resultDiv" style="position: static;">
    <table class="easyui-datagrid" width='100%' id="tableList" data-options="pageSize:50,pagination:true,rownumbers:true,loadMsg:'加载中,请稍候...'">   
	          <thead>   
		        <tr>   
		            <th data-options="field:'tseq',align:'center'">电银交易编号</th> 	
					<th data-options="field:'xpepMercode',align:'center'">电银商户号</th>
					<th data-options="field:'abbrev',align:'center'">商户简称</th> 
					<th data-options="field:'oid',align:'center'">商户订单号</th>
					<th data-options="field:'xpepTrancode',align:'center'">交易类型</th>
					<th data-options="field:'amount',align:'center'">交易金额(元)</th>
					<th data-options="field:'tstat',align:'center',formatter:formatterTradeState">交易状态</th>
					<th data-options="field:'xpepOutcard',align:'center'">银行卡号</th>
					<th data-options="field:'gate',align:'center'">扣款渠道</th>
					<th data-options="field:'sysDate',align:'center'">系统时间</th>
					<th data-options="field:'xpeDeductTrace',align:'center'">电银流水号</th>
					<th data-options="field:'terminalNumber',align:'center'">终端编号</th>
					<th data-options="field:'xpepTermId',align:'center'">手机/电话/用户/apn</th>
					<th data-options="field:'xpeDeductRefer',align:'center',formatter:formatterDeductReferWithColor">银联参考号</th>
					<th data-options="field:'bankFee',align:'center'">银行手续费</th>
					<th data-options="field:'xpeDeductRefer',align:'center',formatter:formatterDeductRefer">系统跟踪号</th>
					<th data-options="field:'xpepAuthCode',align:'center'">授权码</th>
					<th data-options="field:'xpepPoitcde',align:'center',formatter:formatterPoitcde">卡密信息</th>
					<th data-options="field:'gisaddr',align:'center'">基站地址</th>
					<th data-options="field:'installAddress',align:'center'">POS装机地址</th>
					<th data-options="field:'installAddress',align:'center'">失败原因</th>
		        </tr>   
	          </thead>   
     </table> 
     </div>
	<div id="ERROR_DIV"></div>
</body>
</html>