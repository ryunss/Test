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
		String check = request.getHeader("Cookie"); // 쿠키 있는지 체크
		if(check != null){
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies){
				out.print(cookie.getName() + " : " + cookie.getValue()+"<br>");
			}
		}else{
			out.print("<p>쿠키 데이터가 존재하지 않습니다.</p>");
		}
	%>
</body>
</html>