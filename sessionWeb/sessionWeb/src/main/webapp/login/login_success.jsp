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
	JSP에서
	+ HttpServletRequest 객체 사용 : request 변수 사용.
		(request.getParameter(""); request.getAttribute("");)
	+ HttpSession 객체 사용 : session 변수 사용.
		(session.getAttribute(""), session.setAttribute("");)
	=> request, session 변수 : JSP 내장 객체.
 -->
	<h1>login_success.jsp</h1>
	<%= ((Member)session.getAttribute("loginMember")).getName() %>님 환영합니다.
	<p>
		<a href="/sessionWeb/index.jsp">메인페이지</a>
		<a href="/sessionWeb/logout">로그아웃</a>
	</p>
</body>
</html>