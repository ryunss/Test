<%@page import="bean.TestBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--	객체에 담아서 각각 데이터들을 저장하는데 이렇게 하면 코드도 너무 길어짐
	<%
		TestBean bean = new TestBean();
		
		bean.setIntdata(Integer.parseInt(request.getParameter("intdata")));
		bean.setDoubledata(Double.parseDouble(request.getParameter("doubledata")));
		bean.setStrdata(request.getParameter("strdata"));
	%>
 --%>
 	<%-- id가 객체명이다. class 는 bean 클래스 안의 TestBean 이다.--%>
 	<jsp:useBean id="bean" class="bean.TestBean"/>
 	<%-- name은 객체명이다. property는 필드명--%>
 <%--	
 	<jsp:setProperty property="intdata" name="bean"/>
 	<jsp:setProperty property="doubledata" name="bean"/>
 	<jsp:setProperty property="strdata" name="bean"/>
 --%>
 	
 	<jsp:setProperty property="*" name="bean"/>
  	
 	<%-- 
 		jsp:setProperty 는 외부에서 날라온 파라미터 중 같은 name을 가지고 있는것이 있다면
 		value 속성을 작성하지 않더라도 값이 자동으로 들어간다.
 	 --%>
 	
 	<%
 		System.out.println(bean.getIntdata());
 		System.out.println(bean.getDoubledata());
 		System.out.println(bean.getStrdata());
 	%>
 	
 	<hr>
 	방법 1 <%=bean.getIntdata() %> <br>
 	방법 2 <jsp:getProperty property="intdata" name="bean"/>
 	
</body>
</html>