/**
 * workflow_task_query_pre.jsp页面对应的js
 */
function formatterTaskId(value,row,index) {
	var html="<a href=\"#\" class=\"easyui-tooltip\" onclick=\"showProcessImage('"+value+"')\">查看流程图</a>";
	html+="&nbsp;&nbsp;&nbsp;";
	html+="<a href=\"#\" class=\"easyui-tooltip\" onclick=\"handlerTask('"+value+"')\">办理任务</a>";
	return html;
}
/**
 * 显示当前流程
 * @param taskId
 */
function showProcessImage(taskId){
	$('#processImageDiv').dialog({    
	    title: '当前流程图',    
	    queryParams:{"taskId":taskId},
	    href:"showProcessImage.do",
		modal: true,
		fit:true,
		border:false
	});    
}
/**
 * 办理任务
 * @param taskId
 */
function handlerTask(taskId){
	$('#processImageDiv').dialog({    
	    title: '办理任务',    
	    queryParams:{"taskId":taskId},
	    href:"dispatcherTask.do",
		modal: true,
		fit:true,
		border:false
	});    
}

