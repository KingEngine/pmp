/**
 * 
 */

/**
 * formatter 操作
 */
function formatterOperation(value,row,index) {
	
	var html="<a href='#' onclick=\"restPwd("+value+")\">密码重置</a>";
	html+="&nbsp;&nbsp;";
	html+="<a href='#' onclick=\"modifyAuthorities("+value+")\">权限修改</a>";
	return html;
}
/**
 * 关闭操作员
 * @param userId
 */
function closeOperator(userId){
	
}
/**
 * 密码重置
 * @param userId
 */
function restPwd(userId){
	
}
/**
 * 权限修改
 * @param userId
 */
function modifyAuthorities(userId){
	
}
