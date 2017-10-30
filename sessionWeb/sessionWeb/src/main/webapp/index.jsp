<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp - 메인페이지</h1>
<%
	//로그인을 하지 않았다면
	Object loginFlag = session.getAttribute("loginMember");
	if(loginFlag == null){//로그인 안한 사람만 보는 메뉴
%>
	<a href="/sessionWeb/login/login_form.jsp">로그인폼</a>
<% }else{ //로그인 한 사람만 보는 메뉴%>
	<a href="/sessionWeb/stacknums/stack">숫자누적 요청</a>
	<a href="/sessionWeb/logout">로그아웃</a>
<% } %>
<!-- 로그인 여부와 상관없이 보는 메뉴. -->
	<a href="/sessionWeb/cart/showItems">상품목록 보기</a>
</body>
</html>