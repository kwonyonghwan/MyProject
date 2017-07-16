<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file= "..\include\tempHeader.jsp" %>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>장바구니</title>
    
    <!-- Font awesome -->
    <link href="\resources\main_bootstrap\css\font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="\resources\main_bootstrap\css\bootstrap.css" rel="stylesheet">   
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="\resources\main_bootstrap\css\jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="\resources\main_bootstrap\css\jquery.simpleLens.css">    
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="\resources\main_bootstrap\css\slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="\resources\main_bootstrap\css\nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="\resources\main_bootstrap\css\theme-color/default-theme.css" rel="stylesheet">
    <!-- Top Slider CSS -->
    <link href="\resources\main_bootstrap\css\sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link href="\resources\main_bootstrap\css\style.css" rel="stylesheet">    

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
  </head>
  
  <body> 
   <!-- wpf loader Two -->
    <div id="wpf-loader-two" style="display: none;">          
      <div class="wpf-loader-two-inner">
        <span>Loading</span>
      </div>
    </div> 
    <!-- / wpf loader Two -->       
 <!-- SCROLL TOP BUTTON -->
    <a class="scrollToTop" href="#" style="display: none;"><i class="fa fa-chevron-up"></i></a>
  <!-- END SCROLL TOP BUTTON -->

 
  <!-- CART PAGE 상단 글자 -->
  <section id="aa-catg-head-banner">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h1>Cart Page</h1>
      </div>
     </div>
   </div>
  </section>
  <!-- CART PAGE 상단 글자 -->

<br><br><br><br>

 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
<!--              <form action=""> 0518 방금 지운 부분!-->
               <div class="table-responsive">
               
                  <!-- 장바구니 표 -->
                 <div class="chkclass">
                  <table class="table">
                    <thead>
                      <tr>
                        <th style="width:50px"></th>
                        <th>CNO</th>
                        <th>PRODUCT</th>
<!--                         <th>MODEL</th> -->
                        <th>NAME</th>
                        <th>COLOR</th>
                        <th>SIZE</th>
                        <th>PRICE</th>
<!--                         <th>Quantity</th> -->
                        <th>QUANTITY</th>
                        <th>TOTAL</th>
                        <th>ORDER</th>
                      </tr>
                    </thead>
                    <tbody>    
                   
                   <form role="form" method="post">                
                   <c:forEach items='${cart}' var='cartVO'>  <!-- forEach문 -->
                      <tr>
                         <td><input type="checkbox" id="pno" name="pno" value="${cartVO.pno}">
                         <td>${cartVO.cno}</td>
                        <td><a href="/product/productDetail?pno=${cartVO.pno}"><img src="/resources/img_product/${cartVO.productthumimage}" alt="img"></a></td> <!-- 상품이미지 -->
<%--                         <td>${cartVO.productmodel}</a></td> 아직 DB에 추가가 안된 부분! --%> 
                        <td><a class="aa-cart-title" href="#">${cartVO.productname}</a></td> <!-- 상품명 -->
                        <td>${cartVO.productcolor}</td>
                        <td>${cartVO.productsize}</td>
                        <td><fmt:formatNumber value="${cartVO.productprice}" pattern="#,###.##"/></td> <!-- 개당 가격 -->
                        <td>${cartVO.productcount}</td> <!-- 수량 -->
<!--                         <td><input class="aa-cart-quantity" type="number" value="1"></td> -->
                        <td><fmt:formatNumber value="${cartVO.productprice}" pattern="#,###.##"/></td>	<!--${total} 총계 -->
                        <td><button class="aa-cart-view-btn" type="submit">주문하기</button></td>
                      </tr>
                   </c:forEach>
                     
                      </tbody>
                  </table>
                  <div class="aa-cart-coupon">
                            <button id="submitFrm" class="aa-cart-view-btn2" type="submit" onclick="this.form.action='/member/deleteCart'">선택삭제</button>
                          </div>
                          <button class="aa-cart-view-btn2" type="submit">전체삭제</button>
                  </div>
                </div>
             </form>
             
             <!-- 총 합계 계산 -->
             <div class="cart-view-total">
               <h4>Cart Totals</h4>
               <table class="aa-totals-table">
                 <tbody>
                   <tr>
                     <th>Total</th>
                     <td><fmt:formatNumber value="${total}" pattern="#,###.##"/></td>
                   </tr>
                 </tbody>
               </table>
               <a href="#" class="aa-cart-view-btn">결제하기</a>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

    
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>  
    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="js/jquery.smartmenus.js"></script>
    <!-- SmartMenus jQuery Bootstrap Addon -->
    <script type="text/javascript" src="js/jquery.smartmenus.bootstrap.js"></script>  
    <!-- To Slider JS -->
    <script src="js/sequence.js"></script>
    <script src="js/sequence-theme.modern-slide-in.js"></script>  
    <!-- Product view slider -->
    <script type="text/javascript" src="js/jquery.simpleGallery.js"></script>
    <script type="text/javascript" src="js/jquery.simpleLens.js"></script>
    <!-- slick slider -->
    <script type="text/javascript" src="js/slick.js"></script>
    <!-- Price picker slider -->
    <script type="text/javascript" src="js/nouislider.js"></script>
    <!-- Custom js -->
    <script src="js/custom.js"></script> 



<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");  //role='form으로 선언한 form태그.
	
	console.log(formObj);
	
	//삭제 부분
	$(".aa-cart-view-btn").on("click", function() {
		formObj.attr("action", "/member/deleteCart");
		formObj.submit();
	});
});
	

//체크박스에서 전체선택 및 해제
function checkboxSelectQue(n,obj) {
    var i;
    var chk = document.getElementsByName(obj);
    var select = chk.length;
    for (i = 0; i < select; i++) {
        if (n == 1) chk[i].checked = true; //전체선택
        if (n == 2) chk[i].checked = false; //전체해제
        if (n == 3) chk[i].checked = !chk[i].checked; //선택반전
    }
}

//체크박스에서 선택된 갯수 및 값 확인. 
function checkboxSelectCount(obj) {
    var i, sum=0, tag=[], str="";
    var chk = document.getElementsByName(obj);
    var select = chk.length;
    for (i = 0; i < select; i++) {
        if (chk[i].checked == true) {
            tag[sum] = chk[i].value;
            sum++;
        }
    }
    str += "선택갯수 : "+sum;
    if(tag.length > 0) str += "\n값 : "+tag.join(",");
    alert(str);
}
</script>

<!-- 카트삭제 -->



<!-- 체크박스 다중선택값을 controller에 보낸다. -->
<script>
$(document).ready(function() {
	  $("#submitFrm").on("click", function() {

	      var param = "";
	      $(".chkclass :checked").each(function() {
	        if( param=="" )
	          param = "pno="+$(this).parent().children("#pno").val();
	        else param = param + "&pno="+$(this).parent().children("#pno").val();
	 
	        param = param + "&pno="+$(this).parent().children("#pno").val();
	      });
	           
	      $.ajax({
	        url : '/member/cartList',
	        type : 'post',
	        data : param,
	        dataType : 'text',
	        success : function(data) {
	          console.log('return string : ' + data);
	        },
	        error : function() { console.log('error');}
	      });
	    }
	  );
	});
</script>

  
</body></html>
