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
       <%@include file="../../../resource.tag" %> 
       <script type='text/javascript' src='<%=request.getContextPath()%>/js/common.js'></script>
       <script type='text/javascript' src='<%=request.getContextPath()%>/js/views/mms/TradeManager/TradeQuery.js'></script>
</head>
<body style="overflow-x:hidden;">
<div class="easyui-panel" style="width: 100%;" title="查询区">
   <form id="searchForm" name="searchForm" method="post"> 
     <table width="100%" class="searchTable">	
        <tr>
     	 <td class="title" align="right">交易渠道&nbsp;&nbsp;</td>
     	 <td align="center">
           <select id="tradeChannel" name="tradeChannel" class="easyui-combobox"
                   data-options="valueField:'cid',textField:'chanAbbrev',
                   url:'getMerchantTypeSelectList.do'"/>
         </td>
         <td class="title" align="right">交易类型&nbsp;&nbsp;</td>
     	 <td align="center">
            <select id="tradeType" name="tradeType"  data-options="valueField:'tradeCode',textField:'tradeName'" class="easyui-combobox"/>  
         </td>
         <td class="title" align="right">交易状态&nbsp;&nbsp;</td>
     	 <td align="center">
            <select id="tradeStatus" name="tradeStatus"  data-options="valueField:'statusKey',textField:'statusDesc',url:'getTradeStatusSelectList.do'" class="easyui-combobox" />  
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">银行&nbsp;&nbsp;</td>
     	 <td align="center">
           <select id="acqBank" name="acqBank"  data-options="valueField:'xpeSystemNum',textField:'acpBankName',url:'getAcqBankSelectList.do'" class="easyui-combobox" />
         </td>
         <td class="title" align="right">银联商户号&nbsp;&nbsp;</td>
     	 <td align="center">
           <input type="text" name="unionpayMerId"/>
         </td>
         <td class="title" align="right">扣款渠道&nbsp;&nbsp;</td>
     	 <td align="center">
              <select id="deductChannel" name="deductChannel"  data-options="valueField:'deductChannelId',textField:'deductChannelName',url:'getDeductChannelSelectList.do'" class="easyui-combobox" style="width:200px;"/>
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">POS商户简称&nbsp;&nbsp;</td>
     	 <td align="center">
              <input type="text" name="posMerAbbrev"/>
         </td>
         <td class="title" align="right">电银商户号&nbsp;&nbsp;</td>
     	 <td align="center">
              <input type="text" id="innerMerCode" name="innerMerCode"/>
         </td>
         <td class="title" align="right">增值交易商户号&nbsp;&nbsp;</td>
     	 <td align="center">
              <input type="text" id="incrementMerCode" name="incrementMerCode"/>
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">终端编号&nbsp;&nbsp;</td>
     	 <td align="center">
             <input type="text" name="terminalNum"/>
         </td>
         <td class="title" align="right">手机/电话/用户/APN&nbsp;&nbsp;</td>
     	 <td align="center">
             <input type="text" name="phoneOrOthers"/>
         </td>
         <td class="title" align="right">银行卡号&nbsp;&nbsp;</td>
     	 <td align="center">
              <input type="text" name="bankCard"/>
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">系统跟踪号&nbsp;&nbsp;</td>
     	 <td align="center">
             <input type="text" name="systemFollowNum"/>
         </td>
         <td class="title" align="right">银联参考号&nbsp;&nbsp;</td>
     	 <td align="center">
             <input type="text" name="bkSeq"/>
         </td>
         <td class="title" align="right">商户订单号&nbsp;&nbsp;</td>
     	 <td align="center">
               <input type="text" name="oid"/>
         </td>
        </tr>
        <tr>
     	 <td class="title" align="right">银行返回码&nbsp;&nbsp;</td>
     	 <td align="center">
     	 	  <input type="text" id="xpeDeductResp" maxlength="2"/>
     	 </td>
     	 <td colspan="4"></td>
        </tr>
        <tr>
        	<td align="center" style="height: 30px" colspan="6">
        		<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'" onclick="ajaxFormQueryForPage('searchForm','getCurrentTradePage.do','AAA','dataList','EEE',1);">查询</a>
				<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-undo'" onclick="$('#searchForm').form('reset');">重置</a>
        	</td>
        </tr>
      </table>
	</form> 
	</div>
	<div class="easyui-panel" style="width:100%;" id="AAA">
		<table  class="easyui-datagrid" style="width: 100%;" title="查询列表" align="center" id="dataList" data-options="fitColumns:true,singleSelect:true,pagination:true,pageSize:50,showFooter:true">   
		          <thead>   
			        <tr>   
			            <th data-options="field:'tseq',align:'center',formatter:formatterTseq">电银交易编号</th> 	
						<th data-options="field:'xpepMercode',align:'center'">电银商户号</th>
						<th data-options="field:'abbrev',align:'center'">商户简称</th> 
						<th data-options="field:'oid',align:'center'">商户订单号</th>
						<th data-options="field:'xpepTrancode',align:'center',formatter:formatterTradeType">交易类型</th>
						<th data-options="field:'amount',align:'center'">交易金额(元)</th>
						<th data-options="field:'tstat',align:'center',formatter:formatterTradeState">交易状态</th>
						<th data-options="field:'xpepOutcard',align:'center'">银行卡号</th>
						<th data-options="field:'gate',align:'center',formatter:formatterDeductChannel">扣款渠道</th>
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
	<div id="EEE"></div>
	<div id="tradeDetailDialog"></div> 
</body>
</html>