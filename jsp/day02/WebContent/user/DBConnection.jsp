<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	Connection getConnection(){
		
		Connection conn = null;
		try{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/gb";
		String user = "root";
		String password = "1234";
		
		conn = DriverManager.getConnection(url, user, password);
		
		}catch(ClassNotFoundException cnfe){
			
		}catch(SQLException sqle){
			
		}
		return conn;
	}
%>