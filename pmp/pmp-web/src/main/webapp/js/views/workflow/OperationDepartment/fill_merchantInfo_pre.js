/**
 * 运行部门js
 */

function cloneTr(){  
	 var termListId = $("#termList tr:last").attr("id");
	 var termId = termListId.split("_")[1];
	 var id = parseInt(termId);
	 id+=1;
	 var trId='termListTr_'+id;
	 var tr="<tr id='"+trId+"'>";
	 tr+="<td class='title' align='right'>申请终端地址</td>";
	 tr+="<td align='left'>";
	 tr+="<input type='text' name='termAddAddress'  class='easyui-validatebox' data-options='required:true'/>";
	 tr+="</td>";
	 tr+="<td class='title' align='right'>终端类型</td>";
	 tr+="<td align='left'>";
	 tr+="<select name='termType' class='easyui-combobox easyui-validatebox' style='width: 100%;'"; 
     tr+="data-options=\"valueField:'typeCode',textField:'typeDesc',url:'getTerminalTypeSelectList.do',required:true\"></select>";
	 tr+="</td>";
	 tr+="<td class='title' align='right'>终端方式</td>";
	 tr+="<td align='left'>";
	 tr+="<select name='posType' class='easyui-combobox easyui-validatebox' style='width: 100%;'";
	 tr+="data-options=\"valueField:'modeCode',textField:'modeDesc',url:'getTerminalModeSelectList.do',required:true\"></select>";
	 tr+="</td>";
	 tr+="<td class='title' align='right'>申请终端数量</td>";
	 tr+="<td align='left'>";
	 tr+="<input type='text' name='askForNumber' class='easyui-numberbox easyui-validatebox' style='width: 100%;' data-options='required:true'/>";
	 tr+="</td>";
	 tr+="<td>";
	 tr+="<a class='easyui-linkbutton easyui-tooltip' data-options=\"iconCls:'icon-add'\" title='添加一行' onclick='cloneTr();'>添加</a>";
	 tr+="<a class='easyui-linkbutton' data-options=\"iconCls:'icon-cancel'\" title='' onclick=\"deleteTr('"+trId+"');\">删除</a>";
	 tr+="</td>";
	 tr+="</tr>";
	 $("#termList tr:last").after(tr);
	 $.parser.parse('#'+trId);
}  

function deleteTr(obj){  
	$('#'+obj).remove();
}
/**
 * 保存方法
 * @returns
 */
function saveMerInfo() {
	try {

		var validate = $('#addForm').form("validate");
		if (!validate) {
			return;
		}
		var array = new Array();
		// 申请终端地址
		var termAddAddresses = document.getElementsByName("termAddAddress");
		// 终端类型
		var termTypes = document.getElementsByName("termType");
		// 终端方式
		var posTypes = document.getElementsByName("posType");
		// 申请数量
		var askForNumbers = document.getElementsByName("askForNumber");
		for (var i = 0; i < termAddAddresses.length; i++) {
			var askForTerm = new Object();
			askForTerm.termAddAddress = termAddAddresses[i].value;
			askForTerm.termType = termTypes[i].value;
			askForTerm.posType = posTypes[i].value;
			askForTerm.askForNumber = askForNumbers[i].value;
			array[i] = askForTerm;
		}
		$('#addForm').form('submit', {
			url : "fillMerchantInfo.do",
			queryParams : {
				"askForTermJson" : JSON.stringify(array)
			},
			// 校验form表单数据
			onSubmit : function(param) {
			},
			success : function(data) {
				var data = eval("(" + data + ")");
				$.messager.alert('消息', data.respCodeDesc, 'info');
			}
		});
	} catch (e) {
		alert(e);
	}
}
