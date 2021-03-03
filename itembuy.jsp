<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<style>

	form{

		margin : none;

		padding : none;

	}

	#checkTop{

    	width: 95%;

    	margin-left : 30px;

    	margin-right : 30px;

        height: 300px;

        background-image: url(img/shop_up.jpg);

    }

    #checkTop p{

        color: white;

        font-size: 3.5em;

        font-weight: bold;

        text-align: center;

        padding-top : 100px;

    }

	#checkTop a{

		text-decoration: none;

	}

	#checkTop a label{

		cursor: pointer;

	}

	#checkMain{

		width: 95%;

    	margin-left : 30px;

    	margin-right : 30px;

        height: 1000px;

	}

	.checkC{

		width : 100%;

		margin-top : 100px;

		margin-bottom : 80px;

		margin-left : 80px;

		font-weight : bold;

		text-decoration : none;

		font-size : 20px;

		color : #303030;

		line-heihgt : 75px;

	}

	.checkC a {

		text-decoration : none;

		color : #303030;

	}

	#checkCenter{

		width: 95%;

    	margin-left : 130px;

    	margin-right : 30px;

    	height : 60%;

	}

	#checkCenter_1{

		float : left;

		width : 48%;

	}

	#checkCenter_1 table{

		font-size : 22px;

	}

	#checkCenter_2{

		float : left;

		width : 48%;

	}

	#checkCenter_2 table{

		font-size : 22px;

	}

	#checkCenter_2 h3{

		width : 250px;

		margin-right : 0;

	}

	#name{

		width : 600px;

		height : 35px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

	}

	#name1{

		width : 600px;

		height : 35px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

	}

	#postcode{

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

		height : 35px;

		width : 600px;

	}

	#postnum{

		border : 2px solid black;

		border-radius : 3px;

		background : white;

		height : 35px;

		width : 130px;

		margin-left : 30px;

		margin-bottom : 25px;

	}

	#roadAddress{

		width : 600px;

		height : 35px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

	}

	#detailAddress{

		width : 600px; 

		height : 35px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

	}

	#detailAddress1{

		width : 600px; 

		height : 35px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

	}

	#email{

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

		height : 35px;

		width : 280px;

		padding : 0;

		margin-right : 34px;

	}

	#emai1l1{

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

		height : 35px;

		width : 280px;

		padding : 0;

		margin-right : 34px;

	}

	#phone{

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

		height : 35px;

		width : 280px;

		padding : 0;

	}

	#phone1{

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

		height : 35px;

		width : 280px;

		padding : 0;

	}

	#freetext{

		width : 600px;

		height : 150px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

	}

	#checkfoot{

		width: 100%;

    	margin-left : 30px;

    	margin-right : 30px;

    	float : left;

	}

	#checkfoot table{

		border : 1px solid #e5e5e5;

		border-collapase : none;

		text-align : center;

		width : 95%;

	}

	#checkfoot th{

		height : 50px;

		font-weight : bold;

		font : 25px;

	}

	#checkfoot td{

		height : 50px;

	}

	#checkfoot tr:last-child{

		color : #D9AC86;

	}

	#checkfoot table th:first-child{

		width: 60%;

	}

	#checkfoot table th:last-child{

		width : 35%;

	}

	#postcode1{

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

		height : 35px;

		width : 100%;

	}

	#roadAddress1{

		width : 600px;

		height : 35px;

		background-color : #f5f5f5;

		border : 2px solid #e5e5e5;

		margin-bottom : 25px;

	}

	#checkfoot2{

		width : 95%;

		margin-left : 30px;

    	margin-right : 30px;

    	float : left;

	}

	#checkfoot2 input{

		margin-top : 20px;

		margin-left : 1300px;

		width : 200px;

		height : 50px;

		border-radius : 4px;

		border : 1px solid black;

		font-weight : bold;

		margin-bottom : 40px;

	}

	#ft1{

		margin-left : 20px;

		color : #A3A3A3;

		margin-top : 20px;

	}

	#ft2{

		margin-left : 20px;

		color : #A3A3A3;

		margin-top : 20px;

	}

	#ft3{

		margin-left : 20px;

		color : #A3A3A3;

		margin-top : 20px;

	}

	#ft4{

		margin-left : 20px;

		color : #A3A3A3;

		margin-top : 20px;

	}

</style>	

<title>Insert title here</title>

</head>

<body>

<form method="get" action="receipt.do">

	<div id="checkTop">

    <a href="#"><p>C&nbsp;H&nbsp;E&nbsp;C&nbsp;K&nbsp;O&nbsp;U&nbsp;T&nbsp;</p></a>

