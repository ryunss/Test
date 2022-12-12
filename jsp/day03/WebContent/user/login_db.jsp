<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="DBConnection.jsp"%>
<%
	Connection conn = getConnection();
	
	request.setCharacterEncoding("UTF-8");
	
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	String sql = "select * from test_user where userid=? and userpw=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	
	ps.setString(1, userid);
	ps.setString(2, userpw);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()){
		session.setAttribute("loginUser", userid);
		response.sendRedirect("main.jsp");
	}else{
		response.sendRedirect("login_fail.jsp");
	}
%>