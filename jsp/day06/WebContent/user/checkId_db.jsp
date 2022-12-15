<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	UserDAO udao = new UserDAO();
	
	if(udao.checkId(userid)){
		//사용 가능한 아이디
		out.print("O");
	}
	else{
		//중복된 아이디
		out.print("X");
	}
%>
