<%@page import="java.util.Arrays"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String[] hobby = request.getParameterValues("hobby");
%>

id = <%=id %><br>
pw = <%=pw %><br>
hobby =
<% for(int i = 0; i<hobby.length; i++){ %>
	<%= hobby[i] %>
<% } %>
<hr>

아이디 : ${param.id }<br>
비밀번호 : ${param.pw }<br>
취미 : ${paramValues.hobby[0] }
 ${paramValues.hobby[1] }
 ${paramValues.hobby[2] }<br>
 <hr>
 
아이디 : ${ param["id"] }<br>
비밀번호 : ${ param["pw"] }<br>
취미 : ${paramValues.hobby[0] }
 ${paramValues.hobby[1] }
 ${paramValues.hobby[2] }<br>
 <hr>

application: ${applicationScope.name1 }<br> <%-- application.getAttribute("name1"); 과 동일 --%>
	<%=application.getAttribute("name1") %> <br>
	session: ${sessionScope.name2 }<br>
	request: ${requestScope.name3 }<br>
	page: ${pageScope.name4 }<br>

<h3>ContextPath</h3>
<%=request.getContextPath() %><br>
${pageContext.request.contextPath }<br>

<a href="/JSP15_EL/el_form.jsp">입력폼</a> <%-- 비추. contextPath는 언제든 바뀔 수가 있음 --%>
<a href="${pageContext.request.contextPath }/el_form.jsp">입력폼</a> <%-- 이렇게 쓰는것 추천 --%>








</body>
</html>