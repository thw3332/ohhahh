<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	#mycart-logo{
		margin : 50px;
		}
	#mycart-logo img{
		width : 150px;
		height : 150px;
	}
	#proimg{
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
	 .pronum{
	    border: none;
	    width:15px;
	    text-align: center;
	    color: gray;
	    font-weight: bold;
	}
	#cartable{
	border: 1px solid #DCDCDC;
	border-collapse: collapse;
	 margin: 0 auto;
	}
	#cartable th,#cartable td{
	border-bottom: 1px solid #DCDCDC;
	padding-top: 10px;
    padding-bottom: 10px;	
    padding-right: 20px;
    padding-left: 20px;
	}
	.rightborder{
	border-right: 1px solid #DCDCDC;

	}
	#realsum1,#realsum2{
	border-style: none;
	}
	#gun,#realsum2{
	color: #FED700;
	font-size: 1.3em;
	}
	#buttontable{
	margin-left: 800px;
	}
	#buttontable input{
	width : 150px;
	height:50px;
	font-weight: 900;
	border-style: none;
	margin: 10px;
	}
	#sumdiv td{
	padding: 10px 0px;
	}
	#sumdiv td:nth-of-type(2){
		text-align: right;
	}
	#sumdiv{
	margin-left: 1150px;
	}
	#myCartMain{
	margin: 0 auto;
	text-align: center;
	}
	#lasttable td{text-align: right;}
	#lasttable td input{text-align: right;}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="myCartMain">
	<div id="shopTop">
		<a href='orderinfo.do?headerr=four'><p>ORDER</p></a>
	</div>
	<div id="mycart-logo">
		<img src="img/cart_empty.jpg">
	</div>
	<div>
	<form action="delete.do" method="get">
		<table width="800" height="30" id="cartable">
			<tr id="cartr">
			<th ><input type="checkbox"  onclick="allckbox()" id="all" checked="checked"></th>
				<th colspan="2">상품</th>
				<th>가격</th>
				<th>총계</th>
				
			</tr>
			<c:set var="cnt" value="1"></c:set>
			<c:set var="sum" value="0"></c:set>
			<c:forEach var="mcto" items="${mcto }">
			<input type="hidden" id="code${cnt}" value="${mcto.item_code }">
				<tr id="cartr">
				    <td class="rightborder"><input type="checkbox" onclick="ckbox(${cnt})" id="ck${cnt }" checked="checked" value="${mcto.item_code }" name="itemcode"></td>
					<td><img src="img/${mcto.item_img }" id="proimg"></td>
					<td>${mcto.item_name } <input type="hidden" id="name${cnt}" value="${mcto.item_name }"></td>
					<td><fmt:formatNumber var="price" value="${mcto.item_price }" pattern="#,###" />
					<c:out value="₩${price}"></c:out>
					<input type="hidden" id="price${cnt}" value="${mcto.item_price }"></td>
					<td id="sum${cnt }"><fmt:formatNumber var="prosum" value="${mcto.item_price * mcto.cnt}" pattern="#,###" />
					<c:out value="₩${prosum}" /> </td>
				</tr>
				<input type="hidden" value="${mcto.item_price * mcto.cnt  }" id="prosum${cnt }">
				<c:set var="cnt" value="${cnt+1}"></c:set>
				<c:set var="sum" value="${sum + mcto.item_price * mcto.cnt }"></c:set>
			</c:forEach>
		</table>
    	
		<div>
		<br>
		<br>
			</div>
			<br><br>
			<div id="sumdiv">
			
				<table id="lasttable">
				    <tr>
				 		<td colspan="2"><h2>주문한 물건 총계</h2></td>
					</tr>
					<tr>
						<td>소계　</td>
						<td> <fmt:formatNumber var="sum2" value="${sum}" pattern="#,###" />
					<c:out value="₩${sum2}"/></td>
					</tr>
					<tr>
						<td>배송　</td>
						<td>무료배송</td>
					</tr>
					<tr>
						<td>총계　</td>
						<td id="gun">  <fmt:formatNumber var="sum2" value="${sum}" pattern="#,###" />
					<c:out value="₩${sum2}"/>	</td>
					</tr>
				</table>	
			</div>
	</div>
	<br><br>
</form>
</div>
</body>
<script>
     
    // 플러스
    function minus(num){
    	var pronum =  document.getElementById("pronum"+num);
        
            pronum.value = parseInt(parseInt(pronum.value) + parseInt(1));
            var sum =  document.getElementById("sum"+num);
            var price =  document.getElementById("price"+num);
            sum.innerHTML = parseInt(pronum.value) * parseInt(price.value) ; 
            var code =  document.getElementById("code"+num);
            location.href= 'CartCntChange.do?cnt='+pronum.value +'&code=' + code.value ;
    }
    //마이너스
       function plus(num){
    	   var pronum =  document.getElementById("pronum"+num);
           if(pronum.value>1){
        	   pronum.value = parseInt(parseInt(pronum.value) - parseInt(1)) ;
        	   var sum =  document.getElementById("sum"+num);
               var price =  document.getElementById("price"+num);
               sum.innerHTML =parseInt(pronum.value) * parseInt(price.value) ;  
               var code =  document.getElementById("code"+num);
               location.href= 'CartCntChange.do?cnt='+pronum.value +'&code=' + code.value ;
           }else{
        	   pronum.value =  1;
               var sum =  document.getElementById("sum"+num);
               var price =  document.getElementById("price"+num);
               sum.innerHTML = parseInt(pronum.value) * parseInt(price.value) ; 
               var code =  document.getElementById("code"+num);
               location.href= 'CartCntChange.do?cnt='+pronum.value +'&code=' + code.value ;
           }
    }
    //체크 삭제
    function ckbox(num){
    	var ck=  document.getElementById("ck"+num);
    	var prosum=  document.getElementById("prosum"+num);
    	var realsum1=  document.getElementById("realsum1");
    	var realsum2=  document.getElementById("realsum2");
    	if(ck.checked == true){
    		realsum1.value = parseInt(realsum1.value) + parseInt(prosum.value);
    		realsum2.value = parseInt(realsum2.value) + parseInt(prosum.value);
    	}else{
    		realsum1.value = parseInt(realsum1.value) - parseInt(prosum.value);
    		realsum2.value = parseInt(realsum2.value) - parseInt(prosum.value);
    	}
            
    }
    function  allckbox(){
    	var all=  document.getElementById("all");
    	
    	if(all.checked == true){
    		for(var i = 1; i<${cnt} ; i++ ){
    		var ck=  document.getElementById("ck"+i);
    		ck.checked = true;
    		}
    		realsum1.value = ${sum};
    		realsum2.value = ${sum};
    	}else{
    		for(var i = 1; i<${cnt} ; i++ ){
    			var ck=  document.getElementById("ck"+i);
    			ck.checked = false;
    		}
    		realsum1.value = 0;
    		realsum2.value = 0;
    	}
            
    }
    allckbox()
    // 3자리마다 콤마 찍기
    var shopPrice = document.querySelectorAll(".shopPrice");
	
	for(var i=0; i<shopPrice.length; i++){
        var price = parseInt(shopPrice[i].innerHTML);
		shopPrice[i].innerHTML = "₩" + price.toLocaleString();
	}
</script>
</html>