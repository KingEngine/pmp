function formatterTseq(value,row,index){
	return "<a href='#' onclick=\"showTradeDetail('"+value+"')\">"+value+"</a>";
}
//显示交易详情
function showTradeDetail(tseq){
	$('#tradeDetailDialog').dialog({    
	    title: '商户订单详细资料',    
	    width: 800,    
	    href:'getTradeDetailPage.do?tseq='+tseq,
		modal: true,
	});    
}

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