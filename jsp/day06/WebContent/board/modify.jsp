<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO bdao = new BoardDAO();
	int boardnum = Integer.parseInt(request.getParameter("boardnum"));
	BoardDTO board = bdao.getDetail(boardnum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify_db.jsp" method="post" name="modifyForm">
		<p>
			<input name="boardnum" type="hidden" value="<%=board.getBoardnum()%>">
		</p>
		<p>
			<input name="boardtitle" type="text" value="<%=board.getBoardtitle() %>">
		</p>
		<p>
			<input name="userid" type="text" readonly value="<%=board.getUserid() %>">
		</p>
		<div>
			<textarea name="boardcontents" style="resize:none; width:300px;"><%=board.getBoardcontents() %></textarea>
		</div>
	</form>
	<hr>
	<a href="javascript:document.modifyForm.submit()">수정완료</a>
	<a href="list_db.jsp">목록보기</a>
</body>
</html>









