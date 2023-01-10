<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	에러페이지 입니다.
	
	<ul style="color: red;">
		<c:forEach items="${e.stackTrace}" var="stack"> 
			<li>${stack }</li>
		</c:forEach>
	</ul>
</body>
</html>