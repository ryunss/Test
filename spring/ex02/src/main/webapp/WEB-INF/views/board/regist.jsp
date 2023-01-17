<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="${cp}/resources/assets/css/main.css" />
<style>
	#banner input, #banner select, #banner option{
		color:#000000;
	}
	input:not(.button), textarea{
		border:1px solid black !important;
		color:#000000 !important;
	}
	#banner .write_area ::placeholder{
		color:#888 !important;
	}
	.write_area{
		width:70%;
		margin:0 auto;	
	}
	.write_area input{
		margin-bottom: 32px;
	}
	.write_area > form > div{
		margin-bottom:32px;
	}
	.write_area > form > div:nth-of-type(odd) > h4 {
		float:left;
	}
	.write_area > form > div:nth-of-type(odd) > input {
		width:70%;
		float:right;
	}
	form h4{
		line-height:3.25rem;
	}
	hr{
		clear:both;	
	}
</style>
</head>
<body class="is-preload">
	<!-- Header -->
	<header id="header" class="alt">
		<a class="logo" href="${cp}/">Spring <span>Board</span></a>
		<nav id="nav">
			<ul>
				<c:choose>
					<c:when test="${loginUser == null}">
						<li class="current"><a href="${cp}/">Home</a></li>
						<li><a href="${cp}/user/join">Join</a></li>
						<li><a href="${cp}/user/login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li>${loginUser.username}님 환영합니다!</li>
						<li class="current"><a href="${cp}/">Home</a></li>
						<li><a href="${cp}/board/list">Board</a></li>
						<li><a href="${cp}/user/logout">Logout</a></li>
					</c:otherwise>
				</c:choose>
					
					
			</ul>
		</nav>
	</header>

<!-- Banner -->
	<div id="banner">
		<div class="wrapper style1 special">
			<div class="inner">
				<h1 class="heading alt">Board</h1>
				<p>게시판 등록</p>
				<a href="${cp}/board/list${cri.listLink}" class="button primary" style="float:right; border-radius:0px; border-bottom: 1px solid white; border-top: 1px solid white;">목록 보기</a>
				<br>
				<br>
				<br>
				<div class="write_area" style="clear:both;">
					<form name="boardForm" method="post" action="${cp }/board/regist">
						<div class="col-12">
							<h4>제목</h4>
							<input name="boardtitle" type="text" placeholder="Title">
						</div>
						<hr>
						<div class="col-12">
							<h4>내용</h4>
							<textarea name="boardcontents" placeholder="Contents" rows="10"></textarea>
						</div>
						<hr>
						<div>
							<h4>작성자</h4>
							<input name="userid" type="text" value="${loginUser.userid}" readonly>
						</div>
						<hr>
						<div>
							<input type="submit" value="등록" class="button primary">
						</div>
					</form>
				
				</div>
			</div>
		</div>
	</div>
<!-- Scripts -->
	<script src="${cp}/resources/assets/js/jquery.min.js"></script>
	<script src="${cp}/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="${cp}/resources/assets/js/browser.min.js"></script>
	<script src="${cp}/resources/assets/js/breakpoints.min.js"></script>
	<script src="${cp}/resources/assets/js/util.js"></script>
	<script src="${cp}/resources/assets/js/main.js"></script>

</body>
</html>
