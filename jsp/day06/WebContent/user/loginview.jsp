<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginview</title>
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
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
	%>
	<!-- 1. 파라미터 -->
	<%-- <%
		String flag = request.getParameter("j");
		if(flag != null){
			if(flag.equals("t")){
	%>
			<script>alert("회원가입 성공!")</script>	
	<%
			}
			else{
	%>
			<script>alert("회원가입 실패!")</script>
	<%
			}
		}
	%> --%>
	<%-- <%
		String check2 = request.getHeader("Cookie");
		String flag = null;
		if(check2 != null){
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("j")){
					flag = cookie.getValue();
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		if(flag != null){
			if(flag.equals("t")){
	%>
			<script>alert("회원가입 성공!")</script>	
	<%
			}
			else{
	%>
			<script>alert("회원가입 실패!")</script>
	<%
			}
		}
	%> --%>
	
	<%
		String flag = (String)session.getAttribute("j");
		session.removeAttribute("j");
		if(flag != null){
			if(flag.equals("t")){
	%>
			<script>alert("회원가입 성공!")</script>	
	<%
			}
			else{
	%>
			<script>alert("회원가입 실패!")</script>
	<%
			}
		}
	%>
	<%
		String l = request.getParameter("l");
		if(l != null){
			if(l.equals("f")){
	%>
			<script>alert("로그인 실패!")</script>
	<%
			}
		}
	%>
	<form action="login_db.jsp" method="post">
		<input name="userid" placeholder="아이디를 입력하세요" value="<%=userid%>">
		<input name="userpw" type="password" placeholder="비밀번호를 입력하세요">
		<input type="submit" value="로그인">
	</form>
	<a href="joinview.jsp">회원가입</a>
	<a href="../index.jsp">처음 화면</a>
</body>
</html>







