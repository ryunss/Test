<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>내용</div>
	<p>
		아이디 : <%= request.getParameter("userid") %>
	</p>
	<p>
		이름 : <%= request.getParameter("username") %>
	</p>
</body>
</html>