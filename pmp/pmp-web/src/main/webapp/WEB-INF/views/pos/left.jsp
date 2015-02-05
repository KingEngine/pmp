<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String context = request.getContextPath();
%>
<head>
	 <%@include file="../resource.tag" %> 
</head>
<body >
	<div class="easyui-panel" style="padding:5px;border: 0px;">
		<ul class="easyui-tree" id="menuTree">
		<c:forEach items="${left_menu_list}" var="secondMenu">
		     <c:if test="${secondMenu.menuLevel == 2}">
		       <li data-options="id:'${secondMenu.id}'"><span><strong>${secondMenu.menuName}</strong></span>
		           <ul>
		              <c:forEach items="${left_menu_list}" var="thirdMenu">
		                  <c:if test="${thirdMenu.menuLevel == 3 && thirdMenu.parentId == secondMenu.menuId}">
		                    <li data-options="id:'${thirdMenu.id}'"><span><a id="MainTitle_${thirdMenu.menuId}" href="${thirdMenu.requestUrl}" target="rightFrame">${thirdMenu.menuName}</a></span></li>
		                  </c:if>
		              </c:forEach>
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
			//是否是叶子节点
		 	var isLeaf = $('#menuTree').tree('isLeaf', node.target);
			//叶子节点 
            if(isLeaf){ 
				var parentName = $("a[id=MainTitle_"+node.id+"]").parent().parent().parent().parent().parent().prev().find(".tree-title").text();
				var mainTitle = parent.window.$("#rightMain");
            	//动态设置title属性值
            	var title = "当前位置："+parentName+">>"+ node.text;
            	mainTitle.panel("setTitle",title);
           }
		},//双击一个节点的时候触发
       	onDblClick:function(node){  
       		$(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
       	}
	});
});
</script>
</html>


