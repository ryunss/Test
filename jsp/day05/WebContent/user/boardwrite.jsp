<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
%>
	<form action="write_db.jsp">
		제목 <input name="subject">
		내용 <input name="content">
		<input type="hidden" name="userid" value="${loginUser.userid }">
		<input type="submit" value="작성완료">
	</form>
</body>
</html>