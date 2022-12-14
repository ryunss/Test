<%@page import="dto.UserDTO"%>
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
		UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
		if(loginUser == null){			
	%>
			<script>
				alert("로그인 후 이용하세요!");
				location.href="loginview.jsp";
			</script>		
		<%} %>
		
	<p><%=loginUser.getUsername() %>님 어서오세요</p>
	<p><a href="logout.jsp">로그아웃</a></p>
	<hr>
	<!-- 
		글쓰기 클릭 시 게시판 작성 페이지로 이동
		게시글 제목, 게시글 내용 작성 후 [작성완료] 버튼 클릭
		데이터베이스에 작성된 게시글 데이터 하나 추가 (게시글 번호, 게시글 제목, 게시글 내용, 작성된 시간, 작성자ID)
		작성이 완료되었으면 main.jsp로 돌아오기 (성공/실패 alert 띄우기)
	 -->
	<p>
		<a href="boardwrite.jsp">글쓰기</a>
	</p>
</body>
</html>