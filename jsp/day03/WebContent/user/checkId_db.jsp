<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="DBConnection.jsp"%>

<%
	Connection conn = getConnection();
	String userid = request.getParameter("userid");
	
	String sql = "select * from test_user where userid = ?";
	
	PreparedStatement ps = conn.prepareStatement(sql);
	
	ps.setString(1, userid);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()){
		// 중복된 아이디
		out.print("X");
	}else{
		// 사용가능한 아이디
		out.print("O");
	}
%>