<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String userid = request.getParameter("userid");
	UserDAO udao = new UserDAO();
	
	if(udao.checkId(userid)){
		out.print("O");
	}else{
		out.print("X");
	}
%>