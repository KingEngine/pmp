/**
 * ajax提交请求
 * @param formId
 * @param requetURL
 * @param dataDiv
 * @param errorDiv
 * @param pageNum
 */
function ajaxFormQueryForPage(formId,requestURL,showDiv,tableList,errorDiv,pageNumber){
	$('#'+showDiv).panel('open');
	var options = $('#' + tableList).datagrid('getPager').data("pagination").options;
	var pageNum = 1;
	if (pageNumber){
		pageNum = pageNumber;
	}
	var rows = options.pageSize;
	$('#'+formId).form('submit', {
		url:requestURL,
		queryParams:{"rows":rows,"pageNumber":pageNum},
		//校验form表单数据
		onSubmit: function(){ 
			var isValid = $(this).form('validate');
 			if (!isValid){
 				return false;
 			}
 			showLoading();//显示遮罩
 			return true;
	    },  
	    success: function(data){
	    	try{
	    	    var data = eval("("+data+")");
				//加载数据
				$('#' + tableList).datagrid('loadData', data.rows);
				if(data.rows.length==0){
					var columns = $('#'+tableList).datagrid('getColumnFields');
					var fieldName = "";
					var colspanNums = 0;
					var isHidden = $('#'+tableList).datagrid('getColumnOption',columns[0]).hidden;
					if(isHidden){
						fieldName=columns[1];
						colspanNums=columns.length-1;
					}else{
						fieldName=columns[0];
						colspanNums=columns.length;
					}
					var msg = "{"+fieldName+":'对不起,暂无数据!'}";
					$('#'+tableList).datagrid("appendRow",eval("("+msg+")"));
					$('#'+tableList).datagrid("mergeCells",{index:0,field:fieldName,rowspan:null,colspan:colspanNums});
				}
	    	    //重置分页组件
	 			$($('#'+tableList).datagrid('getPager')).pagination({ 
	 				total:data.total,
	 				pageSize:rows,
	 				pageNumber:pageNumber,
	 				onSelectPage:function(pageNumber, pageSize){
	 					ajaxFormQueryForPage(formId,requestURL,showDiv,tableList,errorDiv,pageNumber);
	 				}
	 			}); 
	    	}catch(e){
	    		$("#"+errorDiv).text(e);
	    	}
	    	closeLoading();//去掉遮罩
	    }
	});
}
function showLoading(){
	if ($("#disabledImageZone").length > 0) {
		$("#disabledImageZone").show();
	} else {
		var loading = $("<div id='disabledImageZone' class=loading><div style='margin:350px auto 0 auto;width:100px;'><img id='imageZone' style='left:50%;top:50%;' src='images/main/loading.gif'></img></div></div>");
		$("body").append(loading);
	}
}
function closeLoading(){
	 $("#disabledImageZone").hide();
}
/**
 * 显示进度条
 * @param isShow
 * @param title
 * @param msg
 */
function showProcess(isShow,title,msg){
	if (!isShow) {
		$.messager.progress('close');
		return;
	}
	var progress =$.messager.progress({title: title,msg: msg});
}

/**
 * formatter 交易类型
 * @param value
 * @param row
 * @param index
 * @returns {String} 交易类型描述
 */
function formatterTradeType(value,row,index){
	var content = '';
	$.ajax({
		 url:"getCacheTradeType.do",
         type:'post',
         async:false,
         success: function(msg){
        	 $.each(msg,function(i,n){
        		 if(value == n.tradeCode){
        			 content = n.tradeName;
        			 return;
        	     }
        	 });
         },
		 error: function(){
				$.messager.alert('错误','系统异常!','error');
	     }
		
	});
	return content;
}
/**
 * formatter 扣款渠道
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function formatterDeductChannel(value,row,index){
	var content = '';
	$.ajax({
		 url:"getDeductChannelSelectList.do",
         type:'post',
         async:false,
         success: function(msg){
        	 $.each(msg,function(i,n){
        		 if(value == n.deductChannelId){
        			 content = n.deductChannelName;
        			 return;
        	     }
        	 });
         },
		 error: function(){
				$.messager.alert('错误','系统异常!','error');
	     }
		
	});
	return content;
}
/**
 * 商户类别
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function formatterMerchantType(value,row,index){
	var content = '';
	$.ajax({
		 url:"getMerchantTypeSelectList.do",
         type:'post',
         async:false,
         success: function(msg){
        	 $.each(msg,function(i,n){
        		 if(value == n.typeCode){
        			 content = n.typeDesc;
        			 return;
        	     }
        	 });
         },
		 error: function(){
				$.messager.alert('错误','系统异常!','error');
	     }
		
	});
	return content;
}
/**
 * 显示dialog 不需要传入参数
 * @param url
 * @param title
 * @param width
 */
function showDialogWithOutParameter(url,title,width,dialogId){
	$('#'+dialogId).dialog({    
	    title: title,    
	    width: width,    
	    href:url,
	    shadow:true,
		modal: true,
	}); 
}
function ajaxSubmitDialogForm(url,formId,dialogId){
	$('#'+formId).form('submit', {
		url:url,
		//校验form表单数据
		onSubmit: function(){ 
			var isValid = $(this).form('validate');
 			if (!isValid){
 				return false;
 			}
 			showProcess(true,"进度","正在提交");
 			return true;
	    },  
	    success: function(data){
	    	showProcess(false);
	    	try{
		    	var data = eval("("+data+")");
		    	$.messager.alert('消息',data.respCodeDesc,'info');
		    	$('#'+dialogId).dialog("close");
	    	}catch(e){
	    		$.messager.alert('错误',data,'error');
	    	}
	    }
	});
	
}

/**
 * 提交表单
 * @param submitFormId
 * @param requestURL
 * @param isValidate
 */
function ajaxSubmitForm(submitFormId,requestURL,isValidate){
	$('#'+submitFormId).form('submit', {
		url:requestURL,
		//校验form表单数据
		onSubmit: function(){ 
			//判断是否需要校验
			if(isValidate){
				var isValid = $(this).form('validate');
	 			if (!isValid){
	 				return false;
	 			}
			}
 			showLoading();//显示遮罩
 			return true;
	    },  
	    success: function(data){
	    	closeLoading();
	    	try{
		    	var data = eval("("+data+")");
		    	$.messager.alert('消息',data.respCodeDesc,'info');
	    	}catch(e){
	    		$("#"+errorDiv).text(e);
	    	}
	    }
	});
}
function ajaxSubmitFormWithParameter(submitFormId,requestURL,isValidate,paramter){
	$('#'+submitFormId).form('submit', {
		url:requestURL,
		queryParams:{"suggestion":paramter},
		//校验form表单数据
		onSubmit: function(){ 
			//判断是否需要校验
			if(isValidate){
				var isValid = $(this).form('validate');
	 			if (!isValid){
	 				return false;
	 			}
			}
 			showLoading();//显示遮罩
 			return true;
	    },  
	    success: function(data){
	    	closeLoading();
	    	try{
		    	var data = eval("("+data+")");
		    	$.messager.alert('消息',data.respCodeDesc,'info');
	    	}catch(e){
	    		$("#"+errorDiv).text(e);
	    	}
	    }
	});
}
/**
 * 显示手续费公式页面
 */
function showDiscountFeeDetailDialog(divId){
	$('#'+divId).dialog({    
	    title: '手续费公式',    
	    width: 800,    
	    href:'getDiscountFeeDetailPage.do',
	    shadow:true,
		modal: true,
	});   
}