<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="..\include\tempHeader.jsp"%>

<link href="\resources\productListBootstrap2\css\bootstrap.css"
	rel="stylesheet" type="text/css" media="all">


<!--theme-style-->
<link href="\resources\productListBootstrap2\css\style.css"
	rel="stylesheet" type="text/css" media="all">

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Font awesome -->
<link href="\resources\main_bootstrap\css\font-awesome.css"
	rel="stylesheet">
<!-- Bootstrap -->
<link href="\resources\main_bootstrap\css\bootstrap.css"
	rel="stylesheet">
<!-- SmartMenus jQuery Bootstrap Addon CSS -->
<link
	href="\resources\main_bootstrap\css\jquery.smartmenus.bootstrap.css"
	rel="stylesheet">
<!-- Product view slider -->
<link rel="stylesheet" type="text/css"
	href="\resources\main_bootstrap\css\jquery.simpleLens.css">
<!-- slick slider -->
<link rel="stylesheet" type="text/css"
	href="\resources\main_bootstrap\css\slick.css">
<!-- price picker slider -->
<link rel="stylesheet" type="text/css"
	href="\resources\main_bootstrap\css\nouislider.css">
<!-- Theme color -->
<link id="switcher"
	href="\resources\main_bootstrap\css\theme-color/default-theme.css"
	rel="stylesheet">
<!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
<!-- Top Slider CSS -->
<link
	href="\resources\main_bootstrap\css\sequence-theme.modern-slide-in.css"
	rel="stylesheet" media="all">

<!-- Main style sheet -->
<link href="\resources\main_bootstrap\css\style.css" rel="stylesheet">

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<style>
.custom-file-upload-hidden {
	display: none;
	visibility: hidden;
	position: absolute;
	left: -9999px;
}

.custom-file-upload {
	display: block;
	width: auto;
	font-size: 16px;
	margin-top: 30px;
}

.container {
	z-index: 100
}

.fileDrop {
	width: 300px;
	height: 300px;
	border: 1px dotted blue;
}

.uploadedList div {
	float: left;
}

.uploadTarget {
	width: 50px;
	height: 50px;
	border: 1px solid blue;
}

.ti {
	width: 50px;
	height: 50px
}

.showimg {
	position: absolute;
	left: 100px;
	top: 100px;
	z-index: 10
}
</style>



