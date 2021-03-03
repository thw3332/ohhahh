<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{margin: 0;
padding: 0;}
#MainMiddle{
	margin-top: 50px;
}
</style>

</head>
<body>
<div id="MainTop"><jsp:include page="Header.jsp?headerr=${headerr}"></jsp:include></div>
<div id="MainMiddle"><jsp:include page="${center}"></jsp:include></div>
<div id="MainBottom"><jsp:include page="Footer.jsp"></jsp:include></div>

</body>
</html>