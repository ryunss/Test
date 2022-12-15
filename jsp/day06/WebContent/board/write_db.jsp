<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String boardtitle = request.getParameter("boardtitle");
	String boardcontents = request.getParameter("boardcontents");
	String userid = ((UserDTO)session.getAttribute("loginUser")).getUserid();

	BoardDAO bdao = new BoardDAO();
	
	BoardDTO board = new BoardDTO();
	board.setBoardtitle(boardtitle);
	board.setBoardcontents(boardcontents);
	board.setUserid(userid);
	
	if(bdao.writeBoard(board)){
%>
		<script>
			alert("게시글 등록 성공!")
			location.href = "list_db.jsp";
		</script>
<%
	}
	else{
%>
		<script>
			alert("게시글 등록 실패!")
			location.href = "list_db.jsp";
		</script>
		
<%
	}
%>








