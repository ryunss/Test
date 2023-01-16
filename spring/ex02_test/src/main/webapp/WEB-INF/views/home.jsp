<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cp" scope="session"></c:set>
<html>
<head>
   <title>Spring Board</title>
   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
   <meta name="description" content="" />
   <meta name="keywords" content="" />
   <link rel="stylesheet" href="${cp}/resources/assets/css/main.css" />
</head>
<body class="is-preload">

      <!-- Header -->
         <header id="header" class="alt">
            <a class="logo" href="${cp}/">Spring <span>Board</span></a>
            <nav id="nav">
               <ul>
                  <c:choose>
                  	<c:when test="${loginUser == null }">
                        <li class="current"><a href="${cp}/">Home</a></li>
                        <li><a href="${cp}/user/join">Join</a></li>
                        <li><a href="${cp}/user/login">Login</a></li>
                  	</c:when>
                  	<c:otherwise>
                        <li>${loginUser.username }님 환영합니다!</li>
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
                  <h1 class="heading alt">스프링 게시판</h1>
                  <p>스프링 최종 예제</p>
                  <div class="image fit special">
                     <img src="${cp}/resources/images/2023.jpg" alt="ㅇ" />
                  </div>
               </div>
            </div>
         </div>
      <!-- Scripts -->
         <script src="${cp }/resources/assets/js/jquery.min.js"></script>
         <script src="${cp }/resources/assets/js/jquery.dropotron.min.js"></script>
         <script src="${cp }/resources/assets/js/browser.min.js"></script>
         <script src="${cp }/resources/assets/js/breakpoints.min.js"></script>
         <script src="${cp }/resources/assets/js/util.js"></script>
         <script src="${cp }/resources/assets/js/main.js"></script>

   </body>
</html>