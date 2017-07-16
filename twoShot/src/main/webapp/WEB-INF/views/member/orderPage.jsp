<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file= "..\include\tempHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>
        OrderPage
    </title>
  
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
  
</head>
<body>
<div class="container">
  <div class="row-fluid">
      
      <!-- 주문정보 불러오는 곳  -->
        <fieldset>
          <div id="legend">
            <legend>Order List</legend>
          </div>
     
 			<div class="chkclass">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>PNO</th>
                        <th>PRODUCT</th>
                        <th>NAME</th>
                        <th>MODEL</th>
                        <th>COLOR</th>
                        <th>SIZE</th>
                        <th>PRICE</th>
                      </tr>
                    </thead>
                    <tbody>    
                  
                      <tr>
                         <td>${cVo.pno}</td>
                        <td><a href="/product/productDetail?pno=${cVo.pno}"><img src="/resources/img_product/${cVo.productthumimage}" alt="img"></a></td> <!-- 상품이미지 -->
                        <td><a class="aa-cart-title" href="#">${cVo.productname}</a></td> <!-- 상품명 -->
                        <td>${cVo.productmodel}</a></td> 
                        <td>${cVo.productcolor}</td>
                        <td>${cVo.productsize}</td>
                        <td>${cVo.productprice}</td> <!-- 개당 가격 -->
                      </tr>
				</tbody>
				</table>
				</div>
        </fieldset>
        
        
        <fieldset>
<!--           <div id="legend"> -->
<!--             <legend>Address</legend> -->
<!--           </div> -->

<!--           <div class="form-group"> -->
<!--             <label class="control-label col-sm-3" for="company">${memberVO.memberaddress}</label> -->
<!--             <div class="col-sm-4"> -->
<!--               <input type="text" id="company" name="company" placeholder="" value="" class="form-control"> -->
<!--             </div> -->
<!--           </div> -->

    <form role="form" method="post">
          
        <input type="hidden" name="memberid" value="${login.memberid}">
    	
    	<!-- hidden타입으로 화면에 안보이게 값을 controller에 전달한다. form태그 안에, 전달해줄 값을 value에 set -->
    	<input type="hidden" name="productname" value="${cVo.productname}">
    	<input type="hidden" name="productthumimage" value="${cVo.productthumimage}">
    	<input type="hidden" name="productcolor" value="${cVo.productcolor}">
    	<input type="hidden" name="productsize" value="${cVo.productsize}">
    	<input type="hidden" name="productstatus" value="장바구니">
    	<input type="hidden" name="pno" value="${cVo.pno}">
    	<input type="hidden" name="productprice" value="${cVo.productprice}">
          
          
          <div class="form-group">
            <div class="col-sm-offset-3 col-sm-4">
              <button type="submit" class="btn btn-success" onclick="this.form.action='/member/putOrder'">ORDER</button>				
            </div>
          </div>
      </form>
        </fieldset>
    </div>
</div>

</body>
</html>
