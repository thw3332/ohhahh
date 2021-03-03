<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#shopMiddle{
        width: 1200px;
        margin: 0 auto;
        margin-top: 30px;
    }
table{border-collapse: collapse; margin: 0 auto;}
table td{height:40px; width:400px; }
form{ text-align: center;}
h2{text-align: center; margin:20px;}
input[type=text]{height:40px; width:400px;border:1px solid lightgray; margin:10px;}
input[type=password]{height:40px; width:400px;border:1px solid lightgray; margin:10px;}
	
button{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="shopTop">
	<a href="centerc.do?center=Loginform.jsp&headerr=two"><p>MY ACCOUNT</p></a>
</div> 
<div id="shopMiddle">
	<form action="login.do" method="get">
	<h2>로그인</h2>
	<table>
	<tr>
		<td id="loginformtd">
		<input type="text" name="id" placeholder=" 아이디 "></td>
	</tr>
	<tr>
		<td id="loginformtd">
		<input type="password" name="pw" placeholder=" 비밀번호"></td>
	</tr>
	</table>
	
	<button type="submit" id="loginformbtn" >로그인</button>
	<a href="centerc.do?center=FindId.jsp&headerr=two">Lost Password?</a>
	</form>
</div>


</body>
</html>