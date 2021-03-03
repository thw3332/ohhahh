<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 #moreinfolist{
 list-style: none;
 display: inline-block;
 position: relative;
 }
#moreinfolist img{
  width: 270px;
}
#moreinfolist li{
 list-style: none;
 padding: 10px 40px;
}
#moreinfo{
width: 100%;
text-align: center;

margin: 0 auto;
padding: 150px 0px;
}
#catename{
font-size: 2em;
width: 100%;
font-weight: 900;
text-decoration: overline;
background-color: purple;
opacity:0.3;
color:white;
height: 150px;
line-height:150px;
margin-bottom: 150px;
text-shadow: 1px 1px 1px red;
}

#option2	{
display: none;
position: absolute;
top:120px;
right:138px;
padding: 10px;
border-style: none;
background-color: black;
color:white;
font-weight: 900;

}
</style>
</head>
<body>


<div id="moreinfo">
 <div id="catename">${Information }</div>
 


 <ul id="moreinfolist" > 

<li><img src="img/${a.item_img }"></li>
<li>${a.item_name }</li>    
<li><fmt:formatNumber value="${a.item_price }" type="currency" ></fmt:formatNumber>  </li>
<li><img src="img/${a.item_detailimg }"></li>
 </ul>


</div>
<%-- 카테고드 ${b.cate_code } <br>
카테 이름 ${b.cate_name } <br>
아이템 코드${b.item_code } <br>
 카테 코드${b.cate_code } <br>
 아이템이름 ${b.item_name } <br>
아이템가격 ${b.item_price } <br>
아이템 이미지${b.item_img } <br>
디테일 이미지${b.item_detailimg } <br> --%>
</body>
</html>