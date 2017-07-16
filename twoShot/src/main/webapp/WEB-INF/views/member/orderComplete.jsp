<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "..\include\tempHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
		<hr>
			<h1>주문이 완료되었습니다.!</h1>
		<hr>
 <!-- 주문정보 불러오는 곳  -->
        <fieldset>
          <div id="legend">
            <legend>Order List</legend>
          </div>
     
 			<div class="chkclass">
                  <table class="table">
                    <thead>
                      <tr>
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
                        <td>${cVo.cno}</td>
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



   <form role="form" method="get">
          
        <input type="hidden" name="memberid" value="${login.memberid}">
    	
    	<!-- hidden타입으로 화면에 안보이게 값을 controller에 전달한다. form태그 안에, 전달해줄 값을 value에 set -->
    	<input type="hidden" name="productname" value="${cVo.productname}">
    	<input type="hidden" name="productthumimage" value="${cVo.productthumimage}">
    	<input type="hidden" name="productcolor" value="${cVo.productcolor}">
    	<input type="hidden" name="productsize" value="${cVo.productsize}">
    	<input type="hidden" name="productstatus" value="주문완료">
    	<input type="hidden" name="pno" value="${cVo.cno}">
 
   </form>

</body>
</html>