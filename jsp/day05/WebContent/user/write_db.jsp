<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="board" class="dto.BoardDTO"/>
<jsp:setProperty property="*" name="board"/>
<%
	BoardDAO bdao = new BoardDAO();
	
	if(bdao.write(board)){
		// 성공		
		response.sendRedirect("main.jsp");
	}else{
		// 실패
		response.sendRedirect("loginview.jsp?l=f");
	}
%>