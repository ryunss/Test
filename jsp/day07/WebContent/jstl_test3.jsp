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
	<c:set var="userid" value="${param.userid }"/>
	<c:choose>
		<c:when test="${empty userid }">
			<form> <!-- 액션을 생략하고 submit하면 이 자리 그대로 돌아온다. jstl_test3.jsp -->
				아이디 <input type="text" name="userid"><br>
				비밀번호 <input type="password" name="userpw"><br>
				<input type="submit">	
			</form>		
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${userid == 'admin' }">
					<span style="color:red">관리자</span>
				</c:when>
				<c:when test="${userid == 'apple' }">
					<b>김사과님 어서오세요~</b>
				</c:when>
				<c:otherwise>
					<script>
						alert("비회원입니다! 돌아가세요!");
						history.go(-1); // 현재 페이지에서 -1 (뒤로가기) 0 (현재 페이지) -1 대신 history.back() 해도 됨
					</script>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>