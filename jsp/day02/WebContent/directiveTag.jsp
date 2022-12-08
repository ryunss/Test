<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="myErrorPage.jsp"%>
<%@ page info="이 내용은 보이지 않음" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>directiveTag</h2>
	<p>
		NOW : <%=new Date() %>
	</p>
	<%
		String str = null;
		str.charAt(1);
	%>
</body>
</html>