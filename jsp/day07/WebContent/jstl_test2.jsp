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
	<h2>JSTL 제어문(조건문)</h2>
	<c:set var="num" value="60"/>
	<p>c:if</p>
	
	<c:if test="${num > 50 }">
		이 수는 50보다 큽니다!<br>
	</c:if>
	
	<c:if test="${num > 30 }">
		이 수는 30보다 큽니다!<br>
	</c:if>
	<hr>
	<c:set var="num" value="${num-20}"/> <!-- 변수 덮어쓰기 가능. 60-20 으로 계산되서 40으로 됨. 즉 num = num-20 -->
	<p>c:choose(if ~ else if ~ else 문도 choose로 표현)</p>
	<c:choose>
		<c:when test="${num > 50 }">
			이 수는 50보다 큽니다!<br>
		</c:when>
		<c:when test="${num > 30 }">
			이 수는 30보다 큽니다!<br>
		</c:when>
		<c:when test="${num > 10 }">
			이 수는 10보다 큽니다!<br>
		</c:when>
		<c:otherwise>
			이 수는 그 외의 숫자입니다<br>
		</c:otherwise>
	</c:choose>
</body>
</html>