<title>Insert title here</title>
</head>
<body>

	<div class="banner-top">
		<div class="container">

			<h1>Register</h1>
			<em></em>
			<h2>
				<a href="index.html" style="left: 40%">Home</a><label>/</label>Register</a>
			</h2>
		</div>
	</div>

	<!-- / join section -->
	<section id="aa-myaccount">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-myaccount-area">
						<div class="row">


							<!-- 회원가입 -->
							<div class="col-md-6" style="left: 20%">
								<div class="aa-myaccount-register">
									<h4>회원가입</h4>
									<form role="form" method="post" class="aa-login-form">
										<label for="memberid">아이디<span>*</span>
										<i class="glyphicon glyphicon-user"></i>
										</label>
										 <input type="text" id="memberid" name="memberid"
											placeholder="UserId" />
										<label for="memberpw">비밀번호<span>*</span>
										<i class="glyphicon glyphicon-lock"></i>
										</label>
										<input type="password" id="memberpw" name="memberpw"
											placeholder="Password"> 
											<label for="membername">이름<span>*</span>
												<i class="glyphicon glyphicon-user"></i>
											</label>
										<input type="text" id="membername" name="membername">

										<label for="male">남자</label> <input type="checkbox" id="male"
											name="male" value="male"> <label for="female">여자</label>
										<input type="checkbox" id="female" name="female"
											value="female"> <br>
											
											
											
										 <label for="memberaddress">주소<span>*</span>
										 <i class="glyphicon glyphicon-home"></i>
										 </label>
										<input type="text" id="memberaddress" name="memberaddress"
											placeholder="상품을 배송받으실 주소를 입력해 주세요.">
											 <label for="memberfootwidth">발 가로길이
											 <i class="glyphicon glyphicon-resize-horizontal"></i>
											 </label>
											  <input type="text" id="memberfootwidth" name="memberfootwidth"
											placeholder="가장 넓은 면적을 기준으로 숫자만 입력하세요. (mm단위)"> <label
											for="memberfootheight">발 세로길이
											<i class="glyphicon glyphicon-resize-vertical"></i>
											</label> 
											
											<input type="text"
											id="memberfootheight" name="memberfootheight"
											placeholder="가장 긴 발가락을 기준으로 숫자만 입력하세요 (mm단위)"> <label
											for="memberfootperimeter">발 둘레
											<i class="glyphicon glyphicon-repeat"></i>
											</label> 
											
											<input type="text"
											id="memberfootperimeter" name="memberfootperimeter"
											placeholder="양옆의 가장 튀어나온 부분을 기준으로. (숫자만 입력) "> <input
											type="hidden" id="memberfootimage" name="memberfootimage">
										<!-- 사진업로드 -->
										<!--                     	<div class="custom-file-upload"> -->
										<!--                     <form action="/" method="post" enctype="multipart/form-data"> -->
										<!-- 					파일 : <input type="file" id="file" name="upload" />  -->
										<!--  						<input type="file" name="upload" class="upload"> -->
										<!-- 					<input type="submit" name="업로드"><br> -->

										<!-- 					</form> -->
										<!-- 					</div> -->

										<label
											for="footupload">파일 업로드
										<i class="glyphicon glyphicon-file"></i>
											</label> 
											<div class="filecontainer">
											
										<div class="fileDrop filecentered"
											style="width: 300px; height: 300px; margin-bottom: 10px; border: 1px solid #9C9C9C;">
										<label>이 곳에 사진 파일을 끌어다 놓으세요.</label>
										</div>
										
										</div>
										<div class="loading" hidden="">
											<img class="loading" src="\resources\img\spin.gif">
										</div>
										<div class="uploadedList">
											<table>
											</table>
										</div>

										<div class="showimg"></div>

										<button class="aa-browse-btn" onClick="history.go(-1)">돌아가기</button>
										<button type="submit" class="aa-browse-btn"
											onclick="window.open('popup','팝업 ','width=532,height=520,toolbar=no,location=yes,status=no,menubar=no,scrollbars=yes,resizable=no,left=150,top=100')">회원가입</button>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / join section -->

	<script>
		/*  function openNewWindow(url, name) {
		 var specs = "left=10,top=10,width=372,height=466";
		 specs += ",toolbar=no,menubar=no,status=no,scrollbars=no,resizable=no";
		 window.open(url, name, specs);
		 } */

		function viewlist(callback) {

			$.ajax({
				contentType : 'application/json',
				type : "GET",
				url : "/filelist",
				success : function(result) {
					console.dir(result)
					callback(result)
				}
			})
		}

		var uploadedList = $(".uploadedList table");

		function checkImageType(fileName) {

			var pattern = /jpg|gif|png|jpeg/i;

			return fileName.match(pattern);
		}

		function aftersuccess(data) {
			var json = JSON.parse(data);
			constlist(json);
			$('#memberfootheight').val(json.footLength);
			$('#memberfootwidth').val(json.footWidth);
			$('#memberfootperimeter').val(json.footDoolleh);
			$('#memberfootimage').val(json.filePath);

			alert('업로드 완료');
			$('html').find('div .loading').hide(200);
			$('html').find('.fileDrop').hide(200);

		}
		function constlist(json) {

			var fileName = json.fileName;
			console.log(fileName);
			var isImage = checkImageType(fileName);
			var originName;
			if (!isImage) {
				//alert("일반 파일");

				originName = fileName.split("_")[1];

				var str = "<tr class ='"+fileName+"' ><td class='uploadTarget'><img class='ti' src='/resources/icon.png' data-src='"+fileName+"'></td><td>"
						+ originName
						+ "</td><td><button data-src='"+fileName+"' >X</button></td></tr>"

				uploadedList.append(str);
			} else {
				//alert("이미지 파일");

				originName = fileName.split("_s_")[1];
				var str = "<tr class ='"+fileName+"' ><td class='uploadTarget'><img class='ti' src='/displayFile?fileName="
						+ fileName
						+ "' data-src='"
						+ fileName
						+ "'></td><td>"
						+ originName
						+ "</td><td><button type'button' data-src='"+fileName+"'>X</button></td></tr>"
				console.log("파일이름" + fileName);
				uploadedList.append(str);
			}

		}

		function deletefile(src, callback) {
			$.ajax({
				contentType : 'application/json',
				type : "DELETE",
				url : "/uploadAjax",
				dataType : "text",
				data : src,
				success : function(result) {
					callback(result)
				}
			})
		}

		$(".uploadedList table").on("click", "tr td button", function(event) {
			event.preventDefault();
			var that = $(this);
			var temp = $(".uploadedList table tr").attr('class');
			var src = that.attr("data-src");
			console.log(src);

			//$(".uploadedList table tr td img").removeAttr("src");
			//$(".uploadedList table").find("."+src+"").

			//$(".uploadedList table tr").hide(200);
			$(".uploadedList table tr").remove();
			//$("."+src+"").remove();
			deletefile(src, function(result) {
				console.log(result);
				$('html').find('.fileDrop').show(200);
				$('#memberfootheight').val('');
				$('#memberfootwidth').val('');
				$('#memberfootperimeter').val('');
				$('#memberfootimage').val('');

			})

		})

		$(".uploadedList table").on(
				"click",
				"tr td img",
				function(event) { //위임 하는법, on의 두번째 파라미터로 현재클래스 하위에 어떤 요소에 이벤트를 걸지 정해준다
					var that = $(this);

					var src = that.attr("data-src");
					console.log(src);

					var originalsrc = src.split("_s_")[0] + "_"
							+ src.split("_s_")[1];

					//console.log(originalsrc);
					if (checkImageType(src) == null) {
						self.location = '/displayFile?fileName=' + src;
					} else {
						$(".showimg img").show(20000);
						$(".showimg").html(
								"<img src='/displayFile?fileName="
										+ originalsrc + "\'>");
						$(".showimg img").on("click", function(event) {

							$(".showimg img").hide(200);
						})
					}

				})

		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files; // ** JQuery로 이벤트를 처리하면 오리지날 이벤트가 아니다 꼭 오리지날 이벤트 뽑아줘야함

			var length = files.length;

			for (var i = 0; i < length; i++) {
				var file = files[i];

				var formData = new FormData();

				formData.append("file", file);

				var sex = $("input[name=male]:checked").val();

				if ($("input[name=female]:checked").val()) {

					sex = $("input[name=female]:checked").val();
				}

				console.log(sex);

				$.ajax({
					url : '/maleorfemale',

					data : sex,
					dataType : 'text',

					type : 'POST',
					success : function(data) {
						console.log('빠밤 : ' + data);
						if (data == 'true') {
							$('html').find('div .loading').show(200);
							$.ajax({
								url : '/uploadAjax',
								/* xhr: function(){
									myXhr = $.ajaxSettings.xhr();
									if(myXhr.upload){
										myXhr.upload.addEventListener('progress',function(evt){
											if(evt.lengthComputable){
												$('html').find('progress').attr({value:evt.loaded,max:evt.total}).show(200);
											}
										},false);
									}
									return myXhr;
								}, */
								data : formData,
								dataType : 'text',
								processData : false,
								contentType : false,
								type : 'POST',
								success : aftersuccess
							});
						} else {
							alert("성별을 선택하세요 !");
						}

					}
				});

			}

		});

		/* viewlist(function(result){

		 for(var i = 0; i<result.length;i++){
		 constlist(result[i]);
		 }

		 }); */
	</script>




</body>
</html>