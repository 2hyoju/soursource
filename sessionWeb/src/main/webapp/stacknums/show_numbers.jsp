<%@ page import="java.util.ArrayList"%>
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
	1. Session에서 numberList를 조회
	2. 반복문을 이용해 list내의 숫자들을 출력
 -->
<h1>show_numbers.jsp</h1>
<c:choose>
	<c:when test="${empty sessionScope.numberList }">	
		누적된 숫자가 없습니다.
	</c:when>
	<c:otherwise>
		<c:forEach items="${sessionScope.numberList }" var="num">
			${num }
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>