<%@page import="dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<%
		UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
		if(loginUser == null){
	%>
		<script>
			alert("로그인 후 이용하세요!");
			location.href = "loginview.jsp";
		</script>
	<%
		}
		List<BoardDTO> list = (List)request.getAttribute("list");
		int pagenum = (Integer)request.getAttribute("pagenum");
		int cnt = (Integer)request.getAttribute("cnt");
		int realLast = (int)Math.ceil((double)cnt/10);
		int last = ((pagenum-1)/5+1)*5;
		int first = last-4;
		if(first <= 0){
			first = 1;
		}
		if(last > realLast){
			last = realLast;
		}
	%>
	<p><%=loginUser.getUsername()%>님 어서오세요~</p>
	<p><a href="../user/logout.jsp">로그아웃</a></p>
	<hr>
	<!--
		글쓰기 클릭시 게시판 작성 페이지로 이동
		게시글 제목, 게시글 내용 작성 후 [작성완료] 버튼 클릭
		데이터베이스에 작성된 게시글 데이터 하나 추가 (게시글 번호, 게시글 제목, 게시글 내용, 작성된 시간, 작성자 ID)
		작성이 완료되었으면 main.jsp로 돌아오기(성공/실패 알럿 띄우기)
	-->
	<div>
		<a href="../board/boardwrite.jsp">글쓰기</a>
		<hr>
		<!-- 리스트 띄우기 -->
		<table border="1" align="center">
			<tr>
				<th style="width:50px;">번호</th>
				<th style="width:200px;">제목</th>
				<th style="width:100px;">작성자</th>
				<th style="width:100px;">작성일</th>
			</tr>
			<%
			for(BoardDTO board : list){
			%>
			<tr>
				<td><%=board.getBoardnum()%></td>
				<td><a href="get.jsp?boardnum=<%=board.getBoardnum()%>"><%=board.getBoardtitle() %></a></td>
				<td><%=board.getUserid() %></td>
				<td><%=board.getRegdate()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<div class="pagination" style="text-align: center;">
			<%
			if(pagenum > 5){
			%>
			<a href="list_db.jsp?pagenum=<%=pagenum-5%>">&lt;</a>
			<%
			}
			for(int i=first;i<=last;i++){
			%>
			<a href="list_db.jsp?pagenum=<%=i%>"><%=i%></a>
			<%
			}
			if(last != realLast){
			%>
			<a href="list_db.jsp?pagenum=<%=pagenum+5>realLast?realLast:pagenum+5%>">&gt;</a>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>













