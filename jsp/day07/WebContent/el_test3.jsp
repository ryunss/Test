<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	쿠키값 : ${cookie.today.value}<br>
	아이디 : ${param.id}<br>
	비밀번호 : ${param.pw }<br>
	이름 : ${param.name != null ? param.name : "이름없음" }<br>
	취미 : ${paramValues.hobby[0] } / ${paramValues.hobby[1] }<br>
</body>
</html>