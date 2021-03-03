<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#shopTop{
    	width: 97%;
    	margin: 0 5px 0 15px;
        height: 200px;
        background-image: url(img/shop_up.jpg);
    }
    #shopTop p{
    	width: 300px;
        color: white;
        font-size: 2em;
        font-weight: bold;
        padding-top: 80px;
        text-align: center;
        margin-left: 43%;
        margin-right: 50%;
    }
	#shopTop a{
		text-decoration: none;
	}
	#shopTop a label{
		cursor: pointer;
	}
	#shopDMiddle{
	    width: 1200px;
	    margin: 0 auto;
	    padding: 50px 30px 50px 30px;
	    /*background: pink;*/
	}
	#shopDImg, #shopDetail{
	    display: inline-block;
	    vertical-align: top;
	}
	#shopDImg{
	    width: 590px;
	}
	#shopDImg img{
	    width: 540px;
	    height: 540px;
	    margin-left: 60px;
	}
	#shopDetail{
	    width: 520px;
	    margin-left: 26px;
	}
	#shopDetail p:first-of-type{
	    font-size: 2.2em;
	    margin-bottom: 20px;
	}
	#shopDetail p:nth-of-type(2){
	    font-size: 1em;
	    margin-bottom: 20px;
	}
	#shopDetail p:nth-of-type(2) label{
	    color: gray;
	}
	#shopDetail p:last-of-type{
	    font-size: 1.6em;
	}
	#shopDetail .plma, #shopDetail #pronum{
	    margin-top: 30px;
	    margin-bottom: 30px;
	    border: none;
	    font-size: 22px;
	    outline:none;
	}
	#shopDetail .plma{
	    width: 25px;
	    border-radius: 45px;
	}
	#shopDetail #pronum{
	    border: none;
	    width: 40px;
	    text-align: center;
	    color: gray;
	    font-weight: bold;
	}
	.shopbtn{
		margin-top: 30px;
	    width: 150px;
	    height: 50px;
	    font-size: 18px;
	}
	#shopDBottom{
	    width: 1020px;
	    margin: 0 auto;
	    text-align: center;
	}
	#shopDBottom img{
	    left: auto;
	    right: auto;
	}
	#shopDBottom li a{
	    transition-duration: 1s;
	    transition-timing-function: ease-in;
	    font-weight: none;
	    color: gray;
	}
	#shopDBottom .active a{
	    font-weight: bold;
	    color: black;
	}
	#shopDBottom li a:hover{
	    color: #d9b1a0;
	}
	.nav li{
		margin-top: 65px;
		list-style: none;
		font-size: 25px;
		font-weight: bold;
	}
	hr{
		margin-top: 30px;
	}
	#home img{
		margin-top: 100px;
	}
	.shopbtn:first-of-type {
		color:white; background: #CFA987; border: none;
	}
	.shopbtn:last-of-type {
		color:white; background: #3E3E3E; border: none;
	}
	
</style>
</head>
<body>
<form action="addcart.do?item_code=${item_code}&headerr=six" method="post">
<div id="shopTop">
    <a href="Shop.do?headerr=one"><p>SHOP</p></a>
</div>
<div id="shopDMiddle">
    <div id="shopDImg">
        <img src="img/${item_img}">
    </div>
    <div id="shopDetail">
        <p>${item_name}</p>
        <p>카테고리: <label>${cate_name}</label></p>
        <p class="shopPrice">${item_price}</p>
        <span class="cntbtn">
            <input class="plma" type="button" value="-" onclick="plma(-1);">
            <input id="pronum" type="text" name="pronum" value="1" readonly="readonly">
            <input class="plma" type="button" value="+" onclick="plma(+1);">
        </span><br>
        <input class="shopbtn" type="submit" value="장바구니">
        <input class="shopbtn" type="submit" value="바로구매" formaction="onebuy.do?item_code=${item_code}&headerr=zero">
    </div>
</div>
<div id="shopDBottom">
    <ul class="nav nav-tabs">
      <li class="active"><a data-toggle="tab" href="#home">상품정보</a></li>
      <hr>
    </ul>

    <div class="tab-content">
      <div id="home" class="tab-pane fade in active">
        <img src="img/${item_detailimg}">
      </div>
    </div>
</div>
</form>
<script>
    var pronum =  document.getElementById("pronum"); // 상품개수
    
    // 플마
    function plma(num){
        if(num == -1 && pronum.value == 1){
           pronum.value = 1;
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
    // 장바구니 클릭시 알림 창  
	function cart(){
		var myitem = confirm("해당상품을 장바구니에 담으시겠습니까?")
		if(myitem == true){
			location.href='MyCart.do?headerr=six';
		}
	}
	  	
</script>
</body>
</html>





















