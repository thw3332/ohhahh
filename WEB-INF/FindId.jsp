<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    .tab_wrap{
        width: 1200px;
        margin: 0 auto;
        
    }
    .tab_menu_container{
        width: 1200px;
        margin: 0 auto;
    }
    .tab_menu_container button{
        width: 200px;
        background: lightgray;
        font-size: 15px;
        
    }
    .tab_menu_btn:first-of-type{
        font-weight: bold;
        margin-left: 400px;
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
    button {
      background:none;
      border:0;
      outline:0;
      cursor:pointer;
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
</style>
</head>
<body>

<div class="tab_wrap">
  <div class="tab_menu_container">
    <button class="tab_menu_btn" type="button">아이디찾기</button>
    <button class="tab_menu_btn" type="button">비밀번호찾기</button>
  </div> <!-- tab_menu_container e -->

  <div class="tab_box_container">
    <div class="tab_box">
        <form action="#" method="post">
              <h3>아이디 찾기</h3>
              <p>회원가입할때 작성한 성함과 전화번호를 입력해주세요.</p>
              <tr>
                  <td>성함</td>
                  <td><input type="text" name="name" placeholder="성함"></td>
              </tr>
              <tr>
                  <td>전화번호</td>
                  <td><input type="text" name="phone" placeholder="전화번호"></td>
              </tr><br>
              <tr>
                  <td colspan="2"><button type="submit" id="findBtn">아이디 찾기</button></td>
              </tr>
          </form>
    </div>
    <div class="tab_box">
        <form action="#" method="post">
              <h3>비밀번호 찾기</h3>
              <p>회원가입할때 작성한 아이디와 성함, 전화번호를 입력해주세요.</p>
              <tr>
                  <td>아이디</td>
                  <td><input type="text" name="id" placeholder="아이디"></td>
              </tr>
              <tr>
                  <td>성함</td>
                  <td><input type="text" name="name" placeholder="성함"></td>
              </tr>
              <tr>
                  <td>전화번호</td>
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
});  
tab_menu_btn[1].addEventListener('click',function(){
    tab_box[0].style.display="none";
    tab_box[1].style.display="block";
    tab_menu_btn[0].style.fontWeight="normal";
    tab_menu_btn[1].style.fontWeight="bold";
}); 
</script>

</body>
</html>
