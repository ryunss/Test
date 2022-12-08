<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>내가 만든 쿠키</h2>
	<%
		Cookie cookie1 = new Cookie("homerunball","so_good");
		Cookie cookie2 = new Cookie("Ohing","werrrr");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	%>
</body>
</html>