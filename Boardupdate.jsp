<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#title_div{width:96%;margin:0 auto; text-align: center; margin: 50px 0; margin-left:15px;}
hr{width:100%; position:relative; z-index:-1}
form{width:96%;margin:0 auto; text-align: center;margin-top : 50px;}
#review{display:block; border:2px solid #ccc; 
			font-weight: bold; width:150px; height:50px; 
			font-size:35px; line-height: 50px; text-align: center;
			margin:20px auto; position: absolute; top: 358px; left:46%;
			background: white;
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
	table{ border-collapse:collapse;  width: 700px; 	text-align: center;
			padding-top: 80px;	padding-bottom: 80px; margin-left: auto;
			margin-right: auto;  margin-top: 50px;
 	}
 	tr{border-bottom:1px solid #cccccc; height:50px;}
	th{border-bottom: 1px solid #cccccc; width:50px; text-align: right;}
	td{width:110px; text-align: left; padding-left:10px;}
	h3{text-align: center; margin:0 auto;border-bottom: 1px solid #cccccc; 
			width:865px; padding:10px;
		    margin-top: 50px; 
		}
	input[type=text]{width:850px; height:40px; font-size: 15px;}
	input[type=button]{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	input[type=submit]{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #3E3E3E;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	textarea{margin:10px 0;}
	#lasttd td{text-align: center;}
	#filP{margin-bottom: 11px;}
</style>
</head>
<body>
<div id="shopTop">
	<a href="BoardList.do?headerr=five"><p>REVIEW</p></a>
</div>
<div id="title_div">
	<hr>
	<span id="review">REVIEW</span>
</div>
<form action="Boardupdate.do" method="post">
<h3><input type="text" name="board_title" value="${board_title }"></h3>
<table board="1">
	<tr>
		<th>작성자</th>
		<td>${id }</td>
		<th>작성일</th>
		<td>${board_date }</td>
		<th>조회</th>
		<td>${cnt }</td>
	</tr>
	<tr>
		<td colspan="6"><textarea rows="10" cols="122" name = "board_content">${board_content }</textarea></td>
	</tr>
	<input type="hidden" value="${board_img}" name="board_img2">
	<tr>
		<th>첨부파일</th>
		<td colspan="5"><input type="file" value="파일 선택" name="board_img"></td>
	</tr>
	<tr id="lasttd">
		<td colspan="3"><input type="submit" value="수정하기"></td>
		<td colspan="3"><input type="button" value="취소하기" onclick="location.href='BoardList.do?headerr=five'"></td>
	</tr>
</table>
</form>
</body>
</html>