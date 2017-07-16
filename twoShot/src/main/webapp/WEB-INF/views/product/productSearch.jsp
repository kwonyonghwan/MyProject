<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file= "..\include\tempHeader.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>상품 리스트 페이지</title>


<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--theme-style-->
<link href="\resources\productListBootstrap2\css\style.css"
	rel="stylesheet" type="text/css" media="all">
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="\resources\productListBootstrap2\css\bootstrap.css"
	rel="stylesheet" type="text/css" media="all">


<!--  Goodshoes부분 -->
<!-- Favicons (created with http://realfavicongenerator.net/)-->
<link rel="manifest"
	href="/resources/bootstrap_goodshoes/img/favicons/manifest.json">
<link rel="shortcut icon"
	href="/resources/bootstrap_goodshoes/img/favicons/favicon.ico">
<!-- Normalize -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/css/normalize.css">
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/css/bootstrap.css">
<!-- Owl -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/css/owl.css">
<!-- Animate.css -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/css/animate.css">
<!-- Font Awesome -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/fonts/font-awesome-4.1.0/css/font-awesome.min.css">
<!-- Elegant Icons -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/fonts/eleganticons/et-icons.css">
<!-- Main style -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/css/cardio.css">
<!--  Goodshoes부분 -->

<script type="application/x-javascript">
	
	addEventListener("load", function() { 
		setTimeout(hideURLbar, 0); }, false); 
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>

<!--theme-style-->
<link href="\resources\productListBootstrap2\css\style4.css"
	rel="stylesheet" type="text/css" media="all">
<!--//theme-style-->
<script src="\resources\productListBootstrap2\js\jquery.min.js"></script>
<!--- start-rate---->
<script src="\resources\productListBootstrap2\js\jstarbox.js"></script>
<link rel="stylesheet"
	href="\resources\productListBootstrap2\css\jstarbox.css"
	type="text/css" media="screen" charset="utf-8">
<link rel="stylesheet"
	href="\resources\productListBootstrap2\css\chocolat.css" ype="text/css"
	media="screen" charset="utf-8">


<script type="application/x-javascript">
	
	addEventListener("load", function() { 
		setTimeout(hideURLbar, 0); }, false); 
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>


<script type="text/javascript">
	jQuery(function() {
		jQuery('.starbox')
				.each(
						function() {
							var starbox = jQuery(this);
							starbox
									.starbox(
											{
												average : starbox
														.attr('data-start-value'),
												changeable : starbox
														.hasClass('unchangeable') ? false
														: starbox
																.hasClass('clickonce') ? 'once'
																: true,
												ghosting : starbox
														.hasClass('ghosting'),
												autoUpdateAverage : starbox
														.hasClass('autoupdate'),
												buttons : starbox
														.hasClass('smooth') ? false
														: starbox
																.attr('data-button-count') || 5,
												stars : starbox
														.attr('data-star-count') || 5
											})
									.bind(
											'starbox-value-changed',
											function(event, value) {
												if (starbox.hasClass('random')) {
													var val = Math.random();
													starbox.next().text(
															' ' + val);
													return val;
												}
											})
						});
	});
	
	
	function getpage(page){
		var para = document.location.href.split("product/");
		var url = para[1].split('&page');
		location.href=url[0]+"&page="+page;
		}
</script>
<!---//End-rate---->
<link href="\resources\productListBootstrap2\css\form.css"
	rel="stylesheet" type="text/css" media="all">

</head>
<body>
 
<!--banner-->
	<div class="banner-top">
		<div class="container">
		<br>
			<h1>Products</h1>
			<em></em>
			<h2>
				<a href="/product/productList"></a>HANDMADE
			</h2>
		</div>
	</div>
<!--banner-->
 

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<form name="productSearch" method="get">
<div class="container">
			<div class="row">

				<table class="table table-hover">
					<caption></caption>
					<colgroup>
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><h6>카테고리</h6></th>
							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox1" name="category" value="Loafer">
									<label for="checkbox1"> 로퍼</label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox2" name="category" value="Slipon">
									<label for="checkbox2"> 슬립온</label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox3" name="category" value="Oxford">
									<label for="checkbox3"> 옥스포드</label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox4" name="category" value="Sneakers">
									<label for="checkbox4">스니커즈</label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox5" name="category" value="Toeopen">
									<label for="checkbox5"> 토오픈</label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox6" name="category" value="Pumps">
									<label for="checkbox6"> 펌프스</label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" id="checkbox7" name="category" value="Casual" >
									<label for="checkbox7"> 캐쥬얼 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox"  id="checkbox8" name="category" value="Flat">
									<label for="checkbox8"> 플랫</label>
								</div>
							</td>
						</tr>


						<tr>
							<td><h6>색상</h6></td>
							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox9" value="black">
									<label for="checkbox9"> 블랙 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox10" value="brown">
									<label for="checkbox10"> 브라운 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox11" value="navy">
									<label for="checkbox11"> 네이비 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox12" value="white">
									<label for="checkbox12"> 화이트 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox13" value="blue">
									<label for="checkbox13"> 블루 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox14" value="wine">
									<label for="checkbox14"> 와인 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="color" id="checkbox15" value="silver">
									<label for="checkbox15"> 실버 </label>
								</div>
							</td>
							<td></td>
						</tr>
						<tr>
							<th scope="rowgroup" rowspan="2" style="vertical-align: top"><h6>사이즈</h6></th>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox16" value="220">
									<label for="checkbox16"> 220 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox17" value="225">
									<label for="checkbox17"> 225 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox18" value="230">
									<label for="checkbox18"> 230 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox19" value="235">
									<label for="checkbox19"> 235 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox20" value="240">
									<label for="checkbox20"> 240 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox21" value="245">
									<label for="checkbox21"> 245 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox22" value="250">
									<label for="checkbox22"> 250 </label>
								</div>
							</td>
							<td></td>
						<tr>
							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox23" value="255">
									<label for="checkbox23"> 255 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox24" value="260">
									<label for="checkbox24"> 260 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox25" value="265">
									<label for="checkbox25"> 265 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox26" value="270">
									<label for="checkbox26"> 270 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox27" value="275">
									<label for="checkbox27"> 275 </label>
								</div>
							</td>

							<td>
								<div class="checkbox checkbox-success">
									<input type="checkbox" name="size" id="checkbox28" value="280">
									<label for="checkbox28"> 280</label>
								</div>
							</td>
							<td></td>
							<td></td>
						</tr>

						<tr>
							<td><h6>가격</h6></td>
							<td colspan="8"><select class="type" name="price">
									<option value="">선택</option>
									<option value="0-100000">100,000원 이하</option>
									<option value="100000-200000">100,000-200,000원</option>
									<option value="200000-300000">200,000-300,000원</option>
									<option value="300000-400000">300,000만원 이상</option>
							</select></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<td>
				<button id="searchBtn" class="btn_search" type="submit"
					value="검색" onClick="this.form.submit();">검색</button>
			</td>
		</div>
	</form>

	<!--content-->
	<div class="product">
		<div class="container">
			<div class="col-md-12">


				<div class="mid-popular">
					<c:forEach items='${filteredProductList}' var='product'>
						<div class="col-lg-4 item-grid1 simpleCart_shelfItem">
							<div class=" mid-pop">
								<div class="pro-img" style="width: 80%; height: 75%">

									<a href="/product/productDetail?pno=${product.pno}"> 
										<img
											class="img-responsive"
											src="/resources/img_product/${product.productthumimage}"
											alt="${product.productthumimage}"
										>
									</a>
								</div>
								<!--	pro-img  -->
								<div class="mid-1">
									<div class="women">
										<div class="women-top">
											<span>${product.manufacturerid}</span>
											<h6>
												<a href="/product/productDetail?pno=${product.pno}">
													${product.productname} </a>
											</h6>
										</div>    	
									<!-- 장바구니 추가 버튼 -->
									<div class="img item_add">								
										<a href="#">
											<img src="\resources\productListBootstrap2\images\ca.png" alt="">
										</a>	
								    </div>								
									<div class="clearfix"></div> 
									</div>
									<div class="mid-2">
										<p>
											<em class="item_price">가격 : ${product.productprice}</em>
										</p>

										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="clearfix"></div>
				</div>
			</div>

		</div>
	</div>
<!-- 제품 리스트 보여 주기 끝 -->

<!-- 페이지 시작 -->
  <!-- Pagination -->
        <div class="row text-center">
         <div class="col-lg-12">
            <ul class="pagination">
            
            
         <!-- 앞페이지 :<<-->
         <c:if test="${pageMaker.prev}">
            <li>
               <a href="productSearch?page=${pageMaker.startPage - 1}">&laquo;</a>
            </li>
         </c:if>
         
         
         <!-- 페이지 번호 출력-->
         <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
            <li 
               <c:out value="${pageMaker.cri.page == idx?'class =active': ''}"/>>
			<!-- <a href="productSearch?page=${idx}">${idx}</a> -->
			<a onclick="getpage(${idx});">${idx}</a>
            </li>
         </c:forEach>

         <!-- 뒷페이지: >>-->
         <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
            <li>
               <a href="productSearch?page=${pageMaker.endPage +1}">&raquo;</a>
            </li>
         </c:if>

            </ul>
            
         </div>
      </div>

        <hr> <!-- 밑줄 -->
	
	
	<!--brand-->
	<div class="container">
		<div class="brand">
			<div class="col-md-3 brand-grid">
				
				<img src="\resources\productListBootstrap2\images\TheCustom1.jpg" class="img-responsive" alt="">
			</div>
			<div class="col-md-3 brand-grid">
				<img src="\resources\productListBootstrap2\images\ic1.png"" class="img-responsive" alt="">
			</div>
			<div class="col-md-3 brand-grid">
				<img src="\resources\productListBootstrap2\images\ic2.png" class="img-responsive" alt="">
			</div>
			<div class="col-md-3 brand-grid">
				<img src="\resources\productListBootstrap2\images\ic3.png" class="img-responsive" alt="">
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--//brand-->

	<!--//footer-->
	<div class="footer">
		<div class="footer-middle">
			<div class="container">
				<div class="col-md-3 footer-middle-in">
					<a href="index.html"><img src="images/log.png" alt=""></a>
					<p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel
						tincidunt elementum, nunc urna tristique nisi, in interdum libero
						magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
				</div>

				<div class="col-md-3 footer-middle-in">
					<h6>Information</h6>
					<ul class=" in">
						<li><a href="404.html">About</a></li>
						<li><a href="contact.html">Contact Us</a></li>
						<li><a href="#">Returns</a></li>
						<li><a href="contact.html">Site Map</a></li>
					</ul>
					<ul class="in in1">
						<li><a href="#">Order History</a></li>
						<li><a href="wishlist.html">Wish List</a></li>
						<li><a href="login.html">Login</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-3 footer-middle-in">
					<h6>Tags</h6>
					<ul class="tag-in">
						<li><a href="#">Lorem</a></li>
						<li><a href="#">Sed</a></li>
						<li><a href="#">Ipsum</a></li>
						<li><a href="#">Contrary</a></li>
						<li><a href="#">Chunk</a></li>
						<li><a href="#">Amet</a></li>
						<li><a href="#">Omnis</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-middle-in">
					<h6>Newsletter</h6>
					<span>Sign up for News Letter</span>
					<form>
						<input type="text" value="Enter your E-mail"
							onfocus="this.value='';"
							onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
						<input type="submit" value="Subscribe">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<ul class="footer-bottom-top">
					<li><a href="#"><img src="images/f1.png"
							class="img-responsive" alt=""></a></li>
					<li><a href="#"><img src="images/f2.png"
							class="img-responsive" alt=""></a></li>
					<li><a href="#"><img src="images/f3.png"
							class="img-responsive" alt=""></a></li>
				</ul>
				<p class="footer-class">
					© 2016 ONSHOT. All Rights Reserved | Design by <a
						href="http://w3layouts.com/" target="_blank">ONESHOT</a>
				</p>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//footer-->
	
	<script src="\resources\productListBootstrap2\js\simpleCart.min.js">
		
	</script>
	<!-- slide -->
	<script src="\resources\productListBootstrap2\js\bootstrap.min.js"></script>


	<script src="\resources\productListBootstrap2\js\jquery.chocolat.js"></script>
	
	<!--light-box-files -->
	<script type="text/javascript" charset="utf-8">
		$(function() {
			$('a.picture').Chocolat();
		});
		
		   $(document).ready(function() {

			   
			      $('#searchBtn').on("click",function(event) {

			         self.location = "productList"
			                  + '${pageMaker.makeQuery(1)}'
			                  + "&searchType="
			                  + $("select option:selected").val()
			                  + "&keyword=" + $('#keywordInput').val();

			      });

			      $('#newBtn').on("click", function(evt) {

			         self.location = "register";

	</script>


   <script>
   $(document).ready(function() {

		$('#searchBar').on("click",function(event) {

			self.location = "productList"
						+ '${pageMaker.makeQuery(1)}'
						+ "&searchType="
						+ $("select option:selected").val()
						+ "&keyword=" + $('#keywordInput').val();
		});

   	});
</script>

<style>
    .bs-example{
    	margin: 70px;
    }
    
.checkbox {
    padding-left: 20px; }
.checkbox label {
    display: inline-block;
    position: relative;
    padding-left: 5px; }
.checkbox label::before {
    content: "";
    display: inline-block;
    position: absolute;
    width: 17px;
    height: 17px;
    left: 0;
    margin-left: -20px;
    border: 1px solid #cccccc;
    border-radius: 3px;
    background-color: #fff;
    -webkit-transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
    -o-transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
    transition: border 0.15s ease-in-out, color 0.15s ease-in-out; }
.checkbox label::after {
    display: inline-block;
    position: absolute;
    width: 16px;
    height: 16px;
    left: 0;
    top: 0;
    margin-left: -20px;
    padding-left: 3px;
    padding-top: 1px;
    font-size: 11px;
    color: #555555; }
.checkbox input[type="checkbox"] {
    opacity: 0; }
.checkbox input[type="checkbox"]:focus + label::before {
    outline: thin dotted;
    outline: 5px auto -webkit-focus-ring-color;
    outline-offset: -2px; }
.checkbox input[type="checkbox"]:checked + label::after {
    font-family: 'FontAwesome';
    content: "\f00c"; }
.checkbox input[type="checkbox"]:disabled + label {
    opacity: 0.65; }
.checkbox input[type="checkbox"]:disabled + label::before {
    background-color: #eeeeee;
    cursor: not-allowed; }
.checkbox.checkbox-circle label::before {
    border-radius: 50%; }
.checkbox.checkbox-inline {
    margin-top: 0; }

.checkbox-primary input[type="checkbox"]:checked + label::before {
    background-color: #428bca;
    border-color: #428bca; }
.checkbox-primary input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-danger input[type="checkbox"]:checked + label::before {
    background-color: #d9534f;
    border-color: #d9534f; }
.checkbox-danger input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-info input[type="checkbox"]:checked + label::before {
    background-color: #5bc0de;
    border-color: #5bc0de; }
.checkbox-info input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-warning input[type="checkbox"]:checked + label::be {
    background-color: #f0ad4e;
    border-color: #f0ad4e; }
.checkbox-warning input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-success input[type="checkbox"]:checked + label::before {
    background-color: #5cb85c;
    border-color: #5cb85c; }
.checkbox-success input[type="checkbox"]:checked + label::after {
    color: #fff; }
    

/* ****검색버튼*** */
.btn_search {
  margin: 0 auto;
  margin-top :-1%;
  font-size: 1.5rem;
  padding: 1rem 1rem;
  display: block;
  background-color: #4b4d4f;
  border-color: #0f3f7f;
  color: #ffffff;
  font-weight: 300;
  -webkit-border-radius: 3px;
  border-radius: 3px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

.btn_search:hover {
  background-color: #244f80;
  color: #ffffff;
  border-color: #009ac9;
}
</style>

   

</body>
</html>