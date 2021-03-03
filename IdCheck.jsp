<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#shopTop{
    	width: 97%;
    	margin: 0 5px 0 15px;;
        height: 200px;
        background-image: url(img/shop_up.jpg);
    }
    #shopTop p{
        color: white;
        font-size: 2em;
        font-weight: bold;
        padding-top: 80px;
        text-align: center;
        margin-left: 40%;
        margin-right: 40%;
    }
    #shopTop a{
		text-decoration: none;
	}
	#shopTop a p{
		cursor: pointer;
	}
    #IdCheckContain{
    	margin-top: 20px;
        width: 1200px;
        margin: 0 auto;
        text-align: center;
    }    
    button:nth-of-type(1){
	width:120px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:10px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	button:nth-of-type(2){
	width:120px; height:40px; 
	font-size: 15px; color:white; background:#3E3E3E;
	border: none; margin:10px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	button:nth-of-type(3){
	width:120px; height:40px; 
	font-size: 15px; color:white; background:purple;
	border: none; margin:10px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	p{margin:50px; font-size: 20px;}
</style>
<body>
<div id="shopTop">
	<a href="centerc.do?center=Loginform.jsp&headerr=two"><p>MY ACCOUNT</p></a>
</div> 
<div id="IdCheckContain">
	<c:if test="${myid!=null}">
		<p>가입하신 아이디는 <strong>[${myid}]</strong> 입니다.</p>
	</c:if>
	<c:if test="${mypw!=null}">
		<p>가입시 입력하신 비밀번호는 <strong>[${mypw}]</strong> 입니다.</p>
	</c:if>
	<c:if test="${myid==null&&mypw==null}">
		<p>입력하신 정보가 데이터베이스에 포함되어 있지 않습니다.</p>
		<p>다시 입력해주시기 바랍니다.</p>
	</c:if>
    <button onclick="location.href='centerc.do?center=FindId.jsp&headerr=two'">비밀번호 찾기</button>
    <button onclick="location.href='centerc.do?center=Loginform.jsp&headerr=two'">로그인</button>
    <button onclick="location.href='centerc.do?center=Center.jsp&headerr=zero'">메인화면</button>
</div>
</body>
</html>