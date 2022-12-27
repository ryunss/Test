<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<style>
	body{
		background-color:#fff;
	}
	table{
		border:0px;
		width:900px;
	}
	#wrap{
		width:1000px;
		margin:0 auto;
	}
	.title h3{
		font-size:1.5em;
		color:rgb(0,200,80);
		text-shadow:0 0 4px deepskyblue;
	}
	a{
		display:inline-block;
		border-radius:3px;
		background-color:rgb(0,200,80);
		color:#fff;
		font-weight: bold;
		text-decoration: none;
	}
	.title h3 a{
		background-color: transparent;
		color:rgb(0,200,80);
		text-shadow:0 0 4px deepskyblue;
	}
	.header_area a{
		width:100px;
		padding:10px;
		text-align:center;
	}
	.header_area span{
		font-weight:bold;
	}
	.btn_area a{
		text-align:center;
		padding:10px;
		width:100px;
	}
	.board_area a{
		background: transparent;
		color:rgb(0,200,80);
		margin-left:20px;
	}
	.board_area input, .board_area textarea{
		border:none;
		outline:none;
	}
	tr.like a{
		position:absolute;
		left:3px;
		top:3px;
		background: transparent;
		color:#f00;
		background-image: url(https://ca-fe.pstatic.net/web-pc/static/img/ico-post-like-f-53535.svg?a37a11006a542ce9949c0dd6779345b8=);
		background-repeat: no-reapeat;
		width:17px;
		height:17px;
	}
	tr.like span{
		margin-left:18px;
	}
	.reply_line{
		width:900px;
		margin-top:20px;
		border-top:1px solid grey;
		padding-top:30px;
	}
	.write_box{
		padding-bottom: 40px;
	}
	.write_box>tbody>tr>td:first-child, .update_box>tbody>tr>td:first-child{
		width:150px;
		text-align: center;
		font-weight: bold;
		font-size: 18px;
	}
	.write_box>tbody>tr>td+td{
		position: relative;
	}
	.write_box textarea, .update_box textarea{
		padding:5px 10px;
		height:70px;
		resize:none;
		width:600px;
		outline:none;
		border:1px solid rgba(0,200,80,0.5);
		border-radius:10px;
	}
	.update_box textarea{
		width:500px;
		height:80px;
	}
	.write_box a{
		display:inline-block;
		text-align:center;
		padding:10px;
		width:90px;
		position: absolute;
		top:22px;
		right:0px;
	}
	.update_box{
		border-top:1px solid grey;
		padding-top:30px;
	}
	.update_box td:last-child {
		vertical-align: top;
	}
	.update_box .btns a{
		display:inline-block;
		width:70px;
		height:30px;
		text-align: center;
		vertical-align: middle;
		line-height: 30px;
		margin-top: 20px;
	}
</style>
</head>
<body>
	<c:if test="${loginUser == null }">
		<script>
			alert("로그인 후 이용하세요!");
			location.replace("${cp}/user/userlogin.us");
		</script>
	</c:if>
	<div id="wrap">
		<table class="header_area">
			<tr align="right" valign="middle">
				<td>
					<span>${loginUser}님 환영합니다.</span>&nbsp;&nbsp;
					<a href="${cp}/user/userlogout.us">로그아웃</a>
				</td>
			</tr>
		</table>
		<table class="title">
			<tr align="center" valign="middle">
				<td><h3>MVC 게시판</h3></td>
			</tr>
		</table>
		<form>
			<table border="1" style="border-collapse: collapse;">
				<tr height="30px">
					<th align="center" width="150px">제 목</th>
					<td>
						<input name="boardtitle" size="50" maxlength="50" readonly value="${board.boardtitle}">
					</td>
				</tr>
				<tr height="30px">
					<th align="center" width="150px">작성자</th>
					<td>
						<input name="userid" size="50" maxlength="50" readonly value="${board.userid}">
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>
						${board.readcount }
					</td>
				</tr>
				<tr height="300px">
					<th align="center" width="150px">내 용</th>
					<td>
						<textarea name="boardcontents" style="width:700px;height:290px;
						resize:none" readonly>${board.boardcontents }</textarea>
					</td>
				</tr>
				<c:choose>
					<c:when test="${files != null and files.size()>0 }">
						<c:forEach var="i" begin="0" end="${files.size()-1}">
							<c:set var="file" value="${files[i]}"/>
							<tr>
								<th>첨부파일${i+1}</th>
								<td>
									<a href="${cp}/board/filedownload.bo?key=${i}&boardnum=${board.boardnum}">
										${file.orgname}
									</a>
								</td>
							</tr>
							<!-- www.naver.com.png -->
							<!-- token : www / status.last : false -->
							<!-- token : naver / status.last : false -->
							<!-- token : com / status.last : false -->
							<!-- token : png / status.last : true -->
							<c:forTokens items="${file.orgname}" delims="." var="token" varStatus="status">
								<c:if test="${status.last}">
									<c:if test="${token eq 'jpg' or token eq 'jpeg' or token eq 'png' or token eq 'gif' or token eq 'webp' }">
										<tr>
											<td></td>
											<td>
												<img style="width:100px;" src="${cp}/file/${file.systemname}" alt="썸네일">
											</td>
										</tr>
									</c:if>
								</c:if>
							</c:forTokens>
						</c:forEach>		
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2" style="text-align: center;font-size: 20px;">첨부 파일이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			<table class="btn_area">
				<tr align="right" valign="middle">
					<td>
						<c:if test="${board.userid == loginUser }">
							<a href="${cp}/board/boardmodify.bo?boardnum=${board.boardnum}&page=${param.page}&q=${param.q}">수정</a>&nbsp;&nbsp;
							<a href="${cp }/board/boardremove.bo?boardnum=${board.boardnum}">삭제</a>&nbsp;&nbsp;
						</c:if>
						<a href="${cp }/board/boardlist.bo?page=${param.page}&q=${param.q}">목록</a>
					</td>
				</tr>
			</table>
		</form>
		
		<div class="reply_line">
			<form name="replyForm" method="post" action="">
				<input type="hidden" name="boardnum" value="">
				<input type="hidden" name="page" value="">
				<table class="write_box">
					<tr>
						<td>댓글</td>
						<td>
							<textarea name="replycontents"></textarea>
							<a href="">등록</a>
						</td>
					</tr>
				</table>
			</form>
			<form name="updateForm" method="post" action="">
				<input type="hidden" name="boardnum" value="">
				<input type="hidden" name="page" value="">
				<table class="update_box">
					<tr>
						<td>댓글작성자</td>
						<td>
							<textarea readonly name="" id="" class="replycontents">댓글내용</textarea>
						</td>
						<td valign="middle" style="text-align: center">
							댓글등록일
							<br>(수정됨)
							<br>
							<div class="btns">
								<a href="" id="">수정</a>
								<a href="" style="display:none;" id="">수정완료</a>
								<a href="">삭제</a>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>










