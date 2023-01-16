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
   .small-width{
      display:none;
   }
   #banner input, #banner select, #banner option{
      color:#000000;
   }
   select{
      width:15%;
      text-align: center;
      padding:0 20px;
      display: inline;
   }
   #keyword{
      width:55%;
      display: inline;   
   }
   #keyword+a{
      border:1px solid white;
   }
   th, td{
      text-align: center !important;
   }
   tbody tr:hover{
      background-color:rgba(255,255,255,0.3) !important;
   }
   .nowPage{
      background-color:#F9F8FF !important;
      color:#8086F1 !important;
      font-weight: 900;
   }
   @media screen and (max-width:790px){
      .big-width{
         display:none;
      }
      .small-width{
         display:block;
      }
      select[name='type']{
         width:80%;
      }
      #keyword{
         margin:10px auto;
         width:80%;
         display:block;
      }
   }
</style>
</head>
<body class="is-preload">
   <c:if test="${boardnum != null}">
      <script>alert("${boardnum}번 게시글 작성 완료!");</script>
   </c:if>
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
            <p>게시판 목록</p>
            <a href="${cp }/board/regist${pageMaker.cri.listLink}" class="button primary" style="float:right; border-radius:0px; border-bottom: 1px solid white; border-top: 1px solid white;">글 등록</a>
            <div class="table-wrapper" style="clear: both;">
               <table>
                  <thead>
                     <tr>
                        <th style="width:10%;">번호</th>
                        <th style="width:40%;">제목</th>
                        <th style="width:15%;">작성자</th>
                        <th class="big-width" style="width:35%;">작성시간</th>
                     </tr>
                  </thead>
                  <tbody>
					<c:if test="${list != null and list.size() > 0 }">
						<c:forEach items="${list }" var="board">
		                     <tr>
		                        <td>${board.boardnum }</td>
		                        <td><a href="${board.boardnum}" class="get">${board.boardtitle }</a></td>
		                        <td>${board.userid }</td>
		                        <td class="big-width">${board.regdate }
		                        	<c:if test="${board.regdate != board.updatedate }">
			                           <br>(${board.updatedate }) <%-- 수정됐을 때 수정시간 자리 --%>
		                        	</c:if>
		                        </td>
		                     </tr>
						</c:forEach>					
					</c:if>
					<c:if test="${list == null or list.size() le 0 }">
                     <tr>
                        <td colspan="4" class="big-width">작성된 게시글이 없습니다.</td>
                        <td colspan="3" class="small-width">작성된 게시글이 없습니다.</td>
                     </tr>
					</c:if>
                  </tbody>
               </table>
            </div>
            <form id="searchForm" action="${cp}/board/list">
               <div>
                  <select name="type">
                     <option value="" ${pageMaker.cri.type == null ? "selected" : "" }>검색</option>
                     <%-- null 이면 selected 를 적어놔서 옵션이 선택되있는거처럼 만듬 --%>
                     <option value="T" ${pageMaker.cri.type == "T" ? "selected" : "" }>제목</option>
                     <option value="C" ${pageMaker.cri.type == "C" ? "selected" : "" }>내용</option>
                     <option value="W" ${pageMaker.cri.type == "W" ? "selected" : "" }>작성자</option>
                     <option value="TC" ${pageMaker.cri.type == "TC" ? "selected" : "" }>제목 또는 내용</option>
                     <option value="TW" ${pageMaker.cri.type == "TW" ? "selected" : "" }>제목 또는 작성자</option>
                     <option value="TCW" ${pageMaker.cri.type == "TCW" ? "selected" : "" }>제목 또는 내용 또는 작성자</option>
                  </select>
                  <input type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword }">
                  <a href="#" class="button primary">검색</a>
               </div>
               <input type="hidden" value="1" name="pagenum">
               <input type="hidden" value="10" name="amount">
            </form>
            <div class="pagination center big-width">
            	<c:if test="${pageMaker.prev }">
	               <a class="changePage" href="${pageMaker.startPage-1}"><code>&lt;</code></a>
            	</c:if>
            	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage }" var="i">
					<c:if test="${i == pageMaker.cri.pagenum }">
		               <code class="nowPage">${i}</code>
					</c:if>
					<c:if test="${i != pageMaker.cri.pagenum }">
	    	           <a class="changePage" href="${i}"><code>${i}</code></a>
					</c:if>
            	</c:forEach>
            	<c:if test="${pageMaker.next }">
	               <a class="changePage" href="${pageMaker.endPage+1}"><code>&gt;</code></a>
            	</c:if>
            </div>
            
            <div class="pagination center small-width">
               <a class="changePage" href=""><code>&lt;</code></a>
               <code></code>
               <a class="changePage" href=""><code>&gt;</code></a>

            </div>
         </div>
      </div>
   </div>
   <form name="pageForm" id="pageForm" action="${cp}/board/list">
      <input type="hidden" value="${pageMaker.cri.pagenum }" name="pagenum">
      <input type="hidden" value="${pageMaker.cri.amount }" name="amount">
      <input type="hidden" value="${pageMaker.cri.type }" name="type">
      <input type="hidden" value="${pageMaker.cri.keyword }" name="keyword">
   </form>
<!-- Scripts -->
   <script src="${cp}/resources/assets/js/jquery.min.js"></script>
   <script src="${cp}/resources/assets/js/jquery.dropotron.min.js"></script>
   <script src="${cp}/resources/assets/js/browser.min.js"></script>
   <script src="${cp}/resources/assets/js/breakpoints.min.js"></script>
   <script src="${cp}/resources/assets/js/util.js"></script>
   <script src="${cp}/resources/assets/js/main.js"></script>

   </body>
<script>
	const searchForm = $("#searchForm");
	const pageForm = $("#pageForm");
	
	$(".changePage").on("click",function(e){
		// a 태그하면 기본적으로 페이지 이동이 일어나는데 그런 이벤트를 막아준다.
		// e(이벤트)의 기본 작동 막기
		e.preventDefault(); 
		
		let pagenum = $(this).attr("href");
		pageForm.find("input[name='pagenum']").val(pagenum);
		pageForm.submit();
	})

	$(".get").on("click",function(e){
		e.preventDefault();
		let boardnum = $(this).attr("href");

		// 페이지 폼의 마지막에 추가됨 
		pageForm.append("<input type='hidden' name='boardnum' value='"+boardnum+"'");
		pageForm.attr("action", "${cp}/board/get");
		pageForm.submit();
	})
	
	$("#searchForm a").on("click",sendit);
	
	function sendit(){
		/*
			if("") ---> if(false)
		*/
		if(!searchForm.find("option:selected").val()){ // 즉, 빈문자열일때. 0, undefind, "" 등..
			alert("검색 기준을 선택하세여!");
			return false;
		}
			
		if(!$("input[name='keyword']").val()){
			alert("키워드를 입력하세요!");
			return false;
		}
		searchForm.submit();
	}
</script>
</html>





