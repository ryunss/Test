<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO"/>
<jsp:setProperty name="dto" property="id" value="123"/>
<jsp:setProperty name="dto" property="subject" value="제목입니다"/>
<jsp:setProperty name="dto" property="name" value="작성자입니다"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id : <%= dto.getId() %><br>
제목 : <%= dto.getSubject() %> <br>
작성자 : <%= dto.getName()  %> <br>
내용 : <%= dto.getContent() %> <br>
<hr>

id = <jsp:getProperty name="dto" property="id"/><br>
제목 = <jsp:getProperty name="dto" property="subject"/><br>
작성자 = <jsp:getProperty name="dto" property="name"/><br>
내용 = <jsp:getProperty name="dto" property="content"/><br>
<hr>

<%--
el_1에서 봤을 떄랑은 다르게 자바를 el 로 쓰면 아무것도 안떳지만
자바빈이랑은 궁합이 좋음. 이렇게 쓸 수 있음
 --%>
id : ${dto.id}<br> <%-- dto객체의 getId() 값 --%>
제목 : ${dto.subject}<br>
작성자 : ${dto.name}<br>
내용 : ${dto.content}<br> <%-- 값이 없거나 null 이면 표현하지 않는다. --%>
dto: ${dto } <br>
<%-- @data 가 toString 도 있어서 dto 객체의 toString() 값이 나온다 --%>
<%-- WriteDTO(id=123, subject=제목입니다, content=null, name=작성자입니다, viewCnt=0, regDate=null) --%>
<%-- xxx: ${dto.xxx }<br>-- 에러%> <%-- dto.getXxx() ? --%>
</body>
</html>


















