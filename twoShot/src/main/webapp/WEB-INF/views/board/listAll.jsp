<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ page session="false" %>
<%@include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
<link href="\resources\bootstrap\css\bootstrap.css" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.css.map" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<table class="table table-bordered">
		<tr>
			<th style="width: 5%">번호</th>
			<th style="width: 25%">제목</th>
			<th style="width: 10%">작성자</th>
			<th style="width: 15%">등록날짜</th>
			<th style="width: 5%">조회수</th>	
		</tr>
		
	<c:forEach items="${list}" var="boardVO">	
		
		<tr>
			<td>${boardVO.bno}</td>
			<td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern ="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	
	<script>
		var result = '${msg}';
		
		if(result == 'SUCCESS'){
			alert("처리 완료!");
		}
	</script>

</body>
</html>