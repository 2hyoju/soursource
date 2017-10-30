<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	1. Session에서 numberList를 조회
	2. 반복문을 이용해 list내의 숫자들을 출력
 -->
<h1>show_numbers.jsp</h1>
<p>
	<a href="/sessionWeb/stacknums/stack">숫자 누적 요청</a>
</p>
<%
	ArrayList<Integer> list = (ArrayList<Integer>) session.getAttribute("numberList");
	if(list.isEmpty()) {%>
		누적된 숫자가 없습니다.
	<%} else {
		for(Integer num : list) {%>
			<%= num %>
		<%}
	}%>
</body>
</html>