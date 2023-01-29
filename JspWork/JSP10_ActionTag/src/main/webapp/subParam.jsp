<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subParam</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	id = URLDecoder.decode(id, "utf-8");
	String pw = request.getParameter("pw");
%>

<p> 현재 페이지는 subParam 입니다. </p>
id : <%=id %><br>
pw : <%=pw %><br>
</body>
</html>