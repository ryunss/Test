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
		resize:none;
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
	.replyForm input, .replyForm textarea{
		width:100%;
	}
	.page{
		text-align: center;
		clear:both;
	}
	.mdf{
		height:75px; width:100%; resize:none;
	}
</style>
</head>
<body class="is-preload">
	<c:if test="${not empty s }">
		<script>
			alert("${s}번 게시글 수정 완료!");
		</script>
	</c:if>
	<c:if test="${not empty f }">
		<script>
			alert("게시글 수정 실패!");
		</script>
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
				<p>&nbsp;</p>
				<a href="${cp}/board/list${cri.listLink}" class="button primary" style="float:right;
				border-radius:0px; border-bottom: 1px solid white;
				border-top: 1px solid white;">목록 보기</a>
				<br>
				<br>
				<br>
				<div class="write_area" style="clear:both;">
					<form name="boardForm" method="post" action="${cp }/board/remove">
						<input name="boardnum" type="hidden" value="${board.boardnum }">
						<input name="pagenum" type="hidden" value="${cri.pagenum }">
						<input name="amount" type="hidden" value="${cri.amount }">
						<input name="type" type="hidden" value="${cri.type }">
						<input name="keyword" type="hidden" value="${cri.keyword }">
						<div class="col-12">
							<h4>제목</h4>
							<input name="boardtitle" type="text" value="${board.boardtitle}" readonly>
						</div>
						<hr>
						<div class="col-12">
							<h4>내용</h4>
							<textarea name="boardcontents" rows="10" readonly>${board.boardcontents}</textarea>
						</div>
						<hr>
						<div>
							<h4>작성자</h4>
							<input name="userid" type="text" value="${board.userid}" readonly>
						</div>
						<c:if test="${loginUser.userid == board.userid }">
							<hr>
							<div style="text-align: right;">
								<input type="button" value="수정" class="button primary"
								onclick="modify()">
								<input type="submit" value="삭제" class="button primary">
							</div>
						</c:if>

					</form>
					<hr>
					<h3>댓 글</h3>
					<p style="text-align: right;">
					<a href="#" class="button primary small regist">댓글 등록</a>
					</p>
					<div class="replyForm row" style="display:none;">
						<div style="width:15%;">
							<h4>작성자</h4>
							<input name="userid" value="${loginUser.userid}" readonly style="text-align: center;">
						</div>
						<div style="width:65%;">
							<h4>내 용</h4>
							<textarea name="replycontents" placeholder="Contents" style="resize:none;"></textarea>
						</div>
						<div style="width:15%">
							<h4>&nbsp;</h4>
							<a href="#" class="button primary small finish" style="margin-bottom:1rem;">등록</a>
							<a href="#" class="button primary small cancel">취소</a>
						</div>
					</div>
					<br><br>
					<!-- 댓글 띄우는 ul -->
					<ul class="alt replies"></ul>
					<!-- 댓글 페이징 처리할 div -->
					<div class="page">
					</div>
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
	<script src="${cp}/resources/assets/js/reply.js"></script>

</body>
<script>
	function modify(){
		const boardForm = document.boardForm;
		// location.href = "${cp}/board/modify${cri.listLink}&boardnum=${board.boardnum}";
		boardForm.setAttribute("action", "${cp}/board/modify");
		boardForm.setAttribute("method", "get");
		boardForm.submit();
	}
	
	$(".regist").on("click",function(e){ // 댓글 등록 눌렀을 때
		e.preventDefault(); // a 태그 동작 막고
		$(".replyForm").show(); // display none 을 보여주는 키워드.
		$(this).hide(); // 작성칸이 보여졌기 때문에 등록버튼은 다시 감춰야대는데 다시 감춰줄때는 hide
	})
	$(".cancel").on("click", function(e){ // 댓글 등록 취소를 눌렀을 때
		e.preventDefault(); // a 태그 동작 막고
		$(".replyForm").hide(); // display 를 다시 숨긴다.
		$(".regist").show(); // 댓글 등록 버튼을 다시 보여준다.
		$("[name='replaycontents']").val(""); // 댓글 쓰다가 지웠을 때는 값이 남아있을 수 있기 때문에
											// 댓글 내용은 비워준다.
	})
	
	const replies = $(".replies");
	const loginUser = "${loginUser.userid}";
	let maxCnt = 0; // 댓글 개수
	let pagenum = 0; // 내가 보고 있는 댓글의  페이지 번호
	let boardnum = "${board.boardnum}";
	
	$(".finish").on("click",function(e){ // 댓글 작성 완료버튼 누르면
		e.preventDefault(); // a 태그 동작 막고
		let replycontents = $("[name='replycontents']").val(); // 등록하기 위해 작성한 내용
		
		replyService.add(
			{"boardnum":boardnum, "userid":loginUser, "replycontents":replycontents},
			function(result){
				// alert("");
				// 이 조건은 내가 지금 보고 있는 페이지가 마지막 페이지면서 댓글이 5개가 꽉 안찻다면
				if(maxCnt<5 || Math.ceil(maxCnt/5) == pagenum && maxCnt%5 != 0){ // 댓글도 5개씩 페이징하기 위함.
					let str = "";
				
					str += '<li style="clear:both;" class="li">';
					str += '<div style="display:inline; float:left; width:80%">';
					str += '<strong class="userid">'+loginUser+'</strong>';
					str += '<p class="reply">'+replycontents+'</p>';
					str += '</div><div style="text-align:right;">';
					str += '<strong>방금 전</strong><br>';
					str += '<a href="" class="modify">수정</a> &nbsp;'
					str += '<a href="" class="mfinish" style="display:none;">수정완료</a>'
					str += '<a href="" class="remove">삭제</a>'
					str += '</div></li>';
					
					replies.append(str);
					maxCnt++;
				}
			}
		);
		
		$("[name='replycontents']").val(""); // 등록했으니 글 비워주고, 폼은 숨겨주고, 등록은 보여주고 
		$(".replyForm").hide();
		$(".regist").show();
		
	});
</script>
</html>






