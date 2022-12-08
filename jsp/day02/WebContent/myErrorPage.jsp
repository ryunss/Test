<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color : yellow; background-color : black; font-size: 200%;">알 수 없는 오류 발생!</h2>
	<a href="#">백신 프로그램 설치하기</a>
	<p style="color : red;">	
		<%
			// exception 객체 : 예외 페이지로 설정 시 예외를 담는 jsp 내장 객체
			out.print("예외 종류 : "+exception);
		%>
	</p>
</body>	
</html>