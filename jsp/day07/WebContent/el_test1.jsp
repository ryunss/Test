<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	\${10+20} : ${10+20}<br>
	\${10>3} : ${10>3}<br>
	<%
		int data = 100;
		pageContext.setAttribute("data", 200);
		request.setAttribute("data", 300);
		session.setAttribute("data", 400);
	%>
	<!-- 
		data는 변수명을 의미하는 것이 아니라 setAttribute() 할 떄의
		Key 값을 찾는다
		아래는 세팅되어 있는 attribute를 찾는 순서
		pageContext -> request -> session -> application
	-->
	<%=pageContext.getAttribute("data") %> / ${data }
	\${data} : ${data} <br>
	\${requestScope.data } : ${requestScope.data }<br>
	\${sessionScope.data } : ${sessionScope.data }<br>
</body>
</html>