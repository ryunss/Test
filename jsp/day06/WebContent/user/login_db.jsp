<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	UserDAO udao = new UserDAO();
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");

	UserDTO loginUser = udao.login(userid,userpw);
	
	if(loginUser != null){
		session.setAttribute("loginUser", loginUser);
		response.sendRedirect("../board/list_db.jsp");
	}
	else{
		response.sendRedirect("loginview.jsp?l=f");
	}

%>









