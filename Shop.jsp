<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	#shopTop a p{
		cursor: pointer;
	}
    #shopMiddle{
        width: 1200px;
        margin: 0 auto;
    }
    #shopMiddle a{
        text-decoration: none;
        color: black;
    }
    #shopMiddle ul li{
        list-style: none;
    }
    #shopNav, #shopContain{
        display: inline-block;
        vertical-align: top;
    }
    /* search 부분!  */
    #shopNav{
        width: 270px;
        margin: 40px 30px;
    }
    #shopNav label{
        font-weight: bold;
        font-size: 19px;
    }
    #shopNav input:first-of-type{
        width: 200px;
        height: 30px;
        margin-top: 12px;
        padding-left: 10px;
        border: 1px solid gray;
    }
    #shopNav input:nth-of-type(2){
        position: absolute;
        width: 40px;
        height: 34px;
        margin-top: 12px;
        margin-left: -37px;
        background: none;
        border: none;
        cursor: pointer;
        z-index: 10;
        outline: none;
    }
    #shopNav i{
        position: absolute;
        color: gray;
        margin-top: 20px;
        margin-left: -25px;
    }
    /* 상품 네비 */
    #shopNav .shopShop{
        margin-top: 30px;
    }
    #shopNav .shopShop ul li{
        margin: 10px 0;
    }
    #shopNav .shopShop ul li a{
        color: gray;
        transition-duration: 1s;
        transition-timing-function: ease-in;
    }
    #shopNav .shopShop ul li a:hover{
        color: #d9b1a0;
    }
    .shopShop p{
        color: gray;
    }
    /*상품 리스트 부분!*/
    #shopContain{
        width: 830px;
        margin: 40px 30px 40px 0;
    }
    #shopContop, #shopItem{
        width: 830px;
    }
    #shopItem{
        width: 900px;
        clear: both;
    }
    #shopItem li #shopItemin01{
    	display: none;
    }
    #shopItem li:hover{
        opacity: 0.5;
        transition-duration: 0.5s;
    }
    #shopItem li:hover #shopItemin01{
    	position: absolute;
    	margin-top: 130px;
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
    #shopContop select{
        width: 200px;
        height: 50px;
        padding-left: 10px;
        color: gray;
        border: 1px solid gray;
        cursor: pointer;
        -webkit-appearance: none;  /* 네이티브 외형 감추기 */
        -moz-appearance: none;
        appearance: none;
        background: url(img/checkdown.JPG) no-repeat 95% 50%;
    }
    #shopContop label:first-of-type{
        float: left;
        margin-top: 12px;
        color: white;
    }
    #shopContop label:last-of-type{
        float: right;
        margin-top: 12px;
        color: gray;
    }
    #shopItem ul{
        margin-left: -16px;
    }
    #shopItem ul li{
        float: left;
        margin: 10px 16px;
        text-align: center;
    }
    #shopItem ul li img{
    	margin-top: 15px;
        width: 256px;
        height: 256px;
    }
    #shopItem ul li p:first-of-type{
    	margin-top: 25px;
    	margin-bottom: 15px;
    }
    #shopItem ul li p:nth-of-type(2){
        color: #c79a73;
        font-weight: bold;
        font-size: 14px;
    }
    /* 최근 본 상품 */
    #shopRecent1, #shopRecent2{
        display: inline-block;
        vertical-align: top;
    }
    #shopRecent1 img{
        width: 70px;
        height: 70px;
    }
    #shopRecent2{
        width: 150px;
    }
    #shopRecent2 p{
        margin-left: 7px;
        font-weight: bold;
        font-size: 13px;
    }
    #shopRecent2 p:nth-of-type(2){
        margin-top: 5px;
        color: #c79a73;
    }
    #shopPaging{
	    width: 833px;
	    text-align: center;
	    clear: both;
	}
	#shopPaging button{
	    margin-top: 25px;
	    margin-bottom: 40px;
	    width: 30px;
	    height: 30px;
	    font-size: 0.8em;
	    border: 1px solid gray;
	    background: white;
	    cursor: pointer;
	    outline: none;
	    border-radius: 2px;
	    transition-duration: 1s;
        transition-timing-function: ease-in;
	}
	#shopPaging button:hover{
	    background: gray;
	    color: white;
	}
	#shopPaging .shopPageBtnColor{
	    background: gray;
	    color: white;
	}
	#searchZero{width: 830px; text-align: center;}