</div>
<br><br><br>
<div id="checkMain">

	

	<div id="checkCenter">

		<div id="checkCenter_1">

			<table>

				<tr>

					<td colspan="2"><h3>청 구&nbsp;&nbsp;&nbsp;상 세</h3></td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="이름" name="myname" id="name" value="${dto.name}"></td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="우편번호" id="postcode" name="postcode" value="${dto.postcode}"></td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="우편번호 찾기 버튼을 누르세요" id="roadAddress" name="roadAddress" value="${dto.addr}"></td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="상세주소" id="detailAddress" name="detailAddress" value="${dto.detailaddr }"></td>

				</tr>

				<tr>

					<td><input type="text" placeholder="생년월일" id="email" value="${dto.birth}" name="email"></td>

					<td><input type="text" placeholder="전화 또는 휴대폰" id="phone" value="0${dto.phone}" name="phone"></td>

				</tr>

			</table>

			<input type="hidden" id="namev" value="${dto.name}">

			<input type="hidden" id="addrv" value="${dto.addr}">

			<input type="hidden" id="birthv" value="${dto.birth}">

			<input type="hidden" id="phonev" value="${dto.phone}">

		</div>

		<div id="checkCenter_2">

			<table>

				<tr>

					<td><h3>다&nbsp;&nbsp;른&nbsp;&nbsp;주&nbsp;&nbsp;소&nbsp;&nbsp;로&nbsp;&nbsp;배&nbsp;&nbsp;송</h3></td>

					<td><input type="checkbox" onclick="testchkbox()" id="addckbox" >
					<input type="hidden"  name="addckbox1" value="one" id="ckboxvalue">
					</td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="이름" id="name1" name="myname2"></td>

				</tr>

				<tr>

					<td><input type="text" placeholder="우편번호" id="postcode1" name="postcode2" readonly></td>

					<td><input type="button" value="우편번호찾기" onclick="DaumPostcode()" id="postnum"></td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="우편번호 찾기 버튼을 누르세요" id="roadAddress1" name="roadAddress2" readonly></td>

				</tr>

				<tr>

					<td colspan="2"><input type="text" placeholder="상세주소" id="detailAddress1" name="detailAddress2"></td>

				</tr>

				<tr>

					<td><input type="text" placeholder="생년월일" id="emai1l1" name="email2"></td>

					<td><input type="text" placeholder="전화 또는 휴대폰" id="phone1" name="phone2"></td>

				</tr>

			</table>

			<div>

				<input type="text" placeholder="주문에 대한 메모 예:배달시 특별 메모" id="freetext">

			</div>

		</div>

	</div>

	<div id="checkfoot">

		<div>

		<h2>고&nbsp;객&nbsp;님&nbsp;의&nbsp;주&nbsp;문</h2>

			<table>

				<tr>

					<th>상품</th>

					<th>총계</th>

				</tr>
        <c:set var="b" value="0" ></c:set>
				<c:forEach var="a" items="${a }">

				<tr>

					<td>${a.item_name}</td>

					<td>
					<fmt:formatNumber var="sum2" value="${a.item_price * a.cnt }" pattern="#,###" />
					<c:out value="₩${sum2}"></c:out></td>

					<c:set var="b" value="${b + (a.item_price * a.cnt) }"></c:set>

				</tr>

				</c:forEach>

					<tr>

						<td>소계</td>

							<td>
							<fmt:formatNumber var="sum3" value="${b }" pattern="#,###" />
					<c:out value="₩${sum3}"></c:out></td>

					<tr>

						<td>배송</td>

						<td>무료배송</td>

					</tr>

					<tr>

						<td>총계</td>

						<td><fmt:formatNumber var="sum3" value="${b }" pattern="#,###" />
					<c:out value="₩${sum3}"></c:out></td>

					</tr>

			</table>

		</div>

	</div>

	<div id="checkfoot2">

		<input type="submit" value="구매하기" >

	</div>

	<div id="checkfoot1">

		

	</div>

</div>

</form>

</body>

<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<script>

	function DaumPostcode() {

	    new daum.Postcode({

	        oncomplete: function(data) {

	            var roadAddr = data.roadAddress; // 도로명 주소 변수

	            // 우편번호와 주소 정보를 해당 필드에 넣는다.

	            document.getElementById('postcode1').value = data.zonecode;

	            document.getElementById("roadAddress1").value = roadAddr;

	           

	        }

	    }).open();

	}

	

	function testchkbox(){

		var addckbox=  document.getElementById("addckbox");
		var ckboxvalue=  document.getElementById("ckboxvalue");
		if(addckbox.checked == true){

			var name1=  document.getElementById("name1");

			var detailAddress1=  document.getElementById("detailAddress1");

			var emai1l1=  document.getElementById("emai1l1");

			var phone1=  document.getElementById("phone1");

			

			name1.value= namev.value;

			detailAddress1.value= addrv.value;

				emai1l1.value= birthv.value;

			phone1.value= "0" + phonev.value;
			ckboxvalue.value = "two";
		}else{

			var name1=  document.getElementById("name1");

			var detailAddress1=  document.getElementById("detailAddress1");

			var emai1l1=  document.getElementById("emai1l1");

			var phone1=  document.getElementById("phone1");

			name1.value= "";

			detailAddress1.value= "";

			emai1l1.value= "";

			phone1.value="";
			ckboxvalue.value = "one";
		}

		}

		

 

</script>

</html>