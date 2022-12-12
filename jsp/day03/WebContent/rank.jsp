<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{ width: 300px; height: 30px; text-align: center;}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td>실시간 검색 순위</td>
			<td>키워드</td>
		</tr>
		<tr>
			<td id="rank"></td>
			<td id="name"></td>
		</tr>
	</table>
</body>
<script>
	const xhr = new XMLHttpRequest();
	let obj = null;
	let datas = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				// 정상적인 응답 완료
				obj = JSON.parse(xhr.responseText); // 안에 json 형태로 넘겨준다면 객체로 만들어줌
				datas = obj.datas;
				// obj = {"datas" : [{"rank" : "1", "name" : "월드컵"},{"rank" : "2", "name" : "조규성"},{"rank" : "3", "name" : "한반두"},{"rank" : "4", "name" : "정다솔 생일"},{"rank" : "5", "name" : "레드밸벳"}]}
			}
		}
	}	
	xhr.open("GET", "datas.json", true);
	xhr.send();
	
	const rank = document.getElementById("rank");
	const name = document.getElementById("name");
	
	let i = 0;
	const interval = setInterval(
		function(){
			i = i%datas.length;
			rank.innerHTML = datas[i].rank;
			name.innerHTML = datas[i].name;
			i++;
		}	
	,2000);
	
</script>
</html>