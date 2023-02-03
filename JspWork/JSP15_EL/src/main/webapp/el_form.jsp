<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 내장객체</title>
</head>
<body>
	<form action="el_ok.jsp" method="get">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="checkbox" name="hobby" value="music">음악<br>
		<input type="checkbox" name="hobby" value="sport">운동<br>
		<input type="checkbox" name="hobby" value="game">게임<br>
		<input type="submit" value="login">
	</form>
	
	<% 
		// 내장객체
		application.setAttribute("name1", "김사과");
		session.setAttribute("name2", "반하나");
		request.setAttribute("name3", "박수박");
		pageContext.setAttribute("name4", "최포도");
	%>
	
	application: ${applicationScope.name1 }<br> <%-- application.getAttribute("name1"); 과 동일 --%>
	<%=application.getAttribute("name1") %> <br>
	session: ${sessionScope.name2 }<br>
	request: ${requestScope.name3 }<br>
	page: ${pageScope.name4 }<br>
	없는값 : ${pageScope.xxx } <br> <%-- 안나옴 pageContext.getAttribute("xxx") => null 리턴인데 el은 null값 표현 X --%>

</body>
</html>


