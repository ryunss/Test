<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="DBConnection.jsp" %>    
<%
	request.setCharacterEncoding("UTF-8");

/*	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/gb";
	String user = "root";
	String password = "1234";
	
	Connection conn = DriverManager.getConnection(url, user, password); */
	Connection conn = getConnection();
	
	String sql = "insert into test_user values(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	String username = request.getParameter("username");
	
	ps.setString(1, userid);
	ps.setString(2, userpw);
	ps.setString(3, username);
	
	int result = ps.executeUpdate();
	
	if(result == 1){
		Cookie cookie = new Cookie("joinid", userid);
		response.addCookie(cookie);
		response.sendRedirect("loginview.jsp");
	}else{
		response.sendRedirect("failview.jsp");		
	}
%>


