<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <title>商户申请资料录入</title>
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
     <table width="100%" class="addTable">	
        <tr>
        	<td class="title_weight" colspan="6">POS商户信息录入</td>
        </tr>
        <tr>
        	<td colspan="6" bgcolor="#C0C9E0" align="center">商户基本信息</td>
        </tr>
        <tr>
		    <td class="title" align="right" nowrap="nowrap" width="10%">商户类别&nbsp;&nbsp;&nbsp;</td>
			<td align="left" nowrap="nowrap" width="20%">
				<select id="merType" name="merType" class="easyui-combobox" 
				        data-options="valueField:'typeCode',textField:'typeDesc',
                        url:'getMerchantTypeSelectList.do',required:true">
				</select>
			</td>
			<td class="title" align="right" nowrap="nowrap" width="17%">商户名称&nbsp;&nbsp;&nbsp;</td>
			<td align="left" nowrap="nowrap" width="23%">
				<input type="text" id="name" name="name" maxlength="40" class="easyui-validatebox" data-options="required:true"/>
			</td>
			<td class="title" align="right" nowrap="nowrap" width="18%">商户简称&nbsp;&nbsp;&nbsp;</td>
			<td align="left" nowrap="nowrap" width="22%">
				<input type="text" id="abbrev" name="abbrev" class="easyui-validatebox" data-options="required:true"/>
			</td>
		</tr>
		<tr>
			<td class="title" align="right">公司类型&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<select id="companyType" name="companyType" class="easyui-combobox" 
				        data-options="valueField:'typeCode',textField:'typeDesc',
                        url:'getCompanyTypeSelectList.do',required:true">
				</select>
			</td>
			<td class="title" align="right">商户经营名称&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="text" id="merManagerName" name="merManagerName" class="easyui-validatebox" data-options="required:true"/>
			</td>
			<td class="title" align="right">营业执照号&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="businessLicense" name="businessLicense" maxlength="30" class="easyui-validatebox" data-options="required:true"/>
			</td>
		</tr>
		<tr>
			<td class="title" align="right">注册资本&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="text" id="regCapital" name="regCapital" maxlength="9" class="easyui-numberbox easyui-validatebox" data-options="required:true" />
			</td>
			<td class="title" align="right">注册地址&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="text" id="regAddress" name="regAddress" maxlength="50" class="easyui-validatebox" data-options="required:true"/>
			</td>
			<td class="title" align="right">营业执照有效期&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="busStartDate" name="busStartDate" class="easyui-datebox" required="required" style="width: 45%;"></input>
				至
				<input type="text" id="busEndDate" name="busEndDate" class="easyui-datebox" required="required" style="width: 45%;"></input>
			</td>
		</tr>
		<tr>
			<td class="title" align="right">经营范围&nbsp;&nbsp;&nbsp;</td>
			<td colspan="5">
				<input type="text" id="operateScope" name="operateScope" maxlength="30" class="easyui-validatebox" data-options="required:true"/>
			</td>
		</tr>
		<tr>
			<td class="title" align="right" nowrap="nowrap">法人/经营者姓名&nbsp;&nbsp;&nbsp;</td>
	       	<td align="left"> 
	       		<input id="corpName" name="corpName" type="text" maxlength="30" class="easyui-validatebox" data-options="required:true"/>
	       	</td>
	        <td class="title" align="right">证件类型|号码&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<select id="idType" name="idType" class="easyui-combobox" 
				        data-options="valueField:'typeCode',textField:'typeDesc',
                        url:'getCertificateTypeSelectList.do',required:true" style="width: 50%;">
				</select>
				<input id="idNo" name="idNo" class="easyui-validatebox" data-options="required:true" style="width: 100px;" maxlength="30"/>
			</td>
			<td class="title" align="right">证件有效期&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="credentialsStartDate" name="credentialsStartDate" class="easyui-datebox" required="required" style="width: 45%;"></input>
				至
				<input type="text" id="credentialsEndDate" name="credentialsEndDate" class="easyui-datebox" required="required" style="width: 45%;"></input>
			</td>
		</tr>
		<tr>
			<td class="title" align="right">所在省份&nbsp;&nbsp;&nbsp;</td>
			<td align="left" colspan="5" >
				<select id="provId" name="provId" class="easyui-combobox" 
				        data-options="valueField:'areaCode',textField:'areaName',
				        url:'getAreaSelectList.do?parentAreaCode=0',
				        onSelect: function(rec){    
				        			 $('#cityId').combobox('clear');
				        			 $('#countyId').combobox('clear');
            						 var url = 'getAreaSelectList.do?parentAreaCode='+rec.areaCode;    
           							 $('#cityId').combobox('reload', url);    
        						},
        				 required:true
				        ">
				</select>
				<select id="cityId" name="cityId" class="easyui-combobox" 
						data-options="valueField:'areaCode',textField:'areaName',
						onSelect: function(rec){   
									 $('#countyId').combobox('clear');
            						 var url = 'getAreaSelectList.do?parentAreaCode='+rec.areaCode;    
           							 $('#countyId').combobox('reload', url);    
        				}">
        		</select>
        		<select id="countyId" name="countyId" class="easyui-combobox" data-options="valueField:'areaCode',textField:'areaName'">
        		</select>
			</td>
		</tr>
		<tr>
		    <td class="title" align="right">办公地址&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="address" maxlength="80" class="easyui-validatebox" data-options="required:true"/>
			</td>
		    <td class="title" align="right">传真号码&nbsp;&nbsp;&nbsp;</td>
			<td colspan="3">
				<input type="text" id="faxNo" maxlength="50" class="easyui-validatebox" data-options="required:true"/>
			</td>
		</tr>
		<tr>
		    <td class="title" align="right">日常联系人&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="text" id="contact0" maxlength="50" class="easyui-validatebox" data-options="required:true"/>
			</td>
		    <td class="title" align="right">联系电话&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="text" id="tel0" maxlength="50" class="easyui-numberbox easyui-validatebox" data-options="required:true"/>
			</td>
			<td class="title" align="right">邮政邮编&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="zip"  maxlength="6" class="easyui-numberbox easyui-validatebox"/>
			</td>
		</tr>
		<tr> 
			<td class="title" align="right">E-mail&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="text" id="email0" maxlength="50"/>
			</td>
			<td class="title" align="right">合同日期&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="beginDate" name="beginDate" class="easyui-datebox" required="required" style="width: 45%;"></input>
				至
				<input type="text" id="expDate" name="expDate" class="easyui-datebox" required="required" style="width: 45%;"></input>
			</td>
			<td class="title" align="right">备注&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="remark" maxlength="50"/>
			</td>
		</tr>
		<tr>
			<td colspan="6" bgcolor="#C0C9E0" align="center">商户结算信息</td>
		</tr>
		<tr>
			<td class="title" align="right" nowrap="nowrap">结算账户名称&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="bankAcctName" name="bankAcctName" maxlength="50" class="easyui-validatebox" data-options="required:true"/>
			</td>
			<td class="title" align="right">结算银行名称(精确到支行)&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="bankBranch" name="bankBranch" class="easyui-validatebox" data-options="required:true"/>
			</td>
			<td class="title" align="right">结算银行联行号(精确到支行)&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="openBkNo" name="openBkNo" class="easyui-validatebox" data-options="required:true" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td class="title" align="right">结算银行账号&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="bankAcct"maxlength="23" class="easyui-validatebox easyui-numberbox" data-options="required:true"/>
			</td>
			<td class="title" align="right">电银结算账号&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="dianyinSettleId" class="easyui-validatebox easyui-numberbox" data-options="required:true"/>
			</td>
			<td class="title" align="right">商户结算周期&nbsp;&nbsp;&nbsp;</td>
			<td align="left" width="27%">
				<select id="settleAccountDay" name="settleAccountDay" class="easyui-combobox" 
				        data-options="valueField:'balanceCode',textField:'balanceCodeDesc',
                        url:'getBalanceAccountTypeList.do',required:true">
				</select>
			</td>
		</tr>
		<tr>
			<td class="title" align="right">商户保证金(元)&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="cautionMoney" class="easyui-validatebox easyui-numberbox" data-options="required:true"/>
			</td>
			<td class="title" align="right">商户服务费(元)&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="beginFee" class="easyui-validatebox easyui-numberbox" data-options="required:true"/>
			</td>
			<td class="title" align="right">商户年费(元)&nbsp;&nbsp;&nbsp;</td>
			<td align="left" >
				<input type="text" id="annualFee" class="easyui-validatebox easyui-numberbox" data-options="required:true"/>
			</td>
		</tr>
		<tr>
			<td colspan="6" bgcolor="#C0C9E0" align="center">商户申请信息</td>
		</tr>
		<tr>
			<td class="title" align="right">商户所属行业&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				 <select id="merTradeType" name="merTradeType" class="easyui-combobox" 
				        data-options="valueField:'tradeCode',textField:'tradeCodeDesc',
                        url:'getMerchantTradeTypeList.do',required:true">
				</select>
			</td>
			<td class="title" align="right" >交易手续费：&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
					<input type="text" id="deduct_discount" class="easyui-validatebox easyui-numberbox" data-options="required:true" style="width: 70%"></input>
					<a onclick="showDiscountFeeDetailDialog('deductDiscountDetailDialog')"><font color="blue">查看公式</font></a>
			</td>
			<td class="title" align="right">签约人&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<input type="text" id="signagory" class="easyui-validatebox" data-options="required:true"/>
			</td>
		</tr>
		<tr>
			<td class="title" align="right">商户拓展方&nbsp;&nbsp;&nbsp;</td>
			<td align="left" colspan="5" >
			</td>
		</tr>
	    <tr>
		    <td colspan="6">
		     <table class="addTable" width="100%">
			  <tr>
				<td class="title" align="right" width="10%">申请终端地址&nbsp;&nbsp;&nbsp;</td>
				<td align="left" width="18%">
					<input type="text" id="term_add_address" name='term_add_address' maxlength="30" style="width: 95%;"/>
				</td>
				<td class="title" align="right" width="7%">终端类型&nbsp;&nbsp;&nbsp;</td>
				<td align="left" width="12%">
					<select class="easyui-combobox" style="width: 100%;"></select>
				</td>
				<td class="title" align="right" width="10%">终端方式&nbsp;&nbsp;&nbsp;</td>
				<td align="left" width="12%">
					<select class="easyui-combobox" style="width: 100%;"></select>
				</td>
				<td class="title" align="right" width="10%">申请终端数量&nbsp;&nbsp;&nbsp;</td>
				<td align="left" width="10%">
					<input type="text" class="easyui-numberbox easyui-validatebox" style="width: 95%;"/>
				</td>
				<td>
					<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-add'" >添加</a>
					<a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'" >删除</a>
				</td>
		       </tr>
	          </table>
	        </td>
	    </tr>
	    <tr>
			<td colspan="6" bgcolor="#C0C9E0" align="center">上传资料</td>
		</tr>
		<tr>
			<td class="title" align="right" width="10%">商户资料&nbsp;&nbsp;&nbsp; </td>
			<td align="left"  colspan="5">
				<input class="easyui-filebox" data-options="buttonText:'请选择文件',required:true"></input>
			</td>
		</tr>
		<tr>
			<td colspan="6"  align="center">
			    <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-filesave'" onclick="ajaxSubmitForm('addForm','fillMerchantInfo.do',false)">保存</a>
			    &nbsp;&nbsp;
			    <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-ok'">保存并提交</a>
			    &nbsp;&nbsp;
			    <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-back'">返回</a>
			</td>
		</tr>
      </table>
	</form> 
</div>
<div id="deductDiscountDetailDialog"></div> 
</body>
</html>