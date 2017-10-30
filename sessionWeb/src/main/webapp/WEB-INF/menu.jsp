<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 포함될 페이지 --%>
<h2>메뉴</h2>
<c:choose>
	<%-- 로그인을 하지 않았다면 --%>
	<c:when test="${sessionScope.loginMember == null }">
		<a href="/sessionWeb/login/login_form.jsp">로그인 폼</a>
	</c:when>
	<%-- 로그인 했다면 --%>
	<c:otherwise>
		<a href="/sessionWeb/stacknums/stack">숫자 누적 요청</a>
		<a href="/sessionWeb/logout">로그아웃</a>
	</c:otherwise>
</c:choose>
<!-- 로그인 여부와 상관없이 보는 메뉴. -->
<a href="/sessionWeb/cart/showItems">상품목록 보기</a>
<hr>