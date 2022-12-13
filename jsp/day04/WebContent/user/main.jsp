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
		String loginUser = (String)session.getAttribute("loginUser");
		if(loginUser == null){			
	%>
			<script>
				alert("로그인 후 이용하세요!");
				location.href="loginview.jsp";
			</script>		
		<%} %>
		
	<p><%=loginUser %>님 어서오세요</p>
	<p><a href="logout.jsp">로그아웃</a></p>
</body>
</html>