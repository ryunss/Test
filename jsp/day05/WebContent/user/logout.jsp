<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 지우는 방법
	// 방법 1 session.setAttribute("loginUser", null);
	// 방법 2 session.removeAttribute("loginUser");
	// 방법 3 session.invalidate();
	
	session.invalidate();
%>
<script>
	alert("다음에 꼭 다시오세요");
	location.href="index.jsp";
</script>