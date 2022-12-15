<%@page import="dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String temp = request.getParameter("pagenum");
	int pagenum = 0;
	if(temp == null){
		pagenum = 1;
	}
	else{
		pagenum = Integer.parseInt(temp);
	}

	BoardDAO bdao = new BoardDAO();
	List<BoardDTO> list = bdao.getList(pagenum);
	request.setAttribute("list", list);
	request.setAttribute("cnt", bdao.getCnt());
	request.setAttribute("pagenum", pagenum);
	request.getRequestDispatcher("main.jsp").forward(request, response);
%>








