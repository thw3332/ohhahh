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
#checkfoot{

		width: 95%;

    	margin-left : 70px;


    	float : left;
    	text-align: center;
    	margin-bottom: 150px;
    	

	}

	#checkfoot table{

		border : 1px solid #e5e5e5;

		border-collapase : none;

		text-align : center;

		width : 55%;

	}

	#checkfoot th{

		height : 50px;

		font-weight : bold;

		font : 25px;
         border-bottom: 1px solid #e5e5e5;
	}

	#checkfoot td{

		height : 50px;
  border-bottom: 1px solid #e5e5e5;
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
	#backshop{
	width: 150px;
	height: 50px;
	border: 3px solid black;
	background-color: white;
	font-weight: 900;
	
	}
	#mainbutton{
	text-align: center;
	margin-bottom: 150px;
	}
	#checkfoot2 table{
	margin-left: 370px;
	}
</style>
</head>
<body>



<jsp:useBean id="toDay" class="java.util.Date" />
<fmt:formatDate value='${toDay}' pattern='yyyy-MM-dd' var="nowDate"/>
<div id="checkfoot">

		<div id="checkfoot2">
<br><br><br><br>
			<h2>주&nbsp;문&nbsp;이&nbsp;완&nbsp;료&nbsp;되&nbsp;었&nbsp;습&nbsp;니&nbsp;다</h2>
<br><br><br><br>
			<table>
				<tr>

					<th>구매날짜</th>

					<th><c:out value="${nowDate}"/></th>

				</tr>
                	<tr>

					<th>판매자 : OoH-AHh(우아)</th>

					<th>결제방법 : 신용카드</th>

				</tr>
				<tr>

					<th>상품</th>

					<th>총계</th>

				</tr>
        <c:set var="b" value="0" ></c:set>
				<c:forEach var="a" items="${a }">

				<tr>

					<td>${a.item_name}</td>

					<td><fmt:formatNumber var="sum2" value="${a.item_price * a.cnt }" pattern="#,###" />
					<c:out value="₩${sum2}"></c:out></td>

					<c:set var="b" value="${b + (a.item_price * a.cnt) }"></c:set>

				</tr>

				</c:forEach>

					<tr>

						<td>소계</td>
						<fmt:formatNumber var="c" value="${b }" pattern="#,###" />

							<td><c:out value="₩${c}"></c:out></td>

					<tr>

						<td>배송</td>

						<td>무료배송</td>

					</tr>

					<tr>

						<td>총계</td>

						<td><c:out value="₩${c}"></c:out></td>

					</tr>

			</table>

		</div>

	</div>
	<div id="mainbutton"><input id="backshop" type="button" onclick="location.href='centerc.do?center=Center.jsp'" value="메인으로"></div>



</body>
</html>