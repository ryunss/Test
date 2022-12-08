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
		String check = request.getHeader("Cookie");
		String userid = "";
		if(check != null){
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("joinid")){
					userid = cookie.getValue();
					cookie.setMaxAge(0); // 사용하고 지워줌
					response.addCookie(cookie); // 저장
					break;
				}
			}
		}
	%>
	<form>
		<input name="userid" placeholder="아이디를 입력하세요" value="<%=userid%>">
		<input name="userpw" type="password" placeholder="비밀번호를 입력하세요">
		<input type="submit" value="로그인">
	</form>
</body>
</html>