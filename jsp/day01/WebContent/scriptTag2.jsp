<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptTag2</h2>
	<%! String className = "primary"; %>
	
	<!-- HTML 주석은 컴파일이 모두 되고 나서 페이지에서 감춰지는 형태이다. 따라서 내부 내용들이 다 실행된다. -->
	<%-- JSP 주석은 안에 작성된 모든 코드가 무시되므로 JSP 주석을 권장한다. --%>
	
	<%
		for(int i=0; i<10; i++){
			// <a class='primary'>버튼</a>
			out.print("<a class='"+className+"'>버튼</a>");
		}
	%>
	
	<% for(int i=0; i<10; i++){%>
		<a class="<%=className%>">버튼</a>
	<%} %>
</body>
</html>