/**
 * ajax提交请求
 * @param formId
 * @param requetURL
 * @param dataDiv
 * @param errorDiv
 * @param pageNum
 */
function ajaxFormQueryForPage(formId,requestURL,showDiv,tableList,errorDiv,pageNum){
	var options = $('#' + tableList).datagrid('getPager').data("pagination").options;
	var pageOffset = 1;
	if (pageNum)
		pageOffset = pageNum;
	var rows = options.pageSize;
	$('#'+formId).form('submit', {
		url:requestURL,
		queryParams:{"rows":rows,"pageOffset":pageOffset},
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
	    	$('#'+showDiv).attr("display","");
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
	 				onSelectPage:function(pageNumber, pageSize){
	 					ajaxFormQueryForPage(formId,requetURL,showDiv,tableList,errorDiv,pageNumber);
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