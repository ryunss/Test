<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="dto.UserDTO"/>
<jsp:setProperty property="*" name="user"/>
<%
	UserDAO udao = new UserDAO();
	if(udao.join(user)){
		Cookie cookie = new Cookie("joinid",user.getUserid());
		response.addCookie(cookie);
		
		//1. 파라미터
		//response.sendRedirect("loginview.jsp?j=t");
		
		//2. js 활용
		//<script>alert('회원가입 성공!');location.href='loginview.jsp'</script>
		/*
		out.print("<script>alert('회원가입 성공!');");
		out.print("location.href = 'loginview.jsp'");
		out.print("</script>");
		*/
		
		//3. 쿠키
		/*
		Cookie cookie2 = new Cookie("j","t");
		response.addCookie(cookie2);
		response.sendRedirect("loginview.jsp");
		*/
		
		//4. 세션
		session.setAttribute("j", "t");
		response.sendRedirect("loginview.jsp");
	}
	else{
		//1. 파라미터
		//response.sendRedirect("loginview.jsp?j=f");
		
		//2. js 활용
		/*
		out.print("<script>alert('회원가입 실패!');");
		out.print("location.href = 'loginview.jsp'");
		out.print("</script>");
		*/
		
		//3. 쿠키
		/*
		Cookie cookie2 = new Cookie("j","f");
		response.addCookie(cookie2);
		response.sendRedirect("loginview.jsp");
		*/
		
		//4. 세션
		session.setAttribute("j", "f");
		response.sendRedirect("loginview.jsp");
	}

%>



















