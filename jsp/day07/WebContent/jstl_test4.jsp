<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 제어문(반복문)</h2>
	
	<h3>기본 for문</h3>
	<!-- for(int i=1; i<=10; i++) -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p id="pTag${i}">pTag${i }</p>
	</c:forEach>
	<hr>
	<h3>배열의 크기만큼 반복하기</h3>
	<c:set var="arData" value="<%=new int[]{10,20,30,40,50} %>"/>
									<!-- arData.getLength() 찾는거랑 같기 때문에 에러 발생함. -->
	<%--<c:forEach var="i" begin="0" end="${arData.length - 1}">--%>
	<c:forEach var="i" begin="0" end="${fn:length(arData) - 1}">
		${i }번방 : ${arData[i]}<br>
	</c:forEach>
	<hr>
	<h3>빠른 for문</h3>
	<c:forEach var="data" items="${arData}">
		${data }<br>
	</c:forEach>
	<hr>
	<h3>for문에서 두개의 변수 다 운용하기</h3>
	<!-- 
		for(int i=0; i<=arData.length-1; i++){
			int data = arData[i];
		}
	 -->
	<c:forEach var="i" begin="0" end="${fn:length(arData) - 1}">
		<c:set var="data" value="${arData[i] }"/>
		${i} : ${data} /
	</c:forEach>
	<br>
	<!-- 
		int i = 0;
		for(int data : arData){
		i = i+1;
	 -->
	<c:set var="i" value="0"/>
	<c:forEach items="${arData }" var="data">
		${i } : ${data } / 
		<c:set var="i" value="${i+1}"/>
	</c:forEach>
	<hr>
	
	<h3>HashMap으로 빠른for문 돌리기</h3>
	<%
		HashMap<String,Integer> map = new HashMap<>();
		map.put("하나",1);
		map.put("둘",2);
		map.put("셋",3);
		
		pageContext.setAttribute("map", map);
	%>
	<c:forEach items="${map }" var="entry">
		${entry.key } : ${entry.value } <br>
	</c:forEach>
	
</body>
</html>