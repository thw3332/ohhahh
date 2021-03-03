<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    .tab_wrap{
        width: 1200px;
        margin: 0 auto;
        margin-top: 30px;
    }
    .tab_menu_container{
        width: 1200px;
        margin: 0 auto;
    }
    .tab_menu_container button{
    width:200px; height:40px; 
	font-size: 15px; color:white; background: #3E3E3E;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
    }
    .tab_menu_btn:first-of-type{
        margin-left: 400px;
        background: #CFA987;
    }
    .tab_box_container{
        text-align: center;
    }
    #findBtn{
        width: 100px;
        height: 30px;
        margin-top: 10px;
        background: #d9b1a0;
        color: white;
        border: none;
    }
    #findContain li a{
	    transition-duration: 1s;
	    transition-timing-function: ease-in;
	    font-weight: none;
	    color: gray;
	}
	#findContain .active a{
	    font-weight: bold;
	    color: black;
	}
	#findContain li a:hover{
	    color: #d9b1a0;
	}
    .tab_menu_container {
      display:flex;
    }
    .tab_menu_btn {
      width:80px;
      height:40px;
      transition:0.3s all;
    }
    .tab_menu_btn:hover {
      color:white;
      font-weight: bold;
    }
    .tab_box {
      display:none;
      padding:20px;
    }
    .tab_box:first-of-type {
      display:block;
    }
    .tab_box.on {
      display:block;
    } 

input[type=text]{height:40px; width:200px;border:1px solid lightgray; margin:10px;}

	
button{
	width:200px; height:40px; 
	font-size: 15px; color:white; background: #CFA987;
	border: none; margin:20px; font-weight: bold;
	cursor: pointer; outline: none;
}

</style>
</head>
<body>
<div id="shopTop">
	<a href="centerc.do?center=Loginform.jsp&headerr=two"><p>MY ACCOUNT</p></a>
</div> 
<div class="tab_wrap">
  <div class="tab_menu_container">
    <button class="tab_menu_btn" onclick="change()">아이디찾기</button>
    <button class="tab_menu_btn" onclick="change()">비밀번호찾기</button>
  </div> <!-- tab_menu_container e -->

  <div class="tab_box_container">
    <div class="tab_box">
        <form action="FindId.do" method="post">
              <h2>아이디 찾기</h2><br>
              <p>회원가입시 작성한 이름과 전화번호를 입력해주세요.</p>
              <tr>
                  <td><input type="text" name="name" placeholder=" 이름"></td>
              </tr>
              <tr>
                  <td><input type="text" name="phone" placeholder=" 전화번호"></td>
              </tr><br>
              <tr>
                  <td colspan="2"><button type="submit" id="findBtn">아이디 찾기</button></td>
              </tr>
          </form>
    </div>
    <div class="tab_box">
        <form action="FindId.do" method="post">
              <h2>비밀번호 찾기</h2><br>
              <p>회원가입시 작성한 아이디와 이름, 전화번호를 입력해주세요.</p>
              <tr>                
                  <td><input type="text" name="id" placeholder="아이디"></td>
              </tr>
              <tr>
                  <td><input type="text" name="name" placeholder="이름"></td>
              </tr>
              <tr>
                  <td><input type="text" name="phone" placeholder="전화번호"></td>
              </tr><br>
              <tr>
                  <td colspan="2"><button type="submit" id="findBtn">비밀번호 찾기</button></td>
              </tr>
          </form>
    </div>
  </div> <!-- tab_box_container e -->
</div> <!-- tab_wrap e -->

<script>
//버튼 색 제거,추가
var tab_menu_btn = document.querySelectorAll(".tab_menu_btn");
var tab_box = document.querySelectorAll(".tab_box");
var tab_menu_btn = document.querySelectorAll(".tab_menu_btn");
    
tab_menu_btn[0].addEventListener('click',function(){
    tab_box[0].style.display="block";
    tab_box[1].style.display="none";
    tab_menu_btn[0].style.fontWeight="bold";
    tab_menu_btn[1].style.fontWeight="normal";
    tab_menu_btn[0].style.background="#CFA987";
    tab_menu_btn[1].style.background="#3E3E3E";
    
});  
tab_menu_btn[1].addEventListener('click',function(){
    tab_box[0].style.display="none";
    tab_box[1].style.display="block";
    tab_menu_btn[0].style.fontWeight="normal";
    tab_menu_btn[1].style.fontWeight="bold";
    tab_menu_btn[0].style.background="#3E3E3E";
    tab_menu_btn[1].style.background="#CFA987";
}); 

</script>

</body>
</html>
