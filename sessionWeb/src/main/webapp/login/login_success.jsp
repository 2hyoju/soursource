<%@ page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/menu.jsp" %>
<!-- 
	JSP에서 HttpServletRequest 객체를 사용할 때 request 변수를 사용하면 된다.
	request.getParameter("");	request.getAttribute("");
	
	HttpSession 객체를 사용할 때도 session 변수를 사용하면 된다.
	session.getAttribute(""),	session.setAttribute("", "");
	
	=> 이러한 request, session 변수들을 JSP 내장 객체라고 한다.
 -->
<h1>login_success.jsp</h1>
${sessionScope.loginMember.name }님이 로그인 하셨습니다.
<!-- Member import 잊지말기! -->
</body>
</html>