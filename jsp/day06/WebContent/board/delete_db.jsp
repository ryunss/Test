<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int boardnum = Integer.parseInt(request.getParameter("boardnum"));
	
	BoardDAO bdao = new BoardDAO();
	if(bdao.remove(boardnum)){
%>
		<script>
			alert("삭제 성공!");
			location.href = "list_db.jsp";
		</script>
<%
	}
	else{
%>
		<script>
			alert("삭제 실패!");
			location.href = "list_db.jsp";
		</script>
<%
	}
%>