</style>
</head>
<body>
<c:set var="shopName" value="${shopName}"></c:set> <!-- 카테고리 이름 -->
<c:set var="ClickCnt" value="${ClickCnt}"></c:set> <!-- 누른 숫자 -->

<c:set var="itemCount" value="${itemCount}"></c:set> <!-- 상품 총 개수 -->
<c:set var="maxCount" value="${itemCount%12}"></c:set> <!-- 1-12 나타낼때의 그 12 -->
<c:set var="nanuCount" value="${itemCount/12}"></c:set>
<c:if test="${itemCount>=12 && ClickCnt<nanuCount}">
	<c:set var="maxCount" value="12"></c:set>
</c:if>

<c:set var="list" value="${list}"></c:set> <!-- 1:인기순 2:최신순 3:낮은가격 4:높은가격 -->
<c:set var="searchCnt" value="${searchCnt}"></c:set> <!-- 최신순, 인기순 드롭박스 없애는 체크키 -->
<c:set var="recentCnt" value="${recentCnt}"></c:set> <!-- 최근 본 상품 총 갯수 -->
<c:set var="cartCnt" value="${cartCnt}"></c:set><!-- 장바구니  상품 총 갯수 -->
<div id="shopTop">
	<a href="Shop.do?headerr=one"><p>${shopName}</p></a>
</div>
<div id="shopMiddle">
<nav id="shopNav">
    <div id="shopSearch">
    <form action="Shop.do?searchCnt=-1&headerr=one" method="post">
        <label>SEARCH</label><br>
        <input type="text" name="itemName" placeholder="Search Here">
        <input type="submit" value="">
        <i class="fa fa-search" aria-hidden="true"></i>
    </form>
    </div>
    <div class="shopShop">
        <label>SHOP</label>
        <ul class="shopUl01">
            <li><a href="Shop.do?shopName=EVERY&headerr=one">EVERY</a></li>
            <li><a href="Shop.do?shopName=TOP&headerr=one">TOP</a>
            <li><a href="Shop.do?shopName=BOTTOM&headerr=one">BOTTOM</a>
            <li><a href="Shop.do?shopName=ACC&headerr=one">ACC</a>
        </ul>
    </div>
    <div class="shopShop">
        <label>CART</label>
    <c:if test="${cartCnt==0}">
     	<p>장바구니에 상품이 없습니다.</p>
    </c:if>
    <c:if test="${cartCnt!=0}">
 		<ul>
      	<c:forEach var="cartItem" items="${cartItem }">
      		<a href="ShopDetails.do?itemNum=${cartItem.item_code}">
           <li>
               <div id="shopRecent1">
                   <img src="img/${cartItem.item_img}">
               </div>
               <div id="shopRecent2">
                   <p>${cartItem.item_name}</p>
                   <p class="shopPrice">${cartItem.item_price}</p>
               </div>
           </li>
           </a>
          </c:forEach>
      </ul>
	</c:if>
    </div>
    <div class="shopShop">
        <label>최근 본 상품</label>
    
    <c:choose>
	    <c:when test="${recentCnt==0}">
	    	<p>최근 본 상품이 없습니다.</p>
	   	</c:when>
	   	<c:otherwise>
	   		<ul>
	        	<c:forEach var="recentItem" items="${recentItem }">
	        		<a href="ShopDetails.do?itemNum=${recentItem.item_code}">
		            <li>
		                <div id="shopRecent1">
		                    <img src="img/${recentItem.item_img}">
		                </div>
		                <div id="shopRecent2">
		                    <p>${recentItem.item_name}</p>
		                    <p class="shopPrice">${recentItem.item_price}</p>
		                </div>
		            </li>
		            </a>
	            </c:forEach>
	        </ul>
	    </c:otherwise>
    </c:choose>
    </div>
