<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	var input = prompt("패스워드를 입력해주세요.", "")
	if(input){
		/* frmUrl = location.href;  
		varCut = frmUrl.indexOf("?");   
		varCheck = frmUrl.substring(varCut+1); */
		location.href = "BoardChk.do?headerr=five&input="+input;
	}else{
		history(back);
	}
</script>
</body>
</html>