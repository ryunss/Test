<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 sttr 삭제
	session.removeAttribute("ab");
%>
<script>
alert("로그아웃 되었습니다.");
location.href = "login.jsp";
</script>