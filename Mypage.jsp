<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#joinformbtn1{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: red;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
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
	
#Mypage table{
border-collapse: collapse;
border:1px solid lightgray;
margin: 0 auto;
background-color: white;

}

#Mypage table th{
width : 150px;
height: 40px;
border:1px solid lightgray;
}

#Mypage table td{
width : 400px;
height: 40px; 
border:1px solid lightgray;
}

input[type=text]{height:40px; width:400px;
border:1px solid lightgray; margin:10px;
}

input[type=password]{height:40px; width:400px;background:#FAFFBD;
border:1px solid lightgray; margin:10px;
}


input[type=submit]{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
input[type=reset]{
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #3E3E3E;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
h2{text-align: center; margin:20px;}
#lastbutton{text-align: center;}
.readonly{outline:none; background-color:aliceblue;}
.textupdate{background:#FAFFBD};

</style>
<title>Insert title here</title>
</head>
<body>
<div id="shopTop">
	<a href="mypage.do?headerr=four"><p>MY PAGE</p></a>
</div> 
<div id="Mypage">
<form action="infomodify.do" method="get">
<h2>회원정보 수정</h2>
<table>
<tr>
<th id="Mypagetd"><span id="Mypagespan">아이디<span></th>
<td><input type="text" value="${log }" readonly="readonly" class="readonly"></td>
</tr>
<tr>
<th id="Mypagetd"><span id="Mypagespan">비밀번호<span></th>
<td><input type="password" name="password1"></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">비밀번호 확인<span></th>
<td><input type="password" name="password2" ></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">이름<span></th>
<td><input type="text" value="${a.name }" readonly="readonly" class="readonly" ></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">생일<span></th>
<td><input type="text" value="${a.birth }" readonly="readonly" class="readonly"></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">핸드폰 번호<span></th>
<td><input type="text" value="0${a.phone }" name="phone"  class="textupdate"></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">우편번호<span></th>
<td><input type="text" value="${a.postcode }" name="postcode" class="textupdate"></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">주소<span></th>
<td><input type="text" value="${a.addr }" name="addr" class="textupdate"></td>
</tr>

<tr>
<th id="Mypagetd"><span id="Mypagespan">상세주소<span></th>
<td><input type="text" value="${a.detailaddr }" name="detailaddr" class="textupdate"></td>
</tr>




</table>
<div id="lastbutton">
<input type="submit" id="joinformbtn"  value="회원정보 수정">
<input type="reset" id="joinformbtn" value="취소">
<input type='button' id="joinformbtn1" value="회원 탈퇴" onclick="location.href='MemberDelete.do'">
</div>
</form>
</div>
</body>
</html>