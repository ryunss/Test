<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardwrite</title>
</head>
<body>
	<form action="write_db.jsp" method="post">
		<p>
			<input type="text" name="boardtitle">
		</p>
		<p>
			<textarea name="boardcontents"></textarea>
		</p>
		<p>
			<input type="submit" value="등록완료">
		</p>
	</form>
</body>
</html>