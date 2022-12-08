<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아주 예쁜 제목</h2>
	<jsp:forward page="paramResult.jsp">
		<jsp:param value="apple" name="userid"/>
		<jsp:param value="김사과" name="username"/>
	</jsp:forward>
</body>
</html>