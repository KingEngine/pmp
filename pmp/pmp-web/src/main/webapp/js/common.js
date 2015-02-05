/**
 * Form表单提交,ajax查询
 * @param requestURL       请求url
 * @param requestFormId    formID
 * @param showResultDivId  显示的div层id
 * @param pageNum          页号
 */
function ajaxPageQuery(formId,requestURL,resultId,tableList,errorId,pageNum){
	//存在错误提示 隐藏
	var options =$('#'+tableList).datagrid('getPager').data("pagination").options;   
	var page = 1;
	if(pageNum){
		page=pageNum;
	}
 	var rows = options.pageSize;
 	$('#'+formId).form('submit', {
 		url: requestURL,
 		data:{page:page,rows:rows},
 		onSubmit: function(){
 			var isValid = $(this).form('validate');//form表单校验
 			if (!isValid){
 				return false;
 			}
 			return true;
 		},
 		success: function(backData){
 			//填充到表单
 			var data = eval("("+backData+")");
 			//重置分页组件
 			$($('#'+tableList).datagrid('getPager')).pagination({ 
 				total:data.total,
 				pageNumber:page,
 				pageSize:rows,
 				onSelectPage:function(pageNumber, pageSize){
 					$(this).pagination('loading');
 					ajaxPageQuery(formId,requestURL,resultId,tableList,errorId,pageNum);
 					$(this).pagination('loaded');
 				}
 			});
 			var showColumns = data.rows;
 			if(0==showColumns.length){
 				var columns = $('#'+tableList).datagrid('getColumnFields');
 				alert(columns);
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
				var msg = "{"+fieldName+":'\"对不起暂无记录\"'}";
				$('#'+tableList).datagrid("appendRow",eval("("+msg+")"));
				$('#'+tableList).datagrid("mergeCells",{index:0,field:fieldName,rowspan:null,colspan:colspanNums});
				$('#'+tableList).datagrid({});
 			}else{
 			   $('#'+tableList).datagrid('loadData',data.rows); 
 			}
 		},
 		onLoadError:function(error){
 			alert(error);
 		}
 	});
}