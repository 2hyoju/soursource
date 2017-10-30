<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	li{
		-webkit-transition:width 2s, height 2s, color 1s, -webkit-transform 2s;
	}
	li:hover{
		color:red;
		-webkit-transform:scale(1.5,1.1);
	}
</style>
</head>
<body>
	<!-- 
		1. Session에서 numberList를 조회
		2. 반복문을 이용해 list내의 숫자들을 출력.
	 -->
	<h1>show_number.jsp</h1>
	<button onclick="window.location.href='/sessionWeb/stacknums/stack'">숫자생성</button>
	<button onclick="window.location.href='/sessionWeb/stacknums/removenums'">누적된 숫자 제거</button>
	<a href="/sessionWeb/index.jsp">메인페이지</a>
	<div style="width:100px; height:800px; border-radius:10px;">
		<%
		ArrayList<Integer> numberList = (ArrayList<Integer>) session.getAttribute("numberList");
		if(numberList==null || numberList.isEmpty()){
		%>
		누적된 숫자가 없습니다.
	<%	}else{ %>
	<ul>
	<%
			for (Integer num : numberList) {
	%>
		<li><%= num %></li>
	<%}//for end%>
	</ul>
	<%}//else end%>
	</div>
</body>
</html>