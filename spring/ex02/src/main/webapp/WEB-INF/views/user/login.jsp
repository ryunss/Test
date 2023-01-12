<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Spring Board</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" href="/resources/assets/css/main.css" />
<style>
	.heading{
		color:white;
	}
	.loginForm{
		width:50%;
		margin:0 auto;
	}
	.loginForm h3{
		float:left;
		width:30%;
		color:white;
		line-height:3.24rem;
	}
	.loginForm input[type=text], .loginForm input[type=password]{
		float:right;
		width:70%;
	}
	.loginForm>.col-12::after{
		display:block;
		content:" ";
		height:50px;
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
						<li class="current"><a href="${cp}/">Home</a></li>
						<li><a href="${cp}/user/join">Join</a></li>
						<li><a href="${cp}/user/login">Login</a></li>
					</ul>
				</nav>
			</header>

			<div id="main">
				<div class="wrapper style1 special">
					<div class="inner">
						<h2 class="heading alt">로그인</h2>
						<br>
						<form class="loginForm" name="loginForm" id="loginForm" action="${cp}/user/login" method="post">
							<div class="col-12">
								<h3>아이디</h3>
								<input type="text" name="userid">
							</div>
							<div class="col-12">
								<h3>비밀번호</h3>
								<input type="password" name="userpw">
							</div>
							<div class="col-12" style="text-align: center">
								<input type="submit" value="로그인" class="primary">
							</div>
						</form>
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
