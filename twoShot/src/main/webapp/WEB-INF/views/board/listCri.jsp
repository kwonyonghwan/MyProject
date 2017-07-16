<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="\resources\bootstrap\css\bootstrap.css" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.css.map" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.min.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th style="width: 10px">BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th style="width: 40px">VIEWCNT</th>
		</tr>

		<c:forEach items="${list}" var="boardVO">
			<tr>
				<td>${boardVO.bno}</td>
				<td><a href="/board/read?bno=${boardVO.bno}">
						${boardVO.title} </a></td>
				<td>${boardVO.writer}</td>
				<td>${boardVO.regdate}</td>
				<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
			</tr>
		</c:forEach>

	</table>
	
	<script>
		var result = $
		{
			msg
		};

		if (result == "SUCCESS") {
			alert("처리가 완료되었습니다.");
		}
	</script>
</body>
</html>