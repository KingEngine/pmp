<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String context = request.getContextPath();
%>
<head>
	 <%@include file="resource.tag" %> 
</head>
<body >
	<div class="easyui-panel" style="padding:5px;border: 0px;">
		<ul class="easyui-tree" id="menuTree">
		<c:forEach items="${left_menu_list}" var="secondMenu">
		     <c:if test="${secondMenu.menuLevel == 2 && secondMenu.menuUrl=='#'}">
		       <li data-options="id:'${secondMenu.id}'"><span><strong>${secondMenu.menuName}</strong></span>
		           <ul>
		              <c:forEach items="${left_menu_list}" var="thirdMenu">
		                  <c:if test="${thirdMenu.menuLevel == 3 && thirdMenu.parentMenuId == secondMenu.menuId}">
		                    <li data-options="id:'${thirdMenu.id}'"><span><a id="MainTitle_${thirdMenu.menuId}" onclick="showTab('${thirdMenu.menuUrl}','${thirdMenu.menuName}')">${thirdMenu.menuName}</a></span></li>
		                  </c:if>
		              </c:forEach>
		           </ul>
		       </li>
		     </c:if>
		     <c:if test="${secondMenu.menuLevel == 2 && secondMenu.menuUrl!='#'}">
		       <li data-options="id:'${secondMenu.id}'"><span><strong>${secondMenu.menuName}</strong></span>
		           <ul>
		                 <li data-options="id:'${secondMenu.id}'"><span><a id="MainTitle_${secondMenu.menuId}" href="${secondMenu.menuUrl}" target="rightFrame">${secondMenu.menuName}</a></span></li>
		           </ul>
		       </li>
		     </c:if>
		   </c:forEach>
		</ul>
	</div>
</body>
<script type="text/javascript">  
$(function(){
	$('#menuTree').tree({ 
		animate:true,
	 	//点击一个节点的时候触发              
		onClick:function(node){
			$(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target); 
		},//双击一个节点的时候触发
       	onDblClick:function(node){  
       		$(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
       	}
	});
});

function showTab(url,tabName){
	try{
		var tabIsExist = parent.window.$('#rightMain').tabs('exists',tabName);
		if(!tabIsExist){
			var content ="<iframe src="+url+" frameborder=\"0\" height=\"100%\" width=\"100%\" style=\"overflow:auto;\" />";
			parent.window.$('#rightMain').tabs('add',{    
			    title:tabName,    
			    content:content,    
			    closable:true,    
			});  
		}
	}catch(e){
		$.messager.alert('警告',e);
	}
}
</script>
</html>


