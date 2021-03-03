<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body{width:100%; margin:0 auto; }
	form{width:96%;margin:0 auto; text-align: center;margin-top : 50px;}
	
	#title_div{width:100%;}
	hr{width:97%; position:relative; z-index:-1; margin-left: 15px;}
	#review{display:block; border:2px solid #ccc; 
			font-weight: bold; width:150px; height:50px; 
			font-size:35px; line-height: 50px; text-align: center;
			margin:20px auto; position: absolute; top: 357px; left:46%;
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
	input[type=text]{width:500px; height:40px;}
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
	table{ border-collapse:collapse;  width: 700px; 	text-align: center;
			padding-top: 80px;	padding-bottom: 80px; margin-left: auto;
			margin-right: auto; margin-top : 50px;
 	}
 	tr{border-bottom:1px solid #cccccc; height:50px;}
	th{border-bottom: 1px solid #cccccc; width:60px; text-align: right;}
	td{width:250px; text-align: left; padding-left: 50px;}
	#lastdiv{width:100%;display:flex;justify-content: center;}
	tr:nth-of-type(2) input{
		border: none;
	}
</style>
</head>
<body>
<div id="shopTop">
	<a href="BoardList.do?headerr=five"><p>REVIEW</p></a>
</div>
<form action="BoardWrite.do" method="post">
<div id="title_div">
	<hr>
	<span id="review">REVIEW</span>
</div>
<table id="content">
	<tr>
		<th>제목</th>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="id" value="${log}" readonly></td>
	</tr>
		<th>비밀번호</th>
		<td><input type="text" name="writepw"></td>
	<tr>
		<td colspan="2"><textarea rows="15" cols="95" name = "content"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" value="파일 선택" name="board_img"></td>
	</tr>
</table>
<div id="lastdiv">
<input type="submit" value="저장하기">
<input type="button" value="돌아가기" onclick="location.href='BoardList.do?headerr=five'">
</div>
</form>
</body>
</html>