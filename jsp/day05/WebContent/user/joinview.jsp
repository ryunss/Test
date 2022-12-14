<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="joinForm" action="join_db.jsp" method="GET">
		<fieldset>
			<legend>회원가입</legend>
			<span id="txt">&nbsp;</span>
			<p>
				<input name="userid" placeholder="아이디를 입력하세요">
				<input type="button" value="중복체크" onclick="checkId()">
			<p>
			<p>
				<input name="userpw" type="password" placeholder="비밀번호를 입력하세요">
			</p>
			<p>
				<input name="username" placeholder="이름을 입력하세요">
			</p>
			<p>
				<input type="submit" value="회원가입">
			</p>
		</fieldset>
	</form>
</body>
<script>
	const joinForm = document.joinForm;
	const userid = joinForm.userid;
	const userpw = joinForm.userpw;
	
	function checkId(){
		const xhr = new XMLHttpRequest();
		 //alert("xhr.onreadystatechange 밖 처음 :"+xhr.readyState);
		const txt = document.getElementById("txt");
		
		xhr.onreadystatechange = function(){ // 0 1 2 3 4 ?
			// XMLHttpRequest.DONE == 4
			  //alert("xhr.onreadystatechange 안 :"+xhr.readyState);
			  //alert("xhr.rsponseText :"+xhr.responseText);
			if(xhr.readyState == XMLHttpRequest.DONE){
				if(xhr.status == 200){
					let data = xhr.responseText;
					data = data.trim();
					if(data == "O"){
						txt.innerHTML = "사용할 수 있는 아이디입니다!";
					}else{
						txt.innerHTML = "중복된 아이디가 있습니다!";
					}
				}
			}
		}
	// 1. GET 방식
		xhr.open("GET","checkId_db.jsp?userid="+userid.value); // 전송방식, url, 비동기여부
		 //alert("xhr.readyState 밖1 :"+xhr.readyState);
		 //alert("xhr.responseText 밖1-1 :"+xhr.responseText);
		
		xhr.send();
		 //alert("xhr.readyState 밖2 :"+xhr.readyState);
		 //alert("xhr.responseText 밖2-1 :"+xhr.responseText);

	// 2. POST 방식
	/*
		xhr.open("POST", "checkId_db.jsp",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("userid="+userid.value);
	*/	
	}
</script>
</html>



