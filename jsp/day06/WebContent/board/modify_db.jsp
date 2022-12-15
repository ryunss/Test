<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String boardtitle = request.getParameter("boardtitle");
	String userid = request.getParameter("userid");
	String boardcontents = request.getParameter("boardcontents");
	int boardnum = Integer.parseInt(request.getParameter("boardnum"));

	BoardDAO bdao = new BoardDAO();
	
	if(bdao.updateBoard(boardnum,boardtitle,boardcontents)){
%>
	<script>
		alert("수정 성공!");
		location.href="get.jsp?boardnum=<%=boardnum%>"
	</script>
<%
	}
	else{
%>
	<script>
		alert("수정 실패!");
		location.href="get.jsp?boardnum=<%=boardnum%>"
	</script>

<%		
	}
%>
