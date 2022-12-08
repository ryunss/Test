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
				if(cookie.getName().equals("Ohing")){
					cookie.setValue("dont_eat");
					response.addCookie(cookie);
				}
			}
		}
	
	%>
</body>
</html>