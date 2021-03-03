<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	#mycart-logo{
		margin : 50px;
		}
	img{
		width : 66px;
		height : 66px;
	}
	 .plma, #pronum{
	    margin-top: 20px;
	    margin-bottom: 20px;
	    border: none;
	    font-size: 16px;
	    outline:none;
	}
	 .plma{
	    width: 25px;
	    border-radius: 45px;
	}
	 #pronum{
	    border: none;
	    width: 40px;
	    text-align: center;
	    color: gray;
	    font-weight: bold;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<center>
	<div id="mycart-logo">
		<img src="img/cart_empty.jpg">
	</div>
	<div>
		<table width="600" height="30">
			<tr>
				<th></th>
				<th></th>
				<th>상품</th>
				<th>가격</th>
				<th>수량</th>
				<th>총계</th>
			</tr>
			<c:forEach var="mcto" items="${mcto }">
				<tr>
					<td><img src="img/${mcto.item_img }"></td>
					<td>${mcto.item_name }</td>
					<td>${mcto.item_price }</td>
					<td>
						<input class="plma" type="button" value="-" onclick="plma(-1);">
            			<input id="pronum" type="text" name="pronum" value="${mcto.cnt }" readonly="readonly">
            			<input class="plma" type="button" value="+" onclick="plma(+1);">
					</td>
					<td>${mcto.item_price * mcto.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
				<table>
					<td><input type="text" placeholder="쿠폰코드"></td>
					<td><input type="button" value="쿠폰적용하기"></td>
					<td><input type="button" value="장바구니 업데이트"></td>
					<td><input type="button" value="결제로 진행"></td>
				</table>
			</div>
			<div>
				<h2>장바구니 총계</h2>
				<table>
					<tr>
						<td>소계</td>
						<td></td>
					</tr>
					<tr>
						<td>배송</td>
						<td>무료배송</td>
					</tr>
					<tr>
						<td>총계</td>
						<td></td>
					</tr>
				</table>	
			</div>
	</div>
</center>
</body>
<script>
    var pronum =  document.querySelectorAll("#pronum"); // 상품개수
    
    // 플마
    function plma(num){
        if(num == -1 && pronum.value == 0){
           pronum.value = 0;
        }else{
            pronum.value = parseInt(pronum.value) + parseInt(num);
        }
    }
    
    // 3자리마다 콤마 찍기
    var shopPrice = document.querySelectorAll(".shopPrice");
	
	for(var i=0; i<shopPrice.length; i++){
        var price = parseInt(shopPrice[i].innerHTML);
		shopPrice[i].innerHTML = "₩" + price.toLocaleString();
	}
</script>
</html>