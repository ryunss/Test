<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.even{
		background-color : deeppink;
		color : white;
	}
	.odd{
		background-color : deepskyblue;
		color : blue;
	}
</style>
</head>
<body>
   <!-- 
      [1행 1열][1행 2열][1행 3열][1행 4열][1행 5열]
      [2행 1열][2행 2열][2행 3열][2행 4열]
      [3행 1열][3행 2열][3행 3열]
      [4행 1열][4행 2열]
      [5행 1열]
   -->
   <table>
   <% int cnt = 1; %>
   <%for(int i=0; i<5; i++) {%>

   		<tr class="<%=i%2 == 0? "even" : "odd" %>"> 
   		<%for(int j=i; j<5; j++) {%>
   			<td>
   				[<%=i+1%>행 <%=cnt++%>열]
   			</td>
   		<%} %>
   		</tr>
   		<%cnt = 1; %>
   <%} %>
   </table>
   <!-- 
      [1행 1열]
      [2행 1열][2행 2열]
      [3행 1열][3행 2열][3행 3열]
      [4행 1열][4행 2열][4행 3열][4행 4열]
      [5행 1열][5행 2열][5행 3열][5행 4열][5행 5열]
      [6행 1열][6행 2열][6행 3열][6행 4열]
      [7행 1열][7행 2열][7행 3열]
      [8행 1열][8행 2열]
      [9행 1열]
   -->
   <hr>
   <table>
   <% int cnt2 = 1; %>
   <% int cnt3 = 1; %>
   
   <% for(int i=0; i<9; i++) {%>
   
   		<%if(cnt2 <= 5) {%>
			<tr class="<%=i%2 == 0? "even" : "odd" %>"> 
			<% for(int j=0; j<=i; j++) {%>
				<td>
					[<%=i+1%>행 <%=j+1%>열]
				</td>
			<%} %>
			</tr>
		<%} %>
		
		<%if(cnt2 > 5) {%>
			<tr class="<%=i%2 == 0? "even" : "odd" %>"> 
			<% for(int j=i; j<9; j++) {%>
				<td>
					[<%=i+1%>행 <%=cnt3++%>열]
				</td>
			<%} %>
			</tr>
			<%cnt3 = 1; %>
		<%} %>
		
		<%cnt2++;%>
		
   <%} %>
   </table>
   
   <!--
	      위의 표의 짝수행은 배경색을 deeppink, 홀수행은 배경색을 deepskyblue
	      짝수열은 글자색을 white, 홀수열은 글자색을 blue
   -->
  
</body>
</html>