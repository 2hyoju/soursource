<%@page import="vo.Member"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	JSP에서 HttpServletRequest 객체를 사용할 때 request 변수를 사용하면 된다.
	request.getParameter("");	request.getAttribute("");
	
	HttpSession 객체를 사용할 때도 session 변수를 사용하면 된다.
	session.getAttribute(""),	session.setAttribute("", "");
	
	=> 이러한 request, session 변수들을 JSP 내장 객체라고 한다.
 -->
<h1>login_success.jsp</h1>
<%= ((Member) session.getAttribute("loginMember")).getName()%>님이 로그인 하셨습니다.
<!-- Member import 잊지말기! -->
<p>
	<a href="/sessionWeb/index.jsp">메인페이지</a>
	<a href="/sessionWeb/logout">로그아웃</a>
</body>
</html>