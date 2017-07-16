<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file= "..\include\header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<link href="\resources\bootstrap\css\bootstrap.css" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.css.map" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.min.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listPage</title>
</head>
<body>

	<!-- 현재 해당하는 페이지 게시물 목록 처리 -->
	<table class="table table-bordered">
		<tr>
			<th style="width: 10px">BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th style="width: 50px">VIEWCNT</th>


	<!-- page와 perPageNum 링크에 연동 -->
	<c:forEach items="${list}" var="boardVO">
		<tr>
			<td>${boardVO.bno}</td>
			<td><a href="/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}
						&bno=${boardVO.bno}">${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
		</tr>
	</c:forEach>
	
	</table>

	<!-- 페이지 번호 출력해서 보여주는 부분 -->
	<div class="text-center">
		<ul class="pagination">

			<!-- 앞페이지 :<<-->
			<c:if test="${pageMaker.prev}">
				<li>
					<a href="listPage?page=${pageMaker.startPage - 1}">&laquo;</a>
				</li>
			</c:if>
			
			<!-- 페이지 번호 출력-->
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<li 
					<c:out value="${pageMaker.cri.page == idx?'class =active': ''}"/>>
				    <a href="listPage?page=${idx}">${idx}</a>
				</li>
			</c:forEach>
			


			<!-- 뒷페이지: >>-->
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li>
					<a href="listPage?page=${pageMaker.endPage +1}">&raquo;</a>
				</li>
			</c:if>
		</ul>
		
	</div>
	
	
	<form id="jobForm">
	  <input type='hidden' name="page" value="${pageMaker.cri.perPageNum}">
	  <input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}">
	</form>


	<!-- 페이지번호 클릭시 처리하는 부분 -->
	<script>
	
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
	
	//페이지번호가 클릭되면 event.preventDefault();를 이용해 실제 화면의 이동을 막는다.
	$(".pagination li a").on("click", function(event){
		
		event.preventDefault(); 
		
		var targetPage = $(this).attr("href");
		
		var jobForm = $("#jobForm");
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action","/board/listPage").attr("method", "get");
		jobForm.submit();
	});
	
	</script>
	
</body>
</html>