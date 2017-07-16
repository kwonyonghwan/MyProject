<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp" %>

<link href="\resources\bootstrap\css\bootstrap.css" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.css.map" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내용 수정</title>
</head>
<body>
	<!-- 수정 작업에 필요한 데이터를 처리, 전송 -->
	<form role="form" method="post">
		
		<div class="box-body">
			
			<div class="form-group">
				<label for="InputBno">번호</label>
				<input type="text" name="bno" class="form-control" 
				value="${boardVO.bno}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="InputTitle">제목</label>
				<input type="text" name="title" class="form-control" 
				value="${boardVO.title}">
			</div>
			
			
			<div class="form-group">
				<label for="InputContent">내용</label>
				<input type="text" name="content" class="form-control" 
				value="${boardVO.content}">
			</div>
			
			<div class="form-group">
				<label for="InputWriter">작성자</label>
				<input type="text" name="writer" class="form-control" 
				value="${boardVO.writer}" readonly="readonly">
			</div>
			
			
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">SAVE</button>
				<button type="submit" class="btn btn-warning">CANCEL</button>
			</div>
		</div>
	</form>
	
	
	<!-- 코드 아래에 있는 버튼에 대한 처리 -->
	<script>
		$(document).ready(function(){
		
			var formObj = $("form[role='form']");
			
			console.log(formObj);
			
			
			$(".btn-warning").on("click", function(){
				self.location = "/board/listAll";
			});
			
			
			$(".btn-primary").on("click", function(){
				formObj.submit();
			});
			
		});
		
	</script>
	
</body>
</html>