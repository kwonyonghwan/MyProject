<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
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
	<!-- 조회 화면의 경우 나중에 수정이나 삭제 작업에서 사용되기 때문에 원래 게시물 번호인 bno를 가지고 있어야 한다. 
		그런데 사용자에게 보여줄 필요는 없기 때문에 hidden 타입을 사용하여 처리하고 있다.-->
<form role="form" action="modifyPage" method="post">    
    
    <input type='hidden' name='bno' value ="${boardVO.bno}">
    <input type='hidden' name='page' value ="${cri.page}">
    <input type='hidden' name='perPageNum' value ="${cri.perPageNum}">
</form> 
 
	<!-- 조회화면이므로 사용자가 값을 편집할 수 없도록 readonly 속성을 주고 있다. -->
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label> 
			<input type="text" name="title" class="form-control" 
					value="${boardVO.title}" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="exampleInputPassWor1">Content</label>
			<textarea name="content" rows="3" class="form-control"  readonly="readonly"> 
				${boardVO.content}
			</textarea>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> 
			<input type="text" name="writer" class="form-control" 
					value="${boardVO.writer}" readonly="readonly">
		</div>
		<!-- /.box-body -->

	</div>
	<div class="box-footer">
		<button type="submit" class="btn btn-warning">MODIFY</button>
		<button type="submit" class="btn btn-danger">REMOVE</button>
		<button type="submit" class="btn btn-primary">LIST ALL</button>
	
	
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	// 목록페이지로 이동하는 기능은 form태그의 bno, page, pageNum 정보를  get방식으로 /board/listPage에 정보를 붙여
	// submit하여 요청해야한다. 그러면 현재 조회페이지에서 바로 직전의 목록페이지로 이동할 수 있다.
	$(".btn-primary").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/board/listPage");  //삭제처리 링크
		formObj.submit();
	});
	
	//수정 부분
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modifyPage");  //수정 화면으로의 링크
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
});


</script>

</body>
</html>