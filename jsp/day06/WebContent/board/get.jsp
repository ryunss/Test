<%@page import="dto.UserDTO"%>
<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO bdao = new BoardDAO();
	int boardnum = Integer.parseInt(request.getParameter("boardnum"));
	BoardDTO board = bdao.getDetail(boardnum);
	String userid = ((UserDTO)session.getAttribute("loginUser")).getUserid();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=board.getBoardtitle() %></h2>
	<h3><%=board.getUserid() %></h3>
	<h3><%=board.getRegdate() %></h3>
	<textarea style="resize:none; width:300px;" readonly><%=board.getBoardcontents() %></textarea>
	<hr>
	<a href="list_db.jsp">목록보기</a>
	<%
	if(board.getUserid().equals(userid)){
	%>
	<!--
		수정 버튼 클릭시 get.jsp와 동일하게 생겼지만, textarea가 수정 가능한 페이지로 이동
		modify.jsp로 이동했을 때 게시글의 내용이 미리 써져있어야 함
		그곳에서 수정완료 버튼을 클릭했을 때 실제 DB의 수정이 일어나고
		성공시 "수정 성공" 알럿 후 보던 게시글로 돌아오기
		실패시 "수정 실패" 알럿 후 보던 게시글로 돌아오기
		test.jsp?a=10&b=20&c=30
	-->
	<a href="modify.jsp?boardnum=<%=board.getBoardnum()%>">수정</a>
	
	<a href="delete_db.jsp?boardnum=<%=board.getBoardnum()%>">삭제</a>
	<%
	}
	%>
</body>
</html>










