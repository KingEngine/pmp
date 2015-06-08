/**
 * 刷新随机验证码
 * @param url
 */
function flushRandcode(url){
	var nowDate = new Date().getTime().toString(36);
	url+="?temp=";
	url+=nowDate;
	document.getElementById("imgRandcode").src=url;
}

function login(){
	var form = document.getElementById("loginForm");
	form.submit();
}