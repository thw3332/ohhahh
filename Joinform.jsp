<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#postcode1{width: 280px; }
#postnum{width:100px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; font-weight: bold; margin-left:20px;
	cursor: pointer; outline: none;}
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
	
	h2{text-align: center; margin:20px;}
	
	 #joinform{
	 	margin-top: 30px;
	 }
	
	 #joinform table{
	border-collapse: collapse;
	 margin: 0 auto;
	 border-style: none;
	
	 color: blue;
	 margin: 
	}
	
	#joinform table td{
	padding: 13px 20px;
	 border-style: none;
	 }
	 
	 
	input[type=text]{height:40px; width:400px;background:#FAFFBD; border:1px solid lightgray;}
	input[type=password]{height:40px; width:400px;background:#FAFFBD;border:1px solid lightgray;}
	
	button:nth-of-type(2){
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	button:nth-of-type(1){
	width:100px; height:40px; 
	font-size: 15px; color:white; background: #3E3E3E;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
	}
	#lastbutton{text-align: center;}
	#nopwchk{color:red;}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="shopTop">
	<a href="centerc.do?center=Joinform.jsp&headerr=three"><p>REGISTER</p></a>
</div> 
<div id="joinform">
<form action="join.do?headerr=zero" method="get">
<h2>회원가입</h2>
<table>
<tr>
<td id="joinformtd"></td>
<td><input type="text" name="id" placeholder=" 아이디 "></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input id="pw" type="password" name="pw" placeholder=" 비밀번호"></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input id="pwck" type="password" name="pwck" placeholder=" 비밀번호 확인"><p id="pwtext"></p></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input type="text" name="name" placeholder=" 이름"></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input type="text" name="phone" placeholder=" 전화번호"></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input type="text" name="birth" placeholder=" 생일"></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input type="text" placeholder="우편번호" id="postcode1" name="postcode" readonly><input type="button" value="우편번호찾기" onclick="DaumPostcode()" id="postnum"></td>
</tr>
<tr><td id="joinformtd"></td>
<td><input type="text" placeholder="우편번호 찾기 버튼을 누르세요" id="roadAddress1" name="memroadAddress" readonly></td>
</tr>
<tr>
<td id="joinformtd"></td>
<td><input type="text" placeholder="상세주소" id="detailAddress1" name="detailAddress"></td>
</tr>
</tr>
</table>
<div id="lastbutton">
<button type="submit" id="joinformbtn" >회원가입</button>
<button type="reset" id="joinformbtn">다시입력</button>
</div>
</form>
</div>
</div>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
	var pwtext = document.querySelector("#pwtext");
	var joinform = document.querySelector("#joinform");
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
	joinform.addEventListener("focusout", function() {
		var pw = document.querySelector("#pw");
		var pwck = document.querySelector("#pwck");
		
		if(pw.value == "" && pwck.value == "") {
			pwtext.innerHTML = "<span>비밀번호를 입력해주세요.</span>";
		}else if(pw.value == "" || pwck.value == "") {
			pwtext.innerHTML = "<span>비밀번호를 입력해주세요.</span>";
		}else if(pw.value == pwck.value) {
			pwtext.innerHTML = "비밀번호가 일치합니다.";
		}else {
			pwtext.innerHTML = "<span id='nopwchk'>비밀번호가 일치하지 않습니다.</span>";
		}
	});
</script>
</script>



</body>
</html>