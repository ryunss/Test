<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 변수</h2>
	<c:set var="id" value="apple"/> <!-- pageContext.setAttribute("id","value") -->
	회원아이디 : ${id }<br> <!-- el문으로 꺼내기 -->
	회원아이디 : <c:out value="${id}"/> <!-- jstl로 꺼내기 -->
	<hr>
	
	<!-- session.setAttribute("id","banana") -->
	<c:set var="id" scope="session">banana</c:set>
	세션의 아이디 : ${sessionScope.id }
	 
</body>
</html>