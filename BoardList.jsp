<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#div1{width:96%;margin:0 auto; text-align: center; margin: 50px 0; margin-left:15px;}
hr{width:100%; position:relative; z-index:-1}
#review{display:block; border:2px solid #ccc; 
			font-weight: bold; width:150px; height:50px; 
			font-size:35px; line-height: 50px; text-align: center;
			margin:20px auto; position: absolute; top: 357px; left:46%;
			background: white;
}

table{ border-collapse:collapse;  width: 800px; 	text-align: center;
			padding-top: 80px;	padding-bottom: 80px; margin-left:auto;
			margin-right: auto; margin-top: 50px;
 		}
tr{border-bottom:1px solid lightgray; height:50px;}
th{border-bottom: 2px solid lightgray; width:50px;}
th:nth-of-type(2){width:250px;}
td{width:50px;}
td:nth-of-type(2){width:250px;}
td:nth-of-type(4){width:150px;}
input[type=button]{
width:100px; height:40px; 
font-size: 15px; color:white; background: #CFA987;
border: none; margin:20px; font-weight: bold;
cursor: pointer; outline: none; margin-left: 75px;
}
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
	#search{width: 45%;  height: 40px; margin: 0 auto;  text-align: right; margin-top:50px; margin-bottom: 10px;}
	#search input{height: 30px;}
	
	#searchbutton{
        position: absolute;
        width: 40px;
        height: 34px;
        margin-top: 2px;
        margin-left: -46px;
        background: none;
        border: none;
        cursor: pointer;
        z-index: 10;
        outline: none;
      
    }
  .fa{
        position: absolute;
        color: gray;
        margin-top: 8px;
        margin-left: -22px;
    }
    table{margin:0 auto;}
	tr:hover{ background:#F7F7F7; }
	tr:first-of-type:hover{ background:none; }
	
	#paging a{
	    display:inline-block;
	    width: 25px;
	    height: 25px;
	    line-height:25px;
	    font-size: 15px;
	    border: 1px solid gray;
	    background: white;
	    color:gray;
	    font-weight:bold;
	    cursor: pointer;
	    outline: none;
	    border-radius: 5px;
	    transition-duration: 0.5s;
        transition-timing-function: ease-in;
        margin-top:20px;
	}
	#paging .pagingcolor_on{
		color:white; 
	    background: #585858;
	}
	#paging .pagingcolorRN{
		width: 30px;
	    height: 25px;
	    line-height:25px;
	    font-size:15px;
	    color:white; 
	    background: #585858;
	}
	#paging a:hover{
	    background: gray;
	    color: white;
	}
</style>
</head>
<body>
<div id="shopTop">
	<a href="BoardList.do?headerr=five"><p>REVIEW</p></a>
</div>
<div id="div1">
<hr>
<span id="review">REVIEW</span>
<table>
<form action="BoardList.do?headerr=five" method="post">
	<div id="search">SEARCH <input type="text" name="search" placeholder=" ID로 검색해주세요">
	<input type="submit" value="" id="searchbutton"><i class="fa fa-search" aria-hidden="true"></i>
	</div>
</form>
	<tr>
		<th width='50' >번호</th>
		<th width='250' >제목</th>
		<th width='50' >작성자</th>
		<th width='50' >작성일</th>
		<th width='50' >조회수</th>
	</tr>
	
	<c:if test="${count == 0 }">
	<tr>
	<td colspan="5">게시물이 없습니다.</td>
	</tr>
	</c:if>
	<c:if test="${count != 0 }">
	<c:set var='cnt' value='${(currentPage*5)-4}'></c:set>
		<c:forEach var='bdto' items="${bdto }">
					<c:if test="${not empty bdto.board_title}">
						<tr height='40'>
							<td width='50' >${cnt }</td>
							<td width='250' ><a href="Boardselect.do?board_code=${bdto.board_code}&headerr=five">${bdto.board_title }</a></td>
							<td width='50' >${bdto.id }</td>
								<c:set var="now" value="<%=new java.util.Date()%>" />
								<fmt:formatDate var="currDate" pattern="yyyy-MM-dd" value="${now}" />
								
								<fmt:parseDate var="write_date_format" value="${bdto.board_date}" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate var="wirte_date" value="${write_date_format}" pattern="yyyy-MM-dd HH:mm"/>
								<fmt:formatDate var="wirte_date1" value="${write_date_format}" pattern="yyyy-MM-dd"/>
									<c:choose>
								    <c:when test="${wirte_date1==currDate }">
								          	<fmt:formatDate var="wirte_time" value="${write_date_format}" pattern="HH:mm"/>
									<td width='150' >${wirte_time }</td>
								     </c:when>
								     <c:otherwise> 
								          <fmt:formatDate var="wirte_time" value="${write_date_format}" pattern="yyyy-MM-dd"/>
									<td width='150' >${wirte_time }</td>
								     </c:otherwise>
									</c:choose>
							<td width='50' >${bdto.cnt }</td>
							<c:set var='cnt' value='${cnt=cnt+1 }'></c:set>
						</tr>
					</c:if>
		</c:forEach>
	</c:if>
	
		
</table>
<div id="paging">
<!-- [이전]링크를 걸지 파악  -->
		<c:if test="${empty search}">
			<c:if test="${startPage>pageBlock }" >
				<a href="BoardList.do?pageNum=${startPage-1 }" class='pagingcolorRN'>«</a>&nbsp;
			</c:if>
			<!-- 숫자 페이징이 출력 [1] [2] [3]-->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${i==currentPage }">
					<a href="BoardList.do?pageNum=${i }" class='pagingcolor_on'>${i }</a>
				</c:when>
			<c:otherwise>
					<a href="BoardList.do?pageNum=${i }" class='pagingcolor_off'>${i }</a>
					</c:otherwise>
			</c:choose>
			</c:forEach>
			<!-- [다음]링크를 걸지 파악  -->
			<c:if test="${endPage<pageCount }" >
				<a href="BoardList.do?pageNum=${startPage+pageBlock }" class='pagingcolorRN'>»</a>&nbsp;
			</c:if>
		</c:if>
		
</div>

<br>
<input type='button' value='글쓰기' onclick="location.href='BoardWriteview.do?headerr=five'">

</div>
</body>
</html>