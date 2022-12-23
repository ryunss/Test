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
   img.thumbnail{
      display:block;
      clear:both;
      width:100px;
   }
   #boardForm tr:nth-child(n+4) {
      height:50px;
   }
   #boardForm a{
      padding:5px 10px;
   }
   input[type="text"], textarea{
      border:none;
      padding:5px;
   }
</style>
</head>
<body>
   <c:if test="${loginUser == null }">
      <script>
         alert("로그인 후 이용하세요!");
         location.replace(cp+"/user/userlogin.us");
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
      </table>																				<!-- 파일 보낼때는 enctype을 적어줘야한다. -->
      <form id="boardForm" method="post" name="boardForm" action="${cp }/board/boardwriteok.bo" enctype="multipart/form-data">
         <table border="1" style="border-collapse: collapse;">
            <tr height="30px">
               <th align="center" width="150px">제 목</th>
               <td>
                  <input type="text" name="boardtitle" size="50" maxlength="50" placeholder="제목을 입력하세요">
               </td>
            </tr>
            <tr height="30px">
               <th align="center" width="150px">작성자</th>
               <td>
                  <input type="text" name="userid" size="50" maxlength="50" value="${loginUser}" readonly>
               </td>
            </tr>
            <tr height="300px">
               <th align="center" width="150px">내 용</th>
               <td>
                  <textarea name="boardcontents" style="width:700px;height:290px; resize:none"></textarea>
               </td>
            </tr>
            <tr>
               <th>파일 첨부1</th>
               <td class="file1_cont">
                  <div style="float:left;">
                     <input type="file" name="file1" id="file1" style="display:none;">
                     <span id="file1name">선택된 파일 없음</span>
                  </div>
                  <div style="float:right; margin-right:100px;">
                     <a href="javascript:upload('file1')">파일 선택</a>
                     <a href="javascript:cancelFile('file1')">첨부 삭제</a>
                  </div>
               </td>
            </tr>
            <tr>
               <th>파일 첨부2</th>
               <td class="file2_cont">
                  <div style="float:left;">
                     <input type="file" id="file2" name="file2" style="display:none;">
                     <span id="file2name">선택된 파일 없음</span>
                  </div>
                  <div style="float:right; margin-right:100px;">
                     <a href="javascript:upload('file2')">파일 선택</a>
                     <a href="javascript:cancelFile('file2')">첨부 삭제</a>
                  </div>
               </td>
            </tr>
         </table>
         <br>
      </form>
      <table class="btn_area">
         <tr align="right" valign="middle">
            <td>
               <a href="javascript:sendit()">등록</a>&nbsp;&nbsp;
               <a href="${cp }/board/boardlist.bo?page=${param.page}&q=${param.q}">목록</a>
            </td>
         </tr>
      </table>
   </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script>
	$("[type='file']").change(
		function(e){
			// e.target : 업로드를 한 input[type='file'] 객체 (태그객체)
			// e.traget.files : 파일태그에 업로드를 한 파일 객체들의 배열
			// e.target.files[0] : 업로드가 된 파일 객체
			let file = e.target.files[0];
			
			if(file == undefined){
				// "#"+e.target.id 지금 변화가 일어난 대상의 id
				// #file1name
				$("#"+e.target.id+"name").text("선택된 파일 없음");
				$("."+e.target.id+"_cont .thumbnail").remove();
			}else{
				$("#"+e.target.id+"name").text(file.name);
				
				// 썸네일 관련
				// 파일의 네임을 . 으로 스플릿하면 두개로 나눠짐 aaa.jpg 처럼 되니까
				// 마지막에 있는 것을 꺼내면 확장자명이 된다.
				let ext = file.name.split(".").pop(); 
				if(ext == 'jpeg' || ext == 'jpg' || ext == 'png' || ext == 'gif' || ext == 'webp'){
					const reader = new FileReader(); // 파일 객체 생성
					
					reader.onload = function(ie){ // 파일을 읽으면 reader.onload 함수가 실행 됨. (readAsDataURL 읽으면.)
						const img = document.createElement("img");
						img.setAttribute("src", ie.target.result); // ie.target.result 이 url을 가지고 있음.
						img.setAttribute("class", 'thumbnail');
						
						// 					(	.	file1	_cont	) 의 자식으로 img 태그를 추가
						document.querySelector("."+e.target.id+"_cont").appendChild(img);
					}
					
					reader.readAsDataURL(file); // 해당하는 파일을 url로 읽어서 옴
				}
			}
		}		
	)

	function upload(name){
		$("#"+name).click();
	}
	
	function cancelFile(name){
		// 브라우저가 인터넷익스플로러면 true로 나옴
		if($.browser.msie){
			// 덮어씌우기 하는건데 굳이 필요없을듯
			$("input[name='"+name+"']").replaceWith($("input[name='"+name+"']").clone(true));
		}else{
			$("input[name='"+name+"']").val("");
			$("#"+name+"name").text("선택된 파일 없음");
			$("."+name+"_cont .thumbnail").remove();
		}
	}
	
	function sendit(){
		const boardForm = document.boardForm;
		const boardtitle = boardForm.boardtitle;
		if(boardtitle.value == ""){
			alert("제목을 입력하세요");
			boardtitle.focus();
			return false;
		}
		
		boardForm.submit();
	}
</script>
</html>