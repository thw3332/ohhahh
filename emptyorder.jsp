<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	#shopTop{
    	width: 97%;
    	margin: 0 15px 0 15px;
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
#mycart-logo{
		margin : 50px;
		text-align: center;
		}
	#mycart-logo img{
		width : 150px;
		height : 150px;
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
	 .pronum{
	    border: none;
	    width: 40px;
	    text-align: center;
	    color: gray;
	    font-weight: bold;
	}
	#backshop{
	width: 150px;
	height: 50px;
	border: 3px solid black;
	background-color: white;
	font-weight: 900;
	
	}
	#msg{
	text-align: center;
	}
</style>
<title>Insert title here</title>
</head>
<body>

	<div id="shopTop">
		<a href='orderinfo.do?headerr=four'><p>ORDER</p></a>
	</div>
	<div id="mycart-logo">
		<img src="img/cart_empty.jpg">
	</div>
	<div id="msg">
	<br><br><br><br>
	주문내역이 없습니다.
	<br><br><br><br>
	<input id="backshop" type="button" onclick="location.href='Shop.do?shopName=EVERY&headerr=one'" value="상점으로 돌아가기">
	<br><br>
	</div>

</form>
</body>

</html>