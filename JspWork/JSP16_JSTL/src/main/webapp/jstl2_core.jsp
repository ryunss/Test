<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>set, remove, out</h2>
이름 : <c:out value="jang"/><br>
<c:set var="name" value="홍길동"/>
이름 : <c:out value="${name }"/><br>	<%-- JSTL의 변수는 EL에서 사용 가능 --%>
이름 : ${pageScope.name }<br> <%-- set으로 설정한것은 pageScope의 애트리뷰트로 저장됨 --%>

<c:remove var="name"/>
이름 : <c:out value="${name }"/><br>
<hr>

<%
	int age = 10;
%>
나이 : ${age }<br>
<c:set var="age" value="<%=age %>"/>
나이 : ${age }<br>

<hr>
<h2>catch</h2>
<c:catch var="error">
<%-- c:catch 태그 안에서 예외 발생하면 예외 처리 
	발생한 예외는 error 변수에 담는다
--%>
<%= 2/0 %>
</c:catch>

<c:out value="${error }"/>

<br>

<c:catch var="ex">
name parameter 값 = <%= request.getParameter("name") %> <br>
<% if(request.getParameter("name").equals("test")){ %>
	${param.name } 은 test 입니다.
<% } %>
</c:catch>

<c:if test="${ex != null }">
		예외발생<br>
		${ex }
</c:if>

<%-- http://localhost:8088/JSP16_JSTL/jstl2_core.jsp?name=test 참. --%>





</body>
</html>





























