<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    #main{
        width: 99%;
        text-align: center;
        padding-top: 50px;
        padding-bottom: 80px;
        margin: 0 auto;
    }
    #mainTop{
        width: 1500px;
        height: 1000px;
        background-image: url(img/topImg.jpg);
        margin: 0 auto;
    }
    #mainTop img{margin-top: 370px;}
    #mainTop p{
        color: white;
        font-size: 1.5em;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    #mainTop button{
        width: 150px;
        height: 60px;
        background: white;
        font-size: 1em;;
        font-weight: bold;
        border: none;
        outline: none;
    }
    #mainTop button:hover{color: #d9ac86;}
    #mainEvery{width: 1200px; margin: 0 auto;}
    #mainEvery h1{margin-top: 60px; margin-bottom: 60px;}
    #mainEvery ul{margin-left: -16px; margin-left: 20px;}
    #mainEvery ul li{
        float: left;
        margin: 10px 16px;
        text-align: center;
        list-style: none;
    }
    #mainEvery ul li img{
        width: 256px;
        height: 256px;
    }
    #mainEvery ul li p:first-of-type{
    	margin-top: 25px;
    	margin-bottom: 15px;
    }
    #mainEvery ul li p:nth-of-type(2){
        color: #c79a73;
        font-weight: bold;
        font-size: 15px;
    }
    #mainEvery li #shopItemin01{display: none;}
    #mainEvery li:hover{
        opacity: 0.5;
        transition-duration: 0.5s;
    }
    #mainEvery li:hover #shopItemin01{
    	position: absolute;
    	margin-top: 120px;
    	margin-left: 90px;
        display: block;
        width: 70px;
        height: 30px;
        border: none;
        cursor: pointer;
        font-weight: bold;
    }
    #shopItemin01:hover{
    	background: #c79a73;
    	color: white;
    	opacity: 1;
    }
    /*가운데 이미지*/
    #mainMiddle img{margin-top: 70px;margin-bottom: 70px;}
    #mainMiddle h1{margin-bottom: 60px;}
    #mainMiddle p:first-of-type{font-size: 1.2em;margin-bottom: 60px;}
    #mainMiddle p:nth-of-type(2), #mainMiddle p:nth-of-type(3){font-size: 14px;}
    #mainMiddle p:nth-of-type(2) span{font-weight: bold;}
    #mainMiddle p:nth-of-type(3){margin-bottom: 30px;}
    #mainMiddle p:nth-of-type(4), #mainMiddle p:nth-of-type(5), #mainMiddle p:nth-of-type(6){font-size: 13px;}
    #mainMiddle p:nth-of-type(5), #mainMiddle p:nth-of-type(6){}
    #middleImg{margin-top: 110px;}
    #middleImg img:first-of-type{margin-right: 25px;}
    #middleImg img:nth-of-type(3){margin-top: 110px;}
</style>
</head>
<body>
<div id = "main">
	<div id="mainTop">
		<img src="img/topLetter.png">
		<p>Always wear me. One a first date you'll do awesome.</p>
		<button onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">SHOP NOW</button>
	</div>
	<div id="mainEvery">
       <h1>EVERY</h1>
        <ul>
        	<c:forEach var="shopList" items="${a}">
        	<a href="ShopDetails.do?itemNum=${shopList.item_code}&headerr=one">
            <li>
                <input id="shopItemin01" type="button" value="상세보기">
	            <img src="img/${shopList.item_img}">
	            <p>${shopList.item_name}</p>
	            <p class="shopPrice">${shopList.item_price}</p>
            </li>
            </a>
            </c:forEach>
        </ul>
	</div>
	<div id="mainMiddle">
	    <img src="img/middleImg.jpg">
	    <h1>SEASON CONCEPT.</h1>
        <p>BLOOMING</p>
        <p>우아의 <span>20’FALL/WINTER COLLECTION은 BLOOMING</span> 이란 주제로 전개되었다.</p>
        <p>다채로운 원단 텍스쳐를 기반으로 한층 더 성숙해진 페미닌한 무드의 우아를 만나볼 수 있다.</p>
        <p>THE ‘20 FALL/WINTER COLLECTION OF OOHAHH WAS INTRODUCED UNDER THE THEME OF ‘BLOOMING’.</p>
        <p>BASED ON THE SEASON’S COLORFUL TEXTURE OF FABRIC USED, YOU CAN DISCOVER THE MORE MATURE,</p>    <p>FEMININE SIDE OF OOHAHH.</p>
	</div>
	<div id="middleImg">
	    <img src="img/middleLeft.jpg">
	    <img src="img/middleRight.jpg">
	    <img src="img/bottomImg.jpg">
	</div>
</div>
<script>
	var shopPrice = document.querySelectorAll(".shopPrice");
	
	for(var i=0; i<shopPrice.length; i++){
	    var price = parseInt(shopPrice[i].innerHTML);
		shopPrice[i].innerHTML = "₩" + price.toLocaleString(); // 3자리마다 콤마 찍기
	}
</script>
</body>
</html>