<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 상세 조회</title>
<link href="\resources\bootstrap\css\bootstrap.css" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.css.map" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.min.css" rel="stylesheet">
</head>
<body>


	<form role="form" method="post">
	
		<input type='hidden' name='bno' value="${boardVO.bno}">
	
	</form>
		
		<div class="box-body">
			<div class="form-group">
				<label for="InputEmail">제목</label>
				<input type="text" name="title" class="form-control" 
				value="${boardVO.title}" readonly="readonly">
			</div>


		<div class="form-group">
			<label for="InputContent">내용</label>
			<textarea class="form-control" name="content" rows="3" 
			readonly="readonly">${boardVO.content}</textarea>
		</div>

		<div class="form-group">
			<label for="InputWriter">작성자</label>
			<input type="text" name="writer" class="form-control" 
			value="${boardVO.writer}" readonly="readonly">
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-warning">Modify</button>
			<button type="submit" class="btn btn-danger">REMOVE</button>
			<button type="submit" class="btn btn-primary">LIST ALL</button>
		</div>
		
	  </div>	
	

<!-- 코드 아래에 있는 버튼에 대한 처리 -->
	<script>
		$(document).ready(function(){
		
			var formObj = $("form[role='form']");
			
			console.log(formObj);
			
			$(".btn-warning").on("click", function(){
				formObj.attr("action", "/board/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			
			
			$(".btn-danger").on("click", function(){
				formObj.attr("action", "/board/remove");
				formObj.submit();
			});
			
			
			$(".btn-primary").on("click", function(){
				self.location = "/board/listAll";
			});
			
		});
		
	</script>
</body>
</html>