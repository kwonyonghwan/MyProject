<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file= "..\include\header.jsp" %>
<%-- <%@ include file= "..\include\footer.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 등록 폼</title>
<link href="\resources\bootstrap\css\bootstrap.css" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.css.map" rel="stylesheet">
<link href="\resources\bootstrap\css\bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="InputEmail">제목</label>
				<input type="text" name="title" class="form-control" placeholder="제목을 입력해 주세요.">
			</div>


		<div class="form-group">
			<label for="InputContent">내용</label>
			<textarea class="form-control" name="content" rows="3"
				placeholder="내용을 입력해 주세요."></textarea>
		</div>

		<div class="form-group">
			<label for="InputWriter">작성자</label>
			<input type="text" name="writer" class="form-control">
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	  </div>
	</form>

</body>
</html>