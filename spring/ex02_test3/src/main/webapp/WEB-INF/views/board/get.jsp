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
<script>
	const cp = "${cp}";
</script>
</head>
<body class="is-preload">
	<c:if test="${not empty s}">
		<script>
			alert("${s}번 게시글 수정 완료!")
		</script>
	</c:if>
	<c:if test="${not empty f}">
		<script>
			alert("게시글 수정 실패!")
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
					<form name="boardForm" method="post" action="${cp}/board/remove">
						<input name="boardnum" value="${board.boardnum}" type="hidden">
						<input name="pagenum" value="${cri.pagenum}" type="hidden">
						<input name="amount" value="${cri.amount}" type="hidden">
						<input name="type" value="${cri.type}" type="hidden">
						<input name="keyword" value="${cri.keyword}" type="hidden">
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
	const replies = $(".replies")
	const page = $(".page");
	const loginUser = "${loginUser.userid}"
	let maxCnt = 0;
	//내가 보고 있는 댓글의 페이지 번호
	let pagenum = 0;
	let boardnum = "${board.boardnum}"
	
	// 현재 보고 있는 게시글의 댓글이 있는지 없는지를 표기하는 flag
	let flag = true;
	
	$(document).ready(function(){
		pagenum = 1;
		showList(1);
	})
	
	$(".finish").on("click",function(e){
		e.preventDefault();
		let replycontents = $("[name='replycontents']").val();
		replyService.add(
			{"boardnum":boardnum, "userid":loginUser, "replycontents":replycontents},
			function(result){
				//alert("");
				if(maxCnt<5 || Math.ceil(maxCnt/5) == pagenum && maxCnt%5 != 0){
					let str = "";
					
					str += '<li style="clear:both;" class="li'+result+'">'
					str += '<div style="display:inline; float:left; width:80%;">';
					//<strong class="userid123">apple</strong>
					str += '<strong class="userid'+result+'">'+loginUser+'</strong>'
					str += '<p class="reply'+result+'">'+replycontents+'</p>'
					str += '</div><div style="text-align:right;">'
					str += '<strong>방금 전</strong><br>'
					str += '<a href="'+result+'" class="modify">수정</a>';
					str += '<a href="'+result+'" class="mfinish" style="display:none;">수정 완료</a>';
					str += '<a href="'+result+'" class="remove">&nbsp;&nbsp;삭제</a>';
					str += '</div></li>'
					
					if(flag){
						replies.append(str);
					}else{
						replies.html(str);
						flag = true;
					}
					
					$(".remove").on("click", deleteReply);
					
					maxCnt++;
				}
				else{
					showList(pagenum);
				}
			}
		)
	
		
		$("[name='replycontents']").val("");
		$(".replyForm").hide();
		$(".regist").show();
	})
	function showList(pagenum){
		//ajax
		replyService.getList(
			{boardnum:boardnum,pagenum:pagenum||1},
			function(replyCnt, list){
				let str = "";
				if(list == null || list.length == 0){
					flag = false;
					str += '<li style="clear:both;">등록된 댓글이 없습니다</li>';
					replies.html(str);
					return;
				}
				
				maxCnt = replyCnt;
				for(let i=0;i<list.length;i++){
					str += '<li style="clear:both;" class="li'+list[i].replynum+'">'
					str += '<div style="display:inline; float:left; width:80%;">';
					//<strong class="userid123">apple</strong>
					str += '<strong class="userid'+list[i].replynum+'">'+list[i].userid+'</strong>'
					str += '<p class="reply'+list[i].replynum+'">'+list[i].replycontents+'</p>'
					str += '</div><div style="text-align:right;">'
					str += '<strong>'+replyService.displayTime(list[i])+'</strong><br>'
					if(list[i].userid == loginUser){
						str += '<a href="'+list[i].replynum+'" class="modify">수정</a>';
						str += '<a href="'+list[i].replynum+'" class="mfinish" style="display:none;">수정 완료</a>';
						str += '<a href="'+list[i].replynum+'" class="remove">&nbsp;&nbsp;삭제</a>';
					}
					str += '</div></li>'
				}
				replies.html(str);
				
				$(".remove").on("click", deleteReply);
				
				showReplyPage(replyCnt);
			}
		)
	}
	function showReplyPage(replyCnt){
		let endPage = Math.ceil(pagenum/5)*5;
		let startPage = endPage - 4;
		
		let prev = startPage!=1;
		endPage = (endPage-1)*5 >= replyCnt ? Math.ceil(replyCnt/5) : endPage
		let next = endPage*5 < replyCnt ? true : false ;
		
		let str = "";
		if(prev){
			str += '<a class="changePage" href="'+(startPage-1)+'"><code>&lt;</code></a>'
		}
		for(let i=startPage;i<=endPage;i++){
			str+='<a class="changePage" href="'+i+'"><code>'+i+'</code></a>'
		}
		if(next){
			str+= '<a class="changePage" href="'+(endPage+1)+'"><code>&gt;</code></a>'
		}
		page.html(str);
		
		$(".changePage").on("click",function(e){
			e.preventDefault();
			let target = $(this).attr("href");
			pagenum = parseInt(target);
			showList(pagenum)
		})
	}

	function deleteReply(e){
		e.preventDefault();
		let replynum = $(this).attr("href");
		replyService.remove(
			replynum,
			function(result){
				if(result == "success"){
					alert(replynum+"번 댓글 삭제완료!");
					showList(pagenum);
				}
			},
			function(err){
				alert("에러발생");
			}
		);
	}
	
	function modify(){
		const boardForm = document.boardForm;
		//location.href = "${cp}/board/modify${cri.listLink}&boardnum=${board.boardnum}"
		boardForm.setAttribute("action","${cp}/board/modify")
		boardForm.setAttribute("method","get");
		boardForm.submit()
	}
	$(".regist").on("click",function(e){
		e.preventDefault();
		$(".replyForm").show();
		$(this).hide();
	})
	$(".cancel").on("click",function(e){
		e.preventDefault();
		$(".replyForm").hide();
		$(".regist").show();
		$("[name='replycontents']").val("")
	})
	
	
</script>
</html>






