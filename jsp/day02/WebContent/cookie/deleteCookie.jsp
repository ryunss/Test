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
					cookie.setMaxAge(0); // setMaxAge(0) : 0초로 유효기간 세팅. 없어지는거랑 같음
					response.addCookie(cookie);
				}
			}
		}
	%>
</body>
</html>