<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*, com.lec.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 우선순위</title>
</head>
<body>
<%

	//scope 우선순위 pageContext > request > session > application
	pageContext.setAttribute("myage", "pageContext @@!");
	request.setAttribute("myage", "request~~!");
	session.setAttribute("myage", "session...");
	application.setAttribute("myage", "application!!");
%>
myage: ${myage } <br>
applicationScope.myage : ${applicationScope.myage }<br>
sessionScope.myage: ${sessionScope.myage} <br> <%-- 꼭 찝어서 session 의 attribute값 --%>
requestScope.myage: ${requestScope.myage }<br> <%-- 꼭 찝어서 request 의 attribute값 --%>
pageScope.myage: ${pageScope.myage} <br> <%-- 콕 찝어서 pageContext 의 attribute값 --%>
<hr>

<%
	request.setAttribute("dto", new WriteDTO(100, "제목", "내용", "작성자", 3, LocalDateTime.now()));
%>

${dto }<br> <%-- toString 값이 나옴 --%>
${dto.id }<br> <%-- mydto.getId() 값 --%>
<%= ((WriteDTO)request.getAttribute("dto")).getId() %> <br><%-- 위랑 동일한 코드임 --%>
${dto.subject }<br>
${dto.content }<br>
${dto.regDate }<br> <%-- 세터세터의 이름임 regDate, content, subject --%>

${dto.regDateTime }<br> <%-- mydto.getRegDateTime() 값 --%>

</body>
</html>