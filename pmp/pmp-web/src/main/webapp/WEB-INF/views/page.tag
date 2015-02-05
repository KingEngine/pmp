<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="tag.tag"%>

<c:if test="${pageMap.totalPages != null}">
	<div class="next">
		<a href="javascript:ajaxSubmitForm(1)"><span>首页</span></a>
		<c:if test="${pageMap.pageNo > 1}">
			<a href="javascript:ajaxSubmitForm(${pageMap.pageNo-1 })"><span>上一页</span></a>
		</c:if>
		<c:if test="${pageMap.pageNo-3 > 0}">
			<b><span>...</span></b>
		</c:if>
		<c:if test="${pageMap.pageNo-2 > 0}">
			<a href="javascript:ajaxSubmitForm(${pageMap.pageNo-2 })"><span>${pageMap.pageNo-2 }</span></a>
		</c:if>
		<c:if test="${pageMap.pageNo-1 > 0}">
			<a href="javascript:ajaxSubmitForm(${pageMap.pageNo-1 })"><span>${pageMap.pageNo-1 }</span></a>
		</c:if>
		<a href="#" class="hover"><span>${pageMap.pageNo }</span></a>
		<c:if test="${pageMap.pageNo+1 <= pageMap.totalPages}">
			<a href="javascript:ajaxSubmitForm(${pageMap.pageNo+1 })"><span>${pageMap.pageNo+1 }</span></a>
		</c:if>
		<c:if test="${pageMap.pageNo+2 <= pageMap.totalPages}">
			<a href="javascript:ajaxSubmitForm(${pageMap.pageNo+2 })"><span>${pageMap.pageNo+2 }</span></a>
		</c:if>
		<c:if test="${pageMap.pageNo+3 <= pageMap.totalPages}">
			<b><span>...</span></b>
		</c:if>
		<c:if test="${pageMap.pageNo < pageMap.totalPages}">
			<a href="javascript:ajaxSubmitForm(${pageMap.pageNo+1 })"><span>下一页</span></a>
		</c:if>
			<a href="javascript:ajaxSubmitForm(${pageMap.totalPages})"><span>末页</span></a>
		<b><span>共${pageMap.totalPages }页 跳到第<input
				style="width: 24px; margin: 0 5px;" onkeydown="pageEnterEvent(this.value,event)"
				value="${pageMap.pageNo }" />页
		</span></b>
	</div>
</c:if>