</nav>
<div id="shopContain">
   <div id="shopContop">
   	<c:choose>
   		<c:when test="${searchCnt==0}">
	   		<select name="shopList" onchange="location.href=(this.value)"> 
		    <c:choose>
		    	<c:when test="${list==1}">
			    	<option value="1" selected>인기순</option>
			        <option value="Shop.do?list=2&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">최신순</option>
			        <option value="Shop.do?list=3&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">낮은가격순</option>
			        <option value="Shop.do?list=4&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">높은가격순</option>
		    	</c:when>
		    	<c:when test="${list==2 || list==0}">
			    	<option value="1">인기순</option>
			        <option value="Shop.do?list=2&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one" selected>최신순</option>
			        <option value="Shop.do?list=3&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">낮은가격순</option>
			        <option value="Shop.do?list=4&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">높은가격순</option>
		    	</c:when>
		    	<c:when test="${list==3}">
			    	<option value="1">인기순</option>
			        <option value="Shop.do?list=2&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">최신순</option>
			        <option value="Shop.do?list=3&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one" selected>낮은가격순</option>
			        <option value="Shop.do?list=4&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">높은가격순</option>
		    	</c:when>
		    	<c:when test="${list==4}">
			    	<option value="1">인기순</option>
			        <option value="Shop.do?list=2&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">최신순</option>
			        <option value="Shop.do?list=3&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one">낮은가격순</option>
			        <option value="Shop.do?list=4&shopName=${shopName}&ClickCnt=${ClickCnt}&headerr=one" selected>높은가격순</option>
		    	</c:when> 
		    </c:choose>
		    </select>
   		</c:when>
   		
   		
   		
   		<c:otherwise>
   			<label>${offset+1}-${noOfRecords-1} of ${itemCount} results</label>
   		</c:otherwise>
   	</c:choose>
	    <label>${offset+1}-${noOfRecords-1} of ${itemCount} results</label>
	</div>
	<div id="shopItem">
	   <ul>
	   		<c:set var="searchCnt" value="0"></c:set>
	   		<c:forEach var="shopList" items="${a}">
	   		   <a href="ShopDetails.do?itemNum=${shopList.item_code}&headerr=one">
	       	   <li>
	       	   		<input id="shopItemin01" type="button" value="상세보기">
	                <img src="img/${shopList.item_img}">
	                <p>${shopList.item_name}</p>
	                <p class="shopPrice">${shopList.item_price}</p>
	           </li>
	           </a>
	           <c:set var="searchCnt" value="${searchCnt=searchCnt+1}"></c:set>
       	   </c:forEach>
       	   <c:if test="${searchCnt==0}">
       	   		<li id="searchZero"><p>검색한 이름의 상품이 존재하지 않습니다.</p></li>
       	   </c:if>
	   </ul>
	</div>
	<div id="shopPaging">
	<c:set var="i" value="0"></c:set>
	
	
	<c:forEach begin="0" end="${nanuCount}">
		<c:choose>
			<c:when test="${i+1==ClickCnt}">
				<button class="shopPageBtnColor" onclick="location.href='Shop.do?ClickCnt=${i+1}&list=${list}&shopName=${shopName}&headerr=one'">${i+1}</button>
			</c:when>
			<c:otherwise>
				<button class="shopPageBtn" onclick="location.href='Shop.do?ClickCnt=${i+1}&list=${list}&shopName=${shopName}&headerr=one'">${i+1}</button>
			</c:otherwise>
		</c:choose>
		<c:set var="i" value="${i=i+1}"></c:set>
	</c:forEach>
	</div>
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