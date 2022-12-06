<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptTag3</h2>
	<p>
		NOW : <%=new java.util.Date() %>
	</p>
	<table border="1">
		<%for(int i=0; i<5; i++){ %>
		<tr>
			<td><%=i+1%>행 1열</td>
			<td><%=i+1%>행 2열</td>
			<td><%=i+1%>행 3열</td>
			<td><%=i+1%>행 4열</td>
			<td><%=i+1%>행 5열</td>
		</tr>
		<%} %>
	</table>
</body>
</html>