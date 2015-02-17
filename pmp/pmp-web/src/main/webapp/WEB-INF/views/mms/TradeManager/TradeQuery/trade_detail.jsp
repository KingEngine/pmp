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
</head>
<body>
	<table width="100%" class="showTable">
		<tr>
			<td class="title" align="left" width="17%">交易码名称</td>
			<td width="17%">xxx</td>
			<td class="title" align="left" width="17%">电银商户号</td>
			<td width="17%">xxx</td>
			<td class="title" align="left" width="17%">商户简称</td>
			<td width="15%">xxx</td>
		</tr>
		<tr>
			<td class="title" align="left">订单号</td>
			<td></td>
			<td class="title" align="left">交易金额</td>
			<td></td>
			<td class="title" align="left">扣款渠道</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">银联商户号</td>
			<td></td>
			<td class="title" align="left">银联终端号</td>
			<td></td>
			<td class="title" align="left">系统日期</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">电银交易编号</td>
			<td></td>
			<td class="title" align="left">清算批次号</td>
			<td></td>
			<td class="title" align="left">交易状态</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">银行对帐标志</td>
			<td></td>
			<td class="title" align="left">银行日期</td>
			<td></td>
			<td class="title" align="left">电银流水号</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">银联参考号</td>
			<td></td>
			<td class="title" align="left">银行返回代码</td>
			<td></td>
			<td class="title" align="left">是否冲正交易</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">冲正返回码</td>
			<td></td>
			<td class="title" align="left">冲正参考号</td>
			<td></td>
			<td class="title" align="left">银行卡号</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">终端编号</td>
			<td></td>
			<td class="title" align="left">手机/电话/用户/apn</td>
			<td></td>
			<td class="title" align="left">转出卡号</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">转入卡号</td>
			<td></td>
			<td class="title" align="left">入账机构号</td>
			<td></td>
			<td class="title" align="left">入账流水</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">入账商户号</td>
			<td></td>
			<td class="title" align="left">入账终端号</td>
			<td></td>
			<td class="title" align="left">入账金额</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">入账应答码</td>
			<td></td>
			<td class="title" align="left">入账参考号</td>
			<td></td>
			<td class="title" align="left">入账结果</td>
			<td></td>
		</tr>
		<tr>
			<td class="title" align="left">授权码</td>
			<td></td>
			<td class="title" align="left">商户渠道号</td>
			<td></td>
			<td class="title" align="left">商户渠道名称</td>
			<td></td>
		</tr>
		<tr>
		    <td colspan="6" align="center" >
		        <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'" onclick="$('#tradeDetailDialog').dialog('close');">关闭</a>
		</tr>
			
	</table>
</body>
</html>