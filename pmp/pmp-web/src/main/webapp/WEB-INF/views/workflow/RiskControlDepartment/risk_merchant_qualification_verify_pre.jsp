<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="../../tag.tag"%>
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
	<div class="easyui-panel" style="width: 98.5%;overflow-x:hidden;" title="">
	   <form id="addForm" name="addForm" method="post">
	    <input type="hidden" name="taskId" id="taskId" value="${taskId}"/> 
	    <table width="100%" class="addTable">	
	        <tr>
	        	<td colspan="6" bgcolor="#C0C9E0" align="center">商户基本信息</td>
	        </tr>
	        <tr>
			    <td class="title" align="right" nowrap="nowrap" width="10%">商户类别</td>
				<td align="left" nowrap="nowrap" width="20%">
					${merTypeDesc}
				</td>
				<td class="title" align="right" nowrap="nowrap" width="17%">商户名称</td>
				<td align="left" nowrap="nowrap" width="23%">
					${name}
				</td>
				<td class="title" align="right" nowrap="nowrap" width="18%">商户简称</td>
				<td align="left" nowrap="nowrap" width="22%">
					${abbrev}
				</td>
			</tr>
			<tr>
				<td class="title" align="right">公司类型</td>
				<td align="left">
					${companyTypeDesc}
				</td>
				<td class="title" align="right">商户经营名称</td>
				<td>
					${merManagerName}
				</td>
				<td class="title" align="right">营业执照号</td>
				<td align="left">
					${businessLicense}
				</td>
			</tr>
			<tr>
				<td class="title" align="right">注册资本</td>
				<td>
					${regCapital}
				</td>
				<td class="title" align="right">注册地址</td>
				<td>
					${regAddress}
				</td>
				<td class="title" align="right">营业执照有效期</td>
				<td align="left">
					${busStartDate}
					至
					${busEndDate}
				</td>
			</tr>
			<tr>
				<td class="title" align="right">经营范围</td>
				<td colspan="5">
					${operateScope}
				</td>
			</tr>
			<tr>
				<td class="title" align="right" nowrap="nowrap">法人/经营者姓名</td>
		       	<td align="left"> 
		       		${corpName}
		       	</td>
		        <td class="title" align="right">证件类型|号码</td>
				<td align="left">
					${idType}
					${idNo}
				</td>
				<td class="title" align="right">证件有效期</td>
				<td align="left">
					${credentialsStartDate}
					至
					${credentialsEndDate}
				</td>
			</tr>
			<tr>
				<td class="title" align="right">所在省份</td>
				<td align="left" colspan="5" >
					${provId}
				</td>
			</tr>
			<tr>
			    <td class="title" align="right">办公地址</td>
				<td align="left">
					${address}
				</td>
			    <td class="title" align="right">传真号码</td>
				<td colspan="3">
					${faxNo}
				</td>
			</tr>
			<tr>
			    <td class="title" align="right">日常联系人</td>
				<td>
					${contact0}
				</td>
			    <td class="title" align="right">联系电话</td>
				<td>
					${tel0}
				</td>
				<td class="title" align="right">邮政邮编</td>
				<td align="left">
					${zip}
				</td>
			</tr>
			<tr> 
				<td class="title" align="right">E-mail</td>
				<td>
					${email0}${aa}
				</td>
				<td class="title" align="right">合同日期</td>
				<td align="left">
					${beginDate}
					至
					${expDate}
				</td>
				<td class="title" align="right">备注</td>
				<td align="left">
					${remark}
				</td>
			</tr>
			<tr>
				<td colspan="6" bgcolor="#C0C9E0" align="center">商户结算信息</td>
			</tr>
			<tr>
				<td class="title" align="right" nowrap="nowrap">结算账户名称</td>
				<td align="left">
					${bankAcctName}
				</td>
				<td class="title" align="right">结算银行名称(精确到支行)</td>
				<td align="left">
					${bankBranch}
				</td>
				<td class="title" align="right">结算银行联行号(精确到支行)</td>
				<td align="left">
					${openBkNo}
				</td>
			</tr>
			<tr>
				<td class="title" align="right">结算银行账号</td>
				<td align="left">
					${bankAcct}
				</td>
				<td class="title" align="right">电银结算账号</td>
				<td align="left">
					
				</td>
				<td class="title" align="right">商户结算周期</td>
				<td align="left" width="27%">
					
				</td>
			</tr>
			<tr>
				<td class="title" align="right">商户保证金(元)</td>
				<td align="left">
					${cautionMoney}
				</td>
				<td class="title" align="right">商户服务费(元)</td>
				<td align="left">
					${beginFee}
				</td>
				<td class="title" align="right">商户年费(元)</td>
				<td align="left" >
					${annualFee}
				</td>
			</tr>
			<tr>
				<td colspan="6" bgcolor="#C0C9E0" align="center">商户申请信息</td>
			</tr>
			<tr>
				<td class="title" align="right">商户所属行业</td>
				<td align="left">
					 ${merTradeType}
				</td>
				<td class="title" align="right" >交易手续费：</td>
				<td align="left">
					
				</td>
				<td class="title" align="right">签约人</td>
				<td align="left">
					${signagory}
				</td>
			</tr>
			<tr>
				<td class="title" align="right">商户拓展方</td>
				<td align="left" colspan="5" >
					${merProlongation}
				</td>
			</tr>
		    <tr>
			    <td colspan="6">
			     <table class="addTable" width="100%" id="termList">
			     <c:forEach items="${termList}" var="item">
				     <tr id="termListTr_0">
						<td class="title" align="right" width="9%">申请终端地址</td>
						<td align="left" width="17%">
							${item.termAddAddress}
						</td>
						<td class="title" align="right" width="7%">终端类型</td>
						<td align="left" width="20%">
							${item.termType}
						</td>
						<td class="title" align="right" width="8%">终端方式</td>
						<td align="left" width="11%">
							${item.posType}
						</td>
						<td class="title" align="right" width="12%">申请终端数量</td>
						<td align="left" width="4%">
							${item.askForNumber}
						</td>
				       </tr>
			     </c:forEach>
				  
	          </table>
	        </td>
	    </tr>
	    <tr>
			<td colspan="6" bgcolor="#C0C9E0" align="center">上传资料</td>
		</tr>
		<c:forEach items="${merPhotoInfoList}" var="item">
			<tr>
				<td class="title" align="right" width="10%">商户资料</td>
				<td colspan="5">
				   <a href="#" title="点击下载" class="easyui-tooltip">${item.photoUrl}</a>
				 </td>
		    </tr>
		</c:forEach>
		<tr>
			<td colspan="6" bgcolor="#C0C9E0" align="center">审批意见</td>
		</tr>
		<tr>
			<td class="title" align="right" colspan="2">初审意见</td>
			<td>
				<select id="suggestion" class="easyui-combobox" 
				  data-options="
					  valueField: 'value',textField: 'label',
					  data: [{label: '同意',value: 'agree'},{label: '不同意',value: 'disagree'}],
					  onSelect:function(rec){
					  	  if(rec.value=='agree'){
					  	  	  $('#rejectReasonTitle').hide();
					  	  	  $('#rejectReasonChoose').hide();
					  	  	  $('#merchantRiskLevelTitle').show();
					  	  	  $('#merchantRiskLevelChoose').show();
					  	  }else{
					  	  	  $('#rejectReasonTitle').show();
					  	  	  $('#rejectReasonChoose').show();
					  	  	  $('#merchantRiskLevelTitle').hide();
					  	  	  $('#merchantRiskLevelChoose').hide();
					  	  }
					  }
				  ">
				</select>
			</td>
			<td class="title" align="right" colspan="2" id="merchantRiskLevelTitle">商户风险级别</td>
			<td id="merchantRiskLevelChoose">
				<select id="merRiskType" name="merRiskType" class="easyui-combobox" 
				        data-options="valueField:'levelCode',textField:'levelDesc',
                        url:'getMerchantRiskLevelSelectList.do'">
				</select>
			</td>
			<td class="title" align="right" colspan="2" style="display: none" id="rejectReasonTitle">驳回原因</td>
			<td id="rejectReasonChoose" style="display: none">
				<select id="rejectReason" name="rejectReason" class="easyui-combobox" 
				        data-options="valueField:'levelCode',textField:'levelDesc',
                        url:'getMerchantRiskLevelSelectList.do'">
				</select>
			</td>
		</tr>
		<tr>
			<td class="title" align="right" colspan="2">商户交易卡种限制</td>
			<td colspan="4" align="left">
				<label for="debitCard"><input type="checkbox" value="D" name="cardType" id="debitCard"/>借记卡</label>
				<label for="creditCard"><input type="checkbox" value="C" name="cardType" id="creditCard"/>信用卡</label>
			</td>
		</tr>
		<tr>
			<td class="title" align="right" colspan="2">单笔交易限额(借记卡)(元)</td>
			<td align="left">
				<input class="easyui-numberbox" name="singleTradeDLimit"/> 
			</td>
			<td class="title" align="right" colspan="2">交易日限额(借记卡)(元)</td>
			<td align="left">
				<input class="easyui-numberbox" name="tradeDDayLimit"/> 
			</td>
		</tr>
		<tr>
			<td class="title" align="right" colspan="2">单笔交易限额(信用卡)(元)</td>
			<td align="left">
				<input class="easyui-numberbox" name="singleTradeCLimit"/> 
			</td>
			<td class="title" align="right" colspan="2">交易日限额(信用卡)(元)</td>
			<td align="left">
				<input class="easyui-numberbox" name="tradeCDayLimit"/> 
			</td>
		</tr>
		<tr>
			<td class="title" align="right" colspan="2">同卡号日交易次数限制(信用卡)(次)</td>
			<td align="left">
				<input class="easyui-numberbox" name="singleTradeDLimit"/> 
			</td>
			<td class="title" align="right" colspan="2">同卡号日交易次数限制(借记卡)(次)</td>
			<td align="left">
				<input class="easyui-numberbox" name="singleTradeCLimit"/> 
			</td>
		</tr>
		<tr>
			<td class="title" align="right" colspan="2">备注</td>
			<td align="left" colspan="4">
				<input class="easyui-textbox" style="width:100%;"></input>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="6">
			    <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-ok'" onclick="ajaxSubmitForm('setMerchantRiskInfo.do','addForm');">确定</a>
			    &nbsp;&nbsp;
			    <a href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'">取消</a>
			</td>
		</tr>
      </table>
	 </form>
	</div>
</body>
</html>