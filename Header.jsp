<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{
padding: 0;
margin: 0;
} 
 
  #header{
  width: 100%;
   height: 105px;
   z-index: 1;
   cursor:pointer;
   display: flex;
   justify-content: space-between;
   
  }
  /* #menu1,#menu1>li{
  list-style: none;
  cursor:pointer;
  }
  #menu1>li{
  display: inline-block;
  padding: 40px;
  text-align: right;
  } */
  #menu{
  text-align: right;
  margin-right: 50px;
  padding: 30px;
  }
  #menu1{
  	display: flex;
  	margin-top: 34px;
  }
  #menu1 li{
  	margin-left: 65px;
  	list-style: none;
  }
  #menu1 li a{
  	list-style: none;
  	font-size: 18px;
  }
  #logo{
   padding: 60px;
   font-weight: 900;
   font-size: 2em;
  }
  #menu2>li{
 display: none;
 position:relative;
 margin-left: 5px;
  z-index: 2;
  color: gray;
  font-weight: 900;
   }
  #menu1>li:hover #menu2>li {
  display: block;
   text-align: left;
   padding: 10px 0px;
   font-size:0.8em;
  }
  #menu2 li:hover{
  color: #D4AF37;
  }
  #menu2{
 	width: 100px;
  	position: absolute;
  	margin-left: -3px;
  	background-color: white;
  	text-align: left;
  	padding-left: -60px;
  }
  #menu2 li{
  	
  }
 

  a{
  text-decoration:none;
        color:black;
    }
    /* 마우스 오버(마우스 올렸을때) */
    a:hover{
        color: #D4AF37;
    }
    /* 마우스 클릭하고있을때 */
    a:active{
        color: #D4AF37;
    }
    /* 마우스 한번클릭후 */
         
	#menupro7 a{
		color: #d9b1a0;
		font-weight: bold;
	}
</style>
</head>
<c:if test="${log == null }" >
	<c:set var="log" value="손님" ></c:set>
</c:if>
<body>
<div id = "header">
	<div id="logo">
		<a onclick="location.href='centerc.do?center=Center.jsp&headerr=zero'">OoH-AHh!</a>
	</div>
		<c:if test="${headerr == 'one'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro1" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
					<li id="menupro7" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
						<ul id="menu2">
							<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
							<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
							<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
							<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
						</ul>
					</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro3"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro4"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro4"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro5" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${headerr == 'two'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro1" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
						<li id="menupro2" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
							<ul id="menu2">
								<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
								<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
								<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
								<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
							</ul>
						</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro7"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro4"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro4"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro5" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${headerr == 'three'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro1" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
						<li id="menupro2" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
							<ul id="menu2">
								<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
								<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
								<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
								<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
							</ul>
						</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro3"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro7"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro4"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro5" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${headerr == 'four'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro1" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
						<li id="menupro2" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
							<ul id="menu2">
								<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
								<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
								<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
								<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
							</ul>
						</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro3"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro4"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro7"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro5" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${headerr == 'five'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro1" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
						<li id="menupro2" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
							<ul id="menu2">
								<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
								<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
								<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
								<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
							</ul>
						</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro3"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro4"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro4"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro7" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${headerr == 'six'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro7" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
						<li id="menupro2" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
							<ul id="menu2">
								<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
								<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
								<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
								<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
							</ul>
						</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro3"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro4"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro4"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro5" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${headerr == 'zero'}">
			<div id="menu">
				<ul id="menu1">
					<li id="menupro1" onclick="change(1)"><a href='MyCart.do?headerr=six'>CART</a></li>
						<li id="menupro2" onclick="change(2)"><a href='Shop.do?shopName=EVERY&headerr=one'>SHOP</a>
							<ul id="menu2">
								<li onclick="location.href='Shop.do?shopName=EVERY&headerr=one'">EVERY</li>
								<li onclick="location.href='Shop.do?shopName=TOP&headerr=one'">TOP</li>
								<li onclick="location.href='Shop.do?shopName=BOTTOM&headerr=one'">BOTTOM</li>
								<li onclick="location.href='Shop.do?shopName=ACC&headerr=one'">ACC</li>
							</ul>
						</li>
					
					<c:if test="${log == '손님' }" >
						<li id="menupro3"><a href='centerc.do?center=Loginform.jsp&headerr=two'>LOGIN</a></li>
						<li id="menupro4"><a href='centerc.do?center=Joinform.jsp&headerr=three'>JOIN</a></li>
					</c:if>
					<c:if test="${log != '손님' }" >
						<li id="menupro3"><a href='logout.do?headerr=three'>LOGOUT</a></li>
						<li id="menupro4"><a href='mypage.do?headerr=four'>MYPAGE</a>
						<ul id="menu2">
								<li onclick="location.href='mypage.do?headerr=four'">회원정보 수정</li>
								<li onclick="location.href='orderinfo.do?headerr=four'">주문 조회</li>
							</ul>
						
						</li>
					</c:if>
					<li id="menupro5" onclick="change(5)"><a href='BoardList.do?headerr=five'>BOARD</a></li>
				</ul>
			</div>
		</c:if>
</div>
<%-- log는 ${log } --%>
<script>
 function change(n) {
	 
	 for(var i=1;i<=5;i++ ){
		var menupro = document.getElementById("menupro"+i);
		menupro.style.color = "black";
		if(i==n){
			menupro.style.color = "#d9b1a0";
		}
	 }
	
}

</script>
</body>
</html>