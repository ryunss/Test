<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="dan" value="${param.dan }"/>
	<c:choose>
		<c:when test="${empty dan}">
			<form>
				단 <input name="dan" id="dan"><br>
				<input type="submit" onclick="return check();">
			</form>
		</c:when>
		<c:when test="${dan > 0 && dan <= 100}">
			<c:forEach var="i" begin="1" end="9">
				${dan } * ${i } = ${dan*i}<br>
			</c:forEach>
			<hr>
			<input type="button" value="홈으로 돌아가기" onclick="location.href='gugudan.jsp'">
		</c:when>
		<c:when test="${dan <= 0 || dan > 100}">
			<span>1 이상 100 이하의 숫자를 입력하세요</span>
			<hr>
			<input type="button" value="홈으로 돌아가기" onclick="location.href='gugudan.jsp'">
		</c:when>
	</c:choose>
	<!-- 
		위의 폼에 단을 입력해서 제출했다면 해당하는 단 출력과 "홈으로 돌아가기" 버튼 생성해서 보여주기
		1 ~ 100의 범위 바깥 숫자를 입력했다면 메세지(1 이상 100 이하의 숫자를 입력하세요!) 화면에 보여주기
		숫자가 아닌것을 입력했다면 "숫자를 입력하세요!" 알럿 띄우기 isNaN
	 -->
</body>
<script>
let dan = document.getElementById("dan");
function check(){
	if(isNaN(dan.value)){
		alert("숫자만 입력하세요");
		return false;
	}
}
</script>
</html>