<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptTag1</h2>
	<%!
		int count = 3;
		String sayHello(String data){
			return "Hello "+data;
		}
	%>
	<%=sayHello("JSP")%>
	<%-- <% out.print(sayHello("JSP")); %> 이거랑  <%=sayHello("JSP")%> 이거랑 같다.--%>
	<hr>
	
	<%
		for(int i=0; i<count; i++){
			out.print(sayHello("JSP")+"<br>");
		}
	%>
	<hr>
	<% for(int i=0; i<count; i++){ %>
		<%=sayHello("_JSP") %><br>
	<%} %>
	
	<hr>
	
	
</body>
</html>