<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	UserDAO udao = new UserDAO();
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	if(udao.login(userid, userpw)){
		session.setAttribute("loginUser", userid);
		response.sendRedirect("main.jsp");
	}else{
		response.sendRedirect("loginview.jsp?l=f");
	}
%>